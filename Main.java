import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Product> daftarProduk = new ArrayList<>();
        daftarProduk.add(new OrganicProduct(1, "Apel Organik", 5000, 10, "Buah"));
        daftarProduk.add(new OrganicProduct(2, "Wortel Organik", 3000, 8, "Sayur"));
        daftarProduk.add(new DigitalProduct(3, "Ebook Java", 20000, 100, 5.5));

        while (true) {
            System.out.println("\n=== MENU KASIR ===");
            System.out.println("1. Lihat Produk");
            System.out.println("2. Tambah Stok");
            System.out.println("3. Kurangi Stok");
            System.out.println("4. Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = input.nextInt();

            if (pilih == 0) {
                System.out.println("Program selesai.");
                break;
            }

            switch (pilih) {

                // show
                case 1:
                    System.out.println("\n=== DAFTAR PRODUK ===");
                    for (Product p : daftarProduk) {
                        p.show();
                    }
                    break;

                // tambah
                case 2:
                    System.out.print("Masukkan ID produk: ");
                    int idAdd = input.nextInt();

                    Product pAdd = cariProduk(daftarProduk, idAdd);
                    if (pAdd != null) {
                        System.out.print("Jumlah tambah: ");
                        int qty = input.nextInt();

                        pAdd.addQty(qty); 
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                // kurang
                case 3:
                    System.out.print("Masukkan ID produk: ");
                    int idMin = input.nextInt();

                    Product pMin = cariProduk(daftarProduk, idMin);
                    if (pMin != null) {
                        System.out.print("Jumlah kurangi: ");
                        int qty = input.nextInt();

                        pMin.minQty(qty); // validasi di Product
                    } else {
                        System.out.println("Produk tidak ditemukan!");
                    }
                    break;

                // 
                case 4:
                    input.nextLine(); // buang newline
                    System.out.print("Masukkan nama customer: ");
                    String nama = input.nextLine();

                    Customer c = new Customer(1, nama);
                    Order order = new Order(1, c);

                    order.buatOrder(daftarProduk);
                    order.cetakStruk();
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }

        input.close();
    }

    // ================= HELPER METHOD =================
    public static Product cariProduk(ArrayList<Product> list, int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}