package com.lhh.thread;

public class 两个线程循环打印AB {

    static class Word{
        private String str;

        public Word(String string){
            str=string;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

    static int i=0;
    static Word word=new Word("A");

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<100){
                    synchronized (word){
                        if (word.getStr().equals("B")){
                            try {
                                word.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(word.getStr());
                            i++;
                            word.setStr("B");
                            word.notify();
                        }
                    }
                }
            }
        });

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                while (i<100){
                    synchronized (word){
                        if (word.getStr().equals("A")){
                            try {
                                word.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println(word.getStr());
                            i++;
                            word.setStr("B");
                            word.notify();
                        }
                    }
                }
            }
        });
    }
}
