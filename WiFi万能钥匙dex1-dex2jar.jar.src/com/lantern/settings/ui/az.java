package com.lantern.settings.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;

final class az
  implements AdapterView.OnItemSelectedListener
{
  az(UrlTestActivity paramUrlTestActivity) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView.setVisibility(8);
    UrlTestActivity.a(this.a).setText(((String)this.a.a.getItem(paramInt)).toString());
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */