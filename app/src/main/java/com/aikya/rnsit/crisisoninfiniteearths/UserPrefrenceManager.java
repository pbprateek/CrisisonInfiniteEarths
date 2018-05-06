package com.aikya.rnsit.crisisoninfiniteearths;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPrefrenceManager {

    private static SharedPreferences mSharedPreferences;
    private static final String PREF_NAME = "AIKYA";


    private static String POSITION="position";
    private static String TIME0="time0";
    private static String TIME1="time1";
    private static String TIME2="time2";

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




    public static int getPosition(Context mContext){
        int pos;
        if(mSharedPreferences==null){
            init(mContext);
        }
        pos=mSharedPreferences.getInt(POSITION,0);
        return pos;
    }
    public static void setupTimeVillain(Context mContext,
                                     String time){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mShEditor=mSharedPreferences.edit();

        mShEditor.putString(TIME1,time);
        mShEditor.commit();
    }




    public static String getTimeVillain(Context mContext){
        String time;
        if(mSharedPreferences==null){
            init(mContext);
        }
        time=mSharedPreferences.getString(TIME1,"0");
        return time;
    }

    public static void setupTimeBonus(Context mContext,
                                        String time){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mShEditor=mSharedPreferences.edit();

        mShEditor.putString(TIME2,time);
        mShEditor.commit();
    }




    public static String getTimeBonus(Context mContext){
        String time;
        if(mSharedPreferences==null){
            init(mContext);
        }
        time=mSharedPreferences.getString(TIME2,"0");
        return time;
    }

    public static void setupTimeHero(Context mContext,
                                        String time){
        if(mSharedPreferences==null){
            init(mContext);
        }
        SharedPreferences.Editor mShEditor=mSharedPreferences.edit();

        mShEditor.putString(TIME0,time);
        mShEditor.commit();
    }




    public static String getTimeHero(Context mContext){
        String time;
        if(mSharedPreferences==null){
            init(mContext);
        }
        time=mSharedPreferences.getString(TIME0,"0");
        return time;
    }

}

