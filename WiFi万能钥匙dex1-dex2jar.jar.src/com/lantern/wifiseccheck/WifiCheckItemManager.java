package com.lantern.wifiseccheck;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.DhcpInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.item.CheckItemARP;
import com.lantern.wifiseccheck.item.CheckItemDNS;
import com.lantern.wifiseccheck.item.CheckItemLocation;
import com.lantern.wifiseccheck.item.CheckItemNeighbor;
import com.lantern.wifiseccheck.item.CheckItemSSL;
import com.lantern.wifiseccheck.item.CheckItemWebMd5;
import com.lantern.wifiseccheck.item.ICheckItem;
import com.lantern.wifiseccheck.preferences.ExtraParamsUtils;
import com.lantern.wifiseccheck.protocol.ApInfoFromClient;
import com.lantern.wifiseccheck.protocol.ApInfoFromClient.CertificationRobust;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WifiCheckItemManager
{
  private static final String TAG = "WifiCheckItemManager";
  private Map<Integer, ICheckItem> finishCheckItems = new HashMap();
  private ApInfoFromClient mClientInfo = new ApInfoFromClient();
  private Application mContext;
  private Map<Integer, ICheckItem> needTimeoutCheckItems = new HashMap();
  private Map<Integer, ICheckItem> normalCheckItems = new HashMap();
  
  public WifiCheckItemManager(WifiSecCheckManager.WifiCheckListener paramWifiCheckListener, Application paramApplication)
  {
    init(paramWifiCheckListener, paramApplication);
  }
  
  private void fillAppIDAndChannel(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (localApplicationInfo != null)
      {
        paramContext = localApplicationInfo.metaData.getString("conn_chanid");
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("conn_chanid is ");
        LogUtils.d("WifiCheckItemManager", paramContext);
        if (!TextUtils.isEmpty(paramContext)) {
          this.mClientInfo.setChannel(paramContext);
        }
        localObject = localApplicationInfo.metaData.getString("WK_APP_ID");
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>("app id is ");
        LogUtils.d("WifiCheckItemManager", (String)localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          this.mClientInfo.setAppID((String)localObject);
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void init(WifiSecCheckManager.WifiCheckListener paramWifiCheckListener, Application paramApplication)
  {
    this.mContext = paramApplication;
    int i = WifiUtils.getSecurityLevel(paramApplication);
    if ((i >= 0) && (i < ApInfoFromClient.CertificationRobust.values().length)) {
      this.mClientInfo.setCertificationRobust(ApInfoFromClient.CertificationRobust.values()[i]);
    }
    this.mClientInfo.setDhid(paramWifiCheckListener.getDhid());
    this.mClientInfo.setMac(WifiUtils.getAPMacAddress(paramApplication));
    this.mClientInfo.setPortalDetected(Boolean.valueOf(true));
    this.mClientInfo.setSsid(WifiUtils.getWifiName(paramApplication));
    this.mClientInfo.setGateway(Integer.valueOf(WifiUtils.getDhcpInfo(paramApplication).gateway));
    this.mClientInfo.setNetmask(Integer.valueOf(WifiUtils.getNetmask(paramApplication)));
    this.mClientInfo.setDnsArray(WifiUtils.getDNSArray(paramApplication));
    this.mClientInfo.setAppBaseAttr(Utils.getAppBaseAttr(paramWifiCheckListener, paramApplication));
    this.mClientInfo.setProtocolVer(ApInfoFromClient.PROTOCOL_VER);
    this.mClientInfo.setExtraParamsVer(ExtraParamsUtils.getParamsVer(paramApplication));
    this.mClientInfo.setVpnOpened(SvpnShared.getInstance().isVpnStarted());
    this.mClientInfo.setSource(paramWifiCheckListener.getSource());
    fillAppIDAndChannel(paramApplication);
  }
  
  private void insertItemToClientInfo(ICheckItem paramICheckItem)
  {
    if ((paramICheckItem instanceof CheckItemARP))
    {
      paramICheckItem = (CheckItemARP)paramICheckItem;
      this.mClientInfo.setArpAbnormal(paramICheckItem.isHasArp());
    }
    for (;;)
    {
      return;
      if ((paramICheckItem instanceof CheckItemNeighbor))
      {
        paramICheckItem = (CheckItemNeighbor)paramICheckItem;
        this.mClientInfo.setCurrentNumberOfUsers(Integer.valueOf(paramICheckItem.getNeighbors().size()));
        this.mClientInfo.setNeighbourLits(paramICheckItem.getNeighbors());
        this.mClientInfo.setNeighbourPercent(Integer.valueOf(paramICheckItem.getPercent()));
      }
      else if ((paramICheckItem instanceof CheckItemWebMd5))
      {
        paramICheckItem = (CheckItemWebMd5)paramICheckItem;
        this.mClientInfo.setWebMd5Results(paramICheckItem.getWebMd5Results());
      }
      else if ((paramICheckItem instanceof CheckItemDNS))
      {
        paramICheckItem = (CheckItemDNS)paramICheckItem;
        this.mClientInfo.setDomainResults(paramICheckItem.getDomainResults());
      }
      else if ((paramICheckItem instanceof CheckItemSSL))
      {
        paramICheckItem = (CheckItemSSL)paramICheckItem;
        this.mClientInfo.setSslCertResults(paramICheckItem.getSSLCertResults());
      }
      else if ((paramICheckItem instanceof CheckItemLocation))
      {
        paramICheckItem = (CheckItemLocation)paramICheckItem;
        this.mClientInfo.setGpsCoordinate(paramICheckItem.getLocation());
      }
    }
  }
  
  /* Error */
  public void addCheckItem(ICheckItem paramICheckItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 319	com/lantern/wifiseccheck/item/ICheckItem:isTimeOutType	()Z
    //   6: ifeq +24 -> 30
    //   9: aload_0
    //   10: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   13: aload_1
    //   14: invokevirtual 322	com/lantern/wifiseccheck/item/ICheckItem:getType	()I
    //   17: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: aload_1
    //   21: invokeinterface 328 3 0
    //   26: pop
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_0
    //   31: getfield 31	com/lantern/wifiseccheck/WifiCheckItemManager:normalCheckItems	Ljava/util/Map;
    //   34: aload_1
    //   35: invokevirtual 322	com/lantern/wifiseccheck/item/ICheckItem:getType	()I
    //   38: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aload_1
    //   42: invokeinterface 328 3 0
    //   47: pop
    //   48: goto -21 -> 27
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	WifiCheckItemManager
    //   0	56	1	paramICheckItem	ICheckItem
    // Exception table:
    //   from	to	target	type
    //   2	27	51	finally
    //   30	48	51	finally
  }
  
  public ICheckItem getCheckItem(int paramInt)
  {
    try
    {
      if (this.needTimeoutCheckItems.containsKey(Integer.valueOf(paramInt))) {
        localObject1 = (ICheckItem)this.needTimeoutCheckItems.get(Integer.valueOf(paramInt));
      }
      for (;;)
      {
        return (ICheckItem)localObject1;
        if (this.normalCheckItems.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = (ICheckItem)this.normalCheckItems.get(Integer.valueOf(paramInt));
        }
        else
        {
          if (!this.finishCheckItems.containsKey(Integer.valueOf(paramInt))) {
            break;
          }
          localObject1 = (ICheckItem)this.finishCheckItems.get(Integer.valueOf(paramInt));
        }
      }
      NullPointerException localNullPointerException = new java/lang/NullPointerException;
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>(" WifiCheckManager has no key as ");
      localNullPointerException.<init>(paramInt);
      throw localNullPointerException;
    }
    finally {}
  }
  
  public ApInfoFromClient getClientInfo()
  {
    Object localObject2 = this.needTimeoutCheckItems.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Integer)((Iterator)localObject2).next();
      insertItemToClientInfo((ICheckItem)this.needTimeoutCheckItems.get(localObject1));
    }
    Object localObject1 = this.finishCheckItems.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      insertItemToClientInfo((ICheckItem)this.finishCheckItems.get(localObject2));
    }
    localObject1 = this.normalCheckItems.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      insertItemToClientInfo((ICheckItem)this.normalCheckItems.get(localObject2));
    }
    return this.mClientInfo;
  }
  
  public String getClientInfoJson()
  {
    Iterator localIterator = this.needTimeoutCheckItems.keySet().iterator();
    Integer localInteger;
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      insertItemToClientInfo((ICheckItem)this.needTimeoutCheckItems.get(localInteger));
    }
    localIterator = this.finishCheckItems.keySet().iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      insertItemToClientInfo((ICheckItem)this.finishCheckItems.get(localInteger));
    }
    localIterator = this.normalCheckItems.keySet().iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      insertItemToClientInfo((ICheckItem)this.normalCheckItems.get(localInteger));
    }
    return JSON.toJSONString(this.mClientInfo);
  }
  
  /* Error */
  public ICheckItem getNoCheckItem(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 334 2 0
    //   15: ifeq +24 -> 39
    //   18: aload_0
    //   19: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   22: iload_1
    //   23: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: invokeinterface 338 2 0
    //   31: checkcast 316	com/lantern/wifiseccheck/item/ICheckItem
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: areturn
    //   39: aload_0
    //   40: getfield 31	com/lantern/wifiseccheck/WifiCheckItemManager:normalCheckItems	Ljava/util/Map;
    //   43: iload_1
    //   44: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokeinterface 338 2 0
    //   52: checkcast 316	com/lantern/wifiseccheck/item/ICheckItem
    //   55: astore_2
    //   56: goto -21 -> 35
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	WifiCheckItemManager
    //   0	64	1	paramInt	int
    //   34	22	2	localICheckItem	ICheckItem
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	59	finally
    //   39	56	59	finally
  }
  
  public void reset()
  {
    try
    {
      this.needTimeoutCheckItems.clear();
      this.finishCheckItems.clear();
      this.normalCheckItems.clear();
      return;
    }
    finally {}
  }
  
  public void setRepeatCertificationRobust()
  {
    int i = WifiUtils.getSecurityLevel(this.mContext);
    if ((i >= 0) && (i < ApInfoFromClient.CertificationRobust.values().length)) {
      this.mClientInfo.setCertificationRobust(ApInfoFromClient.CertificationRobust.values()[i]);
    }
  }
  
  /* Error */
  public boolean updateCheckItems(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokeinterface 338 2 0
    //   15: checkcast 316	com/lantern/wifiseccheck/item/ICheckItem
    //   18: astore_3
    //   19: aload_3
    //   20: invokevirtual 387	com/lantern/wifiseccheck/item/ICheckItem:isFinish	()Z
    //   23: ifeq +66 -> 89
    //   26: aload_3
    //   27: invokevirtual 319	com/lantern/wifiseccheck/item/ICheckItem:isTimeOutType	()Z
    //   30: ifeq +59 -> 89
    //   33: new 76	java/lang/StringBuilder
    //   36: astore 4
    //   38: aload 4
    //   40: ldc_w 389
    //   43: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: ldc 8
    //   48: aload 4
    //   50: iload_1
    //   51: invokevirtual 345	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 94	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 29	com/lantern/wifiseccheck/WifiCheckItemManager:finishCheckItems	Ljava/util/Map;
    //   64: iload_1
    //   65: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: aload_3
    //   69: invokeinterface 328 3 0
    //   74: pop
    //   75: aload_0
    //   76: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   79: iload_1
    //   80: invokestatic 177	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokeinterface 392 2 0
    //   88: pop
    //   89: aload_0
    //   90: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   93: invokeinterface 393 1 0
    //   98: ifne +11 -> 109
    //   101: ldc 8
    //   103: ldc_w 395
    //   106: invokestatic 94	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: getfield 27	com/lantern/wifiseccheck/WifiCheckItemManager:needTimeoutCheckItems	Ljava/util/Map;
    //   113: invokeinterface 393 1 0
    //   118: ifle +9 -> 127
    //   121: iconst_0
    //   122: istore_2
    //   123: aload_0
    //   124: monitorexit
    //   125: iload_2
    //   126: ireturn
    //   127: iconst_1
    //   128: istore_2
    //   129: goto -6 -> 123
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	WifiCheckItemManager
    //   0	137	1	paramInt	int
    //   122	7	2	bool	boolean
    //   18	51	3	localICheckItem	ICheckItem
    //   132	4	3	localObject	Object
    //   36	13	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	89	132	finally
    //   89	109	132	finally
    //   109	121	132	finally
    //   123	125	132	finally
    //   133	135	132	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiCheckItemManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */