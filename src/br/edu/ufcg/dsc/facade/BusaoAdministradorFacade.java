package br.edu.ufcg.dsc.facade;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.service.CidadeService;
import br.edu.ufcg.dsc.service.EmpresaService;
import br.edu.ufcg.dsc.service.OnibusService;
import br.edu.ufcg.dsc.service.RotaService;
import br.edu.ufcg.dsc.util.Tempo;


public class BusaoAdministradorFacade implements BusaoAdministradorFacadeIF {

	private CidadeService cs;
	private OnibusService os;
	private EmpresaService es;
	private RotaService rs;

	@Override
	public boolean adicionarCidade(Cidade c) {
		return cs.adicionarCidade(c);
	}

	@Override
	public boolean removerCidade(Cidade c) {
		return cs.removeCidade(c);
	}

	@Override
	public boolean adicionarOnibus(Onibus o) {
		return os.addOnibus(o);
	}

	@Override
	public boolean removerOnibus(Onibus o) {
		return os.removeOnibus(o);
	}

	@Override
	public boolean adicionarEmpresa(Cidade c, Empresa empr) {
		return cs.adicionaEmpresa(c, empr);
	}

	@Override
	public boolean removerEmpresa(Cidade c, Empresa empr) {
		return cs.removeEmpresa(c, empr);
	}

	@Override
	public boolean alterarRota(Empresa emp, Rota r) {
		return es.alterarRota(emp, r);
	}

	@Override
	public boolean removerRota(Empresa emp, Rota r) {
		return es.removeRota(emp, r);
	}

	@Override
	public boolean cadastrarRota(Empresa emp, Rota r) {
		return es.adicionaRota(emp, r);
	}

	@Override
	public Tempo calculaProximaPassagem(Rota r, Tempo temp) {
		return rs.calculaProximaPassagem(r, temp);
	}

	@Override
	public Tempo calcularTodosHorarios(Rota r) {
		return rs.calcularTodosHorarios(r);
	}

}

