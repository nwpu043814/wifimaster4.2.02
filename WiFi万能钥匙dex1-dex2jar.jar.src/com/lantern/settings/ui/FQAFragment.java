package com.lantern.settings.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import bluefay.app.Fragment;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public class FQAFragment
  extends Fragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(R.layout.settings_about_webview, paramViewGroup, false);
    a(R.string.settings_web_fqa_title);
    paramLayoutInflater = (WebView)paramBundle.findViewById(R.id.settings_webview_html);
    paramLayoutInflater.setScrollBarStyle(33554432);
    paramLayoutInflater.setOnLongClickListener(new n(this));
    paramViewGroup = paramBundle.getResources().getString(R.string.settings_web_fqa_file_name);
    paramLayoutInflater.loadUrl("file:///android_asset/html/" + paramViewGroup);
    return paramBundle;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/FQAFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */