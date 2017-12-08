package com.lantern.core.favorite;

import org.json.JSONObject;

public class WkSceneFavorite
{
  public String authorIcon;
  public String authorId;
  public String authorName;
  public String authorType;
  public String category;
  public String content;
  public String contentSrc;
  public String contentType;
  public String description;
  public String favId;
  public long favTime;
  public String originalSrc;
  public String srcIcon;
  public String srcId;
  public String srcName;
  public String srcType;
  public String srcUrl;
  public int state;
  public int syncState;
  public String tags;
  public String thumbnailLink;
  public String title;
  
  public boolean equals(Object paramObject)
  {
    paramObject = (WkSceneFavorite)paramObject;
    if (this.favId == ((WkSceneFavorite)paramObject).favId) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("favId", this.favId);
      localJSONObject.put("title", this.title);
      localJSONObject.put("category", this.category);
      localJSONObject.put("contentType", this.contentType);
      localJSONObject.put("content", this.content);
      localJSONObject.put("contentSrc", this.contentSrc);
      localJSONObject.put("favTime", this.favTime);
      localJSONObject.put("thumbnailLink", this.thumbnailLink);
      localJSONObject.put("description", this.description);
      localJSONObject.put("tags", this.tags);
      localJSONObject.put("srcType", this.srcType);
      localJSONObject.put("srcName", this.srcName);
      localJSONObject.put("srcIcon", this.srcIcon);
      localJSONObject.put("srcUrl", this.srcUrl);
      localJSONObject.put("srcId", this.srcId);
      localJSONObject.put("authorName", this.authorName);
      localJSONObject.put("authorIcon", this.authorIcon);
      localJSONObject.put("authorId", this.authorId);
      localJSONObject.put("authorType", this.authorType);
      localJSONObject.put("state", this.state);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public String toString()
  {
    return "WkSceneFavorite [favId=" + this.favId + ", category=" + this.category + ", tags=" + this.tags + ", state=" + this.state + ", syncState=" + this.syncState + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/favorite/WkSceneFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */