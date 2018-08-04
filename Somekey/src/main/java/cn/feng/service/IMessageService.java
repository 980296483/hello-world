package cn.feng.service;

import java.util.HashMap;
import java.util.List;

import cn.feng.bean.Message;
import cn.feng.bean.Page;

public interface IMessageService {
	/**
	 * 查询全部
	 * @return
	 */
	public List<Message> findAll();
	/**
	 * 分页方法
	 * @param currentPage
	 * @return
	 */
	Page<Message> findByPage(int currentPage);
	/**
	 * 类表集合
	 * @return
	 */
	List<Message> selectUserList();
	/**
	 * 添加
	 * @param message
	 */
	void add(Message message);
	/**
	 * 删除
	 * @param number
	 */
	void delete(String number);
	/**
	 * 更新
	 * @param message
	 */
	void update(Message message);
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	List<Message> findm(String name);
	/**
	 * 查询一条信息
	 * @param number
	 * @return
	 */
	Message findOne(String number);
}
