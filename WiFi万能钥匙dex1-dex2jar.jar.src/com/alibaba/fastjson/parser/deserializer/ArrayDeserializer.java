package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

public class ArrayDeserializer
  implements ObjectDeserializer
{
  public static final ArrayDeserializer instance = new ArrayDeserializer();
  
  private <T> T toObjectArray(DefaultJSONParser paramDefaultJSONParser, Class<?> paramClass, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null)
    {
      paramDefaultJSONParser = null;
      return paramDefaultJSONParser;
    }
    int m = paramJSONArray.size();
    Object localObject2 = Array.newInstance(paramClass, m);
    int i = 0;
    Object localObject3;
    while (i < m)
    {
      localObject3 = paramJSONArray.get(i);
      if (localObject3 == paramJSONArray)
      {
        Array.set(localObject2, i, localObject2);
        label55:
        i++;
      }
      else
      {
        if (paramClass.isArray())
        {
          if (paramClass.isInstance(localObject3)) {}
          for (localObject1 = localObject3;; localObject1 = toObjectArray(paramDefaultJSONParser, paramClass, (JSONArray)localObject3))
          {
            Array.set(localObject2, i, localObject1);
            break;
          }
        }
        if (!(localObject3 instanceof JSONArray)) {
          break label235;
        }
        localObject1 = (JSONArray)localObject3;
        int n = ((JSONArray)localObject1).size();
        int j = 0;
        int k = 0;
        while (j < n)
        {
          if (((JSONArray)localObject1).get(j) == paramJSONArray)
          {
            ((JSONArray)localObject1).set(i, localObject2);
            k = 1;
          }
          j++;
        }
        if (k == 0) {
          break label235;
        }
      }
    }
    label235:
    for (Object localObject1 = ((JSONArray)localObject1).toArray();; localObject1 = null)
    {
      if (localObject1 == null) {
        localObject1 = TypeUtils.cast(localObject3, paramClass, paramDefaultJSONParser.getConfig());
      }
      for (;;)
      {
        Array.set(localObject2, i, localObject1);
        break label55;
        paramJSONArray.setRelatedArray(localObject2);
        paramJSONArray.setComponentType(paramClass);
        paramDefaultJSONParser = (DefaultJSONParser)localObject2;
        break;
      }
    }
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)localObject2).token() == 8)
    {
      ((JSONLexer)localObject2).nextToken(16);
      paramDefaultJSONParser = (DefaultJSONParser)localObject1;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (((JSONLexer)localObject2).token() != 4) {
        break;
      }
      paramDefaultJSONParser = ((JSONLexer)localObject2).bytesValue();
      ((JSONLexer)localObject2).nextToken(16);
    }
    if ((paramType instanceof GenericArrayType))
    {
      paramType = ((GenericArrayType)paramType).getGenericComponentType();
      if ((paramType instanceof TypeVariable))
      {
        localObject1 = (TypeVariable)paramType;
        paramType = paramDefaultJSONParser.getContext().getType();
        if ((paramType instanceof ParameterizedType))
        {
          localObject2 = (ParameterizedType)paramType;
          paramType = ((ParameterizedType)localObject2).getRawType();
          if (!(paramType instanceof Class)) {
            break label266;
          }
          TypeVariable[] arrayOfTypeVariable = ((Class)paramType).getTypeParameters();
          paramType = null;
          for (int i = 0; i < arrayOfTypeVariable.length; i++) {
            if (arrayOfTypeVariable[i].getName().equals(((TypeVariable)localObject1).getName())) {
              paramType = localObject2.getActualTypeArguments()[i];
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((paramType instanceof Class)) {
        paramType = (Class)paramType;
      }
      for (;;)
      {
        localObject1 = new JSONArray();
        paramDefaultJSONParser.parseArray(paramType, (Collection)localObject1, paramObject);
        paramDefaultJSONParser = toObjectArray(paramDefaultJSONParser, paramType, (JSONArray)localObject1);
        break;
        paramType = Object.class;
        continue;
        paramType = Object.class;
        continue;
        paramType = (Class)paramType;
        continue;
        paramType = ((Class)paramType).getComponentType();
      }
      label266:
      paramType = null;
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */