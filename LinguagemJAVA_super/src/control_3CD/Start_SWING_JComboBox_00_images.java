package control_3CD;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Start_SWING_JComboBox_00_images {
	
	//ATTRIBUTES static
	private static final String[] nomesDoItens = {"zero", "um", "dois", "tres", "quatro"};
	
	//ATTRIBUTES objects
	private int indiceDoItemSelecionado = 0;
	private JFrame janela = new JFrame("Listas");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JList lista = new JList(nomesDoItens);
	private SentinelaParaALista sentinela = new SentinelaParaALista();
	
	//CONSTRUCTOR
	public Start_SWING_JComboBox_00_images() {
		
		janela.getContentPane().add(new JScrollPane(lista));
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setSelectedIndex(0);
		lista.addListSelectionListener(sentinela);
		
		//instruction of window
		janela.setBackground(Color.CYAN);
		janela.pack();
		janela.setSize(400,400);
		janela.setLocation(400, 100);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void execute() {
		janela.setVisible(true);
	}
	
	//INNER CLASS
	private class SentinelaParaALista implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			//CONDITION
			if(indiceDoItemSelecionado != lista.getSelectedIndex()) {
				System.out.println(lista.getSelectedIndex() + " --> " + lista.getSelectedValue());
			
				indiceDoItemSelecionado = lista.getSelectedIndex();
			}
		}
	}
	
	//MAIN
	public static void main(String[] args) {
		Start_SWING_JComboBox_00_images l = new Start_SWING_JComboBox_00_images();
		l.execute();
	}

}
