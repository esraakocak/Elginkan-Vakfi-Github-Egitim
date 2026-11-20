package com.esrakck.SwingMenuKontrolleri;

import javax.swing.*;

public class Exp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// JFrame: Bütün menülerin bağlı olduğu pencere.
		JFrame pencere = new JFrame("Menü Çubuğu");

		// JMenuBar: Pencerenin üst kısmındaki boş şerit.
		JMenuBar cubuk = new JMenuBar();

		// JMenu: Şeritte görünecek "Dosya" başlığı.
		JMenu dosya = new JMenu("Dosya");

		// "Dosya" menüsünü şeride ekle.
		cubuk.add(dosya);

		// Hazırladığımız şeridi pencereye yerleştir.
		pencere.setJMenuBar(cubuk);

		// Pencerenin boyutunu ve kapanış davranışını ayarla.
		pencere.setSize(420, 260);
		pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Son adım: Pencereyi ekranda göster.
		pencere.setVisible(true);

	}

}
