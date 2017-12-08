package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final AtomicIntegerArrayCodec instance = new AtomicIntegerArrayCodec();
  
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
      paramDefaultJSONParser = new AtomicIntegerArray(paramType.size());
      for (int i = 0; i < paramType.size(); i++) {
        paramDefaultJSONParser.set(i, paramType.getInteger(i).intValue());
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
      paramObject1 = (AtomicIntegerArray)paramObject1;
      int j = ((AtomicIntegerArray)paramObject1).length();
      paramJSONSerializer.append('[');
      for (int i = 0; i < j; i++)
      {
        int k = ((AtomicIntegerArray)paramObject1).get(i);
        if (i != 0) {
          paramJSONSerializer.write(',');
        }
        paramJSONSerializer.writeInt(k);
      }
      paramJSONSerializer.append(']');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/AtomicIntegerArrayCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */