package com.esrakck.SwingMenuKontrolleri;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ExP2 {

	public static void main(String[] args) {

		 // Önce ana pencereyi ve menü çubuğunu oluştur.
        JFrame pencere = new JFrame("Açılır Menü");
        JMenuBar cubuk = new JMenuBar();

        // JMenu, tıklanınca açılan "Dosya" başlığıdır.
        JMenu dosya = new JMenu("Dosya");

        // Menü içinde bir komut oluştur.
        JMenuItem yeni = new JMenuItem("Yeni");
        dosya.add(yeni);

        // JMenu başka bir JMenu içerirse alt menü oluşur.
        JMenu disaAktar = new JMenu("Dışa Aktar");
        disaAktar.add(new JMenuItem("PDF"));
        dosya.add(disaAktar);

        // Önce menüyü çubuğa, sonra çubuğu pencereye ekle.
        cubuk.add(dosya);
        pencere.setJMenuBar(cubuk);

        // Pencereyi göster.
        pencere.setSize(420, 260);
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setVisible(true);
	}

}
