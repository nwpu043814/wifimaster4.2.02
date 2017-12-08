package com.lantern.dm.ui;

import java.util.Set;

final class f
  implements b.b
{
  f(DownloadFragment paramDownloadFragment) {}
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      DownloadFragment.c(this.a).add(Long.valueOf(paramLong));
    }
    for (;;)
    {
      DownloadFragment.h(this.a);
      return;
      DownloadFragment.c(this.a).remove(Long.valueOf(paramLong));
    }
  }
  
  public final boolean a(long paramLong)
  {
    return DownloadFragment.c(this.a).contains(Long.valueOf(paramLong));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */