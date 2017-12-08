package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

public class FilterUtils
{
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, byte paramByte)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Byte.valueOf(paramByte))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, char paramChar)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Character.valueOf(paramChar))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, double paramDouble)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Double.valueOf(paramDouble))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, float paramFloat)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Float.valueOf(paramFloat))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, int paramInt)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Integer.valueOf(paramInt))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, long paramLong)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Long.valueOf(paramLong))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      paramJSONSerializer = paramJSONSerializer.iterator();
      for (;;)
      {
        if (paramJSONSerializer.hasNext()) {
          if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject1, paramString, paramObject2))
          {
            bool = false;
            break;
          }
        }
      }
      bool = true;
    }
  }
  
  public static boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, short paramShort)
  {
    paramJSONSerializer = paramJSONSerializer.getPropertyFiltersDirect();
    boolean bool;
    if (paramJSONSerializer != null)
    {
      paramJSONSerializer = paramJSONSerializer.iterator();
      while (paramJSONSerializer.hasNext()) {
        if (!((PropertyFilter)paramJSONSerializer.next()).apply(paramObject, paramString, Short.valueOf(paramShort))) {
          bool = false;
        }
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = true;
    }
  }
  
  public static boolean applyName(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    Object localObject = paramJSONSerializer.getPropertyPreFiltersDirect();
    boolean bool;
    if (localObject == null) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if (!((PropertyPreFilter)((Iterator)localObject).next()).apply(paramJSONSerializer, paramObject, paramString))
          {
            bool = false;
            break;
          }
        }
      }
      bool = true;
    }
  }
  
  public static Type getExtratype(DefaultJSONParser paramDefaultJSONParser, Object paramObject, String paramString)
  {
    Object localObject = null;
    Iterator localIterator = null;
    paramDefaultJSONParser = paramDefaultJSONParser.getExtraTypeProvidersDirect();
    if (paramDefaultJSONParser == null) {
      paramDefaultJSONParser = localIterator;
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      localIterator = paramDefaultJSONParser.iterator();
      for (paramDefaultJSONParser = (DefaultJSONParser)localObject; localIterator.hasNext(); paramDefaultJSONParser = ((ExtraTypeProvider)localIterator.next()).getExtraType(paramObject, paramString)) {}
    }
  }
  
  public static void processExtra(DefaultJSONParser paramDefaultJSONParser, Object paramObject1, String paramString, Object paramObject2)
  {
    paramDefaultJSONParser = paramDefaultJSONParser.getExtraProcessorsDirect();
    if (paramDefaultJSONParser == null) {}
    for (;;)
    {
      return;
      paramDefaultJSONParser = paramDefaultJSONParser.iterator();
      while (paramDefaultJSONParser.hasNext()) {
        ((ExtraProcessor)paramDefaultJSONParser.next()).processExtra(paramObject1, paramString, paramObject2);
      }
    }
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, byte paramByte)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Byte.valueOf(paramByte));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, char paramChar)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Character.valueOf(paramChar));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, double paramDouble)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Double.valueOf(paramDouble));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, float paramFloat)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Float.valueOf(paramFloat));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, int paramInt)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Integer.valueOf(paramInt));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, long paramLong)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Long.valueOf(paramLong));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject1, paramString, paramObject2);
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, short paramShort)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Short.valueOf(paramShort));
      }
    }
    return paramJSONSerializer;
  }
  
  public static String processKey(JSONSerializer paramJSONSerializer, Object paramObject, String paramString, boolean paramBoolean)
  {
    Object localObject = paramJSONSerializer.getNameFiltersDirect();
    paramJSONSerializer = paramString;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = paramString;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = ((NameFilter)((Iterator)localObject).next()).process(paramObject, paramString, Boolean.valueOf(paramBoolean));
      }
    }
    return paramJSONSerializer;
  }
  
  public static Object processValue(JSONSerializer paramJSONSerializer, Object paramObject1, String paramString, Object paramObject2)
  {
    Object localObject = paramJSONSerializer.getValueFiltersDirect();
    paramJSONSerializer = (JSONSerializer)paramObject2;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        paramJSONSerializer = (JSONSerializer)paramObject2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramObject2 = ((ValueFilter)((Iterator)localObject).next()).process(paramObject1, paramString, paramObject2);
      }
    }
    return paramJSONSerializer;
  }
  
  public static char writeAfter(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    Object localObject = paramJSONSerializer.getAfterFiltersDirect();
    char c = paramChar;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        c = paramChar;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramChar = ((AfterFilter)((Iterator)localObject).next()).writeAfter(paramJSONSerializer, paramObject, paramChar);
      }
    }
    return c;
  }
  
  public static char writeBefore(JSONSerializer paramJSONSerializer, Object paramObject, char paramChar)
  {
    Object localObject = paramJSONSerializer.getBeforeFiltersDirect();
    char c = paramChar;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        c = paramChar;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramChar = ((BeforeFilter)((Iterator)localObject).next()).writeBefore(paramJSONSerializer, paramObject, paramChar);
      }
    }
    return c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/FilterUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */