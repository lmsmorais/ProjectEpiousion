package br.com.epiousion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.epiousion.bean.Usuario;
import br.com.epiousion.conexao.ConexaoDatasource;

public class UsuarioDAO {
	
	public boolean confere(String nomeUsuario, String senhaUsuario) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select * from library.usuarios where nomeUsuario = ? and senhaUsuario = ? ");
			
			ps.setString(1,nomeUsuario);
			ps.setString(2,senhaUsuario);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				nomeUsuario = rs.getString("nomeUsuario");
				senhaUsuario = rs.getString("senhaUsuario");
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
	
	
	public boolean inserir(String nomeUsuario, String senhaUsuario) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			ps = c.prepareStatement("insert into library.usuarios(nomeUsuario, senhaUsuario) values (?,?)");
			
			ps.setString(1, nomeUsuario);
			ps.setString(2, senhaUsuario);
			
			int Nlinhas = ps.executeUpdate();
			
			if(Nlinhas > 0) {
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return false;
	}
	
	public boolean remover(int login) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		
		try {
			ps = c.prepareStatement("delete from usuarios where idUsuario = ?");
			
			ps.setInt(1, login);
			
			int Nlinhas = ps.executeUpdate();
			
			if(Nlinhas > 0) {
				return true;	
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
	
	public List<Usuario> usuariosTotais(){
		Connection c = null;
		Statement ps = null;
		ResultSet rs = null;
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			c = ConexaoDatasource.getConexao();
			ps = c.createStatement();
			rs = ps.executeQuery("select * from library.usuarios");
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setNomeUsuario(rs.getString("nomeUsuario"));
				listaUsuarios.add(usuario);
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
		return listaUsuarios;
	}
	
	public boolean emprestimoUsuario(String login) {
		Connection c = ConexaoDatasource.getConexao();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = c.prepareStatement("select * from library.emprestimos where nomeUsuario = ?");
			
			ps.setString(1,login);
			rs = ps.executeQuery();
			
			if(rs.next()) {
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
