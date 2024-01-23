package dados;

public class Item{
	
	Produto prod = new Produto();
	
	int codItem;
	double qtde;
	double vlrunit;
	double descont;
	
	public Item() {
		
	}
	
	public Item(Produto Item, int codItem, double qtde, double vlrunit, double descont, Produto prod) {
		super();
		this.prod = prod;
		this.codItem = codItem;
		this.qtde = qtde;
		this.vlrunit = vlrunit;
		this.descont = descont;
	}

	public String toString() {
		return "Item [prod=" + prod + ", codItem=" + codItem + ", qtde=" + qtde + ", vlrunit=" + vlrunit + ", descont="
				+ descont + "]";
	}

	
	public int getCodItem() {
		return codItem;
	}

	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}

	public double getQtde() {
		return qtde;
	}
	public void setQtde(double qtde) {
		this.qtde = qtde;
	}
	public double getVlrunit() {
		return vlrunit;
	}
	public void setVlrunit(double vlrunit) {
		this.vlrunit = vlrunit;
	}
	
	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

	public double getDescont() {
		return descont;
	}

	public void setDescont(double descont) {
		this.descont = descont;
	}
}
