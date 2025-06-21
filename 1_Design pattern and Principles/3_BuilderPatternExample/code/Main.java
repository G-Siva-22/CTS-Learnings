public class Main {
    public static void main(String[] args) {
        // Basic Computer
        Computer basicComputer = new Computer.Builder("Intel i3", "4GB").build();
        System.out.println("Basic Computer Specs:");
        basicComputer.showSpecs();

        // Gaming Computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setWiFiCard("Intel AX200")
                .build();
        System.out.println("Gaming Computer Specs:");
        gamingComputer.showSpecs();

        // Office Computer
        Computer officeComputer = new Computer.Builder("Intel i5", "8GB")
                .setStorage("512GB SSD")
                .build();
        System.out.println("Office Computer Specs:");
        officeComputer.showSpecs();
    }
}
