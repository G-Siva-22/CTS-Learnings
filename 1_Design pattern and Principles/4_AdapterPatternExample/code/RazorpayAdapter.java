public class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpayGateway;

    public RazorpayAdapter() {
        razorpayGateway = new RazorpayGateway();
    }

    public void processPayment(double amount) {
        razorpayGateway.pay(amount);
    }
}
