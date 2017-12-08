package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ASMException;
import com.alibaba.fastjson.parser.deserializer.ASMDeserializerFactory;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer.InnerJavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ArrayListTypeFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.AutowiredObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.BooleanFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.CharArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.ClassDerializer;
import com.alibaba.fastjson.parser.deserializer.CollectionDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateDeserializer;
import com.alibaba.fastjson.parser.deserializer.DateFormatDeserializer;
import com.alibaba.fastjson.parser.deserializer.DefaultFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.IntegerFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONArrayDeserializer;
import com.alibaba.fastjson.parser.deserializer.JSONObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.LongFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.StringFieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimestampDeserializer;
import com.alibaba.fastjson.serializer.AtomicIntegerArrayCodec;
import com.alibaba.fastjson.serializer.AtomicLongArrayCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CharsetCodec;
import com.alibaba.fastjson.serializer.ColorCodec;
import com.alibaba.fastjson.serializer.CurrencyCodec;
import com.alibaba.fastjson.serializer.FileCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.FontCodec;
import com.alibaba.fastjson.serializer.InetAddressCodec;
import com.alibaba.fastjson.serializer.InetSocketAddressCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LocaleCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.PatternCodec;
import com.alibaba.fastjson.serializer.PointCodec;
import com.alibaba.fastjson.serializer.RectangleCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.serializer.TimeZoneCodec;
import com.alibaba.fastjson.serializer.URICodec;
import com.alibaba.fastjson.serializer.URLCodec;
import com.alibaba.fastjson.serializer.UUIDCodec;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class ParserConfig
{
  private static ParserConfig global = new ParserConfig();
  private boolean asmEnable;
  private final IdentityHashMap<Type, ObjectDeserializer> derializers = new IdentityHashMap();
  private final Set<Class<?>> primitiveClasses = new HashSet();
  protected final SymbolTable symbolTable;
  
  public ParserConfig()
  {
    boolean bool;
    if (!ASMUtils.isAndroid()) {
      bool = true;
    }
    for (;;)
    {
      this.asmEnable = bool;
      this.symbolTable = new SymbolTable();
      this.primitiveClasses.add(Boolean.TYPE);
      this.primitiveClasses.add(Boolean.class);
      this.primitiveClasses.add(Character.TYPE);
      this.primitiveClasses.add(Character.class);
      this.primitiveClasses.add(Byte.TYPE);
      this.primitiveClasses.add(Byte.class);
      this.primitiveClasses.add(Short.TYPE);
      this.primitiveClasses.add(Short.class);
      this.primitiveClasses.add(Integer.TYPE);
      this.primitiveClasses.add(Integer.class);
      this.primitiveClasses.add(Long.TYPE);
      this.primitiveClasses.add(Long.class);
      this.primitiveClasses.add(Float.TYPE);
      this.primitiveClasses.add(Float.class);
      this.primitiveClasses.add(Double.TYPE);
      this.primitiveClasses.add(Double.class);
      this.primitiveClasses.add(BigInteger.class);
      this.primitiveClasses.add(BigDecimal.class);
      this.primitiveClasses.add(String.class);
      this.primitiveClasses.add(java.util.Date.class);
      this.primitiveClasses.add(java.sql.Date.class);
      this.primitiveClasses.add(Time.class);
      this.primitiveClasses.add(Timestamp.class);
      this.derializers.put(SimpleDateFormat.class, DateFormatDeserializer.instance);
      this.derializers.put(Timestamp.class, TimestampDeserializer.instance);
      this.derializers.put(java.sql.Date.class, SqlDateDeserializer.instance);
      this.derializers.put(Time.class, TimeDeserializer.instance);
      this.derializers.put(java.util.Date.class, DateDeserializer.instance);
      this.derializers.put(Calendar.class, CalendarCodec.instance);
      this.derializers.put(JSONObject.class, JSONObjectDeserializer.instance);
      this.derializers.put(JSONArray.class, JSONArrayDeserializer.instance);
      this.derializers.put(Map.class, MapDeserializer.instance);
      this.derializers.put(HashMap.class, MapDeserializer.instance);
      this.derializers.put(LinkedHashMap.class, MapDeserializer.instance);
      this.derializers.put(TreeMap.class, MapDeserializer.instance);
      this.derializers.put(ConcurrentMap.class, MapDeserializer.instance);
      this.derializers.put(ConcurrentHashMap.class, MapDeserializer.instance);
      this.derializers.put(Collection.class, CollectionDeserializer.instance);
      this.derializers.put(List.class, CollectionDeserializer.instance);
      this.derializers.put(ArrayList.class, CollectionDeserializer.instance);
      this.derializers.put(Object.class, JavaObjectDeserializer.instance);
      this.derializers.put(String.class, StringCodec.instance);
      this.derializers.put(Character.TYPE, CharacterCodec.instance);
      this.derializers.put(Character.class, CharacterCodec.instance);
      this.derializers.put(Byte.TYPE, NumberDeserializer.instance);
      this.derializers.put(Byte.class, NumberDeserializer.instance);
      this.derializers.put(Short.TYPE, NumberDeserializer.instance);
      this.derializers.put(Short.class, NumberDeserializer.instance);
      this.derializers.put(Integer.TYPE, IntegerCodec.instance);
      this.derializers.put(Integer.class, IntegerCodec.instance);
      this.derializers.put(Long.TYPE, LongCodec.instance);
      this.derializers.put(Long.class, LongCodec.instance);
      this.derializers.put(BigInteger.class, BigIntegerCodec.instance);
      this.derializers.put(BigDecimal.class, BigDecimalCodec.instance);
      this.derializers.put(Float.TYPE, FloatCodec.instance);
      this.derializers.put(Float.class, FloatCodec.instance);
      this.derializers.put(Double.TYPE, NumberDeserializer.instance);
      this.derializers.put(Double.class, NumberDeserializer.instance);
      this.derializers.put(Boolean.TYPE, BooleanCodec.instance);
      this.derializers.put(Boolean.class, BooleanCodec.instance);
      this.derializers.put(Class.class, ClassDerializer.instance);
      this.derializers.put(char[].class, CharArrayDeserializer.instance);
      this.derializers.put(AtomicBoolean.class, BooleanCodec.instance);
      this.derializers.put(AtomicInteger.class, IntegerCodec.instance);
      this.derializers.put(AtomicLong.class, LongCodec.instance);
      this.derializers.put(AtomicReference.class, ReferenceCodec.instance);
      this.derializers.put(WeakReference.class, ReferenceCodec.instance);
      this.derializers.put(SoftReference.class, ReferenceCodec.instance);
      this.derializers.put(UUID.class, UUIDCodec.instance);
      this.derializers.put(TimeZone.class, TimeZoneCodec.instance);
      this.derializers.put(Locale.class, LocaleCodec.instance);
      this.derializers.put(Currency.class, CurrencyCodec.instance);
      this.derializers.put(InetAddress.class, InetAddressCodec.instance);
      this.derializers.put(Inet4Address.class, InetAddressCodec.instance);
      this.derializers.put(Inet6Address.class, InetAddressCodec.instance);
      this.derializers.put(InetSocketAddress.class, InetSocketAddressCodec.instance);
      this.derializers.put(File.class, FileCodec.instance);
      this.derializers.put(URI.class, URICodec.instance);
      this.derializers.put(URL.class, URLCodec.instance);
      this.derializers.put(Pattern.class, PatternCodec.instance);
      this.derializers.put(Charset.class, CharsetCodec.instance);
      this.derializers.put(Number.class, NumberDeserializer.instance);
      this.derializers.put(AtomicIntegerArray.class, AtomicIntegerArrayCodec.instance);
      this.derializers.put(AtomicLongArray.class, AtomicLongArrayCodec.instance);
      this.derializers.put(StackTraceElement.class, StackTraceElementDeserializer.instance);
      this.derializers.put(Serializable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Cloneable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Comparable.class, JavaObjectDeserializer.instance);
      this.derializers.put(Closeable.class, JavaObjectDeserializer.instance);
      try
      {
        this.derializers.put(Class.forName("java.awt.Point"), PointCodec.instance);
        this.derializers.put(Class.forName("java.awt.Font"), FontCodec.instance);
        this.derializers.put(Class.forName("java.awt.Rectangle"), RectangleCodec.instance);
        this.derializers.put(Class.forName("java.awt.Color"), ColorCodec.instance);
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public static Field getField(Class<?> paramClass, String paramString)
  {
    Object localObject2 = getField0(paramClass, paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getField0(paramClass, "_" + paramString);
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getField0(paramClass, "m_" + paramString);
    }
    return (Field)localObject2;
  }
  
  private static Field getField0(Class<?> paramClass, String paramString)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      if (paramString.equals(localField.getName())) {
        paramClass = localField;
      }
    }
    for (;;)
    {
      return paramClass;
      i++;
      break;
      if ((paramClass.getSuperclass() != null) && (paramClass.getSuperclass() != Object.class)) {
        paramClass = getField(paramClass.getSuperclass(), paramString);
      } else {
        paramClass = null;
      }
    }
  }
  
  public static ParserConfig getGlobalInstance()
  {
    return global;
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    boolean bool2 = false;
    boolean bool1 = this.asmEnable;
    Object localObject;
    if (bool1)
    {
      localObject = paramClass;
      if (!Modifier.isPublic(((Class)localObject).getModifiers()))
      {
        bool1 = false;
        label31:
        if (paramFieldInfo.getFieldClass() == Class.class) {
          bool1 = false;
        }
        if (!ASMDeserializerFactory.getInstance().isExternalClass(paramClass)) {
          break label128;
        }
        bool1 = bool2;
      }
    }
    label128:
    for (;;)
    {
      if (!bool1) {
        paramParserConfig = createFieldDeserializerWithoutASM(paramParserConfig, paramClass, paramFieldInfo);
      }
      for (;;)
      {
        return paramParserConfig;
        Class localClass = ((Class)localObject).getSuperclass();
        if (localClass != Object.class)
        {
          localObject = localClass;
          if (localClass != null) {
            break;
          }
        }
        break label31;
        try
        {
          localObject = ASMDeserializerFactory.getInstance().createFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
          paramParserConfig = (ParserConfig)localObject;
        }
        catch (Throwable localThrowable)
        {
          paramParserConfig = createFieldDeserializerWithoutASM(paramParserConfig, paramClass, paramFieldInfo);
        }
      }
    }
  }
  
  public FieldDeserializer createFieldDeserializerWithoutASM(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.getFieldClass();
    if ((localClass == Boolean.TYPE) || (localClass == Boolean.class)) {
      paramParserConfig = new BooleanFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
    }
    for (;;)
    {
      return paramParserConfig;
      if ((localClass == Integer.TYPE) || (localClass == Integer.class)) {
        paramParserConfig = new IntegerFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
      } else if ((localClass == Long.TYPE) || (localClass == Long.class)) {
        paramParserConfig = new LongFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
      } else if (localClass == String.class) {
        paramParserConfig = new StringFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
      } else if ((localClass == List.class) || (localClass == ArrayList.class)) {
        paramParserConfig = new ArrayListTypeFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
      } else {
        paramParserConfig = new DefaultFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);
      }
    }
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(Class<?> paramClass, Type paramType)
  {
    boolean bool3 = false;
    boolean bool2 = this.asmEnable;
    Object localObject1;
    label31:
    boolean bool1;
    Object localObject2;
    if (bool2)
    {
      localObject1 = paramClass;
      if (!Modifier.isPublic(((Class)localObject1).getModifiers()))
      {
        bool2 = false;
        if (paramClass.getTypeParameters().length != 0) {
          bool2 = false;
        }
        if (ASMDeserializerFactory.getInstance().isExternalClass(paramClass)) {
          bool2 = false;
        }
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (paramClass.isInterface()) {
            bool1 = false;
          }
          localObject1 = DeserializeBeanInfo.computeSetters(paramClass, paramType);
          if (((DeserializeBeanInfo)localObject1).getFieldList().size() > 200) {
            bool1 = false;
          }
          bool2 = bool1;
          if (((DeserializeBeanInfo)localObject1).getDefaultConstructor() == null)
          {
            bool2 = bool1;
            if (!paramClass.isInterface()) {
              bool2 = false;
            }
          }
          localObject1 = ((DeserializeBeanInfo)localObject1).getFieldList().iterator();
          bool1 = bool2;
          if (!((Iterator)localObject1).hasNext()) {
            break label370;
          }
          localObject2 = (FieldInfo)((Iterator)localObject1).next();
          if (!((FieldInfo)localObject2).isGetOnly()) {
            break label238;
          }
          bool1 = false;
        }
      }
    }
    label195:
    label238:
    label367:
    label370:
    for (;;)
    {
      if ((bool1) && (paramClass.isMemberClass()) && (!Modifier.isStatic(paramClass.getModifiers())))
      {
        bool1 = bool3;
        if (!bool1)
        {
          paramClass = new JavaBeanDeserializer(this, paramClass, paramType);
          return paramClass;
          localObject2 = ((Class)localObject1).getSuperclass();
          if (localObject2 != Object.class)
          {
            localObject1 = localObject2;
            if (localObject2 != null) {
              break;
            }
          }
          break label31;
          localObject2 = ((FieldInfo)localObject2).getFieldClass();
          if (!Modifier.isPublic(((Class)localObject2).getModifiers()))
          {
            bool1 = false;
            continue;
          }
          if ((!((Class)localObject2).isMemberClass()) || (Modifier.isStatic(((Class)localObject2).getModifiers()))) {
            break label367;
          }
          bool1 = false;
        }
      }
      for (;;)
      {
        break;
        try
        {
          localObject1 = ASMDeserializerFactory.getInstance().createJavaBeanDeserializer(this, paramClass, paramType);
          paramClass = (Class<?>)localObject1;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = new JavaBeanDeserializer(this, paramClass, paramType);
        }
        catch (ASMException localASMException)
        {
          paramClass = new JavaBeanDeserializer(this, paramClass, paramType);
        }
        catch (Exception paramType)
        {
          throw new JSONException("create asm deserializer error, " + paramClass.getName(), paramType);
        }
        break label195;
      }
    }
  }
  
  public IdentityHashMap<Type, ObjectDeserializer> getDerializers()
  {
    return this.derializers;
  }
  
  public ObjectDeserializer getDeserializer(FieldInfo paramFieldInfo)
  {
    return getDeserializer(paramFieldInfo.getFieldClass(), paramFieldInfo.getFieldType());
  }
  
  public ObjectDeserializer getDeserializer(Class<?> paramClass, Type paramType)
  {
    Object localObject1 = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObject1 != null) {
      paramType = (Type)localObject1;
    }
    Object localObject2;
    for (;;)
    {
      return paramType;
      localObject2 = paramType;
      if (paramType == null) {
        localObject2 = paramClass;
      }
      localObject1 = (ObjectDeserializer)this.derializers.get(localObject2);
      paramType = (Type)localObject1;
      if (localObject1 == null)
      {
        paramType = (JSONType)paramClass.getAnnotation(JSONType.class);
        if (paramType != null)
        {
          paramType = paramType.mappingTo();
          if (paramType != Void.class)
          {
            paramType = getDeserializer(paramType, paramType);
            continue;
          }
        }
        if (((localObject2 instanceof WildcardType)) || ((localObject2 instanceof TypeVariable)) || ((localObject2 instanceof ParameterizedType))) {
          localObject1 = (ObjectDeserializer)this.derializers.get(paramClass);
        }
        paramType = (Type)localObject1;
        if (localObject1 == null)
        {
          paramType = Thread.currentThread().getContextClassLoader();
          try
          {
            Iterator localIterator = ServiceLoader.load(AutowiredObjectDeserializer.class, paramType).iterator();
            while (localIterator.hasNext())
            {
              AutowiredObjectDeserializer localAutowiredObjectDeserializer = (AutowiredObjectDeserializer)localIterator.next();
              paramType = localAutowiredObjectDeserializer.getAutowiredFor().iterator();
              while (paramType.hasNext())
              {
                localObject1 = (Type)paramType.next();
                this.derializers.put(localObject1, localAutowiredObjectDeserializer);
              }
            }
            if (localObject1 != null) {}
          }
          catch (Exception paramType)
          {
            localObject1 = (ObjectDeserializer)this.derializers.get(localObject2);
            paramType = (Type)localObject1;
          }
        }
      }
    }
    if (paramClass.isEnum()) {
      paramClass = new EnumDeserializer(paramClass);
    }
    for (;;)
    {
      putDeserializer((Type)localObject2, paramClass);
      paramType = paramClass;
      break;
      if (paramClass.isArray()) {
        paramClass = ArrayDeserializer.instance;
      } else if ((paramClass == Set.class) || (paramClass == HashSet.class) || (paramClass == Collection.class) || (paramClass == List.class) || (paramClass == ArrayList.class)) {
        paramClass = CollectionDeserializer.instance;
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        paramClass = CollectionDeserializer.instance;
      } else if (Map.class.isAssignableFrom(paramClass)) {
        paramClass = MapDeserializer.instance;
      } else if (Throwable.class.isAssignableFrom(paramClass)) {
        paramClass = new ThrowableDeserializer(this, paramClass);
      } else {
        paramClass = createJavaBeanDeserializer(paramClass, (Type)localObject2);
      }
    }
  }
  
  public ObjectDeserializer getDeserializer(Type paramType)
  {
    Object localObject = (ObjectDeserializer)this.derializers.get(paramType);
    if (localObject != null) {
      paramType = (Type)localObject;
    }
    for (;;)
    {
      return paramType;
      if ((paramType instanceof Class))
      {
        paramType = getDeserializer((Class)paramType, paramType);
      }
      else if ((paramType instanceof ParameterizedType))
      {
        localObject = ((ParameterizedType)paramType).getRawType();
        if ((localObject instanceof Class)) {
          paramType = getDeserializer((Class)localObject, paramType);
        } else {
          paramType = getDeserializer((Type)localObject);
        }
      }
      else
      {
        paramType = JavaObjectDeserializer.instance;
      }
    }
  }
  
  public Map<String, FieldDeserializer> getFieldDeserializers(Class<?> paramClass)
  {
    paramClass = getDeserializer(paramClass);
    if ((paramClass instanceof JavaBeanDeserializer)) {
      paramClass = ((JavaBeanDeserializer)paramClass).getFieldDeserializerMap();
    }
    for (;;)
    {
      return paramClass;
      if ((paramClass instanceof ASMJavaBeanDeserializer)) {
        paramClass = ((ASMJavaBeanDeserializer)paramClass).getInnterSerializer().getFieldDeserializerMap();
      } else {
        paramClass = Collections.emptyMap();
      }
    }
  }
  
  public SymbolTable getSymbolTable()
  {
    return this.symbolTable;
  }
  
  public boolean isAsmEnable()
  {
    return this.asmEnable;
  }
  
  public boolean isPrimitive(Class<?> paramClass)
  {
    return this.primitiveClasses.contains(paramClass);
  }
  
  public void putDeserializer(Type paramType, ObjectDeserializer paramObjectDeserializer)
  {
    this.derializers.put(paramType, paramObjectDeserializer);
  }
  
  public void setAsmEnable(boolean paramBoolean)
  {
    this.asmEnable = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/ParserConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */