package com.aikya.rnsit.crisisoninfiniteearths;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private AlertDialog dialog;
    private RecyclerView recyclerView;
    private static final int RC_BARCODE_CAPTURE = 9001;
    private ArrayList<CodeAndImage> mainList;
    private GalleryAdapter galleryAdapter;
    ImageView imageView;

    SimpleDateFormat simpleDateFormat;
    String time;
    Calendar calander;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view_top);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showTimeAlert(UserPrefrenceManager.getTimeHero(MainActivity.this),UserPrefrenceManager.getTimeVillain(MainActivity.this),UserPrefrenceManager.getTimeBonus(MainActivity.this));
                return true;
            }
        });
        mainList = new ArrayList<>();

        if (UserPrefrenceManager.getPosition(this) == 0) {
            imageView.setImageResource(R.drawable.top1);
        } else if (UserPrefrenceManager.getPosition(this) <= 4) {
            imageView.setImageResource(R.drawable.top2);
        } else if (UserPrefrenceManager.getPosition(this) == 5) {
            imageView.setImageResource(R.drawable.top5);
        } else if (UserPrefrenceManager.getPosition(this) <= 9) {
            imageView.setImageResource(R.drawable.top3);
        } else if (UserPrefrenceManager.getPosition(this) == 10) {
            imageView.setImageResource(R.drawable.top4);
        } else {
            imageView.setImageResource(R.drawable.top5);
        }

        mainList.add(new CodeAndImage(getResources().getString(R.string.qr1), R.drawable.mm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr2), R.drawable.flash));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr3), R.drawable.firestorm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr4), R.drawable.batman));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr5), R.drawable.dummy));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr6), R.drawable.lexluthor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr7), R.drawable.deathstroke));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr8), R.drawable.darkseid));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr9), R.drawable.joker));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr10), R.drawable.monitor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr11), R.drawable.dummy));

       /*3 mainList.add(new CodeAndImage(getResources().getString(R.string.qr1), R.drawable.firestorm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr2), R.drawable.mm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr3), R.drawable.batman));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr4), R.drawable.flash));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr5), R.drawable.dummy));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr6), R.drawable.darkseid));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr7), R.drawable.lexluthor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr8), R.drawable.joker));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr9), R.drawable.deathstroke));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr10), R.drawable.monitor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr11), R.drawable.dummy)); */


      /*4 mainList.add(new CodeAndImage(getResources().getString(R.string.qr1), R.drawable.batman));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr2), R.drawable.firestorm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr3), R.drawable.flash));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr4), R.drawable.mm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr5), R.drawable.dummy));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr6), R.drawable.joker));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr7), R.drawable.darkseid));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr8), R.drawable.deathstroke));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr9), R.drawable.lexluthor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr10), R.drawable.monitor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr11), R.drawable.dummy)); */

      /*2  mainList.add(new CodeAndImage(getResources().getString(R.string.qr1), R.drawable.flash));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr2), R.drawable.batman));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr3), R.drawable.mm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr4), R.drawable.firestorm));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr5), R.drawable.dummy));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr6), R.drawable.deathstroke));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr7), R.drawable.joker));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr8), R.drawable.lexluthor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr9), R.drawable.darkseid));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr10), R.drawable.monitor));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr11), R.drawable.dummy)); */

        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        if (UserPrefrenceManager.getPosition(this) != 0) {
            Log.e("ABC", UserPrefrenceManager.getPosition(this) + "");

            ArrayList<CodeAndImage> list = new ArrayList<>();
            for (int i = 0; i <= UserPrefrenceManager.getPosition(this) - 1; i++) {
                list.add(mainList.get(i));
            }
            galleryAdapter.setList(list);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BarcodeCaptureActivity.class);
                intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
                intent.putExtra(BarcodeCaptureActivity.UseFlash, false);
                startActivityForResult(intent, RC_BARCODE_CAPTURE);


            }
        });
    }

    private void initRecyclerView() {
        galleryAdapter = new GalleryAdapter();
        galleryAdapter.setCallback(new GalleryAdapter.Callback() {
            @Override
            public void onItemClick(View view, int position) {
                CodeAndImage selectedComment = galleryAdapter.getItemByPosition(position);
                Intent intent = new Intent(MainActivity.this, ImageViewerActivity.class);
                intent.putExtra(ImageViewerActivity.IMAGE_ID, selectedComment.getImage());
                startActivity(intent);
                //startActionMode(selectedComment);
            }
        });
        recyclerView.setAdapter(galleryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setNestedScrollingEnabled(false);
    }


    private void showPositiveAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Congratulation u have found the target.\nNew distress signal recieved.");
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();

    }
    private void showTimeAlert(String a1,String a,String b) {
        String t="Hero Round:"+a1+"\n"+"Villain Round:"+a+"\n"+"Bonus Ronnd:"+b;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(t);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();

    }


    private void showNegativeAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Oops u missed something");
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    private void showCompletedAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("U are done,return to base");
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }


    private void checkBarcode(String barcode) {


        Log.e("ABC", UserPrefrenceManager.getPosition(this) + "");
        if (UserPrefrenceManager.getPosition(this) < 11) {
            if (barcode.equals(mainList.get(UserPrefrenceManager.getPosition(this)).getCode())) {
                showPositiveAlert();
                ArrayList<CodeAndImage> list = new ArrayList<>();
                if(UserPrefrenceManager.getPosition(this)==0){
                    calander = Calendar.getInstance();
                    simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    time = simpleDateFormat.format(calander.getTime());
                    UserPrefrenceManager.setupTimeHero(this,time);
                    imageView.setImageResource(R.drawable.top2);
                }
                 else if (UserPrefrenceManager.getPosition(this) <= 3) {
                    imageView.setImageResource(R.drawable.top2);
                } else if (UserPrefrenceManager.getPosition(this) == 4) {
                    imageView.setImageResource(R.drawable.top5);
                }else if(UserPrefrenceManager.getPosition(this) == 5){
                    calander = Calendar.getInstance();
                    simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    time = simpleDateFormat.format(calander.getTime());
                    UserPrefrenceManager.setupTimeVillain(this,time);
                    imageView.setImageResource(R.drawable.top3);

                } else if (UserPrefrenceManager.getPosition(this) <= 8) {
                    imageView.setImageResource(R.drawable.top3);
                } else if (UserPrefrenceManager.getPosition(this) == 9) {
                    calander = Calendar.getInstance();
                    simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                    time = simpleDateFormat.format(calander.getTime());
                    UserPrefrenceManager.setupTimeBonus(this,time);
                    imageView.setImageResource(R.drawable.top4);
                } else {
                    imageView.setImageResource(R.drawable.top5);
                }
                for (int i = 0; i <= UserPrefrenceManager.getPosition(this); i++) {
                    list.add(mainList.get(i));
                }
                galleryAdapter.setList(list);
                UserPrefrenceManager.setupPosition(this, UserPrefrenceManager.getPosition(this) + 1);
            } else
                showNegativeAlert();
        } else
            showCompletedAlert();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_BARCODE_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra(BarcodeCaptureActivity.BarcodeObject);
                    checkBarcode(barcode.displayValue);
                } else {
                    Toast.makeText(MainActivity.this, "No barcode captured", Toast.LENGTH_SHORT).show();
                }
            } else {

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
