package test.test5;

public class Main {
    public static void main(String[] args) {
        // 변수 선언 - 서로 다른 새로운 String 객체 생성
        String m1 = new String("hello"); // m1에 새로운 String 객체 할당
        String m2 = new String("hello"); // m2에 새로운 String 객체 할당 (m1과는 다른 객체)
        
        // 같은 객체를 참조하는지 판단하는 코드
        // == 연산자로 참조값(메모리 주소) 비교 - 내용이 아닌 객체의 참조를 비교
        if (m1 == m2) {
            System.out.println("m1과 m2는 같은 객체를 참조합니다.");
        } else {
            // new로 각각 생성했으므로 서로 다른 객체를 참조함
            System.out.println("m1과 m2는 다른 객체를 참조합니다.");
        }
    }
}