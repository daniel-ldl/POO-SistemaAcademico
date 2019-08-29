package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisciplinaView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel container;
	private JTextField jtxcodigo;
	private JTextField jtxnome;
	private JLabel jlbcodigo;
	private JLabel jlbnome;
	
	public DisciplinaView() {
		
		inicializa();
		
	}
	
	public void inicializa() {
		
		container = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("Cadastro de Disciplinas");
		container.setLayout(null);
		container.setBounds(0, 0, 700, 450);
		
	}
	
	public void defineComponentes() {
		
	}
	
}
