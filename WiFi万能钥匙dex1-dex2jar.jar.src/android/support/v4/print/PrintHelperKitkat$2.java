package android.support.v4.print;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentAdapter.LayoutResultCallback;
import android.print.PrintDocumentInfo.Builder;

class PrintHelperKitkat$2
  extends PrintDocumentAdapter
{
  AsyncTask<Uri, Boolean, Bitmap> loadBitmap;
  private PrintAttributes mAttributes;
  Bitmap mBitmap = null;
  
  PrintHelperKitkat$2(PrintHelperKitkat paramPrintHelperKitkat, String paramString, Uri paramUri, int paramInt) {}
  
  private void cancelLoad()
  {
    synchronized (PrintHelperKitkat.access$300(this.this$0))
    {
      if (this.this$0.mDecodeOptions != null)
      {
        this.this$0.mDecodeOptions.requestCancelDecode();
        this.this$0.mDecodeOptions = null;
      }
      return;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    cancelLoad();
    this.loadBitmap.cancel(true);
  }
  
  public void onLayout(PrintAttributes paramPrintAttributes1, PrintAttributes paramPrintAttributes2, CancellationSignal paramCancellationSignal, PrintDocumentAdapter.LayoutResultCallback paramLayoutResultCallback, Bundle paramBundle)
  {
    boolean bool = true;
    if (paramCancellationSignal.isCanceled())
    {
      paramLayoutResultCallback.onLayoutCancelled();
      this.mAttributes = paramPrintAttributes2;
    }
    for (;;)
    {
      return;
      if (this.mBitmap != null)
      {
        paramCancellationSignal = new PrintDocumentInfo.Builder(this.val$jobName).setContentType(1).setPageCount(1).build();
        if (!paramPrintAttributes2.equals(paramPrintAttributes1)) {}
        for (;;)
        {
          paramLayoutResultCallback.onLayoutFinished(paramCancellationSignal, bool);
          break;
          bool = false;
        }
      }
      this.loadBitmap = new PrintHelperKitkat.2.1(this, paramCancellationSignal, paramPrintAttributes2, paramPrintAttributes1, paramLayoutResultCallback);
      this.loadBitmap.execute(new Uri[0]);
      this.mAttributes = paramPrintAttributes2;
    }
  }
  
  /* Error */
  public void onWrite(android.print.PageRange[] paramArrayOfPageRange, android.os.ParcelFileDescriptor paramParcelFileDescriptor, CancellationSignal paramCancellationSignal, android.print.PrintDocumentAdapter.WriteResultCallback paramWriteResultCallback)
  {
    // Byte code:
    //   0: new 124	android/print/pdf/PrintedPdfDocument
    //   3: dup
    //   4: aload_0
    //   5: getfield 23	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
    //   8: getfield 128	android/support/v4/print/PrintHelperKitkat:mContext	Landroid/content/Context;
    //   11: aload_0
    //   12: getfield 81	android/support/v4/print/PrintHelperKitkat$2:mAttributes	Landroid/print/PrintAttributes;
    //   15: invokespecial 131	android/print/pdf/PrintedPdfDocument:<init>	(Landroid/content/Context;Landroid/print/PrintAttributes;)V
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_1
    //   21: invokevirtual 135	android/print/pdf/PrintedPdfDocument:startPage	(I)Landroid/graphics/pdf/PdfDocument$Page;
    //   24: astore_3
    //   25: new 137	android/graphics/RectF
    //   28: astore 5
    //   30: aload 5
    //   32: aload_3
    //   33: invokevirtual 143	android/graphics/pdf/PdfDocument$Page:getInfo	()Landroid/graphics/pdf/PdfDocument$PageInfo;
    //   36: invokevirtual 149	android/graphics/pdf/PdfDocument$PageInfo:getContentRect	()Landroid/graphics/Rect;
    //   39: invokespecial 152	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   42: aload_0
    //   43: getfield 23	android/support/v4/print/PrintHelperKitkat$2:this$0	Landroid/support/v4/print/PrintHelperKitkat;
    //   46: aload_0
    //   47: getfield 34	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
    //   50: invokevirtual 158	android/graphics/Bitmap:getWidth	()I
    //   53: aload_0
    //   54: getfield 34	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
    //   57: invokevirtual 161	android/graphics/Bitmap:getHeight	()I
    //   60: aload 5
    //   62: aload_0
    //   63: getfield 29	android/support/v4/print/PrintHelperKitkat$2:val$fittingMode	I
    //   66: invokestatic 165	android/support/v4/print/PrintHelperKitkat:access$000	(Landroid/support/v4/print/PrintHelperKitkat;IILandroid/graphics/RectF;I)Landroid/graphics/Matrix;
    //   69: astore 5
    //   71: aload_3
    //   72: invokevirtual 169	android/graphics/pdf/PdfDocument$Page:getCanvas	()Landroid/graphics/Canvas;
    //   75: aload_0
    //   76: getfield 34	android/support/v4/print/PrintHelperKitkat$2:mBitmap	Landroid/graphics/Bitmap;
    //   79: aload 5
    //   81: aconst_null
    //   82: invokevirtual 175	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   85: aload_1
    //   86: aload_3
    //   87: invokevirtual 179	android/print/pdf/PrintedPdfDocument:finishPage	(Landroid/graphics/pdf/PdfDocument$Page;)V
    //   90: new 181	java/io/FileOutputStream
    //   93: astore_3
    //   94: aload_3
    //   95: aload_2
    //   96: invokevirtual 187	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   99: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   102: aload_1
    //   103: aload_3
    //   104: invokevirtual 194	android/print/pdf/PrintedPdfDocument:writeTo	(Ljava/io/OutputStream;)V
    //   107: aload 4
    //   109: iconst_1
    //   110: anewarray 196	android/print/PageRange
    //   113: dup
    //   114: iconst_0
    //   115: getstatic 200	android/print/PageRange:ALL_PAGES	Landroid/print/PageRange;
    //   118: aastore
    //   119: invokevirtual 206	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFinished	([Landroid/print/PageRange;)V
    //   122: aload_1
    //   123: invokevirtual 209	android/print/pdf/PrintedPdfDocument:close	()V
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 210	android/os/ParcelFileDescriptor:close	()V
    //   134: return
    //   135: astore_3
    //   136: ldc -44
    //   138: ldc -42
    //   140: aload_3
    //   141: invokestatic 220	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: invokevirtual 224	android/print/PrintDocumentAdapter$WriteResultCallback:onWriteFailed	(Ljava/lang/CharSequence;)V
    //   151: goto -29 -> 122
    //   154: astore_3
    //   155: aload_1
    //   156: invokevirtual 209	android/print/pdf/PrintedPdfDocument:close	()V
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 210	android/os/ParcelFileDescriptor:close	()V
    //   167: aload_3
    //   168: athrow
    //   169: astore_1
    //   170: goto -36 -> 134
    //   173: astore_1
    //   174: goto -7 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	2
    //   0	177	1	paramArrayOfPageRange	android.print.PageRange[]
    //   0	177	2	paramParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   0	177	3	paramCancellationSignal	CancellationSignal
    //   0	177	4	paramWriteResultCallback	android.print.PrintDocumentAdapter.WriteResultCallback
    //   28	52	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   90	122	135	java/io/IOException
    //   19	90	154	finally
    //   90	122	154	finally
    //   136	151	154	finally
    //   130	134	169	java/io/IOException
    //   163	167	173	java/io/IOException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/print/PrintHelperKitkat$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */