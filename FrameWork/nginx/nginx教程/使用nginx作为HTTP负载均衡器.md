## 一、nginx负载均衡的方法

`nginx`作为非常有效的`HTTP`负载平衡器，可以将流量分配到多个应用程序服务器，
使用`nginx`可以提高Web应用程序的可伸缩性和可靠性。

`nginx`支持以下负载平衡机制：

* `round-robin`　　　对应用程序服务器的请求以循环方式分发；
* `least-connected`　下一个请求被分配给活动连接数最少的服务器；
* `ip-hash`　　　　　　哈希函数用于确定应为下一个请求选择哪个服务器（基于客户端的IP地址）。

## 二、默认负载均衡配置

使用`nginx`进行负载均衡的最简单配置可能如下所示：
```
http { 
    upstream myapp1 { 
        server srv1.example.com; 
        server srv2.example.com; 
        server srv3.example.com; 
    } 

    server { 
        listen 80; 

        location / { 
            proxy_pass http：// myapp1; 
        } 
    } 
}
```
在上面的示例中，在`srv1-srv3`上运行了3个相同应用程序的实例。
如果未特别配置负载平衡方法，则默认为循环。
所有请求都代理到服务器组`myapp1`，`nginx`应用HTTP负载均衡来分发请求。

`nginx`中的反向代理实现包括HTTP，HTTPS，FastCGI，uwsgi，SCGI，memcached和gRPC的负载平衡。
要为HTTPS而不是HTTP配置负载平衡，只需使用`https`作为协议。

为FastCGI，uwsgi，SCGI，memcached或gRPC设置负载平衡时，
分别使用 `fastcgi_pass`， `uwsgi_pass`， `scgi_pass`， `memcached_pass`和 `grpc_pass`指令。

## 三、最小连接负载均衡

另一个负载平衡规则是最少连接的。在某些请求需要更长时间才能完成的情况下，
最小连接允许更公平地控制应用程序实例上的负载。

使用最少连接的负载平衡，
`nginx`将尽量不会使繁忙的应用程序服务器过载请求，
而是将新请求分发给不太繁忙的服务器。

当 `least_conn`指令用作服务器组配置的一部分时，
将激活`nginx`中的最小连接负载平衡 ：

```
upstream myapp1 {
        least_conn;
        server srv1.example.com;
        server srv2.example.com;
        server srv3.example.com;
    }
```

## 四、使用ip hash保持session持久性

通过循环或最少连接的负载平衡，每个后续客户端的请求可能会分发到不同的服务器。无法保证同一客户端始终指向同一服务器。

如果需要将客户端绑定到特定的应用程序服务器 ，使客户端的会话保持持久性，就可以使用ip-hash负载均衡机制。

要配置ip-hash负载平衡，只需将ip_hash 指令添加到服务器（上游）组配置：

## 五、使用加权负载均衡

通过使用服务器权重，甚至可以进一步影响`nginx`负载平衡算法。
在上面的示例中，未配置服务器权重，这意味着所有指定的服务器都被视为对特定负载平衡方法具有同等资格。

当为服务器指定权重参数时， 权重被计入负载平衡决策的一部分。

```
upstream myapp1 {
        server srv1.example.com weight=3;
        server srv2.example.com;
        server srv3.example.com;
    }
```
使用此配置，每5个新请求进入在应用程序实例中，
3个请求将定向到srv1，一个请求将转到srv2，
另一个请求转到srv3。

同样可以在最近的nginx版本中使用具有最少连接和ip-hash负载平衡的权重。

## 六、健康检查

`nginx`中的反向代理实现包括带内（或被动）服务器运行状况检查。
如果来自特定服务器的响应失败并显示错误，
则`nginx`会将此服务器标记为失败，
并将尝试避免为后续入站请求选择此服务器一段时间。

`max_fails`指令设置了请求与服务器进行通信，连续失败的次数，如果请求发出后，服务器在fail_timeout时间内没有成功的通信，也判定为失败。
默认情况下，`max_fails` 设置为1.当设置为0时，将禁用此服务器的运行状况检查。
该fail_timeout参数还定义服务器多久没有回应会被标记为失败，只要服务器失败将被标记。
在服务器发生故障后的fail_timeout时间间隔后，nginx将开始使用实时客户端的请求正常探测服务器。
如果探测成功，则将服务器标记正常。


