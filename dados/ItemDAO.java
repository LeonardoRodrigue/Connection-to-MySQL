package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexaoBD.Conexao;

public class ItemDAO {
	
	public static boolean criarTabelaItem() {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "CREATE TABLE item("
					+ "codItem INT PRIMARY KEY AUTO_INCREMENT, "
					+ "qtde VARCHAR(4) NOT NULL, "
					+ "vlrunit VARCHAR(10) NOT NULL, "
					+ "descont VARCHAR(3)); "; 
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.execute();
				return true;
		} catch(Exception e) {
				System.out.println("ERROR: A tabela item não foi criada. - " + e.getMessage());
				return false;
		} finally {
					Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean inserirItem(Item it) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "INSERT INTO "
					+ "item(codItem, qtde, vlrunit, descont) "
					+ "VALUES(?, ?, ?, ?);";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stat.setInt(1, it.getCodItem());
			stat.setDouble(2, it.getQtde());
			stat.setDouble(3, it.getVlrunit());
			stat.setDouble(4, it.getDescont());
			stat.execute();
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				it.setCodItem(rs.getInt(1));
			}
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Item não inserido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean alterarItem(Item it) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "UPDATE item SET"
					+ "codItem=?, "
					+ "qtde=?, "
					+ "vlrunit?, "
					+ "descont=?, "
					+ "WHERE codItem=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, it.getCodItem());
			stat.setDouble(2, it.getQtde());
			stat.setDouble(3, it.getVlrunit());
			stat.setDouble(4, it.getDescont());
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Item não alterado. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean excluirItem(int cod) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "DELETE FROM item "
					+ "WHERE codItem=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Item não excluido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static Item consultarItem (int cod) {
		Item it = null;
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM item WHERE codItem=?;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			rs = stat.executeQuery();
			if (rs.next()) {
				it = new Item();
				it.setCodItem(rs.getInt("codItem"));
				it.setQtde(rs.getDouble("Qtde"));
				it.setVlrunit(rs.getDouble("Vlrunit"));
				it.setDescont(rs.getDouble("Descont"));
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do item. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return it;
	}
	
	public static ArrayList<Item> consultarItem() {
		ArrayList<Item> lista = new ArrayList<Item>();
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM item;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Item it = new Item();
				it.setCodItem(rs.getInt("codItem"));
				it.setQtde(rs.getDouble("Qtde"));
				it.setVlrunit(rs.getDouble("Vlrunit"));
				it.setDescont(rs.getDouble("Descont"));
				lista.add(it);
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do item. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return lista;
	}
}

// Leonardo Rodrigues e Arthur Campibel
