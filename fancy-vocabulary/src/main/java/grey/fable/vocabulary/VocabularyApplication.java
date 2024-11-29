package grey.fable.vocabulary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 词汇系统启动类.
 *
 * @author GreyFable
 * @since 2024/11/25 4:15
 */
@SpringBootApplication
@ComponentScan("grey.fable")
@MapperScan("grey.fable.vocabulary.**.dao")
public class VocabularyApplication {
    public static void main(String[] args) {
        SpringApplication.run(VocabularyApplication.class, args);
    }
}
