package mod1;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("mod1")
@PropertySource("classpath:myApp.properties")

public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean() {
//        System.out.println("!!!");
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }
}
