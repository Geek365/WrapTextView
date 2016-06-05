package com.baoyachi.wraptextview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baoyachi.wraptextview.adapter.OrderRemarkAdapter;
import com.baoyachi.wraptextview.bean.OrderRemarkBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_text);
        setAdapter();

    }

    /**
     * setadapter
     */
    private void setAdapter()
    {
        List<OrderRemarkBean> list = new ArrayList<>();

        list.add(new OrderRemarkBean("订号：", "23123131"));
        list.add(new OrderRemarkBean("客类型：", "23123131"));
        list.add(new OrderRemarkBean("企业信息名称：", "23123131"));
        list.add(new OrderRemarkBean("开始的时间：", "23123131"));
        list.add(new OrderRemarkBean("结束时间：", "23123131"));
        list.add(new OrderRemarkBean("技师数：", "23123131"));
        list.add(new OrderRemarkBean("我的身份：", "23123131"));


        OrderRemarkAdapter orderRemarkAdapter = new OrderRemarkAdapter();
        orderRemarkAdapter.setData(list);

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(orderRemarkAdapter);
    }
}
