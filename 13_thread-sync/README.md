如何解决线程安全问题

核心思想：在同一时刻，只能有一个线程执行，那么这个时候整个程序就变成单线程执行。
只要加上说缺点：对程序执行效率非常低

java中如何解决线程问题
Lock锁、synchronized、cas无锁、手写乐观锁


synchronized加锁后如何保证线程安全问题

在多个线程中，同时执行同一个方法的时候，必须要获取锁，只有获取到锁的情况下，才可以进入到该方法执行。

举个例子
如果A线程获取到锁的情况下，那么B线程就会一直阻塞等待，整个过程是一个悲观锁。
必须要等待A线程执行完代码释放锁后，B线程从新进入到获取锁的状态。

synchronized 在什么情况下释放锁？
在 run 方法执行完成或者程序抛出异常的情况下自动释放锁。

synchronized 使用方式
代码形式
使用到 synchronized 锁的时候可以使用任意对象锁作为锁
如果在方法上加上 synchronized 默认是使用 this 锁 

注意：如果方法是一个静态方法的情况下就使用当前类的 class 字节码作为锁。非静态方法则使用 this


重入锁

基本锁都具有可重入性
如果锁不具有重入性的情况，则可能会放生死锁。

如果当前线程获取到锁的情况下，在此请求的时候可以直接获取锁



多线程死锁的现象

产生背景：在同步中嵌套同步，也就是在锁中再嵌套锁


Java 默认创建的线程都是用户线程
thread.setDaemon(false) 用户线程
thread.setDaemon(true) 守护线程