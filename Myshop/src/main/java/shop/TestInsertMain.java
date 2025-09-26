package shop;

public class TestInsertMain {
	public static void main(String[] args) {
		try {
			ProductService service = new ProductService();
			long id = service.addProduct("Exam-Item", 12345, 7);
			System.out.println("[OK] 삽입 완료, 생성된 ID = " + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

