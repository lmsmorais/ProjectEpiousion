package br.com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.epiousion.bean.Livro;

import br.com.epiousion.conexao.ConexaoDatasource;

public class LivroDAO {

	public boolean inserir(String id, String nome) {
		
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			
			ps = c.prepareStatement("insert into livros(idLivro,nomeLivro) values (?,?)");
			
			ps.setString(1, id);
			ps.setString(2, nome);
			int Nlinhas = ps.executeUpdate();
			
			if(Nlinhas > 0) {
				return true;
			} else {
				return false;
			}
			
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
		return false;
	}
	
	public void remover(String id) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			ps = c.prepareStatement("delete from livros where idLivro = ?");
			
			ps.setString(1, id);
			
			ps.executeUpdate();
			
			c.close();
			ps.close();
			
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
	
	public List<Livro> disponiveis(){
		Connection c = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<Livro> listaLivros = new ArrayList<Livro>();
		
		try {
			c = ConexaoDatasource.getConexao();
			ps = c.createStatement();
			rs = ps.executeQuery("select * from library.livros");
			
			while(rs.next()) {
				
				Livro livro = new Livro();
				livro.setIdLivro(rs.getString("idLivro"));
				livro.setNomeLivro(rs.getString("nomeLivro"));
				listaLivros.add(livro);	
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
		return listaLivros;
	}
	
	public boolean confere(String idLivro, String nomeLivro) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select * from library.livros where idLivro = ? and nomeLivro = ? ");
			
			ps.setString(1,idLivro);
			ps.setString(2,nomeLivro);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				idLivro = rs.getString("idLivro");
				nomeLivro = rs.getString("nomeLivro");
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   finally {
			try {
				c.close();
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return false;
	}

}
