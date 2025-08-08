package test;

public class Car {

    // 1. 필드 (Field) : 객체의 상태(속성)를 나타내는 변수입니다.
    protected String brand;
    protected String color;
    protected int speed;

    // 2. 생성자 (Constructor) : 객체가 생성될 때 가장 먼저 호출되는 구문입니다.
    // 객체의 초기 상태를 설정하는 역할을 하며, 클래스 이름과 동일해야 하고, 반환 타입이 없습니다.
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0; // 모든 Car 객체는 초기 속도가 0으로 설정됩니다.
    }

    // 3. 메소드 (Method) : 객체가 수행할 수 있는 기능이나 행동을 정의합니다.
    public void printInfo() {
        System.out.printf("차량: %s %s, 현재 속도: %d km/h\n", color, brand, speed);
    }

    // 3-1. 메소드 오버로딩 (Method Overloading) : 같은 클래스 안에서 같은 이름의 메소드를 여러 개 정의하는 문법입니다.
    // 조건: 매개변수의 개수, 타입 또는 순서가 달라야 합니다.
    public void accelerate(int increment) {
        this.speed += increment;
        System.out.printf("%d만큼 가속! -> ", increment);
        printInfo();
    }

    // 메소드 오버로딩의 또 다른 예시입니다. 매개변수가 없는 경우, accelerate(10)을 호출하여 코드 중복을 줄입니다.
    public void accelerate() {
        accelerate(10);
    }

    // main 메소드는 자바 프로그램의 시작점입니다. 
    public static void main(String[] args) {
        // Car 클래스 예제
        System.out.println("--- Car 클래스 예제 ---");
        Car myCar = new Car("Hyundai", "Blue");
        myCar.printInfo();

        myCar.accelerate(50);
        myCar.accelerate();

        System.out.println("\n--- ElectricCar 클래스 예제 ---");
        // 다른 파일에 정의된 ElectricCar 클래스를 사용합니다.
        ElectricCar myElectricCar = new ElectricCar("Tesla", "White", 95);
        myElectricCar.accelerate(30);
        myElectricCar.printInfo();
    }
}
