package co.micol.lje;

import java.util.Scanner;



public class DoWhileTest {
	private Scanner sc = new Scanner(System.in);

	Friend friends[] = new Friend[100];
//	friends[0] = new SchoolFriend("홍길동", "010-111-111", "대구광역시", "예담");
//	friends[1] = new SchoolFriend("박영희", "010-222-222", "성남", "예담");
//	friends[2] = new CompanyFriend("이길동", "010-333-333", "대전", "삼성");
//	friends[3] = new CompanyFriend("김길동", "010-444-444", "서울", "네이버");

	private void mainMenu() {
		System.out.println("===============");
		System.out.println("== 1. 입력하기 ==");
		System.out.println("== 2. 수정하기 ==");
		System.out.println("== 3. 조회하기 ==");
		System.out.println("== 4. 종료하기 ==");
		System.out.println("===============");
		System.out.print("원하는 작업번호를 입력하세요>>");
	}

	private void firstMenu() {
		System.out.println("===========================");
		System.out.println(" | 1.학교친구 | 2.회사친구 | ");

		int choice = ScanUtil.readInt("메뉴 선택>");

		String name = ScanUtil.readStr("친구 이름 입력: ");
		String tel = ScanUtil.readStr("전화번호 입력: ");
		String address = ScanUtil.readStr("주소 입력: ");
		Friend friend = null;

		if (choice == 1) {
			String school = ScanUtil.readStr("학교입력: ");
			friend = new SchoolFriend(name, tel, address, school);
		} else if (choice == 2) {
			String company = ScanUtil.readStr("회사입력: ");
			friend = new CompanyFriend(name, tel, address, company);
		}

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}

		System.out.println("== 메인메뉴는 아무키나 누르세요. ==");
		System.out.println("===========================");
		sc.nextLine();
	}

	private void secondMenu() {
		System.out.println("===========================");
		System.out.println("== 여기는 수정하는 화면입니다. ==");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println("[" + i + "]" + friends[i].toString());
			}
		}

		int num = ScanUtil.readInt("수정할 친구 선택>");
		String name = ScanUtil.readStr("이름을 수정해주세요 >");
		String phone = ScanUtil.readStr("번호를 수정해주세요 >");
		String address = ScanUtil.readStr("주소를 수정해주세요 >");

		if (!name.equals(""))
			friends[num].setName(name);
		else if (!phone.equals(""))
			friends[num].setTel(phone);
		else if (!address.equals(""))
			friends[num].setAddress(address);

		if (friends[num] instanceof SchoolFriend) {
			String school = ScanUtil.readStr("학교이름을 수정해주세요>");
			if (school.equals(""))
				((SchoolFriend) friends[num]).getSchool();
			else
				((SchoolFriend) friends[num]).setSchool(school);
		} else if (friends[num] instanceof CompanyFriend) {
			String company = ScanUtil.readStr("회사이름을 수정해주세요>");
			if (company.equals(""))
				((CompanyFriend) friends[num]).getCompany();
			else
				((CompanyFriend) friends[num]).setCompany(company);
		}
		System.out.println("수정완료");
		System.out.println("== 메인메뉴는 아무키나 누르세요. ==");
		System.out.println("===========================");
		sc.nextLine();
	}

	private void thirdMenu() {
		System.out.println("===========================");
		System.out.println("== 여기는 조회하는 화면입니다. ==");

		String name = ScanUtil.readStr("이름 조회:");
		String phone = ScanUtil.readStr("번호 조회: ");
		String address = ScanUtil.readStr("주소 조회: ");

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (!name.equals("") && !phone.equals("") && !address.equals("")) {
					if (friends[i].getName().indexOf(name) != -1 && friends[i].getTel().indexOf(phone) != -1
							&& friends[i].getAddress().indexOf(address) != -1) {
						friends[i].friendPrint();
					}
				} else if (!name.equals("")) {
					if (friends[i].getName().indexOf(name) != -1) {
						friends[i].friendPrint();
					}
				} else if (!phone.equals(phone)) {
					if (friends[i].getTel().indexOf(phone) != -1) {
						friends[i].friendPrint();
					}
				} else if (!address.equals(address)) {
					if (friends[i].getAddress().indexOf(address) != -1) {
						friends[i].friendPrint();
					}

				} else {
					friends[i].friendPrint();
				}
			}
		}
		System.out.println("== 메인메뉴는 아무키나 누르세요. ==");
		System.out.println("===========================");
		sc.nextLine();
	}

	private void endMenu() {
		System.out.println("=======Good Bye=======");
	}

	private void doWhileMenu() {
		boolean b = true; // 대부분 false로 초기 값
		friends[0] = new SchoolFriend("홍길동", "010-111-111", "대구광역시", "예담");
		friends[1] = new SchoolFriend("박영희", "010-222-222", "성남", "예담");
		friends[2] = new CompanyFriend("이길동", "010-333-333", "대전", "삼성");
		friends[3] = new CompanyFriend("김길동", "010-444-444", "서울", "네이버");

		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine(); // 버퍼 클리어 역할
			switch (key) {
			case 1:
				firstMenu();
				break;
			case 2:
				secondMenu();
				break;
			case 3:
				thirdMenu();
				break;
			case 4:
				endMenu();
				b = false; // false 초기값이면 true로 설정
				break;
			}
		} while (b); // false 초기값이면 (!b)로 설정해놓음

	}

	public void run() {
		doWhileMenu();
		sc.close();
	}

}