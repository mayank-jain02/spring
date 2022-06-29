package com.springpoc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MySingletonBean implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	
	/* @Autowired
	 * private ApplicationContext applicationContext;
	 */
	
	public void showMessage() {
		MyPrototypeBean bean = applicationContext.getBean(MyPrototypeBean.class);
		System.out.println("Hi, the time is " + bean.getDateTime());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}

}
