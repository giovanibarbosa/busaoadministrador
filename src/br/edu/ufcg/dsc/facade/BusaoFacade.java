package br.edu.ufcg.dsc.facade;

import java.sql.SQLException;
import java.util.List;

import br.edu.ufcg.dsc.bean.Ponto;
import br.edu.ufcg.dsc.service.CidadeService;
import br.edu.ufcg.dsc.service.RotaService;

public class BusaoFacade{

		private RotaService rs = new RotaService();
		private CidadeService cs = new CidadeService();
	
		public BusaoFacade(){
			
		}

		//Aqui tem que especificar mais Julio. Tu pegar valor de que tabela ? So de Rota ? 
		//Rota so tem 2 atributos String (Fora o identificador): cor e url
		//Talvez seja necessario criar outro metodos ou adicionar um atributo ai
        public String getValor(String atributo, String id) throws IllegalArgumentException, SQLException {
        	return rs.getValor(atributo, id);
        }

        //Aqui tu que fazer aquela pesquisa complementar é ? Pesquisa todas as rotas que tem identificador parecido ?
        public List<String> pesquisaRota(String nome) throws SQLException {           
        	return rs.pesquisaRota(nome);
        }

        public List<Ponto> obterPontos(String idRota) throws IllegalArgumentException, SQLException {
        	return rs.getPontos(idRota);
        }

        public String obterHorarios(String idRota) throws IllegalArgumentException, SQLException {
        	return rs.getTodosHorario(idRota);
        }

        //Como serao os calculos aqui ? Iremos dizer "Falta x minutos pro onibus passar"
        //levando em consideracao a hora atual com os calculos do percurso do onibus e o intervalo de passagem ?
        //Acho que os calculos serao assim:
        
        	// (horaAtual - horaInicioRota) / tempoPercursoRota
        	//o resultado sera o resto dessa divisao. Concordam ?
        public int proximaPassagem(String idRota) throws IllegalArgumentException, SQLException {
        	return rs.calculaProximaPassagem(idRota);
        }

        //Esse aqui so da pra fazer qnd extrair os pontos. 
        public Ponto pesquisaPorPonto(double latitude, double longitude) {
        	// TODO Auto-generated method stub
        	return null;
        }

        //Esse aqui so da pra fazer qnd extrair os pontos. 
        public List<Ponto> pesquisaPorDoisPontos(double latitude1,
                        double longitude1, double latitude2, double longitude2) {
        	// TODO Auto-generated method stub
        	return null;
        }

        public String obterCidade(int idCidade) {
        	return cs.getCidadePorId(idCidade);
        }
        
}

