package cn.feng.mapper;

import java.util.HashMap;
import java.util.List;

import cn.feng.bean.Message;

public interface MessageDAO {
	/**
	 * 添加一条记录
	 * @param message
	 */
	void addMessage(Message message);
	/**
	 * 查询所有记录
	 * @return
	 */
	List<Message> findAll();
	/**
	 * 删除一条记录
	 * @param number
	 */
	void delete(String number);
	/**
	 * 查询总共条数
	 * @return
	 */
	int selectCount();
	/**
	 * 分页查询数据
	 * @param map
	 * @return
	 */
	List<Message> findByPage(HashMap<String,Object> map);
	/**
	 * 查询记录总合
	 * @return
	 */
	List<Message> selectUserList();
	/**
	 * 更新数据
	 * @param message
	 */
	void update(Message message);
	/**
	 * 根据名字模糊查询
	 * @param name
	 * @return
	 */
	List<Message> finm(String name);
	/**
	 * 根据编号查询一个信息
	 * @param number
	 * @return
	 */
	Message findOne(String number);
}
