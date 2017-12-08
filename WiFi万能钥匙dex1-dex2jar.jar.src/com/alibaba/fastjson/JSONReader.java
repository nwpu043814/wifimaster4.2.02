package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONReaderScanner;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader
  implements Closeable
{
  private JSONStreamContext context;
  private final DefaultJSONParser parser;
  
  public JSONReader(DefaultJSONParser paramDefaultJSONParser)
  {
    this.parser = paramDefaultJSONParser;
  }
  
  public JSONReader(JSONLexer paramJSONLexer)
  {
    this(new DefaultJSONParser(paramJSONLexer));
  }
  
  public JSONReader(Reader paramReader)
  {
    this(new JSONReaderScanner(paramReader));
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
      i = 1002;
    }
  }
  
  private void readAfter()
  {
    int i = 1002;
    int j = this.context.getState();
    switch (j)
    {
    default: 
      throw new JSONException("illegal state : " + j);
    case 1002: 
      i = 1003;
    }
    for (;;)
    {
      if (i != -1) {
        this.context.setState(i);
      }
      return;
      i = -1;
      continue;
      i = 1005;
    }
  }
  
  private void readBefore()
  {
    int i = this.context.getState();
    switch (i)
    {
    default: 
      throw new JSONException("illegal state : " + i);
    case 1002: 
      this.parser.accept(17);
    }
    for (;;)
    {
      return;
      this.parser.accept(16, 18);
      continue;
      this.parser.accept(16);
    }
  }
  
  private void startStructure()
  {
    switch (this.context.getState())
    {
    default: 
      throw new JSONException("illegal state : " + this.context.getState());
    case 1002: 
      this.parser.accept(17);
    }
    for (;;)
    {
      return;
      this.parser.accept(16);
    }
  }
  
  public void close()
  {
    IOUtils.close(this.parser);
  }
  
  public void config(Feature paramFeature, boolean paramBoolean)
  {
    this.parser.config(paramFeature, paramBoolean);
  }
  
  public void endArray()
  {
    this.parser.accept(15);
    endStructure();
  }
  
  public void endObject()
  {
    this.parser.accept(13);
    endStructure();
  }
  
  public boolean hasNext()
  {
    boolean bool = true;
    if (this.context == null) {
      throw new JSONException("context is null");
    }
    int j = this.parser.getLexer().token();
    int i = this.context.getState();
    switch (i)
    {
    case 1002: 
    default: 
      throw new JSONException("illegal state : " + i);
    case 1004: 
    case 1005: 
      if (j == 15) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      if (j == 13) {
        bool = false;
      }
    }
  }
  
  public Integer readInteger()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToInt(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public Long readLong()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToLong(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public Object readObject()
  {
    if (this.context == null)
    {
      localObject = this.parser.parse();
      return localObject;
    }
    readBefore();
    switch (this.context.getState())
    {
    }
    for (Object localObject = this.parser.parse();; localObject = this.parser.parseKey())
    {
      readAfter();
      break;
    }
  }
  
  public <T> T readObject(TypeReference<T> paramTypeReference)
  {
    return (T)readObject(paramTypeReference.getType());
  }
  
  public <T> T readObject(Class<T> paramClass)
  {
    if (this.context == null) {
      paramClass = this.parser.parseObject(paramClass);
    }
    for (;;)
    {
      return paramClass;
      readBefore();
      paramClass = this.parser.parseObject(paramClass);
      readAfter();
    }
  }
  
  public <T> T readObject(Type paramType)
  {
    if (this.context == null) {
      paramType = this.parser.parseObject(paramType);
    }
    for (;;)
    {
      return paramType;
      readBefore();
      paramType = this.parser.parseObject(paramType);
      readAfter();
    }
  }
  
  public Object readObject(Map paramMap)
  {
    if (this.context == null) {
      paramMap = this.parser.parseObject(paramMap);
    }
    for (;;)
    {
      return paramMap;
      readBefore();
      paramMap = this.parser.parseObject(paramMap);
      readAfter();
    }
  }
  
  public void readObject(Object paramObject)
  {
    if (this.context == null) {
      this.parser.parseObject(paramObject);
    }
    for (;;)
    {
      return;
      readBefore();
      this.parser.parseObject(paramObject);
      readAfter();
    }
  }
  
  public String readString()
  {
    Object localObject;
    if (this.context == null) {
      localObject = this.parser.parse();
    }
    for (;;)
    {
      return TypeUtils.castToString(localObject);
      readBefore();
      localObject = this.parser.parse();
      readAfter();
    }
  }
  
  public void startArray()
  {
    if (this.context == null) {}
    for (this.context = new JSONStreamContext(null, 1004);; this.context = new JSONStreamContext(this.context, 1004))
    {
      this.parser.accept(14);
      return;
      startStructure();
    }
  }
  
  public void startObject()
  {
    if (this.context == null) {}
    for (this.context = new JSONStreamContext(null, 1001);; this.context = new JSONStreamContext(this.context, 1001))
    {
      this.parser.accept(12, 18);
      return;
      startStructure();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/JSONReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */