package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MenuView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel container;
	private JMenuBar jmbPrincipal;
	private JMenu jmDisciplina;
	private JMenu jmAluno;
	private JMenu jmProfessor;
	private JMenu jmCurso;
	private JMenu jmGrade;
	private JMenuItem jmiCadastraDisciplinas;
	private JMenuItem jmiListaDisciplinas;
	private JMenuItem jmiCadastrarAlunos;
	private JMenuItem jmiListarAlunos;
	private JMenuItem jmiCadastraProfessor;
	private JMenuItem jmiListarProfessor;
	private JMenuItem jmiCadastraCurso;
	private JMenuItem jmiListarCurso;
	private JMenuItem jmiCadastraGrade;
	private JMenuItem jmiListarGrade;

	// @autor - Daniel Lima Leite

	public MenuView() {

		inicializaTela();
	}

	private void inicializaTela() {

		container = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema Academico");
		setBounds(0, 0, 700, 450);
		container.setLayout(null);
		jmbPrincipal = new JMenuBar();
		setJMenuBar(jmbPrincipal);
		defineMenu();
		defineAcaoDoMenu();
		setVisible(true);

	}

	private void defineMenu() {

		jmDisciplina = new JMenu("Disciplinas");
		jmAluno = new JMenu("Alunos");
		jmCurso = new JMenu("Curso");
		jmProfessor = new JMenu("Professor");
		jmGrade = new JMenu("Grade");

		jmbPrincipal.add(jmDisciplina);
		jmbPrincipal.add(jmAluno);
		jmbPrincipal.add(jmProfessor);
		jmbPrincipal.add(jmCurso);
		jmbPrincipal.add(jmGrade);

		// Define itens do menu disciplina
		jmiCadastraDisciplinas = new JMenuItem("Cadastrar");
		jmiListaDisciplinas = new JMenuItem("Listar");
		jmDisciplina.add(jmiCadastraDisciplinas);
		jmDisciplina.add(jmiListaDisciplinas);

		// Define itens do menu aluno
		jmiCadastrarAlunos = new JMenuItem("Cadastrar");
		jmiListarAlunos = new JMenuItem("Listar");
		jmAluno.add(jmiCadastrarAlunos);
		jmAluno.add(jmiListarAlunos);

		// Defini itens do menu professor
		jmiCadastraProfessor = new JMenuItem("Cadastrar");
		jmiListarProfessor = new JMenuItem("Listar");
		jmProfessor.add(jmiCadastraProfessor);
		jmProfessor.add(jmiListarProfessor);

		// Defini itens do menu grade
		jmiCadastraGrade = new JMenuItem("Cadastrar");
		jmiListarGrade = new JMenuItem("Listar");
		jmGrade.add(jmiCadastraGrade);
		jmGrade.add(jmiListarGrade);

		// Defini itens do menu curso
		jmiCadastraCurso = new JMenuItem("Cadastrar");
		jmiListarCurso = new JMenuItem("Listar");
		jmCurso.add(jmiCadastraCurso);
		jmCurso.add(jmiListarCurso);
	}

	private void defineAcaoDoMenu() {

		jmiCadastraDisciplinas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DisciplinaView disciplina;
				try {
					disciplina = new DisciplinaView();
					disciplina.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();
			}
		});

		jmiCadastrarAlunos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AlunoView aluno;

				try {
					aluno = new AlunoView();
					aluno.setVisible(true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				dispose();
			}

		});

	}

	public static void main(String[] args) {
		new MenuView();
	}
}
