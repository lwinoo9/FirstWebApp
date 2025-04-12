package thread;

class Caller implements Runnable {
	@Override
	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
				System.out.println("i value is " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

public class RunnableTest {

	public static void main(String[] args) {
		Thread th = new Thread(new Caller());
		Thread th2 = new Thread(new Caller());

		th.start();
		th2.start();

	}

}
