public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card strategy
        context.setPaymentStrategy(new CreditCardPayment("1234567812345678"));
        context.processPayment(2500.00);

        // Use PayPal strategy
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.processPayment(1500.00);
    }
}
