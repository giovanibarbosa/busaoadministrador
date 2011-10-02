package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Cidade;
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

		st.setString(1, cidade.getNome());
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
			throw new IllegalArgumentException("O idenificador da Cidade deve ser valido ");

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
	
	//pesquisa cidade
	//A partir da chava primaria. Acessa o nome da cidade e retorna.
	public String recuperarCidadePorId(int id){
		//TODO
		return "";
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

	public void atualizar(Cidade cidade, Cidade cidadeAtualizada)
			throws SQLException, IllegalArgumentException {
		if (cidade == null || cidadeAtualizada == null)
			throw new IllegalArgumentException("A Cidade nao pode ser atualizada");

		String sql = "update cidade set nome = ?, valorTarifa = ?, estado = ?, latitude = ?, longitude = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, cidadeAtualizada.getNome());
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

	public List<Cidade> listarTodas() throws SQLException {
		String sql = "select * from cidade";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}
}
