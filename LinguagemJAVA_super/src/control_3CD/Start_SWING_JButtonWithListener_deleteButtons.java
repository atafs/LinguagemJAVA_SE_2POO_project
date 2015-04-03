package control_3CD;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Start_SWING_JButtonWithListener_deleteButtons extends JFrame {

	//atributos 
	private JPanel panel = new JPanel();
	private BorderLayout border = new BorderLayout();
	private JButton botao1 = new JButton("Add new Button");
	private JButton botao;
	private int count = 0; //add number to new buttons
	
	//construtor
	public Start_SWING_JButtonWithListener_deleteButtons() {

		// instanciar a janela, com tamanho e localizacao
		super("PrintOnConsole_GUI");

		// 1- INICIALIZO O CONTAINER
		Container c = getContentPane();// instrucao para a criacao do container
		c.setBackground(Color.GREEN);
		
		// 2- ESCOLHO QUAL A DISPOSICAO GERAL DO CONTAINER (grid,...)
		c.setLayout(border);
		c.add(BorderLayout.NORTH, botao1);
		
		panel.setLayout(new GridLayout(4,4));
		c.add(BorderLayout.SOUTH, panel);
		
		// REGISTAR SENTINELAS:
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				botao1.setText("Added new Button. Is another necessary? If so, press again...");
				System.out.println("Envio para a consola esta mensagem!!!");

				botao = new JButton("Button" + count++);
				botao.setBackground(Color.BLACK);
				botao.setForeground(Color.GREEN);
				panel.add(botao);
				panel.validate(); //lay out its sub-components after each adding			
				panel.repaint();
			
				// REGISTAR SENTINELAS:
				botao.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Envio para a consola esta mensagem de dentro do actionListener!!!");
						
						if(arg0.getSource() == botao) {
							//???BUG: ERRO, apaga sempre o ultimo e nao o respectivo
							panel.remove(botao);
							panel.validate(); 	
							panel.repaint();

						}
					}
				});
			}
		});
	}

	// execute
	public void execute() {

		// instrucoes basicas
		setSize(500, 200);
		setLocation(500, 100);
		setResizable(true);// pode ou nao ser resizable

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// poder fechar
		setVisible(true);// visivel
	}

	// main
	public static void main(String[] args) {
		Start_SWING_JButtonWithListener_deleteButtons janela = new Start_SWING_JButtonWithListener_deleteButtons();
		janela.execute();
	}
}
