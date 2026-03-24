package btap1;

public class LambdaDemo {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation divide = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Không thể chia cho 0");
            }
            return a / b;
        };

        int a = 20;
        int b = 5;

        System.out.println("=== BÀI 1: FUNCTIONAL INTERFACE + LAMBDA ===");
        System.out.println(a + " + " + b + " = " + add.compute(a, b));
        System.out.println(a + " - " + b + " = " + subtract.compute(a, b));
        System.out.println(a + " * " + b + " = " + multiply.compute(a, b));
        System.out.println(a + " / " + b + " = " + divide.compute(a, b));
    }
}
