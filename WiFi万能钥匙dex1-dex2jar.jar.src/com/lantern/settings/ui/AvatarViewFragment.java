package com.lantern.settings.ui;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.bluefay.a.e;
import com.lantern.base.ui.BaseFragment;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.lantern.settings.b.a;
import com.lantern.settings.widget.c.a;
import java.text.SimpleDateFormat;

public class AvatarViewFragment
  extends BaseFragment
{
  private String g;
  private Handler h;
  private SimpleDateFormat i;
  private c.a j = new d(this);
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.settings_fragment_avatar_view, null);
    paramViewGroup = (ImageView)paramLayoutInflater.findViewById(R.id.imageView);
    this.g = getArguments().getString("url");
    this.h = new Handler();
    if ((!TextUtils.isEmpty(this.g)) && (URLUtil.isNetworkUrl(this.g)))
    {
      a.a(this.h, this.g, false, new b(this, paramViewGroup));
      paramViewGroup.setOnLongClickListener(new c(this));
    }
    for (;;)
    {
      a(R.string.settings_avatar);
      return paramLayoutInflater;
      e.a(R.string.settings_tips_picture_url_error);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/AvatarViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */