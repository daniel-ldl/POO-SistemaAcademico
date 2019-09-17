package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import connection.Conexao;
import controller.AlunoController;
import controller.CursosController;
import controller.MunicipioController;
import controller.PessoaController;
import entidades.AlunoEntidade;
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
	private JPanel JPsexo;
	private JTextField campoNome;
	private JTextField matricula;
	private JFormattedTextField dataMatricula;
	private JFormattedTextField cpf;
	private JTextField sexo;
	private JFormattedTextField dataNascimento;
	private JTextField logradouro;
	private JTextField bairro;
	private JTextField cep;
	private JTextField numero;
	private JTextField complemento;
	private JTextField email;
	private JLabel lblNome;
	private JLabel lblCodigo;
	private JLabel lblMatricula;
	private JLabel lblCpf;
	private JLabel lblLogradouro;
	private JLabel lblDataNascimento;
	private JLabel lblBairro;
	private JLabel lblMunicipio;
	private JLabel lblEmail;
	private JLabel lblCep;
	private JLabel lblSexo;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JButton botaoSalvar;
	private JButton botaoExcluir;
	private JButton botaoCancelar;
	private ButtonGroup agrupar;
	private JRadioButton sexoFeminino;
	private JRadioButton sexoMasculino;
	private JComboBox estado;
	private JComboBox cidade;
	private JComboBox curso;
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
	MunicipioController mC = new MunicipioController();
	CursosController cC = new CursosController();

	public AlunoView() throws ClassNotFoundException, IOException, ParseException, SQLException {

		listaDeAlunos = new ArrayList<AlunoEntidade>();
		// control.carregarAlunos(new ModelTableAluno(listaDeAlunos));
		inicializaTela();
		mC.resgataMunicipios(cidade);
		mC.resgataEstados(estado);
		cC.carregarCursos(curso);
	}

	private void inicializaTela() throws IOException, ParseException {
		containerPrincipal = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Cadastro de Alunos");
		// setBounds(0, 0, 1200, 900);
		containerPrincipal = new JPanel();
		containerPrincipal.setLayout(null);

		alunos = new JPanel();
		alunos.setBounds(30, 350, 1300, 350);
		alunos.setBorder(BorderFactory.createTitledBorder("Alunos"));
		alunos.setLayout(null);
		containerPrincipal.add(alunos);

		dadosAlunos = new JPanel();
		dadosAlunos.setBounds(30, 63, 1300, 200);
		dadosAlunos.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));
		dadosAlunos.setLayout(null);
		containerPrincipal.add(dadosAlunos);

		ModelTableAluno modeloTabela = new ModelTableAluno(listaDeAlunos);
		tblPessoas = new JTable(modeloTabela);
		scrlPessoas = new JScrollPane(tblPessoas);
		scrlPessoas.setBounds(10, 15, 1285, 330);
		alunos.add(scrlPessoas);

		defineComponentesNaTela();
		defineComponentesNoPanelAluno();
		defineEventoDosBotoes(modeloTabela);
		add(containerPrincipal);
		setVisible(true);
	}

	private void limparCampos() {

		campoNome.setText("");
		matricula.setText("");
		dataMatricula.setText("");
		cpf.setText("");
		sexo.setText("");
		dataNascimento.setText("");
		logradouro.setText("");
		bairro.setText("");
		cep.setText("");
		numero.setText("");
		complemento.setText("");
		email.setText("");

	}

	private void defineComponentesNaTela() throws ParseException {

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

		dataMatricula = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataMatricula.setBounds(470, 30, LARGURA_COMPONENTE_TEXTO, ALTURA_COMPONENTE);
		containerPrincipal.add(dataMatricula);

		lblMatricula = new JLabel("Data de Matrícula");
		lblMatricula.setBounds(470, 8, 150, 30);
		containerPrincipal.add(lblMatricula);

		JPsexo = new JPanel();
		JPsexo.setBounds(850, 9, 150, 65);
		JPsexo.setBorder(BorderFactory.createTitledBorder("Sexo"));
		JPsexo.setLayout(null);
		dadosAlunos.add(JPsexo);

		agrupar = new ButtonGroup();
		sexoMasculino = new JRadioButton("M");
		sexoMasculino.setBounds(20, 15, 40, 40);
		agrupar.add(sexoMasculino);
		JPsexo.add(sexoMasculino);

		sexoFeminino = new JRadioButton("F");
		sexoFeminino.setBounds(80, 15, 40, 40);
		agrupar.add(sexoFeminino);
		JPsexo.add(sexoFeminino);

		botaoSalvar = new JButton("salvar");
		botaoSalvar.setBounds(30, 290, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoSalvar);

		botaoExcluir = new JButton("excluir");
		botaoExcluir.setBounds(150, 290, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoExcluir);

		botaoCancelar = new JButton("cancelar");
		botaoCancelar.setBounds(270, 290, 100, ALTURA_COMPONENTE);
		containerPrincipal.add(botaoCancelar);

	}

	private void defineComponentesNoPanelAluno() throws ParseException {

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(8, 15, 150, 30);
		dadosAlunos.add(lblCpf);

		cpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		cpf.setBounds(8, 42, 200, ALTURA_COMPONENTE);
		dadosAlunos.add(cpf);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(215, 15, 150, 30);
		dadosAlunos.add(lblEmail);

		email = new JTextField();
		email.setBounds(215, 42, 400, ALTURA_COMPONENTE);
		dadosAlunos.add(email);

		lblDataNascimento = new JLabel("Data de Nascimento");
		lblDataNascimento.setBounds(625, 15, 150, 30);
		dadosAlunos.add(lblDataNascimento);

		dataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		dataNascimento.setBounds(625, 42, 200, ALTURA_COMPONENTE);
		dadosAlunos.add(dataNascimento);

		lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(8, 75, 150, 30);
		dadosAlunos.add(lblLogradouro);

		logradouro = new JTextField();
		logradouro.setBounds(8, 99, 400, ALTURA_COMPONENTE);
		dadosAlunos.add(logradouro);

		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(425, 75, 150, 30);
		dadosAlunos.add(lblBairro);

		bairro = new JTextField();
		bairro.setBounds(425, 99, 300, ALTURA_COMPONENTE);
		dadosAlunos.add(bairro);

		estado = new JComboBox();
		estado.setBounds(750, 99, 150, ALTURA_COMPONENTE);
		estado.addItem("--Selecione o Estado--");
		dadosAlunos.add(estado);

		cidade = new JComboBox();
		cidade.setBounds(925, 99, 150, ALTURA_COMPONENTE);
		cidade.addItem("--Selecione a Cidade--");
		dadosAlunos.add(cidade);
		
		curso = new JComboBox();
		curso.setBounds(1100, 99, 150, ALTURA_COMPONENTE);
		curso.addItem("--Selecione o Curso");
		dadosAlunos.add(curso);

		lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(8, 135, 150, 30);
		dadosAlunos.add(lblComplemento);

		complemento = new JTextField();
		complemento.setBounds(8, 160, 500, ALTURA_COMPONENTE);
		dadosAlunos.add(complemento);

		lblCep = new JLabel("CEP");
		lblCep.setBounds(525, 135, 150, 30);
		dadosAlunos.add(lblCep);

		cep = new JTextField();
		cep.setBounds(525, 160, 100, ALTURA_COMPONENTE);
		dadosAlunos.add(cep);

		lblNumero = new JLabel("Número");
		lblNumero.setBounds(640, 135, 150, 30);
		dadosAlunos.add(lblNumero);

		numero = new JTextField();
		numero.setBounds(640, 160, 80, ALTURA_COMPONENTE);
		dadosAlunos.add(numero);
	}

	private void defineEventoDosBotoes(ModelTableAluno modeloTabela) {
		
		botaoSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				AlunoEntidade aluno = new AlunoEntidade();
				AlunoController ac = new AlunoController();
				PessoaEntidade pessoa = new PessoaEntidade();
				PessoaController pc = new PessoaController();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar data_Nascimento = Calendar.getInstance();
				Calendar data_Matricula = Calendar.getInstance();
				
				SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    data_Nascimento.setTime(fmt.parse(dataNascimento.getText()));
                    data_Matricula.setTime(fmt.parse(dataMatricula.getText()));
                } catch (ParseException ex) {
                   
                }
				
				aluno.setMatricula(matricula.getText());
				aluno.setDataMatriculaInstituicao(data_Matricula);
				pessoa.setBairro(bairro.getText());
				pessoa.setCep(cep.getText());
				pessoa.setComplemento(complemento.getText());
				pessoa.setCpf(cpf.getText());
				pessoa.setDataNascimento(data_Nascimento);
				pessoa.setEmail(email.getText());
				pessoa.setLogradouro(logradouro.getText());
				pessoa.setNome(campoNome.getText());
				pessoa.setNumero(Integer.parseInt(numero.getText()));
				
				String sexo;
				
				if(sexoMasculino.isSelected()) {
					sexo = "M";
				}else {
					sexo = "F";
				}
				
				pessoa.setSexo(sexo);
				
				ac.salvarAluno(aluno);
				pc.salvarPessoa(pessoa);
				
			}
		});
		
	}

}
