package test;

public class ArrayIndexRange {
    public static void main(String[] args) {
        int[] point = {90, 100, 79, 85, 80, 70, 75};
        int minValue = 100;
        
        int startIndex = 0;
        int lastIndex = point.length - 1;
        
        System.out.println("시작인덱스: " + startIndex);
        System.out.println("마지막인덱스: " + lastIndex);
        System.out.println("인덱스 범위: " + startIndex + " ~ " + lastIndex);
    }
}

