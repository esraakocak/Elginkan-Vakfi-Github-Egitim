package com.esrakck.SwingMenuKontrolleri;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class MySqlOgrenciEkle {
    public static void main(String[] args) {
        // localhost: bilgisayarınız, 3306: MySQL portu, java_kursu: veri tabanı.
        String url = "jdbc:mysql://localhost:3306/java_kursu";
        String sql = "INSERT INTO ogrenciler (ad, soyad) VALUES (?, ?)";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("MySQL kullanıcı adı (boş bırakırsanız root): ");
            String kullanici = scanner.nextLine().trim();
            if (kullanici.isEmpty()) kullanici = "root";

            System.out.print("Öğrencinin adı: ");
            String ad = scanner.nextLine().trim();
            System.out.print("Öğrencinin soyadı: ");
            String soyad = scanner.nextLine().trim();
            if (ad.isEmpty() || soyad.isEmpty()) {
                System.out.println("Ad ve soyad boş olamaz.");
                return;
            }

            // Eclipse konsolunda Console genellikle yoktur; şifreyi gizli bir pencerede alırız.
            JPasswordField alan = new JPasswordField();
            int secim = JOptionPane.showConfirmDialog(null, alan, "MySQL şifreniz",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (secim != JOptionPane.OK_OPTION) return;
            char[] sifre = alan.getPassword();
            alan.setText("");

            try (Connection baglanti = DriverManager.getConnection(url, kullanici, new String(sifre));
                 PreparedStatement ifade = baglanti.prepareStatement(sql)) {
                // Parametre numaraları 1'den başlar. Değerler SQL metnine eklenmez.
                ifade.setString(1, ad);
                ifade.setString(2, soyad);
                int satir = ifade.executeUpdate();
                System.out.println(satir + " öğrenci eklendi.");
            } catch (SQLException e) {
                System.err.println("MySQL işlemi başarısız: " + e.getMessage());
                System.err.println("SQLState: " + e.getSQLState() + ", kod: " + e.getErrorCode());
            } finally {
                Arrays.fill(sifre, '\0');
            }
        }
    }
}
