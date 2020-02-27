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

