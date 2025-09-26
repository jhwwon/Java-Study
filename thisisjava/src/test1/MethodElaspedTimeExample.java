package test1;

public class MethodElaspedTimeExample {

	public static void main(String[] args) {
		// 코드 실행 되는 시간 계산
		long timeBeforeElasped = System.currentTimeMillis();
		
		hello();
		
		long timeAfterElasped = System.currentTimeMillis();
		
		System.out.println("hello()메소드 실행하는 데 걸린 시간: " 
							+ (timeAfterElasped - timeBeforeElasped) + "ms");
	}
	
	private static void hello() {
		for(int i = 0; i < 1000000000; i++) {
			//System.out.println("안녕하세요" + i);
		}
	}
}
