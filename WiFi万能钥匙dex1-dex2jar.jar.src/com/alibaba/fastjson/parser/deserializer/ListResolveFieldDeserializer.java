package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public final class ListResolveFieldDeserializer
  extends FieldDeserializer
{
  private final int index;
  private final List list;
  private final DefaultJSONParser parser;
  
  public ListResolveFieldDeserializer(DefaultJSONParser paramDefaultJSONParser, List paramList, int paramInt)
  {
    super(null, null);
    this.parser = paramDefaultJSONParser;
    this.index = paramInt;
    this.list = paramList;
  }
  
  public final void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {}
  
  public final void setValue(Object paramObject1, Object paramObject2)
  {
    this.list.set(this.index, paramObject2);
    if ((this.list instanceof JSONArray))
    {
      JSONArray localJSONArray = (JSONArray)this.list;
      Object localObject = localJSONArray.getRelatedArray();
      if ((localObject != null) && (Array.getLength(localObject) > this.index))
      {
        paramObject1 = paramObject2;
        if (localJSONArray.getComponentType() != null) {
          paramObject1 = TypeUtils.cast(paramObject2, localJSONArray.getComponentType(), this.parser.getConfig());
        }
        Array.set(localObject, this.index, paramObject1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ListResolveFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */