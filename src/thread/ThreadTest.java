package thread;

// extends Thread interface
class Runner extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("I is " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}



public class ThreadTest {

	public static void main(String[] args) {
		Runner call = new Runner();
		call.start();
		
		Runner call2 = new Runner();
		call2.start();
	}

}
