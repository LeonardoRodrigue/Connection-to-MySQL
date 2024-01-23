package conexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection criarConexao() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String servidor = "jdbc:mysql://localhost:3306/testes";
		String usuario = "root";
		String senha = "123456";
		try {
			Class.forName(driver);
			return DriverManager.getConnection(servidor,usuario,senha);
			}catch (Exception e) {
				System.out.println("Erro ao conectar :" + e.getMessage());
				return null;
			}
	}
	
	public static void fecharConexao(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar a conexão: " + e.getMessage());
			}
		}
	}
	
	public static void fecharConexao(Connection conn, PreparedStatement stat) {
		Conexao.fecharConexao(conn);
		if (stat != null) {
			try {
				stat.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar a conexão: " + e.getMessage());
			}
		}
	}
	
	public static void fecharConexao(Connection conn, PreparedStatement stat, ResultSet res) {
		Conexao.fecharConexao(conn, stat);
		if (res != null) {
			try {
				res.close();
			} catch (Exception e) {
				System.out.println("Erro ao fechar a conexão: " + e.getMessage());
			}
		}
	}
}