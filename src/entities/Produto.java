package entities;

public class Produto {

	protected Integer code;
	protected String name;
	protected String manufacturer;
	protected Integer stock;
	protected Double price;

	public Produto(Integer code, String name, String manufacturer, Integer stock, Double price) {
		this.code = code;
		this.name = name;
		this.manufacturer = manufacturer;
		this.stock = stock;
		this.price = price;
	}

	public Produto() {

	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String fabricante) {
		this.manufacturer = fabricante;
	}

	public Integer getStock() {
		return stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double vender(int quantity) {
		if (quantity > stock) {
			return -1;
		} else {
			stock -= quantity;
			return quantity * price;
		}
	}

	public void comprar(int quantity) {
		stock += quantity;
	}

	public String toString() {
		return "\nCódigo: " + code
				+ "\nNome: " + name
				+ "\nFabricante: " + manufacturer
				+ "\nQuantidade em estoque: " + stock
				+ "\nValor Unitário: R$" + String.format("%.2f", price);
	}

}
