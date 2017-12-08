package com.lantern.core.f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import com.lantern.core.config.HQConf;
import com.lantern.core.config.HQConf.HqAppInfo;
import com.lantern.core.config.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a
  extends AsyncTask<Void, Void, Void>
{
  private static String a = "LaunchThirdPartAPKAsyncTask";
  private HashMap<Integer, ArrayList<HQConf.HqAppInfo>> b = new HashMap();
  private ArrayList<HQConf.HqAppInfo> c = new ArrayList();
  private boolean d = false;
  
  private Void a()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (com.lantern.core.c.getInstance() != null)
        {
          localObject1 = (HQConf)d.a(com.lantern.core.c.getInstance()).a(HQConf.class);
          com.lantern.core.c.getInstance();
          localObject6 = com.lantern.core.c.getAPPLunchedInfoServer().a();
          localArrayList = ((HQConf)localObject1).e();
          if (localArrayList != null) {
            continue;
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject6;
        ArrayList localArrayList;
        HashMap localHashMap;
        Object localObject3;
        int j;
        Object localObject5;
        Object localObject4;
        localException1.printStackTrace();
        continue;
        Object localObject2 = Integer.valueOf(localException1.intValue() + 1);
        continue;
        if (a((HQConf.HqAppInfo)localObject4)) {
          continue;
        }
        com.lantern.core.c.getAPPLunchedInfoServer().a(((HQConf.HqAppInfo)localObject4).getPackageName());
        localObject2 = localObject5;
        try
        {
          if (com.lantern.core.c.getInstance() == null) {
            continue;
          }
          localObject2 = localObject5;
          localObject5 = ((HQConf.HqAppInfo)localObject4).getPackageName().trim();
          localObject2 = localObject5;
          localObject6 = new android/content/Intent;
          localObject2 = localObject5;
          ((Intent)localObject6).<init>(((HQConf.HqAppInfo)localObject4).getAction().trim());
          localObject2 = localObject5;
          ((Intent)localObject6).setPackage(((HQConf.HqAppInfo)localObject4).getPackageName().trim());
          localObject2 = localObject5;
          ((Intent)localObject6).putExtra(((HQConf.HqAppInfo)localObject4).getParam().trim(), com.lantern.core.c.getInstance().getPackageName());
          localObject2 = localObject5;
          com.lantern.core.c.getInstance().startService((Intent)localObject6);
          localObject2 = localObject5;
          localObject4 = com.lantern.analytics.a.e();
          localObject2 = localObject5;
          localObject6 = new java/lang/StringBuilder;
          localObject2 = localObject5;
          ((StringBuilder)localObject6).<init>("cap01");
          localObject2 = localObject5;
          ((com.lantern.analytics.a)localObject4).onEvent((String)localObject5);
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
          localObject5 = com.lantern.analytics.a.e();
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("cap00");
          ((com.lantern.analytics.a)localObject5).onEvent((String)localObject2);
        }
        continue;
        StringBuilder localStringBuilder = null;
        continue;
      }
      return null;
      localHashMap = new java/util/HashMap;
      localHashMap.<init>();
      localObject3 = Integer.valueOf(0);
      j = 0;
      if (j < localArrayList.size())
      {
        localObject5 = Integer.valueOf(((HQConf.HqAppInfo)localArrayList.get(j)).getmLevel());
        localObject1 = localObject3;
        if (((Integer)localObject3).intValue() < ((Integer)localObject5).intValue()) {
          localObject1 = localObject5;
        }
        if (a((HQConf.HqAppInfo)localArrayList.get(j)))
        {
          this.d = true;
          j++;
          localObject3 = localObject1;
        }
        else
        {
          try
          {
            localObject3 = com.lantern.core.c.getInstance().getPackageManager().getPackageInfo(((HQConf.HqAppInfo)localArrayList.get(j)).getPackageName().trim(), 0);
            if (localObject3 == null) {
              continue;
            }
            if (!((com.lantern.core.model.c)localObject6).a().contains(((HQConf.HqAppInfo)localArrayList.get(j)).getPackageName().trim())) {
              continue;
            }
            if (localHashMap.get(localObject5) == null)
            {
              localObject3 = new java/util/ArrayList;
              ((ArrayList)localObject3).<init>();
              ((ArrayList)localObject3).add(localArrayList.get(j));
              localHashMap.put(localObject5, localObject3);
              i = 1;
            }
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            localObject4 = null;
            continue;
            ((ArrayList)localHashMap.get(localObject5)).add(localArrayList.get(j));
            i = 1;
          }
          continue;
          if (this.b.get(localObject5) == null)
          {
            localObject4 = new java/util/ArrayList;
            ((ArrayList)localObject4).<init>();
            ((ArrayList)localObject4).add(localArrayList.get(j));
            this.b.put(localObject5, localObject4);
          }
          else
          {
            ((ArrayList)this.b.get(localObject5)).add(localArrayList.get(j));
          }
        }
      }
      else
      {
        if ((i != 0) && (this.b.isEmpty())) {
          this.b = localHashMap;
        }
        localObject1 = Integer.valueOf(1);
        if (((Integer)localObject1).intValue() <= ((Integer)localObject4).intValue())
        {
          if (this.b.get(localObject1) != null) {
            Collections.shuffle((ArrayList)this.b.get(localObject1));
          }
          localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1);
        }
        else
        {
          localObject1 = Integer.valueOf(1);
          if (((Integer)localObject1).intValue() > ((Integer)localObject4).intValue()) {
            continue;
          }
          if (this.b.get(localObject1) == null) {
            continue;
          }
          localObject4 = (HQConf.HqAppInfo)((ArrayList)this.b.get(localObject1)).get(0);
          localObject5 = "";
          if (localObject4 != null) {
            continue;
          }
          if (this.d) {
            com.lantern.analytics.a.e().onEvent("cap02");
          }
          com.lantern.analytics.a.e().onEvent("cap_null");
        }
      }
    }
  }
  
  private static boolean a(HQConf.HqAppInfo paramHqAppInfo)
  {
    for (;;)
    {
      try
      {
        localObject = ((ActivityManager)com.lantern.core.c.getInstance().getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (localObject != null) {
          continue;
        }
        bool = false;
      }
      catch (Exception paramHqAppInfo)
      {
        Object localObject;
        Iterator localIterator;
        paramHqAppInfo.printStackTrace();
        boolean bool = false;
        continue;
      }
      return bool;
      localIterator = ((List)localObject).iterator();
      if (!localIterator.hasNext()) {
        continue;
      }
      localObject = (ActivityManager.RunningServiceInfo)localIterator.next();
      if ((localObject != null) && (((ActivityManager.RunningServiceInfo)localObject).process != null))
      {
        bool = ((ActivityManager.RunningServiceInfo)localObject).process.contains(paramHqAppInfo.getServiceProcess());
        if (bool) {
          bool = true;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */