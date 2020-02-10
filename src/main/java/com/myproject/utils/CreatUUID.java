package com.myproject.utils;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myproject.pojo.user;
import com.myproject.service.UserService;

public class CreatUUID {
	
		public static String uuid() {
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
	    	return uuid;
	    }
		
		
		  /**
	     * 获得指定数目的UUID 
	     * @param number int 需要获得的UUID数量 
	     * @return String[] UUID数组 
	     */
	    public static String[] getuuid(int number){
	        if(number < 1){
	            return null;
	        }
	        String[] retArray = new String[number];
	        for(int i=0;i<number;i++){
	            retArray[i] = uuid();
	        }
	        return retArray;
	    }
	    
}
