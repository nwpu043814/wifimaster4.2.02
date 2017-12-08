package com.linksure.apservice.integration.photochoose.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.TextView;
import com.linksure.apservice.R.string;
import com.linksure.apservice.integration.photochoose.b.f;
import com.linksure.apservice.integration.photochoose.ui.a.a;
import java.util.Iterator;
import java.util.List;

final class c
  implements AdapterView.OnItemClickListener
{
  c(PhotoPickerFragment paramPhotoPickerFragment, List paramList, a parama) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramView = (com.linksure.apservice.integration.photochoose.a.b)this.a.get(paramInt);
    if (paramView.a()) {
      return;
    }
    paramAdapterView = this.a.iterator();
    while (paramAdapterView.hasNext()) {
      ((com.linksure.apservice.integration.photochoose.a.b)paramAdapterView.next()).a(false);
    }
    paramView.a(true);
    this.b.notifyDataSetChanged();
    PhotoPickerFragment.c(this.c).clear();
    PhotoPickerFragment.c(this.c).addAll(paramView.c());
    if (PhotoPickerFragment.e().equals(paramView.b())) {
      PhotoPickerFragment.a(this.c).a(PhotoPickerFragment.d(this.c));
    }
    for (;;)
    {
      PhotoPickerFragment.a(this.c).c();
      PhotoPickerFragment.e(this.c);
      PhotoPickerFragment.f(this.c).setAdapter(PhotoPickerFragment.a(this.c));
      PhotoPickerFragment.h(this.c).setText(f.a(PhotoPickerFragment.g(this.c), R.string.settings_photo_photos_num, new Object[] { Integer.valueOf(PhotoPickerFragment.c(this.c).size()) }));
      PhotoPickerFragment.i(this.c).setText(paramView.b());
      PhotoPickerFragment.j(this.c);
      break;
      PhotoPickerFragment.a(this.c).a(false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */