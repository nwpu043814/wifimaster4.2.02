package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class EnumDeserializer
  implements ObjectDeserializer
{
  private final Class<?> enumClass;
  private final Map<String, Enum> nameMap = new HashMap();
  private final Map<Integer, Enum> ordinalMap = new HashMap();
  
  public EnumDeserializer(Class<?> paramClass)
  {
    this.enumClass = paramClass;
    try
    {
      Object[] arrayOfObject = (Object[])paramClass.getMethod("values", new Class[0]).invoke(null, new Object[0]);
      int j = arrayOfObject.length;
      for (int i = 0; i < j; i++)
      {
        Enum localEnum = (Enum)arrayOfObject[i];
        this.ordinalMap.put(Integer.valueOf(localEnum.ordinal()), localEnum);
        this.nameMap.put(localEnum.name(), localEnum);
      }
      return;
    }
    catch (Exception localException)
    {
      throw new JSONException("init enum values error, " + paramClass.getName());
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = null;
    try
    {
      localJSONLexer = paramDefaultJSONParser.getLexer();
      if (localJSONLexer.token() == 2)
      {
        paramObject = Integer.valueOf(localJSONLexer.intValue());
        localJSONLexer.nextToken(16);
        paramType = this.ordinalMap.get(paramObject);
        paramDefaultJSONParser = paramType;
        if (paramType != null) {
          break label139;
        }
        paramDefaultJSONParser = new com/alibaba/fastjson/JSONException;
        paramType = new java/lang/StringBuilder;
        paramType.<init>("parse enum ");
        paramDefaultJSONParser.<init>(this.enumClass.getName() + " error, value : " + paramObject);
        throw paramDefaultJSONParser;
      }
    }
    catch (JSONException paramDefaultJSONParser)
    {
      JSONLexer localJSONLexer;
      throw paramDefaultJSONParser;
      if (localJSONLexer.token() == 4)
      {
        paramDefaultJSONParser = localJSONLexer.stringVal();
        localJSONLexer.nextToken(16);
        if (paramDefaultJSONParser.length() == 0) {
          paramDefaultJSONParser = paramType;
        }
      }
      for (;;)
      {
        return paramDefaultJSONParser;
        this.nameMap.get(paramDefaultJSONParser);
        paramDefaultJSONParser = Enum.valueOf(this.enumClass, paramDefaultJSONParser);
        continue;
        if (localJSONLexer.token() != 8) {
          break;
        }
        localJSONLexer.nextToken(16);
        paramDefaultJSONParser = paramType;
      }
    }
    catch (Throwable paramDefaultJSONParser)
    {
      label139:
      throw new JSONException(paramDefaultJSONParser.getMessage(), paramDefaultJSONParser);
    }
    paramType = paramDefaultJSONParser.parse();
    paramObject = new com/alibaba/fastjson/JSONException;
    paramDefaultJSONParser = new java/lang/StringBuilder;
    paramDefaultJSONParser.<init>("parse enum ");
    ((JSONException)paramObject).<init>(this.enumClass.getName() + " error, value : " + paramType);
    throw ((Throwable)paramObject);
  }
  
  public int getFastMatchToken()
  {
    return 2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/EnumDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */