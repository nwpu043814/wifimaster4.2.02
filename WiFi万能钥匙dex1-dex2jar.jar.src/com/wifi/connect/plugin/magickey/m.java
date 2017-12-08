package com.wifi.connect.plugin.magickey;

import com.bluefay.b.a;
import com.lantern.core.g.r.a;
import com.lantern.sdk.stub.b;

final class m
  implements a
{
  m(ConnectService paramConnectService) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 10000;
    if ((paramObject instanceof r.a)) {
      i = ((r.a)paramObject).a;
    }
    paramObject = new b("connect");
    ((b)paramObject).b = paramInt;
    ((b)paramObject).c = paramString;
    ((b)paramObject).d = String.valueOf(i);
    b.a(this.a, (b)paramObject);
    if ((paramInt == 1) || (paramInt == 0)) {
      ConnectService.a(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */