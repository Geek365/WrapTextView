package com.baoyachi.wraptextview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baoyachi.wraptextview.R;
import com.baoyachi.wraptextview.bean.OrderRemarkBean;
import com.baoyachi.wraptextview.widget.WrapTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 日期：16/6/5 21:28
 * <p/>
 * 描述：
 */
public class OrderRemarkAdapter extends RecyclerView.Adapter<OrderRemarkAdapter.OrderRemarkViewHolder>
{
    private Context mContext;

    private String longestTitle;
    private List<OrderRemarkBean> mList;
    private int mWidth;

    public OrderRemarkAdapter()
    {
        mList = new ArrayList<>();
    }

    public void setData(List<OrderRemarkBean> list)
    {
        this.mList = list;
        int j = 0;
        for(int i = 0; i < mList.size(); i++)
        {
            int fstart = mList.get(j).getTitle().toString().length();
            int secondStart = mList.get(i).getTitle().toString().length();
            if(fstart < secondStart)
            {
                j = i;
            }
        }
        longestTitle = mList.get(j).getTitle().toString();


        notifyDataSetChanged();
    }


    @Override
    public OrderRemarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        mContext = parent.getContext();
        return new OrderRemarkViewHolder(View.inflate(parent.getContext(), R.layout.item_text_view, null));
    }

    @Override
    public void onBindViewHolder(OrderRemarkViewHolder holder, int position)
    {


        OrderRemarkBean orderRemarkBean = mList.get(position);
        //        TextView textView = new TextView(mContext);
        WrapTextView tv_front = new WrapTextView(mContext);
        tv_front.setTextColor(Color.BLACK);
        tv_front.setText(longestTitle);
        tv_front.setGravity(Gravity.CENTER);
        tv_front.setTextSize(16);
        //监听textview尺寸改变

        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        tv_front.measure(spec, spec);

        // getMeasuredWidth
        int measuredWidth = tv_front.getMeasuredWidth();
        int measuredHeight = tv_front.getMeasuredHeight();

        // new textpaint measureText
        TextPaint newPaint = new TextPaint();
        float textSize = mContext.getResources().getDisplayMetrics().scaledDensity * 15;
        newPaint.setTextSize(textSize);
        float newPaintWidth = newPaint.measureText(longestTitle);

        // textView getPaint measureText
        TextPaint textPaint = tv_front.getPaint();
        float textPaintWidth = textPaint.measureText(longestTitle);

        holder.rlTitle.getHeight();

        RelativeLayout.LayoutParams Params1 = new RelativeLayout.LayoutParams((int) textPaintWidth, measuredHeight);
        holder.rlTitle.setLayoutParams(Params1);

        holder.tvTitle.setText(orderRemarkBean.getTitle());
        holder.detailMessage.setText(orderRemarkBean.getDetailMessage());
    }

    @Override
    public int getItemCount()
    {
        return mList.size();
    }

    class OrderRemarkViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle;
        TextView detailMessage;
        RelativeLayout rlTitle;

        public OrderRemarkViewHolder(View itemView)
        {
            super(itemView);
            rlTitle = (RelativeLayout) itemView.findViewById(R.id.rl_title);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            detailMessage = (TextView) itemView.findViewById(R.id.tv_detail_message);
        }
    }
}
