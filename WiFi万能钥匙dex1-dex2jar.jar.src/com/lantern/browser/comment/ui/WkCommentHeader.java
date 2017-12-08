package com.lantern.browser.comment.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.lantern.browser.R.layout;

public class WkCommentHeader
  extends RelativeLayout
{
  public WkCommentHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.layout.browser_comment_header, this);
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */