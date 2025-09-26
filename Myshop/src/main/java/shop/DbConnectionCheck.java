package shop;

import java.sql.Connection;

public class DbConnectionCheck {
	public static void main(String[] args) {
		try (Connection c = DBUtil.getConnection()) {
			System.out.println("[OK] DB 연결 성공: " + c.getMetaData().getURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}