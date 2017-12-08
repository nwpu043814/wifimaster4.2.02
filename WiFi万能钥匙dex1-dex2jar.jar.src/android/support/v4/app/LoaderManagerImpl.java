package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl
  extends LoaderManager
{
  static boolean DEBUG = false;
  static final String TAG = "LoaderManager";
  FragmentActivity mActivity;
  boolean mCreatingLoader;
  final SparseArrayCompat<LoaderInfo> mInactiveLoaders = new SparseArrayCompat();
  final SparseArrayCompat<LoaderInfo> mLoaders = new SparseArrayCompat();
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  final String mWho;
  
  LoaderManagerImpl(String paramString, FragmentActivity paramFragmentActivity, boolean paramBoolean)
  {
    this.mWho = paramString;
    this.mActivity = paramFragmentActivity;
    this.mStarted = paramBoolean;
  }
  
  private LoaderInfo createAndInstallLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    try
    {
      this.mCreatingLoader = true;
      paramBundle = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      installLoader(paramBundle);
      return paramBundle;
    }
    finally
    {
      this.mCreatingLoader = false;
    }
  }
  
  private LoaderInfo createLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
  {
    LoaderInfo localLoaderInfo = new LoaderInfo(paramInt, paramBundle, paramLoaderCallbacks);
    localLoaderInfo.mLoader = paramLoaderCallbacks.onCreateLoader(paramInt, paramBundle);
    return localLoaderInfo;
  }
  
  public void destroyLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    if (DEBUG) {
      Log.v("LoaderManager", "destroyLoader in " + this + " of " + paramInt);
    }
    int i = this.mLoaders.indexOfKey(paramInt);
    LoaderInfo localLoaderInfo;
    if (i >= 0)
    {
      localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      this.mLoaders.removeAt(i);
      localLoaderInfo.destroy();
    }
    paramInt = this.mInactiveLoaders.indexOfKey(paramInt);
    if (paramInt >= 0)
    {
      localLoaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(paramInt);
      this.mInactiveLoaders.removeAt(paramInt);
      localLoaderInfo.destroy();
    }
    if ((this.mActivity != null) && (!hasRunningLoaders())) {
      this.mActivity.mFragments.startPendingDeferredFragments();
    }
  }
  
  void doDestroy()
  {
    if (!this.mRetaining)
    {
      if (DEBUG) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
      for (i = this.mLoaders.size() - 1; i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).destroy();
      }
      this.mLoaders.clear();
    }
    if (DEBUG) {
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    }
    for (int i = this.mInactiveLoaders.size() - 1; i >= 0; i--) {
      ((LoaderInfo)this.mInactiveLoaders.valueAt(i)).destroy();
    }
    this.mInactiveLoaders.clear();
  }
  
  void doReportNextStart()
  {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
      ((LoaderInfo)this.mLoaders.valueAt(i)).mReportNextStart = true;
    }
  }
  
  void doReportStart()
  {
    for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
      ((LoaderInfo)this.mLoaders.valueAt(i)).reportStart();
    }
  }
  
  void doRetain()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.mRetaining = true;
      this.mStarted = false;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).retain();
      }
    }
  }
  
  void doStart()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    if (this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.mStarted = true;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).start();
      }
    }
  }
  
  void doStop()
  {
    if (DEBUG) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (!this.mStarted)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).stop();
      }
      this.mStarted = false;
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    LoaderInfo localLoaderInfo;
    if (this.mLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      for (i = 0; i < this.mLoaders.size(); i++)
      {
        localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
    if (this.mInactiveLoaders.size() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      for (i = j; i < this.mInactiveLoaders.size(); i++)
      {
        localLoaderInfo = (LoaderInfo)this.mInactiveLoaders.valueAt(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.mInactiveLoaders.keyAt(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localLoaderInfo.toString());
        localLoaderInfo.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
  }
  
  void finishRetain()
  {
    if (this.mRetaining)
    {
      if (DEBUG) {
        Log.v("LoaderManager", "Finished Retaining in " + this);
      }
      this.mRetaining = false;
      for (int i = this.mLoaders.size() - 1; i >= 0; i--) {
        ((LoaderInfo)this.mLoaders.valueAt(i)).finishRetain();
      }
    }
  }
  
  public <D> Loader<D> getLoader(int paramInt)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    Object localObject = (LoaderInfo)this.mLoaders.get(paramInt);
    if (localObject != null) {
      if (((LoaderInfo)localObject).mPendingLoader != null) {
        localObject = ((LoaderInfo)localObject).mPendingLoader.mLoader;
      }
    }
    for (;;)
    {
      return (Loader<D>)localObject;
      localObject = ((LoaderInfo)localObject).mLoader;
      continue;
      localObject = null;
    }
  }
  
  public boolean hasRunningLoaders()
  {
    int j = this.mLoaders.size();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.valueAt(i);
      if ((localLoaderInfo.mStarted) && (!localLoaderInfo.mDeliveredData)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i++;
        break;
      }
    }
    return bool2;
  }
  
  public <D> Loader<D> initLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG) {
      Log.v("LoaderManager", "initLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo == null)
    {
      paramLoaderCallbacks = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks);
      paramBundle = paramLoaderCallbacks;
      if (DEBUG) {
        Log.v("LoaderManager", "  Created new loader " + paramLoaderCallbacks);
      }
    }
    for (paramBundle = paramLoaderCallbacks;; paramBundle = localLoaderInfo)
    {
      if ((paramBundle.mHaveData) && (this.mStarted)) {
        paramBundle.callOnLoadFinished(paramBundle.mLoader, paramBundle.mData);
      }
      return paramBundle.mLoader;
      if (DEBUG) {
        Log.v("LoaderManager", "  Re-using existing loader " + localLoaderInfo);
      }
      localLoaderInfo.mCallbacks = paramLoaderCallbacks;
    }
  }
  
  void installLoader(LoaderInfo paramLoaderInfo)
  {
    this.mLoaders.put(paramLoaderInfo.mId, paramLoaderInfo);
    if (this.mStarted) {
      paramLoaderInfo.start();
    }
  }
  
  public <D> Loader<D> restartLoader(int paramInt, Bundle paramBundle, LoaderManager.LoaderCallbacks<D> paramLoaderCallbacks)
  {
    if (this.mCreatingLoader) {
      throw new IllegalStateException("Called while creating a loader");
    }
    LoaderInfo localLoaderInfo1 = (LoaderInfo)this.mLoaders.get(paramInt);
    if (DEBUG) {
      Log.v("LoaderManager", "restartLoader in " + this + ": args=" + paramBundle);
    }
    if (localLoaderInfo1 != null)
    {
      LoaderInfo localLoaderInfo2 = (LoaderInfo)this.mInactiveLoaders.get(paramInt);
      if (localLoaderInfo2 == null) {
        break label305;
      }
      if (!localLoaderInfo1.mHaveData) {
        break label171;
      }
      if (DEBUG) {
        Log.v("LoaderManager", "  Removing last inactive loader: " + localLoaderInfo1);
      }
      localLoaderInfo2.mDeliveredData = false;
      localLoaderInfo2.destroy();
    }
    for (;;)
    {
      localLoaderInfo1.mLoader.abandon();
      this.mInactiveLoaders.put(paramInt, localLoaderInfo1);
      for (paramBundle = createAndInstallLoader(paramInt, paramBundle, paramLoaderCallbacks).mLoader;; paramBundle = localLoaderInfo1.mPendingLoader.mLoader)
      {
        return paramBundle;
        label171:
        if (!localLoaderInfo1.mStarted)
        {
          if (DEBUG) {
            Log.v("LoaderManager", "  Current loader is stopped; replacing");
          }
          this.mLoaders.put(paramInt, null);
          localLoaderInfo1.destroy();
          break;
        }
        if (localLoaderInfo1.mPendingLoader != null)
        {
          if (DEBUG) {
            Log.v("LoaderManager", "  Removing pending loader: " + localLoaderInfo1.mPendingLoader);
          }
          localLoaderInfo1.mPendingLoader.destroy();
          localLoaderInfo1.mPendingLoader = null;
        }
        if (DEBUG) {
          Log.v("LoaderManager", "  Enqueuing as new pending loader");
        }
        localLoaderInfo1.mPendingLoader = createLoader(paramInt, paramBundle, paramLoaderCallbacks);
      }
      label305:
      if (DEBUG) {
        Log.v("LoaderManager", "  Making last loader inactive: " + localLoaderInfo1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    DebugUtils.buildShortClassTag(this.mActivity, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
  
  void updateActivity(FragmentActivity paramFragmentActivity)
  {
    this.mActivity = paramFragmentActivity;
  }
  
  final class LoaderInfo
    implements Loader.OnLoadCompleteListener<Object>
  {
    final Bundle mArgs;
    LoaderManager.LoaderCallbacks<Object> mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    Loader<Object> mLoader;
    LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    
    public LoaderInfo(Bundle paramBundle, LoaderManager.LoaderCallbacks<Object> paramLoaderCallbacks)
    {
      this.mId = paramBundle;
      this.mArgs = paramLoaderCallbacks;
      LoaderManager.LoaderCallbacks localLoaderCallbacks;
      this.mCallbacks = localLoaderCallbacks;
    }
    
    final void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
    {
      String str;
      if (this.mCallbacks != null)
      {
        if (LoaderManagerImpl.this.mActivity == null) {
          break label160;
        }
        str = LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause;
        LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
      }
      for (;;)
      {
        try
        {
          if (LoaderManagerImpl.DEBUG)
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("  onLoadFinished in ");
            Log.v("LoaderManager", paramLoader + ": " + paramLoader.dataToString(paramObject));
          }
          this.mCallbacks.onLoadFinished(paramLoader, paramObject);
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
          this.mDeliveredData = true;
          return;
        }
        finally
        {
          if (LoaderManagerImpl.this.mActivity != null) {
            LoaderManagerImpl.this.mActivity.mFragments.mNoTransactionsBecause = str;
          }
        }
        label160:
        str = null;
      }
    }
    
    /* Error */
    final void destroy()
    {
      // Byte code:
      //   0: aload_0
      //   1: astore_2
      //   2: getstatic 74	android/support/v4/app/LoaderManagerImpl:DEBUG	Z
      //   5: ifeq +25 -> 30
      //   8: ldc 83
      //   10: new 76	java/lang/StringBuilder
      //   13: dup
      //   14: ldc 118
      //   16: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   19: aload_2
      //   20: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   23: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: invokestatic 108	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   29: pop
      //   30: aload_2
      //   31: iconst_1
      //   32: putfield 120	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDestroyed	Z
      //   35: aload_2
      //   36: getfield 114	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDeliveredData	Z
      //   39: istore_1
      //   40: aload_2
      //   41: iconst_0
      //   42: putfield 114	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDeliveredData	Z
      //   45: aload_2
      //   46: getfield 48	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   49: ifnull +125 -> 174
      //   52: aload_2
      //   53: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
      //   56: ifnull +118 -> 174
      //   59: aload_2
      //   60: getfield 124	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mHaveData	Z
      //   63: ifeq +111 -> 174
      //   66: iload_1
      //   67: ifeq +107 -> 174
      //   70: getstatic 74	android/support/v4/app/LoaderManagerImpl:DEBUG	Z
      //   73: ifeq +25 -> 98
      //   76: ldc 83
      //   78: new 76	java/lang/StringBuilder
      //   81: dup
      //   82: ldc 126
      //   84: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   87: aload_2
      //   88: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   91: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   94: invokestatic 108	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   97: pop
      //   98: aload_2
      //   99: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   102: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   105: ifnull +163 -> 268
      //   108: aload_2
      //   109: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   112: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   115: getfield 63	android/support/v4/app/FragmentActivity:mFragments	Landroid/support/v4/app/FragmentManagerImpl;
      //   118: getfield 69	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
      //   121: astore_3
      //   122: aload_2
      //   123: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   126: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   129: getfield 63	android/support/v4/app/FragmentActivity:mFragments	Landroid/support/v4/app/FragmentManagerImpl;
      //   132: ldc -128
      //   134: putfield 69	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
      //   137: aload_2
      //   138: getfield 48	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   141: aload_2
      //   142: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
      //   145: invokeinterface 131 2 0
      //   150: aload_2
      //   151: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   154: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   157: ifnull +17 -> 174
      //   160: aload_2
      //   161: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   164: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   167: getfield 63	android/support/v4/app/FragmentActivity:mFragments	Landroid/support/v4/app/FragmentManagerImpl;
      //   170: aload_3
      //   171: putfield 69	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
      //   174: aload_2
      //   175: aconst_null
      //   176: putfield 48	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
      //   179: aload_2
      //   180: aconst_null
      //   181: putfield 133	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mData	Ljava/lang/Object;
      //   184: aload_2
      //   185: iconst_0
      //   186: putfield 124	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mHaveData	Z
      //   189: aload_2
      //   190: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
      //   193: ifnull +30 -> 223
      //   196: aload_2
      //   197: getfield 135	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mListenerRegistered	Z
      //   200: ifeq +16 -> 216
      //   203: aload_2
      //   204: iconst_0
      //   205: putfield 135	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mListenerRegistered	Z
      //   208: aload_2
      //   209: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
      //   212: aload_2
      //   213: invokevirtual 139	android/support/v4/content/Loader:unregisterListener	(Landroid/support/v4/content/Loader$OnLoadCompleteListener;)V
      //   216: aload_2
      //   217: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
      //   220: invokevirtual 142	android/support/v4/content/Loader:reset	()V
      //   223: aload_2
      //   224: getfield 144	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mPendingLoader	Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   227: ifnull +40 -> 267
      //   230: aload_2
      //   231: getfield 144	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mPendingLoader	Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
      //   234: astore_2
      //   235: goto -233 -> 2
      //   238: astore 4
      //   240: aload_2
      //   241: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   244: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   247: ifnull +17 -> 264
      //   250: aload_2
      //   251: getfield 39	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
      //   254: getfield 57	android/support/v4/app/LoaderManagerImpl:mActivity	Landroid/support/v4/app/FragmentActivity;
      //   257: getfield 63	android/support/v4/app/FragmentActivity:mFragments	Landroid/support/v4/app/FragmentManagerImpl;
      //   260: aload_3
      //   261: putfield 69	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
      //   264: aload 4
      //   266: athrow
      //   267: return
      //   268: aconst_null
      //   269: astore_3
      //   270: goto -133 -> 137
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	273	0	this	LoaderInfo
      //   39	28	1	bool	boolean
      //   1	250	2	localLoaderInfo	LoaderInfo
      //   121	149	3	str	String
      //   238	27	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   137	150	238	finally
    }
    
    public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
    {
      String str = paramString;
      paramString = this;
      for (;;)
      {
        paramPrintWriter.print(str);
        paramPrintWriter.print("mId=");
        paramPrintWriter.print(paramString.mId);
        paramPrintWriter.print(" mArgs=");
        paramPrintWriter.println(paramString.mArgs);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mCallbacks=");
        paramPrintWriter.println(paramString.mCallbacks);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mLoader=");
        paramPrintWriter.println(paramString.mLoader);
        if (paramString.mLoader != null) {
          paramString.mLoader.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        }
        if ((paramString.mHaveData) || (paramString.mDeliveredData))
        {
          paramPrintWriter.print(str);
          paramPrintWriter.print("mHaveData=");
          paramPrintWriter.print(paramString.mHaveData);
          paramPrintWriter.print("  mDeliveredData=");
          paramPrintWriter.println(paramString.mDeliveredData);
          paramPrintWriter.print(str);
          paramPrintWriter.print("mData=");
          paramPrintWriter.println(paramString.mData);
        }
        paramPrintWriter.print(str);
        paramPrintWriter.print("mStarted=");
        paramPrintWriter.print(paramString.mStarted);
        paramPrintWriter.print(" mReportNextStart=");
        paramPrintWriter.print(paramString.mReportNextStart);
        paramPrintWriter.print(" mDestroyed=");
        paramPrintWriter.println(paramString.mDestroyed);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mRetaining=");
        paramPrintWriter.print(paramString.mRetaining);
        paramPrintWriter.print(" mRetainingStarted=");
        paramPrintWriter.print(paramString.mRetainingStarted);
        paramPrintWriter.print(" mListenerRegistered=");
        paramPrintWriter.println(paramString.mListenerRegistered);
        if (paramString.mPendingLoader == null) {
          break;
        }
        paramPrintWriter.print(str);
        paramPrintWriter.println("Pending Loader ");
        paramPrintWriter.print(paramString.mPendingLoader);
        paramPrintWriter.println(":");
        paramString = paramString.mPendingLoader;
        str = str + "  ";
      }
    }
    
    final void finishRetain()
    {
      if (this.mRetaining)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Finished Retaining: " + this);
        }
        this.mRetaining = false;
        if ((this.mStarted != this.mRetainingStarted) && (!this.mStarted)) {
          stop();
        }
      }
      if ((this.mStarted) && (this.mHaveData) && (!this.mReportNextStart)) {
        callOnLoadFinished(this.mLoader, this.mData);
      }
    }
    
    public final void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "onLoadComplete: " + this);
      }
      if (this.mDestroyed) {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
        }
      }
      for (;;)
      {
        return;
        if (LoaderManagerImpl.this.mLoaders.get(this.mId) != this)
        {
          if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
          }
        }
        else
        {
          LoaderInfo localLoaderInfo = this.mPendingLoader;
          if (localLoaderInfo != null)
          {
            if (LoaderManagerImpl.DEBUG) {
              Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
            }
            this.mPendingLoader = null;
            LoaderManagerImpl.this.mLoaders.put(this.mId, null);
            destroy();
            LoaderManagerImpl.this.installLoader(localLoaderInfo);
          }
          else
          {
            if ((this.mData != paramObject) || (!this.mHaveData))
            {
              this.mData = paramObject;
              this.mHaveData = true;
              if (this.mStarted) {
                callOnLoadFinished(paramLoader, paramObject);
              }
            }
            paramLoader = (LoaderInfo)LoaderManagerImpl.this.mInactiveLoaders.get(this.mId);
            if ((paramLoader != null) && (paramLoader != this))
            {
              paramLoader.mDeliveredData = false;
              paramLoader.destroy();
              LoaderManagerImpl.this.mInactiveLoaders.remove(this.mId);
            }
            if ((LoaderManagerImpl.this.mActivity != null) && (!LoaderManagerImpl.this.hasRunningLoaders())) {
              LoaderManagerImpl.this.mActivity.mFragments.startPendingDeferredFragments();
            }
          }
        }
      }
    }
    
    final void reportStart()
    {
      if ((this.mStarted) && (this.mReportNextStart))
      {
        this.mReportNextStart = false;
        if (this.mHaveData) {
          callOnLoadFinished(this.mLoader, this.mData);
        }
      }
    }
    
    final void retain()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Retaining: " + this);
      }
      this.mRetaining = true;
      this.mRetainingStarted = this.mStarted;
      this.mStarted = false;
      this.mCallbacks = null;
    }
    
    final void start()
    {
      if ((this.mRetaining) && (this.mRetainingStarted)) {
        this.mStarted = true;
      }
      for (;;)
      {
        return;
        if (!this.mStarted)
        {
          this.mStarted = true;
          if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Starting: " + this);
          }
          if ((this.mLoader == null) && (this.mCallbacks != null)) {
            this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
          }
          if (this.mLoader != null)
          {
            if ((this.mLoader.getClass().isMemberClass()) && (!Modifier.isStatic(this.mLoader.getClass().getModifiers()))) {
              throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
            }
            if (!this.mListenerRegistered)
            {
              this.mLoader.registerListener(this.mId, this);
              this.mListenerRegistered = true;
            }
            this.mLoader.startLoading();
          }
        }
      }
    }
    
    final void stop()
    {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Stopping: " + this);
      }
      this.mStarted = false;
      if ((!this.mRetaining) && (this.mLoader != null) && (this.mListenerRegistered))
      {
        this.mListenerRegistered = false;
        this.mLoader.unregisterListener(this);
        this.mLoader.stopLoading();
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(64);
      localStringBuilder.append("LoaderInfo{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mId);
      localStringBuilder.append(" : ");
      DebugUtils.buildShortClassTag(this.mLoader, localStringBuilder);
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/app/LoaderManagerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */