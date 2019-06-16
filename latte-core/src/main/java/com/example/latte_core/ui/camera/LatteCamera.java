package com.example.latte_core.ui.camera;

import android.net.Uri;
import com.example.latte_core.delegates.PermissionCheckerDelegate;
import com.example.latte_core.util.file.FileUtil;


/**
 * 照相机调用类
 */

public class LatteCamera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }

//    public static void start(PermissionCheckerDelegate permissionCheckerDelegate) {
//    }
}
