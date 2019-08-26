package view;

import controller.CursosController;
import entidades.CursoEntidade;

public class Aplicativo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CursoEntidade curso = new CursoEntidade("Sistema de Informação");
		CursosController cursoControl = new CursosController();
		
		cursoControl.salvarCliente(curso);
	}

}
