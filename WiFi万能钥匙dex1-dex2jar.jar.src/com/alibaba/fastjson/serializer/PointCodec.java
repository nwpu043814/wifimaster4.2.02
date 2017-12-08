package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.awt.Point;
import java.lang.reflect.Type;

public class PointCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final PointCodec instance = new PointCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    int j = 0;
    paramObject = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)paramObject).token() == 8)
    {
      ((JSONLexer)paramObject).nextToken(16);
      paramDefaultJSONParser = null;
      return paramDefaultJSONParser;
    }
    if ((((JSONLexer)paramObject).token() != 12) && (((JSONLexer)paramObject).token() != 16)) {
      throw new JSONException("syntax error");
    }
    ((JSONLexer)paramObject).nextToken();
    int i = 0;
    for (;;)
    {
      if (((JSONLexer)paramObject).token() == 13)
      {
        ((JSONLexer)paramObject).nextToken();
        paramDefaultJSONParser = new Point(i, j);
        break;
      }
      if (((JSONLexer)paramObject).token() != 4) {
        break label225;
      }
      paramType = ((JSONLexer)paramObject).stringVal();
      if (!JSON.DEFAULT_TYPE_KEY.equals(paramType)) {
        break label140;
      }
      paramDefaultJSONParser.acceptType("java.awt.Point");
    }
    label140:
    ((JSONLexer)paramObject).nextTokenWithColon(2);
    int k;
    int m;
    if (((JSONLexer)paramObject).token() == 2)
    {
      k = ((JSONLexer)paramObject).intValue();
      ((JSONLexer)paramObject).nextToken();
      if (!paramType.equalsIgnoreCase("x")) {
        break label264;
      }
      m = k;
      k = j;
    }
    for (;;)
    {
      j = k;
      i = m;
      if (((JSONLexer)paramObject).token() != 16) {
        break;
      }
      ((JSONLexer)paramObject).nextToken(4);
      j = k;
      i = m;
      break;
      label225:
      throw new JSONException("syntax error");
      throw new JSONException("syntax error : " + ((JSONLexer)paramObject).tokenName());
      label264:
      if (!paramType.equalsIgnoreCase("y")) {
        break label280;
      }
      m = i;
    }
    label280:
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
    paramObject1 = (Point)paramObject1;
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
        paramJSONSerializer.writeString(Point.class.getName());
        c = ',';
      }
      paramJSONSerializer.writeFieldValue(c, "x", ((Point)paramObject1).getX());
      paramJSONSerializer.writeFieldValue(',', "y", ((Point)paramObject1).getY());
      paramJSONSerializer.write('}');
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/PointCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */