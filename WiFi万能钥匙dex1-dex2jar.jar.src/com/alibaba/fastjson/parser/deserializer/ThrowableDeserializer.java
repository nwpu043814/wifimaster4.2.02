package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ThrowableDeserializer
  extends JavaBeanDeserializer
{
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass)
  {
    super(paramParserConfig, paramClass);
  }
  
  private Throwable createException(String paramString, Throwable paramThrowable, Class<?> paramClass)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    Constructor[] arrayOfConstructor = paramClass.getConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    Object localObject3 = null;
    paramClass = (Class<?>)localObject2;
    if (i < j)
    {
      localObject2 = arrayOfConstructor[i];
      if (((Constructor)localObject2).getParameterTypes().length == 0)
      {
        paramClass = (Class<?>)localObject1;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      i++;
      localObject2 = localObject1;
      localObject1 = paramClass;
      paramClass = (Class<?>)localObject2;
      break;
      if ((((Constructor)localObject2).getParameterTypes().length == 1) && (localObject2.getParameterTypes()[0] == String.class))
      {
        localObject1 = paramClass;
        paramClass = (Class<?>)localObject2;
      }
      else if ((((Constructor)localObject2).getParameterTypes().length == 2) && (localObject2.getParameterTypes()[0] == String.class) && (localObject2.getParameterTypes()[1] == Throwable.class))
      {
        Object localObject4 = localObject1;
        localObject1 = paramClass;
        localObject3 = localObject2;
        paramClass = (Class<?>)localObject4;
        continue;
        if (localObject3 != null) {
          paramString = (Throwable)((Constructor)localObject3).newInstance(new Object[] { paramString, paramThrowable });
        }
        for (;;)
        {
          return paramString;
          if (localObject1 != null) {
            paramString = (Throwable)((Constructor)localObject1).newInstance(new Object[] { paramString });
          } else if (paramClass != null) {
            paramString = (Throwable)paramClass.newInstance(new Object[0]);
          } else {
            paramString = null;
          }
        }
      }
      else
      {
        localObject2 = paramClass;
        paramClass = (Class<?>)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      paramObject = null;
      return (T)paramObject;
    }
    label42:
    Throwable localThrowable;
    if (paramDefaultJSONParser.getResolveStatus() == 2)
    {
      paramDefaultJSONParser.setResolveStatus(0);
      localThrowable = null;
      if ((paramType == null) || (!(paramType instanceof Class))) {
        break label472;
      }
      paramType = (Class)paramType;
      if (!Throwable.class.isAssignableFrom(paramType)) {
        break label472;
      }
    }
    for (;;)
    {
      String str1 = null;
      String str2 = null;
      HashMap localHashMap = new HashMap();
      paramObject = paramType;
      paramType = str2;
      label90:
      str2 = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
      if (str2 == null) {
        if (localJSONLexer.token() == 13)
        {
          localJSONLexer.nextToken(16);
          if (paramObject != null) {
            break label429;
          }
          paramDefaultJSONParser = new Exception(str1, localThrowable);
        }
      }
      for (;;)
      {
        paramObject = paramDefaultJSONParser;
        if (paramType == null) {
          break;
        }
        paramDefaultJSONParser.setStackTrace(paramType);
        paramObject = paramDefaultJSONParser;
        break;
        if (localJSONLexer.token() == 12) {
          break label42;
        }
        throw new JSONException("syntax error");
        if ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas))) {
          break label90;
        }
        localJSONLexer.nextTokenWithColon(4);
        if (JSON.DEFAULT_TYPE_KEY.equals(str2)) {
          if (localJSONLexer.token() == 4)
          {
            paramObject = TypeUtils.loadClass(localJSONLexer.stringVal());
            localJSONLexer.nextToken(16);
          }
        }
        for (;;)
        {
          if (localJSONLexer.token() != 13) {
            break label426;
          }
          localJSONLexer.nextToken(16);
          break;
          throw new JSONException("syntax error");
          if ("message".equals(str2))
          {
            if (localJSONLexer.token() == 8) {}
            for (str1 = null;; str1 = localJSONLexer.stringVal())
            {
              localJSONLexer.nextToken();
              break;
              if (localJSONLexer.token() != 4) {
                break label350;
              }
            }
            label350:
            throw new JSONException("syntax error");
          }
          if ("cause".equals(str2)) {
            localThrowable = (Throwable)deserialze(paramDefaultJSONParser, null, "cause");
          } else if ("stackTrace".equals(str2)) {
            paramType = (StackTraceElement[])paramDefaultJSONParser.parseObject(StackTraceElement[].class);
          } else {
            localHashMap.put(str2, paramDefaultJSONParser.parse());
          }
        }
        label426:
        break label90;
        try
        {
          label429:
          paramObject = createException(str1, localThrowable, (Class)paramObject);
          paramDefaultJSONParser = (DefaultJSONParser)paramObject;
          if (paramObject == null) {
            paramDefaultJSONParser = new Exception(str1, localThrowable);
          }
        }
        catch (Exception paramDefaultJSONParser)
        {
          throw new JSONException("create instance error", paramDefaultJSONParser);
        }
      }
      label472:
      paramType = null;
    }
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */