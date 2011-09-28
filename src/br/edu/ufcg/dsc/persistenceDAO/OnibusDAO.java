package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;

public class OnibusDAO {
	private Connection conexao;
	private static OnibusDAO instancia;

	private OnibusDAO() throws SQLException {
		conexao = new ConnectionFactory().getConnection();
	}

	public static OnibusDAO getInstance() throws SQLException {
		if (instancia == null) {
			OnibusDAO bus = new OnibusDAO();
			return bus;
		}
		return instancia;
	}

	public void criar(Onibus onibus) throws SQLException,
			IllegalArgumentException {
		if (onibus == null)
			throw new IllegalArgumentException("O Onibus nao pode ser criado");

		String sql = "insert into onibus (id, capacidade, rotaId) values (?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, onibus.getIdentificador());
		st.setInt(2, onibus.getCapacidade());
		st.setInt(3, onibus.getRotaId());

		st.execute();
		st.close();
	}

	public Onibus recuperar(String identificador) throws SQLException,
			IllegalArgumentException {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException("O identificador do Onibus deve ser valido");

		String sql = "select (id, capacidade, rotaId) from onibus where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		Onibus onibus = null;

		st.setString(1, identificador);
		ResultSet rs = st.executeQuery();
		List<Onibus> onibuss = resultSetToList(rs);

		if (!onibuss.isEmpty())
			onibus = onibuss.get(0);
		st.close();
		return onibus;
	}

	private List<Onibus> resultSetToList(ResultSet rs) throws SQLException {
		List<Onibus> onibuss = new ArrayList<Onibus>();
		Onibus onibus = null;

		while (rs.next()) {
			onibus = new Onibus(rs.getString("id"), rs.getInt("capacidade"), rs.getInt("rotaId"));
			onibuss.add(onibus);
		}
		return onibuss;
	}

	public void atualizar(Onibus onibus, Onibus onibusAtualizada)
			throws SQLException, IllegalArgumentException {
		if (onibus == null || onibusAtualizada == null)
			throw new IllegalArgumentException("O Onibus nao pode ser atualizado");

		String sql = "update onibus set id = ?, capacidade = ?, rotaId = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, onibusAtualizada.getIdentificador());
		st.setInt(2, onibusAtualizada.getCapacidade());
		st.setInt(3, onibusAtualizada.getRotaId());
		st.setString(4, onibus.getIdentificador());

		st.executeUpdate();
		st.close();
	}

	public void deletar(Onibus onibus) throws SQLException,
			IllegalArgumentException {
		if (onibus == null)
			throw new IllegalArgumentException();

		String sql = "delete from onibus where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, onibus.getIdentificador());

		st.execute();
		st.close();
	}

	public List<Onibus> listarTodas() throws SQLException {
		String sql = "select * from onibus";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}
}
