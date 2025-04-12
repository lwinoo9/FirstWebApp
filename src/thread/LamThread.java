package thread;

public class LamThread {

	public static void main(String[] args) {
		
		// First way
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(500);
					System.out.println("i is : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}).start();
		
		
		//Sec way
		
		Thread th = new Thread(()->{
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(500);
					System.out.println("i is : " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		th.start();

	}

}
