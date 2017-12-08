package com.lantern.favorite.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bluefay.app.k;
import bluefay.app.m;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.R.array;
import com.lantern.favorite.R.color;
import com.lantern.favorite.R.id;
import com.lantern.favorite.R.layout;
import com.lantern.favorite.R.string;
import com.lantern.favorite.a;
import com.lantern.favorite.widget.PhotoView;
import com.lantern.favorite.widget.WkListView;
import com.qihoo.util.StubApp1053578832;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import org.json.JSONArray;

public class FavoriteDetails
  extends m
  implements View.OnClickListener, View.OnLongClickListener
{
  private boolean e;
  private ImageView f;
  private TextView g;
  private TextView h;
  private Button i;
  private PhotoView j;
  private TextView k;
  private a l;
  private WkSceneFavorite m;
  private PhotoView n;
  
  static
  {
    StubApp1053578832.interface11(18);
  }
  
  private void f()
  {
    Intent localIntent = new Intent(this, FavoriteTags.class);
    localIntent.putExtra("favId", this.m.favId);
    startActivityForResult(localIntent, 0);
  }
  
  private void g()
  {
    if (this.e) {
      this.n.a(this.j.b(), new g(this));
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("tag", this.m.tags);
      setResult(1002, localIntent);
      finish();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getStringExtra("tag");
      this.m.tags = ((String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("[]"))) {
        break label74;
      }
      this.i.setText(R.string.det_tags);
      this.i.setTextColor(getResources().getColor(R.color.fav_det_tag));
    }
    for (;;)
    {
      return;
      try
      {
        label74:
        paramIntent = new org/json/JSONArray;
        paramIntent.<init>((String)localObject);
        paramInt2 = paramIntent.length();
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
          ((StringBuilder)localObject).append((String)paramIntent.get(paramInt1)).append(", ");
        }
        ((StringBuilder)localObject).replace(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length(), "");
        this.i.setText(((StringBuilder)localObject).toString());
        this.i.setTextColor(getResources().getColor(R.color.framework_primary_color));
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == R.id.det_tags) {
      f();
    }
    for (;;)
    {
      return;
      if (i1 == R.id.det_thumbnailLink)
      {
        if (this.j.getDrawable() != null)
        {
          this.e = true;
          this.j.setVisibility(8);
          this.n.setVisibility(0);
          this.n.a(this.j.b());
        }
      }
      else {
        this.n.a(this.j.b(), new f(this));
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    this.l.c();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      g();
    }
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    paramView = getResources().getStringArray(R.array.photo_save);
    k localk = new k(this, 0);
    WkListView localWkListView = new WkListView(this, new h(this, localk));
    localWkListView.a(R.layout.layout_dialog, R.id.fav_item_view, paramView);
    localk.a(localWkListView);
    localk.show();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      g();
    }
    for (;;)
    {
      return false;
      WkWeiXinUtil.shareToWeiXin(0, this.m.contentSrc, this.m.srcName, "", this.m.thumbnailLink);
      continue;
      WkWeiXinUtil.shareToWeiXin(1, this.m.contentSrc, this.m.srcName, "", this.m.thumbnailLink);
      continue;
      f();
      continue;
      this.m.state = 2;
      this.m.syncState = 0;
      this.l.c(this.m);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("favId", this.m.favId);
      setResult(1001, paramMenuItem);
      finish();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */