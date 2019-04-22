package entities;

public class Eletronico extends Produto {

	protected String voltage;
	protected Integer power;
	protected Character efficiency;

	public Eletronico() {
		super();
	}

	public Eletronico(Integer code, String name, String manufacturer, Integer stock, Double price, String voltage,
			Integer power, Character efficiency) {
		super(code, name, manufacturer, stock, price);
		this.voltage = voltage;
		this.power = power;
		this.efficiency = efficiency;
	}

	public String getVoltage() {
		return voltage;
	}

	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Character getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(Character efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public String toString() {
		return super.toString() + "\nVoltagem: " + voltage
				+ "\nPotência: " + power
				+ "\nClassificação de Eficiência: " + efficiency;
	}

}
