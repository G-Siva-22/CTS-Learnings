public class Main {
    public static void main(String[] args) {
        // Basic email notification
        Notifier emailNotifier = new EmailNotifier();

        // Add SMS notification on top of Email
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Add Slack notification on top of SMS + Email
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send the notification through all layers
        slackNotifier.send("System update at 5 PM today.");
    }
}
