package com.example.birthdaywish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Shape;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {

    TextView birthdaytext;
    RelativeLayout layout0, layoutW;
    ViewSwitcher viewswitch, viewswitch1,viewswitch2,viewswitch3,viewswitchw,viewswitchx,viewswitchy,viewswitchz;

    KonfettiView konfettiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewswitch = findViewById(R.id.viewswitch);
        viewswitch1 = findViewById(R.id.viewswitch1);
        viewswitch2 = findViewById(R.id.viewswitch2);
        viewswitch3 = findViewById(R.id.viewswitch3);
        viewswitchw = findViewById(R.id.viewswitchw);
        viewswitchx = findViewById(R.id.viewswitchx);
        viewswitchy = findViewById(R.id.viewswitchy);
        viewswitchz = findViewById(R.id.viewswitchz);

        birthdaytext = findViewById(R.id.birthdaytext);
        layout0=findViewById(R.id.layout0);
        layoutW = findViewById(R.id.layoutW);

        Animation rotation = AnimationUtils.loadAnimation(this,R.anim.anim_pic);
        viewswitch.setAnimation(rotation);
        viewswitchw.setAnimation(rotation);


        layoutOneView();




    }

    private void layoutOneView() {



        layout0.setVisibility(View.VISIBLE);
        layoutW.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitch.getDisplayedChild() == 0){
                    viewswitch.showNext();
                }else
                    viewswitch.showPrevious();

            }
        },10000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitch1.getDisplayedChild() == 0){
                    viewswitch1.showNext();
                }else
                    viewswitch1.showPrevious();

            }
        },20000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitch2.getDisplayedChild() == 0){
                    viewswitch2.showNext();
                }else
                    viewswitch2.showPrevious();

            }
        },30000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitch3.getDisplayedChild() == 0){
                    viewswitch3.showNext();
                }else
                    viewswitch3.showPrevious();

            }
        },40000);



        layoutTwoView();


    }

    private void layoutTwoView() {
        layout0.setVisibility(View.GONE);
        layoutW.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitchw.getDisplayedChild() == 0){
                    viewswitchw.showNext();
                }else
                    viewswitchw.showPrevious();
            }
        },10000); // not using 50000 because of W running state

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitchx.getDisplayedChild() == 0){
                    viewswitchx.showNext();
                }else
                    viewswitchx.showPrevious();

            }
        },20000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitchy.getDisplayedChild() == 0){
                    viewswitchy.showNext();
                }else
                    viewswitchy.showPrevious();

            }
        },30000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (viewswitchz.getDisplayedChild() == 0){
                    viewswitchz.showNext();
                }else
                    viewswitchz.showPrevious();

            }
        },40000);

    }

    @Override
    protected void onStart() {
        startService(new Intent(this,music_service.class ));

        super.onStart();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopService(new Intent(this,music_service.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopService(new Intent(this,music_service.class));
    }
}