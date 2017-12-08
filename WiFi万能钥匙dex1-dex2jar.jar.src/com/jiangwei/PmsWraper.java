package com.jiangwei;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PmsWraper
  implements InvocationHandler
{
  private static final String SIGN = "308201b53082011ea00302010202044e830b2d300d06092a864886f70d0101050500301e310d300b060355040a1304736e6461310d300b06035504031304736e64613020170d3131303932383131353532355a180f33303130303132393131353532355a301e310d300b060355040a1304736e6461310d300b06035504031304736e646130819f300d06092a864886f70d010101050003818d00308189028181009a987a7f22be5c26bd8a670c10ac101ee06204ad46f9e835e39688238ac6d2cdece475582079821f3e40b8c9ee3efe5f45de776ca089b4d75b260f8016fd4b632dfcb3ac6d5484d157c8a1b6395f4e635c0240d11b9a014a2814ae0198246015deb292601ab634d2360cf14e15944c263f1b8c8d05e89746343a0072bbd227950203010001300d06092a864886f70d0101050500038181004cccd50da9724f03b45fbcc2c9f6da75bd8ca7579994edbfac2c289ef1b3dfd88f40410dca4c3a381697790e33f4167f88e01a78a567926737e8a43199ffa8eed706b8abfac49675d8cf46a4f99933980956f7ebd3e67b17dd0c8d4fe76b38b8b6e292a2178598d303214e5cf067662ae7ad6da962ccddb735e4369f847c976b";
  private Object base;
  
  public PmsWraper(Object paramObject)
  {
    try
    {
      this.base = paramObject;
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        Log.d("jw", "error:" + Log.getStackTraceString((Throwable)paramObject));
      }
    }
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    Log.i("jw", "pms method:" + paramMethod.getName());
    if (("getPackageInfo".equals(paramMethod.getName())) && (((Integer)paramArrayOfObject[1]).intValue() == 64))
    {
      Signature localSignature = new Signature("308201b53082011ea00302010202044e830b2d300d06092a864886f70d0101050500301e310d300b060355040a1304736e6461310d300b06035504031304736e64613020170d3131303932383131353532355a180f33303130303132393131353532355a301e310d300b060355040a1304736e6461310d300b06035504031304736e646130819f300d06092a864886f70d010101050003818d00308189028181009a987a7f22be5c26bd8a670c10ac101ee06204ad46f9e835e39688238ac6d2cdece475582079821f3e40b8c9ee3efe5f45de776ca089b4d75b260f8016fd4b632dfcb3ac6d5484d157c8a1b6395f4e635c0240d11b9a014a2814ae0198246015deb292601ab634d2360cf14e15944c263f1b8c8d05e89746343a0072bbd227950203010001300d06092a864886f70d0101050500038181004cccd50da9724f03b45fbcc2c9f6da75bd8ca7579994edbfac2c289ef1b3dfd88f40410dca4c3a381697790e33f4167f88e01a78a567926737e8a43199ffa8eed706b8abfac49675d8cf46a4f99933980956f7ebd3e67b17dd0c8d4fe76b38b8b6e292a2178598d303214e5cf067662ae7ad6da962ccddb735e4369f847c976b");
      paramObject = (PackageInfo)paramMethod.invoke(this.base, paramArrayOfObject);
      Log.i("jw", "old sign:" + paramObject.signatures[0].hashCode());
      ((PackageInfo)paramObject).signatures[0] = localSignature;
    }
    for (;;)
    {
      return paramObject;
      paramObject = paramMethod.invoke(this.base, paramArrayOfObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/jiangwei/PmsWraper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */