// CLASS PRODUK
class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk() {
        this("P000", "Produk Baru", 1, 0);
    }

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        setHarga(harga);
        setStok(stok);
    }

    public void tampilkanInfo() {
        System.out.println(kode + " | " + nama +
                " | Rp" + harga + " | Stok: " + stok);
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= 0 || jumlah > stok) return false;
        stok -= jumlah;
        return true;
    }

    public void tambahStok(int jumlah) {
        if (jumlah > 0) stok += jumlah;
    }

    public void setHarga(double harga) {
        if (harga > 0) this.harga = harga;
        else throw new IllegalArgumentException("Harga harus lebih dari 0");
    }

    public void setStok(int stok) {
        if (stok >= 0) this.stok = stok;
        else throw new IllegalArgumentException("Stok tidak boleh negatif");
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
}
