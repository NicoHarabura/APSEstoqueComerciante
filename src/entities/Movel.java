package entities;

public class Movel extends Produto {

	protected String materialType;

	public Movel() {
		super();
	}

	public Movel(Integer code, String name, String manufacturer, Integer stock, Double price, String materialType) {
		super(code, name, manufacturer, stock, price);
		this.materialType = materialType;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	@Override
	public String toString() {
		return super.toString() + "\nTipo de Material: " + materialType;
	}

}
