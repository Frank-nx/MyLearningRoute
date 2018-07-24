error.log nginx处理HTTP请求错误的状态以及nginx本身运行的错误状态，会按照不同的级别
记录到error.log里面，

access会记录nginx处理http请求的访问状态，分析每次访问的请求和客户进行的交互
以及对行为进行分析，

log_format只能配置在http模块中

Nginx变量 arg_PARAMETER（request）、http_HEADER（request的head）、sent_http_HEADER（response的header）
转换时小写并横杠转下划线

内置变量-nginx.org nginx -V 

nginx官方模块 
--with-http_stub_status_module  nginx的客户端状态

Syntax：stub_status;
Default:-没有配置
Context：server，location

--with-http_random_index_module  目录中选择一个随机主页,但不会选择.开始的隐藏文件

```
Syntax：random_index on | off;
Default:random_index off
Context：location
```

--with-http_sub_module  http内容替换

```
Syntax：sub_filter string replacement;string是要替换的内容，replacement是替换之后的内容，内容使用单引号
Default:--没开
Context：http,server,location
```

```
Syntax：sub_filter_last_modified on | off; 
Default:sub_filter_last_modified off;
Context：http,server,location
```

```
Syntax：sub_filter_once on | off; on匹配指定的第一个，off是对指定的都进行匹配
Default:sub_filter_once on;
Context：http,server,location
```

连接频率限制 limit_conn_module

```
Syntax：limit_conn_zone key zone=name:size;
Default:--
Context：http
```

```
Syntax：limit_conn zone number;
Default:--
Context：http,server,location
```

请求频率限制 limit_req_module

```
Syntax：limit_req_zone key zone=name:size rate=rate;
Default:--
Context：http
binary_remote_addr会比remote_addr小10个字节左右的空间
```

```
Syntax：limit_req zone=name [burst=number][nodelay];
Default:--
Context：http,server,location
```



第三方模块



