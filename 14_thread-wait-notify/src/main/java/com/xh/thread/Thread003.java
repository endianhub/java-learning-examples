package com.xh.thread;

/**
 * 线程安全 - 交替执行
 *
 * 如果共享对象的 flag 值为 false 的情况下，则只能写不能读
 * 如果共享对象的 flag 值为 false 的情况下，则只能读不能写
 */
public class Thread003 {
    class Res {
        public String userName;
        public char userSex;
        public boolean flag;
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
                        if (this.res.flag) {
                            // 当前线程为阻塞状态，并且释放锁
                            res.wait();
                        }
                        if (count == 0) {
                            this.res.userName = "小薇";
                            this.res.userSex = '女';
                        } else {
                            this.res.userName = "余胜军";
                            this.res.userSex = '男';
                        }
                        this.res.flag = true;
                        this.res.notify();
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
                try {
                    synchronized (res) {
                        if (!res.flag) {
                            res.wait();
                        }
                        System.out.println(res.userName + "," + res.userSex);
                        res.flag = false;
                        res.notify();
                    }
                } catch (Exception e) {

                }

            }
        }
    }

    public static void main(String[] args) {
        new Thread003().start();
    }

    private void start() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutThread outThread = new OutThread(res);
        inputThread.start();
        outThread.start();
    }


}
