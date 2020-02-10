package com.myproject.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.myproject.entiy.BaseEntity;


@Component(value = "generateTime")
public class GenerateTime  {
	
	public void aopAdd(JoinPoint JoinPoint) throws Throwable {
		Object[] args = JoinPoint.getArgs();
        BaseEntity baseEntity = (BaseEntity) args[0];
        
		//获取当前时间
		Date currentTime = new Date();
		System.out.println(currentTime);
		baseEntity.setSavetime(currentTime);
		baseEntity.setChangetime(currentTime);

	}
	
	//为update方法增强生成修改时间
	public void aopUpdate(JoinPoint JoinPoint) throws Throwable{
		Object[] args = JoinPoint.getArgs();
		BaseEntity baseEntity = (BaseEntity) args[0];
		Date currentTime = new Date();
		System.out.println(currentTime);
		baseEntity.setChangetime(currentTime);
	}
}

