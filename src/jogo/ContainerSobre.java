package jogo;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class ContainerSobre extends FrameGeneric{
	public ContainerSobre() {
		super("APS - Sobre");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLocation(300, 200);
		setSize(400, 400);
		setBackground(Color.white);
		
		JLabel txt = new JLabel();
		String html = "<html>";
		html += "<style>h2,h3,h4,li,p,* {color: blue; text-align: center; width: 100%; } </style>";
		html += "<h2><font color=blue>SOBRE</font></h2>";
		html += "<p>Desenvolvido para a APS do quarto Semestre de Ci&ecirc;ncias da Computa&ccedil;&atilde;o 2016</p>";
		html += "<p>Guilherme Pereira - RA C671JG8</p>";
		html += "<p>Jonatas Ferreira - RA C56GJH1</p>";
		html += "<p>Marcello Batista - RA C63BDJ0</p>";
		html += "<p>Vinicius Marcili - RA C6421I2</p>";
		html+= "</html>";
				
		txt.setText(html);
		txt.setSize(300, 300);
		txt.setLocation(30, 15);
		
		getContentPane().add(txt);
		
		setVisible(true);
	}
}
