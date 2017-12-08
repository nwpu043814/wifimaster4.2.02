package a.a.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class b
{
  private ArrayList a;
  
  public b()
  {
    this.a = new ArrayList();
  }
  
  public b(d paramd)
  {
    this();
    int i = paramd.c();
    char c;
    if (i == 91)
    {
      c = ']';
      if (paramd.c() != ']') {
        break label47;
      }
    }
    label47:
    do
    {
      return;
      if (i == 40)
      {
        c = ')';
        break;
      }
      throw paramd.a("A JSONArray text must start with '['");
      paramd.a();
      for (;;)
      {
        if (paramd.c() == ',')
        {
          paramd.a();
          this.a.add(null);
        }
        for (;;)
        {
          i = paramd.c();
          switch (i)
          {
          default: 
            throw paramd.a("Expected a ',' or ']'");
            paramd.a();
            this.a.add(paramd.d());
          }
        }
        if (paramd.c() == ']') {
          break;
        }
        paramd.a();
      }
    } while (c == i);
    throw paramd.a("Expected a '" + new Character(c) + "'");
  }
  
  public b(Object paramObject)
  {
    this();
    if (paramObject.getClass().isArray())
    {
      int j = Array.getLength(paramObject);
      for (int i = 0; i < j; i++)
      {
        Object localObject = Array.get(paramObject, i);
        this.a.add(localObject);
      }
    }
    throw new a("JSONArray initial value should be a string or collection or array.");
  }
  
  public b(String paramString)
  {
    this(new d(paramString));
  }
  
  public b(Collection paramCollection)
  {
    if (paramCollection == null) {}
    for (paramCollection = new ArrayList();; paramCollection = new ArrayList(paramCollection))
    {
      this.a = paramCollection;
      return;
    }
  }
  
  private String a(String paramString)
  {
    int j = this.a.size();
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < j; i++)
    {
      if (i > 0) {
        localStringBuffer.append(paramString);
      }
      localStringBuffer.append(c.a(this.a.get(i)));
    }
    return localStringBuffer.toString();
  }
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final Object a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {}
    for (Object localObject = null; localObject == null; localObject = this.a.get(paramInt)) {
      throw new a("JSONArray[" + paramInt + "] not found.");
    }
    return localObject;
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("[");
      localObject1 = a(",") + ']';
      return (String)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */