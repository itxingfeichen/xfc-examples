use practice;
# 1.查询课程编号为“01”的课程比“02”的课程成绩高的所有学生的学号（重点）
select a.s_id, s.s_name, a.s_score '01', b.s_score '02'
from (select * from Score where c_id = '01') as a
         inner join
         (select * from Score where c_id = '02') as b on a.s_id = b.s_id
         inner join Student s on a.s_id = s.s_id
where a.s_score > b.s_score;

# 2、查询平均成绩大于60分的学生的学号和平均成绩（简单，第二道重点）
select s_id, avg(s_score) 'core'
from Score
group by s_id
having core > 60;

# 3、查询所有学生的学号、姓名、选课数、总成绩（不重要）
select stu.s_id                                                              's_id',
       stu.s_name                                                            's_name',
       count(score.c_id)                                                     'course_count',
       sum(case when score.s_score is null then 0 else score.s_score end) as 'total_score'
from Student stu
         left join Score score on stu.s_id = score.s_id
group by stu.s_id, stu.s_name;

# 4、查询姓“猴”的老师的个数（不重要）
select count(t.t_id) count from Teacher t  where t_name like '张%';
# 查询同姓"张"老师的个数
select count(distinct t.t_name) count from Teacher t  where t_name like '张%';
# 4、查询没学过“张三”老师课的学生的学号、姓名（重点）
# 思路：找到学过张三老师课的同学，然后not in
# 方法一：子查询
select s_id,s_name from Student where s_id not  in(
# 根据张三老师讲的课程管理成绩表，找到学过张三老师课的学生
select s_id from Score where c_id = (
# 找到张三老师讲的课程
select c_id from Course where t_id = (
# 找到姓名为张三的老师
select t_id from Teacher where t_name = '张三')));

# 方法二 join
select stu.s_id, stu.s_name
from Student stu
where s_id not in (
    select s.s_id
    from Score s
             join Course c on s.c_id = c.c_id
             join Teacher t on c.t_id = t.t_id
    where t.t_name = '张三');

# 6、查询学过“张三”老师所教的所有课的同学的学号、姓名（重点）
explain select stu.s_id, stu.s_name
from Student stu
         inner join Score s on stu.s_id = s.s_id
         inner join Course c on s.c_id = c.c_id
         inner join Teacher t on c.t_id = t.t_id
where t.t_name = '张三';

# 7、查询学过编号为“01”的课程并且也学过编号为“02”的课程的学生的学号、姓名（重点）
select s.s_id, s.s_name
from Student s
where s.s_id in (
    select a.s_id
    from ((select s_id from Score where c_id = '01') a
             inner join (select s_id from Score where c_id = '02') as b on a.s_id = b.s_id)
);

# 8、查询课程编号为“02”的总成绩（不重点）
select sum(s_score) from Score where c_id='02';
# 扩展
select sum(s_score) from Score group by c_id;
# 扩展
select sum(s_score) from Score group by c_id having c_id=2;

# 10.查询所有学全所有课程成绩小于60分的学生的学号、姓名(重点)
# 思路：1->根据学生id查询出成绩小于60分的的数量 2->根据学生id查询出当前学生所选课程的数量
select a.s_id, stu.s_name
from (
      (select s.s_id, count(s.c_id) count from Score s where s.s_score < 60 group by s.s_id) as a
         inner join
     (select s1.s_id, count(s1.c_id) count from Score s1 group by s1.s_id) as b on a.s_id = b.s_id
         inner join Student stu on a.s_id = stu.s_id
    )
where a.count = b.count;

# 10.查询没有学全所有课的学生的学号、姓名(重点)
select s.s_id,stu.s_name from Student stu left join Score s on stu.s_id=s.s_id group by s.s_id,stu.s_name
having count(distinct s.c_id) < (select count(distinct Course.c_id) from Course);

# 11、查询至少有一门课与学号为“01”的学生所学课程相同的学生的学号和姓名（重点）
# 方法一
select stu.s_id,stu.s_name from Student stu where s_id in(
    select Score.s_id from Score where c_id in(
# 查询01号同学学过的课程
        select c_id from Score where s_id='01') and s_id !='01');
# 方法二
select stu.s_id,stu.s_name from Student stu inner join (
    select distinct Score.s_id from Score where c_id in(
# 查询01号同学学过的课程
        select c_id from Score where s_id='01') and s_id !='01') as b on stu.s_id  = b.s_id;

# 12.查询和“01”号同学所学课程完全相同的其他同学的学号(重点)
# 查询01号同学学过的课程
select s_id from Score where s_id in(
    select s.s_id from Score s where s.c_id in(
        select distinct c_id from Score where s_id='01') and s.s_id !='01'
    group by s.s_id having count(s.c_id) = (select count(distinct c_id) from Score where s_id='01')) group by s_id
having count(c_id) = (select count(distinct c_id) from Score where s_id='01'); # 这个sql逻辑有问题，使用in筛选数据时是或的关系，并使并列的关系

# 思路：首先筛选出一定有跟'01'同学不一样的课程的同学，然后找出选课数量跟'01'同学一致的同学，在判断最终的id不在选出一定有跟'01'同学不一样的课程的同学id集合
select s_id,s_name from Student where s_id in (
# 选出选课数量跟1号相同的同学
    select s_id from Score s where c_id in(select c_id from Score where s_id='01') and s.s_id!='01'
    group by s.s_id having count(s.c_id)=(select count(c_id) from Score where s_id='01')) and s_id not in
# 选出一定有跟'01'同学不一样的课程的同学
                                                                                              (select s_id from Score where c_id not in(select c_id from Score where s_id='01'));
# 15、查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩（重点）
# 思路：先查询两门以上成绩不及格的同学
select stu.s_id,stu.s_name,avg(s.s_score) from Student stu inner join Score s on stu.s_id = s.s_id where s.s_id in(
    select s_id from Score where s_score < 60 group by s_id having count(c_id)>=2) group by stu.s_id,stu.s_name;
# 16、检索"01"课程分数小于60，按分数降序排列的学生信息（和34题重复，不重点）
select * from Student where s_id in(
    select s.s_id from Score s where s.c_id='01' and s.s_score<60 order by s.s_score asc ) # 不严谨写法，排序有问题
# 严谨写法，使用join
select stu.*,s.s_score from Student stu,Score s where stu.s_id = s.s_id and s.s_score<60 and s.c_id='01' order by s.s_score desc;
# 17、按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩(重重点与35一样)
select s.s_id,a.ave_s,s.s_score from Score s inner join
                                     (select s_id,avg(s_score) ave_s from Score group by s_id) a on
                                             s.s_id = a.s_id group by s.s_id,s.s_score order by a.ave_s desc;
# 非常重要
select s_id,
       MAX(case when c_id = '01' then s_score else null end) 'chinese',
       MAX(case when c_id = '02' then s_score else null end) 'math',
       MAX(case when c_id = '03' then s_score else null end) 'english',
       avg(s_score)                                          avgd
from Score
group by s_id
order by avgd desc
#     18.查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率
#     --及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90 (超级重点)
select
       s.c_id,
       c.c_name,
       MAX(s.s_score),
       min(s.s_score),
       avg(s.s_score),
       sum(case when s.s_score>=60 then 1 else 0 end )/count(s.s_id) '及格率',
       sum(case when s.s_score>=70 and s.s_score<=80 then 1 else 0 end )/count(s.s_id) '中等率',
       sum(case when s.s_score>=80 and s.s_score<=90 then 1 else 0 end )/count(s.s_id) '优良率',
       sum(case when s.s_score>=90 then 1 else 0 end )/count(s.s_id) '优秀率'
from Score s inner join Course c on s.c_id = c.c_id group by c.c_id;
# 19、按各科成绩进行排序，并显示排名(重点row_number（顺序排1,2,3），rank（跳跃排1,1,3），dense_rank（连续排1,1,2）)
# select * from Score s inner join Student stu on s.s_id=stu.s_id
select s_id,c_id,s_score,row_number() over (order by s_score desc) from Score;
# 20、查询学生的总成绩并进行排名（不重点）
select s_id,sum(s_score) total from Score group by s_id  order by total desc;
# 21 、查询不同老师所教不同课程平均分从高到低显示(不重点)
# 方法一：以课程为维度
select t.t_name,c.c_name,avg(sc.s_score) score from Score sc inner join Course c on sc.c_id = c.c_id
inner  join Teacher t on t.t_id = c.t_id
group by c.c_id order by score desc;
# 方法二：以老师为维度
select t.t_id,t_name,avg(sc.s_score) score from Score sc inner join Course c on sc.c_id = c.c_id
inner join Teacher t on c.t_id = t.t_id group by t.t_id,t.t_name order by score desc;
# 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩（重要 25类似）
select *
from (
         select sc.s_id, sc.s_score, stu.s_name, row_number() over(order by sc.s_score desc) m
         from Score sc
                  inner join Student stu on sc.s_id = stu.s_id
     ) as a
where m in (2, 3);

# 23、使用分段[100-85],[85-70],[70-60],[<60]来统计各科成绩，分别统计各分数段人数：课程ID和课程名称(重点和18题类似)
select c.c_id,
       c.c_name,
       sum(case when sc.s_score <= 100 and sc.s_score > 85 then 1 else 0 end)     '(85,100]',
       # 这里也可以使用count，但是count的话跟sum不同，因为结果是0也会统计，为null则不统计
       count(case when sc.s_score <= 85 and sc.s_score > 70 then 1 else null end) '(70,85]',
       sum(case when sc.s_score <= 70 and sc.s_score >= 60 then 1 else 0 end)     '[60,70]',
       sum(case when sc.s_score < 60 then 1 else 0 end)                           '<60'
from Score sc
         inner join Course c on sc.c_id = c.c_id
group by c.c_id, c.c_name;
#24、 查询学生平均成绩及其名次（同19题，重点）
select s_id,avg(s_score) ave,row_number() over (order by avg(s_score) desc ) from Score group by s_id order by ave desc;
# 25、查询各科成绩前三名的记录（不考虑成绩并列情况）（重点 与22题类似）

# 26、查询每门课程被选修的学生数(不重点)
# 写复杂了版本
select
       c.c_id,c.c_name,
    sum(case when c.c_id='01' then 1 else 0 end ) '语文',
    sum(case when c.c_id='02' then 1 else 0 end ) '数学',
    sum(case when c.c_id='03' then 1 else 0 end ) '英语'
 from Score sc inner join Course c on sc.c_id=c.c_id group by c.c_id;
# 简单点的版本
select c.c_id,c.c_name, count(sc.s_id) from Score sc inner join Course c on sc.c_id=c.c_id group by c.c_id,c.c_name;

# 27、 查询出只有两门课程的全部学生的学号和姓名(不重点)
# 连接版本
select s.s_id,stu.s_name from Score s inner join Student stu on s.s_id = stu.s_id group by s.s_id having count(c_id) = 2;
# 子查询
select s_id,s_name from Student where s_id in (select s_id from Score group by s_id having count(c_id)=2);

# 28、查询男生、女生人数(不重点)
# 分组版本
select s_sex,count(s_sex) from Student group by s_sex;
# sum版本
select
    sum(case when s_sex='男' then 1 else 0 end) '男',
    count(case when s_sex='男' then 1 else null end) '女'
 from Student;

# 29 查询名字中含有"风"字的学生信息（不重点）
select * from Student where s_name like  '%风%';
select * from Student where s_name like  '孙%';
select * from Student where s_name like  '孙%风%';

# 31、查询1990年出生的学生名单（重点year）
select * from Student where year(s_birth) = '1990';
select * from Student where month(s_birth) = '5';
select * from Student where day(s_birth) = '20';

# 32、查询平均成绩大于等于85的所有学生的学号、姓名和平均成绩（不重要）
select sc.s_id,stu.s_name,avg(sc.s_score) as ave from Score sc inner join Student stu on sc.s_id = stu.s_id
group by sc.s_id having ave>=85;

# 33、查询每门课程的平均成绩，结果按平均成绩升序排序，平均成绩相同时，按课程号降序排列（不重要）
select c_id,avg(s_score) ave from Score group by c_id order by ave,c_id desc;
# 扩展
select sc.c_id,c.c_name,avg(sc.s_score) ave from Score sc inner join Course c on sc.c_id= c.c_id group by sc.c_id order by ave,sc.c_id desc;
# 34、查询课程名称为"数学"，且分数低于60的学生姓名和分数（不重点）
select stu.s_name,c.c_name,sc.s_score from Score sc inner join Course c on sc.c_id=c.c_id inner join Student stu on sc.s_id=stu.s_id where c.c_name='数学' and sc.s_score<60
#35、查询所有学生的课程及分数情况（重点）
# 1.因为要选出需要的字段 用case when 当co.c_name='数学' then 可以得到对应的 sc.s_core
# 2.因为GROUP UP 要与select 列一致，所以case when 加修饰max
# 3.因为最后要展现出每个同学的各科成绩为一行，所以用到case
select
       stu.s_id,stu.s_name,
      # 这里用max的原因是因为分组以后的数据同一时刻，如c_id等于01的时候其他的两列一定是空
      # 这里也可以使用 min,sum等函数
       min(case when sc.c_id='01' then sc.s_score else null end) '语文',
       min(case when sc.c_id='02' then sc.s_score else null end) '数学',
       min(case when sc.c_id='03' then sc.s_score else null end) '英文'
from Score sc inner join Student stu on sc.s_id = stu.s_id
group by sc.s_id;
# 36、查询任何一门课程成绩在70分以上的姓名、课程名称和分数（重点）
select s.s_name,c.c_name,s_score from Score sc inner join Course c on sc.c_id=c.c_id inner join Student s on sc.s_id=s.s_id
where sc.s_score>70;
# 扩展，查询所有课程都在70分以上的学生
select s.s_name,c.c_name,s_score from Score sc inner join Course c on sc.c_id=c.c_id inner join Student s on sc.s_id=s.s_id
where sc.s_id not in( select s_id from Score where s_score<70);
# 37、查询不及格的课程并按课程号从大到小排列(不重点)
select * from Score where s_score<60 order by c_id desc;
# 扩展：显示学生姓名等信息
select s.s_name,c.c_name,sc.c_id,s_score from Score sc inner join Course c on sc.c_id=c.c_id inner join Student s on sc.s_id=s.s_id
where sc.s_score<60 order by sc.c_id desc;
# 38、查询课程编号为03且课程成绩在80分以上的学生的学号和姓名（不重要）
select s.s_name,c.c_name,sc.c_id,s_score from Score sc inner join Course c on sc.c_id=c.c_id inner join Student s on sc.s_id=s.s_id
where sc.c_id='03' and sc.s_score>80;
# 39、求每门课程的学生人数（不重要）
select  c.c_name,count(sc.s_id) from Score sc inner join Course c on sc.c_id=c.c_id group by sc.c_id;
# 40、查询选修“张三”老师所授课程的学生中成绩最高的学生姓名及其成绩（重要top）
select t.t_name,s.s_id,sc.s_score,s.s_name,c.c_name from Score sc inner join Student s on sc.s_id=s.s_id inner join Course c on sc.c_id=c.c_id
inner join Teacher t on c.t_id=t.t_id
where t.t_name='张三' order by sc.s_score desc limit 1 ;
# 扩展：查询选修“张三”老师所授课程的学生中成绩最低的学生姓名及其成绩
select t.t_name,s.s_id,sc.s_score,s.s_name,c.c_name from Score sc inner join Student s on sc.s_id=s.s_id inner join Course c on sc.c_id=c.c_id
inner join Teacher t on c.t_id=t.t_id
where t.t_name='张三' order by sc.s_score limit 1 ;
# 41.查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩 （重点）
select s1.s_id from Score s1 inner join (
select s.s_id,s.s_score from Score s inner join (
select s_id from Score group by s_id having count(s_id) > 1) a on s.s_id=a.s_id
group by s.s_id,s.s_score) b on s1.s_id = b.s_id group by s1.s_id having count(s1.s_id)>1;

# 42、查询每门功成绩最好的前两名（同22和25题）
#   todo
# 43、统计每门课程的学生选修人数（超过5人的课程才统计）。
    # 要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列（不重要）
select c_id,count(s_id) cnt from Score group by c_id having cnt>5 order by cnt desc,c_id asc;
# 44、检索至少选修两门课程的学生学号（不重要）
select s_id,count(c_id) from Score group by s_id having count(c_id)>=2;
# 45、 查询选修了全部课程的学生信息（重点划红线地方）
select s.* from Score sc inner join Student s on sc.s_id=s.s_id group by sc.s_id having count(sc.c_id)=(select count(c_id) from Course);
#、查询各学生的年龄
# 由于数据库中没有学生的年龄，因此要使用函数进行计算
select s_id,s_name,s_sex,datediff(now(),s_birth)/365 birth from Student;
# select datediff(now(),'20120512')
# 47、查询没学过“张三”老师讲授的任一门课程的学生姓名（还可以，自己写的，答案中没有）
select * from Student where s_id not in(
select s.s_id  from Score sc inner join Student s on sc.s_id=s.s_id inner join Course c on sc.c_id=c.c_id
inner join Teacher t on c.t_id=t.t_id where t.t_name='张三');
# 48、查询两门以上不及格课程的同学的学号及其平均成绩（还可以，自己写的，答案中没有） 15题重复
# 49、查询本月过生日的学生（无法使用week、date(now()）
select s_id,s_name,s_sex,s_birth from Student where month(s_birth) = month(curdate());
# 查询本周过生日的同学
select s_id,s_name,s_sex,s_birth from Student where week(s_birth) = week(curdate());
# 查询下周过生日的同学
select s_id,s_name,s_sex,s_birth from Student where week(s_birth) = week(curdate())+1;
# 查询下月过生日的同学
select s_id,s_name,s_sex,s_birth from Student where month(s_birth) = month(curdate())+1;

