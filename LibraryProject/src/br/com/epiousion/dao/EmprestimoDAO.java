package br.com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.epiousion.bean.Emprestimo;
import br.com.epiousion.conexao.ConexaoDatasource;

public class EmprestimoDAO {
	
	public boolean emprestimo(String idLivro, String nomeLivro, String idUsuario, String nomeUsuario) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			ps = c.prepareStatement("insert into library.emprestimos (idLivro,nomeLivro,idUsuario,nomeUsuario) values (?,?,?,?)");
			
			ps.setString(1, idLivro);
			ps.setString(2, nomeLivro);
			ps.setString(3, idUsuario);
			ps.setString(4, nomeUsuario);
			
			int Nlinhas = ps.executeUpdate();
			if(Nlinhas > 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return false;
	}

	public List<Emprestimo> emprestimosTotais(){
		Connection c = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<Emprestimo> listaEmpestimos = new ArrayList<Emprestimo>();
		
		try {
			c = ConexaoDatasource.getConexao();
			ps = c.createStatement();
			rs = ps.executeQuery("select * from library.emprestimos");
			
			while(rs.next()) {
				
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
				emprestimo.setIdLivro(rs.getString("idLivro"));
				emprestimo.setNomeLivro(rs.getString("nomeLivro"));
				emprestimo.setIdUsuario(rs.getString("idUsuario"));
				emprestimo.setNomeUsuario(rs.getString("nomeUsuario"));
				listaEmpestimos.add(emprestimo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		return listaEmpestimos;
	}
	
	public void removerEmprestimo(String id) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			ps = c.prepareStatement("delete from library.emprestimos where idEmprestimo = ?");
			
			ps.setString(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try {
				c.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public List<Emprestimo> emprestimoUsuario(String login){
		Connection c = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<Emprestimo> listaEmpestimosUsuario = new ArrayList<Emprestimo>();
		
		try {
			c = ConexaoDatasource.getConexao();
			ps = c.createStatement();
			rs = ps.executeQuery("select * from library.emprestimos where nomeUsuario = '" +login+ "'");
			
			
			while(rs.next()) {
				
				Emprestimo emprestimo = new Emprestimo();
				emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
				emprestimo.setIdLivro(rs.getString("idLivro"));
				emprestimo.setNomeLivro(rs.getString("nomeLivro"));
				emprestimo.setIdUsuario(rs.getString("idUsuario"));
				emprestimo.setNomeUsuario(rs.getString("nomeUsuario"));
				listaEmpestimosUsuario.add(emprestimo);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
				ps.close();
				if(rs != null) {
				rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
		return listaEmpestimosUsuario;
	}
	
	
}
