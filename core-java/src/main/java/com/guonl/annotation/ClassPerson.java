package com.guonl.annotation;

/**
 * Created by guonl
 * Date 2018/4/8 下午2:27
 * Description:
 */
@MyAnnotation(name="person",say="hello",age=12)
public class ClassPerson {
	@MyAnnotation(name="person")
	public String getName() {return null;};
	
	@MyAnnotation(say="good")
	public void sayit() {};
	
	@MyAnnotation(age=10)
	public int age() {return 0;};

}
