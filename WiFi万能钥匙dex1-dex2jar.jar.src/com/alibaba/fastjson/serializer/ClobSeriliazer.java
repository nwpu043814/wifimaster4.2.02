package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobSeriliazer
  implements ObjectSerializer
{
  public static final ClobSeriliazer instance = new ClobSeriliazer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    if (paramObject1 == null) {}
    for (;;)
    {
      try
      {
        paramJSONSerializer.writeNull();
        return;
      }
      catch (SQLException paramJSONSerializer)
      {
        int i;
        throw new IOException("write clob error", paramJSONSerializer);
      }
      paramObject2 = ((Clob)paramObject1).getCharacterStream();
      paramObject1 = new java/io/StringWriter;
      ((StringWriter)paramObject1).<init>();
      paramType = new char['Ѐ'];
      i = ((Reader)paramObject2).read(paramType);
      if (i != -1)
      {
        ((StringWriter)paramObject1).write(paramType, 0, i);
      }
      else
      {
        ((Reader)paramObject2).close();
        paramJSONSerializer.write(((StringWriter)paramObject1).toString());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/ClobSeriliazer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */