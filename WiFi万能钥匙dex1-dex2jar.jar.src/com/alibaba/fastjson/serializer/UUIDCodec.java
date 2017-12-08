package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.UUID;

public class UUIDCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final UUIDCodec instance = new UUIDCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = (String)paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {}
    for (paramDefaultJSONParser = null;; paramDefaultJSONParser = UUID.fromString(paramDefaultJSONParser)) {
      return paramDefaultJSONParser;
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      return;
      paramJSONSerializer.write(((UUID)paramObject1).toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/UUIDCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */