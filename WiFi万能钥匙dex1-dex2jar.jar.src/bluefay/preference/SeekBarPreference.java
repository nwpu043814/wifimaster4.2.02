package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.bluefay.a.e;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;

public class SeekBarPreference
  extends Preference
  implements SeekBar.OnSeekBarChangeListener
{
  private int b;
  private int c;
  private boolean d;
  
  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SeekBarPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "ProgressBar");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      int i = ((Integer)e.a("com.android.internal.R$styleable", "ProgressBar_max")).intValue();
      paramInt = ((Integer)e.a("com.android.internal.R$styleable", "ProgressBar_progress")).intValue();
      this.c = paramContext.getInt(i, this.c);
      this.b = paramContext.getInt(paramInt, this.b);
      paramContext.recycle();
      c(R.layout.framework_preference_slider);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.c) {
      paramInt = this.c;
    }
    for (;;)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      if (i != this.b)
      {
        this.b = i;
        h(i);
        if (paramBoolean) {
          z();
        }
      }
      return;
    }
  }
  
  private void a(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    if (i != this.b)
    {
      if (!x()) {
        break label27;
      }
      a(i, false);
    }
    for (;;)
    {
      return;
      label27:
      paramSeekBar.setProgress(this.b);
    }
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Integer.valueOf(paramTypedArray.getInt(paramInt, 0));
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if (!paramParcelable.getClass().equals(SavedState.class)) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      this.b = paramParcelable.a;
      this.c = paramParcelable.b;
      z();
    }
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = (SeekBar)paramView.findViewById(R.id.seekbar);
    paramView.setOnSeekBarChangeListener(this);
    paramView.setMax(this.c);
    paramView.setProgress(this.b);
    paramView.setEnabled(a());
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (int i = i(this.b);; i = ((Integer)paramObject).intValue())
    {
      a(i, true);
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
      ((SavedState)localObject).a = this.b;
      ((SavedState)localObject).b = this.c;
    }
  }
  
  public final CharSequence j()
  {
    return null;
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramKeyEvent.getAction() != 1) {
      if ((paramInt == 81) || (paramInt == 70)) {
        a(this.b + 1, true);
      }
    }
    for (;;)
    {
      return bool;
      if (paramInt == 69) {
        a(this.b - 1, true);
      } else {
        bool = false;
      }
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.d)) {
      a(paramSeekBar);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = true;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.d = false;
    if (paramSeekBar.getProgress() != this.b) {
      a(paramSeekBar);
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new t();
    int a;
    int b;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
      this.b = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/SeekBarPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */