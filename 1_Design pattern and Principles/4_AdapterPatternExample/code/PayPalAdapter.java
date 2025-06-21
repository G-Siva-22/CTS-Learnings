public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter() {
        payPalGateway = new PayPalGateway();
    }

    public void processPayment(double amount) {
        double dollarAmount = amount / 80; // Example conversion rate ₹ to $
        payPalGateway.sendPayment(dollarAmount);
    }
}
