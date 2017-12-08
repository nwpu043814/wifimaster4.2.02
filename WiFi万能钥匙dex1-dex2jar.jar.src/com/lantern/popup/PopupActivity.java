package com.lantern.popup;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import bluefay.app.b;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.qihoo.util.StubApp1053578832;

public class PopupActivity
  extends b
{
  private TextView e;
  private WebView f;
  private View g;
  private Button h;
  private Button i;
  private PopupItem j;
  private View k;
  private View.OnClickListener l = new c(this);
  
  static
  {
    StubApp1053578832.interface11(42);
  }
  
  private void a(Intent paramIntent)
  {
    this.j = ((PopupItem)paramIntent.getParcelableExtra("popup"));
    if (this.j != null)
    {
      this.e.setText(this.j.c);
      this.f.loadDataWithBaseURL("", this.j.d, "text/html", "utf-8", "");
      if ((this.j.f != null) && (this.j.f.length() != 0)) {
        break label164;
      }
      this.i.setVisibility(8);
      this.h.setText(this.j.e);
      if (this.j.b != 2) {
        break label189;
      }
      this.h.setTextColor(-1);
      this.g.setBackgroundResource(2130838448);
      this.i.setBackgroundResource(2130838433);
      this.h.setBackgroundResource(2130838435);
    }
    for (;;)
    {
      a.e().onEvent("smsh", this.j.a);
      return;
      label164:
      this.i.setText(this.j.f);
      this.i.setVisibility(0);
      break;
      label189:
      if (this.j.b == 3)
      {
        this.g.setBackgroundResource(2130838449);
        this.h.setTextColor(-1);
        this.i.setBackgroundResource(2130838433);
        this.h.setBackgroundResource(2130838436);
      }
      else
      {
        this.g.setBackgroundResource(2130838447);
        this.h.setTextColor(-16611856);
        this.h.setBackgroundResource(2130838434);
      }
    }
  }
  
  protected final void d()
  {
    Object localObject1;
    if (this.j != null)
    {
      localObject1 = this.j.g;
      if (localObject1 != null) {
        break label20;
      }
    }
    for (;;)
    {
      return;
      label20:
      Object localObject2;
      if (((String)localObject1).startsWith("http://"))
      {
        localObject2 = new Intent("wifi.intent.action.BROWSER");
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        ((Intent)localObject2).setPackage(getPackageName());
        e.a(this, (Intent)localObject2);
      }
      else if (((String)localObject1).startsWith("package:"))
      {
        localObject2 = new Intent();
        ((Intent)localObject2).setAction("android.intent.action.DELETE");
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        e.a(this, (Intent)localObject2);
      }
      else if (((String)localObject1).startsWith("intent:"))
      {
        localObject2 = ((String)localObject1).substring(7);
        if ((localObject2 != null) && (((String)localObject2).length() != 0))
        {
          localObject1 = ((String)localObject2).split("/");
          if ((localObject1 != null) && (localObject1.length == 2))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).setClassName(localObject1[0], localObject1[1]);
            e.a(this, (Intent)localObject2);
          }
          else
          {
            localObject1 = getPackageManager().getLaunchIntentForPackage((String)localObject2);
            if (localObject1 != null) {
              e.a(this, (Intent)localObject1);
            }
          }
        }
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    h.a("onDestroy");
    this.f.destroy();
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    a(paramIntent);
  }
  
  protected void onPause()
  {
    h.a("onPause");
    super.onPause();
  }
  
  protected void onResume()
  {
    h.a("onResume");
    super.onResume();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/popup/PopupActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */