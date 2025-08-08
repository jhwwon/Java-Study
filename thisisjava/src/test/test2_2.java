package test;

public class test2_2 {
    public static void main(String[] args) {
        int[] point = {90, 100, 79, 85, 80, 70, 75};
        int nowPoint = 80;
        int count = 0;
        
        System.out.println("nowPoint: " + nowPoint + "점");
        System.out.println();
        
        // 각 점수와 비교
        for (int i = 0; i < point.length; i++) {
            if (point[i] > nowPoint) {
                count++;
                System.out.println(point[i] + "점 : 높음 (개수: " + count + ")");
            } else {
                System.out.println(point[i] + "점 : 낮음");
            }
        }
        
        System.out.println();
        System.out.println("카운트 결과: " + count + "개");
    }
}

