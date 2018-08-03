package com.dev.rairet.interwquest.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;

import com.dev.rairet.interwquest.R;

public class HtmlImageGetter implements Html.ImageGetter {
    Context context;

    public HtmlImageGetter(Context context) {
        this.context = context;
    }

    @Override
    public Drawable getDrawable(String source) {
        int id;

        if (source.equals("css.png")) {
            id = R.mipmap.css;
        }
        else if (source.equals("java_io.png")) {
            id = R.mipmap.java_io;
        }
        else {
            return null;
        }

        Drawable d = context.getResources().getDrawable(id);
        d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
        return d;
    }
}
