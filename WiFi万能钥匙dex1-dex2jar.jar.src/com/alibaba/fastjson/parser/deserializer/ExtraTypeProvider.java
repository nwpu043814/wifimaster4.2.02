package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.Type;

public abstract interface ExtraTypeProvider
  extends ParseProcess
{
  public abstract Type getExtraType(Object paramObject, String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ExtraTypeProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */