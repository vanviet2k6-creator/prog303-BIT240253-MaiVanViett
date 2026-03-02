import java.util.*;
import java.util.concurrent.*;

class SinhVien {
    private String mssv;
    private String ten;
    private double gpa;

    public SinhVien(String mssv, String ten, double gpa) {
        this.mssv = mssv;
        this.ten = ten;
        this.gpa = gpa;
    }

    public String getMssv() {
        return mssv;
    }

    public String getTen() {
        return ten;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "MSSV: " + mssv + ", Ten: " + ten + ", GPA: " + gpa;
    }
}

public class QuanLySinhVien {

    static ArrayList<SinhVien> danhSach = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem theo ten");
            System.out.println("4. Xoa theo MSSV");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    themSinhVien();
                    break;
                case 2:
                    hienThiDanhSach();
                    break;
                case 3:
                    timKiemSinhVien();
                    break;
                case 4:
                    xoaSinhVien();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    System.exit(0);
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    static void themSinhVien() {
        System.out.print("Nhap MSSV: ");
        String mssv = scanner.nextLine();

        System.out.print("Nhap ten: ");
        String ten = scanner.nextLine();

        System.out.print("Nhap GPA: ");
        double gpa = scanner.nextDouble();
        scanner.nextLine();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000); 

                if (gpa < 0 || gpa > 4) {
                    throw new RuntimeException("GPA khong hop le!");
                }

                danhSach.add(new SinhVien(mssv, ten, gpa));
                System.out.println(">> Them sinh vien thanh cong!");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(">> Loi: " + ex.getMessage());
            return null;
        });
    }

    static void hienThiDanhSach() {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000); 

                if (danhSach.isEmpty()) {
                    System.out.println("Danh sach trong!");
                    return;
                }

                danhSach.forEach(System.out::println);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static void timKiemSinhVien() {
        System.out.print("Nhap ten can tim: ");
        String tenCanTim = scanner.nextLine();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1500); 

                boolean found = false;

                for (SinhVien sv : danhSach) {
                    if (sv.getTen().equalsIgnoreCase(tenCanTim)) {
                        System.out.println("Tim thay: " + sv);
                        found = true;
                    }
                }

                if (!found) {
                    throw new RuntimeException("Khong tim thay sinh vien!");
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(">> Loi: " + ex.getMessage());
            return null;
        });
    }

    
    static void xoaSinhVien() {
        System.out.print("Nhap MSSV can xoa: ");
        String mssv = scanner.nextLine();

        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2500);

                boolean removed = danhSach.removeIf(sv -> sv.getMssv().equals(mssv));

                if (!removed) {
                    throw new RuntimeException("Khong tim thay MSSV de xoa!");
                }

                System.out.println(">> Xoa thanh cong!");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println(">> Loi: " + ex.getMessage());
            return null;
        });
    }
}
