package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Inimigo {
	private int x, y;
	private Image imagem;
	private boolean isVisible;
	private int altura, largura;
	
	private int xOrigin, yOrigin;
	
	private static final int LARGURA_TELA = 600;
	private static final int VELOCIDADE = 1;
	
	public Inimigo(int x, int y, int i){
		this.x = x;
		this.y = y;
		this.xOrigin = x;
		this.yOrigin = y;
		ImageIcon reference;
		
		if(i % 3 == 0){
			reference = new ImageIcon("res/lixo3.png");			
		}
		else if(i % 5 == 0){
			reference = new ImageIcon("res/lixo1.png");
		}
		else {
			reference = new ImageIcon("res/lixo2.png");
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
			Random r = new Random();
			y = this.yOrigin;
			x = r.nextInt(ContainerDeJanelas.LARGURA_TELA);
		}else {
			y += VELOCIDADE;
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
	
	public int setX(int x){
		return this.x = x;
	}

	public int getY() {
		return y;
	}
	
	public int setY(int y){
		return this.y = y;
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
