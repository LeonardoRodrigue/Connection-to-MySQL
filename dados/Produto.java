package dados;

public class Produto {
	
	private int codProduto;
	private String nome;
	private double precoCusto;
	private double precoVenda;
	private double quantEstoque;
	private String unidade;
	private int estoqueMin;
	private String categoria;
	private double marKup;
	private boolean ativo;
	
	public Produto() {
		
	}

	public Produto(int codProduto, String nome, double precoCusto, double precoVenda, double quantEstoque,
			String unidade, int estoqueMin, String categoria, double marKup, boolean ativo) {
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantEstoque = quantEstoque;
		this.unidade = unidade;
		this.estoqueMin = estoqueMin;
		this.categoria = categoria;
		this.marKup = marKup;
		this.ativo = ativo;
	}
	
	public void incluirEstoque(double qtde) {
		this.quantEstoque += qtde;
	}
	public void retirarEstoque(double qtde) {
		this.quantEstoque -= qtde;
	}
	public void calcularNovoPrecoVenda() {
		this.precoVenda = marKup + precoCusto; 
	}
	public void calcularNovoPrecoVend(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", precoCusto=" + precoCusto + ", precoVenda="
				+ precoVenda + ", quantEstoque=" + quantEstoque + ", unidade=" + unidade + ", estoqueMin=" + estoqueMin
				+ ", categoria=" + categoria + ", marKup=" + marKup + ", Ativo= " + (ativo ? " SIM" : " NÃO") + "]";
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public double getQuantEstoque() {
		return quantEstoque;
	}
	public void setQuantEstoque(double quantEstoque) {
		this.quantEstoque = quantEstoque;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public int getEstoqueMin() {
		return estoqueMin;
	}
	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getMarKup() {
		return marKup;
	}
	public void setMarKup(double marKup) {
		this.marKup = marKup;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
