package com.lantern.browser.comment.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.lantern.browser.R.drawable;
import com.lantern.core.imageloader.c;

public class WkCommentAvatarView
  extends FrameLayout
{
  private String a;
  private int b = -1;
  private int c;
  private ImageView d;
  
  public WkCommentAvatarView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = new ImageView(paramContext);
    this.d.setImageResource(R.drawable.news_comment_head_pic);
    addView(this.d, new FrameLayout.LayoutParams(-1, -1));
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(R.drawable.news_comment_head_frame);
    addView(paramContext, new FrameLayout.LayoutParams(-1, -1));
    this.c = R.drawable.news_comment_head_pic;
  }
  
  public final void a(int paramInt)
  {
    this.d.setImageResource(paramInt);
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.d.setImageDrawable(null);
      this.d.setBackgroundResource(this.c);
      this.a = paramString;
      this.b = -1;
      c.a(getContext(), this.c, this.d);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(this.a)) || (!this.a.equals(paramString)) || (this.b == -1))
      {
        this.d.setImageDrawable(null);
        this.d.setBackgroundResource(this.c);
        c.a(getContext(), paramString, this.d, new d(this), null);
        this.a = paramString;
        this.b = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentAvatarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */