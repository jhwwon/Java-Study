package test1;

public class MethodDefaultParameterExample {
	int a = 0;		// 전역 변수(필드)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMessage("Hello", 3);
		유관순();
		
		int a = 1; // 함수 지역 변수
		if(true) {
			//int a = 2; // compile time에서 error를 내서 실수를 미연에 방지
		}
	}
	
	private static void printMessage(String message, int count) {
		System.out.println(count);   // 3
		String 홍길동 = "홍길동1";
		
		System.out.println(홍길동);   // 홍길동1
	}
	
	private static void 유관순() {
		System.out.println("유관순입니다.");
	}
}
