package com.alibaba.fastjson.util;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

public class ASMUtils
{
  public static String getDesc(Class<?> paramClass)
  {
    if (paramClass.isPrimitive()) {
      paramClass = getPrimitiveLetter(paramClass);
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isArray()) {
        paramClass = "[" + getDesc(paramClass.getComponentType());
      } else {
        paramClass = "L" + getType(paramClass) + ";";
      }
    }
  }
  
  public static String getDesc(Method paramMethod)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("(");
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    for (int i = 0; i < arrayOfClass.length; i++) {
      localStringBuffer.append(getDesc(arrayOfClass[i]));
    }
    localStringBuffer.append(")");
    localStringBuffer.append(getDesc(paramMethod.getReturnType()));
    return localStringBuffer.toString();
  }
  
  public static Type getFieldType(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getField(paramString).getGenericType();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  public static Type getMethodType(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, new Class[0]).getGenericReturnType();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  public static String getPrimitiveLetter(Class<?> paramClass)
  {
    if (Integer.TYPE.equals(paramClass)) {
      paramClass = "I";
    }
    for (;;)
    {
      return paramClass;
      if (Void.TYPE.equals(paramClass))
      {
        paramClass = "V";
      }
      else if (Boolean.TYPE.equals(paramClass))
      {
        paramClass = "Z";
      }
      else if (Character.TYPE.equals(paramClass))
      {
        paramClass = "C";
      }
      else if (Byte.TYPE.equals(paramClass))
      {
        paramClass = "B";
      }
      else if (Short.TYPE.equals(paramClass))
      {
        paramClass = "S";
      }
      else if (Float.TYPE.equals(paramClass))
      {
        paramClass = "F";
      }
      else if (Long.TYPE.equals(paramClass))
      {
        paramClass = "J";
      }
      else
      {
        if (!Double.TYPE.equals(paramClass)) {
          break;
        }
        paramClass = "D";
      }
    }
    throw new IllegalStateException("Type: " + paramClass.getCanonicalName() + " is not a primitive type");
  }
  
  public static String getType(Class<?> paramClass)
  {
    if (paramClass.isArray()) {
      paramClass = "[" + getDesc(paramClass.getComponentType());
    }
    for (;;)
    {
      return paramClass;
      if (!paramClass.isPrimitive()) {
        paramClass = paramClass.getName().replaceAll("\\.", "/");
      } else {
        paramClass = getPrimitiveLetter(paramClass);
      }
    }
  }
  
  public static boolean isAndroid()
  {
    return isAndroid(System.getProperty("java.vm.name"));
  }
  
  public static boolean isAndroid(String paramString)
  {
    paramString = paramString.toLowerCase();
    if ((paramString.contains("dalvik")) || (paramString.contains("lemur"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void parseArray(Collection paramCollection, ObjectDeserializer paramObjectDeserializer, DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramObject = paramDefaultJSONParser.getLexer();
    if (((JSONLexer)paramObject).token() == 8) {
      ((JSONLexer)paramObject).nextToken(16);
    }
    paramDefaultJSONParser.accept(14, 14);
    int i = 0;
    for (;;)
    {
      paramCollection.add(paramObjectDeserializer.deserialze(paramDefaultJSONParser, paramType, Integer.valueOf(i)));
      i++;
      if (((JSONLexer)paramObject).token() != 16) {
        break;
      }
      ((JSONLexer)paramObject).nextToken(14);
    }
    paramDefaultJSONParser.accept(15, 16);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/ASMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */