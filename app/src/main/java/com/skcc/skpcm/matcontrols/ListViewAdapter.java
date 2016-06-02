package com.skcc.skpcm.matcontrols;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by C07656 on 2016-03-17.
 */
public class ListViewAdapter extends BaseAdapter{
    private Context mContext = null;
    private ArrayList<ListData> mListData = new ArrayList<ListData>();

    private class ViewHolder {
        public ImageView aIcon;
        public TextView aIssuerDate;
        public TextView aPlanDate;
        public TextView aClearanceDate;
    }

    public ListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            holder=  new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.items_notclear, null);

            holder.aIcon = (ImageView) convertView.findViewById(R.id.imageItems);
            holder.aIssuerDate = (TextView) convertView.findViewById(R.id.textIssuerDate);
            holder.aPlanDate = (TextView) convertView.findViewById(R.id.textPlanDate);
            holder.aClearanceDate = (TextView) convertView.findViewById(R.id.textClearanceDate);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListData mData = mListData.get(position);

        if (mData.mIcon != null) {
            holder.aIcon.setImageDrawable(mData.getmIcon());
        }

        holder.aIssuerDate.setText(mData.getmIssuerDate());
        holder.aPlanDate.setText(mData.getmPlanDate());
        holder.aClearanceDate.setText(mData.getmClearaceDate());

        return convertView;
    }

    public void addItem(Drawable icon, String issuerdate, String plandate,  String clearancedate) {
        ListData addInfo = null;
        addInfo = new ListData();

        addInfo.mIcon = icon;
        addInfo.mIssuerDate = issuerdate;
        addInfo.mPlanDate = plandate;
        addInfo.mClearaceDate = clearancedate;

        mListData.add(addInfo);
    }

    public void dataChange() {
        this.notifyDataSetChanged();
    }
}
