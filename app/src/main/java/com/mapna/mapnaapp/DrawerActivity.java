package com.mapna.mapnaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;
import com.mapna.mapnaapp.adaptor.DrawerListAdapter;
import com.mapna.mapnaapp.customViews.customTextView;
import com.mapna.mapnaapp.models.DrawerListItem;
import com.mapna.mapnaapp.services.MyFirebaseInstanceIdService;
import com.mapna.mapnaapp.tools.PublicMethods;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageView imgProfile;
    private ImageView imgToggle;
    private ListView lstMenu;
    private DrawerLayout  drawer;
    private customTextView txtUsername;
    private customTextView txtDepartment;
    private PublicMethods pm;
    private FloatingActionButton hourlyLeaveFab;
    private FloatingActionButton dailyLeaveFab;
    private FloatingActionButton hourlymisFab;
    private FloatingActionButton overtime_workFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        pm=new PublicMethods(getApplicationContext());
        BindViews();
        BindDrawerMenu();
        SetUserInfo();

        imgToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( drawer.isDrawerOpen(Gravity.RIGHT)){
                    drawer.closeDrawer(Gravity.RIGHT);
                }else{
                    drawer.openDrawer(Gravity.RIGHT);
                }
            }
        });

        //TODO: variani : should call a service to send token to service
        Intent intentToken=new Intent(DrawerActivity.this, MyFirebaseInstanceIdService.class);
        startService(intentToken);

    }

    private void SetUserInfo() {
        txtUsername.setText(pm.getShared(getString(R.string.Firstname)) + " " +   pm.getShared(getString(R.string.Lastname)));
        txtDepartment.setText(pm.getShared(getString(R.string.Department)));

        //TODO: set image profile

    }

    private void BindViews() {
        imgProfile=(ImageView) findViewById(R.id.imgProfile);
        imgToggle=(ImageView) findViewById(R.id.imgToggle);
        lstMenu=(ListView) findViewById(R.id.listMenu);
        drawer=(DrawerLayout)findViewById(R.id.activity_drawer);
        txtDepartment=(customTextView)findViewById(R.id.txtDepartment);
        txtUsername=(customTextView)findViewById(R.id.txtUsername);

        hourlyLeaveFab= (FloatingActionButton)findViewById(R.id.hourlyLeaveFab);
        hourlyLeaveFab.setOnClickListener(this);
        dailyLeaveFab=(FloatingActionButton)findViewById(R.id.dailyLeaveFab);
        dailyLeaveFab.setOnClickListener(this);
        hourlymisFab=(FloatingActionButton)findViewById(R.id.hourlymisFab);
        hourlymisFab.setOnClickListener(this);
        overtime_workFab=(FloatingActionButton)findViewById(R.id.overtime_workFab);
        overtime_workFab.setOnClickListener(this);
    }

    private void BindDrawerMenu() {

        List<DrawerListItem> drawerListItemModels = new ArrayList<>();

        DrawerListItem dm1 = new DrawerListItem();
        dm1.setTitle(getString(R.string.menu_view_request));
        dm1.setIcon(R.mipmap.view_request);


        DrawerListItem dm2 = new DrawerListItem();
        dm2.setTitle(getString(R.string.menu_clock_in_out));
        dm2.setIcon(R.mipmap.arrival_tim);

        DrawerListItem dm3 = new DrawerListItem();
        dm3.setTitle(getString(R.string.menu_quit));
        dm3.setIcon(R.mipmap.exit);


        drawerListItemModels.add(dm1);
        drawerListItemModels.add(dm2);
        drawerListItemModels.add(dm3);

        DrawerListAdapter drawerListAdapter = new DrawerListAdapter(this, drawerListItemModels);

        lstMenu.setAdapter(drawerListAdapter);

        lstMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    //logoff
                    logOutHandle();

                }
            }
        });


    }

    private void logOutHandle()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(DrawerActivity.this)
                .setTitle(getString(R.string.msg_log_out))
                .setPositiveButton(getString(R.string.msg_yes),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();

                                //clear shared properties
                                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit().clear().apply();
                                startActivity(new Intent(DrawerActivity.this, LoginActivity.class));
                                finish();
                            }
                        }
                )
                .setNegativeButton(getString(R.string.msg_no),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                );
        dialog.show();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.hourlyLeaveFab) {
            Intent h = new Intent(this.getApplicationContext(), HourlyLeaveActivity.class);
            startActivity(h);
        }
        else if ( v.getId()==R.id.dailyLeaveFab)
            {
                Intent h = new Intent(this.getApplicationContext(), DailyLeaveActivity.class);
                startActivity(h);
            }
        else if(v.getId()==R.id.hourlymisFab)
            {
                Intent h = new Intent(this.getApplicationContext(), HourlyMissionActivity.class);
                startActivity(h);
            }
        else if (v.getId()==R.id.overtime_workFab)
            {
                Intent h = new Intent(this.getApplicationContext(), OvertimeWorkActivity.class);
                startActivity(h);
            }
        }

    }
