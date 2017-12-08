package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Color;
import java.lang.reflect.Type;

public class ColorCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final ColorCodec instance = new ColorCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int n = 0;
    paramType = paramDefaultJSONParser.getLexer();
    if ((paramType.token() != 12) && (paramType.token() != 16)) {
      throw new JSONException("syntax error");
    }
    paramType.nextToken();
    int m = 0;
    int k = 0;
    int j = 0;
    if (paramType.token() == 13)
    {
      paramType.nextToken();
      return new Color(j, k, m, n);
    }
    int i;
    int i2;
    int i3;
    int i1;
    if (paramType.token() == 4)
    {
      paramDefaultJSONParser = paramType.stringVal();
      paramType.nextTokenWithColon(2);
      if (paramType.token() != 2) {
        break label224;
      }
      i = paramType.intValue();
      paramType.nextToken();
      if (!paramDefaultJSONParser.equalsIgnoreCase("r")) {
        break label234;
      }
      i2 = i;
      i3 = k;
      i1 = m;
      i = n;
    }
    for (;;)
    {
      n = i;
      m = i1;
      k = i3;
      j = i2;
      if (paramType.token() != 16) {
        break;
      }
      paramType.nextToken(4);
      n = i;
      m = i1;
      k = i3;
      j = i2;
      break;
      throw new JSONException("syntax error");
      label224:
      throw new JSONException("syntax error");
      label234:
      if (paramDefaultJSONParser.equalsIgnoreCase("g"))
      {
        i3 = i;
        i = n;
        i1 = m;
        i2 = j;
      }
      else if (paramDefaultJSONParser.equalsIgnoreCase("b"))
      {
        i1 = i;
        i = n;
        i3 = k;
        i2 = j;
      }
      else
      {
        if (!paramDefaultJSONParser.equalsIgnoreCase("alpha")) {
          break label314;
        }
        i1 = m;
        i3 = k;
        i2 = j;
      }
    }
    label314:
    throw new JSONException("syntax error, " + paramDefaultJSONParser);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    char c = '{';
    paramJSONSerializer = paramJSONSerializer.getWriter();
    paramObject1 = (Color)paramObject1;
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
        paramJSONSerializer.writeString(Color.class.getName());
        c = ',';
      }
      paramJSONSerializer.writeFieldValue(c, "r", ((Color)paramObject1).getRed());
      paramJSONSerializer.writeFieldValue(',', "g", ((Color)paramObject1).getGreen());
      paramJSONSerializer.writeFieldValue(',', "b", ((Color)paramObject1).getBlue());
      if (((Color)paramObject1).getAlpha() > 0) {
        paramJSONSerializer.writeFieldValue(',', "alpha", ((Color)paramObject1).getAlpha());
      }
      paramJSONSerializer.write('}');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ColorCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */