package com.example.c07656.matcontrols;

import android.graphics.drawable.Drawable;

import java.text.Collator;
import java.util.Comparator;

/**
 * Created by C07656 on 2016-03-17.
 */
public class ListData {

    public Drawable mIcon;

    public String mIssuerDate;
    public String mPlanDate;
    public String mClearaceDate;

    public Drawable getmIcon() {
        return mIcon;
    }

    public void setmIcon(Drawable mIcon) {
        this.mIcon = mIcon;
    }

    public String getmIssuerDate() {
        return mIssuerDate;
    }

    public void setmIssuerDate(String mIssuerDate) {
        this.mIssuerDate = mIssuerDate;
    }

    public String getmPlanDate() {
        return mPlanDate;
    }

    public void setmPlanDate(String mPlanDate) {
        this.mPlanDate = mPlanDate;
    }

    public String getmClearaceDate() {
        return mClearaceDate;
    }

    public void setmClearaceDate(String mClearaceDate) {
        this.mClearaceDate = mClearaceDate;
    }

    /*public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        private final Collator sCollator = Collator.getInstance();
        @Override
        public int compare(ListData lhs, ListData rhs) {
            return 0;
        }
    };*/
}
