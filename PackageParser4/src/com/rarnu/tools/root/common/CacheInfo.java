package com.rarnu.tools.root.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class CacheInfo {

    public String cacheSize;
    public String namespace;
    public PackageInfo info;

    public static CacheInfo parseString(Context context, String str) {
        // 4.0K com.android.defcontainer
        String[] cs = str.split(" ");
        CacheInfo info = new CacheInfo();
        info.cacheSize = cs[0] + "K";
        info.namespace = cs[1];
        try {
            info.info = context.getPackageManager().getPackageInfo(info.namespace, 0);
        } catch (NameNotFoundException e) {
            info.info = null;
        }
        if (info.info == null) {
            return null;
        }
        return info;
    }
}
