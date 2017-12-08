package com.b.a;

import com.b.a.b.a;
import com.b.a.b.b;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class bb
{
  private static final c<Type, List<l>> a = new an(500);
  private final i b;
  
  bb(i parami)
  {
    this.b = ((i)a.a(parami));
  }
  
  private static List<Class<?>> a(Type paramType)
  {
    ArrayList localArrayList = new ArrayList();
    for (paramType = b.b(paramType); (paramType != null) && (!paramType.equals(Object.class)); paramType = paramType.getSuperclass()) {
      if (!paramType.isSynthetic()) {
        localArrayList.add(paramType);
      }
    }
    return localArrayList;
  }
  
  final void a(aw paramaw, av.a parama)
  {
    Type localType1 = paramaw.b();
    Object localObject2 = paramaw.a();
    Type localType2 = paramaw.a;
    Object localObject1 = (List)a.a(localType1);
    paramaw = (aw)localObject1;
    if (localObject1 == null)
    {
      paramaw = new ArrayList();
      Iterator localIterator = a(localType1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Class)localIterator.next();
        Field[] arrayOfField = ((Class)localObject1).getDeclaredFields();
        AccessibleObject.setAccessible(arrayOfField, true);
        int j = arrayOfField.length;
        for (int i = 0; i < j; i++) {
          paramaw.add(new l((Class)localObject1, arrayOfField[i], localType2));
        }
      }
      a.a(localType1, paramaw);
    }
    localObject1 = paramaw.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramaw = (l)((Iterator)localObject1).next();
      if ((!this.b.a(paramaw)) && (!this.b.a(paramaw.c())))
      {
        localType1 = paramaw.f();
        if (!parama.c(paramaw, localType1, localObject2)) {
          if (b.d(localType1)) {
            parama.a(paramaw, localType1, localObject2);
          } else {
            parama.b(paramaw, localType1, localObject2);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */