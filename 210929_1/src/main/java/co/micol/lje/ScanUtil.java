package co.micol.lje;

import java.util.Scanner;

public class ScanUtil {
	static Scanner sc =new Scanner(System.in);
	
	public static String readStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	public static int readInt(String msg) {
		System.out.print(msg);
		int num=sc.nextInt();
		sc.nextLine();
		return num;
	}
}
