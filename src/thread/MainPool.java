package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ProcessWork implements Runnable {
	private int workId;

	ProcessWork(int workId) {
		this.workId = workId;
	}

	@Override
	public void run() {
		System.out.println("Starting " + workId);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Complete " + workId);

	}
}

public class MainPool {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			service.submit(new ProcessWork(i));
		}

		service.shutdown();
		System.out.println("Service is shut down.");

		try {
			service.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
