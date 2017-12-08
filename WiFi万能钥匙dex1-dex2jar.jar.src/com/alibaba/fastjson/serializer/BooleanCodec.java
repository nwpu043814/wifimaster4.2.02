package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final BooleanCodec instance = new BooleanCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)paramObject).token() == 6)
    {
      ((JSONLexer)paramObject).nextToken(16);
      paramDefaultJSONParser = Boolean.TRUE;
    }
    for (;;)
    {
      paramObject = paramDefaultJSONParser;
      if (paramType == AtomicBoolean.class) {}
      for (paramObject = new AtomicBoolean(paramDefaultJSONParser.booleanValue());; paramObject = null)
      {
        return (T)paramObject;
        if (((JSONLexer)paramObject).token() == 7)
        {
          ((JSONLexer)paramObject).nextToken(16);
          paramDefaultJSONParser = Boolean.FALSE;
          break;
        }
        if (((JSONLexer)paramObject).token() == 2)
        {
          int i = ((JSONLexer)paramObject).intValue();
          ((JSONLexer)paramObject).nextToken(16);
          if (i == 1)
          {
            paramDefaultJSONParser = Boolean.TRUE;
            break;
          }
          paramDefaultJSONParser = Boolean.FALSE;
          break;
        }
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser != null) {
          break label136;
        }
      }
      label136:
      paramDefaultJSONParser = TypeUtils.castToBoolean(paramDefaultJSONParser);
    }
  }
  
  public int getFastMatchToken()
  {
    return 6;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramJSONSerializer = paramJSONSerializer.getWriter();
    paramObject1 = (Boolean)paramObject1;
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
        paramJSONSerializer.write("false");
      }
    }
    for (;;)
    {
      return;
      paramJSONSerializer.writeNull();
      continue;
      if (((Boolean)paramObject1).booleanValue()) {
        paramJSONSerializer.write("true");
      } else {
        paramJSONSerializer.write("false");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/BooleanCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */