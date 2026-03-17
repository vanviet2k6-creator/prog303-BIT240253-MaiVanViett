package bai1;

import java.util.HashMap;

public class exone {
    public static void main(String[] args) {
        HashMap<Integer, String> employeeMap = new HashMap<>();
        employeeMap.put(101, "Anna");
        employeeMap.put(102, "Peter");
        employeeMap.put(103, "Mary");
        String name102 = employeeMap.get(102);
        System.out.println("Nhân viên có ID 102: " + name102);
        int checkId = 105;
        if (employeeMap.containsKey(checkId)) {
            System.out.println("ID " + checkId + " tồn tại: " + employeeMap.get(checkId));
        } else {
            System.out.println("ID " + checkId + " không tồn tại. Thêm mới...");
            employeeMap.put(checkId, "Unknown");
        }
        System.out.println("\nDanh sách nhân viên:");
        for (Integer id : employeeMap.keySet()) {
            System.out.println("ID: " + id + ", Tên: " + employeeMap.get(id));
        }
    }
}