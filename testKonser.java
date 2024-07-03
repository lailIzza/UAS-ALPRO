import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class testKonser {
     public static void main(String[] args) {
        PemesananTiket pemesananTiket = new PemesananTiket();
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("\nAplikasi Pemesanan Tiket Konser");
            System.out.println("1. Tambah Konser");
            System.out.println("2. Tambah Tiket");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Tampilkan Daftar Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama konser: ");
                    String namaKonser = scanner.nextLine();
                    System.out.print("Masukkan tanggal konser: ");
                    String tanggalKonser = scanner.nextLine();
                    Konser konser = new Konser(namaKonser, tanggalKonser);
                    pemesananTiket.tambahKonser(konser);
                    break;
                case 2:
                    System.out.print("Masukkan nomor tiket: ");
                    int nomorTiket = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Masukkan nama konser: ");
                    String namaKonser2 = scanner.nextLine();
                    Konser konser2 = pemesananTiket.getDaftarKonser().stream()
                            .filter(k -> k.getNama().equals(namaKonser2))
                            .findFirst()
                            .orElse(null);
                    if (konser2 != null) {
                        Tiket tiket = new Tiket(nomorTiket, konser2);
                        pemesananTiket.tambahTiket(tiket);
                    } else {
                        System.out.println("Konser tidak ditemukan.");
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nama pemesan: ");
                    String namaPemesan = scanner.nextLine();
                    System.out.print("Masukkan nomor tiket: ");
                    int nomorTiket2 = scanner.nextInt();
                    scanner.nextLine(); 
                    pemesananTiket.pesanTiket(namaPemesan, nomorTiket2);
                    break;
                case 4:
                    pemesananTiket.tampilkanDaftarPesanan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }
}
