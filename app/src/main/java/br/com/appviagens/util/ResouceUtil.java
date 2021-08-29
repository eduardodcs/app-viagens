package br.com.appviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResouceUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoDrawble = resources.getIdentifier(drawableEmTexto,
                DRAWABLE, context.getPackageName());
        Drawable drawableImagePacote = resources.getDrawable(idDoDrawble);
        return drawableImagePacote;
    }
}
