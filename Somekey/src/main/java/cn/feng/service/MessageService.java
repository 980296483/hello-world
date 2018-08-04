package cn.feng.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.feng.bean.Message;
import cn.feng.bean.Page;
import cn.feng.mapper.MessageDAO;
@Service
public class MessageService implements IMessageService{
	@Resource
	private MessageDAO dao;
	@Override
	public List<Message> findAll() {
		List<Message> list=dao.findAll();
		return list;
	}
	@Override
	public Page<Message> findByPage(int currentPage) {
		 HashMap<String,Object> map = new HashMap<String,Object>();
	        Page<Message> pageBean = new Page<Message>();
	        //封装当前页数
	        pageBean.setCurrPage(currentPage);
	        //每页显示的数据
	        int pageSize=4;
	        pageBean.setPageSize(pageSize);
	        //封装总记录数
	        int totalCount = dao.selectCount();
	        pageBean.setTotalCount(totalCount);
	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue());
	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        //封装每页显示的数据
	        List<Message> lists = dao.findByPage(map);
	        pageBean.setLists(lists);
	        return pageBean;
	}
	@Override
	public List<Message> selectUserList() {
		// TODO Auto-generated method stub
		 return dao.selectUserList();
	}
	@Override
	public void add(Message message) {
		dao.addMessage(message);
	}
	@Override
	public void delete(String number) {
		dao.delete(number);
	}
	@Override
	public void update(Message message) {
		dao.update(message);
		
	}
	@Override
	public List<Message> findm(String name) {
		List<Message> list=dao.finm(name);
		return list;
	}
	@Override
	public Message findOne(String number) {	
		return dao.findOne(number);
	}

}
