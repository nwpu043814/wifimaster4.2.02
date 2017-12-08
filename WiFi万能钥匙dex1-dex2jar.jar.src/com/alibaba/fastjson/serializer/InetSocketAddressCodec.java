package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class InetSocketAddressCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static InetSocketAddressCodec instance = new InetSocketAddressCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = null;
    paramType = null;
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8) {
      localJSONLexer.nextToken();
    }
    int i;
    for (paramDefaultJSONParser = paramType;; paramDefaultJSONParser = new InetSocketAddress(paramType, i))
    {
      return paramDefaultJSONParser;
      paramDefaultJSONParser.accept(12);
      i = 0;
      paramType = (Type)paramObject;
      paramObject = localJSONLexer.stringVal();
      localJSONLexer.nextToken(17);
      if (((String)paramObject).equals("address"))
      {
        paramDefaultJSONParser.accept(17);
        paramType = (InetAddress)paramDefaultJSONParser.parseObject(InetAddress.class);
      }
      for (;;)
      {
        if (localJSONLexer.token() != 16) {
          break label177;
        }
        localJSONLexer.nextToken();
        break;
        if (((String)paramObject).equals("port"))
        {
          paramDefaultJSONParser.accept(17);
          if (localJSONLexer.token() != 2) {
            throw new JSONException("port is not int");
          }
          i = localJSONLexer.intValue();
          localJSONLexer.nextToken();
        }
        else
        {
          paramDefaultJSONParser.accept(17);
          paramDefaultJSONParser.parse();
        }
      }
      label177:
      paramDefaultJSONParser.accept(13);
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      return;
      paramObject2 = paramJSONSerializer.getWriter();
      paramObject1 = (InetSocketAddress)paramObject1;
      paramType = ((InetSocketAddress)paramObject1).getAddress();
      ((SerializeWriter)paramObject2).write('{');
      if (paramType != null)
      {
        ((SerializeWriter)paramObject2).writeFieldName("address");
        paramJSONSerializer.write(paramType);
        ((SerializeWriter)paramObject2).write(',');
      }
      ((SerializeWriter)paramObject2).writeFieldName("port");
      ((SerializeWriter)paramObject2).writeInt(((InetSocketAddress)paramObject1).getPort());
      ((SerializeWriter)paramObject2).write('}');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/InetSocketAddressCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */