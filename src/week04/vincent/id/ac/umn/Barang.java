package week04.vincent.id.ac.umn;

public class Barang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	private int id;
    private String nama;
    private int stock;
    private int harga;

    public Barang(int id, String nama, int stock, int harga) {
        this.id = id;
        this.nama = nama;
        this.stock = stock;
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getStock() {
        return stock;
    }

    public int getHarga() {
        return harga;
    }

    public void minusStock(int qty) {
        this.stock -= qty;
    }
}
