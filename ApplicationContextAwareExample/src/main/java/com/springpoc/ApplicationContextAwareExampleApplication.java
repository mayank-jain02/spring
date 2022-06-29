package com.springpoc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationContextAwareExampleApplication {

	@Bean
	@Scope("prototype")
	public MyPrototypeBean prototypeBean() {
		return new MyPrototypeBean();
	}

	@Bean
	public MySingletonBean singletonBean() {
		return new MySingletonBean();
	}

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextAwareExampleApplication.class);
		MySingletonBean bean = context.getBean(MySingletonBean.class);
		bean.showMessage();
		Thread.sleep(1000);
		
		bean = context.getBean(MySingletonBean.class);
		bean.showMessage();
		context.close();
	}

}
