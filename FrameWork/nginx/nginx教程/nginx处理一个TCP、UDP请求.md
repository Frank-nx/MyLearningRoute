一个来自客户端的TCP/UDP session经过连续的阶段被处理

`Post-accept`

这是在接受客户端连接之后的第一个阶段，`ngx_stream_realip_module` 模块在这个阶段被调用。

`Pre-access`

初步检查访问。`ngx_stream_limit_conn_module` 模块在这个阶段被调用。

`Access`

实际数据处理前的客户端访问限制。`ngx_stream_access_module` 模块在这个阶段被调用。

`SSL`

TLS / SSL终端。`ngx_stream_ssl_module` 模块在这个阶段被调用。

`Preread`

将初始数据字节读入预读缓冲区， 以允许如`ngx_stream_ssl_preread_module`之类的模块 在处理之前分析数据。

`Content`

实际处理数据的强制阶段（通常代理到上游服务器）或指定值返回给客户端。

`Log`

记录客户端会话处理结果的最后阶段。`ngx_stream_log_module` 模块在这个阶段被调用。