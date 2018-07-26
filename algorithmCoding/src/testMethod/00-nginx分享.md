## 一、Nginx介绍

`Nginx`（发音同`engine x`）是一个异步框架的Web服务器，也可以用作反向代理，负载平衡器和HTTP缓存
。该软件由Igor Sysoev创建，并于2004年首次公开发布。同名公司成立于2011年，以提供支持。

`Nginx`是一款免费的开源软件，根据类BSD许可证的条款发布。
一大部分Web服务器使用Nginx，通常作为负载均衡器。

Nginx有五大优点：模块化、事件驱动、异步、非阻塞、多进程单线程。Nginx 由内核和模块组成，其中，内核的设计非常微小和简洁，完成的工作也非常简单，
仅仅通过查找配置文件将客户端请求映射到一个 location block（location 是 Nginx配置中的一个指令，用于 URL 匹配），
而在这个 location 中所配置的每个指令将会启动不同的模块去完成相应的工作。Nginx 的模块从结构上分为

核心模块、基础模块和第三方模块： 

* 核心模块：HTTP 模块、 EVENT 模块和 MAIL 模块
* 基础模块： HTTP Access 模块、HTTP FastCGI 模块、HTTP Proxy 模块和 HTTP Rewrite模块，
* 第三方模块：HTTP Upstream Request Hash 模块、 Notice 模块和 HTTP Access Key模块。

nginx的常见指令
```
启动Nginx：start nginx

验证配置是否正确: nginx -t

查看Nginx的版本号：nginx -V

快速停止或关闭Nginx：nginx -s stop

正常停止或关闭Nginx：nginx -s quit

配置文件修改重装载命令：nginx -s reload
```

## 二、nginx原理

<a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/01-nginx%E7%9A%84%E8%BF%9B%E7%A8%8B%E6%A8%A1%E5%9E%8B.md" target="_blank">nginx进程</a>

在处理请求时，Nginx是分为11个不同的阶段来完成的。
在Nginx中，模块对请求进行操作的唯一途径是在这11个阶段中嵌入自己的钩子函数。

![](pages/请求的阶段.png)

1. 一共分为了11个阶段，“理论上”请求的处理过程是严格按照这个顺序来执行的。
2. 并不是每个阶段都必须要有钩子，如上面的几个阶段是没有嵌入钩子的
3. 每个阶段理论上可以嵌入任意多的钩子数量
4. 第三方模块能够嵌入的阶段有限：0，1，3，5，6，9，10。
而其它阶段（2，4，7，8）的钩子是由HTTP框架来嵌入的。

## 三、nginx的配置

nginx的默认配置

```
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
<a href="" target="_blank">main部分的配置</a>

```
http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;

    server {
        listen       80;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

        location / {
            root   html;
            index  index.html index.htm;
        }

        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}
```
http配置结构简化如下：

http{      #http块


> > ...   #http全局块
    
>>server        #server块
    
>>{

>>>>...       #server全局块
        
>>>>location [PATTERN]   #location块
        
>>>>{
        
>>>>>>...
            
>>>>}

>>>>location [PATTERN]{...}
    
>>}

>>server{...}

}

1. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/02-nginx%E5%A6%82%E4%BD%95%E5%A4%84%E7%90%86%E8%AF%B7%E6%B1%82.md" target="_blank">nginx处理请求</a>

2. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/03-nginx%E4%B8%AD%E7%9A%84server_name.md" target="_blank">配置中server_name的问题</a>

3. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/02-%E4%BD%BF%E7%94%A8nginx%E4%BD%9C%E4%B8%BAHTTP%E8%B4%9F%E8%BD%BD%E5%9D%87%E8%A1%A1%E5%99%A8.md" target="_blank">配置nginx作为HTTP负载均衡器</a>

4. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/04-nginx%E7%9A%84location.md" target="_blank">nginx的location匹配规则</a>

5. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/05-ngnix%E7%9A%84rewrite%E6%8C%87%E4%BB%A4.md" target="_blank">nginx中的rewrite指令</a>

6. <a href="http://gitlab.qiyi.domain/vip/vip-internship/blob/nixuan_daily/20180620_%E5%80%AA%E6%97%8B/20180725_%E5%80%AA%E6%97%8B/06-nginx%E7%9A%84%E5%8F%98%E9%87%8F.md" target="_blank">nginx使用中的变量注意事项</a>


