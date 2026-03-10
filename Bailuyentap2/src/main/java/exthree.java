
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class exthree {
    
    public static String authenticateCustomer(String customerName) {
        try {
            System.out.println("Bat dau xac thuc khach hang: " + customerName);
            TimeUnit.SECONDS.sleep(2); 
            System.out.println("✓ Xac thuc thanh cong cho: " + customerName);
            return "Da xac thuc: " + customerName;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
  
    public static String generateTicket(String movieName, String customerInfo) {
        try {
            System.out.println("Bat dau xuat ve cho phim: " + movieName);
            TimeUnit.SECONDS.sleep(3);
            String ticket = "VE XEM PHIM\nPhim: " + movieName + "\n" + customerInfo;
            System.out.println("✓ Da xuat ve thanh cong");
            return ticket;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
        String customerName = "Mai Van Viet";
        String movieName = "Avengers: Endgame";
        
        System.out.println("=== HE THONG DAT VE XEM PHIM ===");
        long startTime = System.currentTimeMillis();
        
        CompletableFuture<String> authFuture = CompletableFuture.supplyAsync(() -> {
            return authenticateCustomer(customerName);
        });
        
        CompletableFuture<String> ticketFuture = CompletableFuture.supplyAsync(() -> {
            return generateTicket(movieName, "Khach hang: " + customerName);
        });
        
        CompletableFuture<String> combinedFuture = authFuture.thenCombine(ticketFuture, 
            (authResult, ticketResult) -> {
                return "KET QUA HOAN THANH:\n" + authResult + "\n" + ticketResult;
            });
        
        combinedFuture.thenAccept(result -> {
            long endTime = System.currentTimeMillis();
            System.out.println("\n" + result);
            System.out.println("Thoi gian xu ly: " + (endTime - startTime) + "ms");
        });
        combinedFuture.join();
        
        System.out.println("\n=== KET THUC XU LY ===");
    }
}