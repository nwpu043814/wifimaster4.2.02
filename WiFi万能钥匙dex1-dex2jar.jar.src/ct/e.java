package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  public int a;
  public int b;
  public int c;
  public int d;
  public int e;
  public am f;
  
  public e() {}
  
  public e(ah paramah)
  {
    this.a = paramah.a;
    this.b = paramah.b;
    this.c = paramah.c;
    this.d = paramah.d;
    this.e = paramah.e;
    this.f = paramah.f;
  }
  
  private void c()
  {
    if ((this.a < 10000) || (this.a > 60000)) {
      this.a = 20000;
    }
    if ((this.b < 10000) || (this.b > 60000)) {
      this.b = 20000;
    }
    if ((this.c < 3) || (this.c > 15)) {
      this.c = 8;
    }
    if ((this.d <= 0) || (this.d > 5)) {
      this.d = 2;
    }
    if ((this.e < 900) || (this.e > 2160)) {
      this.e = 1440;
    }
  }
  
  public final void a()
  {
    am localam = null;
    Object localObject = p.a().getSharedPreferences("Access_Preferences", 0);
    this.a = ((SharedPreferences)localObject).getInt("connectTimeout", 20000);
    this.b = ((SharedPreferences)localObject).getInt("readTimeout", 20000);
    this.c = ((SharedPreferences)localObject).getInt("apnCachedNum", 8);
    this.d = ((SharedPreferences)localObject).getInt("parallelNum", 2);
    this.e = ((SharedPreferences)localObject).getInt("expireTime", 1440);
    localObject = ((SharedPreferences)localObject).getString("samplingInfo", null);
    if (localObject != null)
    {
      String[] arrayOfString = ((String)localObject).split(";");
      localam = new am();
      HashMap localHashMap = new HashMap();
      for (int i = 0; i < arrayOfString.length - 1; i++)
      {
        localObject = arrayOfString[i].split(",");
        localHashMap.put(Integer.valueOf(Integer.parseInt(localObject[0])), Byte.valueOf(Byte.parseByte(localObject[1])));
      }
      localam.a = localHashMap;
      localam.b = Byte.parseByte(arrayOfString[(arrayOfString.length - 1)]);
    }
    this.f = localam;
    c();
  }
  
  public final void b()
  {
    Object localObject = p.a().getSharedPreferences("Access_Preferences", 0);
    c();
    ((SharedPreferences)localObject).edit().putInt("connectTimeout", this.a).commit();
    ((SharedPreferences)localObject).edit().putInt("readTimeout", this.b).commit();
    ((SharedPreferences)localObject).edit().putInt("apnCachedNum", this.c).commit();
    ((SharedPreferences)localObject).edit().putInt("parallelNum", this.d).commit();
    ((SharedPreferences)localObject).edit().putInt("expireTime", this.e).commit();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    if (((am)localObject).a != null)
    {
      Iterator localIterator = ((am)localObject).a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append(localEntry.getKey() + "," + localEntry.getValue() + ";");
      }
      localStringBuilder.append(((am)localObject).b);
    }
    for (localObject = localStringBuilder.toString();; localObject = null)
    {
      localEditor.putString("samplingInfo", (String)localObject).commit();
      return;
    }
  }
  
  public final String toString()
  {
    return "connectTimeout:" + this.a + ",readTimeout:" + this.b + ",apnCachedNum:" + this.c + ",parallelNum:" + this.d + ",expireTime:" + this.e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */