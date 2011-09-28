package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Usuario;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;

public class UsuarioDAO {
	private Connection conexao;
	private static UsuarioDAO instancia;

	private UsuarioDAO() throws SQLException {
		conexao = new ConnectionFactory().getConnection();
	}

	public static UsuarioDAO getInstance() throws SQLException {
		if (instancia == null) {
			UsuarioDAO usr = new UsuarioDAO();
			return usr;
		}
		return instancia;
	}

	public Usuario recuperar() throws SQLException,
			IllegalArgumentException {
		String sql = "select * from usuario";
		PreparedStatement st = conexao.prepareStatement(sql);
		Usuario usuario = null;

		ResultSet rs = st.executeQuery();
		List<Usuario> usuarios = resultSetToList(rs);

		if (!usuarios.isEmpty())
			usuario = usuarios.get(0);
		st.close();
		return usuario;
	}

	private List<Usuario> resultSetToList(ResultSet rs) throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = null;

		while (rs.next()) {
			usuario = new Usuario(rs.getString("login"), rs.getString("senha"));
			usuarios.add(usuario);
		}
		return usuarios;
	}

}
