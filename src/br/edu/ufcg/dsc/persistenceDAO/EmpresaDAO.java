package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;

public class EmpresaDAO {
	private Connection conexao;
	private static EmpresaDAO instancia;

	private EmpresaDAO() throws SQLException {
		conexao = new ConnectionFactory().getConnection();
	}

	public static EmpresaDAO getInstance() throws SQLException {
		if (instancia == null) {
			EmpresaDAO emp = new EmpresaDAO();
			return emp;
		}
		return instancia;
	}

	public void criar(Empresa empresa) throws SQLException,
			IllegalArgumentException {
		if (empresa == null)
			throw new IllegalArgumentException("Empresa nao foi criada");

		String sql = "insert into empresa (id, nome, anoDeFundacao, cidadeId) values (?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, empresa.getIdentificador());
		st.setString(2, empresa.getNome());
		st.setInt(3, empresa.getAnoFundacao());
		st.setInt(4, empresa.getCidadeId());

		st.execute();
		st.close();
	}

	public Empresa recuperar(String identificador) throws SQLException,
			IllegalArgumentException {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException("O identificador da Empresa deve ser valido");

		String sql = "select (nome, anoDeFundacao, cidadeId) from empresa where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		Empresa empresa = null;

		st.setInt(1, Integer.parseInt(identificador));
		ResultSet rs = st.executeQuery();
		List<Empresa> empresas = resultSetToList(rs);

		if (!empresas.isEmpty())
			empresa = empresas.get(0);
		st.close();
		return empresa;
	}

	private List<Empresa> resultSetToList(ResultSet rs) throws SQLException {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;

		while (rs.next()) {
			empresa = new Empresa(rs.getInt("id"), rs.getString("nome"),
					rs.getInt("anoDeFundacao"), rs.getInt("cidadeId"));
			empresas.add(empresa);
		}
		return empresas;
	}

	public void atualizar(Empresa empresa, Empresa empresaAtualizada)
			throws SQLException, IllegalArgumentException {
		if (empresa == null || empresaAtualizada == null)
			throw new IllegalArgumentException("A Empresa nao pode ser atualizada");

		String sql = "update empresa set id = ?, nome = ?, anoDeFundacao = ?, cidadeId = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, empresaAtualizada.getIdentificador());
		st.setString(2, empresaAtualizada.getNome());
		st.setInt(3, empresaAtualizada.getAnoFundacao());
		st.setInt(4, empresaAtualizada.getCidadeId());
		st.setInt(5, empresa.getIdentificador());

		st.executeUpdate();
		st.close();
	}

	public void deletar(Empresa empresa) throws SQLException,
			IllegalArgumentException {
		if (empresa == null)
			throw new IllegalArgumentException("A Empresa nao pode ser removida");

		String sql = "delete from empresa where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, empresa.getIdentificador());

		st.execute();
		st.close();
	}

	public List<Empresa> listarTodas() throws SQLException {
		String sql = "select * from empresa";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}
	
	

}
