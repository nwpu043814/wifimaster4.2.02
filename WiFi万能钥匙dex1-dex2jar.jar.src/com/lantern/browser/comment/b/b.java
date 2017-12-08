package com.lantern.browser.comment.b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.R.style;
import com.lantern.browser.comment.ui.WkCommentAvatarView;
import com.lantern.core.p;

public final class b
  extends Dialog
{
  private EditText a;
  private TextView b;
  private TextView c;
  private WkCommentAvatarView d;
  private TextView e;
  private a f;
  
  public b(Context paramContext)
  {
    super(paramContext, R.style.WkCommentInputDialog);
  }
  
  public final void a()
  {
    if (this.b != null) {
      this.b.setClickable(false);
    }
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(String paramString)
  {
    getWindow().setWindowAnimations(R.style.dialogWindowNoAnim);
    super.show();
    if (TextUtils.isEmpty(paramString)) {
      this.a.setHint(R.string.comment_input_hint);
    }
    for (;;)
    {
      return;
      this.a.setHint(paramString);
    }
  }
  
  public final void b()
  {
    h.a("onWriteCommentCallback aRetCd:0 aResult:" + null, new Object[0]);
    this.b.setClickable(true);
    this.a.setText("");
    com.lantern.browser.c.b.a(getContext(), R.drawable.comment_sent_succes, R.string.comment_send_success);
  }
  
  public final void dismiss()
  {
    com.lantern.browser.c.b.b(getContext(), this.a);
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.dialog_comment_input);
    this.a = ((EditText)findViewById(R.id.commentInput));
    this.a.addTextChangedListener(new c(this));
    this.b = ((TextView)findViewById(R.id.commentInputSubmit));
    this.c = ((TextView)findViewById(R.id.commentInputTip));
    this.d = ((WkCommentAvatarView)findViewById(R.id.userAvatar));
    this.e = ((TextView)findViewById(R.id.userNickName));
    paramBundle = new d(this);
    this.d.setOnClickListener(paramBundle);
    this.e.setOnClickListener(paramBundle);
    findViewById(R.id.commentDialogRoot).setOnClickListener(new e(this));
    this.b.setOnClickListener(new f(this));
    this.b.setClickable(false);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    Context localContext = getContext();
    if (paramBoolean) {
      if (this.e != null)
      {
        if (p.a()) {
          break label46;
        }
        this.e.setVisibility(8);
        this.d.setVisibility(8);
      }
    }
    for (;;)
    {
      super.onWindowFocusChanged(paramBoolean);
      return;
      label46:
      this.e.setVisibility(0);
      this.d.setVisibility(0);
      String str = p.d(localContext);
      this.e.setText(com.lantern.browser.c.b.a(str, p.c("")));
      str = p.e(localContext);
      if (!TextUtils.isEmpty(str))
      {
        this.d.a(str);
      }
      else
      {
        this.d.a(R.drawable.news_comment_head_pic);
        continue;
        com.lantern.browser.c.b.b(localContext, this.a);
      }
    }
  }
  
  public final void show()
  {
    a(null);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */