package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
public @interface JSONField
{
  boolean deserialize() default true;
  
  String format() default "";
  
  String name() default "";
  
  Feature[] parseFeatures() default {};
  
  boolean serialize() default true;
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/annotation/JSONField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */