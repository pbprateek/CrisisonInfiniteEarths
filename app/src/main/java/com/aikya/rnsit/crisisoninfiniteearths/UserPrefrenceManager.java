package com.aikya.rnsit.crisisoninfiniteearths;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPrefrenceManager {

    private static SharedPreferences mSharedPreferences;
    private static final String PREF_NAME = "AIKYA";


    private static String POSITION="position";
    private static String LIST_NO="list_no";

    private static void init(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void setupPosition(Context mContext,
                             int pos){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mShEditor=mSharedPreferences.edit();

        mShEditor.putInt(POSITION,pos);
        mShEditor.commit();
    }
    public static void setupListNo(Context mContext,
                                     int listNo){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mShEditor=mSharedPreferences.edit();

        mShEditor.putInt(LIST_NO,listNo);
        mShEditor.commit();
    }


    public static void logout(Context mContext){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mSEditor=mSharedPreferences.edit();
        mSEditor.clear();
        mSEditor.commit();
    }


    public static int getPosition(Context mContext){
        int pos;
        if(mSharedPreferences==null){
            init(mContext);
        }
        pos=mSharedPreferences.getInt(POSITION,0);
        return pos;
    }

    public static int getListNo(Context mContext){
        int listNo;
        if(mSharedPreferences==null){
            init(mContext);
        }
        listNo=mSharedPreferences.getInt(LIST_NO,-1);
        return listNo;
    }

}

