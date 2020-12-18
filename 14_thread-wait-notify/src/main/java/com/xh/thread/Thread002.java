package com.xh.thread;

/**
 * 非线程安全
 * <p>
 * 由于使用锁的缘故导致线程为单线程执行
 */
public class Thread002 {
    class Res {
        public String userName;
        public char userSex;
    }

    class InputThread extends Thread {

        private Res res;

        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            try {
                int count = 0;
                while (true) {
                    synchronized (res) {
                        if (count == 0) {
                            this.res.userName = "小薇";
                            this.res.userSex = '女';
                        } else {
                            this.res.userName = "余胜军";
                            this.res.userSex = '男';
                        }
                    }
                    count = (count + 1) % 2;
                }
            } catch (Exception e) {

            }
        }
    }

    class OutThread extends Thread {

        private Res res;

        public OutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    System.out.println(res.userName + "," + res.userSex);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread002().start();
    }

    private void start() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutThread outThread = new OutThread(res);
        inputThread.start();
        outThread.start();
    }


}
