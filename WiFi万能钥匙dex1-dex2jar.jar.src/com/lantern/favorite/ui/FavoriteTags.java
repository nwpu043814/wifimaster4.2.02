package com.lantern.favorite.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import bluefay.app.m;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.flowlayout.TagFlowLayout;
import com.qihoo.util.StubApp1053578832;
import java.util.ArrayList;
import org.json.JSONArray;

public class FavoriteTags
  extends m
  implements View.OnClickListener, TextView.OnEditorActionListener
{
  private ArrayList<String> e = new ArrayList();
  private EditText f;
  private TagFlowLayout g;
  private com.lantern.favorite.flowlayout.a<String> h;
  private com.lantern.favorite.a i;
  private WkSceneFavorite j;
  private TextView k;
  
  static
  {
    StubApp1053578832.interface11(21);
  }
  
  private boolean g()
  {
    Object localObject = this.f.getText().toString().trim();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!this.e.contains(localObject)))
    {
      this.e.add(this.e.size() - 1, localObject);
      this.h.c();
    }
    localObject = new JSONArray();
    for (int m = 0; m < this.e.size() - 1; m++) {
      ((JSONArray)localObject).put(this.e.get(m));
    }
    if (((JSONArray)localObject).toString().equals("[]")) {}
    for (localObject = "";; localObject = ((JSONArray)localObject).toString())
    {
      this.j.tags = ((String)localObject);
      this.j.syncState = 0;
      this.i.c(this.j);
      this.f.requestFocus();
      this.f.requestFocusFromTouch();
      this.f.setText("");
      return true;
    }
  }
  
  public final int a(float paramFloat)
  {
    return (int)(getApplicationContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public final void f()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.f, 0);
  }
  
  public void onClick(View paramView)
  {
    this.g.a();
    this.f.requestFocus();
    this.f.requestFocusFromTouch();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public void onDestroy()
  {
    this.i.c();
    super.onDestroy();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return g();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("tag", this.j.tags);
      setResult(1002, localIntent);
      finish();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1001)
    {
      com.lantern.analytics.a.e().onEvent("favtag");
      g();
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("tag", this.j.tags);
    setResult(1002, localIntent);
    finish();
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    new Handler().postDelayed(new n(this), 300L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */