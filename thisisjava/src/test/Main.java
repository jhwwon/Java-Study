package test;

import java.io.*;
import java.util.Scanner;

public class Main {
    
    // User 클래스를 Main 클래스 내부의 정적 클래스로 정의
    static class User implements Serializable {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                   "name='" + name + '\'' +
                   ", age=" + age +
                   '}';
        }
    }

    public static void main(String[] args) {
        // 1. 콘솔 입출력을 사용하여 사용자 정보 입력 받기
        System.out.println("사용자 정보를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("이름: ");
        String name = scanner.nextLine();
        
        System.out.print("나이: ");
        int age = scanner.nextInt();
        
        scanner.close();
        
        User user = new User(name, age);
        String fileName = "user_info.dat";

        // 2. 파일에 객체 저장 (파일 출력)
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(user);
            System.out.println(fileName + " 파일에 객체가 성공적으로 저장되었습니다.");
            
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

        // 3. 파일에서 객체 읽어오기 (파일 입력)
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            User readUser = (User) ois.readObject();
            System.out.println(fileName + " 파일에서 객체를 성공적으로 읽어왔습니다.");
            System.out.println("읽어온 정보: " + readUser);
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 읽기 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }
}