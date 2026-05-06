public class OrganicProduct extends Product {
    private String type;

    public OrganicProduct(int id, String name, double price, int qty, String type) {
        super(id, name, price, qty);
        this.type = type;
    }

    @Override
    public void show() {
        System.out.println("[ORGANIC] " + name + 
        " | Harga: " + price + 
        " | Stok: " + qty);
    }
}