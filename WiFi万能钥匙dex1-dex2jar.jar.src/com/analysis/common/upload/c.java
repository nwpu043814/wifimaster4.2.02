package com.analysis.common.upload;

import java.io.File;
import java.io.FilenameFilter;

final class c
  implements FilenameFilter
{
  c(a parama) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("log_");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */