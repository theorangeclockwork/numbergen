package inovus.task.numbergen;

import inovus.task.numbergen.service.NumberPresenter;
import inovus.task.numbergen.service.impl.NumberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NumbergenApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumbergenApplication.class, args);
    }

    @Bean
    public NumberServiceImpl numberService(NumberPresenter presenter) {
        return new NumberServiceImpl(presenter, 1728000);
    }
}
