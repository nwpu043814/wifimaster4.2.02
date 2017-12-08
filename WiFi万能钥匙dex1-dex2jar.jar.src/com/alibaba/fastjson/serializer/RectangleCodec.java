package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Rectangle;
import java.lang.reflect.Type;

public class RectangleCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final RectangleCodec instance = new RectangleCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int n = 0;
    paramType = paramDefaultJSONParser.getLexer();
    if (paramType.token() == 8) {
      paramType.nextToken();
    }
    int m;
    int k;
    int j;
    for (paramDefaultJSONParser = null;; paramDefaultJSONParser = new Rectangle(j, k, m, n))
    {
      return paramDefaultJSONParser;
      if ((paramType.token() != 12) && (paramType.token() != 16)) {
        throw new JSONException("syntax error");
      }
      paramType.nextToken();
      m = 0;
      k = 0;
      j = 0;
      if (paramType.token() != 13) {
        break;
      }
      paramType.nextToken();
    }
    int i;
    int i3;
    int i2;
    int i1;
    if (paramType.token() == 4)
    {
      paramDefaultJSONParser = paramType.stringVal();
      paramType.nextTokenWithColon(2);
      if (paramType.token() != 2) {
        break label248;
      }
      i = paramType.intValue();
      paramType.nextToken();
      if (!paramDefaultJSONParser.equalsIgnoreCase("x")) {
        break label258;
      }
      i3 = i;
      i2 = k;
      i1 = m;
      i = n;
    }
    for (;;)
    {
      n = i;
      m = i1;
      k = i2;
      j = i3;
      if (paramType.token() != 16) {
        break;
      }
      paramType.nextToken(4);
      n = i;
      m = i1;
      k = i2;
      j = i3;
      break;
      throw new JSONException("syntax error");
      label248:
      throw new JSONException("syntax error");
      label258:
      if (paramDefaultJSONParser.equalsIgnoreCase("y"))
      {
        i2 = i;
        i = n;
        i1 = m;
        i3 = j;
      }
      else if (paramDefaultJSONParser.equalsIgnoreCase("width"))
      {
        i1 = i;
        i = n;
        i2 = k;
        i3 = j;
      }
      else
      {
        if (!paramDefaultJSONParser.equalsIgnoreCase("height")) {
          break label338;
        }
        i1 = m;
        i2 = k;
        i3 = j;
      }
    }
    label338:
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
    paramObject1 = (Rectangle)paramObject1;
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
        paramJSONSerializer.writeString(Rectangle.class.getName());
        c = ',';
      }
      paramJSONSerializer.writeFieldValue(c, "x", ((Rectangle)paramObject1).getX());
      paramJSONSerializer.writeFieldValue(',', "y", ((Rectangle)paramObject1).getY());
      paramJSONSerializer.writeFieldValue(',', "width", ((Rectangle)paramObject1).getWidth());
      paramJSONSerializer.writeFieldValue(',', "height", ((Rectangle)paramObject1).getHeight());
      paramJSONSerializer.write('}');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/RectangleCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */