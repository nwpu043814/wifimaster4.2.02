package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JSONType
{
  boolean alphabetic() default true;
  
  boolean asm() default true;
  
  String[] ignores() default {};
  
  Class<?> mappingTo() default Void.class;
  
  String[] orders() default {};
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/annotation/JSONType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */