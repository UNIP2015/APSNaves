package jogo;
import javax.swing.JFrame;

public class ContainerDeJanelas extends FrameGeneric{
	public static int LARGURA_TELA = 800;
	public static int ALTURA_TELA = 800;
	
	public ContainerDeJanelas() throws InterruptedException{
		
		add(new Fase(this));
		
		setTitle("APS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA_TELA,ALTURA_TELA);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	

}
