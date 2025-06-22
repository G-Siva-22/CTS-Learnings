public class WebApp implements Observer {
    private String userName;

    public WebApp(String userName) {
        this.userName = userName;
    }

    public void update(String stockName, double price) {
        System.out.println("WebApp [" + userName + "] - " + stockName + " price updated to ₹" + price);
    }
}
