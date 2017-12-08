package com.linksure.apservice.integration.photochoose.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class b
  implements AdapterView.OnItemClickListener
{
  b(PhotoPickerFragment paramPhotoPickerFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((PhotoPickerFragment.a(this.a).a()) && (paramInt == 0)) {
      PhotoPickerFragment.b(this.a);
    }
    for (;;)
    {
      return;
      PhotoPickerFragment.a(this.a, PhotoPickerFragment.a(this.a).a(paramInt));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */