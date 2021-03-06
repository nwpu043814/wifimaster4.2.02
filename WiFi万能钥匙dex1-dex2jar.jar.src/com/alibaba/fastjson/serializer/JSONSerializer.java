package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.util.ServiceLoader;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

public class JSONSerializer
{
  private List<AfterFilter> afterFilters = null;
  private List<BeforeFilter> beforeFilters = null;
  private final SerializeConfig config;
  private SerialContext context;
  private DateFormat dateFormat;
  private String dateFormatPattern;
  private String indent = "\t";
  private int indentCount = 0;
  private List<NameFilter> nameFilters = null;
  private final SerializeWriter out;
  private List<PropertyFilter> propertyFilters = null;
  private List<PropertyPreFilter> propertyPreFilters = null;
  private IdentityHashMap<Object, SerialContext> references = null;
  private List<ValueFilter> valueFilters = null;
  
  public JSONSerializer()
  {
    this(new SerializeWriter(), SerializeConfig.getGlobalInstance());
  }
  
  @Deprecated
  public JSONSerializer(JSONSerializerMap paramJSONSerializerMap)
  {
    this(new SerializeWriter(), paramJSONSerializerMap);
  }
  
  public JSONSerializer(SerializeConfig paramSerializeConfig)
  {
    this(new SerializeWriter(), paramSerializeConfig);
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter)
  {
    this(paramSerializeWriter, SerializeConfig.getGlobalInstance());
  }
  
  public JSONSerializer(SerializeWriter paramSerializeWriter, SerializeConfig paramSerializeConfig)
  {
    this.out = paramSerializeWriter;
    this.config = paramSerializeConfig;
  }
  
  public static final void write(SerializeWriter paramSerializeWriter, Object paramObject)
  {
    new JSONSerializer(paramSerializeWriter).write(paramObject);
  }
  
  public static final void write(Writer paramWriter, Object paramObject)
  {
    SerializeWriter localSerializeWriter = new SerializeWriter();
    try
    {
      JSONSerializer localJSONSerializer = new com/alibaba/fastjson/serializer/JSONSerializer;
      localJSONSerializer.<init>(localSerializeWriter);
      localJSONSerializer.write(paramObject);
      localSerializeWriter.writeTo(paramWriter);
      return;
    }
    catch (IOException paramWriter)
    {
      paramObject = new com/alibaba/fastjson/JSONException;
      ((JSONException)paramObject).<init>(paramWriter.getMessage(), paramWriter);
      throw ((Throwable)paramObject);
    }
    finally
    {
      localSerializeWriter.close();
    }
  }
  
  public void close()
  {
    this.out.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.out.config(paramSerializerFeature, paramBoolean);
  }
  
  public boolean containsReference(Object paramObject)
  {
    if (this.references == null) {}
    for (boolean bool = false;; bool = this.references.containsKey(paramObject)) {
      return bool;
    }
  }
  
  public void decrementIdent()
  {
    this.indentCount -= 1;
  }
  
  public List<AfterFilter> getAfterFilters()
  {
    if (this.afterFilters == null) {
      this.afterFilters = new ArrayList();
    }
    return this.afterFilters;
  }
  
  public List<AfterFilter> getAfterFiltersDirect()
  {
    return this.afterFilters;
  }
  
  public List<BeforeFilter> getBeforeFilters()
  {
    if (this.beforeFilters == null) {
      this.beforeFilters = new ArrayList();
    }
    return this.beforeFilters;
  }
  
  public List<BeforeFilter> getBeforeFiltersDirect()
  {
    return this.beforeFilters;
  }
  
  public SerialContext getContext()
  {
    return this.context;
  }
  
  public DateFormat getDateFormat()
  {
    if ((this.dateFormat == null) && (this.dateFormatPattern != null)) {
      this.dateFormat = new SimpleDateFormat(this.dateFormatPattern);
    }
    return this.dateFormat;
  }
  
  public String getDateFormatPattern()
  {
    if ((this.dateFormat instanceof SimpleDateFormat)) {}
    for (String str = ((SimpleDateFormat)this.dateFormat).toPattern();; str = this.dateFormatPattern) {
      return str;
    }
  }
  
  public int getIndentCount()
  {
    return this.indentCount;
  }
  
  public SerializeConfig getMapping()
  {
    return this.config;
  }
  
  public List<NameFilter> getNameFilters()
  {
    if (this.nameFilters == null) {
      this.nameFilters = new ArrayList();
    }
    return this.nameFilters;
  }
  
  public List<NameFilter> getNameFiltersDirect()
  {
    return this.nameFilters;
  }
  
  public ObjectSerializer getObjectWriter(Class<?> paramClass)
  {
    int j = 0;
    Object localObject1 = (ObjectSerializer)this.config.get(paramClass);
    Object localObject3 = localObject1;
    Object localObject4;
    Object localObject5;
    if (localObject1 == null) {
      try
      {
        localObject1 = ServiceLoader.load(AutowiredObjectSerializer.class, Thread.currentThread().getContextClassLoader()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = ((Iterator)localObject1).next();
          if ((localObject3 instanceof AutowiredObjectSerializer))
          {
            localObject4 = (AutowiredObjectSerializer)localObject3;
            localObject3 = ((AutowiredObjectSerializer)localObject4).getAutowiredFor().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject5 = (Type)((Iterator)localObject3).next();
              this.config.put(localObject5, localObject4);
            }
          }
        }
        localObject2 = localObject3;
      }
      catch (ClassCastException localClassCastException1)
      {
        localObject3 = (ObjectSerializer)this.config.get(paramClass);
      }
    }
    Object localObject2;
    ObjectSerializer localObjectSerializer;
    if (localObject3 == null)
    {
      localObject4 = JSON.class.getClassLoader();
      localObject2 = localObject3;
      if (localObject4 != Thread.currentThread().getContextClassLoader()) {
        try
        {
          localObject2 = ServiceLoader.load(AutowiredObjectSerializer.class, (ClassLoader)localObject4).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if ((localObject3 instanceof AutowiredObjectSerializer))
            {
              localObject5 = (AutowiredObjectSerializer)localObject3;
              localObject3 = ((AutowiredObjectSerializer)localObject5).getAutowiredFor().iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (Type)((Iterator)localObject3).next();
                this.config.put(localObject4, localObject5);
              }
            }
          }
          localObject3 = localObjectSerializer;
        }
        catch (ClassCastException localClassCastException2)
        {
          localObjectSerializer = (ObjectSerializer)this.config.get(paramClass);
        }
      }
    }
    if (localObjectSerializer == null)
    {
      if (!Map.class.isAssignableFrom(paramClass)) {
        break label333;
      }
      this.config.put(paramClass, MapSerializer.instance);
    }
    for (;;)
    {
      localObject3 = (ObjectSerializer)this.config.get(paramClass);
      label330:
      return (ObjectSerializer)localObject3;
      label333:
      if (List.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, ListSerializer.instance);
      }
      else if (Collection.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, CollectionSerializer.instance);
      }
      else if (Date.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, DateSerializer.instance);
      }
      else if (JSONAware.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, JSONAwareSerializer.instance);
      }
      else if (JSONStreamAware.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, JSONStreamAwareSerializer.instance);
      }
      else if ((paramClass.isEnum()) || ((paramClass.getSuperclass() != null) && (paramClass.getSuperclass().isEnum())))
      {
        this.config.put(paramClass, EnumSerializer.instance);
      }
      else if (paramClass.isArray())
      {
        localObject3 = paramClass.getComponentType();
        localObjectSerializer = getObjectWriter((Class)localObject3);
        this.config.put(paramClass, new ArraySerializer((Class)localObject3, localObjectSerializer));
      }
      else if (Throwable.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, new ExceptionSerializer(paramClass));
      }
      else if (TimeZone.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, TimeZoneCodec.instance);
      }
      else if (Appendable.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, AppendableSerializer.instance);
      }
      else if (Charset.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, CharsetCodec.instance);
      }
      else if (Enumeration.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, EnumerationSeriliazer.instance);
      }
      else if (Calendar.class.isAssignableFrom(paramClass))
      {
        this.config.put(paramClass, CalendarCodec.instance);
      }
      else
      {
        if (!Clob.class.isAssignableFrom(paramClass)) {
          break;
        }
        this.config.put(paramClass, ClobSeriliazer.instance);
      }
    }
    localObject3 = paramClass.getInterfaces();
    int k = localObject3.length;
    int i = 0;
    label729:
    if (i < k)
    {
      localObjectSerializer = localObject3[i];
      if (localObjectSerializer.getName().equals("net.sf.cglib.proxy.Factory")) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        localObject3 = getObjectWriter(paramClass.getSuperclass());
        this.config.put(paramClass, localObject3);
        break label330;
        if (localObjectSerializer.getName().equals("javassist.util.proxy.ProxyObject"))
        {
          i = 0;
          j = 1;
          continue;
        }
        i++;
        break label729;
      }
      if (Proxy.isProxyClass(paramClass))
      {
        this.config.put(paramClass, this.config.createJavaBeanSerializer(paramClass));
        break;
      }
      this.config.put(paramClass, this.config.createJavaBeanSerializer(paramClass));
      break;
      i = 0;
    }
  }
  
  public List<PropertyFilter> getPropertyFilters()
  {
    if (this.propertyFilters == null) {
      this.propertyFilters = new ArrayList();
    }
    return this.propertyFilters;
  }
  
  public List<PropertyFilter> getPropertyFiltersDirect()
  {
    return this.propertyFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFilters()
  {
    if (this.propertyPreFilters == null) {
      this.propertyPreFilters = new ArrayList();
    }
    return this.propertyPreFilters;
  }
  
  public List<PropertyPreFilter> getPropertyPreFiltersDirect()
  {
    return this.propertyPreFilters;
  }
  
  public SerialContext getSerialContext(Object paramObject)
  {
    if (this.references == null) {}
    for (paramObject = null;; paramObject = (SerialContext)this.references.get(paramObject)) {
      return (SerialContext)paramObject;
    }
  }
  
  public List<ValueFilter> getValueFilters()
  {
    if (this.valueFilters == null) {
      this.valueFilters = new ArrayList();
    }
    return this.valueFilters;
  }
  
  public List<ValueFilter> getValueFiltersDirect()
  {
    return this.valueFilters;
  }
  
  public SerializeWriter getWriter()
  {
    return this.out;
  }
  
  public void incrementIndent()
  {
    this.indentCount += 1;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature)
  {
    return this.out.isEnabled(paramSerializerFeature);
  }
  
  public final boolean isWriteAsArray(Object paramObject, Type paramType)
  {
    if (this.out.isEnabled(SerializerFeature.BeanToArray)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean isWriteClassName(Type paramType, Object paramObject)
  {
    boolean bool = false;
    if (!this.out.isEnabled(SerializerFeature.WriteClassName)) {}
    label55:
    label58:
    for (;;)
    {
      return bool;
      if ((paramType == null) && (isEnabled(SerializerFeature.NotWriteRootClassName))) {
        if (this.context.getParent() != null) {
          break label55;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label58;
        }
        bool = true;
        break;
      }
    }
  }
  
  public void popContext()
  {
    if (this.context != null) {
      this.context = this.context.getParent();
    }
  }
  
  public void println()
  {
    this.out.write('\n');
    for (int i = 0; i < this.indentCount; i++) {
      this.out.write(this.indent);
    }
  }
  
  public void setContext(SerialContext paramSerialContext)
  {
    this.context = paramSerialContext;
  }
  
  public void setContext(SerialContext paramSerialContext, Object paramObject1, Object paramObject2)
  {
    if (isEnabled(SerializerFeature.DisableCircularReferenceDetect)) {}
    for (;;)
    {
      return;
      this.context = new SerialContext(paramSerialContext, paramObject1, paramObject2);
      if (this.references == null) {
        this.references = new IdentityHashMap();
      }
      this.references.put(paramObject1, this.context);
    }
  }
  
  public void setContext(Object paramObject1, Object paramObject2)
  {
    setContext(this.context, paramObject1, paramObject2);
  }
  
  public void setDateFormat(String paramString)
  {
    this.dateFormatPattern = paramString;
    if (this.dateFormat != null) {
      this.dateFormat = null;
    }
  }
  
  public void setDateFormat(DateFormat paramDateFormat)
  {
    this.dateFormat = paramDateFormat;
    if (this.dateFormatPattern != null) {
      this.dateFormatPattern = null;
    }
  }
  
  public String toString()
  {
    return this.out.toString();
  }
  
  public final void write(Object paramObject)
  {
    if (paramObject == null) {
      this.out.writeNull();
    }
    for (;;)
    {
      return;
      ObjectSerializer localObjectSerializer = getObjectWriter(paramObject.getClass());
      try
      {
        localObjectSerializer.write(this, paramObject, null, null);
      }
      catch (IOException paramObject)
      {
        throw new JSONException(((IOException)paramObject).getMessage(), (Throwable)paramObject);
      }
    }
  }
  
  public final void write(String paramString)
  {
    StringCodec.instance.write(this, paramString);
  }
  
  protected final void writeKeyValue(char paramChar, String paramString, Object paramObject)
  {
    if (paramChar != 0) {
      this.out.write(paramChar);
    }
    this.out.writeFieldName(paramString);
    write(paramObject);
  }
  
  public void writeNull()
  {
    this.out.writeNull();
  }
  
  public void writeReference(Object paramObject)
  {
    SerialContext localSerialContext2 = getContext();
    if (paramObject == localSerialContext2.getObject()) {
      this.out.write("{\"$ref\":\"@\"}");
    }
    for (;;)
    {
      return;
      SerialContext localSerialContext3 = localSerialContext2.getParent();
      SerialContext localSerialContext1 = localSerialContext2;
      if (localSerialContext3 != null)
      {
        localSerialContext1 = localSerialContext2;
        if (paramObject == localSerialContext3.getObject())
        {
          this.out.write("{\"$ref\":\"..\"}");
          continue;
        }
      }
      while (localSerialContext1.getParent() != null) {
        localSerialContext1 = localSerialContext1.getParent();
      }
      if (paramObject == localSerialContext1.getObject())
      {
        this.out.write("{\"$ref\":\"$\"}");
      }
      else
      {
        paramObject = getSerialContext(paramObject).getPath();
        this.out.write("{\"$ref\":\"");
        this.out.write((String)paramObject);
        this.out.write("\"}");
      }
    }
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2)
  {
    writeWithFieldName(paramObject1, paramObject2, null);
  }
  
  public final void writeWithFieldName(Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {}
    for (;;)
    {
      try
      {
        this.out.writeNull();
        return;
      }
      catch (IOException paramObject1)
      {
        throw new JSONException(((IOException)paramObject1).getMessage(), (Throwable)paramObject1);
      }
      getObjectWriter(paramObject1.getClass()).write(this, paramObject1, paramObject2, paramType);
    }
  }
  
  public final void writeWithFormat(Object paramObject, String paramString)
  {
    if ((paramObject instanceof Date))
    {
      DateFormat localDateFormat = getDateFormat();
      Object localObject = localDateFormat;
      if (localDateFormat == null) {
        localObject = new SimpleDateFormat(paramString);
      }
      paramObject = ((DateFormat)localObject).format((Date)paramObject);
      this.out.writeString((String)paramObject);
    }
    for (;;)
    {
      return;
      write(paramObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/JSONSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */