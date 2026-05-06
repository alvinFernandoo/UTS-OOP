import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private int id;
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Integer> qtyList = new ArrayList<>();

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public void buatOrder(ArrayList<Product> daftarProduk) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("\nPilih ID produk (0 untuk selesai): ");
            int id = input.nextInt();

            if (id == 0) break;

            Product selected = null;
            for (Product p : daftarProduk) {
                if (p.getId() == id) {
                    selected = p;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Produk tidak ditemukan!");
                continue;
            }

            System.out.print("Jumlah beli: ");
            int qty = input.nextInt();

            tambahItem(selected, qty);
        }
    }

    public void tambahItem(Product p, int qty) {
        if (qty <= p.getQty()) {
            products.add(p);
            qtyList.add(qty);
            p.minQty(qty);
        } else {
            System.out.println("Stok tidak cukup!");
        }
    }

    // === DISKON ===
    public double hitungDiskon() {
        double subtotal = 0;

        for (int i = 0; i < products.size(); i++) {
            subtotal += products.get(i).getPrice() * qtyList.get(i);
        }

        if (subtotal > 50000) {
            return subtotal * 0.10;
        }
        return 0;
    }

    // === PAJAK ===
    public double hitungPajak() {
        double subtotal = 0;

        for (int i = 0; i < products.size(); i++) {
            subtotal += products.get(i).getPrice() * qtyList.get(i);
        }

        subtotal -= hitungDiskon();
        return subtotal * 0.10;
    }

    // === TOTAL ===
    public double hitungTotal() {
        double subtotal = 0;

        for (int i = 0; i < products.size(); i++) {
            subtotal += products.get(i).getPrice() * qtyList.get(i);
        }

        double diskon = (subtotal > 50000) ? subtotal * 0.10 : 0;
        double pajak = (subtotal - diskon) * 0.10;

        return subtotal - diskon + pajak;
    }

    public void cetakStruk() {
        System.out.println("\n===== STRUK BELANJA =====");
        System.out.println("Customer: " + customer.getName());

        double subtotal = 0;

        for (int i = 0; i < products.size(); i++) {
            double totalItem = products.get(i).getPrice() * qtyList.get(i);
            subtotal += totalItem;

            System.out.println(products.get(i).getName() +
                " x " + qtyList.get(i) +
                " = " + totalItem);
        }

        double diskon = (subtotal > 50000) ? subtotal * 0.10 : 0;
        double pajak = (subtotal - diskon) * 0.10;
        double total = subtotal - diskon + pajak;

        System.out.println("--------------------------");
        System.out.println("Subtotal : " + subtotal);
        System.out.println("Diskon   : " + diskon);
        System.out.println("Pajak    : " + pajak);
        System.out.println("TOTAL    : " + total);
        System.out.println("==========================");
    }
}