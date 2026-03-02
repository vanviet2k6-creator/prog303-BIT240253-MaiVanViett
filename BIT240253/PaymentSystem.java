
interface Payment {
    void processPayment(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toan bang Credit Card: " + amount);
    }
}
class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toan bang PayPal: " + amount);
    }
}

class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Thanh toan bang tien mat: " + amount);
    }
}

class PaymentFactory {

    public static Payment createPayment(String type) {

        if (type.equalsIgnoreCase("creditcard")) {
            return new CreditCardPayment();
        } else if (type.equalsIgnoreCase("paypal")) {
            return new PayPalPayment();
        } else if (type.equalsIgnoreCase("cash")) {
            return new CashPayment();
        } else {
            throw new IllegalArgumentException("Phuong thuc thanh toan khong hop le!");
        }
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        double amount = 150.75;

        Payment payment1 = PaymentFactory.createPayment("creditcard");
        payment1.processPayment(amount);

        Payment payment2 = PaymentFactory.createPayment("paypal");
        payment2.processPayment(amount);

        Payment payment3 = PaymentFactory.createPayment("cash");
        payment3.processPayment(amount);
    }
}
