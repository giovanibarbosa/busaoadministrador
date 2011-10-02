package br.edu.ufcg.dsc.persistenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.persistenceFactory.ConnectionFactory;
import br.edu.ufcg.dsc.util.Tempo;

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

		String sql = "insert into rota (id, cor, numeroVisualizacao, empresaId, diferencaEntreOnibus, "
				+ "tempoPercusoTotal, horaInicio, minutoInicio, horaTermino, minutoTermino, urlRota) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rota.getIdentificador());
		st.setString(2, rota.getCor());
		st.setInt(3, rota.getNumeroVisualizacao());
		st.setInt(4, rota.getEmpresaId());
		st.setInt(5, rota.getHorario().getDiferencaEntreOnibus());
		st.setInt(6, rota.getHorario().getTempoPercursoTotal());
		st.setInt(7, rota.getHorario().getHoraInicio().getHora());
		st.setInt(8, rota.getHorario().getHoraInicio().getMinutos());
		st.setInt(9, rota.getHorario().getHoraTermino().getHora());
		st.setInt(10, rota.getHorario().getHoraTermino().getMinutos());
		st.setString(11, rota.getUrlRota());

		st.execute();
		st.close();
	}

	public Rota recuperar(String identificador) throws SQLException,
			IllegalArgumentException {
		if (identificador == null || !(identificador.matches("[0-9]+")))
			throw new IllegalArgumentException(
					"O identificador da Rota deve ser valido");

		String sql = "select (id, cor, numeroVisualizacao, empresaId, diferencaEntreOnibus, "
				+ "tempoPercusoTotal, horaInicio, minutoInicio, horaTermino, minutoTermino, urlRota) "
				+ "from rota where id=?";
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
							rs.getInt("tempoPercusoTotal"), new Tempo(
									rs.getInt("horaInicio"),
									rs.getInt("minutoInicio")), new Tempo(
									rs.getInt("horaTermino"),
									rs.getInt("minutoTermino"))),
					rs.getInt("empresaId"), rs.getString("urlRota"));
			rotas.add(rota);
		}
		return rotas;
	}

	public void atualizar(Rota rota, Rota rotaAtualizada) throws SQLException,
			IllegalArgumentException {
		if (rota == null || rotaAtualizada == null)
			throw new IllegalArgumentException("A Rota nao pode ser atualizada");

		String sql = "update rota set id = ?, cor = ?, numeroVisualizacao = ?, emrpesaId = ?, "
				+ "diferencaEntreOnibus = ?, tempoPercusoTotal = ?, horaInicio = ?, minutoInicio = ?, "
				+ "horaTermino = ?, minutoTermino = ?, urlRota = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);

		st.setString(1, rotaAtualizada.getIdentificador());
		st.setString(2, rotaAtualizada.getCor());
		st.setInt(3, rotaAtualizada.getNumeroVisualizacao());
		st.setInt(4, rotaAtualizada.getEmpresaId());
		st.setInt(5, rotaAtualizada.getHorario().getDiferencaEntreOnibus());
		st.setInt(6, rotaAtualizada.getHorario().getTempoPercursoTotal());
		st.setInt(7, rotaAtualizada.getHorario().getHoraInicio().getHora());
		st.setInt(8, rotaAtualizada.getHorario().getHoraInicio().getMinutos());
		st.setInt(9, rotaAtualizada.getHorario().getHoraTermino().getHora());
		st.setInt(10, rotaAtualizada.getHorario().getHoraTermino().getMinutos());
		st.setString(11, rotaAtualizada.getUrlRota());
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
	
	
	public List<String> resultSetToListSearch(ResultSet rs) throws SQLException {
		
		List<String> rotas = new ArrayList<String>();
		Rota rota = null;
		
		//Giovani, aqui eu quero que pesquise o q tem identificador parecido e retorne.
		while (rs.next()){
			
			//rota = new Rota (rs.getString("id").equals(anObject));
			
			//rotas.add(rota.getIdentificador());
		}
		
		return rotas;
	}
	
	
	//Pra pesquisar por rota com identificador igual ou parecido
	public List<String> pesquisaRota (String identificador) throws SQLException {
		String sql = "select r from rota where r.id=" + identificador;
		PreparedStatement st = conexao.prepareStatement(sql);
		return resultSetToListSearch(st.executeQuery());
	}

}
