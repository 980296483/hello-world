package cn.feng.gong;

import java.util.UUID;

public class Uid {
	public static String getUUID32(){
	    String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
	    //return uuid;
	  return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}

}
