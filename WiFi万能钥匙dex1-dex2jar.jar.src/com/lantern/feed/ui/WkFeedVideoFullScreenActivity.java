package com.lantern.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bluefay.b.h;
import com.lantern.feed.b.g;
import com.qihoo.util.StubApp1053578832;

public class WkFeedVideoFullScreenActivity
  extends Activity
{
  public static int a = -1;
  public static int b = -1;
  public static boolean c = false;
  public static g d;
  public static String e;
  private WkFeedVideoPlayer f;
  
  static
  {
    StubApp1053578832.interface11(24);
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, g paramg, String paramString)
  {
    a = paramInt1;
    b = paramInt2;
    h.a("toFullScreen mState:" + a + " mBackupState:" + b, new Object[0]);
    d = paramg;
    e = paramString;
    paramContext.startActivity(new Intent(paramContext, WkFeedVideoFullScreenActivity.class));
  }
  
  public void onBackPressed()
  {
    this.f.f();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onPause()
  {
    super.onPause();
    h.a("onPause mManualQuit:" + c, new Object[0]);
    if (!c)
    {
      this.f.g();
      finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedVideoFullScreenActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */