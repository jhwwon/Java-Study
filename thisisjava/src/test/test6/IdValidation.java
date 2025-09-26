package test.test6;

public class IdValidation {
    
    // 사용자 정의 함수: 특수문자 포함 여부 검사
    public static boolean checkSpecialChar(String id, String sign) {
        boolean hasSpecialChar = false;
        
        // 이중 반복문 사용 (배열로 변환해서 length 속성 사용)
        char[] idArray = id.toCharArray();  // 내장함수: toCharArray()
        char[] signArray = sign.toCharArray();
        
        for(int i = 0; i < idArray.length; i++) {
            for(int j = 0; j < signArray.length; j++) {
                if(idArray[i] == signArray[j]) {  // 조건문 사용
                    hasSpecialChar = true;
                    break;
                }
            }
            if(hasSpecialChar) break;  // 조건문 사용
        }
        
        return hasSpecialChar;
    }
    
    public static void main(String[] args) {
        String id = "test01";
        String sign = "!@#$%^&*";
        
        // 사용자 정의 함수 호출
        boolean result = checkSpecialChar(id, sign);
        
        // 결과 출력
        if(result) {  // 조건문 사용
            System.out.println("사용가능");
        } else {
            System.out.println("사용불가능");
        }
    }
}


