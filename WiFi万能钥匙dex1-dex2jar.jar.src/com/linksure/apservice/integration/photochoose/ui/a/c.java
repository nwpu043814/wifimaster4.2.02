package com.linksure.apservice.integration.photochoose.ui.a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.string;
import java.util.List;

final class c
  implements View.OnClickListener
{
  c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    String str = paramView.findViewById(R.id.imageview_photo).getTag().toString();
    if (b.a(this.a).contains(str))
    {
      paramView.findViewById(R.id.mask).setVisibility(8);
      paramView.findViewById(R.id.checkmark).setSelected(false);
      b.a(this.a).remove(str);
    }
    for (;;)
    {
      if (b.d(this.a) != null) {
        b.d(this.a).d();
      }
      for (;;)
      {
        return;
        if (b.a(this.a).size() < b.b(this.a)) {
          break;
        }
        Toast.makeText(b.c(this.a), R.string.settings_photo_msg_maxi_capacity, 0).show();
      }
      b.a(this.a).add(str);
      paramView.findViewById(R.id.mask).setVisibility(0);
      paramView.findViewById(R.id.checkmark).setSelected(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */