package com.jason.rat.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jason.rat.*"})
public class RatPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatPortalApplication.class, args);
    }

    /**
     * 打印springboot启动时装在了哪些bean
     * @param ctx
     * @return
     */
/*	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}*/
}
