// CLASS TRANSAKSI
class Transaksi {
    private String kodeTransaksi;
    private Pelanggan pelanggan;
    private Produk produk;
    private int jumlah;
    private double diskon;

    public Transaksi(String kodeTransaksi, Pelanggan pelanggan,
                     Produk produk, int jumlah, double diskon) {
        this.kodeTransaksi = kodeTransaksi;
        this.pelanggan = pelanggan;
        this.produk = produk;
        this.jumlah = jumlah;
        if (diskon < 0 || diskon > 50)
            throw new IllegalArgumentException("Diskon maksimal 50 persen");
        this.diskon = diskon;
    }

    public double hitungSubtotal() { return produk.getHarga() * jumlah; }
    public double hitungDiskon() { return hitungSubtotal() * diskon / 100; }
    public double hitungTotal() { return hitungSubtotal() - hitungDiskon(); }

    public void tampilkanInfo() {
        System.out.println("Kode Transaksi: " + kodeTransaksi);
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Produk: " + produk.getNama());
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Total: Rp" + hitungTotal());
    }

    public double getTotal() { return hitungTotal(); }
}
