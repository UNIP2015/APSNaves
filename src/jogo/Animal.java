package jogo;

import javax.swing.ImageIcon;

public class Animal extends ObjetoCity{
	public Animal(int x, int y, int i){
		this.x = x;
		this.y = y;
		this.xOrigin = x;
		this.yOrigin = y;
		ImageIcon reference;
		
		if(i % 3 == 0){
			reference = new ImageIcon("res/animal1.png");			
		}
		else if(i % 5 == 0){
			reference = new ImageIcon("res/animal2.png");
		}
		else {
			reference = new ImageIcon("res/animal3.png");
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
