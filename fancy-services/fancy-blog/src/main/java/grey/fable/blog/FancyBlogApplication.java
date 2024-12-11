package grey.fable.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 博客服务启动类.
 *
 * @author GreyFable
 * @since 2024/12/9 17:22
 */
@SpringBootApplication
@MapperScan("grey.fable.blog.**.dao")
public class FancyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(FancyBlogApplication.class, args);
    }
}
