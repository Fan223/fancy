package grey.fable.vocabulary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 词汇服务启动类.
 *
 * @author GreyFable
 * @since 2024/12/9 17:23
 */
@SpringBootApplication
@MapperScan("grey.fable.vocabulary.**.dao")
public class FancyVocabularyApplication {
    public static void main(String[] args) {
        SpringApplication.run(FancyVocabularyApplication.class, args);
    }
}
