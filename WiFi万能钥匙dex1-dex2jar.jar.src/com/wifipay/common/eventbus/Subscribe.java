package com.wifipay.common.eventbus;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Subscribe
{
  int priority() default 0;
  
  boolean sticky() default false;
  
  ThreadMode threadMode() default ThreadMode.POSTING;
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/Subscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */