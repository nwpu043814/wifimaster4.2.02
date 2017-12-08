package com.lantern.settings.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import bluefay.app.Fragment;
import com.bluefay.a.c;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import java.util.Locale;

@Deprecated
public class IntroductFragment
  extends Fragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(R.layout.settings_about_webview, paramViewGroup, false);
    a(R.string.settings_web_product_introduct_title);
    paramViewGroup = (WebView)paramBundle.findViewById(R.id.settings_webview_html);
    paramViewGroup.setScrollBarStyle(33554432);
    paramViewGroup.setOnLongClickListener(new v(this));
    paramViewGroup.getSettings().setJavaScriptEnabled(true);
    String str = paramBundle.getResources().getString(R.string.settings_web_product_introduct_file_name);
    int i = c.b(this.e);
    paramLayoutInflater = Locale.getDefault().getLanguage();
    if (TextUtils.isEmpty(paramLayoutInflater)) {
      paramLayoutInflater = "zh";
    }
    for (;;)
    {
      paramViewGroup.loadUrl("file:///android_asset/html/" + str + "?ver=" + i + "&lang=" + paramLayoutInflater);
      return paramBundle;
      if (paramLayoutInflater.equalsIgnoreCase("zh")) {
        paramLayoutInflater = "zh";
      } else {
        paramLayoutInflater = "en";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/IntroductFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */