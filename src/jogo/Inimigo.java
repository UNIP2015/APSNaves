package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Inimigo {
	private int x, y;
	private Image imagem;
	private boolean isVisible;
	private int altura, largura;
	
	private int xOrigin, yOrigin;
	
	private static final int LARGURA_TELA = 500;
	private static final int VELOCIDADE = 1;
	
	private int contador = 0;
	
	public Inimigo(int x, int y){
		this.x = x;
		this.y = y;
		this.xOrigin = x;
		this.yOrigin = y;
		ImageIcon reference;
		
		if(contador++ % 3 == 0){
			reference = new ImageIcon("res/inimigo_1.gif");			
		}else {
			reference = new ImageIcon("res/inimigo_2.gif");
		}
		imagem = reference.getImage();
		isVisible = true;
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		if((x+largura) > ContainerDeJanelas.LARGURA_TELA){
			int dif = (x+largura) - ContainerDeJanelas.LARGURA_TELA;
			this.xOrigin -= dif;
			this.x= this.xOrigin;
		}
	}
	
	public void move(){
		if(y > ContainerDeJanelas.ALTURA_TELA){
			y = this.yOrigin;
		}else {
			y += VELOCIDADE;
		}
		System.out.println("Moving X: " + x + " Y: " + y);
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
	public Rectangle getBounds(){
		return  new Rectangle(x,y, largura, altura);
	}

	
}
