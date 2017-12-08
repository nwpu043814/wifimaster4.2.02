package com.linksure.apservice.ui.common.search;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.linksure.apservice.R.color;

final class e
  implements TextWatcher
{
  final int a = this.c.getResources().getColor(R.color.aps_white);
  final int b = this.c.getResources().getColor(R.color.aps_white_alpha);
  
  e(SearchFragment paramSearchFragment) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (TextUtils.isEmpty(paramEditable.toString().trim()))
    {
      SearchFragment.c(this.c).setClickable(true);
      SearchFragment.d(this.c).setVisibility(4);
      SearchFragment.d(this.c).setClickable(false);
    }
    for (;;)
    {
      return;
      SearchFragment.c(this.c).setClickable(false);
      SearchFragment.d(this.c).setVisibility(0);
      SearchFragment.d(this.c).setClickable(true);
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */