package com.lantern.browser.comment.f;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.lantern.browser.comment.ui.WkCommentSetUserInfoGuideActivity;
import com.lantern.core.config.d;
import com.lantern.core.p;
import org.json.JSONObject;

public class b
{
  private static b a;
  private a b;
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        b localb = new com/lantern/browser/comment/f/b;
        localb.<init>();
        a = localb;
      }
      return a;
    }
    finally {}
  }
  
  private void c()
  {
    if (this.b != null)
    {
      com.lantern.core.c.removeListener(this.b);
      this.b = null;
    }
  }
  
  public final void a(Context paramContext, Runnable paramRunnable)
  {
    int j = 1;
    boolean bool2 = TextUtils.isEmpty(p.e(paramContext));
    boolean bool1 = TextUtils.isEmpty(p.d(paramContext));
    JSONObject localJSONObject = d.a(paramContext).a("comment");
    int i = j;
    if (localJSONObject != null)
    {
      if (localJSONObject.optInt("anss", 1) == 1) {
        i = j;
      }
    }
    else
    {
      if ((i == 0) || ((!bool2) && (!bool1))) {
        break label127;
      }
      paramContext.startActivity(new Intent(paramContext, WkCommentSetUserInfoGuideActivity.class));
      if (this.b != null) {
        break label116;
      }
      this.b = new c(this, paramRunnable);
      com.lantern.core.c.addListener(this.b);
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label116:
      this.b.a(paramRunnable);
      continue;
      label127:
      paramRunnable.run();
    }
  }
  
  public final void b()
  {
    c();
  }
  
  private abstract class a
    extends com.bluefay.d.b
  {
    private Runnable a;
    
    public a(Runnable paramRunnable)
    {
      super();
      this.a = paramRunnable;
    }
    
    public abstract void a();
    
    public final void a(Runnable paramRunnable)
    {
      this.a = paramRunnable;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        a();
        if ((paramMessage.what == 128301) && (this.a != null)) {
          this.a.run();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */