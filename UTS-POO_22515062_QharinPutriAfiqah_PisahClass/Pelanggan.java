// CLASS PELANGGAN
class Pelanggan {
    private String id;
    private String nama;
    private String noTelepon;
    private String alamat;

    public Pelanggan(String id, String nama, String noTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }

    public void tampilkanInfo() {
        System.out.println(id + " | " + nama + " | " + noTelepon + " | " + alamat);
    }

    public void ubahAlamat(String alamat) {
        if (alamat != null && !alamat.trim().isEmpty()) this.alamat = alamat;
    }

    public void ubahNoTelepon(String noTelepon) {
        if (noTelepon != null && !noTelepon.trim().isEmpty()) this.noTelepon = noTelepon;
    }

    public String getId() { return id; }
    public String getNama() { return nama; }
}
