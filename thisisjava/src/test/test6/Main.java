package test.test6;

public class Main {
    
    // 문제 1-1: joinMember 메서드 정의 (예외처리 포함)
    public void joinMember(String 아이디, String 비밀번호, String 이름, String 주소) {
        // 4개의 데이터를 입력받는 메서드
        System.out.println("회원가입 정보:");
        
        try {
            // 예외가 발생할 수 있는 코드
            System.out.println("아이디: " + 아이디);
            System.out.println("비밀번호: " + 비밀번호); 
            System.out.println("이름: " + 이름);
            System.out.println("주소: " + 주소);
            
            // 아이디 길이 체크 (NullPointerException 발생 가능)
            int idLength = 아이디.length();
            System.out.println("아이디 길이: " + idLength);
            
        } catch (NullPointerException e) {
            // 예외 처리
            System.out.println("오류 발생: 아이디가 null입니다!");
            System.out.println("올바른 아이디를 입력해주세요.");
        } catch (Exception e) {
            // 기타 예외 처리
            System.out.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
        }
    }
    
    // 테스트용 main 메서드 (문제 1-2를 위한 예외 발생 코드)
    public static void main(String[] args) {
        String 아이디 = null; // null 값으로 테스트
        String 비밀번호 = "password123!";
        String 이름 = "홍길동";
        String 주소 = "서울시 강남구";
        
        Main program = new Main();
        program.joinMember(아이디, 비밀번호, 이름, 주소);
    }
}

