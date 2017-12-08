package com.lantern.browser.comment.ui;

import android.os.AsyncTask;
import com.lantern.browser.comment.e.f;
import com.lantern.browser.comment.ui.a.a;
import com.lantern.browser.comment.ui.a.a.a;
import java.util.List;

final class i
  implements a.a
{
  i(WkCommentDetailFragment paramWkCommentDetailFragment) {}
  
  public final void a()
  {
    boolean bool = WkCommentDetailFragment.f(this.a).c(1);
    Object localObject = WkCommentDetailFragment.f(this.a).c();
    label63:
    int i;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = (com.lantern.browser.comment.d.i)((List)localObject).get(((List)localObject).size() - 1);
      if (localObject == null) {
        break label105;
      }
      localObject = ((com.lantern.browser.comment.d.i)localObject).e();
      if (localObject == null) {
        break label110;
      }
      i = ((com.lantern.browser.comment.d.j)localObject).m();
      label72:
      if (i > 1) {
        break label115;
      }
      WkCommentDetailFragment.f(this.a).c(2);
      WkCommentDetailFragment.g(this.a).notifyDataSetChanged();
    }
    for (;;)
    {
      return;
      localObject = null;
      break;
      label105:
      localObject = null;
      break label63;
      label110:
      i = 0;
      break label72;
      label115:
      if (bool) {
        WkCommentDetailFragment.g(this.a).notifyDataSetChanged();
      }
      new com.lantern.browser.comment.e.g(WkCommentDetailFragment.e(this.a), i, new j(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
  }
  
  public final void b()
  {
    if (WkCommentDetailFragment.f(this.a).d(1)) {
      WkCommentDetailFragment.g(this.a).notifyDataSetChanged();
    }
    new f(WkCommentDetailFragment.e(this.a), new k(this)).execute(new Void[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */