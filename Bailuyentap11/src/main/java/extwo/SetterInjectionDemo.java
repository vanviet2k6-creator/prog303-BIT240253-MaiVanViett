package extwo;
public class SetterInjectionDemo {
    
    public static void main(String[] args) {
        System.out.println("===== DEMO SETTER INJECTION =====\n");
        
        Notification notification = new Notification();
        System.out.println();
        
        System.out.println("--- Demo 1: Gửi thông báo qua Email ---");
        EmailService emailService = new EmailService();
        notification.setMessageService(emailService);
        notification.sendNotification("Chào mừng bạn đến với khóa học Java!");
        
        System.out.println("--- Demo 2: Gửi thông báo qua SMS ---");
        SMSService smsService = new SMSService();
        notification.setMessageService(smsService);
        notification.sendNotification("Mã xác thực của bạn là: 123456");
        
        System.out.println("--- Demo 3: Thay đổi dịch vụ linh hoạt ---");
        System.out.println("Gửi nhiều thông báo qua các dịch vụ khác nhau:");
        
        notification.setMessageService(emailService);
        notification.sendNotification("Thông báo: Bảo trì hệ thống lúc 22h00");
        
        notification.setMessageService(smsService);
        notification.sendNotification("Mã OTP: 789012 - Hiệu lực 5 phút");
        
        System.out.println("--- Demo 4: Gửi khi chưa inject dependency ---");
        Notification notification2 = new Notification();
        notification2.sendNotification("Thông báo này sẽ không được gửi!");
    }
}