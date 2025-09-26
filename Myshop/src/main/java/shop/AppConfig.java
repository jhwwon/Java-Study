package shop;

public class AppConfig {
// 싱글톤 인스턴스 
	private static final AppConfig instance = new AppConfig();

// 공용변수 
	public static final String APP_TITLE = "MyShop 물류관리";
	public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	public static final String DB_USER = "jhw1"; 
	public static final String DB_PASSWORD = "1234"; 

	private AppConfig() {
	}

// 싱글톤 접근자 
	public static AppConfig getInstance() {
		return instance;
	}
}



