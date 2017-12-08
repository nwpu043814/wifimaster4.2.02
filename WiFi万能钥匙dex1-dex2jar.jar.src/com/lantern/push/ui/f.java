package com.lantern.push.ui;

import android.widget.AdapterView.OnItemClickListener;

final class f
  implements AdapterView.OnItemClickListener
{
  f(MessageFragment paramMessageFragment) {}
  
  /* Error */
  public final void onItemClick(android.widget.AdapterView<?> paramAdapterView, android.view.View paramView, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   4: invokestatic 28	com/lantern/push/ui/MessageFragment:b	(Lcom/lantern/push/ui/MessageFragment;)Lcom/lantern/push/ui/h;
    //   7: iload_3
    //   8: invokevirtual 34	com/lantern/push/ui/h:getItem	(I)Ljava/lang/Object;
    //   11: checkcast 36	com/lantern/push/b/a
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +39 -> 55
    //   19: aload_1
    //   20: invokevirtual 39	com/lantern/push/b/a:b	()I
    //   23: ifne +32 -> 55
    //   26: aload_1
    //   27: iconst_1
    //   28: invokevirtual 42	com/lantern/push/b/a:b	(I)V
    //   31: new 44	com/lantern/push/utils/e
    //   34: aload_0
    //   35: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   38: invokestatic 48	com/lantern/push/ui/MessageFragment:d	(Lcom/lantern/push/ui/MessageFragment;)Landroid/content/Context;
    //   41: aload_0
    //   42: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   45: invokestatic 28	com/lantern/push/ui/MessageFragment:b	(Lcom/lantern/push/ui/MessageFragment;)Lcom/lantern/push/ui/h;
    //   48: aload_1
    //   49: invokevirtual 50	com/lantern/push/b/a:a	()I
    //   52: invokespecial 53	com/lantern/push/utils/e:<init>	(Landroid/content/Context;Lcom/lantern/push/ui/h;I)V
    //   55: aload_1
    //   56: ifnull +87 -> 143
    //   59: aload_1
    //   60: invokevirtual 57	com/lantern/push/b/a:c	()Ljava/lang/String;
    //   63: astore_2
    //   64: aload_0
    //   65: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   68: invokestatic 61	com/lantern/push/ui/MessageFragment:e	(Lcom/lantern/push/ui/MessageFragment;)Landroid/app/NotificationManager;
    //   71: aload_2
    //   72: invokestatic 67	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   75: invokevirtual 72	android/app/NotificationManager:cancel	(I)V
    //   78: new 74	android/content/Intent
    //   81: astore_2
    //   82: aload_2
    //   83: ldc 76
    //   85: aload_1
    //   86: invokevirtual 78	com/lantern/push/b/a:d	()Ljava/lang/String;
    //   89: invokestatic 84	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   92: invokespecial 87	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   95: aload_2
    //   96: aload_0
    //   97: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   100: invokestatic 90	com/lantern/push/ui/MessageFragment:f	(Lcom/lantern/push/ui/MessageFragment;)Landroid/content/Context;
    //   103: invokevirtual 95	android/content/Context:getPackageName	()Ljava/lang/String;
    //   106: invokevirtual 99	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   109: pop
    //   110: new 101	android/os/Bundle
    //   113: astore_1
    //   114: aload_1
    //   115: invokespecial 102	android/os/Bundle:<init>	()V
    //   118: aload_1
    //   119: ldc 104
    //   121: iconst_0
    //   122: invokevirtual 108	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   125: aload_2
    //   126: aload_1
    //   127: invokevirtual 112	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   130: pop
    //   131: aload_0
    //   132: getfield 12	com/lantern/push/ui/f:a	Lcom/lantern/push/ui/MessageFragment;
    //   135: invokevirtual 116	com/lantern/push/ui/MessageFragment:getActivity	()Landroid/app/Activity;
    //   138: aload_2
    //   139: iconst_1
    //   140: invokevirtual 122	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   143: return
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 125	android/content/ActivityNotFoundException:printStackTrace	()V
    //   149: goto -6 -> 143
    //   152: astore_2
    //   153: goto -75 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	f
    //   0	156	1	paramAdapterView	android.widget.AdapterView<?>
    //   0	156	2	paramView	android.view.View
    //   0	156	3	paramInt	int
    //   0	156	4	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   0	15	144	android/content/ActivityNotFoundException
    //   19	55	144	android/content/ActivityNotFoundException
    //   59	78	144	android/content/ActivityNotFoundException
    //   78	143	144	android/content/ActivityNotFoundException
    //   59	78	152	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */