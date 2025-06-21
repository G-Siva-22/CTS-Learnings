public class Computer {
    // Required attributes
    private final String cpu;
    private final String ram;

    // Optional attributes
    private final String storage;
    private final String graphicsCard;
    private final String wifiCard;

    // Private constructor accepting Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.wifiCard = builder.wifiCard;
    }

    // Display method
    public void showSpecs() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + (storage != null ? storage : "Not included"));
        System.out.println("Graphics Card: " + (graphicsCard != null ? graphicsCard : "Not included"));
        System.out.println("WiFi Card: " + (wifiCard != null ? wifiCard : "Not included"));
        System.out.println("-------------");
    }

    // ✅ Builder class
    public static class Builder {
        private final String cpu;
        private final String ram;

        private String storage;
        private String graphicsCard;
        private String wifiCard;

        // Constructor for required parameters
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        // Setter methods for optional parameters
        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWiFiCard(String wifiCard) {
            this.wifiCard = wifiCard;
            return this;
        }

        // Final build() method
        public Computer build() {
            return new Computer(this);
        }
    }
}
