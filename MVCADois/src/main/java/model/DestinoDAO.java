package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void save(Destino destino) {
		String sql = "INSERT INTO destinos(nomeDest)" + "VALUES(?)";
		
		try {
			conn = Conexao.createConnectionToMySQL();			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNomeDest());
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void remove(int id) {
		String sql = "DELETE FROM destinos WHERE idDes = ?";
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		
	}
	
	public void update(Destino destino) {
		String sql = "UPDATE destinos SET nomeDest = ? WHERE idDes = ?";
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNomeDest());
			
			pstm.setInt(2, destino.getIdDes());
			
			pstm.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	public List<Destino> getDestinos(){
		String sql = "SELECT * FROM destinos";
		
		List<Destino> destinos = new ArrayList<Destino>();
		
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			
			while(rset.next()) {
				Destino destino = new Destino();
				
				destino.setIdDes(rset.getInt("idDes"));
				destino.setNomeDest(rset.getString("nomeDest"));
				destinos.add(destino);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}		
		return destinos;
	}
	
	public Destino getContado(int id) {
		
		String sql = "SELECT * FROM destinos WHERE idDes = ?";
		Destino destino = new Destino();
		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			
			rset.next();
			
			destino.setNomeDest(rset.getString("nomeDest"));
			destino.setIdDes(rset.getInt("idDes"));
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return destino;
	}
}































