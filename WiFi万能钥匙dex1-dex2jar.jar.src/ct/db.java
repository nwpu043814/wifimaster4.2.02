package ct;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class db
{
  public static boolean a = false;
  
  public static int a(CellLocation paramCellLocation)
  {
    int i;
    if ((paramCellLocation instanceof CdmaCellLocation)) {
      i = ((CdmaCellLocation)paramCellLocation).getBaseStationId();
    }
    for (;;)
    {
      return i;
      try
      {
        i = ((GsmCellLocation)paramCellLocation).getCid();
      }
      catch (Exception paramCellLocation)
      {
        i = -1;
      }
    }
  }
  
  public static CellInfo a(bi parambi)
  {
    try
    {
      parambi = parambi.a();
      if (parambi == null) {
        break label138;
      }
      localList = parambi.getAllCellInfo();
      if (localList == null) {
        break label158;
      }
      Iterator localIterator = localList.iterator();
      CellInfo localCellInfo;
      for (parambi = null; localIterator.hasNext(); parambi = localCellInfo)
      {
        localCellInfo = (CellInfo)localIterator.next();
        if (!localCellInfo.isRegistered()) {
          break label155;
        }
      }
    }
    catch (Exception parambi)
    {
      for (;;)
      {
        List localList;
        int i;
        int j;
        int k;
        b.a.a("Cells", "cannot get cell location", parambi);
        parambi = null;
      }
    }
    catch (Error parambi)
    {
      for (;;)
      {
        label80:
        label119:
        label124:
        label138:
        b.a.a("Cells", "cannot get cell location", parambi);
        continue;
        label155:
        continue;
        label158:
        parambi = null;
      }
    }
    if (parambi == null)
    {
      i = 1;
      if (localList == null) {
        break label119;
      }
      j = 1;
      if (localList.size() <= 0) {
        break label124;
      }
    }
    for (k = 1;; k = 0)
    {
      if ((k & i & j) != 0) {
        parambi = (CellInfo)localList.get(0);
      }
      return parambi;
      i = 0;
      break;
      j = 0;
      break label80;
    }
  }
  
  public static void a(@NonNull TelephonyManager paramTelephonyManager, @NonNull int[] paramArrayOfInt)
  {
    paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    if ((paramTelephonyManager != null) && (paramTelephonyManager.length() >= 5)) {}
    try
    {
      paramArrayOfInt[0] = Integer.parseInt(paramTelephonyManager.substring(0, 3));
      paramArrayOfInt[1] = Integer.parseInt(paramTelephonyManager.substring(3, 5));
      return;
    }
    catch (IndexOutOfBoundsException paramTelephonyManager)
    {
      for (;;)
      {
        b.a.a("Cells", "getMccMnc: ", paramTelephonyManager);
        Arrays.fill(paramArrayOfInt, 0);
      }
    }
    catch (NumberFormatException paramTelephonyManager)
    {
      for (;;)
      {
        b.a.a("Cells", "getMccMnc: ", paramTelephonyManager);
      }
    }
  }
  
  private static boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool2 = true;
    boolean bool1;
    if (b(paramInt1)) {
      if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 >= 0) && (paramInt4 <= 65535) && (paramInt5 >= 0) && (paramInt5 <= 65535))
      {
        bool1 = bool2;
        if (paramInt3 == 0)
        {
          bool1 = bool2;
          if (paramInt4 == 0)
          {
            bool1 = bool2;
            if (paramInt5 != 0) {}
          }
        }
      }
      else
      {
        bool1 = false;
      }
    }
    for (;;)
    {
      return bool1;
      if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 <= 0) || (paramInt4 >= 65535))
      {
        bool1 = false;
      }
      else if ((paramInt5 == 268435455) || (paramInt5 == Integer.MAX_VALUE) || (paramInt5 == 50594049) || (paramInt5 == 65535) || (paramInt5 <= 0))
      {
        bool1 = false;
      }
      else if (paramInt5 != 65535)
      {
        bool1 = bool2;
        if (paramInt5 > 0) {}
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramSignalStrength1 != null)
    {
      if (paramSignalStrength2 != null) {
        break label22;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label22:
      int i = b(paramInt, paramSignalStrength1, paramSignalStrength2);
      if (a(paramInt))
      {
        bool1 = bool2;
        if (i <= 3) {
          bool1 = false;
        }
      }
      else if (b(paramInt))
      {
        bool1 = bool2;
        if (i <= 6) {
          bool1 = false;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 17) {}
    for (;;)
    {
      try
      {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on");
        if (i != 1) {
          continue;
        }
        bool1 = bool2;
      }
      catch (Error paramContext)
      {
        int i;
        continue;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return bool1;
      bool1 = false;
      continue;
      try
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
        if (i == 1)
        {
          bool1 = bool3;
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean a(CellInfo paramCellInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramCellInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        int m;
        int i;
        int j;
        int k;
        if ((paramCellInfo instanceof CellInfoGsm))
        {
          paramCellInfo = ((CellInfoGsm)paramCellInfo).getCellIdentity();
          m = paramCellInfo.getMcc();
          i = paramCellInfo.getMnc();
          j = paramCellInfo.getLac();
          k = paramCellInfo.getCid();
          bool1 = bool2;
          if (m >= 0)
          {
            bool1 = bool2;
            if (i >= 0)
            {
              bool1 = bool2;
              if (j > 0)
              {
                bool1 = bool2;
                if (j < 65535)
                {
                  bool1 = bool2;
                  if (k != 268435455)
                  {
                    bool1 = bool2;
                    if (k != Integer.MAX_VALUE)
                    {
                      bool1 = bool2;
                      if (k != 50594049)
                      {
                        bool1 = bool2;
                        if (k != 65535)
                        {
                          bool1 = bool2;
                          if (k != 8)
                          {
                            bool1 = bool2;
                            if (k != 10)
                            {
                              bool1 = bool2;
                              if (k != 33)
                              {
                                bool1 = bool2;
                                if (k <= 0) {}
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        else
        {
          label262:
          label414:
          do
          {
            do
            {
              do
              {
                do
                {
                  bool1 = true;
                  break;
                  if (!(paramCellInfo instanceof CellInfoCdma)) {
                    break label262;
                  }
                  paramCellInfo = ((CellInfoCdma)paramCellInfo).getCellIdentity();
                  j = paramCellInfo.getSystemId();
                  i = paramCellInfo.getNetworkId();
                  k = paramCellInfo.getBasestationId();
                  bool1 = bool2;
                  if (j < 0) {
                    break;
                  }
                  bool1 = bool2;
                  if (i < 0) {
                    break;
                  }
                  bool1 = bool2;
                  if (i > 65535) {
                    break;
                  }
                  bool1 = bool2;
                  if (k < 0) {
                    break;
                  }
                  bool1 = bool2;
                  if (k > 65535) {
                    break;
                  }
                } while ((j != 0) || (i != 0) || (k != 0));
                bool1 = bool2;
                break;
                if (!(paramCellInfo instanceof CellInfoWcdma)) {
                  break label414;
                }
                paramCellInfo = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
                j = paramCellInfo.getMcc();
                m = paramCellInfo.getMnc();
                k = paramCellInfo.getLac();
                i = paramCellInfo.getCid();
                bool1 = bool2;
                if (j < 0) {
                  break;
                }
                bool1 = bool2;
                if (m < 0) {
                  break;
                }
                bool1 = bool2;
                if (k <= 0) {
                  break;
                }
                bool1 = bool2;
                if (k >= 65535) {
                  break;
                }
                bool1 = bool2;
                if (i == 268435455) {
                  break;
                }
                bool1 = bool2;
                if (i == Integer.MAX_VALUE) {
                  break;
                }
                bool1 = bool2;
                if (i == 50594049) {
                  break;
                }
                bool1 = bool2;
                if (i == 65535) {
                  break;
                }
                bool1 = bool2;
                if (i == 8) {
                  break;
                }
                bool1 = bool2;
                if (i == 10) {
                  break;
                }
                bool1 = bool2;
                if (i == 33) {
                  break;
                }
              } while (i > 0);
              bool1 = bool2;
              break;
            } while (!(paramCellInfo instanceof CellInfoLte));
            paramCellInfo = ((CellInfoLte)paramCellInfo).getCellIdentity();
            m = paramCellInfo.getMcc();
            j = paramCellInfo.getMnc();
            k = paramCellInfo.getTac();
            i = paramCellInfo.getCi();
            bool1 = bool2;
            if (m < 0) {
              break;
            }
            bool1 = bool2;
            if (j < 0) {
              break;
            }
            bool1 = bool2;
            if (k <= 0) {
              break;
            }
            bool1 = bool2;
            if (k >= 65535) {
              break;
            }
            bool1 = bool2;
            if (i == 268435455) {
              break;
            }
            bool1 = bool2;
            if (i == Integer.MAX_VALUE) {
              break;
            }
            bool1 = bool2;
            if (i == 50594049) {
              break;
            }
            bool1 = bool2;
            if (i == 65535) {
              break;
            }
            bool1 = bool2;
            if (i == 8) {
              break;
            }
            bool1 = bool2;
            if (i == 10) {
              break;
            }
            bool1 = bool2;
            if (i == 33) {
              break;
            }
          } while (i > 0);
          bool1 = bool2;
        }
      }
      catch (Error paramCellInfo)
      {
        bool1 = bool2;
      }
      catch (Exception paramCellInfo)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static boolean a(CellInfo paramCellInfo1, CellInfo paramCellInfo2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (b.a.a(paramCellInfo1, paramCellInfo2)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramCellInfo1.getClass() == paramCellInfo2.getClass()) {
        try
        {
          Object localObject;
          if ((paramCellInfo1 instanceof CellInfoGsm))
          {
            localObject = (CellInfoGsm)paramCellInfo1;
            paramCellInfo1 = (CellInfoGsm)paramCellInfo2;
            paramCellInfo2 = ((CellInfoGsm)localObject).getCellIdentity();
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            bool1 = bool2;
            if (paramCellInfo2.getCid() == paramCellInfo1.getCid()) {
              bool1 = true;
            }
          }
          else if ((paramCellInfo1 instanceof CellInfoCdma))
          {
            paramCellInfo1 = (CellInfoCdma)paramCellInfo1;
            paramCellInfo2 = (CellInfoCdma)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            bool1 = bool2;
            if (paramCellInfo1.getBasestationId() == paramCellInfo2.getBasestationId()) {
              bool1 = true;
            }
          }
          else if ((paramCellInfo1 instanceof CellInfoWcdma))
          {
            paramCellInfo1 = (CellInfoWcdma)paramCellInfo1;
            paramCellInfo2 = (CellInfoWcdma)paramCellInfo2;
            paramCellInfo1 = paramCellInfo1.getCellIdentity();
            paramCellInfo2 = paramCellInfo2.getCellIdentity();
            bool1 = bool2;
            if (paramCellInfo1.getCid() == paramCellInfo2.getCid()) {
              bool1 = true;
            }
          }
          else
          {
            bool1 = bool2;
            if ((paramCellInfo1 instanceof CellInfoLte))
            {
              localObject = (CellInfoLte)paramCellInfo1;
              paramCellInfo1 = (CellInfoLte)paramCellInfo2;
              paramCellInfo2 = ((CellInfoLte)localObject).getCellIdentity();
              paramCellInfo1 = paramCellInfo1.getCellIdentity();
              int j = paramCellInfo2.getCi();
              int i = paramCellInfo1.getCi();
              bool1 = bool2;
              if (j == i) {
                bool1 = true;
              }
            }
          }
        }
        catch (Error paramCellInfo1)
        {
          bool1 = bool2;
        }
        catch (Exception paramCellInfo1)
        {
          bool1 = bool2;
        }
      }
    }
  }
  
  public static boolean a(CellLocation paramCellLocation1, CellLocation paramCellLocation2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (b.a.a(paramCellLocation1, paramCellLocation2)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramCellLocation1.getClass() == paramCellLocation2.getClass()) {
        if ((paramCellLocation1 instanceof GsmCellLocation))
        {
          paramCellLocation1 = (GsmCellLocation)paramCellLocation1;
          paramCellLocation2 = (GsmCellLocation)paramCellLocation2;
          bool1 = bool2;
          if (paramCellLocation1.getCid() == paramCellLocation2.getCid()) {
            bool1 = true;
          }
        }
        else
        {
          bool1 = bool2;
          if ((paramCellLocation1 instanceof CdmaCellLocation))
          {
            paramCellLocation1 = (CdmaCellLocation)paramCellLocation1;
            paramCellLocation2 = (CdmaCellLocation)paramCellLocation2;
            bool1 = bool2;
            if (paramCellLocation1.getBaseStationId() == paramCellLocation2.getBaseStationId()) {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(ck paramck)
  {
    if (b.a.a(paramck)) {}
    for (boolean bool = false;; bool = a(paramck.a, paramck.b, paramck.c, paramck.d, paramck.e)) {
      return bool;
    }
  }
  
  private static int b(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    try
    {
      if (a(paramInt)) {
        paramInt = paramSignalStrength1.getGsmSignalStrength() - paramSignalStrength2.getGsmSignalStrength();
      }
      for (;;)
      {
        return paramInt;
        if (!b(paramInt)) {
          break;
        }
        paramInt = paramSignalStrength1.getCdmaDbm();
        int i = paramSignalStrength2.getCdmaDbm();
        paramInt -= i;
      }
    }
    catch (NoSuchMethodError paramSignalStrength1)
    {
      for (;;)
      {
        paramInt = 0;
      }
    }
  }
  
  public static CellLocation b(bi parambi)
  {
    boolean bool2 = false;
    TelephonyManager localTelephonyManager = parambi.a();
    if (localTelephonyManager != null) {}
    for (;;)
    {
      try
      {
        CellLocation localCellLocation = localTelephonyManager.getCellLocation();
        int i = localTelephonyManager.getSimState();
        if (i == 5) {
          j = 1;
        }
        try
        {
          bool1 = TextUtils.isEmpty(localTelephonyManager.getSubscriberId());
          if (bool1) {
            continue;
          }
          i = 1;
        }
        catch (Exception localException)
        {
          boolean bool1;
          i = 1;
          continue;
        }
        if ((j != 0) && (i != 0))
        {
          if ((localCellLocation != null) && (!b(localCellLocation)))
          {
            bool1 = bool2;
            if (a(localCellLocation) >= 0) {}
          }
          else
          {
            bool1 = bool2;
            if (!a(parambi.a)) {
              bool1 = true;
            }
          }
          a = bool1;
        }
        if (a) {
          b.a.b("Cells", "location permission denied!");
        }
        parambi = localCellLocation;
        return parambi;
        int j = 0;
        continue;
        i = 0;
        continue;
        parambi = CellLocation.getEmpty();
      }
      catch (Exception parambi)
      {
        b.a.a("Cells", "cannot get cell location", parambi);
        a = true;
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    if (paramInt == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean b(CellLocation paramCellLocation)
  {
    try
    {
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      if (paramCellLocation.getCid() != 0) {
        break label26;
      }
      int i = paramCellLocation.getLac();
      if (i != 0) {
        break label26;
      }
      bool = true;
    }
    catch (ClassCastException paramCellLocation)
    {
      for (;;)
      {
        label26:
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static List<NeighboringCellInfo> c(bi parambi)
  {
    parambi = parambi.a();
    if (parambi != null) {}
    for (;;)
    {
      try
      {
        parambi = parambi.getNeighboringCellInfo();
        return parambi;
      }
      catch (Exception parambi)
      {
        b.a.a("Cells", "cannot get NeighboringCellInfo", parambi);
      }
      parambi = Collections.emptyList();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */