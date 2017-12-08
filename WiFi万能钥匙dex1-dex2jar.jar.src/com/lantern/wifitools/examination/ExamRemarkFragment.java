package com.lantern.wifitools.examination;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;

public class ExamRemarkFragment
  extends Fragment
{
  private EditText g;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(getString(R.string.exam_device_remark));
    b().a(null);
    paramLayoutInflater = new u(this.e);
    paramLayoutInflater.add(101, 1001, 0, "Save").setTitle(getString(R.string.exam_device_save));
    a(a, paramLayoutInflater);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(R.layout.wifitools_exam_remark, paramViewGroup, false);
    this.g = ((EditText)paramViewGroup.findViewById(R.id.editText));
    paramLayoutInflater = getArguments().getString("display_value");
    if (!TextUtils.isEmpty(paramLayoutInflater)) {
      this.g.setText(paramLayoutInflater);
    }
    return paramViewGroup;
  }
  
  public void onDestroyView()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
    if ((getActivity() != null) && (getActivity().getCurrentFocus() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
    }
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject;
    String str;
    if (paramMenuItem.getItemId() == 1001)
    {
      localObject = getActivity().getSharedPreferences("device_remark", 0);
      str = getArguments().getString("mac");
      if ((localObject != null) && (!TextUtils.isEmpty(str)))
      {
        localObject = ((SharedPreferences)localObject).edit();
        if (TextUtils.isEmpty(this.g.getText())) {
          break label98;
        }
        ((SharedPreferences.Editor)localObject).putString(str, this.g.getText().toString());
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      a();
      return super.onOptionsItemSelected(paramMenuItem);
      label98:
      ((SharedPreferences.Editor)localObject).putString(str, getArguments().getString("default_value"));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.g.requestFocus();
    ((InputMethodManager)getActivity().getSystemService("input_method")).showSoftInput(this.g, 2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/ExamRemarkFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */