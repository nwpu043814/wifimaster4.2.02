package ct;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class t
{
  String a;
  Map b;
  
  public t(String paramString)
  {
    this.a = paramString;
    this.b = new HashMap();
  }
  
  public final void a(a parama)
  {
    this.b.put(parama.a, parama);
  }
  
  public static final class a
  {
    String a;
    public String b;
    public List c;
    public s d;
    long e;
    
    public a(String paramString1, long paramLong, String paramString2)
    {
      this.a = paramString1;
      this.e = paramLong;
      this.b = paramString2;
      this.c = new ArrayList();
    }
    
    public a(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
    {
      this.a = paramString1;
      this.e = paramLong;
      this.b = paramString3;
      this.c = a(paramString2);
      if (!TextUtils.isEmpty(paramString4))
      {
        paramString1 = paramString4.split(":");
        if ((paramString1 == null) || (paramString1.length <= 0)) {}
      }
      for (paramString1 = new s(paramString1[0], Integer.parseInt(paramString1[1]));; paramString1 = null)
      {
        this.d = paramString1;
        return;
      }
    }
    
    private static ArrayList a(String paramString)
    {
      ArrayList localArrayList = new ArrayList();
      if (!TextUtils.isEmpty(paramString))
      {
        String[] arrayOfString = paramString.split(",");
        if ((arrayOfString != null) && (arrayOfString.length > 0))
        {
          int j = arrayOfString.length;
          for (int i = 0; i < j; i++)
          {
            paramString = arrayOfString[i].split(":");
            if ((paramString != null) && (paramString.length > 0)) {
              localArrayList.add(new s(paramString[0], Integer.parseInt(paramString[1])));
            }
          }
        }
      }
      return localArrayList;
    }
    
    public final String a()
    {
      Object localObject2 = this.c;
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {}
      for (Object localObject1 = "";; localObject1 = ((StringBuilder)localObject1).toString())
      {
        return (String)localObject1;
        localObject1 = new StringBuilder();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((StringBuilder)localObject1).append(((s)((Iterator)localObject2).next()).a());
          ((StringBuilder)localObject1).append(",");
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
      }
    }
    
    public final boolean b()
    {
      if (SystemClock.elapsedRealtime() - this.e > b.a.b().b.e * 60 * 1000) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */