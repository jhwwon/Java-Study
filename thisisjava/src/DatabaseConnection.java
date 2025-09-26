import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static Connection conn = null;
    
    public static boolean connectDB() {
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            
            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",  
                "jhw1",                                   
                "1234"                                    
            );
            
            System.out.println("데이터베이스 연결 성공!");
            return true;  // 연결 성공시 true 리턴
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
            return false;  // 연결 실패시 false 리턴
            
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 실패: " + e.getMessage());
            return false;  // 연결 실패시 false 리턴
        }
    }
    
    public static Connection getConnection() {
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("데이터베이스 연결 종료");
            } catch (SQLException e) {
                System.out.println("연결 종료 중 오류: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 데이터베이스 연결 테스트 ===");
        
        boolean isConnected = connectDB();
        
        if (isConnected) {
            System.out.println("연결 상태: 성공 (true)");
            
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connection 객체: " + connection.toString());
            }
            
            closeConnection();  // 연결 종료
            
        } else {
            System.out.println("연결 상태: 실패 (false)");
        }
    }
}
