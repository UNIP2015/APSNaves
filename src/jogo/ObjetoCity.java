package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

public class ObjetoCity {
	protected int x, y;
	protected Image imagem;
	protected boolean isVisible;
	protected int altura, largura;
	
	protected int xOrigin, yOrigin;
	
	protected static final int LARGURA_TELA = 600;
	protected static final int VELOCIDADE = 1;
	
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
