package com.wifi.connect;

import com.bluefay.b.a;
import com.wifi.connect.model.AccessPointKey;
import com.wifi.connect.model.c;
import java.util.ArrayList;
import java.util.Iterator;

final class b
  implements a
{
  b(WkSDKService paramWkSDKService) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt == 1)
    {
      localObject1 = localObject2;
      if ((paramObject instanceof c))
      {
        paramObject = ((c)paramObject).k();
        localObject1 = new ArrayList();
        paramObject = ((ArrayList)paramObject).iterator();
        while (((Iterator)paramObject).hasNext()) {
          ((ArrayList)localObject1).add((AccessPointKey)((Iterator)paramObject).next());
        }
      }
    }
    paramObject = new com.lantern.sdk.stub.b("queryKey");
    ((com.lantern.sdk.stub.b)paramObject).b = paramInt;
    ((com.lantern.sdk.stub.b)paramObject).c = paramString;
    ((com.lantern.sdk.stub.b)paramObject).d = WkSDKService.a((ArrayList)localObject1);
    com.lantern.sdk.stub.b.a(this.a, (com.lantern.sdk.stub.b)paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */