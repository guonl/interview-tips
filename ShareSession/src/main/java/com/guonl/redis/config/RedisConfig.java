package com.guonl.redis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by guonl
 * Date 2018/4/11 下午2:07
 * Description: 还可以通过这样的配置
 *
 * 通过EnableRedisHttpSession注解进行自动配置，
 * 需要早springboot上面添加：@EnableAutoConfiguration
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)//session 1分钟后过期
public class RedisConfig {

}
