package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceCodec
  implements ObjectDeserializer, ObjectSerializer
{
  public static final ReferenceCodec instance = new ReferenceCodec();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject)
  {
    paramType = (ParameterizedType)paramType;
    paramDefaultJSONParser = paramDefaultJSONParser.parseObject(paramType.getActualTypeArguments()[0]);
    paramType = paramType.getRawType();
    if (paramType == AtomicReference.class) {
      paramDefaultJSONParser = new AtomicReference(paramDefaultJSONParser);
    }
    for (;;)
    {
      return paramDefaultJSONParser;
      if (paramType == WeakReference.class)
      {
        paramDefaultJSONParser = new WeakReference(paramDefaultJSONParser);
      }
      else
      {
        if (paramType != SoftReference.class) {
          break;
        }
        paramDefaultJSONParser = new SoftReference(paramDefaultJSONParser);
      }
    }
    throw new UnsupportedOperationException(paramType.toString());
  }
  
  public int getFastMatchToken()
  {
    return 12;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if ((paramObject1 instanceof AtomicReference)) {}
    for (paramObject1 = ((AtomicReference)paramObject1).get();; paramObject1 = ((Reference)paramObject1).get())
    {
      paramJSONSerializer.write(paramObject1);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ReferenceCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */