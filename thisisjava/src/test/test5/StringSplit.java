package test.test5;

public class StringSplit {
    public static void main(String[] args) {
        String id = "human01";
        
        for (int i = 0; i < id.length(); i++) {
            System.out.println((i + 1) + "번째 문자: " + id.charAt(i));
        }
    }
}
