package com.mapna.mapnaapp.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mapna.mapnaapp.R;
import com.mapna.mapnaapp.customViews.customTextView;
import com.mapna.mapnaapp.models.HrRequest;

import java.util.List;

/**
 * Created by variani_h on 2/7/2017.
 */

public class RequestListAdaptor extends BaseAdapter {
    private Context mContext;
    //private List<HrRequest> hrRequestItemList;
    private HrRequest[] hrRequestItemList;

    public RequestListAdaptor(Context mContext, HrRequest[] hrRequestItemList) {
        this.mContext = mContext;
        this.hrRequestItemList = hrRequestItemList;
    }

//    public RequestListAdaptor(Context mContext, List<HrRequest> hrRequestItemList) {
//        this.mContext = mContext;
//        this.hrRequestItemList = hrRequestItemList;
//    }

    @Override
    public int getCount() {
        return hrRequestItemList.length ;
    }

    @Override
    public Object getItem(int position) {
        return hrRequestItemList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = LayoutInflater.from(mContext).inflate(R.layout.request_list_item, parent, false);

        customTextView title = (customTextView) rowView.findViewById(R.id.lblRequest);
        //ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
        String result= hrRequestItemList[position].getReqTypeDesc();

        switch (hrRequestItemList[position].getReqCat().trim()) {
            case "6" ://mContext.getString(R.string.req_type_hourly_leave):
            {
                result+=": " + hrRequestItemList[position].getStartDate() + System.getProperty ("line.separator")+
                        mContext.getString(R.string.label_from_time)+" : " + hrRequestItemList[position].getStartTime()
                        +" " + mContext.getString(R.string.label_to)+" : " + hrRequestItemList[position].getEndTime() + System.getProperty ("line.separator");

                if (hrRequestItemList[position].getMissionSubject().length()>0)
                    result+=mContext.getString(R.string.label_mission_title)+ hrRequestItemList[position].getMissionSubject()+ System.getProperty ("line.separator");

                if (hrRequestItemList[position].getMissionPlace().length()>0)
                    result+=mContext.getString(R.string.label_mission_Location)+ hrRequestItemList[position].getMissionPlace()+ System.getProperty ("line.separator");

                if (hrRequestItemList[position].getRemarks().length()>0)
                    result+=mContext.getString(R.string.label_mission_Desc)+ hrRequestItemList[position].getRemarks()+ System.getProperty ("line.separator");


                result+=mContext.getString(R.string.label_Status)+ hrRequestItemList[position].getStatusDesc()+ System.getProperty ("line.separator")+
                        mContext.getString(R.string.label_Req_Date)+ hrRequestItemList[position].getReqDate();

                break;
            }
            case "2":{
                result+=": " + hrRequestItemList[position].getStartDate() + System.getProperty ("line.separator")+
                        mContext.getString(R.string.label_from_time)+" : " + hrRequestItemList[position].getStartTime()
                        +" " + mContext.getString(R.string.label_to)+" : " + hrRequestItemList[position].getEndTime() + System.getProperty ("line.separator");


                if (hrRequestItemList[position].getRemarks().length()>0)
                    result+=mContext.getString(R.string.label_Desc)+ hrRequestItemList[position].getRemarks();

                result+=mContext.getString(R.string.label_Status)+ hrRequestItemList[position].getStatusDesc()+ System.getProperty ("line.separator")+
                        mContext.getString(R.string.label_Req_Date)+ hrRequestItemList[position].getReqDate();
                break;
            }
            case "LA":{
                result+=" " + mContext.getString(R.string.label_from) +": " + hrRequestItemList[position].getStartDate() + mContext.getString(R.string.label_To)+" : "
                        + hrRequestItemList[position].getEndDate() + System.getProperty ("line.separator") ;

                if (hrRequestItemList[position].getRemarks().length()>0)
                    result+=mContext.getString(R.string.label_Desc)+ hrRequestItemList[position].getRemarks();

                result+=mContext.getString(R.string.label_Status)+ hrRequestItemList[position].getStatusDesc()+ System.getProperty ("line.separator")+
                        mContext.getString(R.string.label_Req_Date)+ hrRequestItemList[position].getReqDate();

                break;
            }
        }
        title.setText(result);
        if (hrRequestItemList[position].getSoaStatus().equals( mContext.getString(R.string.soa_accepted))) {
            title.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.accept_icon, 0, 0, 0);
        }
        else if ( (hrRequestItemList[position].getSoaStatus().equals(mContext.getString(R.string.soa_mng_rejected))
                ||  (hrRequestItemList[position].getSoaStatus().equals(mContext.getString(R.string.soa_hr_rejected))) ) )
        {
            title.setCompoundDrawablesWithIntrinsicBounds(
                    R.drawable.reject_icon, 0, 0, 0);
        }

        return rowView;
    }
}
