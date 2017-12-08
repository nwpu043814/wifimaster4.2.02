package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public abstract class TwoStatePreference
  extends Preference
{
  boolean b;
  private CharSequence c;
  private CharSequence d;
  private boolean e;
  private boolean f;
  private boolean g;
  
  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TwoStatePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false));
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class))) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      a(paramParcelable.a);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.b != paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (!this.e))
      {
        this.b = paramBoolean;
        this.e = true;
        e(paramBoolean);
        if (i != 0)
        {
          c(i());
          z();
        }
      }
      return;
    }
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramBoolean = f(this.b);; paramBoolean = ((Boolean)paramObject).booleanValue())
    {
      a(paramBoolean);
      return;
    }
  }
  
  final void b(View paramView)
  {
    int j = 0;
    TextView localTextView = (TextView)paramView.findViewById(16908304);
    int k;
    int i;
    if (localTextView != null)
    {
      k = 1;
      if ((!this.b) || (TextUtils.isEmpty(this.c))) {
        break label95;
      }
      localTextView.setText(this.c);
      i = 0;
      if (i == 0) {
        break label138;
      }
      paramView = j();
      if (TextUtils.isEmpty(paramView)) {
        break label138;
      }
      localTextView.setText(paramView);
      i = 0;
    }
    label95:
    label138:
    for (;;)
    {
      if (i == 0) {}
      for (i = j;; i = 8)
      {
        if (i != localTextView.getVisibility()) {
          localTextView.setVisibility(i);
        }
        return;
        i = k;
        if (this.b) {
          break;
        }
        i = k;
        if (TextUtils.isEmpty(this.d)) {
          break;
        }
        localTextView.setText(this.d);
        i = 0;
        break;
      }
    }
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    if (this.b) {
      z();
    }
  }
  
  protected final void d()
  {
    super.d();
    boolean bool;
    if (!this.b)
    {
      bool = true;
      this.f = true;
      if (x()) {
        break label31;
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      label31:
      a(bool);
    }
  }
  
  public final void d(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    if (!this.b) {
      z();
    }
  }
  
  public final void g(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.b;
    }
  }
  
  public final boolean i()
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.g) {
      bool1 = this.b;
    }
    for (;;)
    {
      if (!bool1)
      {
        bool1 = bool2;
        if (!super.i()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (!this.b) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
  }
  
  static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new u();
    boolean a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.a = bool;
        return;
        bool = false;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.a) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/TwoStatePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */