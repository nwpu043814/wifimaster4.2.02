package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class ClassDerializer
  implements ObjectDeserializer
{
  public static final ClassDerializer instance = new ClassDerializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = paramDefaultJSONParser.getLexer();
    if (paramType.token() == 8) {
      paramType.nextToken();
    }
    for (paramDefaultJSONParser = null;; paramDefaultJSONParser = TypeUtils.loadClass(paramDefaultJSONParser))
    {
      return paramDefaultJSONParser;
      if (paramType.token() != 4) {
        throw new JSONException("expect className");
      }
      paramDefaultJSONParser = paramType.stringVal();
      paramType.nextToken(16);
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ClassDerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */