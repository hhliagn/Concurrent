package com.lhh.thread;

public class 三个线程顺序打印ABC {

    public static void main(String[] args) throws Exception {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("A");
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("B");
            }
        });

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("C");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
