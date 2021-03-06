package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Inimigo  extends ObjetoCity{
	
	
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
	
	

	
}
