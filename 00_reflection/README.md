## 反射

反射可以根据 class 文件获取类的信息内容，如：类名称、属性、方法，帮助示例化对象，动态调用某个方法。

### 应用场景：

1. JDBC驱动连接器 class.foraname("")
2. SpringIOC 容器框架 <bean id="userService" class="类路径">
3. 自定义注解（AOP反射）
4. 第三方框架
5. 逆向生成 Java 代码
6. 破解常用单例方法

### 反射技术使用

- Class 类：代表实体类，在运行的 java 应用程序中标识类和接口
- Field 类：代表类的成员变量
- Method类：代表类的方法
- Constructor类：代表类的构造方法




