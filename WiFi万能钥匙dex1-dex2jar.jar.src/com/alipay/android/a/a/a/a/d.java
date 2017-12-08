package com.alipay.android.a.a.a.a;

import com.alipay.a.a.e;
import com.alipay.android.a.a.a.b;
import java.lang.reflect.Type;
import org.json.JSONObject;

public final class d
  extends a
{
  public d(Type paramType, byte[] paramArrayOfByte)
  {
    super(paramType, paramArrayOfByte);
  }
  
  public final Object a()
  {
    Object localObject2;
    try
    {
      String str = new java/lang/String;
      str.<init>(this.b);
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("threadid = ");
      ((StringBuilder)localObject2).append(Thread.currentThread().getId()).append("; rpc response:  ").append(str);
      localObject2 = new org/json/JSONObject;
      ((JSONObject)localObject2).<init>(str);
      int i = ((JSONObject)localObject2).getInt("resultStatus");
      if (i != 1000)
      {
        str = ((JSONObject)localObject2).optString("tips");
        localObject2 = new com/alipay/android/a/a/a/b;
        ((b)localObject2).<init>(Integer.valueOf(i), str);
        throw ((Throwable)localObject2);
      }
    }
    catch (Exception localException)
    {
      if ("response  =" + new String(this.b) + ":" + localException != null) {}
    }
    for (Object localObject1 = "";; localObject1 = ((Exception)localObject1).getMessage())
    {
      throw new b(Integer.valueOf(10), (String)localObject1);
      if (this.a == String.class) {}
      for (localObject1 = ((JSONObject)localObject2).optString("result");; localObject1 = e.a(((JSONObject)localObject2).optString("result"), this.a)) {
        return localObject1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */