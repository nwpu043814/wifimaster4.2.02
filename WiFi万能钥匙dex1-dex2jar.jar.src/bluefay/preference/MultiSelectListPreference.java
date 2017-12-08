package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import bluefay.app.k.a;
import com.bluefay.a.e;
import java.util.HashSet;
import java.util.Set;

public class MultiSelectListPreference
  extends DialogPreference
{
  private CharSequence[] b;
  private CharSequence[] c;
  private Set<String> d = new HashSet();
  private Set<String> e = new HashSet();
  private boolean f;
  
  public MultiSelectListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = e.a("com.android.internal.R$styleable", "MultiSelectListPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, 0);
      int i = ((Integer)e.a("com.android.internal.R$styleable", "MultiSelectListPreference_entries")).intValue();
      int j = ((Integer)e.a("com.android.internal.R$styleable", "MultiSelectListPreference_entryValues")).intValue();
      this.b = paramContext.getTextArray(i);
      this.c = paramContext.getTextArray(j);
      paramContext.recycle();
    }
  }
  
  private boolean[] F()
  {
    CharSequence[] arrayOfCharSequence = this.c;
    int j = arrayOfCharSequence.length;
    Set localSet = this.d;
    boolean[] arrayOfBoolean = new boolean[j];
    for (int i = 0; i < j; i++) {
      arrayOfBoolean[i] = localSet.contains(arrayOfCharSequence[i].toString());
    }
    return arrayOfBoolean;
  }
  
  private void c(Set<String> paramSet)
  {
    this.d.clear();
    this.d.addAll(paramSet);
    a(paramSet);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    CharSequence[] arrayOfCharSequence = paramTypedArray.getTextArray(paramInt);
    if (arrayOfCharSequence == null)
    {
      paramTypedArray = null;
      return paramTypedArray;
    }
    int i = arrayOfCharSequence.length;
    HashSet localHashSet = new HashSet();
    for (paramInt = 0;; paramInt++)
    {
      paramTypedArray = localHashSet;
      if (paramInt >= i) {
        break;
      }
      localHashSet.add(arrayOfCharSequence[paramInt].toString());
    }
  }
  
  protected final void a(k.a parama)
  {
    super.a(parama);
    if ((this.b == null) || (this.c == null)) {
      throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
    }
    boolean[] arrayOfBoolean = F();
    parama.a(this.b, arrayOfBoolean, new i(this));
    this.e.clear();
    this.e.addAll(this.d);
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (this.f))
    {
      Set localSet = this.e;
      if (x()) {
        c(localSet);
      }
    }
    this.f = false;
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramObject = b(this.d);; paramObject = (Set)paramObject)
    {
      c((Set)paramObject);
      return;
    }
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.d;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new j();
    Set<String> a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = new HashSet();
      paramParcel = paramParcel.createStringArray();
      int j = paramParcel.length;
      for (int i = 0; i < j; i++) {
        this.a.add(paramParcel[i]);
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeStringArray((String[])this.a.toArray(new String[0]));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/MultiSelectListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */