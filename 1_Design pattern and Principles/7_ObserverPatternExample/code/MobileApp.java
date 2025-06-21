public class MobileApp implements Observer {
    private String appId;

    public MobileApp(String appId) {
        this.appId = appId;
    }

    public void update(String stockName, double price) {
        System.out.println("MobileApp [" + appId + "] - " + stockName + " price updated to ₹" + price);
    }
}
