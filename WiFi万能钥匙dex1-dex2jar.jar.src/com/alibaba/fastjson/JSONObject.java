package com.alibaba.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JSONObject
  extends JSON
  implements JSONAware, Serializable, Cloneable, InvocationHandler, Map<String, Object>
{
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final long serialVersionUID = 1L;
  private final Map<String, Object> map;
  
  public JSONObject()
  {
    this(16, false);
  }
  
  public JSONObject(int paramInt)
  {
    this(paramInt, false);
  }
  
  public JSONObject(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.map = new LinkedHashMap(paramInt);; this.map = new HashMap(paramInt)) {
      return;
    }
  }
  
  public JSONObject(Map<String, Object> paramMap)
  {
    this.map = paramMap;
  }
  
  public JSONObject(boolean paramBoolean)
  {
    this(16, paramBoolean);
  }
  
  public void clear()
  {
    this.map.clear();
  }
  
  public Object clone()
  {
    return new JSONObject(new HashMap(this.map));
  }
  
  public boolean containsKey(Object paramObject)
  {
    return this.map.containsKey(paramObject);
  }
  
  public boolean containsValue(Object paramObject)
  {
    return this.map.containsValue(paramObject);
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return this.map.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.map.equals(paramObject);
  }
  
  public Object get(Object paramObject)
  {
    return this.map.get(paramObject);
  }
  
  public BigDecimal getBigDecimal(String paramString)
  {
    return TypeUtils.castToBigDecimal(get(paramString));
  }
  
  public BigInteger getBigInteger(String paramString)
  {
    return TypeUtils.castToBigInteger(get(paramString));
  }
  
  public Boolean getBoolean(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = TypeUtils.castToBoolean(paramString)) {
      return paramString;
    }
  }
  
  public boolean getBooleanValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (boolean bool = false;; bool = TypeUtils.castToBoolean(paramString).booleanValue()) {
      return bool;
    }
  }
  
  public Byte getByte(String paramString)
  {
    return TypeUtils.castToByte(get(paramString));
  }
  
  public byte getByteValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (byte b = 0;; b = TypeUtils.castToByte(paramString).byteValue()) {
      return b;
    }
  }
  
  public byte[] getBytes(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = TypeUtils.castToBytes(paramString)) {
      return paramString;
    }
  }
  
  public java.util.Date getDate(String paramString)
  {
    return TypeUtils.castToDate(get(paramString));
  }
  
  public Double getDouble(String paramString)
  {
    return TypeUtils.castToDouble(get(paramString));
  }
  
  public double getDoubleValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (double d = 0.0D;; d = TypeUtils.castToDouble(paramString).doubleValue()) {
      return d;
    }
  }
  
  public Float getFloat(String paramString)
  {
    return TypeUtils.castToFloat(get(paramString));
  }
  
  public float getFloatValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (float f = 0.0F;; f = TypeUtils.castToFloat(paramString).floatValue()) {
      return f;
    }
  }
  
  public int getIntValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (int i = 0;; i = TypeUtils.castToInt(paramString).intValue()) {
      return i;
    }
  }
  
  public Integer getInteger(String paramString)
  {
    return TypeUtils.castToInt(get(paramString));
  }
  
  public JSONArray getJSONArray(String paramString)
  {
    paramString = this.map.get(paramString);
    if ((paramString instanceof JSONArray)) {}
    for (paramString = (JSONArray)paramString;; paramString = (JSONArray)toJSON(paramString)) {
      return paramString;
    }
  }
  
  public JSONObject getJSONObject(String paramString)
  {
    paramString = this.map.get(paramString);
    if ((paramString instanceof JSONObject)) {}
    for (paramString = (JSONObject)paramString;; paramString = (JSONObject)toJSON(paramString)) {
      return paramString;
    }
  }
  
  public Long getLong(String paramString)
  {
    return TypeUtils.castToLong(get(paramString));
  }
  
  public long getLongValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (long l = 0L;; l = TypeUtils.castToLong(paramString).longValue()) {
      return l;
    }
  }
  
  public <T> T getObject(String paramString, Class<T> paramClass)
  {
    return (T)TypeUtils.castToJavaBean(this.map.get(paramString), paramClass);
  }
  
  public Short getShort(String paramString)
  {
    return TypeUtils.castToShort(get(paramString));
  }
  
  public short getShortValue(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (short s = 0;; s = TypeUtils.castToShort(paramString).shortValue()) {
      return s;
    }
  }
  
  public java.sql.Date getSqlDate(String paramString)
  {
    return TypeUtils.castToSqlDate(get(paramString));
  }
  
  public String getString(String paramString)
  {
    paramString = get(paramString);
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.toString()) {
      return paramString;
    }
  }
  
  public Timestamp getTimestamp(String paramString)
  {
    return TypeUtils.castToTimestamp(get(paramString));
  }
  
  public int hashCode()
  {
    return this.map.hashCode();
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getParameterTypes();
    if (paramObject.length == 1)
    {
      if (paramMethod.getReturnType() != Void.TYPE) {
        throw new JSONException("illegal setter");
      }
      paramObject = (JSONField)paramMethod.getAnnotation(JSONField.class);
      if ((paramObject == null) || (((JSONField)paramObject).name().length() == 0)) {
        break label427;
      }
    }
    label332:
    label399:
    label422:
    label427:
    for (paramObject = ((JSONField)paramObject).name();; paramObject = null)
    {
      Object localObject = paramObject;
      if (paramObject == null)
      {
        paramObject = paramMethod.getName();
        if (!((String)paramObject).startsWith("set")) {
          throw new JSONException("illegal setter");
        }
        paramObject = ((String)paramObject).substring(3);
        if (((String)paramObject).length() == 0) {
          throw new JSONException("illegal setter");
        }
        localObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1);
      }
      this.map.put(localObject, paramArrayOfObject[0]);
      paramObject = null;
      return paramObject;
      if (paramObject.length == 0)
      {
        if (paramMethod.getReturnType() == Void.TYPE) {
          throw new JSONException("illegal getter");
        }
        paramObject = (JSONField)paramMethod.getAnnotation(JSONField.class);
        if ((paramObject == null) || (((JSONField)paramObject).name().length() == 0)) {
          break label422;
        }
      }
      for (paramArrayOfObject = ((JSONField)paramObject).name();; paramArrayOfObject = null)
      {
        paramObject = paramArrayOfObject;
        if (paramArrayOfObject == null)
        {
          paramObject = paramMethod.getName();
          if (!((String)paramObject).startsWith("get")) {
            break label332;
          }
          paramObject = ((String)paramObject).substring(3);
          if (((String)paramObject).length() == 0) {
            throw new JSONException("illegal getter");
          }
        }
        for (paramObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1);; paramObject = Character.toLowerCase(((String)paramObject).charAt(0)) + ((String)paramObject).substring(1))
        {
          paramObject = TypeUtils.cast(this.map.get(paramObject), paramMethod.getGenericReturnType(), ParserConfig.getGlobalInstance());
          break;
          if (!((String)paramObject).startsWith("is")) {
            break label399;
          }
          paramObject = ((String)paramObject).substring(2);
          if (((String)paramObject).length() == 0) {
            throw new JSONException("illegal getter");
          }
        }
        throw new JSONException("illegal getter");
        throw new UnsupportedOperationException(paramMethod.toGenericString());
      }
    }
  }
  
  public boolean isEmpty()
  {
    return this.map.isEmpty();
  }
  
  public Set<String> keySet()
  {
    return this.map.keySet();
  }
  
  public Object put(String paramString, Object paramObject)
  {
    return this.map.put(paramString, paramObject);
  }
  
  public void putAll(Map<? extends String, ? extends Object> paramMap)
  {
    this.map.putAll(paramMap);
  }
  
  public Object remove(Object paramObject)
  {
    return this.map.remove(paramObject);
  }
  
  public int size()
  {
    return this.map.size();
  }
  
  public Collection<Object> values()
  {
    return this.map.values();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSONObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */