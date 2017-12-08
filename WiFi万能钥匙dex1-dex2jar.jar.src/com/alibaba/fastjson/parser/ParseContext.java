package com.alibaba.fastjson.parser;

import java.lang.reflect.Type;

public class ParseContext
{
  private final Object fieldName;
  private Object object;
  private final ParseContext parent;
  private Type type;
  
  public ParseContext(ParseContext paramParseContext, Object paramObject1, Object paramObject2)
  {
    this.parent = paramParseContext;
    this.object = paramObject1;
    this.fieldName = paramObject2;
  }
  
  public Object getObject()
  {
    return this.object;
  }
  
  public ParseContext getParentContext()
  {
    return this.parent;
  }
  
  public String getPath()
  {
    String str;
    if (this.parent == null) {
      str = "$";
    }
    for (;;)
    {
      return str;
      if ((this.fieldName instanceof Integer)) {
        str = this.parent.getPath() + "[" + this.fieldName + "]";
      } else {
        str = this.parent.getPath() + "." + this.fieldName;
      }
    }
  }
  
  public Type getType()
  {
    return this.type;
  }
  
  public void setObject(Object paramObject)
  {
    this.object = paramObject;
  }
  
  public void setType(Type paramType)
  {
    this.type = paramType;
  }
  
  public String toString()
  {
    return getPath();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/ParseContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */