package com.lispcast;

import java.util.Random;

/**
 * Created by eric on 1/3/17.
 */
public class NumberGenerator extends Thread {
    private Random r;
    private NumberCruncher nc;

    public NumberGenerator(NumberCruncher nc) {
        this.r = new Random();
        this.nc = nc;
    }

    public void run() {
        while(true) {
            nc.average(r.nextInt(1000));
        }
    }
}
