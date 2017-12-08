package com.lantern.browser.comment.ui;

import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.core.p;
import com.qihoo.util.StubApp1053578832;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WkCommentSetUserInfoGuideActivity
  extends bluefay.app.m
{
  private com.lantern.browser.comment.e.b A;
  private boolean B = true;
  private boolean C = true;
  private boolean D;
  private View.OnClickListener E = new al(this);
  private View e;
  private View f;
  private View g;
  private View h;
  private View i;
  private View j;
  private ImageView k;
  private View l;
  private TextView m;
  private ImageView n;
  private View o;
  private TextView p;
  private TextView q;
  private EditText r;
  private View s;
  private Animation t;
  private Animation u;
  private Animation v;
  private Animation w;
  private com.lantern.browser.comment.d.m x;
  private com.lantern.browser.comment.e.c y;
  private com.lantern.browser.comment.e.a z;
  
  static
  {
    StubApp1053578832.interface11(8);
  }
  
  private static String a(List<String> paramList, String paramString)
  {
    Object localObject;
    int i1;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localObject = paramList;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new ArrayList(paramList);
        ((List)localObject).remove(paramString);
      }
      i1 = ((List)localObject).size();
    }
    for (paramList = (String)((List)localObject).get(new Random().nextInt(i1));; paramList = null) {
      return paramList;
    }
  }
  
  private void a(View paramView, Animation paramAnimation)
  {
    paramView.clearAnimation();
    paramView.startAnimation(paramAnimation);
    if ((paramAnimation == this.t) || (paramAnimation == this.w)) {
      paramView.setVisibility(8);
    }
    for (;;)
    {
      return;
      if ((paramAnimation == this.v) || (paramAnimation == this.u)) {
        paramView.setVisibility(0);
      }
    }
  }
  
  private static void a(TextView paramTextView)
  {
    paramTextView.getPaint().setFlags(8);
    paramTextView.getPaint().setAntiAlias(true);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    View localView2 = null;
    View localView1;
    if (paramInt1 == 1) {
      localView1 = this.e;
    }
    for (;;)
    {
      if (paramInt2 == 1)
      {
        localView2 = this.e;
        label24:
        if (localView1 != null)
        {
          if (paramInt2 <= paramInt1) {
            break label133;
          }
          a(localView1, this.t);
        }
        label42:
        if (localView2 != null)
        {
          if (paramInt2 <= paramInt1) {
            break label145;
          }
          a(localView2, this.u);
        }
        label62:
        if (localView1 != this.e) {
          break label158;
        }
        com.lantern.browser.c.b.b(this, this.r);
      }
      for (;;)
      {
        return;
        if (paramInt1 == 2)
        {
          localView1 = this.f;
          break;
        }
        if (paramInt1 != 3) {
          break label178;
        }
        localView1 = this.g;
        break;
        if (paramInt2 == 2)
        {
          localView2 = this.f;
          break label24;
        }
        if (paramInt2 != 3) {
          break label24;
        }
        localView2 = this.g;
        break label24;
        label133:
        a(localView1, this.w);
        break label42;
        label145:
        a(localView2, this.v);
        break label62;
        label158:
        if (localView2 == this.e) {
          com.lantern.browser.c.b.a(this, this.r);
        }
      }
      label178:
      localView1 = null;
    }
  }
  
  private void b(String paramString)
  {
    com.lantern.core.imageloader.c.a(getApplication(), paramString, this.k, new com.lantern.core.imageloader.a());
    com.lantern.core.imageloader.c.a(getApplication(), paramString, this.n, new com.lantern.core.imageloader.a());
  }
  
  private boolean f()
  {
    if (!TextUtils.isEmpty(p.e(this))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private Dialog g()
  {
    com.lantern.browser.comment.b.a locala = new com.lantern.browser.comment.b.a(this);
    locala.setCanceledOnTouchOutside(false);
    locala.show();
    return locala;
  }
  
  public final String a(String paramString)
  {
    return a(this.x.b(), paramString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      try
      {
        Object localObject1 = (ArrayList)paramIntent.getSerializableExtra("picker_result");
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
        {
          String str = (String)((ArrayList)localObject1).get(0);
          if ((!TextUtils.isEmpty(str)) && (com.bluefay.b.b.e(str)))
          {
            localObject1 = g();
            Object localObject2 = new com/lantern/browser/comment/ui/aq;
            ((aq)localObject2).<init>(this);
            ((Dialog)localObject1).setOnDismissListener((DialogInterface.OnDismissListener)localObject2);
            localObject2 = new com/lantern/browser/comment/e/c;
            ar localar = new com/lantern/browser/comment/ui/ar;
            localar.<init>(this, (Dialog)localObject1, str, paramInt1);
            ((com.lantern.browser.comment.e.c)localObject2).<init>(str, localar);
            this.y = ((com.lantern.browser.comment.e.c)localObject2);
            this.y.execute(new Void[0]);
          }
        }
      }
      catch (Exception localException) {}
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    Message localMessage;
    if (this.D)
    {
      localMessage = Message.obtain();
      localMessage.what = 128301;
      com.lantern.core.c.dispatch(localMessage);
    }
    for (;;)
    {
      super.onDestroy();
      return;
      localMessage = Message.obtain();
      localMessage.what = 128302;
      com.lantern.core.c.dispatch(localMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentSetUserInfoGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */