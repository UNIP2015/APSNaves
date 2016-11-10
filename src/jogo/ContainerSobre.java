package jogo;

import java.awt.Dimension;

import javax.swing.JLabel;

public class ContainerSobre extends FrameGeneric{
	public ContainerSobre() {
		super("APS - Sobre");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel txt = new JLabel();
		String html = "<html>";
		html += "<h2><font color=#FFFFFF>SOBRE</font></h2>";
		html+= "</html>";
				
		txt.setText(html);
		txt.setSize(300, 300);
		txt.setLocation(30, 15);
		
		getContentPane().add(txt);
		
		setVisible(true);
	}
}
