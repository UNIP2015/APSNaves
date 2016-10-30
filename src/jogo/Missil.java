package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Missil {
	private int x, y;
	private Image imagem;
	private boolean isVisible;
	
	private int largura,altura;
	
	private static final int LARGURA_TELA = 800;
	private static final int ALTURA_TELA = 800;
	private static final int VELOCIDADE = 4;
	
	public Missil(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon reference = new ImageIcon("res/missel.png");
		imagem = reference.getImage();
		
		largura = imagem.getWidth(null);
		altura = imagem.getHeight(null);
		isVisible = true;
	}
	
	public void move(){
		this.y -= VELOCIDADE;
		if(y > ALTURA_TELA){
			isVisible = false;
		}
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

	public static int getLarguraTela() {
		return LARGURA_TELA;
	}
}
