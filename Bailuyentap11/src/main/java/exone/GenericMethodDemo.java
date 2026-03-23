package exone;
public class GenericMethodDemo {

    public static <E> void printArray(E[] array) {
        System.out.println("Các phần tử trong mảng:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Phần tử thứ " + (i + 1) + ": " + array[i]);
        }
        System.out.println("------------------------");
    }
    
    public static void main(String[] args) {
        Integer[] integerArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("=== In mảng Integer ===");
        printArray(integerArray);
        String[] stringArray = {"Java", "Generic", "Method", "NetBeans", "Programming"};
        System.out.println("=== In mảng String ===");
        printArray(stringArray);

        Double[] doubleArray = {1.5, 2.8, 3.14, 4.99, 5.12};
        System.out.println("=== In mảng Double ===");
        printArray(doubleArray);

        Character[] charArray = {'A', 'B', 'C', 'D', 'E'};
        System.out.println("=== In mảng Character ===");
        printArray(charArray);
    }
}
