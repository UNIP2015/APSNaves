package jogo;
import javax.swing.JFrame;

public class ContainerDeJanelas extends JFrame{
	public static int LARGURA_TELA = 470;
	public static int ALTURA_TELA = 300;
	
	public ContainerDeJanelas(){
		
		add(new Fase());
		
		setTitle("Meu Primeiro Jogo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA_TELA,ALTURA_TELA);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
