## 多线程间同步

### 本节内容

1. 什么是线程安全问题  
2. 如何解决线程安全问题
3. Synchronized锁基本的用法
4. Lock锁重入与读写锁用法
5. Synchronized与Lock锁之间的区别
6. 如何理解锁的可重入性
7. 多线程死锁产生的原因
8. 如何排查程序中死锁的现象。

<br>

#### 什么是线程安全

当多个线程同时共享同一个全局变量做写的操作时候，可能会受到其他线程的干扰，就会产生线程安全问题，导致数据脏读。

产生背景：同时做写的时候


<br>


#### 如何解决线程安全问题

核心思想：解决多线程安全问题必须在同一时刻，只能有一个线程执行，那么这个时候整个程序就变成单线程执行。

<br>


####  java中如何解决线程问题

通过使用 Lock锁、synchronized、cas无锁、手写乐观锁 解决线程安全问题。

**解决办法：**

1. 使用java锁的机制 Synchronized、或者Lock锁、还有CAS无锁机制。
2. 对于代码中如果在多线程同时执行操作的情况下，可能会受到其他线程的干扰的代码采用锁的机制，在同一个时刻只能保证只有一个线程去执行。也就是只要获取到锁的之后，才能够进入该代码块执行，代码执行完之后释放锁之后其他线程才可以执行。
3. 没有获取到锁的线程，则一直会排队阻塞，整个过程是一个悲观状态。

<br>

当通过使用加锁的方式让线程安全，就会导致程序执行效率变低。

加锁的好处：同一时间只能有一个线程执行

加锁的缺点：程序执行效率变低


<br>


#### synchronized加锁后如何保证线程安全问题

在多个线程中，同时执行同一个方法的时候，必须要获取锁，只有获取到锁的情况下，才可以进入到该方法执行。

**举个例子**

如果A线程获取到锁的情况下，那么B线程就会一直阻塞等待，整个过程是一个悲观锁。必须要等待A线程执行完代码释放锁后，B线程从新进入到获取锁的状态。

**synchronized 在什么情况下释放锁？**

在 run 方法执行完成或者程序抛出异常的情况下自动释放锁。

**synchronized 使用方式**

代码块形式：使用到 synchronized 锁的时候可以使用任意对象锁作为锁；如果在方法上加上 synchronized 默认是使用 this 锁。

- 注意：如果方法是一个静态方法的情况下就使用当前类的 class 字节码作为锁。非静态方法则使用 this

<br>

**为什么使用锁之后，能够保证线程安全？**

核心思路：在同一时刻，能够有多个线程操作共享变量。

因为使用锁了之后，多个线程在同时执行该代码的时候，必须要获取到锁，只有获取到锁的情况下，才可以进入到该方法。

比如A线程获取到了之后，B线程则一直阻塞等待，必须等待A线程执行完毕释放了锁之后，B才可以重新进入到获取锁的过程。


<br>


#### 重入锁

如果当前线程获取到锁的情况下，在此请求的时候可以直接获取锁。

基本锁都具有可重入性

如果锁不具有重入性的情况，则可能会放生死锁。


<br>


#### 多线程死锁的现象

产生背景：在同步中嵌套同步，也就是在锁中再嵌套锁

**程序中死锁诊断工具**

查找到当前JVM环境变量E:\java8\jdk  找到 jconsole.exe 工具


<br>


#### Lock与Synchronized锁的区别

1. Synchronized属于java内置的关键字，而lock锁是基于aqs封装的一个锁的框架
2. Synchronized当代码执行结束自动释放锁，而lock需要人工释放锁，相对于来说lock锁更加灵活。

<br>

### 本节用例

1. 模拟多线程抢票
2. 模拟死锁
3. 重入锁
4. Lock锁 - 重入锁
5. 读写锁
