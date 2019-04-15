package kr.co.sist.exam.vo;

public class CarVO {
	private String country, maker, model;

	public CarVO(String country, String maker, String model) {
		this.country = country;
		this.maker = maker;
		this.model = model;
	} // CarVO

	public String getCountry() {
		return country;
	}

	public String getMaker() {
		return maker;
	}

	public String getModel() {
		return model;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
} // class
