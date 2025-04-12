package thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProConsumer {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) {
		
		Thread th1 = new Thread(()->{
			try {
				procedure();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread th2 = new Thread(()->{
			try {
				consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

	public static void procedure() throws InterruptedException {
		Random rand = new Random();
		while (true) {
			queue.put(rand.nextInt());
		}
	}

	public static void consumer() throws InterruptedException {
		Random rand = new Random();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			if (rand.nextInt() == 0) {
				Integer value = queue.take();
				System.out.println("Take out value is " + value + "Queue Size is" + queue.size());
			}
		}
	}

}
