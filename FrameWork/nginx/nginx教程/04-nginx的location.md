## 一、location语法规则

* location是在server块中配置。

* 可以根据不同的URL使用不同的配置（location中配置），来处理不同请求。

* location是有顺序的。

|           语法         |                  解释                          |
| --------------------- | -------------------------------------------    |
| location = /uri       | =开头表示精确匹配，只有完全匹配上才能生效          |
|location ^~ /uri       | ^~ 开头对URL路径进行前缀匹配，并且在正则之前       |    
|location ~ 正则表达式   | ~开头表示区分大小写的正则匹配                     |
|location ~*正则表达式   | ~*开头表示不区分大小写的正则匹配                  |
|location !~ 正则表达式  | !~区分大小写不匹配的正则                         |
|location !~*正则表达式  | !~*不区分大小写不匹配的正则                      |
|location /uri          | 不带任何修饰符，也表示前缀匹配，但是在正则匹配之后  |
|location /             | 通用匹配，任何未匹配到其它location的请求都会匹配到，相当于switch中的default
|location @名称          | nginx内部跳转

### 2、location匹配顺序

`(location =) > (location ^~ 路径) > (location ~,~* 正则顺序) > (location 部分起始路径) > (/)`


1. =前缀的指令严格匹配这个查询。如果找到，停止搜索。
2. ^〜前缀的指令匹配这个查询，如果找到，搜索停止。
3. 匹配所有剩下的常规字符串，找出匹配到的最长前缀的url。
4. 正则表达式，在配置文件中定义的顺序，匹配到就停止搜索，如果正则表达式都没有匹配到，则使用步骤三中
找出的最长前缀的。
5. 上面4种都没匹配到，则匹配location /;

reference:

[location](http://nginx.org/en/docs/http/ngx_http_core_module.html#location)
