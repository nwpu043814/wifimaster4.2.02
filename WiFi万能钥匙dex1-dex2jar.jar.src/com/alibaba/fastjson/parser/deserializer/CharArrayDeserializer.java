package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;

public class CharArrayDeserializer
  implements ObjectDeserializer
{
  public static final CharArrayDeserializer instance = new CharArrayDeserializer();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 4)
    {
      paramDefaultJSONParser = localJSONLexer.stringVal();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser = paramDefaultJSONParser.toCharArray();
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (localJSONLexer.token() == 2)
      {
        paramDefaultJSONParser = localJSONLexer.integerValue();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = paramDefaultJSONParser.toString().toCharArray();
      }
      else
      {
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser == null) {
          paramDefaultJSONParser = null;
        } else {
          paramDefaultJSONParser = JSON.toJSONString(paramDefaultJSONParser).toCharArray();
        }
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    return (T)deserialze(paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/CharArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */