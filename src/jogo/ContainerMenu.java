package jogo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContainerMenu extends FrameGeneric {
	private JButton btSobre;
	private JButton btSair;
	private JButton btInstrucoes;
	private JButton btPlay;
	private JPanel panelButtons;
	private JLabel lbTitle;
	private JPanel panel;
	private Image fundo;
	private Color buttoncolor;
	
	public ContainerMenu() {
		
		Dimension dimension = new Dimension(ContainerDeJanelas.LARGURA_TELA,ContainerDeJanelas.ALTURA_TELA);
		
		setTitle("APS - NaveCity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(dimension);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		buttoncolor = new Color(0f,0f,0f,.0f );
		
		ImageIcon referencia = new ImageIcon("res/fundo.png");
		fundo = referencia.getImage();
		
		panel = new JPanel();
		panel.setSize(dimension);
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.YELLOW);
		panel.setLayout(null);

		lbTitle = new JLabel("NaveCity");
		
		//Botoes
		panelButtons = new JPanel();
		panelButtons.setBackground(null);
		panelButtons.setForeground(null);
		panelButtons.setLayout(null);
		panelButtons.setSize(ContainerDeJanelas.LARGURA_TELA ,ContainerDeJanelas.ALTURA_TELA );
		
		Font f = new Font("Arial", Font.BOLD, 18);
		Font fTitle = new Font("Arial", Font.BOLD, 32);
		lbTitle.setFont(fTitle);
		lbTitle.setForeground(Color.YELLOW);
		lbTitle.setSize(200, 200);
		lbTitle.setLocation(ContainerDeJanelas.LARGURA_TELA / 2 - 75, 40);
		panelButtons.add(lbTitle);
		
		panelButtons.setLocation(0, 0);
		Dimension sizeBt = new Dimension(200, 80);
		
		int x = (ContainerDeJanelas.LARGURA_TELA / 2 ) - ((int)(sizeBt.getWidth() / 2));
		int y = 180;
		
		//Botoes Init Jogo
		btPlay = new JButton("Iniciar Jogo");
		btPlay.setBackground(buttoncolor);
		btPlay.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(buttoncolor, 20)));
		
		btPlay.setSize(sizeBt);
		btPlay.setFont(f);
		btPlay.setForeground(Color.WHITE);
		btPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btPlay.setLocation(x,y);
		panelButtons.add(btPlay);
		
		
		//Botao instrucao		
		btInstrucoes = new JButton("Como Jogar");
		btInstrucoes.setBackground(buttoncolor);
		btInstrucoes.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(buttoncolor, 20)));
		
		btInstrucoes.setSize(sizeBt);
		btInstrucoes.setFont(f);
		btInstrucoes.setForeground(Color.WHITE);
		y = btPlay.getHeight() + ((int) btPlay.getLocation().getY());
		y+= 5;
		btInstrucoes.setLocation(x,y);
		
		panelButtons.add(btInstrucoes);
		
		//Botao Sobre
		btSobre = new JButton("Sobre");
		btSobre.setBackground(buttoncolor);
		btSobre.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(buttoncolor, 20)));
		
		btSobre.setSize(sizeBt);
		btSobre.setFont(f);
		btSobre.setForeground(Color.WHITE);
		y = btInstrucoes.getHeight() + ((int) btInstrucoes.getLocation().getY());
		y+= 5;
		btSobre.setLocation(x,y);
				
		panelButtons.add(btSobre);
		
		//Botao Sair
		btSair = new JButton("Sair");
		btSair.setBackground(buttoncolor);
		btSair.setBorder(BorderFactory.createCompoundBorder(
	               BorderFactory.createLineBorder(Color.WHITE, 3),
	               BorderFactory.createLineBorder(buttoncolor, 20)));
		
		btSair.setSize(sizeBt);
		btSair.setFont(f);
		btSair.setForeground(Color.WHITE);
		y = btSobre.getHeight() + ((int) btSobre.getLocation().getY());
		y+= 5;
		btSair.setLocation(x,y);
				
		panelButtons.add(btSair);
		
		ImageIcon icon = new ImageIcon("res/fundo.png");
		Image image = icon.getImage();
		JLabel lbPic = new JLabel(icon);
		lbPic.setSize(dimension);
		panelButtons.add(lbPic);
		
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
		
		btInstrucoes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new ContainerInstrucao();
				
			}
		});
		
		btSobre.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new ContainerSobre();
				
			}
		});
		
		btSair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		new ContainerMenu();
	}

	public Image getFundo() {
		return fundo;
	}

	public void setFundo(Image fundo) {
		this.fundo = fundo;
	}	
}
