package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by User on 6/2/2019.
 */

public class canteen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteens);
    }


    public void go(View view)
    {
        Intent nextact=new Intent(this,Order_Type.class);
        startActivity(nextact);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }
}
