package bluefay.preference;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.drawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class o
  extends BaseAdapter
  implements Preference.a
{
  private PreferenceGroup a;
  private List<Preference> b;
  private ArrayList<b> c;
  private b d = new b((byte)0);
  private boolean e = false;
  private volatile boolean f = false;
  private Handler g = new Handler();
  private int[] h;
  private Runnable i = new p(this);
  
  public o(PreferenceGroup paramPreferenceGroup)
  {
    this.a = paramPreferenceGroup;
    this.a.a(this);
    this.b = new ArrayList();
    this.c = new ArrayList();
    c();
  }
  
  private Preference a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {}
    for (Preference localPreference = null;; localPreference = (Preference)this.b.get(paramInt)) {
      return localPreference;
    }
  }
  
  private static b a(Preference paramPreference, b paramb)
  {
    if (paramb != null) {}
    for (;;)
    {
      b.a(paramb, paramPreference.getClass().getName());
      b.a(paramb, paramPreference.n());
      b.b(paramb, paramPreference.p());
      return paramb;
      paramb = new b((byte)0);
    }
  }
  
  private void a(List<Preference> paramList, PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.e();
    int k = paramPreferenceGroup.b();
    for (int j = 0; j < k; j++)
    {
      Preference localPreference = paramPreferenceGroup.a(j);
      paramList.add(localPreference);
      Object localObject;
      if ((!this.e) && (localPreference.E()))
      {
        localObject = a(localPreference, null);
        int m = Collections.binarySearch(this.c, localObject);
        if (m < 0) {
          this.c.add(m * -1 - 1, localObject);
        }
      }
      if ((localPreference instanceof PreferenceGroup))
      {
        localObject = (PreferenceGroup)localPreference;
        if (((PreferenceGroup)localObject).c()) {
          a(paramList, (PreferenceGroup)localObject);
        }
      }
      localPreference.a(this);
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	bluefay/preference/o:f	Z
    //   6: ifeq +6 -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: iconst_1
    //   14: putfield 43	bluefay/preference/o:f	Z
    //   17: aload_0
    //   18: monitorexit
    //   19: new 64	java/util/ArrayList
    //   22: dup
    //   23: aload_0
    //   24: getfield 67	bluefay/preference/o:b	Ljava/util/List;
    //   27: invokeinterface 148 1 0
    //   32: invokespecial 151	java/util/ArrayList:<init>	(I)V
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: aload_0
    //   39: getfield 57	bluefay/preference/o:a	Lbluefay/preference/PreferenceGroup;
    //   42: invokespecial 142	bluefay/preference/o:a	(Ljava/util/List;Lbluefay/preference/PreferenceGroup;)V
    //   45: aload_0
    //   46: aload_1
    //   47: putfield 67	bluefay/preference/o:b	Ljava/util/List;
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 67	bluefay/preference/o:b	Ljava/util/List;
    //   55: invokestatic 154	bluefay/preference/o$a:a	(Ljava/util/List;)[I
    //   58: putfield 156	bluefay/preference/o:h	[I
    //   61: aload_0
    //   62: invokevirtual 159	bluefay/preference/o:notifyDataSetChanged	()V
    //   65: aload_0
    //   66: monitorenter
    //   67: aload_0
    //   68: iconst_0
    //   69: putfield 43	bluefay/preference/o:f	Z
    //   72: aload_0
    //   73: invokevirtual 162	java/lang/Object:notifyAll	()V
    //   76: aload_0
    //   77: monitorexit
    //   78: goto -67 -> 11
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	o
    //   35	12	1	localArrayList	ArrayList
    //   81	4	1	localObject1	Object
    //   86	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   67	78	81	finally
    //   82	84	81	finally
    //   2	11	86	finally
    //   12	19	86	finally
    //   87	89	86	finally
  }
  
  public final void a()
  {
    notifyDataSetChanged();
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final void b()
  {
    this.g.removeCallbacks(this.i);
    this.g.post(this.i);
  }
  
  public final int getCount()
  {
    return this.b.size();
  }
  
  public final long getItemId(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {}
    for (long l = Long.MIN_VALUE;; l = a(paramInt).u()) {
      return l;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    int j = -1;
    if (!this.e) {
      this.e = true;
    }
    Preference localPreference = a(paramInt);
    if (!localPreference.E()) {
      paramInt = j;
    }
    for (;;)
    {
      return paramInt;
      this.d = a(localPreference, this.d);
      int k = Collections.binarySearch(this.c, this.d);
      paramInt = j;
      if (k >= 0) {
        paramInt = k;
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = a(paramInt);
    this.d = a((Preference)localObject, this.d);
    if (Collections.binarySearch(this.c, this.d) < 0) {
      paramView = null;
    }
    paramView = ((Preference)localObject).a(paramView, paramViewGroup);
    paramView.setBackgroundResource(this.h[paramInt]);
    paramViewGroup = ((Preference)localObject).y();
    int j;
    int k;
    if (!(localObject instanceof PreferenceCategory))
    {
      if (((Preference)localObject).s() == null) {
        break label173;
      }
      paramInt = 1;
      j = paramViewGroup.getResources().getDimensionPixelSize(R.dimen.framework_preference_item_padding_side);
      k = paramViewGroup.getResources().getDimensionPixelSize(R.dimen.framework_preference_item_padding_right_side);
      if (paramInt == 0) {
        break label178;
      }
    }
    label173:
    label178:
    for (paramInt = paramViewGroup.getResources().getDimensionPixelSize(R.dimen.framework_preference_icon_item_padding_side);; paramInt = j)
    {
      paramViewGroup = paramView.getBackground();
      if (paramViewGroup != null)
      {
        localObject = new Rect();
        paramViewGroup.getPadding((Rect)localObject);
        paramView.setPadding(paramInt + ((Rect)localObject).left, ((Rect)localObject).top, k + ((Rect)localObject).right, ((Rect)localObject).bottom);
      }
      return paramView;
      paramInt = 0;
      break;
    }
  }
  
  public final int getViewTypeCount()
  {
    if (!this.e) {
      this.e = true;
    }
    return Math.max(1, this.c.size());
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {}
    for (boolean bool = true;; bool = a(paramInt).t()) {
      return bool;
    }
  }
  
  static final class a
  {
    static int[] a(List<Preference> paramList)
    {
      int j = paramList.size();
      int[] arrayOfInt = new int[j];
      int i = 0;
      if (i < j)
      {
        Preference localPreference3 = (Preference)paramList.get(i);
        int k = i - 1;
        Preference localPreference1;
        label51:
        Preference localPreference2;
        if (k >= 0)
        {
          localPreference1 = (Preference)paramList.get(k);
          k = i + 1;
          if (k >= j) {
            break label107;
          }
          localPreference2 = (Preference)paramList.get(k);
          label72:
          if (!(localPreference3 instanceof PreferenceCategory)) {
            break label123;
          }
          if (localPreference3.r() == null) {
            break label113;
          }
          arrayOfInt[i] = R.drawable.framework_preference_category_background;
        }
        for (;;)
        {
          i++;
          break;
          localPreference1 = null;
          break label51;
          label107:
          localPreference2 = null;
          break label72;
          label113:
          arrayOfInt[i] = R.drawable.framework_preference_category_background_no_title;
          continue;
          label123:
          if ((localPreference1 == null) && (localPreference2 == null)) {
            arrayOfInt[i] = R.drawable.framework_preference_item_single_bg;
          } else if ((localPreference1 == null) && (localPreference2 != null))
          {
            if ((localPreference2 instanceof PreferenceCategory)) {
              arrayOfInt[i] = R.drawable.framework_preference_item_single_bg;
            } else {
              arrayOfInt[i] = R.drawable.framework_preference_item_first_bg;
            }
          }
          else if ((localPreference1 != null) && (localPreference2 == null))
          {
            if ((localPreference1 instanceof PreferenceCategory)) {
              arrayOfInt[i] = R.drawable.framework_preference_item_single_bg;
            } else {
              arrayOfInt[i] = R.drawable.framework_preference_item_last_bg;
            }
          }
          else if (((localPreference1 instanceof PreferenceCategory)) && ((localPreference2 instanceof PreferenceCategory))) {
            arrayOfInt[i] = R.drawable.framework_preference_item_single_bg;
          } else if ((localPreference1 instanceof PreferenceCategory)) {
            arrayOfInt[i] = R.drawable.framework_preference_item_first_bg;
          } else if ((localPreference2 instanceof PreferenceCategory)) {
            arrayOfInt[i] = R.drawable.framework_preference_item_last_bg;
          } else {
            arrayOfInt[i] = R.drawable.framework_preference_item_middle_bg;
          }
        }
      }
      return arrayOfInt;
    }
  }
  
  private static final class b
    implements Comparable<b>
  {
    private int a;
    private int b;
    private String c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */