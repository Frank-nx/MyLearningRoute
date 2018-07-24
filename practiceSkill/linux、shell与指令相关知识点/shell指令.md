0. if语句

- if
```
if [ condition ]
then
    command
fi
```
- if-else
```
if [ condition ]
then
    command
else
    command
fi
```
- if-elif-else
```
if [ condition1 ]
then
    command1
elif [ condition2 ]
    command2
else
    commandN
fi
```
1. `if [ $# -lt 7]; `
```
$#:取得shell脚本参数个数

-lt：lower than，小于，与之相应的
-eq：equal 相等
-ne：not equal不等于
-le：lower or equal小于等于
-ge：greater or equal大于等于
-gt：greater than大于

$0: 取得脚本名称（包含路径）
$1: 表示第一个参数，$9 以后就需要大括号了,如 ${10}, ${11}, ${12}
```
2. `if ["x${net_dc}" == "x"]`
```
表示字符串"x${net_dc}" 和字符串"x"是否相等，{}用以区分字符串，
{}内部被当做一个整体处理，$是取内容运算符，表示其后所接变量的值，
这句语句时检查net_dc这个变量的引用是否为空，
加上x是为了，防止net_dc这个变量的引用为空时的语法错误。
```




