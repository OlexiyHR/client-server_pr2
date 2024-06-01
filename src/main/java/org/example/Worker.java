package org.example;

public class Worker extends Thread{

	private int id;
	private Data data;
	
	public Worker(int id, Data d){
		this.id = id;
		data = d;
		this.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				switch (id) {
					case 1:
						data.Tic();
						break;
					case 2:
						data.Tak();
						break;
					case 3:
						data.Toy();
						break;
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		synchronized (data) {
			data.notifyAll();
		}
	}
}
