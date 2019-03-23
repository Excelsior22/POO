
public class MainThread {
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
		
			@Override
			public void run() {
				for (int j=0; j<100; j++) 
					System.out.println(“Sono A”);
			}
		});
		t.start();
		for (int j=0; j<100; j++) 
			System.out.println(“Sono Main”);
	}
}