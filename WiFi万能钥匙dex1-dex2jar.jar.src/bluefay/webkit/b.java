package bluefay.webkit;

import android.content.Context;
import android.content.res.Resources;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import bluefay.app.t;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.drawable;
import com.bluefay.widget.ActionTopBarView;

public final class b
  extends FrameLayout
{
  private ActionTopBarView a;
  private ProgressBar b;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.a = new ActionTopBarView(paramContext);
    addView(this.a);
    this.b = new ProgressBar(paramContext, null, 16842872);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, paramContext.getResources().getDimensionPixelSize(R.dimen.framework_small_horizontal_progress_height));
    localLayoutParams.gravity = 80;
    paramContext = paramContext.getResources().getDrawable(R.drawable.framework_webview_progress_transparent_horizontal);
    this.b.setProgressDrawable(paramContext);
    addView(this.b, localLayoutParams);
  }
  
  public final ActionTopBarView a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 100) {
      this.b.setVisibility(8);
    }
    for (;;)
    {
      return;
      if (this.b.getVisibility() == 8) {
        this.b.setVisibility(0);
      }
      this.b.setProgress(paramInt);
    }
  }
  
  public final void a(t paramt)
  {
    this.a.a(paramt);
  }
  
  public final void a(com.bluefay.widget.b paramb)
  {
    this.a.a(paramb);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public final void b(int paramInt)
  {
    this.a.h(paramInt);
  }
  
  public final void c(int paramInt)
  {
    this.a.i(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/webkit/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */