package jogo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Fase extends JPanel implements ActionListener {

	private Image fundo;
	private Nave nave;
	private Timer timer;
	
	private int points = 0;

	private boolean emJogo;

	private List<Inimigo> inimigos;

	private int[][] coordenadas = { { 29, 2380 }, { 59, 2600 }, { 89, 1380},
			{ 109, 780}, { 139, 580}, { 239, 880}, { 259,790},
			{ 50,760}, { 790, 150 }, { 1980, 209 }, { 45,560}, { 70, 510},
			{ 159,930}, { 80,590}, { 50,530}, { 940, 59 }, { 30,990},
			{ 200,920}, { 259,900}, { 50, 660 }, { 540,90}, { 220,810},
			{ 20,860 }, { 180,740}, { 128, 820}, { 490,170}, { 30,700},
			{ 300,920}, { 328,856}, { 320, 456} };

	public Fase() {
		
		

		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon referencia = new ImageIcon("res/fundo.png");
		fundo = referencia.getImage();
		nave = new Nave();

		emJogo = true;

		inicializaInimigos();

		timer = new Timer(5, this);
		timer.start();

	}

	public void inicializaInimigos() {

		inimigos = new ArrayList<Inimigo>();
		
		
		Random r = new  Random();
		for(int i = 0; i < coordenadas.length; i++){
			int x = r.nextInt(ContainerDeJanelas.LARGURA_TELA);
			
			int y =  ContainerDeJanelas.ALTURA_TELA * i;
			y = -1 * y;
		
			inimigos.add(new Inimigo(x, y ));
			
		}
		


	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);

		if (emJogo) {

			graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(), this);

			List<Missil> misseis = nave.getMisseis();

			for (int i = 0; i < misseis.size(); i++) {

				Missil m = (Missil) misseis.get(i);
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);

			}

			for (int i = 0; i < inimigos.size(); i++) {

				Inimigo in = inimigos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);

			}

			graficos.setColor(Color.WHITE);
			graficos.drawString("INIMIGOS: " + inimigos.size(), 5, 15);
			
			graficos.drawString("PONTOS: " + points, ContainerDeJanelas.LARGURA_TELA - 100, 15);
			
		}
		
		g.dispose();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (inimigos.size() == 0) {
			emJogo = false;
		}

		List<Missil> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missil m = (Missil) misseis.get(i);

			if (m.isVisible()) {
				m.move();
			} else {
				misseis.remove(i);
			}

		}

		for (int i = 0; i < inimigos.size(); i++) {

			Inimigo in = inimigos.get(i);

			if (in.isVisible()) {
				in.move();
			} else {
				inimigos.remove(i);
			}

		}

		nave.move();
		checarColisoes();
		repaint();
	}

	public void checarColisoes() {

		Rectangle formaNave = nave.getBounds();
		Rectangle formaInimigo;
		Rectangle formaMissel;

		for (int i = 0; i < inimigos.size(); i++) {

			Inimigo tempInimigo = inimigos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {

				nave.setVisivel(false);
				tempInimigo.setVisible(false);
				

				emJogo = false;

			}

		}

		List<Missil> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missil tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < inimigos.size(); j++) {

				Inimigo tempInimigo = inimigos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {

					tempInimigo.setVisible(false);
					tempMissel.setVisible(false);
					points++;
					
					
				}

			}

		}

	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				emJogo = true;
				nave = new Nave();
				inicializaInimigos();
			}
			
			nave.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			nave.keyReleased(e);
		}

	}

}
