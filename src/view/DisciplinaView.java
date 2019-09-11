package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import connection.Conexao;
import controller.DisciplinaController;
import entidades.DisciplinaEntidade;
import model.ModelTableDisciplinas;

public class DisciplinaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerPrincipal;
	private JPanel disciplinas;
	private JTextField campoNome;
	private JTextField campoCodigo;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JButton botaoSalvar;
	private JButton botaoExcluir;
	private JButton botaoCancelar;
	private JTable tblPessoas;
	private JScrollPane scrlPessoas;
	private List<DisciplinaEntidade> listaDeDisciplinas;

	// @autor - Daniel Lima Leite

	private final int ALTURA_COMPONENTE = 30;
	private final int LARGURA_COMPONENTE_TEXTO = 300;
	private final int COORDENADA_MAIS_A_ESQUERDA = 30;
	private final int COORDENADA_MAIS_A_DIREITA = 365;

	DisciplinaEntidade cliente = new DisciplinaEntidade();
	Conexao con = new Conexao();
	DisciplinaController control = new DisciplinaController();

	public DisciplinaView() throws ClassNotFoundException, IOException {

		listaDeDisciplinas = new ArrayList<DisciplinaEntidade>();
		control.carregarDisciplinas(new ModelTableDisciplinas(listaDeDisciplinas));
		inicializaTela();
	}

	private void inicializaTela() throws IOException {
		containerPrincipal = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastro de Disciplinas");
		setBounds(0, 0, 700, 450);
		containerPrincipal = new JPanel();
		containerPrincipal.setLayout(null);

		disciplinas = new JPanel();
		disciplinas.setBounds(30, 180, 640, 210);
		disciplinas.setBorder(BorderFactory.createTitledBorder("Disciplinas"));
		disciplinas.setLayout(null);
		containerPrincipal.add(disciplinas);

		ModelTableDisciplinas modeloTabela = new ModelTableDisciplinas(listaDeDisciplinas);
		tblPessoas = new JTable(modeloTabela);
		scrlPessoas = new JScrollPane(tblPessoas);
		scrlPessoas.setBounds(10, 15, 620, 190);
		disciplinas.add(scrlPessoas);

		defineComponentesNaTela();
		defineEventoDoBotao(modeloTabela);
		add(containerPrincipal);
		setVisible(true);
	}

	private void defineEventoDoBotao(ModelTableDisciplinas modeloTabela) {

		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				List<DisciplinaEntidade> listaDeDisciplinas = new ArrayList<DisciplinaEntidade>();
				DisciplinaEntidade disciplina = new DisciplinaEntidade();
				DisciplinaController dc = new DisciplinaController();

				String codigo = campoCodigo.getText();
				String nome = campoNome.getText();

				disciplina.setCodigo(codigo);
				disciplina.setNome(nome);

				modeloTabela.addRows(disciplina);
				listaDeDisciplinas.add(disciplina);
				
				dc.salvarDisciplina(disciplina);

				limparCampos();
			}
		});

		tblPessoas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				// TODO Auto-generated method stub
				JTable table = (JTable) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

					campoCodigo.setText((String) tblPessoas.getValueAt(tblPessoas.getSelectedRow(), 0));
					campoNome.setText((String) tblPessoas.getValueAt(tblPessoas.getSelectedRow(), 1));

				}

			}

		});

	}

	private void limparCampos() {

		campoNome.setText("");
		campoCodigo.setText("");
		campoNome.requestFocus();

	}

	private void defineComponentesNaTela() {

		lblNome = new JLabel("Nome");
		lblNome.setBounds(30, 8, 50, 30);
		containerPrincipal.add(lblNome);

		campoNome = new JTextField();
		campoNome.setBounds(COORDENADA_MAIS_A_ESQUERDA, 30, LARGURA_COMPONENTE_TEXTO, ALTURA_COMPONENTE);
		containerPrincipal.add(campoNome);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(COORDENADA_MAIS_A_DIREITA, 8, 150, 30);
		containerPrincipal.add(lblCodigo);

		campoCodigo = new JTextField();
		campoCodigo.setBounds(COORDENADA_MAIS_A_DIREITA, 30, 120, ALTURA_COMPONENTE);
		containerPrincipal.add(campoCodigo);

		botaoSalvar = new JButton("salvar");
		botaoSalvar.setBounds(30, 60, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoSalvar);

		botaoExcluir = new JButton("excluir");
		botaoExcluir.setBounds(145, 60, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoExcluir);

		botaoCancelar = new JButton("cancelar");
		botaoCancelar.setBounds(260, 60, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoCancelar);


	}

}
