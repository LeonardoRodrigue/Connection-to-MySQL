package dados;

public class TestesProduto {

	public static void main(String[] args) {
		
		Produto p1 = new Produto();
		
		
		p1.setNome("Monitô");
		p1.setPrecoCusto(90);
		p1.setMarKup(5);
		p1.setAtivo(true);
		p1.calcularNovoPrecoVenda();
		p1.setQuantEstoque(10);
		p1.incluirEstoque(0);
		ProdutoDAO.inserirProduto(p1);
		System.out.println(p1);
		//ProdutoDAO.criarTabelaProduto();

	}

}