package jogo;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ContainerInstrucao extends FrameGeneric{
	public ContainerInstrucao() {
		super("APS - Instrução");
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		JLabel txt = new JLabel();
		String html = "<html>";
		html += "<style>h2,h3,h4,li,* {color: white } </style>";
		html += "<h2><font color=#FFFFFF>INSTRUÇÕES</font></h2>";
		html+= "</html>";
				
		txt.setText(html);
		txt.setSize(300, 300);
		txt.setLocation(30, 15);
		
		getContentPane().add(txt);
		
		setVisible(true);
	}
}
