package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexaoBD.Conexao;

public class ClienteDAO {
	
	public static boolean criarTabelaCliente() {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "CREATE TABLE cliente("
					+ "codCliente INT PRIMARY KEY AUTO_INCREMENT, "
					+ "nome VARCHAR(50) NOT NULL, "
					+ "email VARCHAR(50) NOT NULL, "
					+ "endereco VARCHAR(100), "
					+ "cidade VARCHAR(30), "
					+ "estado CHAR(2), "
					+ "fone VARCHAR(15)); ";
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.execute();
				return true;
		} catch(Exception e) {
				System.out.println("ERROR: A tabela cliente não foi criada. - " + e.getMessage());
				return false;
		} finally {
					Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean inserirCliente(Cliente cli) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "INSERT INTO "
					+ "cliente(nome, email, endereco, cidade, estado, fone) "
					+ "VALUES(?, ?, ?, ?, ?, ?);";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, cli.getNome());
			stat.setString(2, cli.getEstado());
			stat.setString(3, cli.getEndereco());
			stat.setString(4, cli.getCidade());
			stat.setString(5, cli.getEstado());
			stat.setString(6, cli.getFone());
			stat.execute();
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				cli.setCodCliente(rs.getInt(1));
			}
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Cliente não inserido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean alterarCliente(Cliente cli) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "UPDATE cliente SET"
					+ "nome=?, "
					+ "email=?, "
					+ "endereco=?, "
					+ "cidade=?, "
					+ "estado=?, "
					+ "fone=?, "
					+ "WHERE codCliente=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setString(1, cli.getNome());
			stat.setString(2, cli.getEmail());
			stat.setString(3, cli.getEndereco());
			stat.setString(4, cli.getCidade());
			stat.setString(5, cli.getEstado());
			stat.setString(6, cli.getFone());
			stat.setInt(7, cli.getCodCliente());
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Cliente não alterado. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
		public static boolean excluirCliente(int cod) {
			Connection conn = null;
			PreparedStatement stat = null;
			try {
				String sql = "DELETE FROM cliente "
						+ "WHERE codCliente=?";
				
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.setInt(1, cod);
				stat.execute();
				
				return true;
			} catch (Exception e) {
				System.out.println("ERRO: Cliente não excluido. " + e.getMessage());
				return false;
			} finally {
				Conexao.fecharConexao(conn, stat);
			}
		}
		
		public static Cliente consultarCliente (int cod) {
			Cliente cli = null;
			Connection conn = null;
			PreparedStatement stat= null;
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM cliente WHERE codClinte=?;";
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.setInt(1, cod);
				rs = stat.executeQuery();
				if (rs.next()) {
					cli = new Cliente();
					cli.setCodCliente(rs.getInt("codCliente"));
					cli.setNome(rs.getString("nome"));
					cli.setEmail(rs.getString("email"));
					cli.setEndereco(rs.getString("endereco"));
					cli.setCidade(rs.getString("cidade"));
					cli.setEstado(rs.getString("estado"));
					cli.setFone(rs.getString("fone"));
				}
			} catch (Exception e) {
				System.out.println("ERRO na consulta do cliente. " + e.getMessage());
			} finally {
				Conexao.fecharConexao(conn, stat, rs);
			}
			return cli;
		}
		
		public static ArrayList<Cliente> consultarCliente() {
			ArrayList<Cliente> lista = new ArrayList<Cliente>();
			Connection conn = null;
			PreparedStatement stat= null;
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM cliente;";
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				rs = stat.executeQuery();
				while (rs.next()) {
					Cliente cli = new Cliente();
					cli.setCodCliente(rs.getInt("codCliente"));
					cli.setNome(rs.getString("nome"));
					cli.setEmail(rs.getString("email"));
					cli.setEndereco(rs.getString("endereco"));
					cli.setCidade(rs.getString("cidade"));
					cli.setEstado(rs.getString("estado"));
					cli.setFone(rs.getString("fone"));
					lista.add(cli);
				}
			} catch (Exception e) {
				System.out.println("ERRO na consulta do cliente. " + e.getMessage());
			} finally {
				Conexao.fecharConexao(conn, stat, rs);
			}
			return lista;
	}
}