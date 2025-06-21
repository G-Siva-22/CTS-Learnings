public class Main {
    public static void main(String[] args) {
        System.out.println("Using Stripe Adapter:");
        PaymentProcessor stripeProcessor = new StripeAdapter();
        stripeProcessor.processPayment(5000);

        System.out.println("\nUsing PayPal Adapter:");
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment(5000);

        System.out.println("\nUsing Razorpay Adapter:");
        PaymentProcessor razorpayProcessor = new RazorpayAdapter();
        razorpayProcessor.processPayment(5000);
    }
}
