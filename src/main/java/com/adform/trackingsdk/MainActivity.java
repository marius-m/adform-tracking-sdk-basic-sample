package com.adform.trackingsdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.adform.adformtrackingsdk.AdformTrackingSdk;
import com.adform.adformtrackingsdk.TrackPoint;
import com.adform.adformtrackingsdk.entities.Order;
import com.adform.trackingsdk.simpleapp.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.view_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order();
                order.setCurrency("currency");
                order.setOrderStatus("order status");
                order.setEmail("email");
                order.setOrderId("order id");

                // You can also set other custom variables.
                order.addCustomValue(1, "var1 value"); //Set index (1-10) of custom variable and value
                order.addSystemValue(5, "sv5 value"); //Set index (1-89) of system variable and value
                order.addNumericValue(3, 45.4); //Set index (1 or 2) of numeric system variable and value (numeric format)

                final TrackPoint trackPoint = new TrackPoint(Constants.TRACK_POINT_ID);
                trackPoint.setSectionName("custom-demo-Ri5wq7#$Vmpt");
                trackPoint.setOrder(order);

                AdformTrackingSdk.sendTrackPoint(trackPoint);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AdformTrackingSdk.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AdformTrackingSdk.onPause();
    }
}
