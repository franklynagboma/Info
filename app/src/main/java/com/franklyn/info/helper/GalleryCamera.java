package com.franklyn.info.helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;


import com.franklyn.info.ui.view.CircularImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by AGBOMA Franklyn on 3/18/2016.
 */
public class GalleryCamera extends Activity{

    private static String logTag = GalleryCamera.class.getSimpleName();

    //imageView
    private static ImageView imageLoad;

    //camera codes
    public static final int CAMERA_CODE = 100;
    public static final int MEDIA_CAMERA_TYPE = 1;

    //gallery codes
    public static final int GALLERY_CODE = 200;

    //storage directory
    private static final String CAMERA_DIR = "Info camera";

    //uri to store image
    private static Uri fileUri;
    private static String getUri = "";
    private static boolean which;

    public static Intent getCameraIntent() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getImageFileUri(MEDIA_CAMERA_TYPE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);


        return intent;
    }

    public static Intent getGalleryIntent() {

        //default gallery app.
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        Intent addIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        addIntent.setType("image/*");

        Intent chooser = Intent.createChooser(intent, "Info profile picture");
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {addIntent});
        Log.e(logTag, "Chooser Intent: " + chooser.toString());

        return chooser;
    }


    public static boolean ifCameraPresent(Context context) {

        if(context.getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            return true; //device has camera
        }
        else {
            return false; //device does not have camera
        }
    }

    private static Uri getImageFileUri(int getType) {
        return Uri.fromFile(getImageFile(getType));
    }

    private static File getImageFile(int type) {


        File mediaStorageDir = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                CAMERA_DIR);

        //create storage director if not exist
        if(!mediaStorageDir.exists()) {
            if(!mediaStorageDir.mkdir()){
                Log.e(logTag, CAMERA_DIR + " does no exist." );
                return null;
            }
        }

        //create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        Log.e(logTag, "Time: " + timeStamp);
        //Use time format for something else.


        File mediaFile;
        if(type == MEDIA_CAMERA_TYPE) {

            mediaFile = new File(mediaStorageDir.getPath()
                    +File.separator
                    +"Info" + timeStamp + ".jpg");

            Log.e(logTag, "Media file: " + mediaFile.toString());
        }
        else {
            return null;
        }

        return mediaFile;
    }

    public static void capture(ImageView imageView, Uri file) {

        try {

            imageLoad = imageView;

            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inSampleSize = 8;//reduces the size of image

            //checking file value
            if(file != null) {
                getUri = file.getPath();
            }
            else {
                getUri = fileUri.getPath();
            }

            which = false; // if camera.

            final Bitmap bitmap = BitmapFactory.decodeFile(getUri, opts);
            Log.e(logTag, "file uri path: " + getUri);

            Bitmap getBitmap = CircularImageView.getCircleBitmap(bitmap);
            imageLoad.setImageBitmap(getBitmap);
            Log.e(logTag, "Camera getBitmap: " + getBitmap);

        } catch (NullPointerException i){
            i.printStackTrace();
            Log.e(logTag, "Error loading image");
        }
    }

    public static void gallery(Context context,ImageView imageView, Uri uri) {

        try {

            imageLoad = imageView;

            getUri = uri.toString();
            which = true; // if uri.

            final Bitmap bitmap = MediaStore.Images.Media
                    .getBitmap(context.getContentResolver(), uri);
            Bitmap getBitmap = CircularImageView.getCircleBitmap(bitmap);
            imageLoad.setImageBitmap(getBitmap);
            Log.e(logTag, "Gallery getBitmap: " + getBitmap);
        }
        catch (IOException i) {
            i.printStackTrace();
            Log.e(logTag," No access");
        }
    }

    public static boolean getWhich() {
        return which;
    }


    public static String getImage(){
        return getUri;
    }


}
