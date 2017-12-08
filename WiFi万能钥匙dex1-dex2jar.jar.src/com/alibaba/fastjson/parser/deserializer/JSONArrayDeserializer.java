package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public class JSONArrayDeserializer
  implements ObjectDeserializer
{
  public static final JSONArrayDeserializer instance = new JSONArrayDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = new JSONArray();
    paramDefaultJSONParser.parseArray(paramType);
    return paramType;
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/JSONArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */