package test.test6;

import java.util.Scanner;  // 클래스 import 확인 가능
public class CustomerRegistration {
    public static void main(String[] args) {
        // 지역변수로 Scanner 선언 (변수명: dataLoad)
        Scanner dataLoad = new Scanner(System.in);
        
        // 아이디 입력받기
        System.out.print("아이디를 입력하세요: ");
        String id = dataLoad.nextLine();
        
        // 입력한 아이디 출력
        System.out.println("입력한 아이디: " + id);
        
        dataLoad.close();
    }
}

