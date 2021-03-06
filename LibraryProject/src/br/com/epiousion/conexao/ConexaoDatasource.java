package br.com.epiousion.conexao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexaoDatasource {
	
	public static Connection getConexao() {
		
		try {
			
			Context context = new InitialContext();
			Context env = (Context)context.lookup("java:comp/env");
			
			DataSource ds = (DataSource)env.lookup("jdbc/library");
			
			try {
				
				Connection c = ds.getConnection()	;
				return c;
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
