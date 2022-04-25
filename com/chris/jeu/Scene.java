package com.chris.jeu;

import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.chris.objet.Tuyau;
import com.chris.personnage.FlappyBird;

@SuppressWarnings("serial")
public class Scene extends JPanel {

	
	private ImageIcon icoBandeFond;
	private Image imgBandeFond;
	
	public Tuyau tuyauHaut1;
	public Tuyau tuyauBas1;
	public Tuyau tuyauHaut2;
	public Tuyau tuyauBas2;
	public Tuyau tuyauHaut3;
	public Tuyau tuyauBas3;
	
	public FlappyBird flappyBird;
	
	private int score;
	private Font police;
	
	private final int LARGEUR_BANDE_FOND = 140;
	private final int DISTANCE_TUYAUX = 250;
	private final int ECART_TUYAUX = 120;
	
	public int xFond;
	private int xTuyaux;
	public boolean finDuJeu;
	
	private Random hasard;
	
	public Scene() {
		this.icoBandeFond = new ImageIcon(getClass().getResource("/image/bandeFondEcran.png"));
		this.imgBandeFond = this.icoBandeFond.getImage();
		
		this.xFond = 0;
		this.xTuyaux = 400;
		this.finDuJeu = false;
		
		this.tuyauHaut1 = new Tuyau(this.xTuyaux, -150, "/image/tuyauHaut.png");
		this.tuyauBas1 = new Tuyau(this.xTuyaux, 250, "/image/tuyauBabs.png");
		this.tuyauHaut2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX, -100, "/image/tuyauHaut.png");
		this.tuyauBas2 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX, 300, "/image/tuyauBas.png");
		this.tuyauHaut3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX * 2, -120, "/image/tuyauHaut.png");
		this.tuyauBas3 = new Tuyau(this.xTuyaux + this.DISTANCE_TUYAUX * 2, 280, "/image/tuyauBas.png");
		
		this.flappyBird = new FlappyBird(100, 150, "/image/oiseau1.png");
		
		hasard = new Random();
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		this.score = 0;
		this.police = new Font("Arial", Font.PLAIN, 40);
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
}
