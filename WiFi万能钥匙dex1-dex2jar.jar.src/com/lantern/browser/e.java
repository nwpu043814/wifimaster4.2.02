package com.lantern.browser;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.alibaba.fastjson.JSON;
import com.bluefay.b.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private HashMap<String, Method> a;
  private HashMap<String, String> b;
  private String c;
  private String d;
  
  public e(String paramString, Class paramClass)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        paramString = new java/lang/Exception;
        paramString.<init>("injected name can not be null");
        throw paramString;
      }
    }
    catch (Exception paramString)
    {
      Log.e("JsCallJava", "init js error:" + paramString.getMessage());
    }
    for (;;)
    {
      return;
      this.c = paramString;
      paramString = new java/util/HashMap;
      paramString.<init>();
      this.a = paramString;
      paramString = new java/util/HashMap;
      paramString.<init>();
      this.b = paramString;
      paramString = paramClass.getDeclaredMethods();
      paramClass = new java/lang/StringBuilder;
      paramClass.<init>("javascript:(function(b){console.log(\"");
      paramClass.append(this.c);
      paramClass.append(" initialization begin\");var a={queue:[],callback:function(){var d=Array.prototype.slice.call(arguments,0);var c=d.shift();var e=d.shift();this.queue[c].apply(this,d);if(!e){delete this.queue[c]}}};");
      int j = paramString.length;
      while (i < j)
      {
        Method localMethod = paramString[i];
        if (localMethod.getModifiers() == 9)
        {
          String str = a(localMethod);
          if (str != null)
          {
            Object localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            localObject = localMethod.getName() + "_" + localMethod.getParameterTypes().length;
            this.a.put(str, localMethod);
            this.b.put(localObject, str);
            paramClass.append(String.format("a.%s=", new Object[] { localMethod.getName() }));
          }
        }
        i++;
      }
      paramClass.append("function(){var f=Array.prototype.slice.call(arguments,0);if(f.length<1){throw\"");
      paramClass.append(this.c);
      paramClass.append(" call error, message:miss method name\"}var e=[];for(var h=1;h<f.length;h++){var c=f[h];var j=typeof c;e[e.length]=j;if(j==\"function\"){var d=a.queue.length;a.queue[d]=c;f[h]=d}}var g=JSON.parse(prompt(JSON.stringify({method:f.shift(),types:e,args:f})));if(g.code!=200){throw\"");
      paramClass.append(this.c);
      paramClass.append(" call error, code:\"+g.code+\", message:\"+g.result}return g.result};Object.getOwnPropertyNames(a).forEach(function(d){var c=a[d];if(typeof c===\"function\"&&d!==\"callback\"){a[d]=function(){return c.apply(a,[d].concat(Array.prototype.slice.call(arguments,0)))}}});b.");
      paramClass.append(this.c);
      paramClass.append("=a;console.log(\"");
      paramClass.append(this.c);
      paramClass.append(" initialization end\")})(window);");
      this.d = paramClass.toString();
    }
  }
  
  private String a(String paramString, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "null";
    }
    for (;;)
    {
      paramObject = String.format("{\"code\": %d, \"result\": %s}", new Object[] { Integer.valueOf(paramInt), paramObject });
      Log.d("JsCallJava", this.c + " call json: " + paramString + " result:" + (String)paramObject);
      return (String)paramObject;
      if ((paramObject instanceof String))
      {
        paramObject = ((String)paramObject).replace("\"", "\\\"");
        paramObject = "\"" + paramObject + "\"";
      }
      else if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof Long)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Double)) && (!(paramObject instanceof JSONObject)))
      {
        paramObject = JSON.toJSONString(paramObject);
      }
      else
      {
        paramObject = String.valueOf(paramObject);
      }
    }
  }
  
  private static String a(Method paramMethod)
  {
    Object localObject = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    int j = arrayOfClass.length;
    if ((j <= 0) || (arrayOfClass[0] != WebView.class))
    {
      Log.w("JsCallJava", "method(" + (String)localObject + ") must use webview to be first parameter, will be pass");
      localObject = null;
    }
    int i;
    do
    {
      return (String)localObject;
      paramMethod = (Method)localObject;
      i = 1;
      localObject = paramMethod;
    } while (i >= j);
    localObject = arrayOfClass[i];
    if (localObject == String.class) {
      paramMethod = paramMethod + "_S";
    }
    for (;;)
    {
      i++;
      break;
      if ((localObject == Integer.TYPE) || (localObject == Long.TYPE) || (localObject == Float.TYPE) || (localObject == Double.TYPE)) {
        paramMethod = paramMethod + "_N";
      } else if (localObject == Boolean.TYPE) {
        paramMethod = paramMethod + "_B";
      } else if (localObject == JSONObject.class) {
        paramMethod = paramMethod + "_O";
      } else if (localObject == f.class) {
        paramMethod = paramMethod + "_F";
      } else {
        paramMethod = paramMethod + "_P";
      }
    }
  }
  
  public final String a()
  {
    return this.d;
  }
  
  public final String a(WebView paramWebView, String paramString)
  {
    Object localObject2;
    Object localObject1;
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    int m;
    Object[] arrayOfObject;
    int i;
    Object localObject3;
    int k;
    int j;
    Object localObject4;
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(paramString);
        localObject1 = ((JSONObject)localObject2).getString("method");
        localJSONArray1 = ((JSONObject)localObject2).getJSONArray("types");
        localJSONArray2 = ((JSONObject)localObject2).getJSONArray("args");
        m = localJSONArray1.length();
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject2 = (String)localObject1 + "_" + (m + 1);
        arrayOfObject = new Object[m + 1];
        i = 0;
        arrayOfObject[0] = paramWebView;
        localObject3 = (String)this.b.get(localObject2);
        localObject2 = null;
        if (localObject3 != null) {
          localObject2 = (Method)this.a.get(localObject3);
        }
        if (localObject2 != null)
        {
          Class[] arrayOfClass = ((Method)localObject2).getParameterTypes();
          k = 0;
          i = 0;
          j = i;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (k >= m) {
            break label1003;
          }
          localObject3 = localJSONArray1.optString(k);
          if (("string".equals(localObject3)) || ("number".equals(localObject3))) {
            if (arrayOfClass[(k + 1)] == String.class)
            {
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              localObject3 = (String)localObject1 + "_S";
              if (localJSONArray2.isNull(k))
              {
                localObject1 = null;
                label254:
                arrayOfObject[(k + 1)] = localObject1;
                localObject1 = localObject3;
              }
            }
          }
          for (;;)
          {
            k++;
            break;
            localObject1 = localJSONArray2.getString(k);
            break label254;
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject1 = (String)localObject1 + "_N";
            i = i * 10 + k + 1;
            continue;
            if (!"boolean".equals(localObject3)) {
              break label423;
            }
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            localObject1 = (String)localObject1 + "_B";
            arrayOfObject[(k + 1)] = Boolean.valueOf(localJSONArray2.getBoolean(k));
          }
          paramWebView = a(paramString, 500, "method execute error:" + paramWebView.getCause().getMessage());
        }
      }
      catch (Exception paramWebView)
      {
        if (paramWebView.getCause() == null) {}
      }
    }
    for (;;)
    {
      return paramWebView;
      label423:
      if ("object".equals(localObject3))
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject3 = (String)localObject1 + "_O";
        if (localJSONArray2.isNull(k)) {}
        for (localObject1 = null;; localObject1 = localJSONArray2.getJSONObject(k))
        {
          arrayOfObject[(k + 1)] = localObject1;
          localObject1 = localObject3;
          break;
        }
      }
      if ("function".equals(localObject3))
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        localObject1 = (String)localObject1 + "_F";
        arrayOfObject[(k + 1)] = new f(paramWebView, this.c, localJSONArray2.getInt(k));
        break;
      }
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      localObject1 = (String)localObject1 + "_P";
      break;
      j = 0;
      if (j < m)
      {
        localObject2 = localJSONArray1.optString(j);
        if ("string".equals(localObject2))
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject2 = (String)localObject1 + "_S";
          if (localJSONArray2.isNull(j))
          {
            localObject1 = null;
            label668:
            arrayOfObject[(j + 1)] = localObject1;
            localObject1 = localObject2;
          }
        }
        for (;;)
        {
          j++;
          break;
          localObject1 = localJSONArray2.getString(j);
          break label668;
          if ("number".equals(localObject2))
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject1 = (String)localObject1 + "_N";
            i = i * 10 + j + 1;
          }
          else if ("boolean".equals(localObject2))
          {
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>();
            localObject1 = (String)localObject1 + "_B";
            arrayOfObject[(j + 1)] = Boolean.valueOf(localJSONArray2.getBoolean(j));
          }
          else
          {
            if ("object".equals(localObject2))
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              localObject2 = (String)localObject1 + "_O";
              if (localJSONArray2.isNull(j)) {}
              for (localObject1 = null;; localObject1 = localJSONArray2.getJSONObject(j))
              {
                arrayOfObject[(j + 1)] = localObject1;
                localObject1 = localObject2;
                break;
              }
            }
            if ("function".equals(localObject2))
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              localObject1 = (String)localObject1 + "_F";
              arrayOfObject[(j + 1)] = new f(paramWebView, this.c, localJSONArray2.getInt(j));
            }
            else
            {
              localObject2 = new java/lang/StringBuilder;
              ((StringBuilder)localObject2).<init>();
              localObject1 = (String)localObject1 + "_P";
            }
          }
        }
      }
      localObject3 = (Method)this.a.get(localObject1);
      localObject4 = localObject1;
      j = i;
      label1003:
      if (localObject3 == null)
      {
        paramWebView = new java/lang/StringBuilder;
        paramWebView.<init>("not found method(");
        paramWebView = a(paramString, 500, (String)localObject4 + ") with valid parameters");
      }
      else
      {
        if (j > 0)
        {
          paramWebView = ((Method)localObject3).getParameterTypes();
          i = j;
          if (i > 0)
          {
            j = i - i / 10 * 10;
            localObject4 = paramWebView[j];
            localObject1 = localJSONArray1.optString(j - 1);
            arrayOfObject[j] = Integer.valueOf(0);
            boolean bool;
            if (localObject4 == Integer.TYPE)
            {
              bool = "string".equals(localObject1);
              if (!bool) {}
            }
            for (;;)
            {
              try
              {
                arrayOfObject[j] = Integer.valueOf(localJSONArray2.getString(j - 1));
                i /= 10;
              }
              catch (Exception localException1)
              {
                h.a(localException1);
                continue;
              }
              arrayOfObject[j] = Integer.valueOf(localJSONArray2.getInt(j - 1));
              continue;
              localObject2 = Long.TYPE;
              if (localObject4 == localObject2)
              {
                try
                {
                  arrayOfObject[j] = Long.valueOf(Long.parseLong(localJSONArray2.getString(j - 1)));
                }
                catch (Exception localException2)
                {
                  h.a(localException2);
                }
              }
              else
              {
                bool = "string".equals(localException2);
                if (bool) {
                  try
                  {
                    arrayOfObject[j] = Double.valueOf(localJSONArray2.getString(j - 1));
                  }
                  catch (Exception localException3)
                  {
                    h.a(localException3);
                  }
                } else {
                  arrayOfObject[j] = Double.valueOf(localJSONArray2.getDouble(j - 1));
                }
              }
            }
          }
        }
        paramWebView = a(paramString, 200, ((Method)localObject3).invoke(null, arrayOfObject));
        continue;
        paramWebView = a(paramString, 500, "method execute error:" + paramWebView.getMessage());
        continue;
        paramWebView = a(paramString, 500, "call data empty");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */