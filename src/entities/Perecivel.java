package entities;

import java.time.LocalDate;

public class Perecivel extends Produto {

	protected LocalDate expireDate;
	protected Boolean reefer;

	public Perecivel() {
		super();
	}

	public Perecivel(Integer code, String name, String manufacturer, Integer stock, Double price, LocalDate expireDate,
			Boolean reefer) {
		super(code, name, manufacturer, stock, price);
		this.expireDate = expireDate;
		this.reefer = reefer;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

	public Boolean getReefer() {
		return reefer;
	}

	public void setReefer(Boolean reefer) {
		this.reefer = reefer;
	}

	@Override
	public String toString() {
		return super.toString() + "\nValidade: " + expireDate
				+ "\nRefrigerado? " + reefer;
	}

}
