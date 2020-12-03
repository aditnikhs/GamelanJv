package id.soewidiatmaka.gamelanjv;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import static java.lang.Thread.sleep;

public class SplashActivity extends AppCompatActivity {

    private final static int EXIT_CODE = 100;


    ImageView imageViewS;
    TextView textViewS;
    TextView textViewS2;


    // here first we need to decalare some variables

    private static final int PERMISSION_CONSTANT = 100;  // first is the permission constant


    private static final int REQUEST_PERMISSION_SETTING = 101; // Request permission settings code

    // Then I am creating a array of the name permissionsRequired
    // And i am filling it with the permissions that i want

    String[] permissionsRequired = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO,
    };

    private SharedPreferences permissionStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener
                (visibility -> {
                    if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        getWindow().getDecorView().setSystemUiVisibility(hideSystemBars());
                        }
                });

        Context context = getBaseContext();

        imageViewS = findViewById(R.id.imageViewSplash);
        textViewS = findViewById(R.id.textViewSplash);
        textViewS2 = findViewById(R.id.textViewSplash2);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.transitional2);

        textViewS.startAnimation(animation2);
        imageViewS.startAnimation(animation);
        textViewS2.startAnimation(animation2);

        Thread thread = new Thread(() -> {

            try{
                sleep(5000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }finally {

                //  Here we need to initialize the screen
                permissionStatus = getSharedPreferences("permissionStatus",MODE_PRIVATE);

                /*Here first we need to check for the self permission whether is pre granted or not*/


                if(ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
                        || ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[0])
                            || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[1])
                    ){
                        //Show Information about why you need the permission

                        /*Then need to give some information to user why the permission are required
                         * By building the AlertDialog
                         * */


                        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                        builder.setTitle("Need Multiple Permissions");
                        builder.setMessage("This app needs Storage and Record Audio Permissions.");
                        builder.setPositiveButton("Grant", (dialog, which) -> {
                            dialog.cancel();
                            ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                        });
                        builder.setNegativeButton("Cancel", (dialog, which) -> {
                            dialog.cancel();

                            CharSequence text1 = "Unable to get Permission";
                            int durationLong = android.widget.Toast.LENGTH_LONG;
                            android.widget.Toast.makeText(context,text1,durationLong).show();

                            ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                        });
                        builder.show();
                    }
                    else if (permissionStatus.getBoolean(permissionsRequired[0],false)) {

                        /*Now previously the permissions are not allowed so this else block will execute
                         * when the user deny all the permission also the Grant to permissoin dialog as well
                         *
                         * So, the bellow line of code takes the user to the Settings of the Application
                         * From where user need to give the permission manually by taping on the switch button
                         *
                         * */



                        // Previously Permission Request was cancelled with 'Dont Ask Again',
                        // Redirect to Settings after showing Information about why you need the permission

                        /*
                         *   First need to build the dialog that will be shown in which user can interact
                         *   after that need to specify the listener to the positive button
                         * * */
                        lasthope();



                    } else {
                        //just request the permission by calling the requestPermissions() method
                        ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                    }

                    SharedPreferences.Editor editor = permissionStatus.edit();
                    editor.putBoolean(permissionsRequired[0],true);
                    editor.apply();
                }else {
                    //You already have the permission, just go ahead.
                    proceedAfterPermission();
                }
            }
        });

        thread.start();

    }

    private void lasthope() {
        Context context = getBaseContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle("Membutuhkan Izin");
        builder.setMessage("Aplikasi ini membutuhkan izin Data Storage dan Microphone.");

        builder.setPositiveButton("Izinkan", (dialog, which) -> {
            dialog.cancel();

            /* Then with the use of the Intent or Uri Start Activity for the result
             *  by startActivityForResult()
             * */

            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
            CharSequence text = "Pergi ke Perizinan, izinkan Penyimpanan Data dan Perekam Audio.";
            int duration = android.widget.Toast.LENGTH_SHORT;
            android.widget.Toast.makeText(context, text, duration).show();
        });

        /*
         * Then need to build the negative button so that the user can cancel that
         * or at the end we need to close the application by calling finish() method
         *
         * */
        builder.setNegativeButton("Urungkan", (dialog, which) -> {
            dialog.cancel();

            CharSequence text1 = "Gagal mendapat izin";
            int durationLong = android.widget.Toast.LENGTH_LONG;
            android.widget.Toast.makeText(context,text1,durationLong).show();

            lasthope2();
        });
        builder.show();
    }

    private void lasthope2() {
        Context context = getBaseContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
        builder.setTitle("Membutuhkan Izin");
        builder.setMessage("Aplikasi ini membutuhkan izin Data Storage dan Microphone.");


        builder.setPositiveButton("Izinkan", (dialog, which) -> {
            dialog.cancel();

            /* Then with the use of the Intent or Uri Start Activity for the result
             *  by startActivityForResult()
             * */

            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", getPackageName(), null);
            intent.setData(uri);
            startActivityForResult(intent, REQUEST_PERMISSION_SETTING);
            CharSequence text = "Pergi ke Perizinan, izinkan Penyimpanan Data dan Perekam Audio.";
            int duration = android.widget.Toast.LENGTH_SHORT;
            android.widget.Toast.makeText(context, text, duration).show();
        });

        /*
         * Then need to build the negative button so that the user can cancel that
         * or at the end we need to close the application by calling finish() method
         *
         * */
        builder.setNegativeButton("Urungkan", (dialog, which) -> {
            dialog.cancel();

            CharSequence text1 = "Gagal mendapat izin.";
            int durationLong = android.widget.Toast.LENGTH_LONG;
            android.widget.Toast.makeText(context,text1,durationLong).show();

            lasthope();
        });
        builder.show();
    }

    /*
     *
     *      At the third number we need to call the onRequestPermissionsResult() method
     *
     * */


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_CONSTANT){  // here matching the requestCode to PERMISSION_CONSTANT
            //check if all permissions are granted
            boolean allgranted = false;         // here setting the variable to false

            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    allgranted = true;
                } else {
                    allgranted = false;
                    break;
                }
            }

            if(allgranted){ //its true means permission granted then call the proceedAfterPermission() Method
                proceedAfterPermission(); // This method will takes the user to the PianoActiviy
            } else if(ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[0])
                    || ActivityCompat.shouldShowRequestPermissionRationale(SplashActivity.this,permissionsRequired[1])
            ){
//
                /*
                 *  Then again here need to build the AlertDialog to give some information to user
                 * */

                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setTitle("Membutuhkan Izin");
                builder.setMessage("Aplikasi ini membutuhkan izin Data Storage dan Microphone.");
                builder.setPositiveButton("Izinkan", (dialog, which) -> {
                    dialog.cancel();
                    ActivityCompat.requestPermissions(SplashActivity.this,permissionsRequired,PERMISSION_CONSTANT);
                });
                builder.setNegativeButton("Urungkan", (dialog, which) -> {
                    dialog.cancel();

                    Context context = getBaseContext();
                    CharSequence text1 = "Gagal memperoleh izin.";
                    int durationLong = android.widget.Toast.LENGTH_LONG;
                    android.widget.Toast.makeText(context,text1,durationLong).show();

                    lasthope();

//                    handler.postDelayed(() -> {
//                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                        startActivity(intent);
//                    }, 6000);
                });

                // Then at the end we need to show the dialog
                builder.show();
            } else {

                lasthope();
//
//                handler.postDelayed(() -> {
//                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(intent);
//                }, 6000);

                /*This else part excutes and here we can write some code that
                 *  like we can specify a code to close the application
                 *  by calling the finish() method
                 *
                 * */

            }
        }
    }// end of the onRequestPermissionsResult() method


    /*
     *   The following code can be written at the end of the lecture tutorial
     * */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PERMISSION_SETTING) {
            if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) == PackageManager.PERMISSION_GRANTED) {
                //Got Permission
                proceedAfterPermission();
            }
        }


        if (requestCode == EXIT_CODE){
            if (resultCode == RESULT_OK){
                data.getBooleanExtra("Keluar", true);
                lasthope();
            }
        }

    }


    // This can be used to create a second last lecture of The Course when explaining or demonstrate the
    // concept of RuntimePermissions


    /*
     *  proceedAfterPermission() Method is called when the app gets all the permissions successfully
     * */

    private void proceedAfterPermission() {


        startActivityForResult(new Intent(SplashActivity.this,MainActivity.class),EXIT_CODE);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    // HIDE NAVIGATION RELATED
    @Override
    public void onWindowFocusChanged(boolean visibility) {
        super.onWindowFocusChanged(visibility);
        if (visibility){
            getWindow().getDecorView().setSystemUiVisibility(hideSystemBars());
        }
    }
    public int hideSystemBars() {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
    }


//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        if (ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[0]) != PackageManager.PERMISSION_GRANTED
//                || ActivityCompat.checkSelfPermission(SplashActivity.this, permissionsRequired[1]) != PackageManager.PERMISSION_GRANTED) {
//            lasthope();
//        }
//    }

    @Override
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
