package com.lantern.browser;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import bluefay.app.k;
import com.bluefay.a.e;
import com.lantern.core.favorite.IWkAPI;
import com.lantern.core.favorite.SendMessageToWk.Req;
import com.lantern.core.favorite.WkAPIFactory;
import com.lantern.core.favorite.WkSceneFavorite;
import java.util.List;

final class ax
  implements AdapterView.OnItemClickListener
{
  ax(at paramat, List paramList) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.a.get(paramInt);
    if ((paramAdapterView.equals(this.b.getResources().getString(R.string.browser_pop_open_link))) || (paramAdapterView.equals(this.b.getResources().getString(R.string.browser_pop_open_img)))) {
      this.b.c(at.g(this.b));
    }
    for (;;)
    {
      if (at.i(this.b) != null)
      {
        at.i(this.b).hide();
        at.i(this.b).dismiss();
        at.j(this.b);
      }
      return;
      if (paramAdapterView.equals(this.b.getResources().getString(R.string.browser_pop_copy_link)))
      {
        ((ClipboardManager)at.d(this.b).getSystemService("clipboard")).setText(at.g(this.b));
        Toast.makeText(at.d(this.b), R.string.browser_tip_copylink, 0).show();
      }
      else if (paramAdapterView.equals(this.b.getResources().getString(R.string.browser_pop_save)))
      {
        paramAdapterView = n.b();
        at.h(this.b);
        paramAdapterView.a(at.g(this.b), true);
      }
      else if (paramAdapterView.equals(this.b.getResources().getString(R.string.browser_pop_favorite)))
      {
        paramAdapterView = WkAPIFactory.createIWkAPI(at.d(this.b));
        paramView = new WkSceneFavorite();
        paramView.srcName = at.h(this.b).getTitle();
        paramView.contentType = "image/jpeg";
        paramView.category = "image";
        paramView.favTime = System.currentTimeMillis();
        paramView.contentSrc = at.g(this.b);
        paramView.thumbnailLink = at.g(this.b);
        SendMessageToWk.Req localReq = new SendMessageToWk.Req();
        localReq.mData = paramView;
        paramAdapterView.sendReq(localReq);
        e.a(R.string.browser_fav_success);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */