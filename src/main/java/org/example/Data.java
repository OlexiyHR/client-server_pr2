package org.example;

public class Data {
    private int state=1;

    public int getState() { return state; }

    public synchronized void Tic() throws InterruptedException {
        while (state != 1) {
            wait();
        }
        System.out.print("Tic-");
        state=2;
        notifyAll();
    }
    public synchronized void Tak() throws InterruptedException {
        while (state != 2) {
            wait();
        }
        System.out.print("Tak-");
        state=3;
        notifyAll();
    }
    public synchronized void Toy() throws InterruptedException {
        while (state != 3) {
            wait();
        }
        System.out.println("Toy");
        state=1;
        notifyAll();
    }
}
