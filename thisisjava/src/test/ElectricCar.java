package test;

public class ElectricCar extends Car {
    // ElectricCar만의 고유한 속성(필드)을 추가합니다.
    private int batteryLevel;
    // 생성자: 부모 클래스의 생성자를 호출합니다.
    // super(brand, color)는 부모 클래스인 Car의 생성자를 호출하는 코드입니다.
    // 자식 클래스 생성자에서 부모 클래스 생성자를 호출하는 것은 필수입니다.
    public ElectricCar(String brand, String color, int batteryLevel) {
        super(brand, color);
        this.batteryLevel = batteryLevel;
    }
    // 3-2. 메소드 오버라이딩 (Method Overriding) : 상속 관계에 있는 자식 클래스에서 부모 클래스의 메소드를 재정의하는 문법입니다.
    // @Override 어노테이션은 이 메소드가 부모 메소드를 재정의한다는 것을 명시합니다.
    @Override
    public void printInfo() {
        // 부모 클래스의 기능을 확장하여 배터리 잔량 정보도 함께 출력합니다.
        System.out.printf("전기차: %s %s, 현재 속도: %d km/h, 배터리 잔량: %d%%\n", color, brand, speed, batteryLevel);
    }
}