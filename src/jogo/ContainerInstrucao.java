package jogo;

import java.awt.Color;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ContainerInstrucao extends FrameGeneric{
	public ContainerInstrucao() {
		super("APS - Instrucoes");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		setLocation(300, 200);
		setSize(400, 400);
		setBackground(Color.white);
		
		JLabel txt = new JLabel();
		String html = "<html>";
		html += "<style>h2,h3,h4,li,p,* {color: blue; text-align: center; width: 100%; } </style>";
		html += "<h2><font color=blue>INSTRU&Ccedil;&Otilde;ES</font></h2>";
		html += "<p>Use as setas do teclado para mover a nave nos dois eixos, </p>";
		html += "<p>E barra espaço para atirar.</p>";
		html += "<p>Colete o maior numero de animais possiveis e destrua o lixo para pontuar</p>";
		html+= "</html>";
				
		txt.setText(html);
		txt.setSize(300, 300);
		txt.setLocation(30, 15);
		
		getContentPane().add(txt);
		
		setVisible(true);
	}
}
