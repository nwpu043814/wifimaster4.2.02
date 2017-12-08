package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;
import java.util.Map;

public final class MapResolveFieldDeserializer
  extends FieldDeserializer
{
  private final String key;
  private final Map map;
  
  public MapResolveFieldDeserializer(Map paramMap, String paramString)
  {
    super(null, null);
    this.key = paramString;
    this.map = paramMap;
  }
  
  public final void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public final void setValue(Object paramObject1, Object paramObject2)
  {
    this.map.put(this.key, paramObject2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/MapResolveFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */