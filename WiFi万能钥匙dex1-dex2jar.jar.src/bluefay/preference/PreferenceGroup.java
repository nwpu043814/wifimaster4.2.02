package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.bluefay.a.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class PreferenceGroup
  extends Preference
  implements d.b<Preference>
{
  private List<Preference> b = new ArrayList();
  private boolean c = true;
  private int d = 0;
  private boolean e = false;
  
  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "PreferenceGroup");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      this.c = paramContext.getBoolean(((Integer)e.a("com.android.internal.R$styleable", "PreferenceGroup_orderingFromXml")).intValue(), this.c);
      paramContext.recycle();
    }
  }
  
  private boolean d(Preference paramPreference)
  {
    try
    {
      paramPreference.D();
      boolean bool = this.b.remove(paramPreference);
      return bool;
    }
    finally {}
  }
  
  protected final void C()
  {
    super.C();
    this.e = true;
    int j = b();
    for (int i = 0; i < j; i++) {
      a(i).C();
    }
  }
  
  protected final void D()
  {
    super.D();
    this.e = false;
  }
  
  public final Preference a(int paramInt)
  {
    return (Preference)this.b.get(paramInt);
  }
  
  protected final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int j = b();
    for (int i = 0; i < j; i++) {
      a(i).a(paramBundle);
    }
  }
  
  protected boolean a(Preference paramPreference)
  {
    paramPreference.d(i());
    return true;
  }
  
  public final int b()
  {
    return this.b.size();
  }
  
  protected final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    int j = b();
    for (int i = 0; i < j; i++) {
      a(i).b(paramBundle);
    }
  }
  
  public final boolean b(Preference paramPreference)
  {
    boolean bool;
    if (this.b.contains(paramPreference)) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (paramPreference.q() == Integer.MAX_VALUE)
      {
        if (this.c)
        {
          i = this.d;
          this.d = (i + 1);
          paramPreference.d(i);
        }
        if ((paramPreference instanceof PreferenceGroup)) {
          ((PreferenceGroup)paramPreference).c = this.c;
        }
      }
      int j = Collections.binarySearch(this.b, paramPreference);
      int i = j;
      if (j < 0) {
        i = j * -1 - 1;
      }
      if (!a(paramPreference))
      {
        bool = false;
        continue;
      }
      try
      {
        this.b.add(i, paramPreference);
        paramPreference.a(B());
        if (this.e) {
          paramPreference.C();
        }
        A();
        paramPreference.a = this;
        bool = true;
      }
      finally {}
    }
  }
  
  public final Preference c(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(v(), paramCharSequence)) {
      paramCharSequence = this;
    }
    for (;;)
    {
      return paramCharSequence;
      int j = b();
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label97;
        }
        Preference localPreference = a(i);
        String str = localPreference.v();
        if ((str != null) && (str.equals(paramCharSequence)))
        {
          paramCharSequence = localPreference;
          break;
        }
        if ((localPreference instanceof PreferenceGroup))
        {
          localPreference = ((PreferenceGroup)localPreference).c(paramCharSequence);
          if (localPreference != null)
          {
            paramCharSequence = localPreference;
            break;
          }
        }
      }
      label97:
      paramCharSequence = null;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    int j = b();
    for (int i = 0; i < j; i++) {
      a(i).d(paramBoolean);
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public final boolean c(Preference paramPreference)
  {
    boolean bool = d(paramPreference);
    A();
    return bool;
  }
  
  final void e()
  {
    try
    {
      Collections.sort(this.b);
      return;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/PreferenceGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */