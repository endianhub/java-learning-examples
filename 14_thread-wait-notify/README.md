## 多线程间实现通讯

### 本节内容

1. 多线程之间如何实现通讯
2. 基于Wait、Notify实现生产者与消费者

<br>


多个线程之间相互通信需要涉及到 wait、notify

<br>


#### Wait、Notify 用法

Wait 会让当前线程变为阻塞状态，放弃 CPU 执行权，同时会释放锁。必须在代码块中使用且必须要通过 [对象锁].wait() 。

Notify 唤醒锁池阻塞的线程，从就绪到运行状态

因为涉及到对象锁，wait、notify 必须要在 synchronized 中使用


<br>


多个线程对同一个对象实现不同的操作，过程可以称作为多线之间实现通讯。

<br>


**为什么 Wait 需要释放锁？**

目的就是为了能够让生产者写数据，防止死锁




<br>

### 本节用例

1. 非线程安全
2. 线程安全 - 加锁导致线程为单线程
3. 线程安全 - 交替执行
4. join使用


<br

> 注意：join 内部使用的是 wait()，所以 wait 是对当前对象线程阻塞，而不是对调用线程对象阻塞。