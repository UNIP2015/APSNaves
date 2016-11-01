package jogo;

import java.awt.Component;

import javax.swing.JFrame;

public class FrameGeneric extends JFrame{

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


