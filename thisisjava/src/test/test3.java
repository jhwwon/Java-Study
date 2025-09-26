package test;

public class test3 {
    public static void main(String[] args) {
        int[] scores = {70, 90, 100, 80}; // 배열에 점수 저장
        int sum = 0;  // 총합 변수
        
        System.out.print("저장된 점수: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        System.out.println();
        
        System.out.println("마지막 점수부터 역순으로 합계 계산");
        
        // 마지막 점수부터 차례대로 역으로 더하여 저장 (반복문)
        for (int i = scores.length - 1; i >= 0; i--) {
            sum += scores[i];
            System.out.println(scores[i] + "점 추가한 현재 총합: " + sum);
        }
        
        System.out.println();
        System.out.println("최종 총합: " + sum + "점");
    }
}

