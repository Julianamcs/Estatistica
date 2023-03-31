package BO;
import java.util.List;

import Bean.Questao;
import DAO.EstatisticaDAO;

public class EstatisticaBO {

	public  List<Questao> obterQuestoes(){
		EstatisticaDAO dao = new EstatisticaDAO();
		return dao.obterTodasQuestoes();
	}
	
	public void criarQuestao(Questao questao){
		EstatisticaDAO dao = new EstatisticaDAO();
		dao.criarQuestao(questao);
	}
	
	public void apagarTodasQuestoes(){
		EstatisticaDAO dao = new EstatisticaDAO();
		dao.apagarTodasQuestoes();
	}
	
}