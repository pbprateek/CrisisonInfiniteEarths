package com.aikya.rnsit.crisisoninfiniteearths;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private  AlertDialog dialog;
    private RecyclerView recyclerView;
    private static final int RC_BARCODE_CAPTURE = 9001;
    private ArrayList<CodeAndImage> mainList;
    private GalleryAdapter galleryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainList=new ArrayList<>();
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr1),R.drawable.qr1));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr2),R.drawable.qr2));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr3),R.drawable.qr3));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr4),R.drawable.qr4));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr5),R.drawable.qr5));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr6),R.drawable.qr6));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr7),R.drawable.qr7));
        mainList.add(new CodeAndImage(getResources().getString(R.string.qr8),R.drawable.qr8));

        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        if(UserPrefrenceManager.getPosition(this)!= 0){
            Log.e("ABC",UserPrefrenceManager.getPosition(this)+"");

            ArrayList<CodeAndImage> list= new ArrayList<>();
            for(int i=0;i<=UserPrefrenceManager.getPosition(this)-1;i++){
                list.add(mainList.get(i));
            }
            galleryAdapter.setList(list);
        }






        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BarcodeCaptureActivity.class);
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
                Intent intent=new Intent(MainActivity.this,ImageViewerActivity.class);
                intent.putExtra(ImageViewerActivity.IMAGE_ID,selectedComment.getImage());
                startActivity(intent);
                //startActionMode(selectedComment);
            }
        });
        recyclerView.setAdapter(galleryAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setNestedScrollingEnabled(false);
    }


    private void showPositiveAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Great..u are on track");
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();

    }


    private void showNegativeAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("oops u missed something");
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




    private void checkBarcode(String barcode){


        Log.e("ABC",UserPrefrenceManager.getPosition(this)+"");
        if(UserPrefrenceManager.getPosition(this)<8){
            if(barcode.equals(mainList.get(UserPrefrenceManager.getPosition(this)).getCode())){
                showPositiveAlert();
                ArrayList<CodeAndImage> list= new ArrayList<>();
                for(int i=0;i<=UserPrefrenceManager.getPosition(this);i++){
                    list.add(mainList.get(i));
                }
                galleryAdapter.setList(list);
                UserPrefrenceManager.setupPosition(this,UserPrefrenceManager.getPosition(this)+1);
            }
            else
                showNegativeAlert();
        }else
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
                    Toast.makeText(MainActivity.this,"No barcode captured",Toast.LENGTH_SHORT).show();
                }
            } else {

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
