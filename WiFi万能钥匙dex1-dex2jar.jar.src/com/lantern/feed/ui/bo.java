package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.webkit.DownloadListener;

final class bo
  implements DownloadListener
{
  bo(bm parambm) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (bm.c(this.a) != null) {
      bm.c(this.a).cancel();
    }
    this.a.dismiss();
    bm.a(this.a, paramString1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */