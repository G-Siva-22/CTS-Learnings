public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");
        Image image2 = new ProxyImage("sunset.jpg");

        // First time: loads + displays
        image1.display();

        // Second time: just displays (cached)
        image1.display();

        // First time: loads + displays
        image2.display();
    }
}
