
import javax.swing.*;

public class tugaspendakian {
    public static void main(String[] args) {
        int energi = 0;
        String jalur;
        
        energi = Integer.parseInt(JOptionPane.showInputDialog("Masukan energi awal:"));
        jalur = JOptionPane.showInputDialog("Masukan jalur pendakian:");
        String Pendakian[][] = {
            {"PX", "X", "X", "X", "X", "X", "X", "X", "X", "Y", "Y", "Y"},
            {"Y", "X", "Y", "Y", "Y", "X", "X", "P", "X", "Y", "X", "Y"},
            {"Y", "X", "X", "X", "Y", "P", "Y", "Y", "Y", "Y", "X", "Y"},
            {"Y", "P", "Y", "Y", "Y", "X", "Y", "Y", "X", "X", "X", "Y"},
            {"Y", "Y", "X", "Y", "Y", "X", "P", "X", "X", "X", "X", "Y"},
            {"P", "Y", "X", "P", "Y", "X", "Y", "Y", "Y", "Y", "Y", "P"}
        };        
        
        int kolom = 11;
        int baris = 5;
        
        for (int i = 0; i < jalur.length(); i++) {
            char huruf = jalur.charAt(i);
            String huruf1 = String.valueOf(huruf);
            huruf1 = huruf1.toLowerCase();
            
            if (huruf1.equals("l")) {
                kolom--;
            } else if (huruf1.equals("r")) {
                kolom++;
            } else if (huruf1.equals("u")) {
                baris--;
            } else if (huruf1.equals("d")) {
                baris++;
            } else if (huruf1.equals("i")) {
                String posisi = Pendakian[baris][kolom];
                if (posisi.equals("P")) {
                    energi += 10;
                } else {
                    System.out.println("Mohon maaf, istirahat hanya di perbolehkan di pos - pos yang tersedia");
                    break;
                }
            }
            
            String posisi = Pendakian[baris][kolom];
            
            if (posisi.equals("Y") || posisi.equals("P")) {
                energi--;
            } else if (posisi.equals("X")) {
                energi--;
                System.out.println("Jalur anda salah, anda masuk jurang/blank 45.");
                break;
            } else if (posisi.equals("PX")) {
                energi--;
                System.out.println("Selamat anda berhasil mencapai puncak, sisa energi anda adalah " + energi);
                break;
            }
            
            if (energi == 0) {
                System.out.println("Jalur anda benar, tapi tenaga anda tidak akan kuat, coba jalur lain atau sempatkan istirahat terlebih dahulu");
                break;
            }
        }
        
        System.out.println("Sisa energi anda: " + energi);
    }
}
