package com.xh.thread;

/**
 * 非线程安全
 * <p>
 * 生产者一直生产，消费者一直消费
 */
public class Thread001 {
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
            int count = 0;
            while (true) {
                if (count == 0) {
                    this.res.userName = "小薇";
                    this.res.userSex = '女';
                } else {
                    this.res.userName = "余胜军";
                    this.res.userSex = '男';
                }

                // 负载均衡算法 轮询
                count = (count + 1) % 2;
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
                System.out.println(res.userName + "," + res.userSex);
            }
        }
    }

    public static void main(String[] args) {
        new Thread001().start();
    }

    private void start() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutThread outThread = new OutThread(res);
        inputThread.start();
        outThread.start();
    }


}
