package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionDeserializer
  implements ObjectDeserializer
{
  public static final CollectionDeserializer instance = new CollectionDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    Object localObject;
    if (paramDefaultJSONParser.getLexer().token() == 8)
    {
      paramDefaultJSONParser.getLexer().nextToken(16);
      localObject = null;
      return (T)localObject;
    }
    Class localClass = getRawClass(paramType);
    if (localClass == AbstractCollection.class)
    {
      localObject = new ArrayList();
      label54:
      if (!(paramType instanceof ParameterizedType)) {
        break label264;
      }
    }
    label264:
    for (paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];; paramType = Object.class)
    {
      paramDefaultJSONParser.parseArray(paramType, (Collection)localObject, paramObject);
      break;
      if (localClass.isAssignableFrom(HashSet.class))
      {
        localObject = new HashSet();
        break label54;
      }
      if (localClass.isAssignableFrom(LinkedHashSet.class))
      {
        localObject = new LinkedHashSet();
        break label54;
      }
      if (localClass.isAssignableFrom(TreeSet.class))
      {
        localObject = new TreeSet();
        break label54;
      }
      if (localClass.isAssignableFrom(ArrayList.class))
      {
        localObject = new ArrayList();
        break label54;
      }
      if (localClass.isAssignableFrom(EnumSet.class))
      {
        if ((paramType instanceof ParameterizedType)) {}
        for (localObject = ((ParameterizedType)paramType).getActualTypeArguments()[0];; localObject = Object.class)
        {
          localObject = EnumSet.noneOf((Class)localObject);
          break;
        }
      }
      try
      {
        localObject = (Collection)localClass.newInstance();
      }
      catch (Exception paramDefaultJSONParser)
      {
        throw new JSONException("create instane error, class " + localClass.getName());
      }
    }
  }
  
  public int getFastMatchToken()
  {
    return 14;
  }
  
  public Class<?> getRawClass(Type paramType)
  {
    if ((paramType instanceof Class)) {}
    for (paramType = (Class)paramType;; paramType = getRawClass(((ParameterizedType)paramType).getRawType()))
    {
      return paramType;
      if (!(paramType instanceof ParameterizedType)) {
        break;
      }
    }
    throw new JSONException("TODO");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/CollectionDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */