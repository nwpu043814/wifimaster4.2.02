package com.b.b;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class aa
  extends z<FieldDescriptorType, Object>
{
  aa(int paramInt)
  {
    super(paramInt, (byte)0);
  }
  
  public final void a()
  {
    if (!b())
    {
      for (int i = 0; i < c(); i++)
      {
        localObject = b(i);
        if (((k.a)((Map.Entry)localObject).getKey()).b()) {
          ((Map.Entry)localObject).setValue(Collections.unmodifiableList((List)((Map.Entry)localObject).getValue()));
        }
      }
      Object localObject = d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((k.a)localEntry.getKey()).b()) {
          localEntry.setValue(Collections.unmodifiableList((List)localEntry.getValue()));
        }
      }
    }
    super.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */