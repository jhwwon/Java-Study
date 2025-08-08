package test.test5;

import java.util.Scanner;

public class StringUtil {
    public static int returnLength(Scanner scanner) {
        System.out.print("문자열을 입력하세요: ");
        String input = scanner.nextLine();
        return input.length();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 공통 메서드 호출
        int length = returnLength(scanner);
        System.out.println("입력한 문자열의 길이: " + length);
        
        scanner.close();
    }
}