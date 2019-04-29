#  分布式基础
##  什么是分布式
##  分布式和集群的关系
### 分布式
*   指一个业务拆分成多个子系统，部署在不同的服务器
### 集群
*   指同一个业务部署在多个服务器上，保证服务高可用

### Session共享问题解决方案
*   session stricky(保证同一个请求地址请求到同一台服务器)
*   session replication
*   session集中存储（db，redis）
*   cookie（userId+token+timestamp）