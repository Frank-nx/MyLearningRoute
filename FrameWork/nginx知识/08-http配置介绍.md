## http配置属性

### 网络连接相关的设置

- keepalive_timeout time;

保持连接的超时时长，默认为75s

```
Syntax:keepalive_timeout timeout [header_timeout];
Default:keepalive_timeout 75s;
Context:http, server, location;
```

- keepalive_requests N；

在一次长连接上允许承载的最大请求数

```
Syntax:keepalive_requests number;
Default:keepalive_requests 100;
Context:http, server, location
```

- keepalive_disable [msie6|safari |none]；

对指定的浏览器禁止使用长连接

```
Syntax:keepalive_disable none | browser ...;
Default:keepalive_disable msie6;
Context:http, server, location
```
### 对客户端请求的限制

- limit_except method ...{ ... }

指定范围之外的其他方法的访问控制，只能用于location中
```
Syntax:limit_except method ... { ... }
Default:—
Context:location
```
method可以是下列中的一个:GET, HEAD, POST, PUT, DELETE, MKCOL, COPY, MOVE, OPTIONS, PROPFIND, PROPPATCH, LOCK, UNLOCK, or PATCH.
允许了GET方法，HEAD方法也会被允许。

- client_max_body_size SIZE;

http请求包体的最大值，常用于限定客户端所能够请求的最大包体，根据请求首部中的Content-Length来检查，以避免无用的传输

```
Syntax:client_max_body_size size;
Default:client_max_body_size 1m;
Context:http, server, location
```

- limit_rate speed;

限制客户端每秒传输的字节数，默认为0，表示没有限制

```
Syntax:limit_rate rate;
Default:limit_rate 0;
Context:http, server, location, if in location
```

### 文件操作的优化

- sendfile on|off

是否启用sendfile功能

```
Syntax:sendfile on | off;
Default:sendfile off;
Context:http, server, location, if in location
```

- aio on|off

是否启用aio功能
```
Syntax:aio on | off | threads[=pool];
Default:aio off;
Context:http, server, location
```

### 对客户端请求的特殊处理

- log_not_found on|off

用户访问的文件不存在时，是否将其记录到错误日志中

```
Syntax:log_not_found on | off;
Default:log_not_found on;
Context:http, server, location
```

- resolver address；

指定nginx使用的dns服务器地址，用于上游服务器的名称解析
```
Syntax:	resolver address ... [valid=time] [ipv6=on|off];
Default:—
Context:http, server, location
```









