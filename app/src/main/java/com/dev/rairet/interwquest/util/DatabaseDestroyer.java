package com.dev.rairet.interwquest.util;

import android.content.Context;
import android.util.Log;

import com.dev.rairet.interwquest.Configuration;

import java.io.File;

public class DatabaseDestroyer {

    public static void deleteDb(Context context) {
        context.deleteDatabase(Configuration.DATABASE_NAME);
        File db = new File(context.getApplicationInfo().dataDir, Configuration.DATABASE_SHARED_PREFS);
        db.delete();
    }
}
