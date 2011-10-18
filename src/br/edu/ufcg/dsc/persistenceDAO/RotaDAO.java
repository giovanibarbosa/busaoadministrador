package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.PontoDeRota;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;


public class RotaDAO {
	private Connection conexao;
	private static RotaDAO instancia;

	public RotaDAO() throws SQLException {

		try {
			conexao = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static RotaDAO getInstance() throws SQLException {
		if (instancia == null) {
			RotaDAO rota = new RotaDAO();
			return rota;
		}
		return instancia;
	}

	public void criar(Rota rota) throws SQLException, IllegalArgumentException {
		if (rota == null)
			throw new IllegalArgumentException("Rota nao foi criada");

		String sql = "insert into rota (id,via, cor, numeroVisualizacao, diferencaEntreOnibus, "
				+ "tempoPercursoTotal, horaInicio, horaTermino, urlRota, empresaId, numOnibus) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rota.getIdentificador());
		st.setString(2, rota.getVia());
		st.setString(3, rota.getCor());
		st.setInt(4, rota.getNumeroVisualizacao());
		st.setInt(5, rota.getHorario().getDiferencaEntreOnibus());
		st.setInt(6, rota.getHorario().getTempoPercursoTotal());
		st.setTime(7, rota.getHorario().getHoraInicio());
		st.setTime(8, rota.getHorario().getHoraTermino());
		st.setString(9, rota.getUrlRota());
		st.setInt(10, rota.getEmpresaId());
		st.setInt(11, rota.getNumeroDoOnibus());

		st.execute();
		st.close();
	}

	public Rota recuperar(String identificador) throws SQLException,
			IllegalArgumentException {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException(
					"O identificador da Rota deve ser valido");

		String sql = "select (id, via, cor, numeroVisualizacao, diferencaEntreOnibus, "
				+ "tempoPercursoTotal, horaInicio, horaTermino, "
				+ "urlRota, empresaId, numOnibus) from rota where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);
		Rota rota = null;

		st.setString(1, identificador);
		ResultSet rs = st.executeQuery();
		List<Rota> rotas = resultSetToList(rs);

		if (!rotas.isEmpty())
			rota = rotas.get(0);
		st.close();
		return rota;
	}

	private List<Rota> resultSetToList(ResultSet rs) throws SQLException {
		List<Rota> rotas = new ArrayList<Rota>();
		Rota rota = null;

		while (rs.next()) {
			rota = new Rota(rs.getString("id"), rs.getString("cor"),
					rs.getInt("numeroVisualizacao"), new Horario(
							rs.getInt("diferencaEntreOnibus"),
							rs.getInt("tempoPercursoTotal"), 
									rs.getTime("horaInicio"),
									rs.getTime("horaTermino")
									),
					rs.getInt("empresaId"), rs.getString("urlRota"),
					rs.getInt("numOnibus"), rs.getString("via"));
			rotas.add(rota);
		}
		return rotas;
	}

	public void atualizar(Rota rota, Rota rotaAtualizada) throws SQLException,
			IllegalArgumentException {
		if (rota == null || rotaAtualizada == null)
			throw new IllegalArgumentException("A Rota nao pode ser atualizada");

		String sql = "upTime rota set id = ?, via = ?, cor = ?, numeroVisualizacao = ?,  "
				+ "diferencaEntreOnibus = ?, tempoPercursoTotal = ?, horaInicio = ?, "
				+ "horaTermino = ?, urlRota = ?, empresaId = ?,numOnibus=? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rotaAtualizada.getIdentificador());
		st.setString(2, rotaAtualizada.getCor());
		st.setString(3, rotaAtualizada.getVia());
		st.setInt(4, rotaAtualizada.getNumeroVisualizacao());
		st.setInt(5, rotaAtualizada.getEmpresaId());
		st.setInt(6, rotaAtualizada.getHorario().getDiferencaEntreOnibus());
		st.setInt(7, rotaAtualizada.getHorario().getTempoPercursoTotal());
		st.setTime(8, rotaAtualizada.getHorario().getHoraInicio());
		st.setTime(9, rotaAtualizada.getHorario().getHoraTermino());
		st.setString(10, rotaAtualizada.getUrlRota());
		st.setInt(11, rotaAtualizada.getNumeroDoOnibus());
		st.setString(12, rota.getIdentificador());

		st.executeUpdate();
		st.close();
	}

	public void deletar(Rota rota) throws SQLException,
			IllegalArgumentException {
		if (rota == null)
			throw new IllegalArgumentException("A Rota nao pode ser removida");

		String sql = "delete from rota where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rota.getIdentificador());

		st.execute();
		st.close();
	}

	public List<Rota> listarTodas() throws SQLException {
		String sql = "select * from rota";
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToList(st.executeQuery());
	}

	public boolean adicionaOnibus(Rota rota, Onibus onibus)
			throws IllegalArgumentException, SQLException {
		if (rota == null || onibus == null)
			throw new IllegalArgumentException("Empresa ou Cidade inválida");
		String sql = "upTime onibus set rotaId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (!recuperaOnibuss(rota).contains(onibus)) {
			st.setString(1, rota.getIdentificador());
			st.setString(2, onibus.getIdentificador());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}

	public List<Onibus> recuperaOnibuss(Rota rota) throws SQLException,
			IllegalArgumentException {
		if (rota == null)
			throw new IllegalArgumentException("Rota inválida");
		String sql = "select * from onibus where rotaId=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rota.getIdentificador());
		ResultSet rs = st.executeQuery();
		List<Onibus> onibuss = resultSetToOnibusList(rs);

		st.close();
		return onibuss;
	}

	private List<Onibus> resultSetToOnibusList(ResultSet rs)
			throws SQLException {
		List<Onibus> onibuss = new ArrayList<Onibus>();
		Onibus onibus = null;

		while (rs.next()) {
			onibus = new Onibus(rs.getString("id"), rs.getInt("capacidade"),
					rs.getString("rotaId"));
			onibuss.add(onibus);
		}
		return onibuss;
	}

	public boolean removeOnibus(Onibus onibus, Rota rota)
			throws IllegalArgumentException, SQLException {
		if (onibus == null || rota == null)
			throw new IllegalArgumentException("Onibus ou Rota inválida");
		String sql = "upTime onibus set rotaId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (recuperaOnibuss(rota).contains(onibus)) {
			st.setObject(1, null);
			st.setString(2, onibus.getIdentificador());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}

	public boolean adicionaPonto(PontoDeRota ponto, Rota rota)
			throws IllegalArgumentException, SQLException {
		if (rota == null || ponto == null)
			throw new IllegalArgumentException("Rota ou Ponto inválido");
		String sql = "upTime pontoDeRota set rotaId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (!recuperaPontos(rota).contains(rota)) {
			st.setString(1, rota.getIdentificador());
			st.setInt(2, ponto.getId());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}

	public List<PontoDeRota> recuperaPontos(Rota rota) throws SQLException {
		if (rota == null)
			throw new IllegalArgumentException("Rota inválida");
		String sql = "select * from pontoDeRota where rotaId=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rota.getIdentificador());
		ResultSet rs = st.executeQuery();
		List<PontoDeRota> pontos = resultSetToPontoList(rs);

		st.close();
		return pontos;
	}

	private List<PontoDeRota> resultSetToPontoList(ResultSet rs)
			throws SQLException {
		List<PontoDeRota> pontos = new ArrayList<PontoDeRota>();
		PontoDeRota pontoDeRota = null;

		while (rs.next()) {
			pontoDeRota = new PontoDeRota(rs.getInt("id"),
					rs.getDouble("longitude"), rs.getDouble("latitude"),
					rs.getString("rotaId"));
			pontos.add(pontoDeRota);
		}
		return pontos;
	}

	public boolean removePonto(PontoDeRota ponto, Rota rota)
			throws IllegalArgumentException, SQLException {
		if (ponto == null || rota == null)
			throw new IllegalArgumentException("Ponto ou Rota inválida");
		String sql = "upTime pontoDeRota set rotaId=? where id=?";
		PreparedStatement st = conexao.prepareStatement(sql);

		if (recuperaPontos(rota).contains(ponto)) {
			st.setObject(1, null);
			st.setInt(2, ponto.getId());
			st.executeUpdate();
			st.close();
			return true;
		}

		st.close();
		return false;
	}
//	public static void main(String[] args) {
//		Rota r = new Rota("903","","Azul", "903",);
//	}
}
