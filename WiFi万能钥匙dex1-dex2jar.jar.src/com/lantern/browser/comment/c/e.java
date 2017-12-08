package com.lantern.browser.comment.c;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;
import bluefay.app.k.a;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.at;
import com.lantern.browser.bg;
import com.lantern.browser.bh;
import com.lantern.browser.bn;
import com.lantern.browser.comment.d.n;
import com.lantern.browser.comment.f.b;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class e
  extends a.b
{
  e(a parama)
  {
    super(parama);
  }
  
  public final void a()
  {
    a.o(this.a);
  }
  
  public final void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("newsId", a.a(this.a));
    com.lantern.analytics.a.e().onEvent("cmtshacli", new JSONObject(localHashMap).toString());
    if ((a.j(this.a) != null) && (a.j(this.a).a("cmt", paramInt))) {
      a.n(this.a).dismiss();
    }
  }
  
  public final void a(n paramn)
  {
    boolean bool = true;
    if (a.j(this.a) != null) {
      bool = a.j(this.a).i().a();
    }
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("wifi.intent.action.BROWSER", Uri.parse(paramn.c()));
      localIntent.setPackage(a.d(this.a).getPackageName());
      localIntent.addFlags(268435456);
      localIntent.putExtra("allowdownload", bool);
      localIntent.putExtra("title", paramn.b());
      localIntent.putExtra("web_page_id", a.j(this.a).h().b().a().l());
      a.d(this.a).startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramn)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramn);
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (c.getServer().j())
    {
      b.a().a(a.d(this.a), new f(this, paramString));
      com.lantern.analytics.a.e().onEvent("cmtsubmit");
    }
    for (;;)
    {
      return;
      Context localContext = a.j(this.a).getContext();
      k.a locala = new k.a(localContext);
      TextView localTextView = new TextView(localContext);
      localTextView.setTextSize(16.0F);
      localTextView.setTextColor(-11711155);
      localTextView.setGravity(17);
      localTextView.setText(R.string.comment_dialog_message);
      int i = com.bluefay.a.e.a(localContext, 20.0F);
      localTextView.setPadding(i, i, i, i);
      locala.a(localTextView);
      locala.b(R.string.comment_dialog_cancel, new g(this));
      locala.a(R.string.comment_dialog_login, new h(this, paramString));
      locala.a(new k(this));
      locala.d();
    }
  }
  
  public final void b()
  {
    a.i(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */