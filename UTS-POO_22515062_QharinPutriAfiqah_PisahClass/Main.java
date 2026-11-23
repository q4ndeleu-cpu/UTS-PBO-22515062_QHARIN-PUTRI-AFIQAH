import java.util.Scanner;

// CLASS MAIN
public class Main {
    static Scanner input = new Scanner(System.in);
    static TokoKelontong toko = new TokoKelontong("Toko Kelontong Qharin");
    static StackADT<Transaksi> riwayat = new StackADT<>(10);
    static int nomorTransaksi = 1;

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n===== TOKO KELONTONG =====");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Tambah Pelanggan");
            System.out.println("4. Tampilkan Pelanggan");
            System.out.println("5. Buat Transaksi");
            System.out.println("6. Cari Produk");
            System.out.println("7. Tampilkan Riwayat Stack");
            System.out.println("8. Hapus Riwayat Transaksi Terakhir");
            System.out.println("9. Laporan Toko");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = bacaInt();

            switch (pilihan) {
                case 1: tambahProduk(); break;
                case 2: toko.tampilkanProduk(); break;
                case 3: tambahPelanggan(); break;
                case 4: toko.tampilkanPelanggan(); break;
                case 5: buatTransaksi(); break;
                case 6: cariProduk(); break;
                case 7: riwayat.tampilkan(); break;
                case 8: batalkanTransaksi(); break;
                case 9: toko.tampilkanLaporan(); break;
                case 0: System.out.println("Program selesai."); break;
                default: System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 0);
    }

    static int bacaInt() {
        while (true) {
            try { return Integer.parseInt(input.nextLine()); }
            catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang benar: ");
            }
        }
    }

    static double bacaDouble() {
        while (true) {
            try { return Double.parseDouble(input.nextLine()); }
            catch (NumberFormatException e) {
                System.out.print("Masukkan angka yang benar: ");
            }
        }
    }

    static void tambahProduk() {
        try {
            System.out.print("Kode produk: ");
            String kode = input.nextLine();
            System.out.print("Nama produk: ");
            String nama = input.nextLine();
            System.out.print("Harga: ");
            double harga = bacaDouble();
            System.out.print("Stok: ");
            int stok = bacaInt();
            toko.tambahProduk(new Produk(kode, nama, harga, stok));
        } catch (IllegalArgumentException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }

    static void tambahPelanggan() {
        System.out.print("ID pelanggan: ");
        String id = input.nextLine();
        System.out.print("Nama pelanggan: ");
        String nama = input.nextLine();
        System.out.print("Nomor telepon: ");
        String telepon = input.nextLine();
        System.out.print("Alamat: ");
        String alamat = input.nextLine();
        toko.tambahPelanggan(new Pelanggan(id, nama, telepon, alamat));
    }

    static void buatTransaksi() {
        if (riwayat.isFull()) {
            System.out.println("Riwayat transaksi penuh.");
            return;
        }
        try {
            System.out.print("ID pelanggan: ");
            String id = input.nextLine();
            System.out.print("Kode produk: ");
            String kodeProduk = input.nextLine();
            System.out.print("Jumlah pembelian: ");
            int jumlah = bacaInt();
            System.out.print("Diskon (%): ");
            double diskon = bacaDouble();

            String kode = "TRX" + nomorTransaksi;
            Transaksi t = toko.prosesTransaksi(kode, id, kodeProduk, jumlah, diskon);
            if (t != null && riwayat.push(t)) {
                nomorTransaksi++;
                System.out.println("\nTransaksi berhasil!");
                t.tampilkanInfo();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Kesalahan: " + e.getMessage());
        }
    }

    static void cariProduk() {
        System.out.print("Masukkan kode produk: ");
        String kode = input.nextLine();
        Produk p = toko.cariProduk(kode);
        if (p != null) {
            System.out.println("Produk ditemukan:");
            p.tampilkanInfo();
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    static void batalkanTransaksi() {
        Transaksi t = riwayat.pop();
        if (t != null) {
            System.out.println("Riwayat transaksi terakhir berhasil dihapus.");
            System.out.println("Catatan: stok dan pendapatan belum dikembalikan.");
        }
    }
}
