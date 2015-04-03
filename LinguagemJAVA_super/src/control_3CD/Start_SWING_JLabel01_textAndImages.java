package control_3CD;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Start_SWING_JLabel01_textAndImages extends JFrame{

	public Start_SWING_JLabel01_textAndImages() {
		super("Label");
	
		/* criar label com uma mensagem (quando passo o rato por cima) */
		JLabel simples = new JLabel("Label Simples");
		simples.setToolTipText("Meu Tooltip");
		
		/* criar label com variantes de cor, letra, tamanho,...*/
		Font fonte = new Font("serif", Font.BOLD | Font.ITALIC, 28);
		JLabel label = new JLabel("Label Simples");
		label.setFont(fonte);
		label.setForeground(Color.BLUE);
		
		/* criar label com imagem */
		ImageIcon luz = new ImageIcon("./myFotos/luz.jpg");//imagem e um Objecto deste tipo
		ImageIcon informatica = new ImageIcon("./myFotos/informatica.jpg");
		
		JLabel imagem = new JLabel(luz);
		JLabel imagem1 = new JLabel(informatica);
		
		/* definido o Container e o que esta dentro */
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(simples);
		c.add(label);
		c.add(imagem);
		c.add(imagem1);
		
		/* base */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,700);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		
		new Start_SWING_JLabel01_textAndImages();

	}

}
