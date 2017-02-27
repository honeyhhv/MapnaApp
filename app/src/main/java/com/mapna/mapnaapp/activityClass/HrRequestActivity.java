package com.mapna.mapnaapp.activityClass;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;


import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.adaptor.RequestListAdaptor;
import com.mapna.mapnaapp.customViews.customProgressbar;
import com.mapna.mapnaapp.models.HrRequest;
import com.mapna.mapnaapp.models.Period;
import com.mapna.mapnaapp.models.RequestType;
import com.mapna.mapnaapp.tools.PublicMethods;
import com.mapna.mapnaapp.customViews.customButton;
import com.rey.material.widget.ImageView;

import java.io.UnsupportedEncodingException;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.util.TextUtils;


public class HrRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spType, spPeriod;
    private customButton btnSearch;
    private PublicMethods pm;
    private ImageView imgBack;
    private customProgressbar progressbar;
    private ListView listRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr_request);

        BindViews();
        BindSpinners();
    }

    private void BindSpinners() {

        List<RequestType> ReqTypes = pm.getAllRequestType();
        ArrayAdapter<RequestType> reqAdapter = new ArrayAdapter<RequestType>(this, R.layout.support_simple_spinner_dropdown_item, ReqTypes);
        spType.setAdapter(reqAdapter);

        List<Period> periods = pm.getAllPeriods();
        ArrayAdapter<Period> perAdapter = new ArrayAdapter<Period>(this, R.layout.support_simple_spinner_dropdown_item, periods);
        spPeriod.setAdapter(perAdapter);

    }

    private void BindViews() {
        pm = new PublicMethods(this);
        spType = (Spinner) findViewById(R.id.req_type_spinner);
        spPeriod = (Spinner) findViewById(R.id.period_spinner);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        assert imgBack != null;
        imgBack.setOnClickListener(this);

        btnSearch = (customButton) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);

        progressbar = (customProgressbar) findViewById(R.id.progressbar);

        listRequest = (ListView) findViewById(R.id.listRequest);
        //listRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack: {
                finish();
                onBackPressed();
                break;
            }
            case R.id.btnSearch: {
                assert ((Spinner) findViewById(R.id.period_spinner)) != null;
                Period selectedItemPeriod = (Period) ((Spinner) findViewById(R.id.period_spinner)).getSelectedItem();
                assert ((Spinner) findViewById(R.id.req_type_spinner)) != null;
                RequestType selectedItemReq = (RequestType) ((Spinner) findViewById(R.id.req_type_spinner)).getSelectedItem();

                pm.ToastLong(selectedItemPeriod.toString() + " - " + selectedItemReq.getName());

                LoadRequets(selectedItemPeriod.getId(), selectedItemReq.getId());
                break;
            }
        }

    }

    private void LoadRequets(int period_id, String req_id) {
        AsyncHttpClient client = new AsyncHttpClient();

        String strUrl = PublicMethods.Request_TYPE_URL;//pd=8&np=45270&tq=6
        strUrl += "pd=" + period_id + "&np=" + pm.getShared(getString(R.string.PersonelId)) + "&tq=" + req_id;

        Log.d("hrRequest", strUrl);
        client.get(strUrl, new AsyncHttpResponseHandler() {
            /**
             * Fired when the request is started, override to handle in your own code
             */
            @Override
            public void onStart() {
                super.onStart();
                progressbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String strJson = new String(responseBody, "UTF-8");
                    Log.d("AsyncCall", strJson);

                    if (!TextUtils.isEmpty(strJson)) {

                        RequestJsonParser(strJson);

                        Log.d("hrRequest", "after if");
                    } else {
                        pm.ToastLong(getString(R.string.error_get_request));
                    }
                } catch (UnsupportedEncodingException e) {

                    //ToDo catch this eror delicately: UnsupportedEncodingException
                    e.printStackTrace();
                    pm.ToastLong(getString(R.string.error_Server));

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                progressbar.setVisibility(View.INVISIBLE);
                pm.ToastLong(getString(R.string.error_Server));
            }

            /**
             * Fired when the request progress, override to handle in your own code
             *
             * @param bytesWritten offset from start of file
             * @param totalSize    total size of file
             */
            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);

                progressbar.setVisibility(View.VISIBLE);
            }

            /**
             * Fired in all cases when the request is finished, after both success and failure, override to
             * handle in your own code
             */
            @Override
            public void onFinish() {
                super.onFinish();
                progressbar.setVisibility(View.INVISIBLE);

            }
        });


    }

    private void RequestJsonParser(String strJson) {

        if (!strJson.equalsIgnoreCase("null") )
        {
            Gson gson = new Gson();
            HrRequest[] myRequests = gson.fromJson(strJson, HrRequest[].class);
            if (myRequests.length > 0) {
                Log.d("hrRequest", myRequests.length + "");
                RequestListAdaptor requestListAdaptor = new RequestListAdaptor(this, myRequests);
                listRequest.setAdapter(requestListAdaptor);
            } else {
                pm.ToastLong(getString(R.string.error_get_request));
            }
        }else
        {
            pm.ToastLong(getString(R.string.error_get_request));
        }
    }
}
