package com.alibaba.fastjson;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray
  extends JSON
  implements JSONAware, Serializable, Cloneable, List<Object>, RandomAccess
{
  private static final long serialVersionUID = 1L;
  protected transient Type componentType;
  private final List<Object> list;
  protected transient Object relatedArray;
  
  public JSONArray()
  {
    this.list = new ArrayList(10);
  }
  
  public JSONArray(int paramInt)
  {
    this.list = new ArrayList(paramInt);
  }
  
  public JSONArray(List<Object> paramList)
  {
    this.list = paramList;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    this.list.add(paramInt, paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    return this.list.add(paramObject);
  }
  
  public boolean addAll(int paramInt, Collection<? extends Object> paramCollection)
  {
    return this.list.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(Collection<? extends Object> paramCollection)
  {
    return this.list.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.list.clear();
  }
  
  public Object clone()
  {
    return new JSONArray(new ArrayList(this.list));
  }
  
  public boolean contains(Object paramObject)
  {
    return this.list.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.list.containsAll(paramCollection);
  }
  
  public boolean equals(Object paramObject)
  {
    return this.list.equals(paramObject);
  }
  
  public Object get(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public BigDecimal getBigDecimal(int paramInt)
  {
    return TypeUtils.castToBigDecimal(get(paramInt));
  }
  
  public BigInteger getBigInteger(int paramInt)
  {
    return TypeUtils.castToBigInteger(get(paramInt));
  }
  
  public Boolean getBoolean(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (localObject = null;; localObject = TypeUtils.castToBoolean(localObject)) {
      return (Boolean)localObject;
    }
  }
  
  public boolean getBooleanValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (boolean bool = false;; bool = TypeUtils.castToBoolean(localObject).booleanValue()) {
      return bool;
    }
  }
  
  public Byte getByte(int paramInt)
  {
    return TypeUtils.castToByte(get(paramInt));
  }
  
  public byte getByteValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (byte b = 0;; b = TypeUtils.castToByte(localObject).byteValue()) {
      return b;
    }
  }
  
  public Type getComponentType()
  {
    return this.componentType;
  }
  
  public java.util.Date getDate(int paramInt)
  {
    return TypeUtils.castToDate(get(paramInt));
  }
  
  public Double getDouble(int paramInt)
  {
    return TypeUtils.castToDouble(get(paramInt));
  }
  
  public double getDoubleValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (double d = 0.0D;; d = TypeUtils.castToDouble(localObject).doubleValue()) {
      return d;
    }
  }
  
  public Float getFloat(int paramInt)
  {
    return TypeUtils.castToFloat(get(paramInt));
  }
  
  public float getFloatValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (float f = 0.0F;; f = TypeUtils.castToFloat(localObject).floatValue()) {
      return f;
    }
  }
  
  public int getIntValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (paramInt = 0;; paramInt = TypeUtils.castToInt(localObject).intValue()) {
      return paramInt;
    }
  }
  
  public Integer getInteger(int paramInt)
  {
    return TypeUtils.castToInt(get(paramInt));
  }
  
  public JSONArray getJSONArray(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof JSONArray)) {}
    for (localObject = (JSONArray)localObject;; localObject = (JSONArray)toJSON(localObject)) {
      return (JSONArray)localObject;
    }
  }
  
  public JSONObject getJSONObject(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof JSONObject)) {}
    for (localObject = (JSONObject)localObject;; localObject = (JSONObject)toJSON(localObject)) {
      return (JSONObject)localObject;
    }
  }
  
  public Long getLong(int paramInt)
  {
    return TypeUtils.castToLong(get(paramInt));
  }
  
  public long getLongValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (long l = 0L;; l = TypeUtils.castToLong(localObject).longValue()) {
      return l;
    }
  }
  
  public <T> T getObject(int paramInt, Class<T> paramClass)
  {
    return (T)TypeUtils.castToJavaBean(this.list.get(paramInt), paramClass);
  }
  
  public Object getRelatedArray()
  {
    return this.relatedArray;
  }
  
  public Short getShort(int paramInt)
  {
    return TypeUtils.castToShort(get(paramInt));
  }
  
  public short getShortValue(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {}
    for (short s = 0;; s = TypeUtils.castToShort(localObject).shortValue()) {
      return s;
    }
  }
  
  public java.sql.Date getSqlDate(int paramInt)
  {
    return TypeUtils.castToSqlDate(get(paramInt));
  }
  
  public String getString(int paramInt)
  {
    return TypeUtils.castToString(get(paramInt));
  }
  
  public Timestamp getTimestamp(int paramInt)
  {
    return TypeUtils.castToTimestamp(get(paramInt));
  }
  
  public int hashCode()
  {
    return this.list.hashCode();
  }
  
  public int indexOf(Object paramObject)
  {
    return this.list.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.list.isEmpty();
  }
  
  public Iterator<Object> iterator()
  {
    return this.list.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return this.list.lastIndexOf(paramObject);
  }
  
  public ListIterator<Object> listIterator()
  {
    return this.list.listIterator();
  }
  
  public ListIterator<Object> listIterator(int paramInt)
  {
    return this.list.listIterator(paramInt);
  }
  
  public Object remove(int paramInt)
  {
    return this.list.remove(paramInt);
  }
  
  public boolean remove(Object paramObject)
  {
    return this.list.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.list.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.list.retainAll(paramCollection);
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    return this.list.set(paramInt, paramObject);
  }
  
  public void setComponentType(Type paramType)
  {
    this.componentType = paramType;
  }
  
  public void setRelatedArray(Object paramObject)
  {
    this.relatedArray = paramObject;
  }
  
  public int size()
  {
    return this.list.size();
  }
  
  public List<Object> subList(int paramInt1, int paramInt2)
  {
    return this.list.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return this.list.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.list.toArray(paramArrayOfT);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSONArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */