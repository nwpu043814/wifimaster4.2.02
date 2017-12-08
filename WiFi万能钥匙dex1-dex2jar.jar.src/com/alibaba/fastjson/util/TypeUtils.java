package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import java.beans.Introspector;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TypeUtils
{
  public static boolean compatibleWithJavaBean = false;
  private static ConcurrentMap<String, Class<?>> mappings;
  
  static
  {
    try
    {
      String str = System.getProperty("fastjson.compatibleWithJavaBean");
      if ("true".equals(str)) {
        compatibleWithJavaBean = true;
      }
      for (;;)
      {
        mappings = new ConcurrentHashMap();
        addBaseClassMappings();
        return;
        if ("false".equals(str)) {
          compatibleWithJavaBean = false;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public static void addBaseClassMappings()
  {
    mappings.put("byte", Byte.TYPE);
    mappings.put("short", Short.TYPE);
    mappings.put("int", Integer.TYPE);
    mappings.put("long", Long.TYPE);
    mappings.put("float", Float.TYPE);
    mappings.put("double", Double.TYPE);
    mappings.put("boolean", Boolean.TYPE);
    mappings.put("char", Character.TYPE);
    mappings.put("[byte", byte[].class);
    mappings.put("[short", short[].class);
    mappings.put("[int", int[].class);
    mappings.put("[long", long[].class);
    mappings.put("[float", float[].class);
    mappings.put("[double", double[].class);
    mappings.put("[boolean", boolean[].class);
    mappings.put("[char", char[].class);
    mappings.put(HashMap.class.getName(), HashMap.class);
  }
  
  public static void addClassMapping(String paramString, Class<?> paramClass)
  {
    String str = paramString;
    if (paramString == null) {
      str = paramClass.getName();
    }
    mappings.put(str, paramClass);
  }
  
  public static final <T> T cast(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    Object localObject;
    if (paramObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return (T)localObject;
      if (paramClass == null) {
        throw new IllegalArgumentException("clazz is null");
      }
      localObject = paramObject;
      if (paramClass != paramObject.getClass()) {
        if ((paramObject instanceof Map))
        {
          localObject = paramObject;
          if (paramClass != Map.class)
          {
            Map localMap = (Map)paramObject;
            if (paramClass == Object.class)
            {
              localObject = paramObject;
              if (!localMap.containsKey(JSON.DEFAULT_TYPE_KEY)) {}
            }
            else
            {
              localObject = castToJavaBean((Map)paramObject, paramClass, paramParserConfig);
            }
          }
        }
        else if ((paramClass.isArray()) && ((paramObject instanceof Collection)))
        {
          paramObject = (Collection)paramObject;
          int i = 0;
          localObject = Array.newInstance(paramClass.getComponentType(), ((Collection)paramObject).size());
          paramObject = ((Collection)paramObject).iterator();
          while (((Iterator)paramObject).hasNext())
          {
            Array.set(localObject, i, cast(((Iterator)paramObject).next(), paramClass.getComponentType(), paramParserConfig));
            i++;
          }
        }
        else
        {
          localObject = paramObject;
          if (!paramClass.isAssignableFrom(paramObject.getClass())) {
            if ((paramClass == Boolean.TYPE) || (paramClass == Boolean.class))
            {
              localObject = castToBoolean(paramObject);
            }
            else if ((paramClass == Byte.TYPE) || (paramClass == Byte.class))
            {
              localObject = castToByte(paramObject);
            }
            else if ((paramClass == Short.TYPE) || (paramClass == Short.class))
            {
              localObject = castToShort(paramObject);
            }
            else if ((paramClass == Integer.TYPE) || (paramClass == Integer.class))
            {
              localObject = castToInt(paramObject);
            }
            else if ((paramClass == Long.TYPE) || (paramClass == Long.class))
            {
              localObject = castToLong(paramObject);
            }
            else if ((paramClass == Float.TYPE) || (paramClass == Float.class))
            {
              localObject = castToFloat(paramObject);
            }
            else if ((paramClass == Double.TYPE) || (paramClass == Double.class))
            {
              localObject = castToDouble(paramObject);
            }
            else if (paramClass == String.class)
            {
              localObject = castToString(paramObject);
            }
            else if (paramClass == BigDecimal.class)
            {
              localObject = castToBigDecimal(paramObject);
            }
            else if (paramClass == BigInteger.class)
            {
              localObject = castToBigInteger(paramObject);
            }
            else if (paramClass == java.util.Date.class)
            {
              localObject = castToDate(paramObject);
            }
            else if (paramClass == java.sql.Date.class)
            {
              localObject = castToSqlDate(paramObject);
            }
            else if (paramClass == Timestamp.class)
            {
              localObject = castToTimestamp(paramObject);
            }
            else if (paramClass.isEnum())
            {
              localObject = castToEnum(paramObject, paramClass, paramParserConfig);
            }
            else
            {
              if (Calendar.class.isAssignableFrom(paramClass))
              {
                paramParserConfig = castToDate(paramObject);
                if (paramClass == Calendar.class) {
                  paramObject = Calendar.getInstance();
                }
                for (;;)
                {
                  ((Calendar)paramObject).setTime(paramParserConfig);
                  localObject = paramObject;
                  break;
                  try
                  {
                    paramObject = (Calendar)paramClass.newInstance();
                  }
                  catch (Exception paramObject)
                  {
                    throw new JSONException("can not cast to : " + paramClass.getName(), (Throwable)paramObject);
                  }
                }
              }
              if ((!(paramObject instanceof String)) || (((String)paramObject).length() != 0)) {
                break;
              }
              localObject = null;
            }
          }
        }
      }
    }
    throw new JSONException("can not cast to : " + paramClass.getName());
  }
  
  public static final <T> T cast(Object paramObject, ParameterizedType paramParameterizedType, ParserConfig paramParserConfig)
  {
    Object localObject2 = paramParameterizedType.getRawType();
    Type localType;
    Object localObject1;
    if ((localObject2 == List.class) || (localObject2 == ArrayList.class))
    {
      localType = paramParameterizedType.getActualTypeArguments()[0];
      if ((paramObject instanceof Iterable))
      {
        paramParameterizedType = new ArrayList();
        localObject1 = ((Iterable)paramObject).iterator();
        for (;;)
        {
          paramObject = paramParameterizedType;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          paramParameterizedType.add(cast(((Iterator)localObject1).next(), localType, paramParserConfig));
        }
      }
    }
    if ((localObject2 == Map.class) || (localObject2 == HashMap.class))
    {
      localObject1 = paramParameterizedType.getActualTypeArguments()[0];
      localType = paramParameterizedType.getActualTypeArguments()[1];
      if ((paramObject instanceof Map))
      {
        paramParameterizedType = new HashMap();
        paramObject = ((Map)paramObject).entrySet().iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)paramObject).next();
          paramParameterizedType.put(cast(((Map.Entry)localObject2).getKey(), (Type)localObject1, paramParserConfig), cast(((Map.Entry)localObject2).getValue(), localType, paramParserConfig));
        }
        paramObject = paramParameterizedType;
      }
    }
    for (;;)
    {
      return (T)paramObject;
      if (((paramObject instanceof String)) && (((String)paramObject).length() == 0))
      {
        paramObject = null;
      }
      else
      {
        if ((paramParameterizedType.getActualTypeArguments().length != 1) || (!(paramParameterizedType.getActualTypeArguments()[0] instanceof WildcardType))) {
          break;
        }
        paramObject = cast(paramObject, (Type)localObject2, paramParserConfig);
      }
    }
    throw new JSONException("can not cast to : " + paramParameterizedType);
  }
  
  public static final <T> T cast(Object paramObject, Type paramType, ParserConfig paramParserConfig)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    do
    {
      for (;;)
      {
        return (T)paramObject;
        if ((paramType instanceof Class))
        {
          paramObject = cast(paramObject, (Class)paramType, paramParserConfig);
        }
        else if ((paramType instanceof ParameterizedType))
        {
          paramObject = cast(paramObject, (ParameterizedType)paramType, paramParserConfig);
        }
        else
        {
          if ((!(paramObject instanceof String)) || (((String)paramObject).length() != 0)) {
            break;
          }
          paramObject = null;
        }
      }
    } while ((paramType instanceof TypeVariable));
    throw new JSONException("can not cast to : " + paramType);
  }
  
  public static final BigDecimal castToBigDecimal(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (BigDecimal)paramObject;
      if ((paramObject instanceof BigDecimal))
      {
        paramObject = (BigDecimal)paramObject;
      }
      else if ((paramObject instanceof BigInteger))
      {
        paramObject = new BigDecimal((BigInteger)paramObject);
      }
      else
      {
        paramObject = paramObject.toString();
        if (((String)paramObject).length() == 0) {
          paramObject = null;
        } else {
          paramObject = new BigDecimal((String)paramObject);
        }
      }
    }
  }
  
  public static final BigInteger castToBigInteger(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (BigInteger)paramObject;
      if ((paramObject instanceof BigInteger))
      {
        paramObject = (BigInteger)paramObject;
      }
      else if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
      {
        paramObject = BigInteger.valueOf(((Number)paramObject).longValue());
      }
      else
      {
        paramObject = paramObject.toString();
        if (((String)paramObject).length() == 0) {
          paramObject = null;
        } else {
          paramObject = new BigInteger((String)paramObject);
        }
      }
    }
  }
  
  public static final Boolean castToBoolean(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (Boolean)paramObject;
      if ((paramObject instanceof Boolean))
      {
        paramObject = (Boolean)paramObject;
      }
      else
      {
        if ((paramObject instanceof Number))
        {
          if (((Number)paramObject).intValue() == 1) {}
          for (;;)
          {
            paramObject = Boolean.valueOf(bool);
            break;
            bool = false;
          }
        }
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = (String)paramObject;
        if (str.length() == 0)
        {
          paramObject = null;
        }
        else if ("true".equals(str))
        {
          paramObject = Boolean.TRUE;
        }
        else if ("false".equals(str))
        {
          paramObject = Boolean.FALSE;
        }
        else
        {
          if (!"1".equals(str)) {
            break;
          }
          paramObject = Boolean.TRUE;
        }
      }
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Byte castToByte(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      paramObject = localObject;
    }
    for (;;)
    {
      return (Byte)paramObject;
      if ((paramObject instanceof Number))
      {
        paramObject = Byte.valueOf(((Number)paramObject).byteValue());
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = (String)paramObject;
        paramObject = localObject;
        if (str.length() != 0) {
          paramObject = Byte.valueOf(Byte.parseByte(str));
        }
      }
    }
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final byte[] castToBytes(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {}
    for (paramObject = (byte[])paramObject;; paramObject = Base64.decodeFast((String)paramObject))
    {
      return (byte[])paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final Character castToChar(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (Character)paramObject;
      if ((paramObject instanceof Character))
      {
        paramObject = (Character)paramObject;
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = (String)paramObject;
        if (str.length() == 0)
        {
          paramObject = null;
        }
        else
        {
          if (str.length() != 1) {
            throw new JSONException("can not cast to byte, value : " + paramObject);
          }
          paramObject = Character.valueOf(str.charAt(0));
        }
      }
    }
    throw new JSONException("can not cast to byte, value : " + paramObject);
  }
  
  public static final java.util.Date castToDate(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (java.util.Date)paramObject;
      if ((paramObject instanceof Calendar))
      {
        paramObject = ((Calendar)paramObject).getTime();
      }
      else if ((paramObject instanceof java.util.Date))
      {
        paramObject = (java.util.Date)paramObject;
      }
      else
      {
        long l = -1L;
        if ((paramObject instanceof Number)) {
          l = ((Number)paramObject).longValue();
        }
        if ((paramObject instanceof String))
        {
          String str = (String)paramObject;
          if (str.indexOf('-') != -1)
          {
            if (str.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
              paramObject = JSON.DEFFAULT_DATE_FORMAT;
            }
            for (;;)
            {
              paramObject = new SimpleDateFormat((String)paramObject);
              try
              {
                paramObject = ((SimpleDateFormat)paramObject).parse(str);
              }
              catch (ParseException paramObject)
              {
                throw new JSONException("can not cast to Date, value : " + str);
              }
              if (str.length() == 10) {
                paramObject = "yyyy-MM-dd";
              } else if (str.length() == 19) {
                paramObject = "yyyy-MM-dd HH:mm:ss";
              } else {
                paramObject = "yyyy-MM-dd HH:mm:ss.SSS";
              }
            }
          }
          if (str.length() == 0) {
            paramObject = null;
          } else {
            l = Long.parseLong(str);
          }
        }
        else
        {
          if (l < 0L) {
            throw new JSONException("can not cast to Date, value : " + paramObject);
          }
          paramObject = new java.util.Date(l);
        }
      }
    }
  }
  
  public static final Double castToDouble(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      paramObject = localObject;
    }
    for (;;)
    {
      return (Double)paramObject;
      if ((paramObject instanceof Number))
      {
        paramObject = Double.valueOf(((Number)paramObject).doubleValue());
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = paramObject.toString();
        paramObject = localObject;
        if (str.length() != 0) {
          paramObject = Double.valueOf(Double.parseDouble(str));
        }
      }
    }
    throw new JSONException("can not cast to double, value : " + paramObject);
  }
  
  public static final <T> T castToEnum(Object paramObject, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    paramParserConfig = null;
    int i = 0;
    try
    {
      if ((paramObject instanceof String))
      {
        paramObject = (String)paramObject;
        if (((String)paramObject).length() == 0) {}
        for (paramObject = paramParserConfig;; paramObject = Enum.valueOf(paramClass, (String)paramObject)) {
          return (T)paramObject;
        }
      }
      if ((paramObject instanceof Number))
      {
        int j = ((Number)paramObject).intValue();
        paramParserConfig = (Object[])paramClass.getMethod("values", new Class[0]).invoke(null, new Object[0]);
        int k = paramParserConfig.length;
        for (;;)
        {
          if (i >= k) {
            break label141;
          }
          paramObject = (Enum)paramParserConfig[i];
          int m = ((Enum)paramObject).ordinal();
          if (m == j) {
            break;
          }
          i++;
        }
      }
      throw new JSONException("can not cast to : " + paramClass.getName());
    }
    catch (Exception paramObject)
    {
      throw new JSONException("can not cast to : " + paramClass.getName(), (Throwable)paramObject);
    }
  }
  
  public static final Float castToFloat(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      paramObject = localObject;
    }
    for (;;)
    {
      return (Float)paramObject;
      if ((paramObject instanceof Number))
      {
        paramObject = Float.valueOf(((Number)paramObject).floatValue());
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = paramObject.toString();
        paramObject = localObject;
        if (str.length() != 0) {
          paramObject = Float.valueOf(Float.parseFloat(str));
        }
      }
    }
    throw new JSONException("can not cast to float, value : " + paramObject);
  }
  
  public static final Integer castToInt(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (Integer)paramObject;
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
      }
      else if ((paramObject instanceof Number))
      {
        paramObject = Integer.valueOf(((Number)paramObject).intValue());
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        paramObject = (String)paramObject;
        if (((String)paramObject).length() == 0) {
          paramObject = null;
        } else {
          paramObject = Integer.valueOf(Integer.parseInt((String)paramObject));
        }
      }
    }
    throw new JSONException("can not cast to int, value : " + paramObject);
  }
  
  public static final <T> T castToJavaBean(Object paramObject, Class<T> paramClass)
  {
    return (T)cast(paramObject, paramClass, ParserConfig.getGlobalInstance());
  }
  
  public static final <T> T castToJavaBean(Map<String, Object> paramMap, Class<T> paramClass, ParserConfig paramParserConfig)
  {
    int i = 0;
    if (paramClass == StackTraceElement.class) {}
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        paramClass = (String)paramMap.get("className");
        paramParserConfig = (String)paramMap.get("methodName");
        localObject1 = (String)paramMap.get("fileName");
        paramMap = (Number)paramMap.get("lineNumber");
        if (paramMap == null)
        {
          paramMap = new StackTraceElement(paramClass, paramParserConfig, (String)localObject1, i);
          return paramMap;
        }
        i = paramMap.intValue();
        continue;
        localObject1 = paramMap.get(JSON.DEFAULT_TYPE_KEY);
        if (!(localObject1 instanceof String)) {
          break label194;
        }
        localObject1 = (String)localObject1;
        localObject2 = loadClass((String)localObject1);
        if (localObject2 == null)
        {
          paramClass = new java/lang/ClassNotFoundException;
          paramMap = new java/lang/StringBuilder;
          paramMap.<init>();
          paramClass.<init>((String)localObject1 + " not found");
          throw paramClass;
        }
      }
      catch (Exception paramMap)
      {
        throw new JSONException(paramMap.getMessage(), paramMap);
      }
      if (!localObject2.equals(paramClass))
      {
        paramMap = castToJavaBean(paramMap, (Class)localObject2, paramParserConfig);
      }
      else
      {
        label194:
        if (paramClass.isInterface())
        {
          if ((paramMap instanceof JSONObject)) {}
          for (paramMap = (JSONObject)paramMap;; paramMap = new JSONObject(paramMap))
          {
            paramMap = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { paramClass }, paramMap);
            break;
          }
        }
        localObject1 = paramParserConfig;
        if (paramParserConfig == null) {
          localObject1 = ParserConfig.getGlobalInstance();
        }
        paramParserConfig = ((ParserConfig)localObject1).getFieldDeserializers(paramClass);
        paramClass = paramClass.getDeclaredConstructor(new Class[0]);
        if (!paramClass.isAccessible()) {
          paramClass.setAccessible(true);
        }
        paramClass = paramClass.newInstance(new Object[0]);
        paramParserConfig = paramParserConfig.entrySet().iterator();
        while (paramParserConfig.hasNext())
        {
          Object localObject3 = (Map.Entry)paramParserConfig.next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          localObject3 = (FieldDeserializer)((Map.Entry)localObject3).getValue();
          if (paramMap.containsKey(localObject2))
          {
            localObject2 = paramMap.get(localObject2);
            Method localMethod = ((FieldDeserializer)localObject3).getMethod();
            if (localMethod != null)
            {
              localMethod.invoke(paramClass, new Object[] { cast(localObject2, localMethod.getGenericParameterTypes()[0], (ParserConfig)localObject1) });
            }
            else
            {
              localObject3 = ((FieldDeserializer)localObject3).getField();
              ((Field)localObject3).set(paramClass, cast(localObject2, ((Field)localObject3).getGenericType(), (ParserConfig)localObject1));
            }
          }
        }
        paramMap = paramClass;
      }
    }
  }
  
  public static final Long castToLong(Object paramObject)
  {
    Long localLong = null;
    if (paramObject == null) {}
    Object localObject2;
    for (;;)
    {
      return localLong;
      if ((paramObject instanceof Number))
      {
        localLong = Long.valueOf(((Number)paramObject).longValue());
      }
      else if ((paramObject instanceof String))
      {
        localObject2 = (String)paramObject;
        if (((String)localObject2).length() == 0) {
          continue;
        }
        try
        {
          long l = Long.parseLong((String)localObject2);
          localLong = Long.valueOf(l);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject2 = new JSONScanner((String)localObject2);
          if (!((JSONScanner)localObject2).scanISO8601DateIfMatch(false)) {}
        }
      }
    }
    for (Object localObject1 = ((JSONScanner)localObject2).getCalendar();; localObject1 = null)
    {
      ((JSONScanner)localObject2).close();
      if (localObject1 != null)
      {
        localObject1 = Long.valueOf(((Calendar)localObject1).getTimeInMillis());
        break;
      }
      throw new JSONException("can not cast to long, value : " + paramObject);
    }
  }
  
  public static final Short castToShort(Object paramObject)
  {
    Object localObject = null;
    if (paramObject == null) {
      paramObject = localObject;
    }
    for (;;)
    {
      return (Short)paramObject;
      if ((paramObject instanceof Number))
      {
        paramObject = Short.valueOf(((Number)paramObject).shortValue());
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        String str = (String)paramObject;
        paramObject = localObject;
        if (str.length() != 0) {
          paramObject = Short.valueOf(Short.parseShort(str));
        }
      }
    }
    throw new JSONException("can not cast to short, value : " + paramObject);
  }
  
  public static final java.sql.Date castToSqlDate(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (java.sql.Date)paramObject;
      if ((paramObject instanceof Calendar))
      {
        paramObject = new java.sql.Date(((Calendar)paramObject).getTimeInMillis());
      }
      else if ((paramObject instanceof java.sql.Date))
      {
        paramObject = (java.sql.Date)paramObject;
      }
      else
      {
        if (!(paramObject instanceof java.util.Date)) {
          break;
        }
        paramObject = new java.sql.Date(((java.util.Date)paramObject).getTime());
      }
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.length() == 0)
        {
          paramObject = null;
          break;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new JSONException("can not cast to Date, value : " + paramObject);
      }
      paramObject = new java.sql.Date(l);
      break;
    }
  }
  
  public static final String castToString(Object paramObject)
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = paramObject.toString()) {
      return (String)paramObject;
    }
  }
  
  public static final Timestamp castToTimestamp(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return (Timestamp)paramObject;
      if ((paramObject instanceof Calendar))
      {
        paramObject = new Timestamp(((Calendar)paramObject).getTimeInMillis());
      }
      else if ((paramObject instanceof Timestamp))
      {
        paramObject = (Timestamp)paramObject;
      }
      else
      {
        if (!(paramObject instanceof java.util.Date)) {
          break;
        }
        paramObject = new Timestamp(((java.util.Date)paramObject).getTime());
      }
    }
    if ((paramObject instanceof Number)) {}
    for (long l = ((Number)paramObject).longValue();; l = 0L)
    {
      if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.length() == 0)
        {
          paramObject = null;
          break;
        }
        l = Long.parseLong(str);
      }
      if (l <= 0L) {
        throw new JSONException("can not cast to Date, value : " + paramObject);
      }
      paramObject = new Timestamp(l);
      break;
    }
  }
  
  public static void clearClassMapping()
  {
    mappings.clear();
    addBaseClassMappings();
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap)
  {
    return computeGetters(paramClass, paramMap, true);
  }
  
  public static List<FieldInfo> computeGetters(Class<?> paramClass, Map<String, String> paramMap, boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Method[] arrayOfMethod = paramClass.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Method localMethod;
    Object localObject4;
    Object localObject2;
    Object localObject1;
    label241:
    char c;
    label303:
    Object localObject3;
    if (i < j)
    {
      localMethod = arrayOfMethod[i];
      localObject4 = localMethod.getName();
      if ((!Modifier.isStatic(localMethod.getModifiers())) && (!localMethod.getReturnType().equals(Void.TYPE)) && (localMethod.getParameterTypes().length == 0) && (localMethod.getReturnType() != ClassLoader.class) && ((!localMethod.getName().equals("getMetaClass")) || (!localMethod.getReturnType().getName().equals("groovy.lang.MetaClass"))))
      {
        localObject2 = (JSONField)localMethod.getAnnotation(JSONField.class);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getSupperMethodAnnotation(paramClass, localMethod);
        }
        if (localObject1 == null) {
          break label241;
        }
        if (((JSONField)localObject1).serialize())
        {
          if (((JSONField)localObject1).name().length() == 0) {
            break label241;
          }
          localObject2 = ((JSONField)localObject1).name();
          localObject1 = localObject2;
          if (paramMap != null)
          {
            localObject1 = (String)paramMap.get(localObject2);
            if (localObject1 == null) {}
          }
          else
          {
            localLinkedHashMap.put(localObject1, new FieldInfo((String)localObject1, localMethod, null));
          }
        }
      }
      do
      {
        JSONField localJSONField;
        do
        {
          do
          {
            i++;
            break;
            if (!((String)localObject4).startsWith("get")) {
              break label462;
            }
          } while ((((String)localObject4).length() < 4) || (((String)localObject4).equals("getClass")));
          c = ((String)localObject4).charAt(3);
          if (!Character.isUpperCase(c)) {
            break label715;
          }
          if (!compatibleWithJavaBean) {
            break label679;
          }
          localObject1 = Introspector.decapitalize(((String)localObject4).substring(3));
          if (isJSONTypeIgnore(paramClass, (String)localObject1)) {
            break label747;
          }
          localObject3 = ParserConfig.getField(paramClass, (String)localObject1);
          localObject2 = localObject1;
          if (localObject3 == null) {
            break label1188;
          }
          localJSONField = (JSONField)((Field)localObject3).getAnnotation(JSONField.class);
          localObject2 = localObject1;
          if (localJSONField == null) {
            break label1188;
          }
        } while (!localJSONField.serialize());
        localObject2 = localObject1;
        if (localJSONField.name().length() == 0) {
          break label1188;
        }
        localObject1 = localJSONField.name();
        localObject2 = localObject1;
        if (paramMap == null) {
          break label1188;
        }
        localObject1 = (String)paramMap.get(localObject1);
      } while (localObject1 == null);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (paramMap != null)
      {
        localObject2 = (String)paramMap.get(localObject1);
        if (localObject2 == null) {
          break;
        }
      }
      localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, localMethod, (Field)localObject3));
      label462:
      if ((!((String)localObject4).startsWith("is")) || (((String)localObject4).length() < 3)) {
        break;
      }
      c = ((String)localObject4).charAt(2);
      if (Character.isUpperCase(c)) {
        if (compatibleWithJavaBean)
        {
          localObject1 = Introspector.decapitalize(((String)localObject4).substring(2));
          label513:
          localObject3 = ParserConfig.getField(paramClass, (String)localObject1);
          if (localObject3 != null) {
            break label1185;
          }
          localObject3 = ParserConfig.getField(paramClass, (String)localObject4);
        }
      }
      label679:
      label715:
      label747:
      label1110:
      label1175:
      label1185:
      for (;;)
      {
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject4 = (JSONField)((Field)localObject3).getAnnotation(JSONField.class);
          localObject2 = localObject1;
          if (localObject4 != null)
          {
            if (!((JSONField)localObject4).serialize()) {
              break;
            }
            localObject2 = localObject1;
            if (((JSONField)localObject4).name().length() != 0)
            {
              localObject1 = ((JSONField)localObject4).name();
              localObject2 = localObject1;
              if (paramMap != null)
              {
                localObject1 = (String)paramMap.get(localObject1);
                if (localObject1 == null) {
                  break;
                }
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (paramMap != null)
          {
            localObject2 = (String)paramMap.get(localObject1);
            if (localObject2 == null) {
              break;
            }
          }
          localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, localMethod, (Field)localObject3));
          break;
          localObject1 = Character.toLowerCase(((String)localObject4).charAt(3)) + ((String)localObject4).substring(4);
          break label303;
          if (c == '_')
          {
            localObject1 = ((String)localObject4).substring(4);
            break label303;
          }
          if (c != 'f') {
            break;
          }
          localObject1 = ((String)localObject4).substring(3);
          break label303;
          break;
          localObject1 = Character.toLowerCase(((String)localObject4).charAt(2)) + ((String)localObject4).substring(3);
          break label513;
          if (c == '_')
          {
            localObject1 = ((String)localObject4).substring(3);
            break label513;
          }
          if (c != 'f') {
            break;
          }
          localObject1 = ((String)localObject4).substring(2);
          break label513;
          localObject3 = paramClass.getFields();
          j = localObject3.length;
          i = 0;
          if (i < j)
          {
            arrayOfMethod = localObject3[i];
            if (!Modifier.isStatic(arrayOfMethod.getModifiers()))
            {
              localObject2 = (JSONField)arrayOfMethod.getAnnotation(JSONField.class);
              localObject1 = arrayOfMethod.getName();
              if (localObject2 == null) {
                break label1175;
              }
              if (((JSONField)localObject2).serialize())
              {
                if (((JSONField)localObject2).name().length() == 0) {
                  break label1175;
                }
                localObject1 = ((JSONField)localObject2).name();
              }
            }
          }
          for (;;)
          {
            localObject2 = localObject1;
            if (paramMap != null)
            {
              localObject2 = (String)paramMap.get(localObject1);
              if (localObject2 == null) {}
            }
            else if (!localLinkedHashMap.containsKey(localObject2))
            {
              localLinkedHashMap.put(localObject2, new FieldInfo((String)localObject2, null, arrayOfMethod));
            }
            i++;
            break;
            paramMap = new ArrayList();
            paramClass = (JSONType)paramClass.getAnnotation(JSONType.class);
            if (paramClass != null)
            {
              paramClass = paramClass.orders();
              if ((paramClass != null) && (paramClass.length == localLinkedHashMap.size()))
              {
                j = paramClass.length;
                for (i = 0; i < j; i++) {
                  if (!localLinkedHashMap.containsKey(paramClass[i])) {
                    break label1110;
                  }
                }
                i = 1;
              }
            }
            for (;;)
            {
              if (i != 0)
              {
                j = paramClass.length;
                for (i = 0; i < j; i++) {
                  paramMap.add((FieldInfo)localLinkedHashMap.get(paramClass[i]));
                }
                i = 0;
              }
              else
              {
                paramClass = localLinkedHashMap.values().iterator();
                while (paramClass.hasNext()) {
                  paramMap.add((FieldInfo)paramClass.next());
                }
                if (paramBoolean) {
                  Collections.sort(paramMap);
                }
                return paramMap;
                i = 0;
                paramClass = null;
              }
            }
          }
          localObject1 = localObject2;
        }
      }
      label1188:
      localObject1 = localObject2;
    }
  }
  
  public static Class<?> getClass(Type paramType)
  {
    if (paramType.getClass() == Class.class) {}
    for (paramType = (Class)paramType;; paramType = Object.class)
    {
      return paramType;
      if ((paramType instanceof ParameterizedType))
      {
        paramType = ((ParameterizedType)paramType).getRawType();
        break;
      }
    }
  }
  
  public static JSONField getSupperMethodAnnotation(Class<?> paramClass, Method paramMethod)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int m = arrayOfClass.length;
    int i = 0;
    int j;
    if (i < m)
    {
      Method[] arrayOfMethod = arrayOfClass[i].getMethods();
      int n = arrayOfMethod.length;
      j = 0;
      label35:
      if (j < n)
      {
        paramClass = arrayOfMethod[j];
        if ((paramClass.getName().equals(paramMethod.getName())) && (paramClass.getParameterTypes().length == paramMethod.getParameterTypes().length))
        {
          k = 0;
          label76:
          if (k >= paramClass.getParameterTypes().length) {
            break label154;
          }
          if (paramClass.getParameterTypes()[k].equals(paramMethod.getParameterTypes()[k])) {}
        }
      }
    }
    label154:
    for (int k = 0;; k = 1)
    {
      if (k != 0)
      {
        paramClass = (JSONField)paramClass.getAnnotation(JSONField.class);
        if (paramClass == null) {}
      }
      for (;;)
      {
        return paramClass;
        k++;
        break label76;
        j++;
        break label35;
        i++;
        break;
        paramClass = null;
      }
    }
  }
  
  private static boolean isJSONTypeIgnore(Class<?> paramClass, String paramString)
  {
    Object localObject = (JSONType)paramClass.getAnnotation(JSONType.class);
    int i;
    boolean bool;
    if ((localObject != null) && (((JSONType)localObject).ignores() != null))
    {
      localObject = ((JSONType)localObject).ignores();
      int j = localObject.length;
      i = 0;
      if (i < j) {
        if (paramString.equalsIgnoreCase(localObject[i])) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      return bool;
      i++;
      break;
      if ((paramClass.getSuperclass() != Object.class) && (paramClass.getSuperclass() != null) && (isJSONTypeIgnore(paramClass.getSuperclass(), paramString))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public static Class<?> loadClass(String paramString)
  {
    String str = paramString;
    if ((str == null) || (str.length() == 0)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      Class localClass1 = (Class)mappings.get(str);
      paramString = localClass1;
      if (localClass1 == null) {
        if (str.charAt(0) == '[')
        {
          paramString = Array.newInstance(loadClass(str.substring(1)), 0).getClass();
        }
        else
        {
          if ((str.startsWith("L")) && (str.endsWith(";")))
          {
            str = str.substring(1, str.length() - 1);
            break;
          }
          paramString = localClass1;
          try
          {
            ClassLoader localClassLoader = Thread.currentThread().getContextClassLoader();
            paramString = localClass1;
            if (localClassLoader != null)
            {
              paramString = localClass1;
              localClass1 = localClassLoader.loadClass(str);
              paramString = localClass1;
              addClassMapping(str, localClass1);
              paramString = localClass1;
            }
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              Class localClass2 = Class.forName(str);
              paramString = localClass2;
              addClassMapping(str, localClass2);
              paramString = localClass2;
            }
            catch (Throwable localThrowable2) {}
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/TypeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */