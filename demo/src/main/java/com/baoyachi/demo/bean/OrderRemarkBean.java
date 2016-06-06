package com.baoyachi.demo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 日期：16/6/5 21:31
 * <p/>
 * 描述：
 */
public class OrderRemarkBean implements Parcelable
{
    private String title;
    private String detailMessage;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDetailMessage()
    {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage)
    {
        this.detailMessage = detailMessage;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.title);
        dest.writeString(this.detailMessage);
    }

    public OrderRemarkBean()
    {
    }

    public OrderRemarkBean(String title, String detailMessage)
    {
        this.title = title;
        this.detailMessage = detailMessage;
    }

    protected OrderRemarkBean(Parcel in)
    {
        this.title = in.readString();
        this.detailMessage = in.readString();
    }

    public static final Parcelable.Creator<OrderRemarkBean> CREATOR = new Parcelable.Creator<OrderRemarkBean>()
    {
        @Override
        public OrderRemarkBean createFromParcel(Parcel source)
        {
            return new OrderRemarkBean(source);
        }

        @Override
        public OrderRemarkBean[] newArray(int size)
        {
            return new OrderRemarkBean[size];
        }
    };
}
