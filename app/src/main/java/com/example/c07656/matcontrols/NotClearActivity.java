package com.example.c07656.matcontrols;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class NotClearActivity extends Activity {

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notclear);
        Log.d("NewClearFormActivity", "Init NewClear Activity!!");

        mListView = (ListView) findViewById(R.id.listNewClear);
        mAdapter = new ListViewAdapter(NotClearActivity.this);
        mListView.setAdapter(mAdapter);

        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-06", "2016-03-11", "2016-03-16");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-02", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-02-07", "2016-02-11", "2016-02-25");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-02-16", "2016-02-20", "2016-03-01");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-02", "2016-03-05", "2016-03-05");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");
        mAdapter.addItem(getResources().getDrawable(R.drawable.asv), "2016-03-03", "2016-03-10", "2016-03-12");

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListData mData = (ListData) mAdapter.getItem(position);
                Toast.makeText(NotClearActivity.this, "Issue : " + mData.mIssuerDate + " / Plan" + mData.mPlanDate + " / Clearance : " + mData.mClearaceDate, Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                int countList = mAdapter.getCount();
                Toast.makeText(NotClearActivity.this, "Count of List : " + countList, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
