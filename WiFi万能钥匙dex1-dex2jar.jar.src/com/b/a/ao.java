package com.b.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

final class ao
  extends b
  implements ak<Map<?, ?>>, x<Map<?, ?>>
{
  private static void a(Object paramObject1, int paramInt1, Object paramObject2, int paramInt2)
  {
    if (paramInt1 != paramInt2) {
      throw new al("Input size " + paramInt1 + " != output size " + paramInt2 + " for input " + paramObject1 + " and output " + paramObject2);
    }
  }
  
  private static Type[] a(Type paramType)
  {
    Type[] arrayOfType1;
    if ((paramType instanceof ParameterizedType))
    {
      Type[] arrayOfType2 = ((ParameterizedType)paramType).getActualTypeArguments();
      arrayOfType1 = arrayOfType2;
      if (arrayOfType2.length != 2) {
        throw new IllegalArgumentException("MapAsArrayTypeAdapter cannot handle " + paramType);
      }
    }
    else
    {
      arrayOfType1 = new Type[2];
      arrayOfType1[0] = Object.class;
      arrayOfType1[1] = Object.class;
    }
    return arrayOfType1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */