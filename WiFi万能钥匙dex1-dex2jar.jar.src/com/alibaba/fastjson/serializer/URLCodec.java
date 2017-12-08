package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;

public class URLCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final URLCodec instance = new URLCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = (String)paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      paramDefaultJSONParser = null;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      try
      {
        paramDefaultJSONParser = new URL(paramDefaultJSONParser);
      }
      catch (MalformedURLException paramDefaultJSONParser)
      {
        throw new JSONException("create url error", paramDefaultJSONParser);
      }
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
      paramJSONSerializer.write(paramObject1.toString());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/URLCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */