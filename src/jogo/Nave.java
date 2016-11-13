package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Nave {
	private int x, y;
	private int dx, dy;
	private Image imagem;
	
	private int altura,largura;
	private boolean isVisivel;
	
	
	private List<Missil> misseis;
	
	public Nave(){
		
		ImageIcon reference = new ImageIcon("res/nave.gif");
		imagem = reference.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
		
		misseis = new ArrayList<Missil>();
		
		this.x = 400;
		this.y = 600;
	}

	public void move(){
		this.x += dx;
		this.y += dy;
		if(x < 1 ){
			x = 1;
		}
		if(x > 740 ){
			x = 740;
		}
		
		if(y < 1){
			y = 1;
		}
		if(y > 670){
			y = 670;
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDx() {
		return dx;
	}
	public Image getImagem() {
		return imagem;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}
	public void setVisivel(boolean isVisivel){
		this.isVisivel = isVisivel;
	}

	
	public List<Missil> getMisseis() {
		return misseis;
	}
	
	public void atira(){
		misseis.add(new Missil((x+largura/2)-3, y-7));
	}

	public Rectangle getBounds(){
		return  new Rectangle(x,y, largura, altura);
	}

	
	public void keyPressed(KeyEvent tecla){
		int code = tecla.getKeyCode();
		
		if(code == KeyEvent.VK_SPACE){
			atira();
		}
		
		if(code == KeyEvent.VK_UP){
			dy = -2;
		}
		
		if(code == KeyEvent.VK_DOWN){
			dy = 2;
		}
		
		if(code == KeyEvent.VK_LEFT){
			dx = -2;
		}
		
		if(code == KeyEvent.VK_RIGHT){
			dx = 2;
		}	
	}
	
	public void keyReleased(KeyEvent tecla){
		int code = tecla.getKeyCode();
		
		if(code == KeyEvent.VK_UP){
			dy = 0;
		}
		
		if(code == KeyEvent.VK_DOWN){
			dy = 0;
		}
		
		if(code == KeyEvent.VK_LEFT){
			dx = 0;
		}
		
		if(code == KeyEvent.VK_RIGHT){
			dx = 0;
		}
	}
}
