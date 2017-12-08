package com.linksure.apservice.ui.profile;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.u;
import bluefay.support.annotation.Nullable;
import com.bluefay.widget.ActionTopBarView;
import com.linksure.apservice.R.array;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.a;
import com.linksure.apservice.a.i;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import com.linksure.apservice.utils.f;
import com.linksure.apservice.utils.f.a;

public class ComplainFragment
  extends InterceptorFragment
  implements View.OnClickListener, a.b
{
  private a g;
  private d i;
  private ListView j;
  private EditText k;
  private a l;
  private ScrollView m;
  private String n;
  private f.a o = new b(this);
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Toast.makeText(getActivity(), R.string.aps_complain_i_success, 0).show();
      getFragmentManager().popBackStack();
    }
    for (;;)
    {
      return;
      Toast.makeText(getActivity(), R.string.aps_complain_w_fail, 0).show();
    }
  }
  
  final void d(int paramInt)
  {
    this.l.a(paramInt);
    this.l.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (paramView.getId() == R.id.aps_complain_submit)
    {
      i1 = this.l.a();
      paramView = this.k.getText().toString();
      if (i1 != -1) {
        break label49;
      }
      Toast.makeText(getActivity(), R.string.aps_complain_w_type, 0).show();
    }
    for (;;)
    {
      return;
      label49:
      if (TextUtils.isEmpty(paramView)) {
        Toast.makeText(getActivity(), R.string.aps_complain_w_content, 0).show();
      } else if (this.i != null) {
        this.i.a(this.n, i1 + 1, paramView);
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(R.string.aps_complain);
    b().b(0);
    a(a, new u(getActivity()));
    this.g = i.a(getActivity());
    this.i = new d(this, this.g);
    a(this.i);
    f.a(getActivity(), this.o);
    this.n = getArguments().getString("id");
    paramBundle = getResources().getStringArray(R.array.aps_complain_types);
    this.l = new a(getActivity(), paramBundle);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_complain, null);
    this.m = ((ScrollView)paramLayoutInflater.findViewById(R.id.aps_scrollview));
    this.j = ((ListView)paramLayoutInflater.findViewById(R.id.aps_complain_list));
    this.j.setAdapter(this.l);
    this.j.setOnItemClickListener(new c(this));
    this.k = ((EditText)paramLayoutInflater.findViewById(R.id.aps_complain_content));
    paramLayoutInflater.findViewById(R.id.aps_complain_submit).setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  static final class a
    extends BaseAdapter
  {
    private String[] a = new String[0];
    private int b = -1;
    private Context c;
    
    public a(Context paramContext, String[] paramArrayOfString)
    {
      this.c = paramContext;
      this.a = paramArrayOfString;
    }
    
    public final int a()
    {
      return this.b;
    }
    
    public final void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public final int getCount()
    {
      return this.a.length;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = LayoutInflater.from(this.c).inflate(R.layout.aps_listitem_complain, null);
      }
      TextView localTextView = (TextView)paramViewGroup.findViewById(R.id.aps_listitem_complain_text);
      ImageView localImageView = (ImageView)paramViewGroup.findViewById(R.id.aps_listitem_checker);
      paramView = paramViewGroup.findViewById(R.id.aps_listitem_divider);
      localTextView.setText(this.a[paramInt]);
      if (paramInt == this.b)
      {
        localImageView.setVisibility(0);
        if (paramInt != 0) {
          break label98;
        }
        paramView.setVisibility(4);
      }
      for (;;)
      {
        return paramViewGroup;
        localImageView.setVisibility(4);
        break;
        label98:
        paramView.setVisibility(0);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/ComplainFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */