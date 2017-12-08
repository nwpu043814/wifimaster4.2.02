package com.alibaba.fastjson.serializer;

import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class DoubleSerializer
  implements ObjectSerializer
{
  public static final DoubleSerializer instance = new DoubleSerializer();
  private DecimalFormat decimalFormat = null;
  
  public DoubleSerializer() {}
  
  public DoubleSerializer(String paramString)
  {
    this(new DecimalFormat(paramString));
  }
  
  public DoubleSerializer(DecimalFormat paramDecimalFormat)
  {
    this.decimalFormat = paramDecimalFormat;
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramType = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      if (paramJSONSerializer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
        paramType.write('0');
      }
    }
    double d;
    for (;;)
    {
      return;
      paramType.writeNull();
      continue;
      d = ((Double)paramObject1).doubleValue();
      if (Double.isNaN(d))
      {
        paramType.writeNull();
      }
      else
      {
        if (!Double.isInfinite(d)) {
          break;
        }
        paramType.writeNull();
      }
    }
    if (this.decimalFormat == null)
    {
      paramObject2 = Double.toString(d);
      paramObject1 = paramObject2;
      if (!((String)paramObject2).endsWith(".0")) {}
    }
    for (paramObject1 = ((String)paramObject2).substring(0, ((String)paramObject2).length() - 2);; paramObject1 = this.decimalFormat.format(d))
    {
      paramType.append((CharSequence)paramObject1);
      if (!paramJSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
        break;
      }
      paramType.write('D');
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/DoubleSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */