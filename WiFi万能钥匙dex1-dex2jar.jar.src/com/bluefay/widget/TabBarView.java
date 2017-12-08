package com.bluefay.widget;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import java.util.ArrayList;
import java.util.HashMap;

public class TabBarView
  extends LinearLayout
  implements View.OnClickListener
{
  private FragmentManager a;
  private h b;
  private HashMap<String, g> c = new HashMap();
  private ArrayList<g> d = new ArrayList();
  private g e;
  
  public TabBarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TabBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    b((g)this.d.get(paramInt));
  }
  
  private void b(g paramg)
  {
    FragmentTransaction localFragmentTransaction = null;
    if (this.a != null) {
      localFragmentTransaction = this.a.beginTransaction().disallowAddToBackStack();
    }
    if (this.e == paramg) {
      if (this.b != null) {
        this.b.a(this.e);
      }
    }
    for (;;)
    {
      if ((localFragmentTransaction != null) && (!localFragmentTransaction.isEmpty())) {
        localFragmentTransaction.commitAllowingStateLoss();
      }
      return;
      if (this.e != null)
      {
        View localView = findViewWithTag(this.e);
        if (localView != null) {
          localView.setSelected(false);
        }
        if (this.b != null) {
          this.b.b(this.e, localFragmentTransaction);
        }
      }
      this.e = paramg;
      if (this.e != null)
      {
        paramg = findViewWithTag(this.e);
        if (paramg != null) {
          paramg.setSelected(true);
        }
        if (this.b != null) {
          this.b.a(this.e, localFragmentTransaction);
        }
      }
    }
  }
  
  public final g a()
  {
    return this.e;
  }
  
  public final void a(int paramInt, g paramg)
  {
    if (!this.c.containsKey(paramg.c()))
    {
      View localView = LayoutInflater.from(getContext()).inflate(R.layout.framework_tab_item, this, false);
      localView.setTag(paramg);
      TextView localTextView = (TextView)localView.findViewById(R.id.tab_text);
      Object localObject = (ImageView)localView.findViewById(R.id.tab_image);
      localTextView.setText(paramg.a());
      ((ImageView)localObject).setImageDrawable(paramg.b());
      localView.setOnClickListener(this);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      addView(localView, paramInt, (ViewGroup.LayoutParams)localObject);
      this.c.put(paramg.c(), paramg);
      this.d.add(paramInt, paramg);
    }
  }
  
  public final void a(FragmentManager paramFragmentManager)
  {
    this.a = paramFragmentManager;
  }
  
  public final void a(g paramg)
  {
    if (!this.c.containsKey(paramg.c()))
    {
      View localView = LayoutInflater.from(getContext()).inflate(R.layout.framework_tab_item, this, false);
      localView.setTag(paramg);
      Object localObject = (TextView)localView.findViewById(R.id.tab_text);
      ImageView localImageView = (ImageView)localView.findViewById(R.id.tab_image);
      ((TextView)localObject).setText(paramg.a());
      localImageView.setImageDrawable(paramg.b());
      localView.setOnClickListener(this);
      localObject = new LinearLayout.LayoutParams(-1, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      addView(localView, (ViewGroup.LayoutParams)localObject);
      this.c.put(paramg.c(), paramg);
      this.d.add(paramg);
    }
  }
  
  public final void a(h paramh)
  {
    this.b = paramh;
  }
  
  public final void a(String paramString)
  {
    int i;
    if (this.c.containsKey(paramString))
    {
      paramString = (g)this.c.remove(paramString);
      i = 0;
      if (i >= this.d.size()) {
        break label96;
      }
      if (this.d.get(i) != paramString) {
        break label90;
      }
      label48:
      this.d.remove(i);
      removeViewAt(i);
      if ((this.e != null) && (paramString == this.e))
      {
        if (i <= 1) {
          break label101;
        }
        a(i - 1);
      }
    }
    for (;;)
    {
      return;
      label90:
      i++;
      break;
      label96:
      i = -1;
      break label48;
      label101:
      a(0);
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    Object localObject = findViewWithTag(this.c.get(paramString));
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramString = (TextView)((View)localObject).findViewById(R.id.tab_text);
      localObject = (ImageView)((View)localObject).findViewById(R.id.tab_image);
      paramString.setText(paramInt);
      ((ImageView)localObject).setImageResource(2130838342);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Object localObject = findViewWithTag(this.c.get(paramString1));
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramString1 = (TextView)((View)localObject).findViewById(R.id.tab_text_unread);
      localObject = (ImageView)((View)localObject).findViewById(R.id.tab_text_unread_dot);
      if (paramString2 == null)
      {
        paramString1.setVisibility(4);
        ((ImageView)localObject).setVisibility(4);
      }
      else if (paramString2.equals("-1"))
      {
        paramString1.setVisibility(4);
        ((ImageView)localObject).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject).setVisibility(4);
        paramString1.setText(paramString2);
        paramString1.setVisibility(0);
      }
    }
  }
  
  public final int b(String paramString)
  {
    paramString = findViewWithTag(this.c.get(paramString));
    int i;
    if (paramString == null) {
      i = -2;
    }
    for (;;)
    {
      return i;
      TextView localTextView = (TextView)paramString.findViewById(R.id.tab_text_unread);
      if (((ImageView)paramString.findViewById(R.id.tab_text_unread_dot)).getVisibility() == 0)
      {
        i = -1;
      }
      else if (localTextView.getVisibility() == 4)
      {
        i = 0;
      }
      else
      {
        paramString = localTextView.getText().toString();
        if ("...".equals(paramString)) {
          i = 100;
        } else if ("new".equalsIgnoreCase(paramString)) {
          i = -1;
        } else {
          try
          {
            i = Integer.parseInt(paramString);
          }
          catch (NumberFormatException paramString)
          {
            i = 0;
          }
        }
      }
    }
  }
  
  public final void c(String paramString)
  {
    b((g)this.c.get(paramString));
  }
  
  public void onClick(View paramView)
  {
    b((g)paramView.getTag());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/TabBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */