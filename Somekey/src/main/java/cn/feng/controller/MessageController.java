package cn.feng.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.feng.bean.Message;
import cn.feng.gong.Uid;
import cn.feng.service.IMessageService;

@Controller
public class MessageController {
	@Resource
	private IMessageService service;
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
	@RequestMapping("/login.do")
    public String login(Model model) throws Exception{
            List<Message> lists =service.selectUserList();
            model.addAttribute("userLists", lists);//回显用户信息
            model.addAttribute("currentUser", "测试");    
            return "redirect:main.do";
    }
	@RequestMapping("/main.do")
	public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,Model model){
	     model.addAttribute("pagemsg", service.findByPage(currentPage));
	        return "index";
	}
	 @RequestMapping("/add.do")
	    public String add(Model model,HttpServletRequest request){
		 	String aa=request.getParameter("number");
		 	System.out.println(aa);
		 	Message message=new Message();
	        model.addAttribute("returnUser", aa);
	        return "add";
	    }
	 @RequestMapping("/update.do")
	    public String update(Model model,HttpServletRequest request) throws ParseException{
		 	String number=request.getParameter("number");
		 	System.out.println(number);
		 	Message message=service.findOne(number);
	        model.addAttribute("returnUser", message);
	        return "add";
	    }
	 @RequestMapping("/save.do")
	 public String save(HttpServletRequest request) throws ParseException {
		 System.out.println(request.getParameter("number"));
		 if(request.getParameter("number")==null||request.getParameter("number").equals("")) {
			 Message mess=new Message();
				mess.setNumber(Uid.getUUID32().substring(0, 6));
				String data=request.getParameter("date");
				mess.setDate(data);
				mess.setId(request.getParameter("id"));
				mess.setSex(request.getParameter("sex"));
				mess.setName(request.getParameter("name"));
		        	service.add(mess);
		 }else {
			 Message mess=new Message();
			 mess.setNumber(request.getParameter("number"));
			 String data=request.getParameter("date");
			 System.out.println(data);
				mess.setDate(data);
				mess.setId(request.getParameter("id"));
				mess.setSex(request.getParameter("sex"));
				mess.setName(request.getParameter("name"));
				service.update(mess);
		 }
		
	        return "redirect:main.do";
	  }
	    @RequestMapping("/delete.do")
	    public String delete(@RequestParam("number") String number){
	    	System.out.println(number);
	        service.delete(number);
	        return "redirect:main.do";
	    }
	    @RequestMapping("/list.do")
	    public String findm(Model model,HttpServletRequest request) {
	    	String name=request.getParameter("name");
	    	List<Message> list=service.findm(name);
	    	model.addAttribute("list",list);
	    	return "index1";
	    }
	 
}
