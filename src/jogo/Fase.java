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
	private int enemy = 10;
	
	private int points = 0;
	
	private boolean emJogo;

	private List<ObjetoCity> objetos;
	private FrameGeneric parent;

	public Fase(FrameGeneric parent) {
		this.parent = parent;
		setFocusable(true);
		setDoubleBuffered(true);
		addKeyListener(new TecladoAdapter());

		ImageIcon referencia = new ImageIcon("res/fundo.png");
		fundo = referencia.getImage();
		nave = new Nave();

		emJogo = true;

		objetos = new ArrayList<ObjetoCity>();
		inicializaInimigos();
		inicializaAnimais();
		

		timer = new Timer(5, this);
		timer.start();
	}

	public void inicializaInimigos() {
		
		

	        Random r = new  Random();
	        for(int i = 0; i < enemy; i++){

	            int x = r.nextInt((ContainerDeJanelas.LARGURA_TELA - 200));
	            
	            if(x < 100){
	            	x = 100;
	            }
	            
	            int y = 0;

	            if(x >= 0){
	                y = (ContainerDeJanelas.ALTURA_TELA + r.nextInt(x)) * -1;
	            }
	            else
	            {
	                y = (ContainerDeJanelas.ALTURA_TELA + r.nextInt((x * -1))) * -1;
	            }

	            objetos.add(new Inimigo(x, y, i));

	            if(i % 9 == 0){

	            }
	        }
	}
	
	public void inicializaAnimais() {
	

	        Random r = new  Random();
	        for(int i = 0; i < 10; i++){

	            int x = r.nextInt((ContainerDeJanelas.LARGURA_TELA - 50));
	            int y = 0;

	            if(x >= 0){
	                y = (ContainerDeJanelas.ALTURA_TELA + r.nextInt(x)) * -1;
	            }
	            else
	            {
	                y = (ContainerDeJanelas.ALTURA_TELA + r.nextInt((x * -1))) * -1;
	            }

	            objetos.add(new Animal(x, y, i));

	            if(i % 9 == 0){

	            }
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
			for (int i = 0; i < objetos.size(); i++) {
				ObjetoCity in =  objetos.get(i);
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			}

			graficos.setColor(Color.BLACK);
			
			graficos.drawString("Pontos: " + points, (ContainerDeJanelas.LARGURA_TELA / 2), 15);

		}
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent arg0) {

		if (objetos.size() == 0) {
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

		for (int i = 0; i < objetos.size(); i++) {

			ObjetoCity in = objetos.get(i);

			if (in.isVisible()) {
				in.move();
			} else {
				objetos.remove(i);
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

		for (int i = 0; i < objetos.size(); i++) {

			ObjetoCity tempInimigo = objetos.get(i);
			formaInimigo = tempInimigo.getBounds();

			if (formaNave.intersects(formaInimigo)) {
				
				
				if( tempInimigo instanceof Animal){
					points += 5;
					
				}else {
					nave.setVisivel(false);
					emJogo = false;
					objetos = new ArrayList<ObjetoCity>();
					points = 0;
					new GameOver(this, this.parent);
				}
				
				tempInimigo.setVisible(false);

				
			}
		}

		List<Missil> misseis = nave.getMisseis();

		for (int i = 0; i < misseis.size(); i++) {

			Missil tempMissel = misseis.get(i);
			formaMissel = tempMissel.getBounds();

			for (int j = 0; j < objetos.size(); j++) {

				ObjetoCity tempInimigo = objetos.get(j);
				formaInimigo = tempInimigo.getBounds();

				if (formaMissel.intersects(formaInimigo)) {
					
					if( !(tempInimigo instanceof Animal) ){
						tempInimigo.setY((100 + ContainerDeJanelas.ALTURA_TELA * -1));
						tempMissel.setVisible(false);
						points++;
					}

					

				}
			}
		}
	}
	
	public void playAgain(){
		emJogo = true;
		nave = new Nave();
		inicializaInimigos();
		
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
