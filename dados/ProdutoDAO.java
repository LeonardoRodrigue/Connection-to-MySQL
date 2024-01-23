package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexaoBD.Conexao;

public class ProdutoDAO {
	
	public static boolean criarTabelaProduto() {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "CREATE TABLE produto("
					+ "codProduto INT PRIMARY KEY AUTO_INCREMENT, "
					+ "nome VARCHAR(50) NOT NULL, "
					+ "precoCusto VARCHAR(50) NOT NULL, "
					+ "precoVenda VARCHAR(50) NOT NULL, "
					+ "quantEstoque INT, "
					+ "unidade CHAR(4), "
					+ "estoqueMin INT NOT NULL, "
					+ "categoria VARCHAR(10), "
					+ "marKup DOUBLE NOT NULL, " 
					+ "ativo VARCHAR(3)); ";
				conn = Conexao.criarConexao();
				stat = conn.prepareStatement(sql);
				stat.execute();
				return true;
		} catch(Exception e) {
				System.out.println("ERROR: A tabela produto não foi criada. - " + e.getMessage());
				return false;
		} finally {
					Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean inserirProduto(Produto prod) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "INSERT INTO "
					+ "produto(nome, precoCusto, precoVenda, quantEstoque, unidade, estoqueMin, categoria, marKup, ativo) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, prod.getNome());
			stat.setDouble(2, prod.getPrecoCusto());
			stat.setDouble(3, prod.getPrecoVenda());
			stat.setDouble(4, prod.getQuantEstoque());
			stat.setString(5, prod.getUnidade());
			stat.setInt(6, prod.getEstoqueMin());
			stat.setString(7, prod.getCategoria());
			stat.setDouble(8, prod.getMarKup());
			stat.setBoolean(9, prod.isAtivo());
			stat.execute();
			ResultSet rs = stat.getGeneratedKeys();
			if (rs.next()) {
				prod.setCodProduto(rs.getInt(1));
			}
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Produto não inserido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean alterarProduto(Produto prod) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "UPDATE produto SET"
					+ "nome=?, "
					+ "precoCusto=?, "
					+ "precoVenda=?, "
					+ "quantEstoque=?, "
					+ "unidade=?, "
					+ "estoqueMin=?, "
					+ "categoria=?, "
					+ "marKup=?, "
					+ "Ativo=?, "
					+ "WHERE codProduto=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setString(1, prod.getNome());
			stat.setDouble(2, prod.getPrecoCusto());
			stat.setDouble(3, prod.getPrecoVenda());
			stat.setDouble(4, prod.getQuantEstoque());
			stat.setString(5, prod.getUnidade());
			stat.setInt(6, prod.getEstoqueMin());
			stat.setString(7, prod.getCategoria());
			stat.setDouble(8, prod.getMarKup());
			stat.setBoolean(9, prod.isAtivo());
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Produto não alterado. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static boolean excluirProduto(int cod) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			String sql = "DELETE FROM produto "
					+ "WHERE codProduto=?";
			
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			stat.execute();
			
			return true;
		} catch (Exception e) {
			System.out.println("ERRO: Produto não excluido. " + e.getMessage());
			return false;
		} finally {
			Conexao.fecharConexao(conn, stat);
		}
	}
	
	public static Produto consultarProduto (int cod) {
		Produto prod = null;
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM produto WHERE codProduto=?;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			stat.setInt(1, cod);
			rs = stat.executeQuery();
			if (rs.next()) {
				prod = new Produto();
				prod.setCodProduto(rs.getInt("codProduto"));
				prod.setNome(rs.getString("nome"));
				prod.setPrecoCusto(rs.getDouble("PrecoCusto"));
				prod.setPrecoVenda(rs.getDouble("PrecoVenda"));
				prod.setQuantEstoque(rs.getDouble("quantEstoque"));
				prod.setUnidade(rs.getString("unidade"));
				prod.setEstoqueMin(rs.getInt("estoqueMin"));
				prod.setCategoria(rs.getString("categoria"));
				prod.setMarKup(rs.getDouble("marKup"));
				prod.setAtivo(rs.getBoolean("ativo"));
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do produto. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return prod;
	}
	
	public static ArrayList<Produto> consultarProduto() {
		ArrayList<Produto> lista = new ArrayList<Produto>();
		Connection conn = null;
		PreparedStatement stat= null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM produto;";
			conn = Conexao.criarConexao();
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while (rs.next()) {
				Produto prod = new Produto();
				prod.setCodProduto(rs.getInt("codProduto"));
				prod.setNome(rs.getString("nome"));
				prod.setPrecoCusto(rs.getDouble("PrecoCusto"));
				prod.setPrecoVenda(rs.getDouble("PrecoVenda"));
				prod.setQuantEstoque(rs.getDouble("quantEstoque"));
				prod.setUnidade(rs.getString("unidade"));
				prod.setEstoqueMin(rs.getInt("estoqueMin"));
				prod.setCategoria(rs.getString("categoria"));
				prod.setMarKup(rs.getDouble("marKup"));
				prod.setAtivo(rs.getBoolean("ativo"));
				lista.add(prod);
			}
		} catch (Exception e) {
			System.out.println("ERRO na consulta do produto. " + e.getMessage());
		} finally {
			Conexao.fecharConexao(conn, stat, rs);
		}
		return lista;
	}
}