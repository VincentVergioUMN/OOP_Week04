package week04.vincent.id.ac.umn;

import java.util.Scanner;
import java.util.ArrayList;
public class MainToko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        ArrayList<Order> daftarOrder = new ArrayList<>();
        
        daftarBarang.add(new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000));
        daftarBarang.add(new Barang(2, "Penggaris 30cm", 30, 5000));
        daftarBarang.add(new Barang(3, "Tipe-x Roller", 30, 7000));
        daftarBarang.add(new Barang(4, "Pensil Mekanik", 50, 5000));
        daftarBarang.add(new Barang(5, "Buku Tulis", 100, 6000));
        
        while (true) {
            System.out.println("\n------------Menu Toko Multiguna------------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.print("Pilihan : ");
            int pilihan;
            try {
                pilihan = input.nextInt();
            } catch (Exception e) {
                System.out.println("Input tidak valid.");
                input.nextLine();
                continue;
            }
            input.nextLine();
            
            if (pilihan == 1) {
                System.out.println("\nDaftar Barang Toko Multiguna");
                for (Barang b : daftarBarang) {
                    System.out.println("ID   : " + b.getId());
                    System.out.println("Nama : " + b.getNama());
                    System.out.println("Stock: " + b.getStock());
                    System.out.println("Harga: " + b.getHarga());
                    System.out.println("------------------------------------------");
                }

                System.out.print("Ketik 0 untuk batal\nPesan Barang (ID) : ");
                int id = input.nextInt();
                input.nextLine();
                
                if (id == 0) {
                    continue;
                }

                Barang barangDipilih = null;
                for (Barang b : daftarBarang) {
                    if (b.getId() == id) {
                        barangDipilih = b;
                        break;
                    }
                }

                if (barangDipilih == null) {
                    System.out.println("ID Barang tidak ditemukan!");
                    continue;
                }

                int jumlah;
                while (true) {
                    System.out.print("Masukkan Jumlah : ");
                    jumlah = input.nextInt();
                    input.nextLine();
                    
                    if (jumlah == 0) {
                        System.out.println("Pembatalan pemesanan (jumlah 0).");
                        break;
                    }
                    if (jumlah > 0 && jumlah <= barangDipilih.getStock()) {
                        break;
                    } else {
                        System.out.println("Jumlah tidak sesuai stock!");
                    }
                }

                if (jumlah == 0) {
                    continue;
                }

                int totalHarga = jumlah * barangDipilih.getHarga();
                System.out.println(jumlah + " @ " + barangDipilih.getNama() + " dengan total harga " + totalHarga);

                System.out.print("Masukkan jumlah uang : ");
                int uang = input.nextInt();
                input.nextLine();

                if (uang < totalHarga) {
                    System.out.println("Jumlah uang tidak mencukupi");
                } else if (uang == totalHarga) {
                    barangDipilih.minusStock(jumlah);
                    daftarOrder.add(new Order(barangDipilih, jumlah));
                    System.out.println("Berhasil dipesan");
                } else {
                    barangDipilih.minusStock(jumlah);
                    daftarOrder.add(new Order(barangDipilih, jumlah));
                    int kembalian = uang - totalHarga;
                    System.out.println("Berhasil dipesan. Kembalian: " + kembalian);
                }

            } else if (pilihan == 2) {
                System.out.println("\nDaftar Pesanan Toko Multiguna");
                if (daftarOrder.isEmpty()) {
                    System.out.println("Belum ada pesanan.");
                } else {
                    for (Order o : daftarOrder) {
                        System.out.println("ID   : " + o.getId());
                        System.out.println("Nama : " + o.getBarang().getNama());
                        System.out.println("Jumlah : " + o.getJumlah());
                        System.out.println("Total : " + (o.getBarang().getHarga() * o.getJumlah()));
                        System.out.println("------------------------------------------");
                    }
                    System.out.println("Total Semua Pesanan: " + Order.total);
                }
            } else {
                System.out.println("Pilihan tidak tersedia!");
            }
        }
	}
}