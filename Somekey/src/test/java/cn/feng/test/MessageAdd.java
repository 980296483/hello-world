package cn.feng.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.feng.bean.Message;
import cn.feng.mapper.MessageDAO;

public class MessageAdd {
	@Test
	public void add() throws ParseException {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		//SqlSessionFactory a=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		//System.out.println(a);
		MessageDAO dao= ac.getBean("messageDAO",MessageDAO.class);
		System.out.println(dao);
		Message mess=new Message();
		mess.setNumber("21");
		String data="2005-04-22";
	
		mess.setDate(data);
		mess.setId("51032219964");
		mess.setSex("张三");
		mess.setName("男");
		dao.addMessage(mess);
		
	}
	@Test
	public void findAll() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
		MessageDAO dao=ac.getBean("messageDAO",MessageDAO.class);
		System.out.println(dao);
		List<Message> list=dao.findAll();
		System.out.println(list);
	}
}
