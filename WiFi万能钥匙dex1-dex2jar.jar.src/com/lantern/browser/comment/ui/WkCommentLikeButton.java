package com.lantern.browser.comment.ui;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.browser.R.anim;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.comment.d.j;

public class WkCommentLikeButton
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a;
  private Animation b;
  private Animation c;
  private Animation d;
  private TextView e;
  private ImageView f;
  private TextView g;
  private j h;
  private a i;
  
  public WkCommentLikeButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentLikeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentLikeButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(1);
    setOnClickListener(this);
    this.b = AnimationUtils.loadAnimation(this.a, R.anim.praise_anim_1);
    this.c = AnimationUtils.loadAnimation(this.a, R.anim.praise_anim_2);
    this.d = AnimationUtils.loadAnimation(this.a, R.anim.praise_anim_3);
    this.b.setAnimationListener(new ah(this));
    this.c.setAnimationListener(new ai(this));
    LayoutInflater.from(paramContext).inflate(R.layout.browser_comment_item_likebtn, this);
    this.e = ((TextView)findViewById(R.id.addUpText));
    this.e.getPaint().setFakeBoldText(true);
    this.g = ((TextView)findViewById(R.id.upText));
    this.f = ((ImageView)findViewById(R.id.upImage));
  }
  
  public final void a(j paramj)
  {
    this.h = paramj;
    this.g.setText(String.valueOf(this.h.e()));
    if (this.h.g())
    {
      setClickable(false);
      this.g.setTextColor(-572872);
      this.f.setImageResource(R.drawable.browser_comment_zan_on);
      if (this.h.e() <= 0) {
        break label102;
      }
      this.g.setVisibility(0);
    }
    for (;;)
    {
      return;
      setClickable(true);
      this.g.setTextColor(-3355444);
      this.f.setImageResource(R.drawable.browser_comment_zan_off);
      break;
      label102:
      this.g.setVisibility(4);
    }
  }
  
  public final void a(a parama)
  {
    this.i = parama;
  }
  
  public void onClick(View paramView)
  {
    setClickable(false);
    this.g.setVisibility(0);
    this.g.setText(String.valueOf(this.h.e() + 1));
    this.g.setTextColor(-572872);
    this.e.startAnimation(this.b);
    this.f.startAnimation(this.c);
    if ((this.h.o() == 0) && (this.h.p() != 1) && (this.i != null)) {
      this.i.a(this.h.n(), this.h.a(), this.h.m());
    }
    this.h.a(this.h.e() + 1);
    this.h.h();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentLikeButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */