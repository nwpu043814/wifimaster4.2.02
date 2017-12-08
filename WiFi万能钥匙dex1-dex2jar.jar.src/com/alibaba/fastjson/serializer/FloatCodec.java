package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;

public class FloatCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static FloatCodec instance = new FloatCodec();
  
  public static <T> T deserialze(DefaultJSONParser paramDefaultJSONParser)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2)
    {
      paramDefaultJSONParser = localJSONLexer.numberString();
      localJSONLexer.nextToken(16);
      paramDefaultJSONParser = Float.valueOf(Float.parseFloat(paramDefaultJSONParser));
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (localJSONLexer.token() == 3)
      {
        float f = localJSONLexer.floatValue();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Float.valueOf(f);
      }
      else
      {
        paramDefaultJSONParser = paramDefaultJSONParser.parse();
        if (paramDefaultJSONParser == null) {
          paramDefaultJSONParser = null;
        } else {
          paramDefaultJSONParser = TypeUtils.castToFloat(paramDefaultJSONParser);
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
    return 2;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramType = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramType.write('0');
      }
    }
    for (;;)
    {
      return;
      paramType.writeNull();
      continue;
      float f = ((Float)paramObject1).floatValue();
      if (Float.isNaN(f))
      {
        paramType.writeNull();
      }
      else if (Float.isInfinite(f))
      {
        paramType.writeNull();
      }
      else
      {
        paramObject2 = Float.toString(f);
        paramObject1 = paramObject2;
        if (((String)paramObject2).endsWith(".0")) {
          paramObject1 = ((String)paramObject2).substring(0, ((String)paramObject2).length() - 2);
        }
        paramType.write((String)paramObject1);
        if (paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
          paramType.write('F');
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FloatCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */