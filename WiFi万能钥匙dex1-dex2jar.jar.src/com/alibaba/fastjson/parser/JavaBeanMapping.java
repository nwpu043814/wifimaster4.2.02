package com.alibaba.fastjson.parser;

@Deprecated
public class JavaBeanMapping
  extends ParserConfig
{
  private static final JavaBeanMapping instance = new JavaBeanMapping();
  
  public static JavaBeanMapping getGlobalInstance()
  {
    return instance;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/JavaBeanMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */