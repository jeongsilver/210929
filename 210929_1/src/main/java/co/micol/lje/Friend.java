package co.micol.lje;

public abstract class Friend {

	public String name;
	public String tel;
	public String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Friend() {
		
	}
	
	public Friend(String name, String tel, String address) {
		this.name=name;
		this.tel=tel;
		this.address=address;
		
	}
	
	public abstract void friendPrint();
	public abstract String toString();
}
