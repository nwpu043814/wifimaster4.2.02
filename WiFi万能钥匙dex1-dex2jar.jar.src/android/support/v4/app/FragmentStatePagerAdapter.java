package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class FragmentStatePagerAdapter
  extends PagerAdapter
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FragmentStatePagerAdapter";
  private FragmentTransaction mCurTransaction = null;
  private Fragment mCurrentPrimaryItem = null;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public FragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    this.mSavedState.set(paramInt, this.mFragmentManager.saveFragmentInstanceState(paramViewGroup));
    this.mFragments.set(paramInt, null);
    this.mCurTransaction.remove(paramViewGroup);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitAllowingStateLoss();
      this.mCurTransaction = null;
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Fragment localFragment;
    if (this.mFragments.size() > paramInt)
    {
      localFragment = (Fragment)this.mFragments.get(paramInt);
      if (localFragment == null) {}
    }
    for (paramViewGroup = localFragment;; paramViewGroup = localFragment)
    {
      return paramViewGroup;
      if (this.mCurTransaction == null) {
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }
      localFragment = getItem(paramInt);
      if (this.mSavedState.size() > paramInt)
      {
        Fragment.SavedState localSavedState = (Fragment.SavedState)this.mSavedState.get(paramInt);
        if (localSavedState != null) {
          localFragment.setInitialSavedState(localSavedState);
        }
      }
      while (this.mFragments.size() <= paramInt) {
        this.mFragments.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.mFragments.set(paramInt, localFragment);
      this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    if (((Fragment)paramObject).getView() == paramView) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      paramParcelable = (Bundle)paramParcelable;
      paramParcelable.setClassLoader(paramClassLoader);
      paramClassLoader = paramParcelable.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      int i;
      if (paramClassLoader != null) {
        for (i = 0; i < paramClassLoader.length; i++) {
          this.mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
        }
      }
      Iterator localIterator = paramParcelable.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith("f"))
        {
          i = Integer.parseInt(str.substring(1));
          paramClassLoader = this.mFragmentManager.getFragment(paramParcelable, str);
          if (paramClassLoader != null)
          {
            while (this.mFragments.size() <= i) {
              this.mFragments.add(null);
            }
            paramClassLoader.setMenuVisibility(false);
            this.mFragments.set(i, paramClassLoader);
          }
          else
          {
            Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
          }
        }
      }
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    for (Object localObject2 = localObject1; i < this.mFragments.size(); localObject2 = localObject1)
    {
      Fragment localFragment = (Fragment)this.mFragments.get(i);
      localObject1 = localObject2;
      if (localFragment != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        localObject2 = "f" + i;
        this.mFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
      }
      i++;
    }
    return (Parcelable)localObject2;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/app/FragmentStatePagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */