public class Main {
    public static void main(String[] args) {
        System.out.println("===== CÂU 1: QUAN LY SINH VIEN VOI GENERIC =====\n");
        
        StudentManager<Student> studentManager = new StudentManager<>();
        
        System.out.println("Dang them sinh vien vao danh sach...");
        
        Student sv1 = new Student("SV001", "Nguyen Van A", 3.5);
        Student sv2 = new Student("SV002", "Tran Thi B", 3.8);
        Student sv3 = new Student("SV003", "Le Van C", 3.2);
        Student sv4 = new Student("SV004", "Pham Thi D", 2.9);
        Student sv5 = new Student("SV005", "Hoang Van E", 3.6);
        
        studentManager.add(sv1);
        studentManager.add(sv2);
        studentManager.add(sv3);
        studentManager.add(sv4);
        studentManager.add(sv5);
        
        System.out.println("Da them " + studentManager.getAll().size() + " sinh vien");

        System.out.println("===== DANH SACH SINH VIEN =====");
       
        System.out.println("\n--- Duyet bang for-each ---");
        for (Student student : studentManager.getAll()) {
            System.out.println(student);
        }
  
        System.out.println("\n--- Duyet bang forEach voi Lambda ---");
        studentManager.getAll().forEach(student -> System.out.println(student));
        
        System.out.println("\n--- Duyet bang method reference ---");
        studentManager.getAll().forEach(System.out::println);

        System.out.println("\n===== THONG TIN CHI TIET SINH VIEN =====");
        for (int i = 0; i < studentManager.getAll().size(); i++) {
            Student sv = studentManager.getAll().get(i);
            System.out.println("Sinh viên thứ " + (i + 1) + ":");
            System.out.println("  Mã số: " + sv.getId());
            System.out.println("  Họ tên: " + sv.getName());
            System.out.println("  Điểm GPA: " + sv.getGpa());
            System.out.println("  Xếp loại: " + getRank(sv.getGpa()));
            System.out.println();
        }
    }
    
    // Phương thức phụ để xếp loại sinh viên dựa trên GPA
    public static String getRank(double gpa) {
        if (gpa >= 3.6) {
            return "Xuất sắc";
} else if (gpa >= 3.2) {
            return "Giỏi";
        } else if (gpa >= 2.5) {
            return "Khá";
        } else if (gpa >= 2.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}
