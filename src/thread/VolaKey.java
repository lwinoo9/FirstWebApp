package thread;

import java.util.Scanner;

class Drive extends Thread {
	volatile boolean bol = true;

	@Override
	public void run() {
		while (bol) {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(500);
					System.out.println(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void stopNow() {
		bol = false;
	}

}

public class VolaKey {

	public static void main(String[] args) {
		Drive driver = new Drive();
		driver.start();

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter something to stop.");
		scan.nextLine();
		driver.stopNow();

		scan.close();

	}

}
