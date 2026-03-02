import java.util.concurrent.CompletableFuture;

public class BankingSystemSimple{

    public static void main(String[] args) {

        String customerId = "C001"; 
        double balance = 1000;
        double amount = 300;

        CompletableFuture<String> future =

                CompletableFuture.supplyAsync(() -> {
                    sleep(1000); 
                    System.out.println("Dang xac thuc khach hang...");

                    if (!customerId.equals("C001")) {
                        throw new RuntimeException("Xac thuc that bai");
                    }

                    return "Xac thuc thanh cong";
                })

                .thenApply(result -> {
                    sleep(1500); 
                    System.out.println("Dang kiem tra so du...");

                    if (balance < amount) {
                        throw new RuntimeException("Khong du tien!");
                    }

                    return balance - amount;
                })

                .thenApply(newBalance -> {
                    sleep(2000); 
                    System.out.println("Dang chuyen tien...");

                    return "Chuyen tien thanh cong, So du con lai: " + newBalance;
                })

                .exceptionally(error -> {
                    return "Giao dich bi huy: " + error.getMessage();
                });

        System.out.println(future.join());
    }

    static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
