package com.alipay.android.a.a.a.a;

import com.alipay.a.a.f;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class e
  extends b
{
  private int c;
  private Object d;
  
  public e(int paramInt, String paramString, Object paramObject)
  {
    super(paramString, paramObject);
    this.c = paramInt;
  }
  
  public final void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public final byte[] a()
  {
    Object localObject;
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      if (this.d != null)
      {
        localObject = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject).<init>("extParam", f.a(this.d));
        localArrayList.add(localObject);
      }
      localObject = new org/apache/http/message/BasicNameValuePair;
      ((BasicNameValuePair)localObject).<init>("operationType", this.a);
      localArrayList.add(localObject);
      BasicNameValuePair localBasicNameValuePair = new org/apache/http/message/BasicNameValuePair;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localBasicNameValuePair.<init>("id", this.c);
      localArrayList.add(localBasicNameValuePair);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("mParams is:");
      ((StringBuilder)localObject).append(this.b);
      localBasicNameValuePair = new org/apache/http/message/BasicNameValuePair;
      if (this.b == null) {}
      for (localObject = "[]";; localObject = f.a(this.b))
      {
        localBasicNameValuePair.<init>("requestData", (String)localObject);
        localArrayList.add(localBasicNameValuePair);
        return URLEncodedUtils.format(localArrayList, "utf-8").getBytes();
      }
      localObject = "";
    }
    catch (Exception localException)
    {
      if ("request  =" + this.b + ":" + localException != null) {}
    }
    for (;;)
    {
      throw new com.alipay.android.a.a.a.b(Integer.valueOf(9), (String)localObject, localException);
      localObject = localException.getMessage();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */