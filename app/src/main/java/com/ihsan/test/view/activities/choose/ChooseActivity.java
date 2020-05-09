package com.ihsan.test.view.activities.choose;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ihsan.test.R;
import com.ihsan.test.utils.Constants;
import com.ihsan.test.view.activities.event.EventActivity;
import com.ihsan.test.view.activities.guest.GuestActivity;
import com.ihsan.test.view.base.mvp.MvpActivity;
import com.ihsan.test.view.base.ui.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class ChooseActivity extends MvpActivity<BasePresenter> {

    @BindView(R.id.txt_halaman)
    TextView txtName;
    @BindView(R.id.btn_event)
    Button btnEvent;
    @BindView(R.id.btn_guest)
    Button btnGuest;
    String event, guest, jenis;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getActivityView() {
        return R.layout.activity_choose;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @OnClick({R.id.btn_event, R.id.btn_guest})
    public void onClick(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.btn_event:
                i = new Intent(this, EventActivity.class);
                startActivityForResult(i, Constants.STATIC_INTEGER_VALUE);
                break;
            case R.id.btn_guest:
                i = new Intent(this, GuestActivity.class);
                startActivityForResult(i, Constants.STATIC_INTEGER_VALUE);
                break;
        }
    }

    private void initView(){
        txtName.setText(getBundle().getString("nama"));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.STATIC_INTEGER_VALUE) {
            if (resultCode == Activity.RESULT_OK) {
                jenis = data.getStringExtra(Constants.KEY_JENIS);
                if (jenis.equals(Constants.KEY_JENIS_EVENT)) {
                    btnEvent.setText(data.getStringExtra(Constants.KEY_HASIL));
                } else {
                    btnGuest.setText(data.getStringExtra(Constants.KEY_HASIL));
                }
            }
        }
    }
}
