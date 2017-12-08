package com.lantern.browser;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.bluefay.b.h;

public class bb
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  private MediaScannerConnection a;
  private String b;
  private String c;
  
  public bb(Context paramContext, String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = new MediaScannerConnection(paramContext, this);
  }
  
  public final void a()
  {
    this.a.connect();
  }
  
  public void onMediaScannerConnected()
  {
    try
    {
      this.a.scanFile(this.b, this.c);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public void onScanCompleted(String paramString, Uri paramUri) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */