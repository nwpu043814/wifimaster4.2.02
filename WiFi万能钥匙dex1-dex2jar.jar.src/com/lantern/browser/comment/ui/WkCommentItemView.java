package com.lantern.browser.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.c.b;
import com.lantern.browser.c.g;
import com.lantern.browser.comment.d.j;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;

public class WkCommentItemView
  extends LinearLayout
{
  private Context a;
  private WkCommentAvatarView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private TextView g;
  private j h;
  
  public WkCommentItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkCommentItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkCommentItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(1);
    setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    LayoutInflater.from(this.a).inflate(R.layout.browser_comment_item, this);
    this.b = ((WkCommentAvatarView)findViewById(R.id.userAvatar));
    paramContext = findViewById(R.id.userInfoLayout);
    this.g = ((TextView)findViewById(R.id.commentContent));
    this.e = ((TextView)paramContext.findViewById(R.id.upText));
    this.f = ((ImageView)paramContext.findViewById(R.id.upImage));
    this.c = ((TextView)paramContext.findViewById(R.id.commentNickName));
    this.d = ((TextView)paramContext.findViewById(R.id.commentTime));
  }
  
  public final void a(j paramj)
  {
    this.h = paramj;
    h.a("setDataToView " + paramj.b(), new Object[0]);
    String str = c.getServer().h();
    int i;
    if ((!TextUtils.isEmpty(str)) && (str.equals(paramj.i())))
    {
      this.c.setText(b.a(p.d(this.a), str));
      this.b.a(p.e(this.a));
      this.d.setText(g.a(this.a, paramj.d()));
      i = paramj.e();
      if (i >= 10000) {
        break label195;
      }
    }
    label195:
    for (str = String.format(getResources().getString(R.string.comment_up_count_str_1), new Object[] { Integer.valueOf(i) });; str = String.format(getResources().getString(R.string.comment_up_count_str_2), new Object[] { Float.valueOf(i / 10000.0F) }))
    {
      this.e.setText(str);
      this.g.setText(paramj.b());
      return;
      this.c.setText(b.a(paramj.c(), paramj.i()));
      this.b.a(paramj.k());
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */