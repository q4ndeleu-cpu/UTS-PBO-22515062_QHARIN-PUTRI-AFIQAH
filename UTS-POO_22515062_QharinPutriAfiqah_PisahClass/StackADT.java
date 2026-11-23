// CLASS ADT STACK
class StackADT<T> {
    private Object[] data;
    private int top;
    private int kapasitas;

    public StackADT(int kapasitas) {
        if (kapasitas <= 0)
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0");
        this.kapasitas = kapasitas;
        data = new Object[kapasitas];
        top = -1;
    }

    public boolean push(T item) {
        if (isFull()) {
            System.out.println("Stack penuh.");
            return false;
        }
        if (item == null) {
            System.out.println("Data tidak boleh kosong.");
            return false;
        }
        data[++top] = item;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return null;
        }
        T item = (T) data[top];
        data[top--] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return null;
        }
        return (T) data[top];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == kapasitas - 1; }
    public int size() { return top + 1; }

    public void tampilkan() {
        System.out.println("\n--- RIWAYAT TRANSAKSI (STACK) ---");
        if (isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }
        for (int i = top; i >= 0; i--) {
            Transaksi t = (Transaksi) data[i];
            System.out.println("Riwayat ke-" + (i + 1));
            t.tampilkanInfo();
            System.out.println("--------------------");
        }
    }
}
