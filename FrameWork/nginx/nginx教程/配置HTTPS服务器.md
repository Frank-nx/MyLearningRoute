## 一、HTTPS服务器

要配置HTTPS服务器，必须在server模块的listening sockets中启用ssl参数，
并且应指定服务器证书和私钥文件的位置 ：

```
server {
    listen              443 ssl;
    server_name         www.example.com;
    ssl_certificate     www.example.com.crt;
    ssl_certificate_key www.example.com.key;
    ssl_protocols       TLSv1 TLSv1.1 TLSv1.2;
    ssl_ciphers         HIGH:!aNULL:!MD5;
    ...
}
```
服务器证书是公共实体。
它被发送到连接到服务器的每个客户端。
私钥是一个安全的实体，应该存储在具有受限访问权限的文件中，
但是，它必须是`nginx`的主进程可读的。私钥可以替代地存储在与证书相同的文件中：

```
ssl_certificate www.example.com.cert; 
ssl_certificate_key www.example.com.cert;
```

在这种情况下，还应限制文件访问权限。
虽然证书和密钥存储在一个文件中，但只有证书才会发送到客户端。

指令`ssl_protocols`和`ssl_ciphers`可用于包括SSL/TLS的版本和密码的限定连接，。默认情况下，nginx使用“ ssl_protocols TLSv1 TLSv1.1 TLSv1.2”和“ ssl_ciphers HIGH:!aNULL:!MD5”，因此通常不需要显式配置它们。

## 二、HTTPS服务器优化

SSL操作会消耗额外的CPU资源。在多处理器系统上，
应运行多个工作进程，不少于可用CPU核心数。CPU占用最多的操作是SSL握手。
有两种方法可以最大限度地减少每个客户端的这些操作数量：
第一种方法是通过启用`keepalive`连接来通过一个连接发送多个请求，
第二种方法是重用SSL会话参数以避免SSL并行连接和后续连接。
会话存储在工作线程之间共享的SSL会话高速缓存中，
并由`ssl_session_cache` 指令配置 。
一兆字节的缓存包含大约4000个会话。默认缓存超时为5分钟。
它可以通过使用 `ssl_session_timeout` 指令来延长。
以下是针对具有10兆字节共享会话缓存的多核系统优化的示例配置：

```
worker_processes auto;

http {
    ssl_session_cache   shared:SSL:10m;
    ssl_session_timeout 10m;

    server {
        listen              443 ssl;
        server_name         www.example.com;
        keepalive_timeout   70;

        ssl_certificate     www.example.com.crt;
        ssl_certificate_key www.example.com.key;
        ssl_protocols       TLSv1 TLSv1.1 TLSv1.2;
        ssl_ciphers         HIGH:!aNULL:!MD5;
        ...
```

## 三、SSL证书链

某些浏览器可能会对由知名证书颁发机构签名的证书发出警告，
而其他浏览器可能会毫无问题地接受证书。
发生这种情况是因为颁发机构使用中间证书对服务器证书进行了签名，
该中间证书不存在于与特定浏览器一起分发的知名可信证书颁发机构的证书库中。
在这种情况下，授权机构提供一组链式证书，这些证书应连接到签名的服务器证书。
服务器证书必须出现在组合文件中的链接证书之前：

`$ cat www.example.com.crt bundle.crt > www.example.com.chained.crt`

生成的文件应该在 ssl_certificate指令中使用：

```
server {
    listen              443 ssl;
    server_name         www.example.com;
    ssl_certificate     www.example.com.chained.crt;
    ssl_certificate_key www.example.com.key;
    ...
}
```
如果服务器证书和软件包已按错误顺序连接，则nginx将无法启动并显示错误消息：

```
SSL_CTX_use_PrivateKey_file(" ... /www.example.com.key") failed
   (SSL: error:0B080074:x509 certificate routines:
    X509_check_private_key:key values mismatch)
```
因为nginx试图将私钥与bundle的第一个证书而不是服务器证书一起使用。