package week04.vincent.id.ac.umn;

public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	private static int nextOrderId = 1;
    private int id;
    private int jumlah;
    private Barang barang;
    public static int total = 0;

    public Order() { }

    public Order(Barang barang, int jumlah) {
        this.id = nextOrderId++;
        this.barang = barang;
        this.jumlah = jumlah;
        total += barang.getHarga() * jumlah;
    }

    public int getId() {
        return id;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Barang getBarang() {
        return barang;
    }
}
