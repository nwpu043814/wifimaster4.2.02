package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class LocalBroadcastManager
{
  private static final boolean DEBUG = false;
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  private static final String TAG = "LocalBroadcastManager";
  private static LocalBroadcastManager mInstance;
  private static final Object mLock = new Object();
  private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap();
  private final Context mAppContext;
  private final Handler mHandler;
  private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList();
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap();
  
  private LocalBroadcastManager(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandler = new LocalBroadcastManager.1(this, paramContext.getMainLooper());
  }
  
  private void executePendingBroadcasts()
  {
    for (;;)
    {
      int i;
      synchronized (this.mReceivers)
      {
        i = this.mPendingBroadcasts.size();
        if (i <= 0) {
          return;
        }
        BroadcastRecord[] arrayOfBroadcastRecord = new BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        i = 0;
        if (i >= arrayOfBroadcastRecord.length) {
          continue;
        }
        ??? = arrayOfBroadcastRecord[i];
        int j = 0;
        if (j < ???.receivers.size())
        {
          ((ReceiverRecord)???.receivers.get(j)).receiver.onReceive(this.mAppContext, ???.intent);
          j++;
        }
      }
      i++;
    }
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext)
  {
    synchronized (mLock)
    {
      if (mInstance == null)
      {
        LocalBroadcastManager localLocalBroadcastManager = new android/support/v4/content/LocalBroadcastManager;
        localLocalBroadcastManager.<init>(paramContext.getApplicationContext());
        mInstance = localLocalBroadcastManager;
      }
      paramContext = mInstance;
      return paramContext;
    }
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    synchronized (this.mReceivers)
    {
      ReceiverRecord localReceiverRecord = new android/support/v4/content/LocalBroadcastManager$ReceiverRecord;
      localReceiverRecord.<init>(paramIntentFilter, paramBroadcastReceiver);
      Object localObject2 = (ArrayList)this.mReceivers.get(paramBroadcastReceiver);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new java/util/ArrayList;
        ((ArrayList)localObject1).<init>(1);
        this.mReceivers.put(paramBroadcastReceiver, localObject1);
      }
      ((ArrayList)localObject1).add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++)
      {
        localObject2 = paramIntentFilter.getAction(i);
        localObject1 = (ArrayList)this.mActions.get(localObject2);
        paramBroadcastReceiver = (BroadcastReceiver)localObject1;
        if (localObject1 == null)
        {
          paramBroadcastReceiver = new java/util/ArrayList;
          paramBroadcastReceiver.<init>(1);
          this.mActions.put(localObject2, paramBroadcastReceiver);
        }
        paramBroadcastReceiver.add(localReceiverRecord);
      }
      return;
    }
  }
  
  public boolean sendBroadcast(Intent paramIntent)
  {
    label420:
    label451:
    label542:
    label551:
    for (;;)
    {
      Object localObject3;
      int i;
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      int k;
      synchronized (this.mReceivers)
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
        localObject3 = paramIntent.getData();
        String str3 = paramIntent.getScheme();
        Set localSet = paramIntent.getCategories();
        if ((paramIntent.getFlags() & 0x8) != 0)
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>("Resolving type ");
            Log.v("LocalBroadcastManager", str1 + " scheme " + str3 + " of intent " + paramIntent);
          }
          ArrayList localArrayList = (ArrayList)this.mActions.get(paramIntent.getAction());
          if (localArrayList == null) {
            break label542;
          }
          if (i != 0)
          {
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>("Action list: ");
            Log.v("LocalBroadcastManager", localArrayList);
          }
          localObject1 = null;
          int j = 0;
          if (j >= localArrayList.size()) {
            break label451;
          }
          localObject2 = (ReceiverRecord)localArrayList.get(j);
          if (i != 0)
          {
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("Matching against filter ");
            Log.v("LocalBroadcastManager", ((ReceiverRecord)localObject2).filter);
          }
          if (((ReceiverRecord)localObject2).broadcasting)
          {
            if (i == 0) {
              break label420;
            }
            Log.v("LocalBroadcastManager", "  Filter's target already added");
            j++;
            continue;
          }
        }
        else
        {
          i = 0;
          continue;
        }
        k = ((ReceiverRecord)localObject2).filter.match(str2, str1, str3, (Uri)localObject3, localSet, "LocalBroadcastManager");
        if (k >= 0)
        {
          if (i != 0)
          {
            localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>("  Filter matched!  match=0x");
            Log.v("LocalBroadcastManager", Integer.toHexString(k));
          }
          if (localObject1 != null) {
            break label551;
          }
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>();
          ((ArrayList)localObject1).add(localObject2);
          ((ReceiverRecord)localObject2).broadcasting = true;
        }
      }
      if (i != 0) {
        switch (k)
        {
        default: 
          localObject2 = "unknown reason";
        }
      }
      for (;;)
      {
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("  Filter did not match: ");
        Log.v("LocalBroadcastManager", (String)localObject2);
        break;
        localObject2 = "action";
        continue;
        localObject2 = "category";
        continue;
        localObject2 = "data";
        continue;
        localObject2 = "type";
      }
      boolean bool;
      if (localObject1 != null)
      {
        for (i = 0; i < ((ArrayList)localObject1).size(); i++) {
          ((ReceiverRecord)((ArrayList)localObject1).get(i)).broadcasting = false;
        }
        localObject2 = this.mPendingBroadcasts;
        localObject3 = new android/support/v4/content/LocalBroadcastManager$BroadcastRecord;
        ((BroadcastRecord)localObject3).<init>(paramIntent, (ArrayList)localObject1);
        ((ArrayList)localObject2).add(localObject3);
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
        bool = true;
      }
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
  }
  
  public void sendBroadcastSync(Intent paramIntent)
  {
    if (sendBroadcast(paramIntent)) {
      executePendingBroadcasts();
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    label179:
    for (;;)
    {
      synchronized (this.mReceivers)
      {
        ArrayList localArrayList1 = (ArrayList)this.mReceivers.remove(paramBroadcastReceiver);
        if (localArrayList1 == null) {
          return;
        }
        int j = 0;
        if (j < localArrayList1.size())
        {
          IntentFilter localIntentFilter = (IntentFilter)localArrayList1.get(j);
          int k = 0;
          if (k < localIntentFilter.countActions())
          {
            String str = localIntentFilter.getAction(k);
            ArrayList localArrayList2 = (ArrayList)this.mActions.get(str);
            if (localArrayList2 != null)
            {
              int i = 0;
              if (i < localArrayList2.size())
              {
                if (((ReceiverRecord)localArrayList2.get(i)).receiver != paramBroadcastReceiver) {
                  break label179;
                }
                localArrayList2.remove(i);
                i--;
                i++;
                continue;
              }
              if (localArrayList2.size() <= 0) {
                this.mActions.remove(str);
              }
            }
            k++;
            continue;
          }
          j++;
        }
      }
    }
  }
  
  private static class BroadcastRecord
  {
    final Intent intent;
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
    
    BroadcastRecord(Intent paramIntent, ArrayList<LocalBroadcastManager.ReceiverRecord> paramArrayList)
    {
      this.intent = paramIntent;
      this.receivers = paramArrayList;
    }
  }
  
  private static class ReceiverRecord
  {
    boolean broadcasting;
    final IntentFilter filter;
    final BroadcastReceiver receiver;
    
    ReceiverRecord(IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
    {
      this.filter = paramIntentFilter;
      this.receiver = paramBroadcastReceiver;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      localStringBuilder.append("Receiver{");
      localStringBuilder.append(this.receiver);
      localStringBuilder.append(" filter=");
      localStringBuilder.append(this.filter);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/LocalBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */