import java.util.TreeSet;

public class exone {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>();
        names.add("John");
        names.add("Alice");
        names.add("Zack");
        names.add("Bob");
        System.out.println("Danh sach ten da sap xep: " + names);

        String first = names.first();
        String last = names.last();
        System.out.println("Phan tu dau tien: " + first);
        System.out.println("Phan tu cuoi cung: " + last);
    }
}