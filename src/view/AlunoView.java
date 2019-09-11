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
import controller.AlunoController;
import controller.DisciplinaController;
import entidades.AlunoEntidade;
import entidades.DisciplinaEntidade;
import entidades.PessoaEntidade;
import model.ModelTableAluno;

public class AlunoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel containerPrincipal;
	private JPanel alunos;
	private JPanel dadosAlunos;
	private JTextField campoNome;
	private JTextField matricula;
	private JTextField dataMatricula;
	private JTextField cpf;
	private JTextField sexo;
	private JTextField dataNascimento;
	private JTextField logradouro;
	private JTextField bairro;
	private JTextField cep;
	private JTextField numero;
	private JTextField complemento;
	private JTextField email;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblMatricula;
	private JButton botaoSalvar;
	private JButton botaoExcluir;
	private JButton botaoCancelar;
	private JTable tblPessoas;
	private JScrollPane scrlPessoas;
	private List<AlunoEntidade> listaDeAlunos;
	private List<PessoaEntidade> listaDePessoas;

	// @autor - Daniel Lima Leite

	private final int ALTURA_COMPONENTE = 30;
	private final int LARGURA_COMPONENTE_TEXTO = 300;
	private final int COORDENADA_MAIS_A_ESQUERDA = 30;
	private final int COORDENADA_MAIS_A_DIREITA = 365;

	AlunoEntidade cliente = new AlunoEntidade();
	Conexao con = new Conexao();
	AlunoController control = new AlunoController();

	public AlunoView() throws ClassNotFoundException, IOException {

		listaDeAlunos = new ArrayList<AlunoEntidade>();
		control.carregarAlunos(new ModelTableAluno(listaDeAlunos));
		inicializaTela();
	}

	private void inicializaTela() throws IOException {
		containerPrincipal = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("SISTEMA ACADEMICO");
		//setBounds(0, 0, 1200, 900);
		containerPrincipal = new JPanel();
		containerPrincipal.setLayout(null);

		alunos = new JPanel();
		alunos.setBounds(30, 450, 1300, 210);
		alunos.setBorder(BorderFactory.createTitledBorder("Alunos"));
		alunos.setLayout(null);
		containerPrincipal.add(alunos);
		
		dadosAlunos = new JPanel();
		dadosAlunos.setBounds(30, 63, 1300, 300);
		dadosAlunos.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));
		containerPrincipal.add(dadosAlunos);
		
		ModelTableAluno modeloTabela = new ModelTableAluno(listaDeAlunos);
		tblPessoas = new JTable(modeloTabela);
		scrlPessoas = new JScrollPane(tblPessoas);
		scrlPessoas.setBounds(10, 15, 1285, 190);
		alunos.add(scrlPessoas);

		defineComponentesNaTela();
		defineEventoDoBotao(modeloTabela);
		add(containerPrincipal);
		setVisible(true);
	}

	private void defineEventoDoBotao(ModelTableAluno modeloTabela) {

		botaoSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				List<AlunoEntidade> listaDeAlunos = new ArrayList<AlunoEntidade>();
				DisciplinaEntidade disciplina = new DisciplinaEntidade();
				DisciplinaController dc = new DisciplinaController();
				AlunoEntidade aluno = new AlunoEntidade();
				AlunoController ac = new AlunoController();

				String codigo = matricula.getText();
				String nome = campoNome.getText();

				disciplina.setCodigo(codigo);
				disciplina.setNome(nome);

				modeloTabela.addRows(aluno);
				listaDeAlunos.add(aluno);
				
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

					matricula.setText((String) tblPessoas.getValueAt(tblPessoas.getSelectedRow(), 0));
					campoNome.setText((String) tblPessoas.getValueAt(tblPessoas.getSelectedRow(), 1));

				}

			}

		});

	}

	private void limparCampos() {

		campoNome.setText("");
		matricula.setText("");
		campoNome.requestFocus();

	}

	private void defineComponentesNaTela() {

		lblNome = new JLabel("Nome");
		lblNome.setBounds(160, 8, 50, 30);
		containerPrincipal.add(lblNome);

		campoNome = new JTextField();
		campoNome.setBounds(160, 30, LARGURA_COMPONENTE_TEXTO, ALTURA_COMPONENTE);
		containerPrincipal.add(campoNome);

		lblCodigo = new JLabel("Matricula");
		lblCodigo.setBounds(30, 8, 150, 30);
		containerPrincipal.add(lblCodigo);

		matricula = new JTextField();
		matricula.setBounds(COORDENADA_MAIS_A_ESQUERDA, 30, 120, ALTURA_COMPONENTE);
		containerPrincipal.add(matricula);
		
		dataMatricula = new JTextField();
		dataMatricula.setBounds(470, 30, LARGURA_COMPONENTE_TEXTO, ALTURA_COMPONENTE);
		containerPrincipal.add(dataMatricula);
		
		lblMatricula = new JLabel("Data de Matrícula");
		lblMatricula.setBounds(470, 8, 150, 30);
		containerPrincipal.add(lblMatricula);
/*
		botaoSalvar = new JButton("salvar");
		botaoSalvar.setBounds(30, 63, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoSalvar);

		botaoExcluir = new JButton("excluir");
		botaoExcluir.setBounds(145, 60, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoExcluir);

		botaoCancelar = new JButton("cancelar");
		botaoCancelar.setBounds(260, 60, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoCancelar);
*/

	}

}
