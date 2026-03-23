package extwo;
public class SMSService implements MessageService { 
    @Override
    public void sendMessage(String message) {
        System.out.println(" Đang gửi SMS...");
        System.out.println("   Nội dung: " + message);
        System.out.println("   Đã gửi SMS thành công!");
        System.out.println();
    }
}
