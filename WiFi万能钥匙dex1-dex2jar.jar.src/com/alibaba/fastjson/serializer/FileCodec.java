package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.File;
import java.lang.reflect.Type;

public class FileCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static FileCodec instance = new FileCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {}
    for (paramDefaultJSONParser = null;; paramDefaultJSONParser = new File((String)paramDefaultJSONParser)) {
      return paramDefaultJSONParser;
    }
  }
  
  public int getFastMatchToken()
  {
    return 4;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      ((SerializeWriter)paramObject2).writeNull();
    }
    for (;;)
    {
      return;
      paramJSONSerializer.write(((File)paramObject1).getPath());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FileCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */