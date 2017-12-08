package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Font;
import java.lang.reflect.Type;

public class FontCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final FontCodec instance = new FontCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = null;
    paramType = null;
    int j = 0;
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8) {
      localJSONLexer.nextToken(16);
    }
    int i;
    for (paramDefaultJSONParser = paramType;; paramDefaultJSONParser = new Font(paramDefaultJSONParser, j, i))
    {
      return paramDefaultJSONParser;
      if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
        throw new JSONException("syntax error");
      }
      localJSONLexer.nextToken();
      i = 0;
      paramDefaultJSONParser = (DefaultJSONParser)paramObject;
      if (localJSONLexer.token() != 13) {
        break;
      }
      localJSONLexer.nextToken();
    }
    int m;
    int k;
    if (localJSONLexer.token() == 4)
    {
      paramType = localJSONLexer.stringVal();
      localJSONLexer.nextTokenWithColon(2);
      if (!paramType.equalsIgnoreCase("name")) {
        break label252;
      }
      if (localJSONLexer.token() != 4) {
        break label242;
      }
      paramType = localJSONLexer.stringVal();
      localJSONLexer.nextToken();
      m = i;
      k = j;
    }
    for (;;)
    {
      paramDefaultJSONParser = paramType;
      j = k;
      i = m;
      if (localJSONLexer.token() != 16) {
        break;
      }
      localJSONLexer.nextToken(4);
      paramDefaultJSONParser = paramType;
      j = k;
      i = m;
      break;
      throw new JSONException("syntax error");
      label242:
      throw new JSONException("syntax error");
      label252:
      if (paramType.equalsIgnoreCase("style"))
      {
        if (localJSONLexer.token() == 2)
        {
          k = localJSONLexer.intValue();
          localJSONLexer.nextToken();
          paramType = paramDefaultJSONParser;
          m = i;
        }
        else
        {
          throw new JSONException("syntax error");
        }
      }
      else
      {
        if (!paramType.equalsIgnoreCase("size")) {
          break label362;
        }
        if (localJSONLexer.token() != 2) {
          break label352;
        }
        m = localJSONLexer.intValue();
        localJSONLexer.nextToken();
        paramType = paramDefaultJSONParser;
        k = j;
      }
    }
    label352:
    throw new JSONException("syntax error");
    label362:
    throw new JSONException("syntax error, " + paramType);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    char c = '{';
    paramJSONSerializer = paramJSONSerializer.getWriter();
    paramObject1 = (Font)paramObject1;
    if (paramObject1 == null) {
      paramJSONSerializer.writeNull();
    }
    for (;;)
    {
      return;
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName))
      {
        paramJSONSerializer.write('{');
        paramJSONSerializer.writeFieldName(JSON.DEFAULT_TYPE_KEY);
        paramJSONSerializer.writeString(Font.class.getName());
        c = ',';
      }
      paramJSONSerializer.writeFieldValue(c, "name", ((Font)paramObject1).getName());
      paramJSONSerializer.writeFieldValue(',', "style", ((Font)paramObject1).getStyle());
      paramJSONSerializer.writeFieldValue(',', "size", ((Font)paramObject1).getSize());
      paramJSONSerializer.write('}');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FontCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */