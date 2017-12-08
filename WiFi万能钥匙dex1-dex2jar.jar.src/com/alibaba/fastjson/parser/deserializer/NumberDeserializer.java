package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class NumberDeserializer
  implements ObjectDeserializer
{
  public static final NumberDeserializer instance = new NumberDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 2) {
      if ((paramType == Double.TYPE) || (paramType == Double.class))
      {
        paramDefaultJSONParser = localJSONLexer.numberString();
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
      }
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      long l = localJSONLexer.longValue();
      localJSONLexer.nextToken(16);
      if ((paramType == Short.TYPE) || (paramType == Short.class))
      {
        paramDefaultJSONParser = Short.valueOf((short)(int)l);
      }
      else if ((paramType == Byte.TYPE) || (paramType == Byte.class))
      {
        paramDefaultJSONParser = Byte.valueOf((byte)(int)l);
      }
      else if ((l >= -2147483648L) && (l <= 2147483647L))
      {
        paramDefaultJSONParser = Integer.valueOf((int)l);
      }
      else
      {
        paramDefaultJSONParser = Long.valueOf(l);
        continue;
        if (localJSONLexer.token() == 3)
        {
          if ((paramType == Double.TYPE) || (paramType == Double.class))
          {
            paramDefaultJSONParser = localJSONLexer.numberString();
            localJSONLexer.nextToken(16);
            paramDefaultJSONParser = Double.valueOf(Double.parseDouble(paramDefaultJSONParser));
          }
          else
          {
            paramObject = localJSONLexer.decimalValue();
            localJSONLexer.nextToken(16);
            if ((paramType == Short.TYPE) || (paramType == Short.class))
            {
              paramDefaultJSONParser = Short.valueOf(((BigDecimal)paramObject).shortValue());
            }
            else if (paramType != Byte.TYPE)
            {
              paramDefaultJSONParser = (DefaultJSONParser)paramObject;
              if (paramType != Byte.class) {}
            }
            else
            {
              paramDefaultJSONParser = Byte.valueOf(((BigDecimal)paramObject).byteValue());
            }
          }
        }
        else
        {
          paramDefaultJSONParser = paramDefaultJSONParser.parse();
          if (paramDefaultJSONParser == null) {
            paramDefaultJSONParser = null;
          } else if ((paramType == Double.TYPE) || (paramType == Double.class)) {
            paramDefaultJSONParser = TypeUtils.castToDouble(paramDefaultJSONParser);
          } else if ((paramType == Short.TYPE) || (paramType == Short.class)) {
            paramDefaultJSONParser = TypeUtils.castToShort(paramDefaultJSONParser);
          } else if ((paramType == Byte.TYPE) || (paramType == Byte.class)) {
            paramDefaultJSONParser = TypeUtils.castToByte(paramDefaultJSONParser);
          } else {
            paramDefaultJSONParser = TypeUtils.castToBigDecimal(paramDefaultJSONParser);
          }
        }
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/NumberDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */