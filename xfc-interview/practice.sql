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

