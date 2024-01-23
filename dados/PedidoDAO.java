package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexaoBD.Conexao;

public class PedidoDAO {
	
	public static boolean criarTabelaPedido() {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "CREATE TABLE pedido("
					+ "numPedido INT PRIMARY KEY AUTO_INCREMENT, "
					+ "chavSeg VARCHAR(10) NOT NULL, "
					+ "prazo VARCHAR(25) NOT NULL, "
					+ "rastream VARCHAR(50), "
					+ "vlrtotal VARCHAR(30) NOT NULL, "
					+ "pagto VARCHAR(20) NOT NULL, "
					+ "frete VARCHAR(10), "
					+ "transport VARCHAR(10)); "; 
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.execute();
				return true;
		} catch(Exception e) {
				System.out.println("ERROR: A tabela pedido não foi criada. - " + e.getMessage());
				return false;
		} finally {
					Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean inserirPedido(Pedido ped) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "INSERT INTO "
					+ "pedido(numPedido, chavSeg, prazo, rastream, vlrtotal, pagto, frete, transport) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, ped.getNumPedido());
			stat.setDouble(2, ped.getChavSeg());
			stat.setString(3, ped.getPrazo());
			stat.setString(4,ped.getRastream());
			stat.setDouble(5, ped.getVlrtotal());
			stat.setString(6, ped.getPagto());
			stat.setDouble(7, ped.getFrete());
			stat.setString(8, ped.getTransport());
			stat.execute();
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				ped.setNumPedido(rs.getInt(1));
			}
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Pedido não inserido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean alterarPedido(Pedido ped) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "UPDATE pedido SET"
					+ "numPedido=?, "
					+ "chavSeg=?, "
					+ "prazo=?, "
					+ "rastream=?, "
					+ "vlrtotal=?, "
					+ "pagto=?, "
					+ "frete=?, "
					+ "transport=?, "
					+ "WHERE numPedido=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, ped.getNumPedido());
			stat.setDouble(2, ped.getChavSeg());
			stat.setString(3, ped.getPrazo());
			stat.setString(4,ped.getRastream());
			stat.setDouble(5, ped.getVlrtotal());
			stat.setString(6, ped.getPagto());
			stat.setDouble(7, ped.getFrete());
			stat.setString(8, ped.getTransport());
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Pedido não alterado. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean excluirPedido(int cod) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "DELETE FROM pedido "
					+ "WHERE numPedido=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Pedido não excluido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static Pedido consultarPedido (int cod) {
		Pedido ped = null;
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM pedido WHERE numPedido=?;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			rs = stat.executeQuery();
			if (rs.next()) {
				ped = new Pedido();
				ped.setNumPedido(rs.getInt("numPedido"));
				ped.setChavSeg(rs.getDouble("chavSeg"));
				ped.setPrazo(rs.getString("Prazo"));
				ped.setRastream(rs.getString("Rastrea,"));
				ped.setVlrtotal(rs.getDouble("vlrTotal"));
				ped.setPagto(rs.getString("Pagto"));
				ped.setFrete(rs.getDouble("Frete"));
				ped.setTransport(rs.getString("Transport"));
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do pedido. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return ped;
	}
	
	public static ArrayList<Pedido> consultarPedido() {
		ArrayList<Pedido> lista = new ArrayList<Pedido>();
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM pedido;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Pedido ped = new Pedido();
				ped.setNumPedido(rs.getInt("numPedido"));
				ped.setChavSeg(rs.getDouble("chavSeg"));
				ped.setPrazo(rs.getString("Prazo"));
				ped.setRastream(rs.getString("Rastrea,"));
				ped.setVlrtotal(rs.getDouble("vlrTotal"));
				ped.setPagto(rs.getString("Pagto"));
				ped.setFrete(rs.getDouble("Frete"));
				ped.setTransport(rs.getString("Transport"));
				lista.add(ped);
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do pedido. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return lista;
	}
}

// Leonardo Rodrigues e Arthur Campibel
