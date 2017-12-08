package com.lantern.browser.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.comment.c.a.a;
import com.lantern.core.p;

public class WkCommentToolBar
  extends LinearLayout
{
  private Context a;
  private TextView b;
  private a.a c;
  private View d;
  private WkCommentAvatarView e;
  private ViewTreeObserver.OnGlobalLayoutListener f;
  
  public WkCommentToolBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentToolBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentToolBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setBackgroundResource(R.drawable.comment_toolbar);
    setGravity(16);
    LayoutInflater.from(paramContext).inflate(R.layout.browser_comment_toolbar, this);
    paramContext = findViewById(R.id.commentToolBarInputBtn);
    this.e = ((WkCommentAvatarView)findViewById(R.id.commentUserAvatar));
    this.e.setOnClickListener(new at(this));
    paramContext.setOnClickListener(new au(this));
    paramContext = findViewById(R.id.commentToolBarCommentBtn);
    this.d = findViewById(R.id.commentToolBarCommentImg);
    this.f = new av(this, paramContext);
    this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    paramContext.setOnClickListener(new aw(this));
    this.b = ((TextView)findViewById(R.id.commentToolBarCommentTxt));
    findViewById(R.id.commentToolBarShareBtn).setOnClickListener(new ax(this));
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.b.setVisibility(0);
      this.b.setText(String.valueOf(paramInt));
    }
    for (;;)
    {
      return;
      this.b.setVisibility(4);
    }
  }
  
  public final void a(a.a parama)
  {
    this.c = parama;
  }
  
  public final void b(int paramInt)
  {
    if (this.e.getVisibility() != paramInt) {
      this.e.setVisibility(paramInt);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.e.getVisibility() == 0)) {
      this.e.a(p.e(this.a));
    }
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {
      this.d.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      this.d.getViewTreeObserver().removeGlobalOnLayoutListener(this.f);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentToolBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */