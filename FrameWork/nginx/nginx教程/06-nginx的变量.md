[在 Nginx 配置中，变量只能存放一种类型的值，因为也只存在一种类型的值，那就是字符串。](http://blog.sina.com.cn/s/blog_6d579ff40100wi7p.html)
所有的 Nginx 变量在 Nginx 配置文件中引用时都须带上 $ 前缀。

`set $a "hello world";`

Nginx 变量的创建和赋值操作发生在全然不同的时间阶段。Nginx 变量的创建只能发生在 Nginx 配置加载的时候，
或者说 Nginx 启动的时候；而赋值操作则只会发生在请求实际处理的时候。
这意味着不创建而直接使用变量会导致启动失败，
同时也意味着我们无法在请求处理时动态地创建新的 Nginx 变量。

###变量的范围

Nginx 变量一旦创建，其变量名的可见范围就是整个 Nginx 配置，
甚至可以跨越不同虚拟主机的 server 配置块。

```
server {
        listen 8080;
 
        location /foo {
            echo "foo = [$foo]";
        }
 
        location /bar {
            set $foo 32;
            echo "foo = [$foo]";
        }
}
```
这里我们在 location /bar 中用 set 指令创建了变量 $foo，
于是在整个配置文件中这个变量都是可见的，因此我们可以在 location /foo
中直接引用这个变量而不用担心 Nginx 会报错。

```
下面是在命令行上用 curl 工具访问这两个接口的结果：

    $ curl 'http://localhost:8080/foo'
    foo = []
 
    $ curl 'http://localhost:8080/bar'
    foo = [32]
 
    $ curl 'http://localhost:8080/foo'
    foo = []
```
Nginx 变量名的可见范围虽然是整个配置，
但每个请求都有所有变量的独立副本，
或者说都有各变量用来存放值的容器的独立副本，
彼此互不干扰。比如前面我们请求了 /bar 接口后，
$foo 变量被赋予了值 32，
但它丝毫不会影响后续对 /foo 接口的请求所对应的 $foo 值（它仍然是空的！），
因为各个请求都有自己独立的 $foo 变量的副本。

### 内部跳转

server {
        listen 8080;
 
        location /foo {
            set $a hello;
            echo_exec /bar;
        }
 
        location /bar {
            echo "a = [$a]";
        }
}

标准 ngx_rewrite 模块的 rewrite 配置指令其实也可以发起“内部跳转”，
例如上面那个例子用 rewrite 配置指令可以改写成下面这样的形式：
```
server {
        listen 8080;
 
        location /foo {
            set $a hello;
            rewrite ^ /bar;
        }
 
        location /bar {
            echo "a = [$a]";
        }
    }
```
所谓“内部跳转”，就是在处理请求的过程中，于服务器内部，
从一个 location 跳转到另一个 location 的过程。
这不同于利用 HTTP 状态码 301 和 302 所进行的“外部跳转”，
因为后者是由 HTTP 客户端配合进行跳转的，而且在客户端，
用户可以通过浏览器地址栏这样的界面，
看到请求的 URL 地址发生了变化。
内部跳转和 Bourne Shell（或 Bash）中的 exec 命令很像，
都是“有去无回”。另一个相近的例子是 C 语言中的 goto 语句。


既然是内部跳转，当前正在处理的请求就还是原来那个，
只是当前的 location 发生了变化，
所以还是原来的那一套 Nginx 变量的容器副本。
对应到上例，如果我们请求的是 /foo 这个接口，
那么整个工作流程是这样的：
先在 location /foo 中通过 set 指令将 $a 变量的值赋为字符串 hello，
然后通过 echo_exec 指令发起内部跳转，
又进入到 location /bar 中，再输出 $a 变量的值。
因为 $a 还是原来的 $a，
所以我们可以期望得到 hello 这行输出。测试证实了这一点：
```
$ curl localhost:8080/foo
a = [hello]
```

Nginx 变量值容器的生命期是与当前正在处理的请求绑定的，而与 location 无关。

### 自定义变量与内建变量

由set指令隐式创建的Nginx变量，一般称为用户自定义变量，
还有由 Nginx 核心和各个Nginx模块提供的“预定义变量”，
或者说“内建变量”（builtin variables）。

$uri

$request_uri

```
location /test {
        echo "uri = $uri";
        echo "request_uri = $request_uri";
    }
    
$ curl 'http://localhost:8080/test/hello%20world?a=3&b=4'
uri = /test/hello world
request_uri = /test/hello%20world?a=3&b=4
```
$arg_XXX

$cookie_XXX

$http_XXX 取请求头

$sent_http_XXX 取响应头

### 内建变量的读和写

许多内建变量都是只读的，比如我们刚才介绍的 $uri 和 $request_uri.
 对只读变量进行赋值是应当绝对避免的，如果你尝试改写另外一些只读的内建变量，
 比如 $arg_XXX 变量，在某些 Nginx 的版本中甚至可能导致进程崩溃。
 
 当然还有一些内建变量是支持改写的，
 其中一个例子是 $args. 
 这个变量在读取时返回当前请求的 URL 参数串
 （即请求 URL 中问号后面的部分，如果有的话 ），
 而在赋值时可以直接修改参数串。
 
 这里的 $args 变量和 $arg_XXX 一样，
 也不再使用属于自己的存放值的容器。
 当我们读取 $args 时，Nginx 会执行一小段代码，
 从 Nginx 核心中专门存放当前 URL 参数串的位置去读取数据；
 而当我们改写 $args 时，Nginx 会执行另一小段代码，对相同位置进行改写。
 Nginx 的其他部分在需要当前 URL 参数串的时候，都会从那个位置去读数据，
 所以我们对 $args 的修改会影响到所有使用这部分的功能。
 ```
 location /test {
         set $orig_a $arg_a;
         set $args "a=5";
         echo "original a: $orig_a";
         echo "a: $arg_a";
     }
 ```
 ```
 $ curl 'http://localhost:8080/test?a=3'
     original a: 3
     a: 5
 ```
 ```
 我们再来看一个通过修改 $args 变量影响标准的 HTTP 代理模块 ngx_proxy 的例子：
 
     server {
         listen 8080;
  
         location /test {
             set $args "foo=1&bar=2";
             proxy_pass http://127.0.0.1:8081/args;
         }
     }
  
     server {
         listen 8081;
  
         location /args {
             echo "args: $args";
         }
     }
 ```
 这里我们在 http 配置块中定义了两个虚拟主机。第一个虚拟主机监听 8080 端口，其 /test 接口自己通过改写 $args 变量，将当前请求的 URL 参数串无条件地修改为 foo=1&bar=2. 然后 /test 接口再通过 ngx_proxy 模块的 proxy_pass 指令配置了一个反向代理，指向本机的 8081 端口上的 HTTP 服务 /args. 默认情况下，ngx_proxy 模块在转发 HTTP 请求到远方 HTTP 服务的时候，会自动把当前请求的 URL 参数串也转发到远方。
 
 
而本机的 8081 端口上的 HTTP 服务正是由我们定义的第二个虚拟主机来提供的。我们在第二个虚拟主机的 location /args 中利用 echo 指令输出当前请求的 URL 参数串，以检查 /test 接口通过 ngx_proxy 模块实际转发过来的 URL 请求参数串。
 
 
我们来实际访问一下第一个虚拟主机的 /test 接口：
 ```
 $ curl 'http://localhost:8080/test?blah=7'
 args: foo=1&bar=2
 ```
 
 reference：
 
 [agentzh的博客-变量漫谈](http://blog.sina.com.cn/s/articlelist_1834459124_0_1.html)
     