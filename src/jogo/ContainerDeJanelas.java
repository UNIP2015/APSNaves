package jogo;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ContainerDeJanelas extends JFrame{
	public static int LARGURA_TELA = 800;
	public static int ALTURA_TELA = 800;
	
	public ContainerDeJanelas() throws InterruptedException{
		
		add(new Fase());
		
		setTitle("APS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LARGURA_TELA,ALTURA_TELA);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new ContainerDeJanelas();
	}
}
