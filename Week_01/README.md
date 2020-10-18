学习笔记

# JVM 核心技术 -- 基础知识

## 1. JVM 基础知识
编程语言
- 面向过程、面向对象、面向行数
- 静态类型、动态类型
- 编译执行、解释执行
- 有虚拟机、无虚拟机
- 有GC、无GC

## 2. 字节码技术
字节码
Java bytecode 由单字节（byte）的指令组成，理论上最多支持 256 个操作码（opcode）。
实际上 Java 只使用了 200 左右的操作码，还有一些操作码则保留给调试操作

根据指令的性质，主要分为四个大类：
1. 栈操作指令，包括与局部变量交互的指令
2. 程序流程控制指令
3. 对象操作指令，包括方法调用指令
4. 算术运算以及类型转换指令

方法调用指令
- invokestatic: 用于调用某个类的静态方法，这个方法是调用指令中最快的方法
- invokespecial: 用来调用构造函数，但是也可以调用同一个类中的 private 方法，以及可见的超类方法
- invokevirtual: 调用公共，受保护和 package 级的私有方法
- invokeinterface: 当通过接口引用来调用方法时，将会编译为 invokeinterface 指令
- invokedynamic: JDK7 新增的指令，是实现“动态类型语言”支持而进行的升级改进，同时也是 JDK8 以后 lambda 表达式的实现基础

# 3. JVM 类加载器
类生命周期
1. 加载（Loading）: 找 Class 文件
2. 验证（Verification）: 验证格式、依赖
3. 准备（Preparation）: 静态字段、方发表
4. 解析（Resolution）: 符号解析为引用
5. 初始化（Initialization）: 构造器、静态变量赋值、静态代码块
6. 使用（Using）
7. 卸载（UnLoading）

类的加载时机
1. 当虚拟机启动时，初始化用户指令的主类，就是启动执行的 main 方法所在的类
2. 当遇到用以新建目标类实例的 new 指令时，初始化 new 指令的目标类，就是 new 一个类的时候要初始化
3. 当遇到调用静态方法的指令时，初始化该静态方法所在的类
4. 当遇到访问静态字段的指令时，初始化该静态方法所在的类
5. 子类的初始化会触发父类的初始化
6. 如果一个接口定义了 default 方法，那么直接实现或者间接实现该接口的类的初始化，会触发该接口的初始化
7. 使用反射 API 对某个类进行反射调用时，如果该对象未被实例化，初始化该类
8. 初次调用 MethodHandle 实例时，初始化该 MethodHandle 指向的方法所在的类 （与反射一样）

不会初始化（可能会加载）
1. 通过子类引用父类的静态字段，只会触发父类的初始化，而不会触发子类的初始化
2. 定义对象数组，不会触发该类的初始化
3. 常量在编译期间会存入调用类的常量池中，本质上并没有直接引用定义常量的类，不会触发定义常量所在类的初始化
4. 通过类名获取 Class 对象，不会触发类的初始化，Hello.class 不会让 Hello 类初始化
5. 用过 Class.forName 加载指定类时，如果指定参数 initialize 为 false 时，也不会触发类的初始化
    ```
    public static Class<?> forName(String name, boolean initialize, ClassLoader loader) throws ClassNotFoundException {}   
    ```
6. 通过 ClassLoader 默认的 loadClass 方法，也不会触发初始化动作（加载了，但是不初始化）

三类加载器
1. 启动类加载器（BootstrapClassLoader）
2. 扩展类加载器（ExtClassLoader）
3. 应用类加载器（AppClassLoader）

加载器特点
1. 双亲委托
2. 负责依赖
3. 缓存加载

# 4. JVM 内存模型

# 5. JVM 启动参数
1. 系统属性参数
2. 运行模式参数
3. 堆内存设置参数
4. GC 设置参数
5. 分析诊断参数
6. JavaAgent 参数