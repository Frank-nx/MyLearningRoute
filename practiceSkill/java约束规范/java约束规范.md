1. POJO 类中布尔类型的变量，都不要加 is 前缀，否则部分框架解析会引起序列化错误。
   反例： 定义为基本数据类型 Boolean isDeleted 的属性，它的方法也是 isDeleted()，
   RPC框架在反向解析的时候， “误以为” 对应的属性名称是 deleted，导致属性获取不到，进而抛
   出异常。

2. 在 long 或者 Long 赋值时， 数值后使用大写的 L，不能是小写的 l，小写容易跟数字
  1 混淆，造成误解。

3. 关于基本数据类型与包装数据类型的使用标准如下：

   1） 【强制】 所有的 POJO 类属性必须使用包装数据类型。

   2） 【强制】 RPC 方法的返回值和参数必须使用包装数据类型。

   3） 【推荐】 所有的局部变量使用基本数据类型。
   
4. 【强制】 ArrayList的subList结果不可强转成ArrayList，否则会抛出 ClassCastException
      异常， 即 java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
      说明： subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList 而是 ArrayList
      的一个视图，对于 SubList 子列表的所有操作最终会反映到原列表上。
      
5. 【强制】在 subList 场景中， 高度注意对原集合元素的增加或删除， 均会导致子列表的遍历、
      增加、删除产生 ConcurrentModificationException 异常。
      
6. 【强制】 在 JDK7 版本及以上， Comparator 实现类要满足如下三个条件，不然 Arrays.sort，
   Collections.sort 会报 IllegalArgumentException 异常。
   
   说明： 三个条件如下
   
   1） x， y 的比较结果和 y， x 的比较结果相反。
   
   2） x>y， y>z， 则 x>z。
   
   3） x=y， 则 x， z 比较结果和 y， z 比较结果相同。
   
   反例： 下例中没有处理相等的情况，实际使用中可能会出现异常：
   ```
   new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
        return o1.getId() > o2.getId() ? 1 : -1;
      }
   };
   ```
   
7. 【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。
   说明： 使用线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决
   资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或
   者“过度切换”的问题。
   
8. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样
   的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
   说明： Executors 返回的线程池对象的弊端如下：
   
   1） FixedThreadPool 和 SingleThreadPool:
   允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。
   
   2） CachedThreadPool 和 ScheduledThreadPool:
   允许的创建线程数量为 Integer.MAX_VALUE， 可能会创建大量的线程，从而导致 OOM。
   
9. 【强制】 SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为
   static，必须加锁，或者使用 DateUtils 工具类。
   
   正例： 注意线程安全，使用 DateUtils。亦推荐如下处理：
   ```
   private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
            @Override
            protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
      };
   ```
   说明： 如果是 JDK8 的应用，可以使用 Instant 代替 Date， LocalDateTime 代替 Calendar，
   DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释： simple beautiful strong
   immutable thread-safe。
   
10. 【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造
    成死锁。
    
    说明： 线程一需要对表 A、 B、 C 依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序
    也必须是 A、 B、 C，否则可能出现死锁。
    
11. 【强制】并发修改同一记录时，避免更新丢失， 需要加锁。 要么在应用层加锁，要么在缓存加
    锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。
    
    说明： 如果每次访问冲突概率小于 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次
    数不得小于 3 次。
    
10. 【强制】多线程并行处理定时任务时， Timer 运行多个 TimeTask 时，只要其中之一没有捕获
    抛出的异常，其它任务便会自动终止运行，使用 ScheduledExecutorService 则没有这个问题。
    
11.【推荐】使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown
    方法，线程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行
    至 await 方法，直到超时才返回结果。
    
    说明： 注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。
    
12.【推荐】避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一
    seed 导致的性能下降。
    
    说明： Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。
    
    正例： 在 JDK7 之后，可以直接使用 API ThreadLocalRandom， 而在 JDK7 之前， 需要编码保
    证每个线程持有一个实例。
13.【推荐】 在并发场景下， 通过双重检查锁（double-checked locking） 实现延迟初始化的优
    化问题隐患(可参考 The "Double-Checked Locking is Broken" Declaration)， 推荐解
    决方案中较为简单一种（适用于 JDK5 及以上版本） ，将目标属性声明为 volatile 型。
    反例：
```
class LazyInitDemo {
    private Helper helper = null;
    public Helper getHelper() {
        if (helper == null) synchronized(this) {
            if (helper == null)
            helper = new Helper();
        }
        return helper;
    }
    // other methods and fields...
}
```

14.【参考】 volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，
    但是如果多写，同样无法解决线程安全问题。如果是 count++操作，使用如下类实现：
    
    ```
    AtomicInteger count = new AtomicInteger();
    count.addAndGet(1);
    ```
如果是 JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数）。

15.【参考】 HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在
    开发过程中可以使用其它数据结构或加锁来规避此风险。

16.【参考】 ThreadLocal 无法解决共享对象的更新问题， ThreadLocal 对象建议使用 static
    修饰。这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享
    此静态变量 ，也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只
    要是这个线程内定义的)都可以操控这个变量。

17.【推荐】除常用方法（如 getXxx/isXxx）等外，不要在条件判断中执行其它复杂的语句，将
   复杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性。
   说明： 很多 if 语句内的逻辑相当复杂，阅读者需要分析条件表达式的最终结果，才能明确什么
   样的条件执行什么样的语句，那么，如果阅读者分析逻辑表达式错误呢？
   正例：
   ```
   // 伪代码如下
      final boolean existed = (file.open(fileName, "w") != null) && (...) || (...);
        if (existed) {
        ...
      }
      反例：
      if ((file.open(fileName, "w") != null) && (...) || (...)) {
        ...
      }
   ```
18.【强制】在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
   说明： 不要在方法体内定义： Pattern pattern = Pattern.compile(“规则”);
   
19.【强制】后台输送给页面的变量必须加$!{var}——中间的感叹号。
说明： 如果 var 等于 null 或者不存在，那么${var}会直接显示在页面上。

20.【强制】注意 Math.random() 这个方法返回是 double 类型，注意取值的范围 0≤x<1（能够
取到零值，注意除零异常） ，如果想获取整数类型的随机数，不要将 x 放大 10 的若干倍然后
取整，直接使用 Random 对象的 nextInt 或者 nextLong 方法。

21.【强制】获取当前毫秒数 System.currentTimeMillis(); 而不是 new Date().getTime();
说明： 如果想获取更加精确的纳秒级时间值， 使用 System.nanoTime()的方式。在 JDK8 中，
针对统计时间等场景，推荐使用 Instant 类。

22.【强制】有 try 块放到了事务代码中， catch 异常后，如果需要回滚事务，一定要注意手动回
滚事务。

23.【强制】 finally 块必须对资源对象、流对象进行关闭，有异常也要做 try-catch。
说明： 如果 JDK7 及以上，可以使用 try-with-resources 方式。

24.【强制】不要在 finally 块中使用 return。
说明： finally 块中的 return 返回后方法结束执行，不会再执行 try 块中的 return 语句。

25.【推荐】防止 NPE，是程序员的基本修养，注意 NPE 产生的场景： NPE是java.lang.NullPointerException

   1）返回类型为基本数据类型， return 包装数据类型的对象时，自动拆箱有可能产生 NPE。
   反例： public int f() { return Integer 对象}， 如果为 null，自动解箱抛 NPE。
   
   2） 数据库的查询结果可能为 null。
   
   3） 集合里的元素即使 isNotEmpty，取出的数据元素也可能为 null。
   
   4） 远程调用返回对象时，一律要求进行空指针判断，防止 NPE。
   
   5） 对于 Session 中获取的数据，建议 NPE 检查，避免空指针。
   
   6） 级联调用 obj.getA().getB().getC()； 一连串调用，易产生 NPE。
   
   正例： 使用 JDK8 的 Optional 类来防止 NPE 问题。
   
   