import java.util.ArrayList;

// CLASS TOKO KELONTONG
class TokoKelontong {
    private String namaToko;
    private ArrayList<Produk> daftarProduk;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Transaksi> daftarTransaksi;
    private double pendapatan;

    public TokoKelontong(String namaToko) {
        this.namaToko = namaToko;
        daftarProduk = new ArrayList<>();
        daftarPelanggan = new ArrayList<>();
        daftarTransaksi = new ArrayList<>();
        pendapatan = 0;
    }

    public void tambahProduk(Produk produk) {
        if (cariProduk(produk.getKode()) != null) {
            System.out.println("Kode produk sudah digunakan.");
            return;
        }
        daftarProduk.add(produk);
        System.out.println("Produk berhasil ditambahkan.");
    }

    public void tambahPelanggan(Pelanggan pelanggan) {
        if (cariPelanggan(pelanggan.getId()) != null) {
            System.out.println("ID pelanggan sudah digunakan.");
            return;
        }
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    public Produk cariProduk(String kode) {
        for (Produk p : daftarProduk)
            if (p.getKode().equalsIgnoreCase(kode)) return p;
        return null;
    }

    public Pelanggan cariPelanggan(String id) {
        for (Pelanggan p : daftarPelanggan)
            if (p.getId().equalsIgnoreCase(id)) return p;
        return null;
    }

    public Transaksi prosesTransaksi(String kode, String id, String kodeProduk,
                                     int jumlah, double diskon) {
        Pelanggan pelanggan = cariPelanggan(id);
        Produk produk = cariProduk(kodeProduk);

        if (pelanggan == null || produk == null) {
            System.out.println("Pelanggan atau produk tidak ditemukan.");
            return null;
        }
        if (jumlah <= 0 || jumlah > produk.getStok()) {
            System.out.println("Jumlah pembelian tidak valid.");
            return null;
        }
        if (diskon < 0 || diskon > 50) {
            System.out.println("Diskon maksimal 50 persen.");
            return null;
        }

        produk.kurangiStok(jumlah);
        Transaksi transaksi = new Transaksi(kode, pelanggan, produk, jumlah, diskon);
        daftarTransaksi.add(transaksi);
        pendapatan += transaksi.hitungTotal();
        return transaksi;
    }

    public void tampilkanProduk() {
        System.out.println("\n--- DAFTAR PRODUK ---");
        for (Produk p : daftarProduk) p.tampilkanInfo();
    }

    public void tampilkanPelanggan() {
        System.out.println("\n--- DAFTAR PELANGGAN ---");
        for (Pelanggan p : daftarPelanggan) p.tampilkanInfo();
    }

    public void tampilkanLaporan() {
        System.out.println("\n--- LAPORAN TOKO ---");
        System.out.println("Nama Toko: " + namaToko);
        System.out.println("Jumlah Produk: " + daftarProduk.size());
        System.out.println("Jumlah Pelanggan: " + daftarPelanggan.size());
        System.out.println("Jumlah Transaksi: " + daftarTransaksi.size());
        System.out.println("Total Pendapatan: Rp" + pendapatan);
    }
}
