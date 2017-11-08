# 选取redis-alpine镜像作为基础镜像，因为它非常小，只有9M。
# 修改时区和把一些配置拷贝进去后，变更下权限和用户组，因为基础镜像是redis用户组。
# ENTRYPOINT和CMD组合，默认以master方式启动
FROM redis:3-alpine
MAINTAINER voidman <voidman>

COPY Shanghai /etc/localtime
COPY redis.conf /etc/redis/redis.conf
COPY sentinel.conf /etc/redis/sentinel.conf
RUN chown redis:redis /etc/redis/*
ENV SENTINEL_QUORUM 2
ENV SENTINEL_DOWN_AFTER 30000
ENV SENTINEL_FAILOVER 180000
COPY start.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/start.sh
ENTRYPOINT ["start.sh"]
CMD["master"]