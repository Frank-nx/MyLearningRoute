# 一、获取仓库相关的指令

* `$ git init`

初始化仓库，该命令将创建一个名为 .git 的子目录，
这个子目录含有你初始化的 Git 仓库中所有的必须文件，
这些文件是 Git 仓库的骨干。

* `$ git add readme.txt`

添加readme.txt到暂存区域，readme.txt可以为*，代表该目录下所有文件

* `$ git clone [url]`

克隆url对应的仓库

* `$ git clone [url] yourName`

 克隆url对应的仓库到本地，并将本地仓库名命名为yourName.

# 二、记录每次更新到仓库相关的指令

* `$ git status`

查看文件处于什么状态

* `$ git status -s` 或是 `$ git status --short`

状态格式输出更为紧凑

```
$ git status -s
 M README
MM Rakefile
A  lib/git.rb
M  lib/simplegit.rb
?? LICENSE.txt
```
新添加的未跟踪文件前面有 ?? 标记，
新添加到暂存区中的文件前面有 A 标记，
修改过的文件前面有 M 标记。 
你可能注意到了 M 有两个可以出现的位置，
出现在右边的 M 表示该文件被修改了但是还没放入暂存区，
出现在靠左边的 M 表示该文件被修改了并放入了暂存区。

* `$ git diff`

此命令比较的是工作目录中当前文件和暂存区域快照之间的差异,
也就是修改之后还没有暂存起来的变化内容。

* `$ git diff --cached` Git1.6.1及更高版本还允许使用
`git diff --staged`

查看已暂存的将要添加到下次提交里的内容

* `$ git commit` 

提交暂存区域的更新

* `$ git commit -a -m "提交信息"`

-m "提交信息"表示提交的信息，
-a表示Git 就会自动把所有已经跟踪过的文件暂存起来一并提交，
从而跳过 git add 步骤

* `$ git rm readme.txt`

从已跟踪文件清单中移除（确切地说，是从暂存区域移除），
并连带从工作目录中删除readme.txt，

* `$ git rm -f readme.txt`

 如果删除之前修改过并且已经放到暂存区域的话，
 则必须要用强制删除选项 -f（译注：即 force 的首字母）
 
* `$ git rm --cached readme.txt`

把文件从 Git 仓库中删除（亦即从暂存区域移除），
但仍然保留在当前工作目录中。 

* `$ git mv file_from file_to` 


重命名，将file_from用file_to代替,用重命名的方式实现移动，实际操作相当于：
```
$ mv file_from file_to
$ git rm file_from
$ git add file_to
```

# 三、查看提交历史

* `$ git log`

默认不用任何参数的话，`git log` 会按提交时间列出所有的更新，
最近的更新排在最上面

* `$ git log -p -2`

`-p`用来显示每次提交的内容差异。 `-2` 来仅显示最近两次提交

* `$ git log --stat`

每次提交的简略的统计信息

* `$ git log --pretty=oneline`

将每个提交放在一行显示，还可以等于short，full，fuller

* `$ git log --pretty=format:""`

可以定制要显示的记录格式。在“”中输入你要显示的格式

* `$ git log --pretty=oneline --graph`

 `--graph`这个选项添加了一些ASCII字符串来形象地展示你的分支、合并历史：

# 四、撤销操作

* `$ git commit -amend`

这个命令会将暂存区中的文件提交。 
如果自上次提交以来你还未做任何修改（例如，在上次提交后马上执行了此命令），
那么快照会保持不变，而你所修改的只是提交信息。
```
$ git commit -m 'initial commit'
$ git add forgotten_file
$ git commit --amend
```
最终你只会有一个提交 - 第二次提交将代替第一次提交的结果

* `$ git reset HEAD readme`

取消暂存的文件，将readme从暂存区移除，还是已跟踪状态

* `$ git checkout -- readme`

撤销之前你对readme文件的修改，恢复到上次你commit前的状态

* `$ git remote`

它会列出你指定的每一个远程服务器的简写

* $ git remote -v

会显示需要读写远程仓库使用的 Git 保存的简写与其对应的 URL





