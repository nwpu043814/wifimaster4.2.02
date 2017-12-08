package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JavaObjectDeserializer
  implements ObjectDeserializer
{
  public static final JavaObjectDeserializer instance = new JavaObjectDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if ((paramType instanceof GenericArrayType))
    {
      paramObject = ((GenericArrayType)paramType).getGenericComponentType();
      paramType = (Type)paramObject;
      if ((paramObject instanceof TypeVariable)) {
        paramType = ((TypeVariable)paramObject).getBounds()[0];
      }
      paramObject = new ArrayList();
      paramDefaultJSONParser.parseArray(paramType, (Collection)paramObject);
      if ((paramType instanceof Class))
      {
        paramDefaultJSONParser = (Object[])Array.newInstance((Class)paramType, ((List)paramObject).size());
        ((List)paramObject).toArray(paramDefaultJSONParser);
      }
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser = ((List)paramObject).toArray();
      continue;
      paramDefaultJSONParser = paramDefaultJSONParser.parse(paramObject);
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/JavaObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */