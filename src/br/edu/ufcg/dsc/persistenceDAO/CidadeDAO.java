package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;

public class CidadeDAO {
	private Connection conexao;
	private static CidadeDAO instancia;

	private CidadeDAO() throws SQLException {
		conexao = new ConnectionFactory().getConnection();
	}

	public static CidadeDAO getInstance() throws SQLException {
		if (instancia == null) {
			CidadeDAO cid = new CidadeDAO();
			return cid;
		}
		return instancia;
	}

	public void criar(Cidade cidade) throws SQLException {
		//String sql = "insert into cidade (nome, estado, valorTarifa, latitude, longitude) values (?,?,?,?,?)";
	}

	public Cidade recuperar(String identificador) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Cidade cidade, Cidade cidadeAtualizada)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	public void deletar(Cidade cidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	public List<Cidade> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
