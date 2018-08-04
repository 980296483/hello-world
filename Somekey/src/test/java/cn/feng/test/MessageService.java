package cn.feng.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.feng.bean.Message;
import cn.feng.bean.Page;
import cn.feng.service.IMessageService;

public class MessageService {
	@Autowired
	private IMessageService service;
	@Test
	public void findAll() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		IMessageService service=ac.getBean("messageService",IMessageService.class);
		Page<Message> page=service.findByPage(2);
		System.out.println(page.getLists());
	}
}	
