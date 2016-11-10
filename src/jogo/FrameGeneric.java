package jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameGeneric extends JFrame{
	public FrameGeneric() {}
	public FrameGeneric(String title) {
		Dimension dimension = new Dimension(ContainerDeJanelas.LARGURA_TELA,ContainerDeJanelas.ALTURA_TELA);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimension);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		ImageIcon icon = new ImageIcon("res/fundo.png");
		Image image = icon.getImage();
		JLabel lbPic = new JLabel(icon);
		lbPic.setSize(dimension);
		
		JPanel pn = new JPanel();
		pn.setLocation(0,0);
		pn.setSize(dimension);
		pn.setBackground(Color.black);
		
		pn.setLayout(null);
		setContentPane(pn);
//		getContentPane().add(lbPic);
		
	}
	
	protected void setDefaultSize(Component c){
		c.setSize(390,20);
	}
	protected void setDefaultSize(Component c, int divisor){
		int r = 390/divisor;
		r -= 5;
		c.setSize(r,20);
	}
	
	protected void addBottom(Component component, Component elementTop){
		int y = elementTop.getLocation().y + elementTop.getSize().height;
		component.setLocation(elementTop.getLocation().x, y);
	}
	
	protected void addBottom(Component component, Component elementTop, int divisor){
		int y = elementTop.getLocation().y + elementTop.getSize().height;
		int x = 390 / divisor;
		x += 10;
		component.setLocation(x, y);
	}
	
	protected void addTop(Component component, Component elementBottom){
		int y = elementBottom.getLocation().y - elementBottom.getSize().height;
		component.setLocation(elementBottom.getLocation().x, y);
	}
}


