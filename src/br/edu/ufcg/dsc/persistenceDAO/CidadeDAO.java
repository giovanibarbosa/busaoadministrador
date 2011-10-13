package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Ponto;
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

	public void criar(Cidade cidade) throws SQLException,
			IllegalArgumentException {
		if (cidade == null)
			throw new IllegalArgumentException("Cidade nao foi criada");

		String sql = "insert into cidade (nome, estado, valorTarifa, latitude, longitude) values (?,?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, cidade.getNome().toLowerCase());
		st.setString(2, cidade.getEstado());
		st.setDouble(3, cidade.getValorTarifa());
		st.setDouble(4, cidade.getPonto().getLatitude());
		st.setDouble(5, cidade.getPonto().getLongitude());

		st.execute();
		st.close();
	}

	public Cidade recuperar(String identificador) throws SQLException,
			IllegalArgumentException {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException(
					"O idenificador da Cidade deve ser valido ");

		String sql = "select (nome, estado, valorTarifa, latitude, longitude) from cidade where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		Cidade cidade = null;

		st.setInt(1, Integer.parseInt(identificador));
		ResultSet rs = st.executeQuery();
		List<Cidade> cidades = resultSetToList(rs);

		if (!cidades.isEmpty())
			cidade = cidades.get(0);
		st.close();
		return cidade;
	}

	public Cidade recuperarCidadePorNome(String nome) throws SQLException,
			IllegalArgumentException {
		if (nome == null)
			throw new IllegalArgumentException(
					"O nome da Cidade deve ser valido ");

		String sql = "select * from cidade where nome=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		Cidade cidade = null;

		nome.toLowerCase();
		st.setString(1, nome);
		ResultSet rs = st.executeQuery();
		List<Cidade> cidades = resultSetToList(rs);

		if (!cidades.isEmpty())
			cidade = cidades.get(0);
		st.close();
		return cidade;
	}

	private List<Cidade> resultSetToList(ResultSet rs) throws SQLException {
		List<Cidade> cidades = new ArrayList<Cidade>();
		Cidade cidade = null;

		while (rs.next()) {
			cidade = new Cidade(rs.getInt("id"), rs.getDouble("valorTarifa"),
					rs.getString("nome"), rs.getString("estado"),
					new Ponto(rs.getDouble("latitude"), rs
							.getDouble("longitude")));
			cidades.add(cidade);
		}
		return cidades;
	}

	private List<Empresa> resultSetToEmpresaList(ResultSet rs)
			throws SQLException {
		List<Empresa> empresas = new ArrayList<Empresa>();
		Empresa empresa = null;

		while (rs.next()) {
			empresa = new Empresa(rs.getInt("id"), rs.getString("nome"),
					rs.getInt("anoDeFundacao"), rs.getInt("cidadeId"));
			empresas.add(empresa);
		}
		return empresas;
	}

	public void atualizar(Cidade cidade, Cidade cidadeAtualizada)
			throws SQLException, IllegalArgumentException {
		if (cidade == null || cidadeAtualizada == null)
			throw new IllegalArgumentException(
					"A Cidade nao pode ser atualizada");

		String sql = "update cidade set nome = ?, valorTarifa = ?, estado = ?, latitude = ?, longitude = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, cidadeAtualizada.getNome().toLowerCase());
		st.setDouble(2, cidadeAtualizada.getValorTarifa());
		st.setString(3, cidadeAtualizada.getEstado());
		st.setDouble(4, cidadeAtualizada.getPonto().getLatitude());
		st.setDouble(5, cidadeAtualizada.getPonto().getLongitude());
		st.setInt(6, cidade.getIdentificacao());

		st.executeUpdate();
		st.close();
	}

	public void deletar(Cidade cidade) throws SQLException,
			IllegalArgumentException {
		if (cidade == null)
			throw new IllegalArgumentException("A Cidade nao pode ser removida");

		String sql = "delete from cidade where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, cidade.getIdentificacao());

		st.execute();
		st.close();
	}

	private List<Empresa> recuperaEmpresas(Cidade cidade) throws SQLException,
			IllegalArgumentException {
		if (cidade == null)
			throw new IllegalArgumentException("Cidade inválida");
		String sql = "select * from empresa where cidadeId=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, cidade.getIdentificacao());
		ResultSet rs = st.executeQuery();
		List<Empresa> empresas = resultSetToEmpresaList(rs);

		st.close();
		return empresas;
	}

	public boolean adicionaEmpresa(Empresa empresa, Cidade cidade)
			throws IllegalArgumentException, SQLException {
		if (empresa == null || cidade == null)
			throw new IllegalArgumentException("Empresa ou Cidade inválida");
		String sql = "update empresa set cidadeId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (!recuperaEmpresas(cidade).contains(empresa)) {
			st.setInt(1, cidade.getIdentificacao());
			st.setInt(2, empresa.getIdentificador());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}

	/**
	 * Metodo para remover uma empresa da Cidade apenas, nao removendo esta
	 * empresa do banco de dados
	 * 
	 * @param empresa
	 * @param cidade
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 */
	public boolean removeEmpresa(Empresa empresa, Cidade cidade)
			throws IllegalArgumentException, SQLException {
		if (empresa == null || cidade == null)
			throw new IllegalArgumentException("Empresa ou Cidade inválida");
		String sql = "update empresa set cidadeId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (recuperaEmpresas(cidade).contains(empresa)) {
			st.setObject(1, null);
			st.setInt(2, empresa.getIdentificador());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}

	public List<Cidade> listarTodas() throws SQLException {
		String sql = "select * from cidade";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}
}
