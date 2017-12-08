package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.Closeable;
import java.io.Flushable;
import java.io.Writer;

public class JSONWriter
  implements Closeable, Flushable
{
  private JSONStreamContext context;
  private JSONSerializer serializer;
  private SerializeWriter writer;
  
  public JSONWriter(Writer paramWriter)
  {
    this.writer = new SerializeWriter(paramWriter);
    this.serializer = new JSONSerializer(this.writer);
  }
  
  private void afterWriter()
  {
    if (this.context == null) {
      return;
    }
    int i;
    switch (this.context.getState())
    {
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.context.setState(i);
      break;
      i = 1003;
      continue;
      i = 1002;
      continue;
      i = 1005;
    }
  }
  
  private void beforeWrite()
  {
    if (this.context == null) {}
    for (;;)
    {
      return;
      switch (this.context.getState())
      {
      case 1001: 
      case 1004: 
      default: 
        break;
      case 1002: 
        this.writer.write(':');
        break;
      case 1003: 
        this.writer.write(',');
        break;
      case 1005: 
        this.writer.write(',');
      }
    }
  }
  
  private void beginStructure()
  {
    int i = this.context.getState();
    switch (i)
    {
    case 1003: 
    default: 
      throw new JSONException("illegal state : " + i);
    case 1002: 
      this.writer.write(':');
    }
    for (;;)
    {
      return;
      this.writer.write(',');
    }
  }
  
  private void endStructure()
  {
    this.context = this.context.getParent();
    if (this.context == null) {
      return;
    }
    int i;
    switch (this.context.getState())
    {
    case 1003: 
    default: 
      i = -1;
    }
    while (i != -1)
    {
      this.context.setState(i);
      break;
      i = 1003;
      continue;
      i = 1005;
      continue;
      i = -1;
      continue;
      i = 1002;
    }
  }
  
  public void close()
  {
    this.writer.close();
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean)
  {
    this.writer.config(paramSerializerFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.writer.write(']');
    endStructure();
  }
  
  public void endObject()
  {
    this.writer.write('}');
    endStructure();
  }
  
  public void flush()
  {
    this.writer.flush();
  }
  
  public void startArray()
  {
    if (this.context != null) {
      beginStructure();
    }
    this.context = new JSONStreamContext(this.context, 1004);
    this.writer.write('[');
  }
  
  public void startObject()
  {
    if (this.context != null) {
      beginStructure();
    }
    this.context = new JSONStreamContext(this.context, 1001);
    this.writer.write('{');
  }
  
  @Deprecated
  public void writeEndArray()
  {
    endArray();
  }
  
  @Deprecated
  public void writeEndObject()
  {
    endObject();
  }
  
  public void writeKey(String paramString)
  {
    writeObject(paramString);
  }
  
  public void writeObject(Object paramObject)
  {
    beforeWrite();
    this.serializer.write(paramObject);
    afterWriter();
  }
  
  public void writeObject(String paramString)
  {
    beforeWrite();
    this.serializer.write(paramString);
    afterWriter();
  }
  
  @Deprecated
  public void writeStartArray()
  {
    startArray();
  }
  
  @Deprecated
  public void writeStartObject()
  {
    startObject();
  }
  
  public void writeValue(Object paramObject)
  {
    writeObject(paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSONWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */