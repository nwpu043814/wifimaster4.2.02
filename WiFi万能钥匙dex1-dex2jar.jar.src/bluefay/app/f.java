package bluefay.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

final class f
  implements View.OnClickListener
{
  f(e parame) {}
  
  public final void onClick(View paramView)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramView == e.a(this.a)) && (e.b(this.a) != null)) {
      localObject1 = Message.obtain(e.b(this.a));
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Message)localObject1).sendToTarget();
      }
      e.h(this.a).obtainMessage(1, e.g(this.a)).sendToTarget();
      return;
      if ((paramView == e.c(this.a)) && (e.d(this.a) != null))
      {
        localObject1 = Message.obtain(e.d(this.a));
      }
      else
      {
        localObject1 = localObject2;
        if (paramView == e.e(this.a))
        {
          localObject1 = localObject2;
          if (e.f(this.a) != null) {
            localObject1 = Message.obtain(e.f(this.a));
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */