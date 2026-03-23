package extwo;
public class Notification {
    private MessageService messageService;
    public Notification() {
        System.out.println("Đã tạo đối tượng Notification");
    }
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
        System.out.println("Đã inject MessageService: " + messageService.getClass().getSimpleName());
    }
    public void sendNotification(String message) {
        if (messageService == null) {
            System.out.println(" Lỗi: Chưa thiết lập MessageService!");
            return;
        }
        messageService.sendMessage(message);
    }
}