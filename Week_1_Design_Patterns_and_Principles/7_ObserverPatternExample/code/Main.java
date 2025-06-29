public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Mob123");
        Observer webUser = new WebApp("WebUser007");

        market.registerObserver(mobileUser);
        market.registerObserver(webUser);

        market.setStock("TCS", 3478.50);
        market.setStock("Infosys", 1542.10);

        market.removeObserver(mobileUser);

        market.setStock("Reliance", 2820.00);
    }
}
