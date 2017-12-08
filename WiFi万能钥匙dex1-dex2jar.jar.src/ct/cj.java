package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cj
{
  private static List<String> a;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add("mobile");
    a.add("16wifi");
    a.add("cmcc");
    a.add("360wifi");
    a.add("androidap");
    a.add("htcphone");
    a.add("xiaomi");
    a.add("lenovo");
    a.add("macbook");
  }
  
  public static List<ScanResult> a(List<ScanResult> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    localArrayList.size();
    paramList = localArrayList.iterator();
    while (paramList.hasNext())
    {
      String str = ((ScanResult)paramList.next()).BSSID;
      if ((str == null) || (str.equals("000000000000")) || (str.equals("00-00-00-00-00-00")) || (str.equals("00:00:00:00:00:00"))) {
        paramList.remove();
      }
    }
    return localArrayList;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */