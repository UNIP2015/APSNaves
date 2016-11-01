package jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ContainerMenu extends FrameGeneric {
	private JButton btSobre;
	private JButton btSair;
	private JButton btInstrucoes;
	private JButton btPlay;
	private JPanel panelButtons;
	private JLabel lbTitle;
	private JPanel panel;
	public ContainerMenu() {
		
		Dimension dimension = new Dimension(ContainerDeJanelas.LARGURA_TELA,ContainerDeJanelas.ALTURA_TELA + 100);
		
		setTitle("Meu Primeiro Jogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimension);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		panel = new JPanel();
		panel.setSize(dimension);
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		lbTitle = new JLabel("Descubra OTÃ�RIO".toUpperCase());
		
		Font f = new Font("Arial", Font.BOLD, 18);
		lbTitle.setFont(f);;
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		panel.add(lbTitle);
		
		//BotÃµes
		
		panelButtons = new JPanel();
		panelButtons.setBackground(Color.BLACK);
		panelButtons.setForeground(Color.BLACK);
		panelButtons.setLayout(null);
		Dimension sizeBt = new Dimension(200, 80);
		
		int x = (ContainerDeJanelas.LARGURA_TELA / 2 ) - ((int)( sizeBt.getWidth() / 2 ) );
		int y = 5;
		//BotÃ£o Init Jogo
		btPlay = new JButton("Iniciar Jogo");
		btPlay.setBackground(Color.BLACK);
		BorderFactory.createLineBorder(Color.WHITE, 1);
		btPlay.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		

		
		btPlay.setSize(sizeBt);
		btPlay.setFont(f);
		btPlay.setForeground(Color.WHITE);
		btPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btPlay.setLocation(x,y);
		panelButtons.add(btPlay);
		
		
		//BotÃ£o INSTRUÃ‡ÃƒO
		
		btInstrucoes = new JButton("InstruÃ§Ãµes");
		btInstrucoes.setBackground(Color.BLACK);
		
		btInstrucoes.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		btInstrucoes.setSize(sizeBt);
		btInstrucoes.setFont(f);
		btInstrucoes.setForeground(Color.WHITE);
		y = btPlay.getHeight() + ((int) btPlay.getLocation().getY());
		y+= 5;
		btInstrucoes.setLocation(x,y);
		
		panelButtons.add(btInstrucoes);
		
		
		//BotÃ£o Sobre
		btSobre = new JButton("Sobre");
		btSobre.setBackground(Color.BLACK);
		btSobre.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		
		btSobre.setSize(sizeBt);
		btSobre.setFont(f);
		btSobre.setForeground(Color.WHITE);
		y = btInstrucoes.getHeight() + ((int) btInstrucoes.getLocation().getY());
		y+= 5;
		btSobre.setLocation(x,y);
				
		panelButtons.add(btSobre);
		
		//BotÃ£o Sair
		btSair = new JButton("Sair do JOGO");
		btSair.setBackground(Color.BLACK);
		btSair.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(Color.BLACK, 20)));
		
		btSair.setSize(sizeBt);
		btSair.setFont(f);
		btSair.setForeground(Color.WHITE);
		y = btSobre.getHeight() + ((int) btSobre.getLocation().getY());
		y+= 5;
		btSair.setLocation(x,y);
				
		panelButtons.add(btSair);
		
		panel.add(panelButtons);
		add(panel);
		
		initEvents();
		
		setVisible(true);
		
	}

	private void initEvents(){
		final FrameGeneric self = this;
		btPlay.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				try{
					self.dispose();
					new ContainerDeJanelas();
				}catch(Exception er){
					//handled exception
				}
				
				
			}
		});
	}
	public static void main(String[] args) {
		new ContainerMenu();
		
	}
	
}
