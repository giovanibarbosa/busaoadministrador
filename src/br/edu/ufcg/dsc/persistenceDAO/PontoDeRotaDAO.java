package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.PontoDeRota;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;

public class PontoDeRotaDAO {
	private Connection conexao;
	private static PontoDeRotaDAO instancia;

	private PontoDeRotaDAO() throws SQLException {
		conexao = new ConnectionFactory().getConnection();
	}

	public static PontoDeRotaDAO getInstance() throws SQLException {
		if (instancia == null) {
			PontoDeRotaDAO p = new PontoDeRotaDAO();
			return p;
		}
		return instancia;
	}

	public void criar(PontoDeRota pontoDeRota) throws SQLException
			 {
		if (pontoDeRota == null)
			throw new IllegalArgumentException(
					"O PontoDeRota nao pode ser criado");

		String sql = "insert into pontoDeRota (id, latitude, longitude, rotaId) values (?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, pontoDeRota.getId());
		st.setDouble(2, pontoDeRota.getLatitude());
		st.setDouble(3, pontoDeRota.getLongitude());
		st.setString(4, pontoDeRota.getRotaId());

		st.execute();
		st.close();
	}

	public PontoDeRota recuperar(String identificador) throws SQLException
			 {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException(
					"O identificador do PontoDeRota deve ser valido");

		String sql = "select (id, latitude, longitude, rotaId) from pontoDeRota where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		PontoDeRota pontoDeRota = null;

		st.setInt(1, Integer.parseInt(identificador));
		ResultSet rs = st.executeQuery();
		List<PontoDeRota> pontoDeRotas = resultSetToList(rs);

		if (!pontoDeRotas.isEmpty())
			pontoDeRota = pontoDeRotas.get(0);
		st.close();
		return pontoDeRota;
	}

	private List<PontoDeRota> resultSetToList(ResultSet rs) throws SQLException {
		List<PontoDeRota> pontoDeRotas = new ArrayList<PontoDeRota>();
		PontoDeRota pontoDeRota = null;

		while (rs.next()) {
			pontoDeRota = new PontoDeRota(rs.getInt("id"),
					rs.getDouble("longitude"), rs.getDouble("latitude"),
					rs.getString("rotaId"));
			pontoDeRotas.add(pontoDeRota);
		}
		return pontoDeRotas;
	}

	public void atualizar(PontoDeRota pontoDeRota,
			PontoDeRota pontoDeRotaAtualizada) throws SQLException
			 {
		if (pontoDeRota == null || pontoDeRotaAtualizada == null)
			throw new IllegalArgumentException(
					"O PontoDeRota nao pode ser atualizado");

		String sql = "update pontoDeRota set id = ?, longitude = ?, latitude= ?, rotaId = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, pontoDeRotaAtualizada.getId());
		st.setDouble(2, pontoDeRotaAtualizada.getLongitude());
		st.setDouble(3, pontoDeRotaAtualizada.getLatitude());
		st.setString(4, pontoDeRotaAtualizada.getRotaId());
		st.setInt(5, pontoDeRota.getId());

		st.executeUpdate();
		st.close();
	}

	public void deletar(PontoDeRota pontoDeRota) throws SQLException
			 {
		if (pontoDeRota == null)
			throw new IllegalArgumentException();

		String sql = "delete from pontoDeRota where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setInt(1, pontoDeRota.getId());

		st.execute();
		st.close();
	}

	public List<PontoDeRota> listarTodas() throws SQLException {
		String sql = "select * from pontoDeRota";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}
}
