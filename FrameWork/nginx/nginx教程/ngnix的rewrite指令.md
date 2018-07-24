
## 一、nginx中rewrite的简单介绍
rewrite功能就是，使用nginx提供的全局变量或自己设置的变量，
结合正则表达式和标志位实现url重写以及重定向。
rewrite只能放在`server{}`,`location{}`,`if{}`中，
并且只能对域名后边的除去传递的参数外的字符串起作用。

例如`http://seanlook.com/a/we/index.PHP?id=1&u=str` 只对`/a/we/index.php`重写。

语法rewrite regex replacement [flag];

表明看rewrite和location功能有点像，都能实现跳转，
主要区别在于rewrite是在同一域名内更改获取资源的路径，
而location是对一类路径做控制访问或反向代理，可以proxy_pass到其他机器。
很多情况下rewrite也会写在location里，它们的执行顺序是：

1. 执行server块的rewrite指令
2. 执行location匹配
3. 执行选定的location中的rewrite指令

如果其中某步URI被重写，则重新循环执行1-3，直到找到真实存在的文件；
循环超过10次，则返回500 `Internal Server Error`错误。


last与break的区别：

1. `last`一般写在`server`和`if`中，而`break`一般使用在`location`中
2. `last`不终止重写后的`url`匹配，即新的`url`会再从`server`走一遍匹配流程，而`break`终止重写后的匹配
3. `break`和`last`都能阻止继续执行后面的`rewrite`指令

该ngx_http_rewrite_module模块用于使用PCRE正则表达式更改请求URI，返回重定向，
以及有条件地选择配置。

break，if，return，rewrite和set指令以下面的顺序执行：

* 首先顺序执行server块中的rewrite模块指令，得到rewrite后的请求URI
* 然后循环执行如下指令

(1). 依据rewrite后的请求URI，匹配定义的 location 块
   
(2). 顺序执行匹配到的 location 中的rewrite模块指令

如果没有遇到中断循环标志，此循环最多执行10次，
但是我们可以使用break指令来中断rewrite后的新一轮的循环

## break

```
Syntax:	break;
Default:	—
Context:	server, location, if
```
停止执行目前ngx_http_rewrite_module的指令集，但是其他模块指令是不受影响的

```
server {
    listen 8080;
    # 此处 break 会停止执行 server 块的 return 指令(return 指令属于rewrite模块)
    # 如果把它注释掉 则所有请求进来都返回 ok
    break;
    return 200 "ok";
    location = /testbreak {
        break;
        return 200 $request_uri;
        proxy_pass http://127.0.0.1:8080/other;
    }
    location / {
        return 200 $request_uri;
    }
}

# 发送请求如下
# curl 127.0.0.1:8080/testbreak
# /other

# 可以看到 返回 `/other` 而不是 `/testbreak`，说明 `proxy_pass` 指令还是被执行了
# 也就是说 其他模块的指令是不会被 break 中断执行的
# (proxy_pass是ngx_http_proxy_module的指令)
```

## if
```
Syntax:	if (condition) { ... }
Default:	—
Context:	server, location
```

if 中的几种判断条件：
1. 一个变量名，如果变量 $variable 的值为空字符串或者字符串"0"，则为false
2. 变量与一个字符串的比较 相等为(=) 不相等为(!=) 注意此处不要把相等当做赋值语句啊
3. 变量与一个正则表达式的模式匹配 操作符可以是(~ 区分大小写的正则匹配， ~*不区分大小写的正则匹配， !~ !~*，前面两者的非)
4. 检测文件是否存在 使用 -f(存在) 和 !-f(不存在)
5. 检测路径是否存在 使用 -d(存在) 和 !-d(不存在) 后面判断可以是字符串也可是变量
6. 检测文件、路径、或者链接文件是否存在 使用 -e(存在) 和 !-e(不存在) 后面判断可以是字符串也可是变量
7. 检测文件是否为可执行文件 使用 -x(可执行) 和 !-x(不可执行) 后面判断可以是字符串也可是变量

## return
```
Syntax:	return code [text];
return code URL;
return URL;
Default:—
Context:	server, location, if
```

停止处理并将指定的code码返回给客户端。 非标准code码 444 关闭连接而不发送响应报头。

从0.8.42版本开始， return 语句可以指定重定向 url (状态码可以为如下几种 301,302,303,307),
也可以为其他状态码指定响应的文本内容，并且重定向的url和响应的文本可以包含变量。

有一种特殊情况，就是重定向的url可以指定为此服务器本地的urI，
这样的话，nginx会依据请求的协议$scheme， server_name_in_redirect 
和 port_in_redirect自动生成完整的 url （此处要说明的是server_name_in_redirect 
和port_in_redirect 指令是表示是否将server块中的 
server_name 和 listen 的端口 作为redirect用 ）

```
# return code [text]; 返回 ok 给客户端
location = /ok {
    return 200 "ok";
}

# return code URL; 临时重定向到 百度
location = /redirect {
    return 302 http://www.baidu.com;
}

# return URL; 和上面一样 默认也是临时重定向
location = /redirect {
    return http://www.baidu.com;
}
```

```
Syntax:	rewrite regex replacement [flag];
Default:—
Context:server, location, if
```

rewrite 指令是使用指定的正则表达式regex来匹配请求的urI，
如果匹配成功，则使用replacement更改URI。
rewrite指令按照它们在配置文件中出现的顺序执行。
可以使用flag标志来终止指令的进一步处理。
如果替换字符串replacement以http：//，https：//或$ scheme开头，
则停止处理后续内容，并直接重定向返回给客户端。

```
location / {
    # 当匹配 正则表达式 /test1/(.*)时 请求将被临时重定向到 http://www.$1.com
    # 相当于 flag 写为 redirect
    rewrite /test1/(.*) http://www.$1.com;
    return 200 "ok";
}
# 在浏览器中输入 127.0.0.1:8080/test1/baidu 
# 则临时重定向到 www.baidu.com
# 后面的 return 指令将没有机会执行了
```

```
location / {
    rewrite /test1/(.*) www.$1.com;
    return 200 "ok";
}
# 发送请求如下
# curl 127.0.0.1:8080/test1/baidu
# ok

# 此处没有带http:// 所以只是简单的重写。请求的 uri 由 /test1/baidu 重写为 www.baidu.com
# 因为会顺序执行 rewrite 指令 所以 下一步执行 return 指令 响应了 ok 
```

1. last

停止处理当前的ngx_http_rewrite_module的指令集，并开始搜索与更改后的URI相匹配的location;

2. break

停止处理当前的ngx_http_rewrite_module指令集，就像上面说的break指令一样;

3. redirect

返回302临时重定向。

4. permanent

返回301永久重定向。

```
# 如果rewrite 后面没有任何 flag 时就顺序执行 
# 当 location 中没有 rewrite 模块指令可被执行时 就重写发起新一轮location匹配
location / {
    # 顺序执行如下两条rewrite指令 
    rewrite ^/test1 /test2;
    rewrite ^/test2 /test3;  # 此处发起新一轮location匹配 uri为/test3
}

location = /test2 {
    return 200 "/test2";
}  

location = /test3 {
    return 200 "/test3";
}
# 发送如下请求
# curl 127.0.0.1:8080/test1
# /test3
```

```
location / {
    rewrite ^/test1 /test2;
    # 此处 不会 发起新一轮location匹配；当是会终止执行后续rewrite模块指令 重写后的uri为 /more/index.html
    rewrite ^/test2 /more/index.html break;  
    rewrite /more/index\.html /test4; # 这条指令会被忽略

    # 因为 proxy_pass 不是rewrite模块的指令 所以它不会被 break终止
    proxy_pass https://www.baidu.com;
}
```
last 和 break一样 它们都会终止此 location 中其他它rewrite模块指令的执行，
但是 last 立即发起新一轮的 location 匹配 而 break 则不会

## rewrite后的请求参数

如果替换字符串replacement包含新的请求参数，则在它们之后附加先前的请求参数。如果你不想要之前的参数，
则在替换字符串 replacement 的末尾放置一个问号，避免附加它们。
如果正则表达式包含“ }”或“ ;”字符，则整个表达式应包含在单引号或双引号中。
```
# 由于最后加了个 ?，原来的请求参数将不会被追加到rewrite之后的url后面 
rewrite ^/users/(.*)$ /show?user=$1? last;
```

## rewrite_log

```
Syntax:	rewrite_log on | off;
Default: rewrite_log off;
Context: http, server, location, if
```
开启或者关闭 rewrite模块指令执行的日志，如果开启，则重写将记录下notice 等级的日志到nginx 的 error_log 中，默认为关闭 off

## set

```
Syntax:	set $variable value;
Default:	—
Context:	server, location, if
```
设置指定变量的值。变量的值可以包含文本，变量或者是它们的组合形式。
```
location / {
    set $var1 "host is ";
    set $var2 $host;
    set $var3 " uri is $request_uri";
    return 200 "response ok $var1$var2$var3";
}
# 发送如下请求
# curl 127.0.0.1:8080/test
# response ok host is 127.0.0.1 uri is /test
```

## uninitialized_variable_warn

Syntax:	uninitialized_variable_warn on | off;
Default:	
uninitialized_variable_warn on;
Context:	http, server, location, if