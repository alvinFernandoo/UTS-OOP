public class Product {
    protected int id;
    protected String name;
    protected double price;
    protected int qty;

    public Product(int id, String name, double price, int qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
public void addQty(int q) {
    if (q <= 0) {
        System.out.println("Jumlah harus lebih dari 0!");
        return;
    }
    this.qty += q;
}

public void minQty(int q) {
    if (q <= 0) {
        System.out.println("Jumlah harus lebih dari 0!");
        return;
    }

    if (q > this.qty) {
        System.out.println("Stok tidak cukup!");
        return;
    }

    this.qty -= q;
}

    public void show() {
        System.out.println(id + ". " + name + " | Harga: " + price + " | Stok: " + qty);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public int getId() {
        return id;
    }
}