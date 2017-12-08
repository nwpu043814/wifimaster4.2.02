package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;

public class StringCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static StringCodec instance = new StringCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 4)
    {
      paramDefaultJSONParser = localJSONLexer.stringVal();
      localJSONLexer.nextToken(16);
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (localJSONLexer.token() == 2)
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
      }
      else
      {
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser == null) {
          paramDefaultJSONParser = null;
        } else {
          paramDefaultJSONParser = paramDefaultJSONParser.toString();
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
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    write(paramJSONSerializer, (String)paramObject1);
  }
  
  public void write(JSONSerializer paramJSONSerializer, String paramString)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramString == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
        paramJSONSerializer.writeString("");
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramJSONSerializer.writeString(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/StringCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */