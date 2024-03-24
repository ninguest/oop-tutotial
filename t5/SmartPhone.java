public class SmartPhone {
    private Storage storage;
    private LCD lcd;

    public SmartPhone() {
        this.storage = new Storage();
        this.lcd = new LCD();
    }

    public void setStorageCapacity(int capacityGB) {
        storage.setCapacityGB(capacityGB);
    }

    public int getStorageCapacity() {
        return storage.getCapacityGB();
    }

    public void setScreenSize(double screenSize) {
        lcd.setScreenSize(screenSize);
    }

    public double getScreenSize() {
        return lcd.getScreenSize();
    }

    public void displayInformation() {
        System.out.println("SmartPhone Information:");
        System.out.println("Storage Capacity: " + getStorageCapacity() + "GB");
        System.out.println("Screen Size: " + getScreenSize() + " inches");
    }

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone();

        // Set storage capacity and screen size
        myPhone.setStorageCapacity(64);
        myPhone.setScreenSize(6.1);

        // Display information
        myPhone.displayInformation();
    }
}