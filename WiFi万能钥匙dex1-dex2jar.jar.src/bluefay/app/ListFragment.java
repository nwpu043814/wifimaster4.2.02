package bluefay.app;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;

public class ListFragment
  extends Fragment
{
  ListAdapter g;
  ListView h;
  View i;
  TextView j;
  View k;
  View l;
  CharSequence m;
  boolean n;
  private final Handler o = new Handler();
  private final Runnable p = new r(this);
  private final AdapterView.OnItemClickListener q = new s(this);
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.k == null) {
      throw new IllegalStateException("Can't be used with a custom content view");
    }
    if (this.n == paramBoolean1) {
      return;
    }
    this.n = paramBoolean1;
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        this.k.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
        this.l.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
      }
      for (;;)
      {
        this.k.setVisibility(8);
        this.k.findViewById(R.id.progressbar).setVisibility(8);
        this.l.setVisibility(0);
        break;
        this.k.clearAnimation();
        this.l.clearAnimation();
      }
    }
    if (paramBoolean2)
    {
      this.k.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432576));
      this.l.startAnimation(AnimationUtils.loadAnimation(getActivity(), 17432577));
    }
    for (;;)
    {
      this.k.setVisibility(0);
      this.k.findViewById(R.id.progressbar).setVisibility(0);
      this.l.setVisibility(8);
      break;
      this.k.clearAnimation();
      this.l.clearAnimation();
    }
  }
  
  public static void c() {}
  
  protected final void d()
  {
    boolean bool = false;
    Object localObject = getView();
    if (localObject == null) {
      throw new IllegalStateException("Content view not yet created");
    }
    int i1;
    if ((localObject instanceof ListView))
    {
      this.h = ((ListView)localObject);
      this.n = true;
      this.h.setOnItemClickListener(this.q);
      if (this.g == null) {
        break label312;
      }
      localObject = this.g;
      this.g = null;
      if (this.g == null) {
        break label307;
      }
      i1 = 1;
      label78:
      this.g = ((ListAdapter)localObject);
      if (this.h != null)
      {
        this.h.setAdapter((ListAdapter)localObject);
        if ((!this.n) && (i1 == 0))
        {
          if (getView().getWindowToken() != null) {
            bool = true;
          }
          a(true, bool);
        }
      }
    }
    for (;;)
    {
      this.o.post(this.p);
      return;
      this.j = ((TextView)((View)localObject).findViewById(R.id.internalEmpty));
      if (this.j == null) {
        this.i = ((View)localObject).findViewById(16908292);
      }
      for (;;)
      {
        this.k = ((View)localObject).findViewById(R.id.progressContainer);
        this.l = ((View)localObject).findViewById(R.id.listContainer);
        localObject = ((View)localObject).findViewById(16908298);
        if ((localObject instanceof ListView)) {
          break;
        }
        throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        this.j.setVisibility(8);
      }
      this.h = ((ListView)localObject);
      if (this.h == null) {
        throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
      }
      if (this.i != null)
      {
        this.h.setEmptyView(this.i);
        break;
      }
      if (this.m == null) {
        break;
      }
      this.j.setText(this.m);
      this.h.setEmptyView(this.j);
      break;
      label307:
      i1 = 0;
      break label78;
      label312:
      if (this.k != null) {
        a(false, false);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.framework_list_content, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    this.o.removeCallbacks(this.p);
    this.n = false;
    this.l = null;
    this.k = null;
    this.i = null;
    this.j = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/ListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */