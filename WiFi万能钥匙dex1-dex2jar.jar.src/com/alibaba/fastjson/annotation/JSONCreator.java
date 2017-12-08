package com.alibaba.fastjson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.METHOD})
public @interface JSONCreator {}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/annotation/JSONCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */