package grey.fable.common.redis;

import grey.fable.base.text.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 自动配置类.
 *
 * @author GreyFable
 * @since 2025/3/6 15:04
 */
public class RedisAutoConfiguration {

    /**
     * 注入 {@link RedissonClient}.
     *
     * @param properties {@link RedisProperties}
     * @return {@link RedissonClient}
     * @author GreyFable
     * @since 2025/3/7 11:21
     */
    @Bean
    public RedissonClient redissonClient(RedisProperties properties) {
        Config config = new Config();
        config.setCodec(new JsonJacksonCodec());

        String address = StringUtils.concat("redis://", properties.getHost(), ":" + properties.getPort());
        config.useSingleServer()
                .setAddress(address)
                .setPassword(properties.getPassword())
                .setDatabase(properties.getDatabase());
        return Redisson.create(config);
    }

    /**
     * 注入 {@link RedisTemplate}.
     *
     * @param redisConnectionFactory {@link RedisConnectionFactory}
     * @return {@link RedisTemplate}
     * @author GreyFable
     * @since 2025/3/7 11:21
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 字符串序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // JSON 序列化
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        // 默认 Key-Value 序列化类型
        redisTemplate.setDefaultSerializer(genericJackson2JsonRedisSerializer);
        // 重设 Key 的序列化类型
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        return redisTemplate;
    }
}
