import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class DriverLoader {
    
    public static void main(String[] args) {
        
        Connection conn = null; // 연결 객체는 finally에서 닫아야 하므로 try 밖에서 선언
        
        // 조건1. 드라이버 로드 코드 확인
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공!");
            
            // 실제 연결 시도 (옵션, 성공을 증명하기 위해 추가)
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "jhw1", "1234");
            System.out.println("데이터베이스 연결 성공!");
            
        // 조건2. 예외처리 구문 확인
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
            
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결에 실패했습니다.");
            e.printStackTrace();
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

