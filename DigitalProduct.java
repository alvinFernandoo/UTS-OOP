public class DigitalProduct extends Product {
    private double fileSize;

    public DigitalProduct(int id, String name, double price, int qty, double fileSize) {
        super(id, name, price, qty);
        this.fileSize = fileSize;
    }

    @Override
    public void show() {
        System.out.println("[DIGITAL] " + name + 
        " | Harga: " + price + 
        " | Stok: " + qty + 
        " | Size: " + fileSize + "MB");
}
}
