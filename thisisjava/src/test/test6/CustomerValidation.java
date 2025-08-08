package test.test6;

import java.util.Scanner;

public class CustomerValidation {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 사용자 입력
        System.out.println("=== 홈쇼핑 회원가입 ===");
        System.out.print("아이디: ");
        String id = scanner.nextLine();
        
        System.out.print("패스워드: ");
        String password = scanner.nextLine();
        
        System.out.print("이름: ");
        String name = scanner.nextLine();
        
        System.out.print("주소: ");
        String address = scanner.nextLine();
        
        System.out.print("나이: ");
        int age = scanner.nextInt();
        
        // 유효성 검사
        System.out.println("\n=== 유효성 검사 결과 ===");
        
        // 아이디 검사
        if (validateId(id)) {
            System.out.println("아이디: 통과");
        } else {
            System.out.println("아이디: 실패 (특수문자 !@#$%^&* 1개 이상 필요)");
        }
        
        // 패스워드 검사
        if (validatePassword(password)) {
            System.out.println("패스워드: 통과");
        } else {
            System.out.println("패스워드: 실패 (8글자 이상, 특수문자 !@#$%^&* 필요)");
        }
        
        // 이름 검사
        if (!name.isEmpty()) {
            System.out.println("이름: 통과");
        } else {
            System.out.println("이름: 실패 (이름이 비어있습니다)");
        }
        
        // 주소 검사
        if (!address.isEmpty()) {
            System.out.println("주소: 통과");
        } else {
            System.out.println("주소: 실패 (주소가 비어있습니다)");
        }
        
        // 나이 검사
        if (age > 0) {
            System.out.println("나이: 통과");
        } else {
            System.out.println("나이: 실패 (올바른 나이를 입력하세요)");
        }
        
        scanner.close();
    }
    
    // 아이디 유효성 검사: 특수문자 1개 이상 포함
    public static boolean validateId(String id) {
        String specialChars = "!@#$%^&*";
        for (char c : id.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
    
    // 패스워드 유효성 검사: 8글자 이상 + 특수문자 포함
    public static boolean validatePassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        
        String specialChars = "!@#$%^&*";
        for (char c : password.toCharArray()) {
            if (specialChars.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}