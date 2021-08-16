package com.assignment.testapp.model;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.assignment.testapp.Test;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public void refresh())")
	public void beforeServiceCall() {
		Test.restart();
	}
}
