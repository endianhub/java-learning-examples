## 单例模式

### 本节内容：

1. 单例模式基本与设计思想概念
2. 单例模式的应用场景有那些
3. 懒汉式为什么需要双重检验锁
4. Java创建对象有那些方式
5. 如何防止单例被反射、序列化破解

<br>

### 本节用例：

> 创建单例的方式方法有很多种，这里只列举常用的单例模式

<br>

### 单例应用场景

1. 项目中定义的配置文件
2. Servlet对象默认就是单例
3. 线程池、数据库连接池
4. Spring中Bean对象默认就是单例
5. 实现网站计数器
6. Jvm内置缓存框架（定义单例HashMap）
7. 定义枚举常量信息

<br>

### 单例优缺点

- 优点：能够节约当前堆内存，不需要频繁New对象，能够快速访问。
- 缺点：当多个线程访问同一个单例对象的时候可能会存在线程安全

> 网上有资料说单例可以防止内存溢出，这句话不完全正确；因为单例是存放在永久区中，不会被GC回收；当单例过多时会发生内存溢出问题

<br>

### 创建对象的方式

1. 直接new对象
2. 采用克隆对象
3. 使用反射创建对象
4. 序列化与反序列化


<br>