package dados;

public class Pedido {
	
	Cliente cli = new Cliente();
	
	int numPedido;
	double chavSeg;
	String listItens;
	String prazo;
	String rastream;
	double vlrtotal;
	String pagto;
	double frete;
	String transport;
	
	public Pedido() {
		
	}
	
	public Pedido(Cliente cli, int numPedido, double chavSeg, String listItens, String prazo, String rastream,
			double vlrtotal, String pagto, double frete, String transport) {
		super();
		this.cli = cli;
		this.numPedido = numPedido;
		this.chavSeg = chavSeg;
		this.listItens = listItens;
		this.prazo = prazo;
		this.rastream = rastream;
		this.vlrtotal = vlrtotal;
		this.pagto = pagto;
		this.frete = frete;
		this.transport = transport;
	}

	public String toString() {
		return "Pedido [cli=" + cli + ", numPedido=" + numPedido + ", chavSeg=" + chavSeg + ", listItens=" + listItens
				+ ", prazo=" + prazo + ", rastream=" + rastream + ", vlrtotal=" + vlrtotal + ", pagto=" + pagto
				+ ", frete=" + frete + ", transport=" + transport + "]";
	}

	public Cliente getCli() {
		return cli;
	}
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
	public int getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(int numPedido) {
		this.numPedido = numPedido;
	}
	public double getChavSeg() {
		return chavSeg;
	}
	public void setChavSeg(double chavSeg) {
		this.chavSeg = chavSeg;
	}
	public String getListItens() {
		return listItens;
	}
	public void setListItens(String listItens) {
		this.listItens = listItens;
	}
	public String getPrazo() {
		return prazo;
	}
	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}
	public String getRastream() {
		return rastream;
	}
	public void setRastream(String rastream) {
		this.rastream = rastream;
	}
	public double getVlrtotal() {
		return vlrtotal;
	}
	public void setVlrtotal(double vlrtotal) {
		this.vlrtotal = vlrtotal;
	}
	public String getPagto() {
		return pagto;
	}
	public void setPagto(String pagto) {
		this.pagto = pagto;
	}
	public double getFrete() {
		return frete;
	}
	public void setFrete(double frete) {
		this.frete = frete;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
}
