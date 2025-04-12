package thread;

public class syncTH {

	int count = 0;

	public synchronized void increment() { // Lock thread
		count++;
	}

	public static void main(String[] args) {

		new syncTH().DoIt();

	}

	public void DoIt() {
		Thread th = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});

		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		});

		th.start();
		th1.start();
		try {
			th.join();
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(count);

	}

}
