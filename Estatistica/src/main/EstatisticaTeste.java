package main;
import java.util.ArrayList;
import java.util.List;

import BO.EstatisticaBO;
import Bean.Questao;
import Bean.Resposta;

public class EstatisticaTeste {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		EstatisticaBO bo = new EstatisticaBO();
		//apagar todoas as questões
		bo.apagarTodasQuestoes();
		
		//Criar novas questões e repostas
		Questao questao = new Questao();
		questao.setIdQuestao(1);
		questao.setDescricaoQuestao("Qual a melhor linguagem de programação");
		
		Resposta reposta = new Resposta();
		reposta.setIdResposta(1);
		reposta.setDescricaoResposta("JAVA");
		
		Resposta reposta2 = new Resposta();
		reposta2.setIdResposta(2);
		reposta2.setDescricaoResposta(".NET");
		
		Resposta reposta3 = new Resposta();
		reposta3.setIdResposta(3);
		reposta3.setDescricaoResposta("PHYTON");
		
		List<Resposta> respostas = new ArrayList<Resposta>();
		respostas.add(reposta);
		respostas.add(reposta2);
		respostas.add(reposta3);
		
		questao.setRepostas(respostas);
		
		bo.criarQuestao(questao);
		
		//imprimir todas as questões e repostas
		List<Questao> questoes = bo.obterQuestoes();
		
		for(Questao q : questoes) {
			System.out.println("Questão : " + q.getDescricaoQuestao());
			System.out.println("Respostas : " );
			
			for(Resposta r : q.getRepostas()) {
				System.out.println(r.getDescricaoResposta() + " ");
			}
		}
		
	}

}
