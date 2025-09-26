package test;

public class test2 {
    public static void main(String[] args) {
        int[] point = {90, 100, 79, 85, 80, 70, 75};
        
        // 1단계: 첫 번째 점수를 최고점으로 정하기
        int max = point[0];
        System.out.println("시작 최고점: " + max);
        
        // 2단계: 나머지 점수들과 비교하기
        for (int i = 1; i < point.length; i++) {
            System.out.print(point[i] + "점과 비교 : ");
            
            if (point[i] > max) {
                max = point[i];
                System.out.println("새로운 최고점");
            } else {
                System.out.println("그대로");
            }
        }
        
        // 3단계: 결과 출력
        System.out.println("최고점: " + max + "점");
    }
}

