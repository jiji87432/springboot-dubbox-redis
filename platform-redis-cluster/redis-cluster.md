http://s4.51cto.com/wyfs02/M00/7F/97/wKiom1cjPE-jZb1QAADi_DezMAw835.png

1.sentinel 说明
- (1)监控（Monitoring）： Sentinel 会不断地检查你的主服务器和从服务器是否运作正常。
- (2)提醒（Notification）： 当被监控的某个 Redis 服务器出现问题时， Sentinel 可以通过 API 向管理员或者其他应用程序发送通知。
- (3)自动故障迁移（Automatic failover）： 当一个主服务器不能正常工作时， Sentinel 会开始一次自动故障迁移操作， 它会将失效主服务器的其中一个从服务器升级为新的主服务器， 并让失效主服务器的其他从服务器改为复制新的主服务器； 当客户端试图连接失效的主服务器时， 集群也会向客户端返回新主服务器的地址， 使得集群可以使用新主服务器代替失效服务器。

Redis Sentinel 是一个分布式系统， 你可以在一个架构中运行多个 Sentinel 进程（progress）， 这些进程使用流言协议（gossip protocols)来接收关于主服务器是否下线的信息， 并使用投票协议（agreement protocols）来决定是否执行自动故障迁移， 以及选择哪个从服务器作为新的主服务器。

2.redis 主从同步原理
- (1)Slave服务器连接到master服务器.
- (2)Slave服务器发送SYCN命令.
- (3)Master服务器备份数据库到.rdb文件.
- (4)Master服务器把.rdb文件传输给Slave服务器.
- (5)Slave服务器把.rdb文件数据导入到数据库中.

3.架构规划
- master:10.1.1.8:6379
- salve1:10.1.1.11:6379
- salve2:10.1.1.12:6379
- salve3:10.1.1.13:6379

- sentinel:10.1.1.11:26379
- sentinel:10.1.1.12:26379
- sentinel:10.1.1.13:26379
