package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static InetAddressCodec instance = new InetAddressCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramDefaultJSONParser = (String)paramDefaultJSONParser.parse();
    if (paramDefaultJSONParser == null) {
      paramDefaultJSONParser = null;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (paramDefaultJSONParser.length() == 0)
      {
        paramDefaultJSONParser = null;
        continue;
      }
      try
      {
        paramDefaultJSONParser = InetAddress.getByName(paramDefaultJSONParser);
      }
      catch (UnknownHostException paramDefaultJSONParser)
      {
        throw new JSONException("deserialize error", paramDefaultJSONParser);
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
      paramJSONSerializer.write(((InetAddress)paramObject1).getHostAddress());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/InetAddressCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */