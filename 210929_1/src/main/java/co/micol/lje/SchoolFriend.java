package co.micol.lje;

public class SchoolFriend extends Friend {

	public String school;
	
	
	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public SchoolFriend(String name, String tel, String address, String school) {
		super(name,tel,address);
		this.school=school;
	}
	
	@Override
	public void friendPrint() {
		System.out.printf("이름: %s\t| 번호: %s\t | 주소: %s\t | 구분: 학교친구(%s)\n",name,tel, address, school);
		
	}

	@Override
	public String toString() {
		return "SchoolFriend [name=" + super.getName() + ", phone=" + super.getTel() +", address=" + super.getAddress() + "school="+school+"]";
	}

	

}
