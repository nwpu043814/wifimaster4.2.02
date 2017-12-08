package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class SerializeConfig
  extends IdentityHashMap<Type, ObjectSerializer>
{
  private static final SerializeConfig globalInstance = new SerializeConfig();
  private boolean asm;
  private final ASMSerializerFactory asmFactory;
  private String typeKey;
  
  public SerializeConfig()
  {
    this(1024);
  }
  
  public SerializeConfig(int paramInt)
  {
    super(paramInt);
    boolean bool;
    if (!ASMUtils.isAndroid()) {
      bool = true;
    }
    for (;;)
    {
      this.asm = bool;
      this.asmFactory = new ASMSerializerFactory();
      this.typeKey = JSON.DEFAULT_TYPE_KEY;
      put(Boolean.class, BooleanCodec.instance);
      put(Character.class, CharacterCodec.instance);
      put(Byte.class, ByteSerializer.instance);
      put(Short.class, ShortSerializer.instance);
      put(Integer.class, IntegerCodec.instance);
      put(Long.class, LongCodec.instance);
      put(Float.class, FloatCodec.instance);
      put(Double.class, DoubleSerializer.instance);
      put(BigDecimal.class, BigDecimalCodec.instance);
      put(BigInteger.class, BigIntegerCodec.instance);
      put(String.class, StringCodec.instance);
      put(byte[].class, ByteArraySerializer.instance);
      put(short[].class, ShortArraySerializer.instance);
      put(int[].class, IntArraySerializer.instance);
      put(long[].class, LongArraySerializer.instance);
      put(float[].class, FloatArraySerializer.instance);
      put(double[].class, DoubleArraySerializer.instance);
      put(boolean[].class, BooleanArraySerializer.instance);
      put(char[].class, CharArraySerializer.instance);
      put(Object[].class, ObjectArraySerializer.instance);
      put(Class.class, ClassSerializer.instance);
      put(SimpleDateFormat.class, DateFormatSerializer.instance);
      put(Locale.class, LocaleCodec.instance);
      put(Currency.class, CurrencyCodec.instance);
      put(TimeZone.class, TimeZoneCodec.instance);
      put(UUID.class, UUIDCodec.instance);
      put(InetAddress.class, InetAddressCodec.instance);
      put(Inet4Address.class, InetAddressCodec.instance);
      put(Inet6Address.class, InetAddressCodec.instance);
      put(InetSocketAddress.class, InetSocketAddressCodec.instance);
      put(File.class, FileCodec.instance);
      put(URI.class, URICodec.instance);
      put(URL.class, URLCodec.instance);
      put(Appendable.class, AppendableSerializer.instance);
      put(StringBuffer.class, AppendableSerializer.instance);
      put(StringBuilder.class, AppendableSerializer.instance);
      put(Pattern.class, PatternCodec.instance);
      put(Charset.class, CharsetCodec.instance);
      put(AtomicBoolean.class, AtomicBooleanSerializer.instance);
      put(AtomicInteger.class, AtomicIntegerSerializer.instance);
      put(AtomicLong.class, AtomicLongSerializer.instance);
      put(AtomicReference.class, ReferenceCodec.instance);
      put(AtomicIntegerArray.class, AtomicIntegerArrayCodec.instance);
      put(AtomicLongArray.class, AtomicLongArrayCodec.instance);
      put(WeakReference.class, ReferenceCodec.instance);
      put(SoftReference.class, ReferenceCodec.instance);
      try
      {
        put(Class.forName("java.awt.Color"), ColorCodec.instance);
        put(Class.forName("java.awt.Font"), FontCodec.instance);
        put(Class.forName("java.awt.Point"), PointCodec.instance);
        put(Class.forName("java.awt.Rectangle"), RectangleCodec.instance);
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        for (;;) {}
      }
    }
  }
  
  public static final SerializeConfig getGlobalInstance()
  {
    return globalInstance;
  }
  
  public final ObjectSerializer createASMSerializer(Class<?> paramClass)
  {
    return this.asmFactory.createJavaBeanSerializer(paramClass);
  }
  
  public ObjectSerializer createJavaBeanSerializer(Class<?> paramClass)
  {
    if (!Modifier.isPublic(paramClass.getModifiers()))
    {
      paramClass = new JavaBeanSerializer(paramClass);
      return paramClass;
    }
    boolean bool1 = this.asm;
    if (((bool1) && (this.asmFactory.isExternalClass(paramClass))) || (paramClass == Serializable.class) || (paramClass == Object.class)) {
      bool1 = false;
    }
    for (;;)
    {
      Object localObject = (JSONType)paramClass.getAnnotation(JSONType.class);
      boolean bool2 = bool1;
      if (localObject != null)
      {
        bool2 = bool1;
        if (!((JSONType)localObject).asm()) {
          bool2 = false;
        }
      }
      if (bool2) {
        try
        {
          localObject = createASMSerializer(paramClass);
          paramClass = (Class<?>)localObject;
        }
        catch (ClassCastException localClassCastException)
        {
          paramClass = new JavaBeanSerializer(paramClass);
        }
        catch (Throwable localThrowable)
        {
          throw new JSONException("create asm serializer error, class " + paramClass, localThrowable);
        }
      }
      paramClass = new JavaBeanSerializer(paramClass);
      break;
    }
  }
  
  public String getTypeKey()
  {
    return this.typeKey;
  }
  
  public boolean isAsmEnable()
  {
    return this.asm;
  }
  
  public void setAsmEnable(boolean paramBoolean)
  {
    this.asm = paramBoolean;
  }
  
  public void setTypeKey(String paramString)
  {
    this.typeKey = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/SerializeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */