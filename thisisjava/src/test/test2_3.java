package test;

public class test2_3 {
    public static void main(String[] args) {
        int nowPoint = 89;
        
        if (nowPoint >= 90 && nowPoint <= 100) {
            System.out.println("수");
        } else if (nowPoint >= 80) {
            System.out.println("우");
        } else if (nowPoint >= 70) {
            System.out.println("미");
        } else if (nowPoint >= 60) {
            System.out.println("양");
        } else if (nowPoint >= 50) {
            System.out.println("가");
        } else {
            System.out.println("재시험");
        }
    }
}


