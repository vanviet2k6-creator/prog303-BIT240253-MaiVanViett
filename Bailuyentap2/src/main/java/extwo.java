public class extwo {
    public static void main(String[] args) {

        Computer computerWithBluetooth = new Computer.ComputerBuilder()
                .setHdd("1TB")
                .setRam(16)
                .setBluetoothEnabled(true)
                .build();

        Computer computerWithoutBluetooth = new Computer.ComputerBuilder()
                .setHdd("500GB")
                .setRam(8)
                .setBluetoothEnabled(false)
                .build();

        System.out.println("May tinh 1: " + computerWithBluetooth);
        System.out.println("May tinh 2: " + computerWithoutBluetooth);
    }
}

class Computer {

    private final String hdd;
    private final int ram;
    private final boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.hdd = builder.hdd;
        this.ram = builder.ram;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    public static class ComputerBuilder {
        private String hdd;
        private int ram;
        private boolean isBluetoothEnabled;

        public ComputerBuilder setHdd(String hdd) {
            this.hdd = hdd;
            return this;
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean enabled) {
            this.isBluetoothEnabled = enabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + hdd + ", RAM=" + ram + "GB, Bluetooth=" + (isBluetoothEnabled ? "Co" : "Khong") + "]";
    }
}
