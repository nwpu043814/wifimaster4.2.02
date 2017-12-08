package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final AtomicLongArrayCodec instance = new AtomicLongArrayCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    if (paramDefaultJSONParser.getLexer().token() == 8)
    {
      paramDefaultJSONParser.getLexer().nextToken(16);
      paramDefaultJSONParser = null;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      paramType = new JSONArray();
      paramDefaultJSONParser.parseArray(paramType);
      paramDefaultJSONParser = new AtomicLongArray(paramType.size());
      for (int i = 0; i < paramType.size(); i++) {
        paramDefaultJSONParser.set(i, paramType.getLong(i).longValue());
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
        paramJSONSerializer.write("[]");
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      paramObject1 = (AtomicLongArray)paramObject1;
      int j = ((AtomicLongArray)paramObject1).length();
      paramJSONSerializer.append('[');
      for (int i = 0; i < j; i++)
      {
        long l = ((AtomicLongArray)paramObject1).get(i);
        if (i != 0) {
          paramJSONSerializer.write(',');
        }
        paramJSONSerializer.writeLong(l);
      }
      paramJSONSerializer.append(']');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/AtomicLongArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */