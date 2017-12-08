package com.alipay.a.a;

import a.a.a.c;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.TreeMap;

public final class g
  implements i, j
{
  public final Object a(Object paramObject)
  {
    TreeMap localTreeMap = new TreeMap();
    Class localClass = paramObject.getClass();
    for (Field[] arrayOfField = localClass.getDeclaredFields(); !localClass.equals(Object.class); arrayOfField = localClass.getDeclaredFields())
    {
      if ((arrayOfField != null) && (arrayOfField.length > 0))
      {
        int j = arrayOfField.length;
        int i = 0;
        if (i < j)
        {
          Field localField = arrayOfField[i];
          Object localObject;
          if ((localField == null) || (paramObject == null)) {
            localObject = null;
          }
          for (;;)
          {
            if (localObject != null) {
              localTreeMap.put(localField.getName(), localObject);
            }
            i++;
            break;
            if ("this$0".equals(localField.getName()))
            {
              localObject = null;
            }
            else
            {
              boolean bool = localField.isAccessible();
              localField.setAccessible(true);
              localObject = localField.get(paramObject);
              if (localObject == null)
              {
                localObject = null;
              }
              else
              {
                localField.setAccessible(bool);
                localObject = f.b(localObject);
              }
            }
          }
        }
      }
      localClass = localClass.getSuperclass();
    }
    return localTreeMap;
  }
  
  public final Object a(Object paramObject, Type paramType)
  {
    if (!paramObject.getClass().equals(c.class))
    {
      paramType = null;
      return paramType;
    }
    c localc = (c)paramObject;
    paramObject = (Class)paramType;
    Object localObject = ((Class)paramObject).newInstance();
    for (;;)
    {
      paramType = (Type)localObject;
      if (paramObject.equals(Object.class)) {
        break;
      }
      Field[] arrayOfField = ((Class)paramObject).getDeclaredFields();
      if ((arrayOfField != null) && (arrayOfField.length > 0))
      {
        int j = arrayOfField.length;
        for (int i = 0; i < j; i++)
        {
          paramType = arrayOfField[i];
          String str = paramType.getName();
          Type localType = paramType.getGenericType();
          if (localc.b(str))
          {
            paramType.setAccessible(true);
            paramType.set(localObject, e.a(localc.a(str), localType));
          }
        }
      }
      paramObject = ((Class)paramObject).getSuperclass();
    }
  }
  
  public final boolean a(Class paramClass)
  {
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */