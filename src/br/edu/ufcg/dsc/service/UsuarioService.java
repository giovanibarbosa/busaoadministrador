package br.edu.ufcg.dsc.service;

import java.sql.SQLException;

import br.edu.ufcg.dsc.bean.Usuario;
import br.edu.ufcg.dsc.persistenceDAO.UsuarioDAO;



public class UsuarioService {
	private static UsuarioService instanciaUnica;
	private UsuarioDAO ud;

	private UsuarioService() throws SQLException {
		ud = UsuarioDAO.getInstance();
	}

	public static UsuarioService getInstance() throws SQLException {

		if (instanciaUnica == null) {
			UsuarioService gc = new UsuarioService();
			instanciaUnica = gc;
		}

		return instanciaUnica;

	}
	
	public void adicionar(Usuario u) throws SQLException{
		ud.cadastrar(u);
	}
	

}
