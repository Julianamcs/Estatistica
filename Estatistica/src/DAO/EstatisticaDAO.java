package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import Bean.Questao;
import Bean.Resposta;
import connection.EstatisticaDBManager;

public class EstatisticaDAO {
	
	Connection conexao;
	
	public void criarQuestao(Questao questao) {
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			
			conexao = EstatisticaDBManager.obterConexao();
			String sql = null;
			int codigoQuestao;
			
			//inserção das questões 
			sql = "INSERT INTO tb_questao (id_questao, descricao_questao) VALUES (?, ?)";
			preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, questao.getIdQuestao());
			preparedStatement.setString(2, questao.getDescricaoQuestao());
			preparedStatement.execute();
			
			//recuperação do código das questões recem criada 
			sql = "SELECT id_questao FROM tb_questao WHERE descricao_questao = ?";
			preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setString(1, questao.getDescricaoQuestao());
			rs = preparedStatement.executeQuery();
			rs.next();
			codigoQuestao = rs.getInt("id_questao");
			
			
			//inserção das repostas 
			sql = "INSERT INTO tb_resposta (id_resposta, id_questao, descricao_resposta) VALUES (?, ?, ?)";
			List<Resposta> respostas = questao.getRepostas();
			for (int i =0; i < respostas.size(); i++) {
			preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, respostas.get(i).getIdResposta());
			preparedStatement.setInt(2, codigoQuestao);
			preparedStatement.setString(3, respostas.get(i).getDescricaoResposta());
			preparedStatement.execute();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
				preparedStatement.close();
				rs.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	
	}
	
	
	List<Questao> obterTodasQuestoes() {
		// TODO Auto-generated method stub

		Statement stmt = null;
		ResultSet rs = null; 
		List<Questao> questoes = null; 
		
		try {
			conexao = EstatisticaDBManager.obterConexao();
			questoes = new ArrayList<Questao>();
			
			stmt = conexao.createStatement();
			String sql =  "SELECT id_questao, descricao_questao FROM tb_questao";
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Questao questao = new Questao();
				questao.setIdQuestao(rs.getInt("id_questao"));
				questao.setDescricaoQuestao(rs.getString(2));
				
				List<Resposta> respostas = this.obterRespostas(questao.getIdQuestao());
				questao.setRepostas(respostas);
				questao.add(questao);
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				
				stmt.close();
				rs.close();
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
			return questoes;
	}

		public List<Resposta> obterRespostas(int idQuestao) {
			// TODO Auto-generated method stub
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<Resposta> respostas = null;
			
			try {
				
				conexao = EstatisticaDBManager.obterConexao();
				
				respostas = new ArrayList<Resposta>();
				
				String sql = "SELECT id_resposta, descricao_resposta FROM tb_resposta WHERE id_questao = ?";
				pstmt = conexao.prepareStatement(sql);
				pstmt.setInt(1, idQuestao);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					
					Resposta resposta = new Resposta();
					resposta.setIdResposta(rs.getInt("id_reposta"));
					resposta.setDescricaoResposta(rs.getString("descricao_resposta"));
					resposta.add(resposta);
					
				}
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					
					pstmt.close();
					rs.close();
					
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
			return respostas;
		}
		
		void apagarTodasQuestoes() {
			// TODO Auto-generated method stub
			
			Statement stmt = null; 
			
			try {
				
				conexao = EstatisticaDBManager.obterConexao();
				
				stmt = conexao.createStatement();
				
				String sql = "DELETE FROM tb_reposta";
				stmt.execute(sql);
				
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					
					stmt.close();
					conexao.close();
					
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		}

}


	