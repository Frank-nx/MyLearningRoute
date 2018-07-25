## 一、基于名称的虚拟服务器

`nginx`首先决定哪个服务器应该处理`request`。
让我们从一个简单的配置开始，其中所有三个虚拟服务器都监听端口*:80

```
server {
    listen      80;
    server_name example.org www.example.org;
    ...
}

server {
    listen      80;
    server_name example.net www.example.net;
    ...
}

server {
    listen      80;
    server_name example.com www.example.com;
    ...
}
```
在这个`nginx`的配置中，只有`request`的头字段`host`去决定`request`
应该被定位到哪个服务器。如果它的值没有匹配上任何一个`server_name`或者是
`request`根本不包含这个头字段，nginx会自动将这个`request`定位到这个端口的
默认服务器上，上面的配置中，默认服务器是第一个，这是`nginx`标准的默认行为，
同时，开发者可以通过在监听端口后面加上`default_server`属性来显示的指定默认服务器。

```
server {
    listen      80 default_server;
    server_name example.net www.example.net;
    ...
}
```
* `default_server`属性从0.8.21版本开始使用，更早期的版本使用的是`default`

* `default_server`是监听端口的属性，不是`server_name`的。

## 二、如何防止处理没有定义服务器名字的`request`

如果没有`Host`头字段的`rquest`不应该被允许，仅仅用来除去这些`request`
的服务器可以这样定义。

```
server {
    listen      80;
    server_name "";
    return      444;
}
```
这里，服务器名称设置为一个空字符串，它将匹配没有“Host”头字段的请求，
并返回一个特殊的nginx非标准代码444来关闭连接。

* 从版本0.8.48开始，这就是`server name`的默认配置，所以`server_name "";`可以
以省略，但在0.8.48更早版本中，默认的`server name`是机器的hostname

## 三、将基于名字和基于IP混合的服务器

一些虚拟服务器监听不同的地址：

```
server {
    listen      192.168.1.1:80;
    server_name example.org www.example.org;
    ...
}

server {
    listen      192.168.1.1:80;
    server_name example.net www.example.net;
    ...
}

server {
    listen      192.168.1.2:80;
    server_name example.com www.example.com;
    ...
}
```
在此配置中，nginx首先根据服务器块的listen指令 测试请求的IP地址和端口。
然后将查看request的“Host”头字段与IP地址和端口匹配上的服务器块中server_name。
如果未找到服务器名称，则默认服务器将处理该请求。
例如，一个针对www.example.com，从192.168.1.1:80端口上来的`request`将由192.168.1.1:80端口的默认服务器处理，
即由第一个服务器处理，因为没有为此端口定义。 www.example.com

如前所述，默认服务器是监听端口的属性，可以为不同的端口定义不同的默认服务器：
