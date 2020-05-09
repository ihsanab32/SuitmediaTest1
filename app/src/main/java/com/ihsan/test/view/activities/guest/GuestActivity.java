package com.ihsan.test.view.activities.guest;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ihsan.test.R;
import com.ihsan.test.adapter.GuestAdapter;
import com.ihsan.test.model.GuestItem;
import com.ihsan.test.model.response.GuestResponse;
import com.ihsan.test.view.base.mvp.MvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GuestActivity extends MvpActivity<GuestPresenter> implements GuestView {

    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.rv_guest)
    RecyclerView rvGuest;
    List<GuestItem> guestItemList = new ArrayList<>();
    GuestAdapter guestAdapter;

    @Override
    protected GuestPresenter createPresenter() {
        return new GuestPresenter(this);
    }

    @Override
    protected int getActivityView() {
        return R.layout.activity_guest;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public void showLoading(String message) {
        showProgressDialog(message);
    }

    @Override
    public void dismissLoading() {
        dismissProgressDialog();
    }

    @Override
    public void getDataSuccess(GuestResponse model) {
        guestItemList = model.getData();
        guestAdapter.refresh(guestItemList);
        Log.d("Event Activity", String.valueOf(model.getData()));
    }

    @Override
    public void getDataFailed(String message) {
        Log.d("Event Activity", message);
    }

    @OnClick({R.id.iv_back, R.id.iv_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_next:
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        txtTitle.setText("GUESTS");
        presenter.getListGuest();
        guestAdapter = new GuestAdapter(this, this, guestItemList);
        rvGuest.setHasFixedSize(true);
        rvGuest.setLayoutManager(new GridLayoutManager(this, 2));
        rvGuest.setAdapter(guestAdapter);
    }
}
