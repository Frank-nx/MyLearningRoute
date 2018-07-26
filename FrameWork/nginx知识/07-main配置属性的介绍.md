## main段配置

```
#user  nobody;
worker_processes  1;
 
#error_log  logs/error.log;
#user  nobody;
worker_processes  1;
 
#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;
 
#pid        logs/nginx.pid;
 
 
events {
    worker_connections  1024;
}
```

- user username [groupname]；
  
以哪个用户身份运行，编译安装时指定了用户和组，如果想改变在这里定义就可以
  
- pid /path/to/pid_filename;    
  
指定nginx的pid文件
  
### 优化性能相关的配置

- worker_procrsses N;

As a general rule you need the only worker with large number of 
worker_connections, say 10,000 or 20,000.

However, if nginx does CPU-intensive work as SSL or gzipping and
you have 2 or more CPU, then you may set worker_processes to be 
equal to CPU number.

Besides, if you serve many static files and the total size of the 
files is bigger than memory, then you may increase worker_processes 
to utilize a full disk bandwidth.

Igor Sysoev

- worker_cpu_affinity CPUMASK ....;     # cpu亲缘性

 0001  #第1个cpu核心

 0010  #第2个

 0100

 1000

```
worker_processes    4;
worker_cpu_affinity 0001 0010 0100 1000;
```

```
worker_processes    2;
worker_cpu_affinity 0101 1010;
```
binds the first worker process to CPU0/CPU2, 
and the second worker process to CPU1/CPU3. 
The second example is suitable for hyper-threading.
（第二个例子适合超线程）

1.9.10版本后允许使用auto自动绑定到可用的cpu上
```
worker_processes auto;
worker_cpu_affinity auto;
```

### 调试、定位相关的配置

只在调试nginx时使用

- daemon [on|off];
  
关闭提供守护进程的模式，是否让nignx运行于后台；调试时应该为off，使得所有信息直接输出在控制台，默认为on
```
Syntax:daemon on | off;
Default:daemon on;
Context:main
```
- master_process on|off;

是否以master/worker模式运行nginx，默认为on，调试时可以设置为off以方便追踪

- error_log /path/to/error_log LEVEL;

错误日志文件及其级别，调试时可以使用debug级别，
但要求在编译时必须使用--with-debug启用debug功能，
默认通常为error级别

（日志输出级别有debug、info、notice、warn、
error、crit可供选择，其中，debug输出日志最为最详细，
而crit输出日志最少）

```
Syntax:error_log file [level];
Default:error_log logs/error.log error;
Context:main, http, mail, stream, server, location
```
### 与事件有关的配置

在events段中，定义io工作模式

- accept_mutex [on|off]；

是否打开nginx的负载均衡锁，此锁能够让多个worker进行轮流地、
序列化地与新的客户端建立连接；
而通常当一个worker进程的负载达到其上限的7/8，
master就尽可能不将请求调度至worker。

```
Syntax:accept_mutex on | off;
Default:accept_mutex off;
Context:events
```

- lock_file /path/to/lock_file；
 指定锁文件的路径

```
Syntax:lock_file file;
Default:lock_file logs/nginx.lock;
Context:main
```
- accept_mutex_delay time；

```
Syntax:accept_mutex_delay time;
Default:accept_mutex_delay 500ms;
Context:events
```
使用accept锁以后，一个worker进程为取得accept锁的等待时长，
即用户建立等待的时间；如果某worker进程在某次试图取得锁时失败了
（其它进程正在使用），至少要等待Nms才能再一次请求锁

- multi_accept on|off；

是否允许一次性地响应多个用户请求，默认为off

- use [epoll|rtsig|select|poll]；  # 关键

 指定要使用的连接处理方法。
 通常不需要显式地指定它，因为nginx将默认使用最有效的方法。

- worker_connections N；

每个worker能够并发响应的最大请求数，

```
Syntax:worker_connections number;
Default:worker_connections 512;
Context:events
```



