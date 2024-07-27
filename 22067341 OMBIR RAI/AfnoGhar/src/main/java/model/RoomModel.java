package model;

public class RoomModel {


	private int houseId;
	private int house_number;
	private String address;
	private int host_number;
	private String unit_price;
	
	
	public RoomModel() {
	}
	
	public RoomModel(int houseId, int house_number, String address, int host_number, String unit_price) {
		super();
		this.houseId = houseId;
		this.house_number = house_number;
		this.address = address;
		this.host_number = host_number;
		this.unit_price = unit_price;
	}
	
	public RoomModel(int house_number, String address, int host_number, String unit_price) {
		super();
		this.house_number = house_number;
		this.address = address;
		this.host_number = host_number;
		this.unit_price = unit_price;
	}
	

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public int getHouse_number() {
		return house_number;
	}

	public void setHouse_number(int house_number) {
		this.house_number = house_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getHost_number() {
		return host_number;
	}

	public void setHost_number(int host_number) {
		this.host_number = host_number;
	}

	public String getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(String unit_price) {
		this.unit_price = unit_price;
	}
	
}
