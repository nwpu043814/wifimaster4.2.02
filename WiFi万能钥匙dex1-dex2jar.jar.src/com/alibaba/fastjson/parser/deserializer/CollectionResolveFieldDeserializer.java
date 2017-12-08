package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

public final class CollectionResolveFieldDeserializer
  extends FieldDeserializer
{
  private final Collection collection;
  
  public CollectionResolveFieldDeserializer(DefaultJSONParser paramDefaultJSONParser, Collection paramCollection)
  {
    super(null, null);
    this.collection = paramCollection;
  }
  
  public final void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public final void setValue(Object paramObject1, Object paramObject2)
  {
    this.collection.add(paramObject2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/CollectionResolveFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */