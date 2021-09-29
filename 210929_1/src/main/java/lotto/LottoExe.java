package lotto;

import java.util.*;

public class LottoExe {
	private Random random = new Random();
	private Scanner sc = new Scanner(System.in);

	// 로또 배열
	int lottoAr[] = new int[6];
	// 1회당 로또 가격
	private int lottoPrice = 1000;

	public void run() {

		while (true) {
			// 가격 입력
			int money = readInt("돈을 넣어주세요:");
			if(money<1000) {
				System.out.println("돈이 부족합니다. 최소 1000원을 넣어주세요.");
			}
			// 게임 횟수
			int game = money / lottoPrice;
			// 거스름돈
			int change = money % lottoPrice;

			for (int n = 0; n < game; n++) {
				random();
				if((n+1)%5==0) {
					System.out.println("-----------");
				}

			}
			System.out.println("거스름돈:"+change);

		}

	}

	public int readInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	private void random() {
		// 1~45부터 랜덤 로또 6자리 생성기(중복값 없는 난수 만들기)
		for (int i = 0; i < lottoAr.length; i++) {
			lottoAr[i] = random.nextInt(45) + 1;
			if (i == 0)
				continue;
			for (int j = 0; j < i; j++) {
				if (lottoAr[i] == lottoAr[j]) {
					i--;
				}
			}
		}
		
		for (int i = 0; i < lottoAr.length; i++) {
			for (int j = 0; j < lottoAr.length - 1; j++) {
				if (lottoAr[j] > lottoAr[j + 1]) {
					int temp = lottoAr[j];
					lottoAr[j] = lottoAr[j + 1];
					lottoAr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(lottoAr));
	}

	
	
}

