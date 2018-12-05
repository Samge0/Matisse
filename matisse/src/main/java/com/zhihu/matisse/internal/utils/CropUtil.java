package com.zhihu.matisse.internal.utils;

import android.app.Activity;
import android.net.Uri;
import android.os.Environment;

import com.yalantis.ucrop.UCrop;
import com.zhihu.matisse.internal.entity.SelectionSpec;

import java.io.File;

/**
 * ================================================
 * <p>
 * Created by samge on 18-12-6 上午12:40  星期四
 * <p>
 * ================================================
 */
public class CropUtil {


    /**
     * crop a photo
     * @param activity
     * @param mSpec
     * @param selectedUri
     */
    public static void doCrop(Activity activity, SelectionSpec mSpec,Uri selectedUri) {
        File dir=new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/nface");
        if(!dir.exists()){
            dir.mkdirs();
        }
        Uri uri = Uri.fromFile(new File(dir, "nface_crop_"+System.currentTimeMillis() + ".jpg"));
        int width = mSpec.maxWidth == 0 ? 500 : mSpec.maxWidth;
        int height = mSpec.maxHeight == 0 ? 500 : mSpec.maxHeight;
        UCrop.of(selectedUri, uri)
                .withOptions(new UCrop.Options())
                .withAspectRatio(width, height)
                .withMaxResultSize(width, height)
                .start(activity);
    }

}
