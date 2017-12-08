package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class FragmentManagerImpl
  extends FragmentManager
{
  static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5F);
  static final Interpolator ACCELERATE_QUINT;
  static final int ANIM_DUR = 220;
  public static final int ANIM_STYLE_CLOSE_ENTER = 3;
  public static final int ANIM_STYLE_CLOSE_EXIT = 4;
  public static final int ANIM_STYLE_FADE_ENTER = 5;
  public static final int ANIM_STYLE_FADE_EXIT = 6;
  public static final int ANIM_STYLE_OPEN_ENTER = 1;
  public static final int ANIM_STYLE_OPEN_EXIT = 2;
  static boolean DEBUG = false;
  static final Interpolator DECELERATE_CUBIC;
  static final Interpolator DECELERATE_QUINT;
  static final boolean HONEYCOMB;
  static final String TAG = "FragmentManager";
  static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
  static final String TARGET_STATE_TAG = "android:target_state";
  static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
  static final String VIEW_STATE_TAG = "android:view_state";
  ArrayList<Fragment> mActive;
  FragmentActivity mActivity;
  ArrayList<Fragment> mAdded;
  ArrayList<Integer> mAvailBackStackIndices;
  ArrayList<Integer> mAvailIndices;
  ArrayList<BackStackRecord> mBackStack;
  ArrayList<FragmentManager.OnBackStackChangedListener> mBackStackChangeListeners;
  ArrayList<BackStackRecord> mBackStackIndices;
  FragmentContainer mContainer;
  ArrayList<Fragment> mCreatedMenus;
  int mCurState = 0;
  boolean mDestroyed;
  Runnable mExecCommit = new FragmentManagerImpl.1(this);
  boolean mExecutingActions;
  boolean mHavePendingDeferredStart;
  boolean mNeedMenuInvalidate;
  String mNoTransactionsBecause;
  Fragment mParent;
  ArrayList<Runnable> mPendingActions;
  SparseArray<Parcelable> mStateArray = null;
  Bundle mStateBundle = null;
  boolean mStateSaved;
  Runnable[] mTmpActions;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    HONEYCOMB = bool;
    DECELERATE_QUINT = new DecelerateInterpolator(2.5F);
    DECELERATE_CUBIC = new DecelerateInterpolator(1.5F);
    ACCELERATE_QUINT = new AccelerateInterpolator(2.5F);
  }
  
  private void checkStateLoss()
  {
    if (this.mStateSaved) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.mNoTransactionsBecause != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
    }
  }
  
  static Animation makeFadeAnimation(Context paramContext, float paramFloat1, float paramFloat2)
  {
    paramContext = new AlphaAnimation(paramFloat1, paramFloat2);
    paramContext.setInterpolator(DECELERATE_CUBIC);
    paramContext.setDuration(220L);
    return paramContext;
  }
  
  static Animation makeOpenCloseAnimation(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramContext = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(DECELERATE_QUINT);
    ((ScaleAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(DECELERATE_CUBIC);
    ((AlphaAnimation)localObject).setDuration(220L);
    paramContext.addAnimation((Animation)localObject);
    return paramContext;
  }
  
  public static int reverseTransit(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramInt;
      paramInt = 8194;
      continue;
      paramInt = 4097;
      continue;
      paramInt = 4099;
    }
  }
  
  private void throwException(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new LogWriter("FragmentManager"));
    if (this.mActivity != null) {}
    for (;;)
    {
      try
      {
        this.mActivity.dump("  ", null, localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        dump("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  public static int transitToStyleIndex(int paramInt, boolean paramBoolean)
  {
    int i = -1;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      return paramInt;
      if (paramBoolean)
      {
        paramInt = 1;
      }
      else
      {
        paramInt = 2;
        continue;
        if (paramBoolean)
        {
          paramInt = 3;
        }
        else
        {
          paramInt = 4;
          continue;
          if (paramBoolean) {
            paramInt = 5;
          } else {
            paramInt = 6;
          }
        }
      }
    }
  }
  
  final void addBackStackState(BackStackRecord paramBackStackRecord)
  {
    if (this.mBackStack == null) {
      this.mBackStack = new ArrayList();
    }
    this.mBackStack.add(paramBackStackRecord);
    reportBackStackChanged();
  }
  
  public final void addFragment(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.mAdded == null) {
      this.mAdded = new ArrayList();
    }
    if (DEBUG) {
      Log.v("FragmentManager", "add: " + paramFragment);
    }
    makeActive(paramFragment);
    if (!paramFragment.mDetached)
    {
      if (this.mAdded.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.mAdded.add(paramFragment);
      paramFragment.mAdded = true;
      paramFragment.mRemoving = false;
      if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      if (paramBoolean) {
        moveToState(paramFragment);
      }
    }
  }
  
  public final void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners == null) {
      this.mBackStackChangeListeners = new ArrayList();
    }
    this.mBackStackChangeListeners.add(paramOnBackStackChangedListener);
  }
  
  /* Error */
  public final int allocBackStackIndex(BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnull +13 -> 19
    //   9: aload_0
    //   10: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   13: invokevirtual 303	java/util/ArrayList:size	()I
    //   16: ifgt +85 -> 101
    //   19: aload_0
    //   20: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   23: ifnonnull +16 -> 39
    //   26: new 241	java/util/ArrayList
    //   29: astore_3
    //   30: aload_3
    //   31: invokespecial 242	java/util/ArrayList:<init>	()V
    //   34: aload_0
    //   35: aload_3
    //   36: putfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   39: aload_0
    //   40: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   43: invokevirtual 303	java/util/ArrayList:size	()I
    //   46: istore_2
    //   47: getstatic 85	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   50: ifeq +38 -> 88
    //   53: new 141	java/lang/StringBuilder
    //   56: astore_3
    //   57: aload_3
    //   58: ldc_w 307
    //   61: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   64: ldc 32
    //   66: aload_3
    //   67: iload_2
    //   68: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   71: ldc_w 312
    //   74: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 261	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: aload_0
    //   89: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   92: aload_1
    //   93: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: iload_2
    //   100: ireturn
    //   101: aload_0
    //   102: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   105: aload_0
    //   106: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   109: invokevirtual 303	java/util/ArrayList:size	()I
    //   112: iconst_1
    //   113: isub
    //   114: invokevirtual 316	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   117: checkcast 318	java/lang/Integer
    //   120: invokevirtual 321	java/lang/Integer:intValue	()I
    //   123: istore_2
    //   124: getstatic 85	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   127: ifeq +38 -> 165
    //   130: new 141	java/lang/StringBuilder
    //   133: astore_3
    //   134: aload_3
    //   135: ldc_w 323
    //   138: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: ldc 32
    //   143: aload_3
    //   144: iload_2
    //   145: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc_w 325
    //   151: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 261	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   164: pop
    //   165: aload_0
    //   166: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   169: iload_2
    //   170: aload_1
    //   171: invokevirtual 329	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_0
    //   176: monitorexit
    //   177: goto -78 -> 99
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	FragmentManagerImpl
    //   0	185	1	paramBackStackRecord	BackStackRecord
    //   46	124	2	i	int
    //   29	115	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	180	finally
    //   19	39	180	finally
    //   39	88	180	finally
    //   88	99	180	finally
    //   101	165	180	finally
    //   165	177	180	finally
    //   181	183	180	finally
  }
  
  public final void attachActivity(FragmentActivity paramFragmentActivity, FragmentContainer paramFragmentContainer, Fragment paramFragment)
  {
    if (this.mActivity != null) {
      throw new IllegalStateException("Already attached");
    }
    this.mActivity = paramFragmentActivity;
    this.mContainer = paramFragmentContainer;
    this.mParent = paramFragment;
  }
  
  public final void attachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "attach: " + paramFragment);
    }
    if (paramFragment.mDetached)
    {
      paramFragment.mDetached = false;
      if (!paramFragment.mAdded)
      {
        if (this.mAdded == null) {
          this.mAdded = new ArrayList();
        }
        if (this.mAdded.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          Log.v("FragmentManager", "add from attach: " + paramFragment);
        }
        this.mAdded.add(paramFragment);
        paramFragment.mAdded = true;
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        moveToState(paramFragment, this.mCurState, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final FragmentTransaction beginTransaction()
  {
    return new BackStackRecord(this);
  }
  
  public final void detachFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "detach: " + paramFragment);
    }
    if (!paramFragment.mDetached)
    {
      paramFragment.mDetached = true;
      if (paramFragment.mAdded)
      {
        if (this.mAdded != null)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "remove from detach: " + paramFragment);
          }
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        moveToState(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final void dispatchActivityCreated()
  {
    this.mStateSaved = false;
    moveToState(2, false);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performConfigurationChanged(paramConfiguration);
        }
      }
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performContextItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  public final void dispatchCreate()
  {
    this.mStateSaved = false;
    moveToState(1, false);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int i;
    if (this.mAdded != null)
    {
      i = 0;
      boolean bool1 = false;
      for (;;)
      {
        localObject2 = localObject1;
        bool2 = bool1;
        if (i >= this.mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        localObject2 = localObject1;
        bool2 = bool1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (localFragment.performCreateOptionsMenu(paramMenu, paramMenuInflater))
          {
            bool2 = true;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
          }
        }
        i++;
        bool1 = bool2;
        localObject1 = localObject2;
      }
    }
    boolean bool2 = false;
    if (this.mCreatedMenus != null) {
      for (i = j; i < this.mCreatedMenus.size(); i++)
      {
        paramMenu = (Fragment)this.mCreatedMenus.get(i);
        if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
          paramMenu.onDestroyOptionsMenu();
        }
      }
    }
    this.mCreatedMenus = ((ArrayList)localObject2);
    return bool2;
  }
  
  public final void dispatchDestroy()
  {
    this.mDestroyed = true;
    execPendingActions();
    moveToState(0, false);
    this.mActivity = null;
    this.mContainer = null;
    this.mParent = null;
  }
  
  public final void dispatchDestroyView()
  {
    moveToState(1, false);
  }
  
  public final void dispatchLowMemory()
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performLowMemory();
        }
      }
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mAdded != null) {}
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i < this.mAdded.size())
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if ((localFragment != null) && (localFragment.performOptionsItemSelected(paramMenuItem))) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.mAdded != null) {
      for (int i = 0; i < this.mAdded.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        if (localFragment != null) {
          localFragment.performOptionsMenuClosed(paramMenu);
        }
      }
    }
  }
  
  public final void dispatchPause()
  {
    moveToState(4, false);
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.mAdded != null)
    {
      int i = 0;
      for (boolean bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (i >= this.mAdded.size()) {
          break;
        }
        Fragment localFragment = (Fragment)this.mAdded.get(i);
        bool2 = bool1;
        if (localFragment != null)
        {
          bool2 = bool1;
          if (localFragment.performPrepareOptionsMenu(paramMenu)) {
            bool2 = true;
          }
        }
        i++;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  public final void dispatchReallyStop()
  {
    moveToState(2, false);
  }
  
  public final void dispatchResume()
  {
    this.mStateSaved = false;
    moveToState(5, false);
  }
  
  public final void dispatchStart()
  {
    this.mStateSaved = false;
    moveToState(4, false);
  }
  
  public final void dispatchStop()
  {
    this.mStateSaved = true;
    moveToState(3, false);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int k;
    int i;
    Object localObject;
    if (this.mActive != null)
    {
      k = this.mActive.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        for (i = 0; i < k; i++)
        {
          localObject = (Fragment)this.mActive.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject);
          if (localObject != null) {
            ((Fragment)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
        }
      }
    }
    if (this.mAdded != null)
    {
      k = this.mAdded.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        for (i = 0; i < k; i++)
        {
          localObject = (Fragment)this.mAdded.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
        }
      }
    }
    if (this.mCreatedMenus != null)
    {
      k = this.mCreatedMenus.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        for (i = 0; i < k; i++)
        {
          localObject = (Fragment)this.mCreatedMenus.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((Fragment)localObject).toString());
        }
      }
    }
    if (this.mBackStack != null)
    {
      k = this.mBackStack.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        for (i = 0; i < k; i++)
        {
          localObject = (BackStackRecord)this.mBackStack.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(((BackStackRecord)localObject).toString());
          ((BackStackRecord)localObject).dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
      }
    }
    try
    {
      if (this.mBackStackIndices != null)
      {
        k = this.mBackStackIndices.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          for (i = 0; i < k; i++)
          {
            paramFileDescriptor = (BackStackRecord)this.mBackStackIndices.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
          }
        }
      }
      if ((this.mAvailBackStackIndices != null) && (this.mAvailBackStackIndices.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
      }
      if (this.mPendingActions != null)
      {
        k = this.mPendingActions.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          for (i = j; i < k; i++)
          {
            paramFileDescriptor = (Runnable)this.mPendingActions.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mActivity=");
    paramPrintWriter.println(this.mActivity);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.mContainer);
    if (this.mParent != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.mParent);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.mCurState);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.mStateSaved);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.mDestroyed);
    if (this.mNeedMenuInvalidate)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.mNeedMenuInvalidate);
    }
    if (this.mNoTransactionsBecause != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.mNoTransactionsBecause);
    }
    if ((this.mAvailIndices != null) && (this.mAvailIndices.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
    }
  }
  
  public final void enqueueAction(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      checkStateLoss();
    }
    try
    {
      if ((this.mDestroyed) || (this.mActivity == null))
      {
        paramRunnable = new java/lang/IllegalStateException;
        paramRunnable.<init>("Activity has been destroyed");
        throw paramRunnable;
      }
    }
    finally {}
    if (this.mPendingActions == null)
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      this.mPendingActions = localArrayList;
    }
    this.mPendingActions.add(paramRunnable);
    if (this.mPendingActions.size() == 1)
    {
      this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
      this.mActivity.mHandler.post(this.mExecCommit);
    }
  }
  
  public final boolean execPendingActions()
  {
    if (this.mExecutingActions) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.mActivity.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int i;
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((this.mPendingActions == null) || (this.mPendingActions.size() == 0))
        {
          if (!this.mHavePendingDeferredStart) {
            break label274;
          }
          j = 0;
          int m;
          for (i = 0; j < this.mActive.size(); i = m)
          {
            Fragment localFragment = (Fragment)this.mActive.get(j);
            int k = i;
            if (localFragment != null)
            {
              k = i;
              if (localFragment.mLoaderManager != null) {
                m = i | localFragment.mLoaderManager.hasRunningLoaders();
              }
            }
            j++;
          }
        }
        int j = this.mPendingActions.size();
        if ((this.mTmpActions == null) || (this.mTmpActions.length < j)) {
          this.mTmpActions = new Runnable[j];
        }
        this.mPendingActions.toArray(this.mTmpActions);
        this.mPendingActions.clear();
        this.mActivity.mHandler.removeCallbacks(this.mExecCommit);
        this.mExecutingActions = true;
        for (i = 0; i < j; i++)
        {
          this.mTmpActions[i].run();
          this.mTmpActions[i] = null;
        }
        this.mExecutingActions = false;
      }
      finally {}
    }
    if (i == 0)
    {
      this.mHavePendingDeferredStart = false;
      startPendingDeferredFragments();
    }
    label274:
    return bool;
  }
  
  public final boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public final Fragment findFragmentById(int paramInt)
  {
    int i;
    Object localObject;
    if (this.mAdded != null)
    {
      i = this.mAdded.size() - 1;
      if (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject == null) || (((Fragment)localObject).mFragmentId != paramInt)) {}
      }
    }
    for (;;)
    {
      return (Fragment)localObject;
      i--;
      break;
      if (this.mActive != null) {
        for (i = this.mActive.size() - 1;; i--)
        {
          if (i < 0) {
            break label110;
          }
          Fragment localFragment = (Fragment)this.mActive.get(i);
          if (localFragment != null)
          {
            localObject = localFragment;
            if (localFragment.mFragmentId == paramInt) {
              break;
            }
          }
        }
      }
      label110:
      localObject = null;
    }
  }
  
  public final Fragment findFragmentByTag(String paramString)
  {
    int i;
    Object localObject;
    if ((this.mAdded != null) && (paramString != null))
    {
      i = this.mAdded.size() - 1;
      if (i >= 0)
      {
        localObject = (Fragment)this.mAdded.get(i);
        if ((localObject == null) || (!paramString.equals(((Fragment)localObject).mTag))) {}
      }
    }
    for (;;)
    {
      return (Fragment)localObject;
      i--;
      break;
      if ((this.mActive != null) && (paramString != null)) {
        for (i = this.mActive.size() - 1;; i--)
        {
          if (i < 0) {
            break label124;
          }
          Fragment localFragment = (Fragment)this.mActive.get(i);
          if (localFragment != null)
          {
            localObject = localFragment;
            if (paramString.equals(localFragment.mTag)) {
              break;
            }
          }
        }
      }
      label124:
      localObject = null;
    }
  }
  
  public final Fragment findFragmentByWho(String paramString)
  {
    int i;
    Fragment localFragment;
    if ((this.mActive != null) && (paramString != null))
    {
      i = this.mActive.size() - 1;
      if (i >= 0)
      {
        localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null)
        {
          localFragment = localFragment.findFragmentByWho(paramString);
          if (localFragment == null) {}
        }
      }
    }
    for (paramString = localFragment;; paramString = null)
    {
      return paramString;
      i--;
      break;
    }
  }
  
  public final void freeBackStackIndex(int paramInt)
  {
    try
    {
      this.mBackStackIndices.set(paramInt, null);
      Object localObject1;
      if (this.mAvailBackStackIndices == null)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>();
        this.mAvailBackStackIndices = ((ArrayList)localObject1);
      }
      if (DEBUG)
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("Freeing back stack index ");
        Log.v("FragmentManager", paramInt);
      }
      this.mAvailBackStackIndices.add(Integer.valueOf(paramInt));
      return;
    }
    finally {}
  }
  
  public final FragmentManager.BackStackEntry getBackStackEntryAt(int paramInt)
  {
    return (FragmentManager.BackStackEntry)this.mBackStack.get(paramInt);
  }
  
  public final int getBackStackEntryCount()
  {
    if (this.mBackStack != null) {}
    for (int i = this.mBackStack.size();; i = 0) {
      return i;
    }
  }
  
  public final Fragment getFragment(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    for (;;)
    {
      return paramBundle;
      if (i >= this.mActive.size()) {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
      }
      Fragment localFragment = (Fragment)this.mActive.get(i);
      paramBundle = localFragment;
      if (localFragment == null)
      {
        throwException(new IllegalStateException("Fragement no longer exists for key " + paramString + ": index " + i));
        paramBundle = localFragment;
      }
    }
  }
  
  public final List<Fragment> getFragments()
  {
    return this.mActive;
  }
  
  public final void hideFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "hide: " + paramFragment);
    }
    if (!paramFragment.mHidden)
    {
      paramFragment.mHidden = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  public final boolean isDestroyed()
  {
    return this.mDestroyed;
  }
  
  final Animation loadAnimation(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Animation localAnimation = paramFragment.onCreateAnimation(paramInt1, paramBoolean, paramFragment.mNextAnim);
    if (localAnimation != null) {
      paramFragment = localAnimation;
    }
    for (;;)
    {
      return paramFragment;
      if (paramFragment.mNextAnim != 0)
      {
        localAnimation = AnimationUtils.loadAnimation(this.mActivity, paramFragment.mNextAnim);
        paramFragment = localAnimation;
        if (localAnimation != null) {}
      }
      else if (paramInt1 == 0)
      {
        paramFragment = null;
      }
      else
      {
        paramInt1 = transitToStyleIndex(paramInt1, paramBoolean);
        if (paramInt1 < 0) {
          paramFragment = null;
        } else {
          switch (paramInt1)
          {
          default: 
            paramInt1 = paramInt2;
            if (paramInt2 == 0)
            {
              paramInt1 = paramInt2;
              if (this.mActivity.getWindow() != null) {
                paramInt1 = this.mActivity.getWindow().getAttributes().windowAnimations;
              }
            }
            if (paramInt1 == 0) {
              paramFragment = null;
            }
            break;
          case 1: 
            paramFragment = makeOpenCloseAnimation(this.mActivity, 1.125F, 1.0F, 0.0F, 1.0F);
            break;
          case 2: 
            paramFragment = makeOpenCloseAnimation(this.mActivity, 1.0F, 0.975F, 1.0F, 0.0F);
            break;
          case 3: 
            paramFragment = makeOpenCloseAnimation(this.mActivity, 0.975F, 1.0F, 0.0F, 1.0F);
            break;
          case 4: 
            paramFragment = makeOpenCloseAnimation(this.mActivity, 1.0F, 1.075F, 1.0F, 0.0F);
            break;
          case 5: 
            paramFragment = makeFadeAnimation(this.mActivity, 0.0F, 1.0F);
            break;
          case 6: 
            paramFragment = makeFadeAnimation(this.mActivity, 1.0F, 0.0F);
            continue;
            paramFragment = null;
          }
        }
      }
    }
  }
  
  final void makeActive(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    label143:
    for (;;)
    {
      return;
      if ((this.mAvailIndices == null) || (this.mAvailIndices.size() <= 0))
      {
        if (this.mActive == null) {
          this.mActive = new ArrayList();
        }
        paramFragment.setIndex(this.mActive.size(), this.mParent);
        this.mActive.add(paramFragment);
      }
      for (;;)
      {
        if (!DEBUG) {
          break label143;
        }
        Log.v("FragmentManager", "Allocated fragment index " + paramFragment);
        break;
        paramFragment.setIndex(((Integer)this.mAvailIndices.remove(this.mAvailIndices.size() - 1)).intValue(), this.mParent);
        this.mActive.set(paramFragment.mIndex, paramFragment);
      }
    }
  }
  
  final void makeInactive(Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {}
    for (;;)
    {
      return;
      if (DEBUG) {
        Log.v("FragmentManager", "Freeing fragment index " + paramFragment);
      }
      this.mActive.set(paramFragment.mIndex, null);
      if (this.mAvailIndices == null) {
        this.mAvailIndices = new ArrayList();
      }
      this.mAvailIndices.add(Integer.valueOf(paramFragment.mIndex));
      this.mActivity.invalidateSupportFragment(paramFragment.mWho);
      paramFragment.initState();
    }
  }
  
  final void moveToState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.mActivity == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No activity");
    }
    if ((!paramBoolean) && (this.mCurState == paramInt1)) {}
    do
    {
      return;
      this.mCurState = paramInt1;
    } while (this.mActive == null);
    int i = 0;
    boolean bool = false;
    label54:
    if (i < this.mActive.size())
    {
      Fragment localFragment = (Fragment)this.mActive.get(i);
      if (localFragment == null) {
        break label168;
      }
      moveToState(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.mLoaderManager == null) {
        break label168;
      }
      bool |= localFragment.mLoaderManager.hasRunningLoaders();
    }
    label168:
    for (;;)
    {
      i++;
      break label54;
      if (!bool) {
        startPendingDeferredFragments();
      }
      if ((!this.mNeedMenuInvalidate) || (this.mActivity == null) || (this.mCurState != 5)) {
        break;
      }
      this.mActivity.supportInvalidateOptionsMenu();
      this.mNeedMenuInvalidate = false;
      break;
    }
  }
  
  final void moveToState(int paramInt, boolean paramBoolean)
  {
    moveToState(paramInt, 0, 0, paramBoolean);
  }
  
  final void moveToState(Fragment paramFragment)
  {
    moveToState(paramFragment, this.mCurState, 0, 0, false);
  }
  
  final void moveToState(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int j;
    if (paramFragment.mAdded)
    {
      j = paramInt1;
      if (!paramFragment.mDetached) {}
    }
    else
    {
      j = paramInt1;
      if (paramInt1 > 1) {
        j = 1;
      }
    }
    int i = j;
    if (paramFragment.mRemoving)
    {
      i = j;
      if (j > paramFragment.mState) {
        i = paramFragment.mState;
      }
    }
    paramInt1 = i;
    if (paramFragment.mDeferStart)
    {
      paramInt1 = i;
      if (paramFragment.mState < 4)
      {
        paramInt1 = i;
        if (i > 3) {
          paramInt1 = 3;
        }
      }
    }
    int k;
    label549:
    Object localObject2;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.mFromLayout) && (!paramFragment.mInLayout)) {}
      for (;;)
      {
        return;
        if (paramFragment.mAnimatingAway != null)
        {
          paramFragment.mAnimatingAway = null;
          moveToState(paramFragment, paramFragment.mStateAfterAnimating, 0, 0, true);
        }
        j = paramInt1;
        k = paramInt1;
        i = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          j = paramInt1;
          paramFragment.mState = j;
        }
      }
      if (DEBUG) {
        Log.v("FragmentManager", "moveto CREATED: " + paramFragment);
      }
      i = paramInt1;
      if (paramFragment.mSavedFragmentState != null)
      {
        paramFragment.mSavedViewState = paramFragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        paramFragment.mTarget = getFragment(paramFragment.mSavedFragmentState, "android:target_state");
        if (paramFragment.mTarget != null) {
          paramFragment.mTargetRequestCode = paramFragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        paramFragment.mUserVisibleHint = paramFragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        i = paramInt1;
        if (!paramFragment.mUserVisibleHint)
        {
          paramFragment.mDeferStart = true;
          i = paramInt1;
          if (paramInt1 > 3) {
            i = 3;
          }
        }
      }
      paramFragment.mActivity = this.mActivity;
      paramFragment.mParentFragment = this.mParent;
      if (this.mParent != null) {}
      for (localObject1 = this.mParent.mChildFragmentManager;; localObject1 = this.mActivity.mFragments)
      {
        paramFragment.mFragmentManager = ((FragmentManagerImpl)localObject1);
        paramFragment.mCalled = false;
        paramFragment.onAttach(this.mActivity);
        if (paramFragment.mCalled) {
          break;
        }
        throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      if (paramFragment.mParentFragment == null) {
        this.mActivity.onAttachFragment(paramFragment);
      }
      if (!paramFragment.mRetaining) {
        paramFragment.performCreate(paramFragment.mSavedFragmentState);
      }
      paramFragment.mRetaining = false;
      j = i;
      if (paramFragment.mFromLayout)
      {
        paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), null, paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null)
        {
          paramFragment.mInnerView = paramFragment.mView;
          paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
          if (paramFragment.mHidden) {
            paramFragment.mView.setVisibility(8);
          }
          paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
          j = i;
        }
      }
      else
      {
        k = j;
        if (j > 1)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + paramFragment);
          }
          if (!paramFragment.mFromLayout)
          {
            if (paramFragment.mContainerId == 0) {
              break label1535;
            }
            localObject2 = (ViewGroup)this.mContainer.findViewById(paramFragment.mContainerId);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (!paramFragment.mRestored) {
                throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.mContainerId) + " (" + paramFragment.getResources().getResourceName(paramFragment.mContainerId) + ") for fragment " + paramFragment));
              }
            }
          }
        }
      }
    }
    label1050:
    label1400:
    label1529:
    label1535:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      paramFragment.mContainer = ((ViewGroup)localObject1);
      paramFragment.mView = paramFragment.performCreateView(paramFragment.getLayoutInflater(paramFragment.mSavedFragmentState), (ViewGroup)localObject1, paramFragment.mSavedFragmentState);
      if (paramFragment.mView != null)
      {
        paramFragment.mInnerView = paramFragment.mView;
        paramFragment.mView = NoSaveStateFrameLayout.wrap(paramFragment.mView);
        if (localObject1 != null)
        {
          localObject2 = loadAnimation(paramFragment, paramInt2, true, paramInt3);
          if (localObject2 != null) {
            paramFragment.mView.startAnimation((Animation)localObject2);
          }
          ((ViewGroup)localObject1).addView(paramFragment.mView);
        }
        if (paramFragment.mHidden) {
          paramFragment.mView.setVisibility(8);
        }
        paramFragment.onViewCreated(paramFragment.mView, paramFragment.mSavedFragmentState);
      }
      for (;;)
      {
        paramFragment.performActivityCreated(paramFragment.mSavedFragmentState);
        if (paramFragment.mView != null) {
          paramFragment.restoreViewState(paramFragment.mSavedFragmentState);
        }
        paramFragment.mSavedFragmentState = null;
        k = j;
        i = k;
        if (k > 3)
        {
          if (DEBUG) {
            Log.v("FragmentManager", "moveto STARTED: " + paramFragment);
          }
          paramFragment.performStart();
          i = k;
        }
        j = i;
        if (i <= 4) {
          break;
        }
        if (DEBUG) {
          Log.v("FragmentManager", "moveto RESUMED: " + paramFragment);
        }
        paramFragment.mResumed = true;
        paramFragment.performResume();
        paramFragment.mSavedFragmentState = null;
        paramFragment.mSavedViewState = null;
        j = i;
        break;
        paramFragment.mInnerView = null;
        j = i;
        break label549;
        paramFragment.mInnerView = null;
      }
      j = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        j = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          j = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if ((this.mDestroyed) && (paramFragment.mAnimatingAway != null))
          {
            localObject1 = paramFragment.mAnimatingAway;
            paramFragment.mAnimatingAway = null;
            ((View)localObject1).clearAnimation();
          }
          if (paramFragment.mAnimatingAway == null) {
            break label1400;
          }
          paramFragment.mStateAfterAnimating = paramInt1;
          j = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom RESUMED: " + paramFragment);
            }
            paramFragment.performPause();
            paramFragment.mResumed = false;
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STARTED: " + paramFragment);
            }
            paramFragment.performStop();
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              Log.v("FragmentManager", "movefrom STOPPED: " + paramFragment);
            }
            paramFragment.performReallyStop();
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + paramFragment);
        }
        if ((paramFragment.mView != null) && (!this.mActivity.isFinishing()) && (paramFragment.mSavedViewState == null)) {
          saveFragmentViewState(paramFragment);
        }
        paramFragment.performDestroyView();
        if ((paramFragment.mView != null) && (paramFragment.mContainer != null)) {
          if ((this.mCurState <= 0) || (this.mDestroyed)) {
            break label1529;
          }
        }
        for (localObject1 = loadAnimation(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            paramFragment.mAnimatingAway = paramFragment.mView;
            paramFragment.mStateAfterAnimating = paramInt1;
            ((Animation)localObject1).setAnimationListener(new FragmentManagerImpl.5(this, paramFragment));
            paramFragment.mView.startAnimation((Animation)localObject1);
          }
          paramFragment.mContainer.removeView(paramFragment.mView);
          paramFragment.mContainer = null;
          paramFragment.mView = null;
          paramFragment.mInnerView = null;
          break label1050;
          if (DEBUG) {
            Log.v("FragmentManager", "movefrom CREATED: " + paramFragment);
          }
          if (!paramFragment.mRetaining) {
            paramFragment.performDestroy();
          }
          paramFragment.mCalled = false;
          paramFragment.onDetach();
          if (!paramFragment.mCalled) {
            throw new SuperNotCalledException("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          j = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.mRetaining)
          {
            makeInactive(paramFragment);
            j = paramInt1;
            break;
          }
          paramFragment.mActivity = null;
          paramFragment.mFragmentManager = null;
          j = paramInt1;
          break;
        }
      }
    }
  }
  
  public final void noteStateNotSaved()
  {
    this.mStateSaved = false;
  }
  
  public final void performPendingDeferredStart(Fragment paramFragment)
  {
    if (paramFragment.mDeferStart)
    {
      if (!this.mExecutingActions) {
        break label20;
      }
      this.mHavePendingDeferredStart = true;
    }
    for (;;)
    {
      return;
      label20:
      paramFragment.mDeferStart = false;
      moveToState(paramFragment, this.mCurState, 0, 0, false);
    }
  }
  
  public final void popBackStack()
  {
    enqueueAction(new FragmentManagerImpl.2(this), false);
  }
  
  public final void popBackStack(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    enqueueAction(new FragmentManagerImpl.4(this, paramInt1, paramInt2), false);
  }
  
  public final void popBackStack(String paramString, int paramInt)
  {
    enqueueAction(new FragmentManagerImpl.3(this, paramString, paramInt), false);
  }
  
  public final boolean popBackStackImmediate()
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, null, -1, 0);
  }
  
  public final boolean popBackStackImmediate(int paramInt1, int paramInt2)
  {
    checkStateLoss();
    executePendingTransactions();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt1);
    }
    return popBackStackState(this.mActivity.mHandler, null, paramInt1, paramInt2);
  }
  
  public final boolean popBackStackImmediate(String paramString, int paramInt)
  {
    checkStateLoss();
    executePendingTransactions();
    return popBackStackState(this.mActivity.mHandler, paramString, -1, paramInt);
  }
  
  final boolean popBackStackState(Handler paramHandler, String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (this.mBackStack == null) {
      bool1 = bool2;
    }
    int i;
    do
    {
      int j;
      do
      {
        for (;;)
        {
          return bool1;
          if ((paramString != null) || (paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
            break;
          }
          paramInt1 = this.mBackStack.size() - 1;
          bool1 = bool2;
          if (paramInt1 >= 0)
          {
            ((BackStackRecord)this.mBackStack.remove(paramInt1)).popFromBackStack(true);
            reportBackStackChanged();
            bool1 = true;
          }
        }
        i = -1;
        if ((paramString == null) && (paramInt1 < 0)) {
          break;
        }
        for (j = this.mBackStack.size() - 1; j >= 0; j--)
        {
          paramHandler = (BackStackRecord)this.mBackStack.get(j);
          if (((paramString != null) && (paramString.equals(paramHandler.getName()))) || ((paramInt1 >= 0) && (paramInt1 == paramHandler.mIndex))) {
            break;
          }
        }
        bool1 = bool2;
      } while (j < 0);
      i = j;
      if ((paramInt2 & 0x1) != 0) {
        for (paramInt2 = j - 1;; paramInt2--)
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          paramHandler = (BackStackRecord)this.mBackStack.get(paramInt2);
          if ((paramString == null) || (!paramString.equals(paramHandler.getName())))
          {
            i = paramInt2;
            if (paramInt1 < 0) {
              break;
            }
            i = paramInt2;
            if (paramInt1 != paramHandler.mIndex) {
              break;
            }
          }
        }
      }
      bool1 = bool2;
    } while (i == this.mBackStack.size() - 1);
    paramString = new ArrayList();
    for (paramInt1 = this.mBackStack.size() - 1; paramInt1 > i; paramInt1--) {
      paramString.add(this.mBackStack.remove(paramInt1));
    }
    paramInt2 = paramString.size() - 1;
    paramInt1 = 0;
    label308:
    if (paramInt1 <= paramInt2)
    {
      if (DEBUG) {
        Log.v("FragmentManager", "Popping back stack state: " + paramString.get(paramInt1));
      }
      paramHandler = (BackStackRecord)paramString.get(paramInt1);
      if (paramInt1 != paramInt2) {
        break label377;
      }
    }
    label377:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramHandler.popFromBackStack(bool1);
      paramInt1++;
      break label308;
      break;
    }
  }
  
  public final void putFragment(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public final void removeFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "remove: " + paramFragment + " nesting=" + paramFragment.mBackStackNesting);
    }
    if (!paramFragment.isInBackStack())
    {
      i = 1;
      if ((!paramFragment.mDetached) || (i != 0))
      {
        if (this.mAdded != null) {
          this.mAdded.remove(paramFragment);
        }
        if ((paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
          this.mNeedMenuInvalidate = true;
        }
        paramFragment.mAdded = false;
        paramFragment.mRemoving = true;
        if (i == 0) {
          break label134;
        }
      }
    }
    label134:
    for (int i = 0;; i = 1)
    {
      moveToState(paramFragment, i, paramInt1, paramInt2, false);
      return;
      i = 0;
      break;
    }
  }
  
  public final void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener paramOnBackStackChangedListener)
  {
    if (this.mBackStackChangeListeners != null) {
      this.mBackStackChangeListeners.remove(paramOnBackStackChangedListener);
    }
  }
  
  final void reportBackStackChanged()
  {
    if (this.mBackStackChangeListeners != null) {
      for (int i = 0; i < this.mBackStackChangeListeners.size(); i++) {
        ((FragmentManager.OnBackStackChangedListener)this.mBackStackChangeListeners.get(i)).onBackStackChanged();
      }
    }
  }
  
  final void restoreAllState(Parcelable paramParcelable, ArrayList<Fragment> paramArrayList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
      if (paramParcelable.mActive != null)
      {
        Object localObject2;
        Object localObject1;
        if (paramArrayList != null) {
          for (i = 0; i < paramArrayList.size(); i++)
          {
            localObject2 = (Fragment)paramArrayList.get(i);
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: re-attaching retained " + localObject2);
            }
            localObject1 = paramParcelable.mActive[localObject2.mIndex];
            ((FragmentState)localObject1).mInstance = ((Fragment)localObject2);
            ((Fragment)localObject2).mSavedViewState = null;
            ((Fragment)localObject2).mBackStackNesting = 0;
            ((Fragment)localObject2).mInLayout = false;
            ((Fragment)localObject2).mAdded = false;
            ((Fragment)localObject2).mTarget = null;
            if (((FragmentState)localObject1).mSavedFragmentState != null)
            {
              ((FragmentState)localObject1).mSavedFragmentState.setClassLoader(this.mActivity.getClassLoader());
              ((Fragment)localObject2).mSavedViewState = ((FragmentState)localObject1).mSavedFragmentState.getSparseParcelableArray("android:view_state");
            }
          }
        }
        this.mActive = new ArrayList(paramParcelable.mActive.length);
        if (this.mAvailIndices != null) {
          this.mAvailIndices.clear();
        }
        int i = 0;
        if (i < paramParcelable.mActive.length)
        {
          localObject2 = paramParcelable.mActive[i];
          if (localObject2 != null)
          {
            localObject1 = ((FragmentState)localObject2).instantiate(this.mActivity, this.mParent);
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + localObject1);
            }
            this.mActive.add(localObject1);
            ((FragmentState)localObject2).mInstance = null;
          }
          for (;;)
          {
            i++;
            break;
            this.mActive.add(null);
            if (this.mAvailIndices == null) {
              this.mAvailIndices = new ArrayList();
            }
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: avail #" + i);
            }
            this.mAvailIndices.add(Integer.valueOf(i));
          }
        }
        if (paramArrayList != null)
        {
          i = 0;
          if (i < paramArrayList.size())
          {
            localObject1 = (Fragment)paramArrayList.get(i);
            if (((Fragment)localObject1).mTargetIndex >= 0) {
              if (((Fragment)localObject1).mTargetIndex >= this.mActive.size()) {
                break label439;
              }
            }
            for (((Fragment)localObject1).mTarget = ((Fragment)this.mActive.get(((Fragment)localObject1).mTargetIndex));; ((Fragment)localObject1).mTarget = null)
            {
              i++;
              break;
              label439:
              Log.w("FragmentManager", "Re-attaching retained fragment " + localObject1 + " target no longer exists: " + ((Fragment)localObject1).mTargetIndex);
            }
          }
        }
        if (paramParcelable.mAdded != null)
        {
          this.mAdded = new ArrayList(paramParcelable.mAdded.length);
          for (i = 0; i < paramParcelable.mAdded.length; i++)
          {
            paramArrayList = (Fragment)this.mActive.get(paramParcelable.mAdded[i]);
            if (paramArrayList == null) {
              throwException(new IllegalStateException("No instantiated fragment for index #" + paramParcelable.mAdded[i]));
            }
            paramArrayList.mAdded = true;
            if (DEBUG) {
              Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + paramArrayList);
            }
            if (this.mAdded.contains(paramArrayList)) {
              throw new IllegalStateException("Already added!");
            }
            this.mAdded.add(paramArrayList);
          }
        }
        this.mAdded = null;
        if (paramParcelable.mBackStack != null)
        {
          this.mBackStack = new ArrayList(paramParcelable.mBackStack.length);
          for (i = 0; i < paramParcelable.mBackStack.length; i++)
          {
            paramArrayList = paramParcelable.mBackStack[i].instantiate(this);
            if (DEBUG)
            {
              Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + paramArrayList.mIndex + "): " + paramArrayList);
              paramArrayList.dump("  ", new PrintWriter(new LogWriter("FragmentManager")), false);
            }
            this.mBackStack.add(paramArrayList);
            if (paramArrayList.mIndex >= 0) {
              setBackStackIndex(paramArrayList.mIndex, paramArrayList);
            }
          }
        }
        else
        {
          this.mBackStack = null;
        }
      }
    }
  }
  
  final ArrayList<Fragment> retainNonConfig()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.mActive != null)
    {
      int i = 0;
      localObject2 = localObject1;
      if (i < this.mActive.size())
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        Object localObject3 = localObject1;
        if (localFragment != null)
        {
          localObject3 = localObject1;
          if (localFragment.mRetainInstance)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new ArrayList();
            }
            ((ArrayList)localObject2).add(localFragment);
            localFragment.mRetaining = true;
            if (localFragment.mTarget == null) {
              break label160;
            }
          }
        }
        label160:
        for (int j = localFragment.mTarget.mIndex;; j = -1)
        {
          localFragment.mTargetIndex = j;
          localObject3 = localObject2;
          if (DEBUG)
          {
            Log.v("FragmentManager", "retainNonConfig: keeping retained " + localFragment);
            localObject3 = localObject2;
          }
          i++;
          localObject1 = localObject3;
          break;
        }
      }
    }
    return (ArrayList<Fragment>)localObject2;
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    execPendingActions();
    if (HONEYCOMB) {
      this.mStateSaved = true;
    }
    Object localObject1 = localObject2;
    if (this.mActive != null)
    {
      if (this.mActive.size() <= 0) {
        localObject1 = localObject2;
      }
    }
    else {
      return (Parcelable)localObject1;
    }
    int k = this.mActive.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    label68:
    FragmentState localFragmentState;
    if (j < k)
    {
      localObject1 = (Fragment)this.mActive.get(j);
      if (localObject1 == null) {
        break label721;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        throwException(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localFragmentState = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[j] = localFragmentState;
      if ((((Fragment)localObject1).mState > 0) && (localFragmentState.mSavedFragmentState == null))
      {
        localFragmentState.mSavedFragmentState = saveFragmentBasicState((Fragment)localObject1);
        if (((Fragment)localObject1).mTarget != null)
        {
          if (((Fragment)localObject1).mTarget.mIndex < 0) {
            throwException(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).mTarget));
          }
          if (localFragmentState.mSavedFragmentState == null) {
            localFragmentState.mSavedFragmentState = new Bundle();
          }
          putFragment(localFragmentState.mSavedFragmentState, "android:target_state", ((Fragment)localObject1).mTarget);
          if (((Fragment)localObject1).mTargetRequestCode != 0) {
            localFragmentState.mSavedFragmentState.putInt("android:target_req_state", ((Fragment)localObject1).mTargetRequestCode);
          }
        }
        label307:
        if (DEBUG) {
          Log.v("FragmentManager", "Saved state of " + localObject1 + ": " + localFragmentState.mSavedFragmentState);
        }
        i = 1;
      }
    }
    label721:
    for (;;)
    {
      j++;
      break label68;
      localFragmentState.mSavedFragmentState = ((Fragment)localObject1).mSavedFragmentState;
      break label307;
      if (i == 0)
      {
        localObject1 = localObject2;
        if (!DEBUG) {
          break;
        }
        Log.v("FragmentManager", "saveAllState: no fragments!");
        localObject1 = localObject2;
        break;
      }
      if (this.mAdded != null)
      {
        j = this.mAdded.size();
        if (j > 0)
        {
          localObject2 = new int[j];
          for (i = 0;; i++)
          {
            localObject1 = localObject2;
            if (i >= j) {
              break;
            }
            localObject2[i] = ((Fragment)this.mAdded.get(i)).mIndex;
            if (localObject2[i] < 0) {
              throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(i) + " has cleared index: " + localObject2[i]));
            }
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.mAdded.get(i));
            }
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.mBackStack != null)
      {
        j = this.mBackStack.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          for (i = 0;; i++)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState(this, (BackStackRecord)this.mBackStack.get(i));
            if (DEBUG) {
              Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.mBackStack.get(i));
            }
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).mActive = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).mAdded = ((int[])localObject1);
      ((FragmentManagerState)localObject3).mBackStack = ((BackStackState[])localObject2);
      localObject1 = localObject3;
      break;
    }
  }
  
  final Bundle saveFragmentBasicState(Fragment paramFragment)
  {
    if (this.mStateBundle == null) {
      this.mStateBundle = new Bundle();
    }
    paramFragment.performSaveInstanceState(this.mStateBundle);
    Object localObject2;
    if (!this.mStateBundle.isEmpty())
    {
      localObject2 = this.mStateBundle;
      this.mStateBundle = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        saveFragmentViewState(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.mSavedViewState != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.mSavedViewState);
      }
      localObject2 = localObject1;
      if (!paramFragment.mUserVisibleHint)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.mUserVisibleHint);
      }
      return (Bundle)localObject2;
      localObject2 = null;
    }
  }
  
  public final Fragment.SavedState saveFragmentInstanceState(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      throwException(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = saveFragmentBasicState(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return (Fragment.SavedState)localObject1;
  }
  
  final void saveFragmentViewState(Fragment paramFragment)
  {
    if (paramFragment.mInnerView == null) {
      return;
    }
    if (this.mStateArray == null) {
      this.mStateArray = new SparseArray();
    }
    for (;;)
    {
      paramFragment.mInnerView.saveHierarchyState(this.mStateArray);
      if (this.mStateArray.size() <= 0) {
        break;
      }
      paramFragment.mSavedViewState = this.mStateArray;
      this.mStateArray = null;
      break;
      this.mStateArray.clear();
    }
  }
  
  /* Error */
  public final void setBackStackIndex(int paramInt, BackStackRecord paramBackStackRecord)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   6: ifnonnull +19 -> 25
    //   9: new 241	java/util/ArrayList
    //   12: astore 5
    //   14: aload 5
    //   16: invokespecial 242	java/util/ArrayList:<init>	()V
    //   19: aload_0
    //   20: aload 5
    //   22: putfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   25: aload_0
    //   26: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   29: invokevirtual 303	java/util/ArrayList:size	()I
    //   32: istore 4
    //   34: iload 4
    //   36: istore_3
    //   37: iload_1
    //   38: iload 4
    //   40: if_icmpge +60 -> 100
    //   43: getstatic 85	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   46: ifeq +41 -> 87
    //   49: new 141	java/lang/StringBuilder
    //   52: astore 5
    //   54: aload 5
    //   56: ldc_w 307
    //   59: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: ldc 32
    //   64: aload 5
    //   66: iload_1
    //   67: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: ldc_w 312
    //   73: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_2
    //   77: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 261	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   91: iload_1
    //   92: aload_2
    //   93: invokevirtual 329	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: iload_3
    //   101: iload_1
    //   102: if_icmpge +87 -> 189
    //   105: aload_0
    //   106: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   109: aconst_null
    //   110: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload_0
    //   115: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   118: ifnonnull +19 -> 137
    //   121: new 241	java/util/ArrayList
    //   124: astore 5
    //   126: aload 5
    //   128: invokespecial 242	java/util/ArrayList:<init>	()V
    //   131: aload_0
    //   132: aload 5
    //   134: putfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   137: getstatic 85	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   140: ifeq +31 -> 171
    //   143: new 141	java/lang/StringBuilder
    //   146: astore 5
    //   148: aload 5
    //   150: ldc_w 1132
    //   153: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: ldc 32
    //   158: aload 5
    //   160: iload_3
    //   161: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 261	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   170: pop
    //   171: aload_0
    //   172: getfield 299	android/support/v4/app/FragmentManagerImpl:mAvailBackStackIndices	Ljava/util/ArrayList;
    //   175: iload_3
    //   176: invokestatic 591	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   182: pop
    //   183: iinc 3 1
    //   186: goto -86 -> 100
    //   189: getstatic 85	android/support/v4/app/FragmentManagerImpl:DEBUG	Z
    //   192: ifeq +41 -> 233
    //   195: new 141	java/lang/StringBuilder
    //   198: astore 5
    //   200: aload 5
    //   202: ldc_w 323
    //   205: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: ldc 32
    //   210: aload 5
    //   212: iload_1
    //   213: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: ldc_w 325
    //   219: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_2
    //   223: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 261	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   232: pop
    //   233: aload_0
    //   234: getfield 305	android/support/v4/app/FragmentManagerImpl:mBackStackIndices	Ljava/util/ArrayList;
    //   237: aload_2
    //   238: invokevirtual 246	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   241: pop
    //   242: goto -145 -> 97
    //   245: astore_2
    //   246: aload_0
    //   247: monitorexit
    //   248: aload_2
    //   249: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	FragmentManagerImpl
    //   0	250	1	paramInt	int
    //   0	250	2	paramBackStackRecord	BackStackRecord
    //   36	148	3	i	int
    //   32	9	4	j	int
    //   12	199	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	245	finally
    //   25	34	245	finally
    //   43	87	245	finally
    //   87	97	245	finally
    //   97	99	245	finally
    //   105	137	245	finally
    //   137	171	245	finally
    //   171	183	245	finally
    //   189	233	245	finally
    //   233	242	245	finally
    //   246	248	245	finally
  }
  
  public final void showFragment(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      Log.v("FragmentManager", "show: " + paramFragment);
    }
    if (paramFragment.mHidden)
    {
      paramFragment.mHidden = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = loadAnimation(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null) {
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.mAdded) && (paramFragment.mHasMenu) && (paramFragment.mMenuVisible)) {
        this.mNeedMenuInvalidate = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  final void startPendingDeferredFragments()
  {
    if (this.mActive == null) {}
    for (;;)
    {
      return;
      for (int i = 0; i < this.mActive.size(); i++)
      {
        Fragment localFragment = (Fragment)this.mActive.get(i);
        if (localFragment != null) {
          performPendingDeferredStart(localFragment);
        }
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.mParent != null) {
      DebugUtils.buildShortClassTag(this.mParent, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/app/FragmentManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */