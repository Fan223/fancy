package grey.fable.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 博客启动类.
 *
 * @author GreyFable
 * @since 2025/3/6 8:48
 */
@SpringBootApplication
@MapperScan("grey.fable.blog.dao")
@EnableScheduling
public class FancyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(FancyBlogApplication.class, args);
    }
}
