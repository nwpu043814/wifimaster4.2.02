package com.lantern.settings.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import bluefay.app.u;
import com.lantern.base.ui.BaseFragment;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.lantern.settings.a.f;
import java.util.regex.Pattern;

public class EditUserNameFragment
  extends BaseFragment
{
  private EditText g;
  private Intent h;
  private String i;
  private int j;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = getActivity().getIntent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.settings_fragment_edit_username, paramViewGroup, false);
    a(R.string.settings_user_info_edit_nickname);
    b(-1);
    paramViewGroup = new u(getActivity());
    paramViewGroup.add(101, 1001, 0, R.string.settings_user_info_save).setTitle(R.string.settings_user_info_save);
    a(a, paramViewGroup);
    this.g = ((EditText)paramLayoutInflater.findViewById(R.id.editText));
    this.i = this.h.getStringExtra("INTENT_KEY_USER_NAME");
    this.j = this.h.getIntExtra("from", 0);
    this.g.setText(this.i);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    Activity localActivity = getActivity();
    try
    {
      ((InputMethodManager)localActivity.getSystemService("input_method")).hideSoftInputFromWindow(localActivity.getCurrentFocus().getWindowToken(), 0);
      super.onDestroyView();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = false;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      try
      {
        String str = this.g.getText().toString().trim();
        if (!com.lantern.settings.b.e.a(str)) {
          break label184;
        }
        if (str != null) {
          bool = Pattern.matches("^[A-Za-z0-9一-龥_\\-]{1,16}$", str);
        }
        if (!bool) {
          break label175;
        }
        if (str.equals(this.i)) {
          break label135;
        }
        a(getString(R.string.settings_user_info_submit_nickname));
        localObject = new com/lantern/settings/a/f;
        m localm = new com/lantern/settings/ui/m;
        localm.<init>(this, str);
        ((f)localObject).<init>(str, null, localm);
        ((f)localObject).execute(new Void[0]);
      }
      catch (Exception localException) {}
      continue;
      label135:
      Object localObject = getActivity();
      if (localObject != null)
      {
        this.h.putExtra("INTENT_KEY_USER_NAME", localException);
        ((Activity)localObject).setResult(-1, this.h);
        ((Activity)localObject).finish();
        continue;
        label175:
        com.bluefay.a.e.a(R.string.settings_user_info_nickname_is_not_validate);
        continue;
        label184:
        com.bluefay.a.e.a(R.string.settings_user_info_nickname_is_not_allow_empty);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivity();
    paramBundle = this.g;
    try
    {
      paramBundle.requestFocus();
      ((InputMethodManager)paramView.getSystemService("input_method")).showSoftInput(paramBundle, 2);
      return;
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/EditUserNameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */