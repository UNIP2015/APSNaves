package jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends FrameGeneric {
	private JButton btAgain;
	private JButton btSair;
	
	private Fase fase;
	private FrameGeneric parent;

	public GameOver(Fase pn, FrameGeneric parent) {
	
		this.fase = pn;
		this.parent = parent;
		
		Dimension dimension = new Dimension(ContainerDeJanelas.LARGURA_TELA /2,ContainerDeJanelas.ALTURA_TELA / 2);
		setTitle("Game Over");
		setSize(200, 180);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setSize(200,200);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JLabel lbMessage = new JLabel("GAME OVER");
		lbMessage.setForeground(Color.BLACK);
		lbMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(lbMessage);		
		
		btAgain = new JButton("MENU PRINCIPAL");
		btAgain.setForeground(Color.WHITE);
		btAgain.setBackground(Color.black);
		btAgain.setAlignmentX(Component.CENTER_ALIGNMENT);
		btAgain.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		
		panel.add(btAgain);	
		
		btSair = new JButton("SAIR");
		btSair.setForeground(Color.WHITE);
		btSair.setBackground(Color.black);
		btSair.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		btSair.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(btSair);	
		
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		defineActions();
	}
	
	private void defineActions(){
		btSair.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		final FrameGeneric  self = this;
		btAgain.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				self.dispose();
				parent.dispose();
				new ContainerMenu();
//				fase.playAgain();
				
			}
		});
	}
}
