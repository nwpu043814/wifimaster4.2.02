package com.linksure.apservice.integration.photochoose.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.integration.photochoose.a.b;
import com.linksure.apservice.integration.photochoose.b.f;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private List<b> a;
  private Context b;
  private int c;
  private String d = null;
  
  public a(Context paramContext, List<b> paramList)
  {
    this.a = paramList;
    this.b = paramContext;
    this.c = f.a(paramContext, 90.0F);
    this.d = paramContext.getString(R.string.settings_photo_photos_num);
  }
  
  public final int getCount()
  {
    return this.a.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a((byte)0);
      paramView = LayoutInflater.from(this.b).inflate(R.layout.settings_photo_item_floder_layout, null);
      a.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.imageview_floder_img));
      a.a(paramViewGroup, (TextView)paramView.findViewById(R.id.textview_floder_name));
      a.b(paramViewGroup, (TextView)paramView.findViewById(R.id.textview_photo_num));
      a.b(paramViewGroup, (ImageView)paramView.findViewById(R.id.imageview_floder_select));
      a.a(paramViewGroup, paramView.findViewById(R.id.dividerLine));
      paramView.setTag(paramViewGroup);
      a.a(paramViewGroup).setVisibility(8);
      a.b(paramViewGroup).setImageResource(R.drawable.settings_photo_ic_photo_loading);
      b localb = (b)this.a.get(paramInt);
      if (localb.a()) {
        a.a(paramViewGroup).setVisibility(0);
      }
      a.c(paramViewGroup).setText(localb.b());
      a.d(paramViewGroup).setText(String.format(this.d, new Object[] { Integer.valueOf(localb.c().size()) }));
      if ((localb.c() != null) && (!localb.c().isEmpty())) {
        com.linksure.apservice.integration.photochoose.b.a.a().a(((com.linksure.apservice.integration.photochoose.a.a)localb.c().get(0)).a(), a.b(paramViewGroup), this.c);
      }
      if (paramInt != getCount() - 1) {
        break label286;
      }
      a.e(paramViewGroup).setVisibility(8);
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label286:
      a.e(paramViewGroup).setVisibility(0);
    }
  }
  
  private final class a
  {
    private ImageView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private View f;
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/ui/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */