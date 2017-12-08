package com.lantern.auth.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.config.d;
import com.lantern.core.k;

public final class a
{
  private static final String[][] a;
  
  static
  {
    String[] arrayOfString1 = { "阿尔巴尼亚", "355", "Albania", "al", "0" };
    String[] arrayOfString2 = { "亚美尼亚", "374", "Armenia", "am", "0" };
    String[] arrayOfString3 = { "阿森松", "247", "Ascension", "ac", "0" };
    String[] arrayOfString4 = { "孟加拉", "880", "Bangladesh", "bd", "0" };
    String[] arrayOfString5 = { "百慕大", "1441", "Bermuda", "bm", "0" };
    String[] arrayOfString6 = { "玻利维亚", "591", "Bolivia ", "bo", "0" };
    String[] arrayOfString7 = { "波黑", "387", "Bosnia and Herzegovina", "", "0" };
    String[] arrayOfString8 = { "保加利亚", "359", "Bulgaria", "bg", "0" };
    String[] arrayOfString9 = { "柬埔寨", "855", "Cambodia", "kh", "0" };
    String[] arrayOfString10 = { "中非", "236", "Central African Republic", "cf", "0" };
    String[] arrayOfString11 = { "捷克", "420", "Chech", "cz", "0" };
    String[] arrayOfString12 = { "刚果", "242", "Congo", "cg", "0" };
    String[] arrayOfString13 = { "哥斯达黎加", "506", "Costa Rica", "cr", "0" };
    String[] arrayOfString14 = { "丹麦", "45", "Denmark", "dk", "0" };
    String[] arrayOfString15 = { "赤道几内亚", "240", "Equatorial Guinea ", "st", "0" };
    String[] arrayOfString16 = { "埃塞俄比亚", "251", "Ethiopia", "et", "0" };
    String[] arrayOfString17 = { "斐济群岛", "679", "Fiji", "fj", "0" };
    String[] arrayOfString18 = { "芬兰", "358", "Finland", "fi", "0" };
    String[] arrayOfString19 = { "法属圭亚那", "594", "French Guiana", "gf", "0" };
    String[] arrayOfString20 = { "德国", "49", "Germany", "de", "0" };
    String[] arrayOfString21 = { "直布罗陀", "350", "Gibraltar", "gi", "0" };
    String[] arrayOfString22 = { "希腊", "30", "Greece", "gr", "0" };
    String[] arrayOfString23 = { "格陵兰", "299", "Greenland", "", "0" };
    String[] arrayOfString24 = { "关岛", "1671", "Guam", "gu", "0" };
    String[] arrayOfString25 = { "圭亚那", "592", "Guyana", "gy", "0" };
    String[] arrayOfString26 = { "海地", "509", "Haiti", "ht", "0" };
    String[] arrayOfString27 = { "匈牙利", "36", "Hungary", "hu", "0" };
    String[] arrayOfString28 = { "印度", "91", "India", "in", "0" };
    String[] arrayOfString29 = { "印度尼西亚", "62", "Indonesia", "id", "0" };
    String[] arrayOfString30 = { "约旦", "962", "Jordan", "jo", "0" };
    String[] arrayOfString31 = { "肯尼亚", "254", "Kenya ", "ke", "0" };
    String[] arrayOfString32 = { "科威特", "965", "Kuwait", "kw", "0" };
    String[] arrayOfString33 = { "吉尔吉斯斯坦", "996", "Kyrghyzstan", "", "0" };
    String[] arrayOfString34 = { "吉尔吉斯坦", "331", "Kyrgyzstan", "kg", "0" };
    String[] arrayOfString35 = { "黎巴嫩", "961", "Lebanon", "lb", "0" };
    String[] arrayOfString36 = { "卢森堡", "352", "Luxembourg", "lu", "0" };
    String[] arrayOfString37 = { "马其顿", "389", "Macedonia", "", "0" };
    String[] arrayOfString38 = { "马达加斯加", "261", "Madagascar ", "mg", "0" };
    String[] arrayOfString39 = { "摩纳哥", "377", "Monaco", "mc", "0" };
    String[] arrayOfString40 = { "蒙古", "976", "Mongolia", "mn", "0" };
    String[] arrayOfString41 = { "莫桑比克", "258", "Mozambique", "mz", "0" };
    String[] arrayOfString42 = { "尼泊尔", "977", "Nepal", "np", "0" };
    String[] arrayOfString43 = { "荷属安的列斯", "599", "Netheriands Antilles", "an", "0" };
    String[] arrayOfString44 = { "荷兰", "31", "Netherlands", "nl", "0" };
    String[] arrayOfString45 = { "新喀里多尼亚", "687", "New Caledonia", "", "0" };
    String[] arrayOfString46 = { "帕劳", "680", "Palau", "ck", "0" };
    String[] arrayOfString47 = { "巴勒斯坦", "970", "Palestine ", "", "0" };
    String[] arrayOfString48 = { "波多黎各", "1787", "Puerto Rico", "pr", "0" };
    String[] arrayOfString49 = { "罗马尼亚", "40", "Romania", "ro", "0" };
    String[] arrayOfString50 = { "卢旺达", "250", "Rwanda", "", "0" };
    String[] arrayOfString51 = { "圣文森特岛", "1784", "Saint Vincent", "vc", "0" };
    String[] arrayOfString52 = { "圣马力诺", "378", "San Marino", "sm", "0" };
    String[] arrayOfString53 = { "沙特阿拉伯", "966", "Saudi Arabia", "sa", "0" };
    String[] arrayOfString54 = { "斯洛文尼亚", "386", "Slovenia", "si", "0" };
    String[] arrayOfString55 = { "南非", "27", "South Africa", "za", "0" };
    String[] arrayOfString56 = { "西班牙", "34", "Spain", "es", "0" };
    String[] arrayOfString57 = { "斯里兰卡", "94", "Sri Lanka", "lk", "0" };
    String[] arrayOfString58 = { "圣基茨和尼维斯", "1869", "St Kitts and Nevis", "", "0" };
    String[] arrayOfString59 = { "斯威士兰", "268", "Swaziland", "sz", "0" };
    String[] arrayOfString60 = { "台湾", "886", "Taiwan", "tw", "1" };
    String[] arrayOfString61 = { "不丹", "975", "The Kingdom of Bhutan", "", "0" };
    String[] arrayOfString62 = { "尼日尔", "227", "The Niger", "ne", "0" };
    String[] arrayOfString63 = { "白俄罗斯", "375", "The Republic of Belarus", "by", "0" };
    String[] arrayOfString64 = { "土库曼斯坦", "993", "Turkmenistan", "tm", "0" };
    String[] arrayOfString65 = { "乌干达", "256", "Uganda", "ug", "0" };
    String[] arrayOfString66 = { "阿联酋", "971", "United Arab Emirates", "ae", "0" };
    String[] arrayOfString67 = { "英国", "44", "United Kingdom", "gb", "0" };
    String[] arrayOfString68 = { "也门", "967", "Yemen", "ye", "0" };
    String[] arrayOfString69 = { "赞比亚", "260", "Zambia", "zm", "0" };
    a = new String[][] { { "中国", "86", "China", "cn", "2" }, { "阿富汗", "93", "Afghan", "af", "0" }, arrayOfString1, { "阿尔及利亚", "213", "Algeria", "dz", "0" }, { "美属萨摩亚", "1684", "American Samoa", "as", "0" }, { "安道尔", "376", "Andorra", "ad", "0" }, { "安哥拉", "244", "Angola", "ao", "0" }, { "安圭拉", "1264", "Anguilla", "ai", "0" }, { "安提瓜和巴布达", "1268", "Antigua and Barbuda", "ag", "0" }, { "阿根廷", "54", "Argentina", "ar", "0" }, arrayOfString2, arrayOfString3, { "澳大利亚", "61", "Australian", "au", "0" }, { "奥地利", "43", "Austria", "at", "0" }, { "阿塞拜疆", "994", "Azerbaijan", "az", "0" }, { "巴哈马", "1242", "Bahamas", "bs", "0" }, { "巴林", "973", "Bahrain", "bh", "0" }, arrayOfString4, { "巴巴多斯", "1246", "Barbados", "bb", "0" }, { "比利时", "32", "Belgium", "be", "0" }, { "伯利兹", "501", "Belize", "bz", "0" }, { "贝宁", "229", "Benin", "bj", "0" }, arrayOfString5, arrayOfString6, arrayOfString7, { "博茨瓦纳", "267", "Botswana", "bw", "0" }, { "巴西", "55", "Brazil", "br", "0" }, { "文莱", "673", "Brunei", "bn", "0" }, arrayOfString8, { "布基纳法索", "226", "Burkina-faso", "bf", "0" }, { "布隆迪", "257", "Burundi", "bi", "0" }, arrayOfString9, { "喀麦隆", "237", "Cameroon", "cm", "0" }, { "加拿大", "1", "Canada", "ca", "1" }, { "佛得角", "238", "Cape Verde", "", "0" }, { "开曼群岛", "1345", "Cayman Is", "ky", "0" }, arrayOfString10, { "乍得", "235", "Chad", "td", "0" }, arrayOfString11, { "智利", "56", "Chile", "cl", "0" }, { "哥伦比亚", "57", "Columbia", "co", "0" }, arrayOfString12, arrayOfString13, { "克罗地亚", "385", "Croatia", "", "0" }, { "古巴", "53", "Cuba", "cu", "0" }, { "塞浦路斯", "357", "Cyprus", "cy", "0" }, arrayOfString14, { "吉布提", "253", "Djibouti", "dj", "0" }, { "多米尼加", "1767", "Dominica", "", "0" }, { "多米尼加共和国", "1829", "Dominica Rep.", "do", "0" }, { "厄瓜多尔", "593", "Ecuador", "ec", "0" }, { "埃及", "20", "Egypt", "eg", "0" }, arrayOfString15, { "爱沙尼亚", "372", "Estonia", "ee", "0" }, arrayOfString16, arrayOfString17, arrayOfString18, { "法国", "33", "France", "fr", "0" }, arrayOfString19, { "法属波利尼西亚", "689", "French Polynesia", "pf", "0" }, { "加蓬", "241", "Gabon", "ga", "0" }, { "冈比亚", "220", "Gambia", "gm", "0" }, { "格鲁吉亚", "995", "Georgia", "ge", "0" }, arrayOfString20, { "加纳", "233", "Ghana", "gh", "0" }, arrayOfString21, arrayOfString22, arrayOfString23, { "格林纳达", "1473", "Grenada", "", "0" }, { "格林纳达", "1809", "Grenada", "gd", "0" }, arrayOfString24, { "危地马拉", "502", "Guatemala", "gt", "0" }, { "几内亚", "224", "Guinea", "gn", "0" }, { "几内亚比绍", "245", "Guinea-Bissau", "", "0" }, arrayOfString25, arrayOfString26, { "洪都拉斯", "504", "Honduras", "hn", "0" }, { "香港", "852", "Hong Kong", "hk", "1" }, arrayOfString27, { "冰岛", "354", "Iceland", "is", "0" }, arrayOfString28, arrayOfString29, { "伊朗", "98", "Iran", "ir", "0" }, { "伊拉克", "964", "Iraq", "iq", "0" }, { "爱尔兰", "353", "Ireland", "ie", "0" }, { "以色列", "972", "Israel", "il", "0" }, { "意大利", "39", "Italy", "it", "0" }, { "科特迪瓦", "225", "Ivory Coast", "ci", "0" }, { "牙买加", "1876", "Jamaica", "jm", "0" }, { "日本", "81", "Japan", "jp", "1" }, arrayOfString30, { "哈萨克斯坦", "327", "Kazakstan", "kz", "0" }, arrayOfString31, { "韩国", "82", "Korea", "kr", "1" }, arrayOfString32, arrayOfString33, arrayOfString34, { "老挝", "856", "Laos", "la", "0" }, { "拉脱维亚", "371", "Latvia", "lv", "0" }, arrayOfString35, { "莱索托", "266", "Lesotho", "ls", "0" }, { "利比里亚", "231", "Liberia", "lr", "0" }, { "利比亚", "218", "Libya", "ly", "0" }, { "列支敦士登", "423", "Liechtenstein", "li", "0" }, arrayOfString36, { "澳门", "853", "Macao", "mo", "1" }, arrayOfString37, arrayOfString38, { "马拉维", "265", "Malawi", "mw", "0" }, { "马来西亚", "60", "Malaysia", "my", "1" }, { "马尔代夫", "960", "Maldives", "mv", "0" }, { "马里", "223", "Mali", "ml", "0" }, { "马耳他", "356", "Malta", "mt", "0" }, { "马里亚那群岛", "1670", "Mariana Is", "mp", "0" }, { "马提尼克", "596", "Martinique", "mq", "0" }, { "毛里求斯", "230", "Mauritius", "mu", "0" }, { "墨西哥", "52", "Mexico", "mx", "0" }, { "摩尔多瓦", "373", "Moldova", "md", "0" }, arrayOfString39, arrayOfString40, { "蒙特塞拉特岛", "1664", "Montserrat Is", "ms", "0" }, { "摩洛哥", "212", "Morocco", "ma", "0" }, arrayOfString41, { "缅甸", "95", "Myanmar", "mm", "0" }, { "纳米比亚", "264", "Namibia", "na", "0" }, { "瑙鲁", "674", "Nauru", "nr", "0" }, arrayOfString42, arrayOfString43, arrayOfString44, arrayOfString45, { "新西兰", "64", "New Zealand", "nz", "0" }, { "尼加拉瓜", "505", "Nicaragua", "ni", "0" }, { "尼日利亚", "234", "Nigeria", "ng", "0" }, { "诺福克岛", "6723", "Norfolk island", "", "0" }, { "挪威", "47", "Norseland", "no", "0" }, { "朝鲜", "850", "North Korea", "kp", "0" }, { "阿曼", "968", "Oman", "om", "0" }, { "巴基斯坦", "92", "Pakistan ", "pk", "0" }, arrayOfString46, arrayOfString47, { "巴拿马", "507", "Panama", "pa", "0" }, { "巴布亚新几内亚", "675", "Papua New Cuinea", "pg", "0" }, { "巴拉圭", "595", "Paraguay", "py", "0" }, { "秘鲁", "51", "Peru", "pe", "0" }, { "菲律宾", "63", "Philippines", "ph", "0" }, { "波兰", "48", "Poland", "pl", "0" }, { "葡萄牙", "351", "Portuga", "pt", "0" }, arrayOfString48, { "卡塔尔", "974", "Qatar", "qa", "0" }, { "立陶宛", "370", "Republic of Lithuania", "lt", "0" }, { "黑山", "382", "Republic of Montenegro", "", "0" }, { "留尼旺", "262", "Reunion", "", "0" }, arrayOfString49, { "俄罗斯", "7", "Russia", "ru", "0" }, arrayOfString50, { "圣卢西亚", "1758", "Saint Lucia", "lc", "0" }, { "圣皮埃尔和密克隆", "508", "Saint Pierre and Miquelon", "", "0" }, arrayOfString51, { "萨尔瓦多", "503", "Salvador", "sv", "0" }, arrayOfString52, arrayOfString53, { "塞内加尔", "221", "Senegal", "sn", "0" }, { "塞尔维亚", "381", "Serbia", "yu", "0" }, { "塞舌尔", "248", "Seychelles", "sc", "0" }, { "塞拉利昂", "232", "Sierra Leone", "sl", "0" }, { "新加坡", "65", "Singapore", "sg", "1" }, { "斯洛伐克", "421", "Slovakia", "sk", "0" }, arrayOfString54, { "所罗门群岛", "677", "Solomon Is", "sb", "0" }, { "索马里", "252", "Somalia", "so", "0" }, arrayOfString55, arrayOfString56, arrayOfString57, arrayOfString58, { "苏丹", "249", "Sultan", "sd", "0" }, { "苏里南", "597", "Surinam", "sr", "0" }, arrayOfString59, { "瑞典", "46", "Sweden", "se", "0" }, { "瑞士", "41", "Switzerland", "ch", "0" }, { "叙利亚", "963", "Syria", "sy", "0" }, arrayOfString60, { "塔吉克斯坦", "992", "Tajikistan", "tj", "0" }, { "坦桑尼亚", "255", "Tanzania", "tz", "0" }, { "泰国", "66", "Thailand", "th", "0" }, { "法罗群岛", "298", "The Faroe Islands", "", "0" }, arrayOfString61, arrayOfString62, arrayOfString63, { "多哥", "228", "Togo", "tg", "0" }, { "汤加", "676", "Tonga", "to", "0" }, { "特立尼达和多巴哥", "1868", "Trinidad and Tobago", "tt", "0" }, { "突尼斯", "216", "Tunisia", "tn", "0" }, { "土耳其", "90", "Turkey", "tr", "0" }, arrayOfString64, arrayOfString65, { "乌克兰", "380", "Ukraine", "ua", "0" }, arrayOfString66, arrayOfString67, { "美国", "1", "United States Of America", "us", "1" }, { "乌拉圭", "598", "Uruguay", "uy", "0" }, { "乌兹别克斯坦", "998", "Uzbekistan", "uz", "0" }, { "委内瑞拉", "58", "Venezuela", "ve", "0" }, { "越南", "84", "Vietnamese", "vn", "1" }, { "萨摩亚", "685", "Western Samoa", "ws", "0" }, arrayOfString68, { "扎伊尔", "243", "Zaire", "zr", "0" }, arrayOfString69, { "津巴布韦", "263", "Zimbabwe", "zw", "0" } };
  }
  
  public static String a(Context paramContext)
  {
    paramContext = d(paramContext);
    int i;
    if (!TextUtils.isEmpty(paramContext))
    {
      i = 0;
      if (i < a.length) {
        if (!paramContext.equals(a[i][3])) {}
      }
    }
    for (paramContext = a[i][1];; paramContext = "")
    {
      return paramContext;
      i++;
      break;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    int i = ((TelephonyManager)paramContext.getSystemService("phone")).getSimState();
    boolean bool = false;
    switch (i)
    {
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  public static boolean c(Context paramContext)
  {
    AuthConfig localAuthConfig2 = (AuthConfig)d.a(paramContext).a(AuthConfig.class);
    AuthConfig localAuthConfig1 = localAuthConfig2;
    if (localAuthConfig2 == null) {
      localAuthConfig1 = new AuthConfig(paramContext);
    }
    boolean bool;
    if (!localAuthConfig1.h()) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (!"86".equals(a(paramContext))) {
        bool = false;
      } else if (!b(paramContext)) {
        bool = false;
      } else if (TextUtils.isEmpty(k.f(paramContext))) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  private static String d(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
        paramContext = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */