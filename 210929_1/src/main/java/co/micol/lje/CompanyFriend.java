package co.micol.lje;

import co.micol.lje.Friend;

public class CompanyFriend extends Friend {

	public String company;
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public CompanyFriend() {
		
	}
	public CompanyFriend(String name, String tel, String address,String company) {
		super(name,tel,address);
		this.company=company;
		
	}
	
	@Override
	public void friendPrint() {

		System.out.printf("이름: %s\t| 번호: %s\t | 주소: %s\t | 구분: 직장동료(%s)\n",name,tel, address, company);
		
	}


	@Override
	public String toString() {
		return "CompanyFriend [name=" + super.getName() + ", phone=" + super.getTel() +", address=" + super.getAddress() + "company="+company+"]";
	}

}
