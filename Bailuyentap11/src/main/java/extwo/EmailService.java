package extwo;
public class EmailService implements MessageService {
    
    @Override
    public void sendMessage(String message) {
        System.out.println(" Đang gửi EMAIL...");
        System.out.println("   Nội dung: " + message);
        System.out.println("   Đã gửi email thành công!");
        System.out.println();
    }
}
