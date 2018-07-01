# MyLearningRoute

git提交步骤：

① git init

② git add README.md 将README用*代替表示添加全部

③ git commit -m "first commit"

④ git remote add origin yourURL

⑤ git push -u origin master

当git项目中有本地没有的文件时，第五步会出错，此时执行完下面的两个步骤，在执行上面的5个步骤就可以了

git pull origin master

git pull origin master --allow-unrelated-histories
