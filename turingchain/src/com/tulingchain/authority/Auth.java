package com.tulingchain.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//a.如果这个方法没有使用Auth注解,会认为没有作权限控制,任何人可以访问.
//b.如果这个方法只标注了@Auth,如果用户没登录,会返回一个403,并提示用户登录.
//c.如果这个方法标注了具体需要某种权限,如@Auth("authority"),就要求用户必须有这种权限,否则返回403,并提示用户没有权限,这里相当于实现授权,并且授权之前先认证.

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface Auth {  
    String value() default "";  
    String name() default "";  
}
