#!/bin/sh
cd /etc/redis
REDIS_ROLE=$1
echo $REDIS_ROLE
if [ $REDIS_ROLE = "master" ] ; then
    echo "master"
    sed -i "s/\$REDIS_PORT/$REDIS_PORT/g" redis.conf
    sed -i "s/\$MASTER_PORT/$MASTER_PORT/g" redis.conf
    redis-server /etc/redis/redis.conf
elif [ $REDIS_ROLE = "slave" ] ; then
    echo "slave"
    sed -i "s/\$REDIS_PORT/$REDIS_PORT/g" redis.conf
    sed -i "s/\$MASTER_PORT/$MASTER_PORT/g" redis.conf
    sed -i "s/#slaveof/slaveof/g" redis.conf
    redis-server /etc/redis/redis.conf
elif [ $REDIS_ROLE = "sentinel" ] ; then
    echo "sentinel"
    sed -i "s/\$SENTINEL_PORT/$SENTINEL_PORT/g" sentinel.conf
    sed -i "s/\$SENTINEL_QUORUM/$SENTINEL_QUORUM/g" sentinel.conf
    sed -i "s/\$SENTINEL_DOWN_AFTER/$SENTINEL_DOWN_AFTER/g" sentinel.conf
    sed -i "s/\$SENTINEL_FAILOVER/$SENTINEL_FAILOVER/g" sentinel.conf
    redis-sentinel /etc/redis/sentinel.conf
else
    echo "unknow role!"
fi