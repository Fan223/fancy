package grey.fable.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 博客系统启动类.
 *
 * @author GreyFable
 * @since 2024/11/25 4:14
 */
@SpringBootApplication
@ComponentScan("grey.fable")
@MapperScan("grey.fable.blog.**.dao")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
