## 1、服务器名称匹配顺序

服务器名称使用server_name 指令定义，
并确定用于给定请求的服务器块。可以使用确切名称，
通配符名称或正则表达式来定义它们：

```
server {
    listen       80;
    server_name  example.org  www.example.org;
    ...
}

server {
    listen       80;
    server_name  *.example.org;
    ...
}

server {
    listen       80;
    server_name  mail.*;
    ...
}

server {
    listen       80;
    server_name  ~^(?<user>.+)\.example\.net$;
    ...
}
```

按名称搜索虚拟服务器时，
如果name匹配多个指定的变体，
例如通配符名称和正则表达式匹配，
则将按以下优先顺序选择第一个匹配的变体：

1. 确切的名字
2. 以星号开头的最长的通配符名称，例如“ *.example.org”
3. 以星号结尾的最长的通配符名称，例如“ mail.*”
4. 第一个匹配正则表达式（按配置文件中的出现顺序）

## 二、通配符名称

通配符名称仅仅只能在名称的开头或结尾包含`*`，并且仅在`.`边上包含星号，
即以`*.`开头或是以`.*`结尾。名称“ www.*.example.org”和“ w*.example.org”无效。
可以使用正则表达式指定这些名称，例如“ ~^www\..+\.example\.org$”和“ ~^w.*\.example\.org$”。
`*`可以匹配多个名称部分。名称`*.example.org`不仅可以匹配`www.example.org`，
而且也可以匹配`www.sub.example.org`。

`.example.org`这种形式是一种特殊的通配符名称，
可用于匹配确切名称`example.org`和通配符名称`*.example.org`。

## 三、正则表达式名称

`nginx`使用的正则表达式与`Perl`编程语言（PCRE）使用的正则表达式兼容。
要使用正则表达式，服务器名称必须以波浪号`~`开头：

`server_name  ~^www\d+\.example\.net$;`

否则它将被视为一个确切的名称，
或者如果表达式包含星号`*`，
则作为通配符名称（并且很可能是无效的名称）。
别忘了设置`^`和`$`锚点。它们在语法上不是必需的，
但在逻辑上是必需的。另请注意，域名点`.`应使用反斜杠`\`进行转义。正则表达式中包含多个字符时，使用`{``}`

server_name  "~^(?<name>\w\d{1,3}+)\.example\.net$";

否则`nginx`将无法启动并显示错误消息：

`directive "server_name" is not terminated by ";" in ...`

命名的正则表达式捕获稍后可以用作变量：

```
server {
    server_name   ~^(www\.)?(?<domain>.+)$;

    location / {
        root   /sites/$domain;
    }
}
```

PCRE库使用以下语法支持命名捕获：

```
?<name>	    自PCRE-7.0以来支持Perl 5.10兼容语法
?'name'	    自PCRE-7.0以来支持Perl 5.10兼容语法
?P<name>	自PCRE-4.0以来支持Python兼容语法
```

如果nginx无法启动并显示下面的错误消息： 

`pcre_compile() failed: unrecognized character after (?< in ...`

这意味着PCRE库已经过时了，应该尝试使用语法`?P<name>`。捕获也可以以数字形式使用：

```
server {
    server_name   ~^(www\.)?(.+)$;

    location / {
        root   /sites/$2;
    }
}
```
但是，这种用法应限于简单的情况（如上所述），因为数字参考可以很容易地被覆盖。


reference：

[Server names](http://nginx.org/en/docs/http/server_names.html)

