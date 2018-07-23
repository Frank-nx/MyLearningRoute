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
Default:-
Context：server，location


第三方模块



