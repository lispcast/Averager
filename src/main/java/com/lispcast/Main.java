package com.lispcast;

public class Main extends Thread{

    private NumberGenerator ngs[];
    private NumberCruncher nc;

    public Main(int threads) {
        ngs = new NumberGenerator[threads];
        nc  = new NumberCruncher();

        for(int i = 0; i < threads; i++) {
            ngs[i] = new NumberGenerator(nc);
        }
    }

    public void run() {
        for(int i = 0; i < ngs.length; i++) {
            ngs[i].start();
        }
        for(Number x: (Iterable<Number>)nc) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main(1000);
        m.start();
        Thread.sleep(10000);
        System.exit(0);
    }
}
