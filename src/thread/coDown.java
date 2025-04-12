package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Work implements Runnable {

	private CountDownLatch latch;

	public Work(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting..");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ending..");
		latch.countDown();
	}

}

public class coDown {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 3; i++) {
			service.submit(new Work(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All Done.");

	}

}
