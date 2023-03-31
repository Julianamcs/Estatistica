package Bean;
import java.io.Serializable;

public class Resposta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idResposta; 
	private String descricaoResposta;

	
	public int getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}
	public String getDescricaoResposta() {
		return descricaoResposta;
	}
	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
	
	

}
