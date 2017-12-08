package com.lantern.browser.comment.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.style;

public final class g
  extends Dialog
{
  private a a;
  
  public g(Context paramContext)
  {
    super(paramContext, R.style.WkCommentFullScreenDialog);
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.dialog_comment_share);
    findViewById(R.id.commentDialogRoot).setOnClickListener(new h(this));
    findViewById(R.id.shareToFriend).setOnClickListener(new i(this));
    findViewById(R.id.shareToTimeLine).setOnClickListener(new j(this));
    findViewById(R.id.cancelShare).setOnClickListener(new k(this));
  }
  
  public final void show()
  {
    getWindow().setWindowAnimations(R.style.dialogWindowNoAnim);
    super.show();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */