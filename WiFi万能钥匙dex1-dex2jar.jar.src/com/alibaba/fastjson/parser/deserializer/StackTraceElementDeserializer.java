package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import java.lang.reflect.Type;

public class StackTraceElementDeserializer
  implements ObjectDeserializer
{
  public static final StackTraceElementDeserializer instance = new StackTraceElementDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    JSONLexer localJSONLexer = paramDefaultJSONParser.getLexer();
    if (localJSONLexer.token() == 8)
    {
      localJSONLexer.nextToken();
      paramDefaultJSONParser = null;
      return paramDefaultJSONParser;
    }
    if ((localJSONLexer.token() != 12) && (localJSONLexer.token() != 16)) {
      throw new JSONException("syntax error: " + JSONToken.name(localJSONLexer.token()));
    }
    Object localObject2 = null;
    Object localObject3 = null;
    Type localType = null;
    int j = 0;
    Object localObject1;
    int i;
    label149:
    do
    {
      paramType = localJSONLexer.scanSymbol(paramDefaultJSONParser.getSymbolTable());
      if (paramType != null) {
        break label191;
      }
      if (localJSONLexer.token() == 13)
      {
        localJSONLexer.nextToken(16);
        paramObject = localObject2;
        localObject1 = localObject3;
        paramType = localType;
        i = j;
        paramDefaultJSONParser = new StackTraceElement((String)paramObject, (String)localObject1, paramType, i);
        break;
      }
    } while ((localJSONLexer.token() == 16) && (localJSONLexer.isEnabled(Feature.AllowArbitraryCommas)));
    label191:
    localJSONLexer.nextTokenWithColon(4);
    if (paramType == "className") {
      if (localJSONLexer.token() == 8)
      {
        paramObject = null;
        localObject1 = localObject3;
        paramType = localType;
        i = j;
      }
    }
    label662:
    label672:
    label748:
    do
    {
      String str;
      do
      {
        for (;;)
        {
          j = i;
          localType = paramType;
          localObject3 = localObject1;
          localObject2 = paramObject;
          if (localJSONLexer.token() != 13) {
            break;
          }
          localJSONLexer.nextToken(16);
          break label149;
          if (localJSONLexer.token() == 4)
          {
            paramObject = localJSONLexer.stringVal();
            i = j;
            paramType = localType;
            localObject1 = localObject3;
          }
          else
          {
            throw new JSONException("syntax error");
            if (paramType == "methodName")
            {
              if (localJSONLexer.token() == 8)
              {
                localObject1 = null;
                i = j;
                paramType = localType;
                paramObject = localObject2;
              }
              else if (localJSONLexer.token() == 4)
              {
                localObject1 = localJSONLexer.stringVal();
                i = j;
                paramType = localType;
                paramObject = localObject2;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else if (paramType == "fileName")
            {
              if (localJSONLexer.token() == 8)
              {
                paramType = null;
                i = j;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else if (localJSONLexer.token() == 4)
              {
                paramType = localJSONLexer.stringVal();
                i = j;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else if (paramType == "lineNumber")
            {
              if (localJSONLexer.token() == 8)
              {
                i = 0;
                paramType = localType;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else if (localJSONLexer.token() == 2)
              {
                i = localJSONLexer.intValue();
                paramType = localType;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else
              {
                throw new JSONException("syntax error");
              }
            }
            else
            {
              if (paramType != "nativeMethod") {
                break label672;
              }
              if (localJSONLexer.token() == 8)
              {
                localJSONLexer.nextToken(16);
                i = j;
                paramType = localType;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else if (localJSONLexer.token() == 6)
              {
                localJSONLexer.nextToken(16);
                i = j;
                paramType = localType;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
              else
              {
                if (localJSONLexer.token() != 7) {
                  break label662;
                }
                localJSONLexer.nextToken(16);
                i = j;
                paramType = localType;
                localObject1 = localObject3;
                paramObject = localObject2;
              }
            }
          }
        }
        throw new JSONException("syntax error");
        if (paramType != JSON.DEFAULT_TYPE_KEY) {
          break label784;
        }
        if (localJSONLexer.token() != 4) {
          break label748;
        }
        str = localJSONLexer.stringVal();
        i = j;
        paramType = localType;
        localObject1 = localObject3;
        paramObject = localObject2;
      } while (str.equals("java.lang.StackTraceElement"));
      throw new JSONException("syntax error : " + str);
      i = j;
      paramType = localType;
      localObject1 = localObject3;
      paramObject = localObject2;
    } while (localJSONLexer.token() == 8);
    throw new JSONException("syntax error");
    label784:
    throw new JSONException("syntax error : " + paramType);
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/StackTraceElementDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */