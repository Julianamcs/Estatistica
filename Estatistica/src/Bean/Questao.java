package Bean;

import java.io.Serializable;
import java.util.List;

public class Questao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idQuestao;
	private String descricaoQuestao;
	private List<Resposta> repostas;
	
	
	public int getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getDescricaoQuestao() {
		return descricaoQuestao;
	}
	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoQuestao = descricaoQuestao;
	}
	public List<Resposta> getRepostas() {
		return repostas;
	}
	public void setRepostas(List<Resposta> repostas) {
		this.repostas = repostas;
	}
	
	
	
	
	

}