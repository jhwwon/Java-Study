package test.test5;

public class ClientHandler {

    /**
     * 조건1. public 접근제어자
     * 조건2. void 반환형 (리턴값 없음)
     * 조건3. 메서드명은 insert
     * 조건4. 문자열을 매개변수로 받아서 처리
     */
    public void insert(String input) {
        // 클라이언트로부터 받은 문자열을 처리하는 로직
        System.out.println("클라이언트로부터 입력받은 값: " + input);
    }

    public static void main(String[] args) {
        // ClientHandler 객체 생성
        ClientHandler handler = new ClientHandler();

        // insert 메서드 호출 (가상의 클라이언트 입력값 전달)
        handler.insert("회원가입 요청 데이터");
    }
}
