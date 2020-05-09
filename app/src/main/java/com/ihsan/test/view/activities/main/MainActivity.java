package com.ihsan.test.view.activities.main;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ihsan.test.R;
import com.ihsan.test.view.activities.choose.ChooseActivity;
import com.ihsan.test.view.base.mvp.MvpActivity;
import com.ihsan.test.view.base.ui.BasePresenter;
import com.libizo.CustomEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<BasePresenter> {

    @BindView(R.id.et_name)
    CustomEditText etName;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getActivityView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        if (etName.getText().toString().equals("")) {
            etName.setError(getResources().getString(R.string.error_null));
        } else {
            Intent intent = new Intent(getApplicationContext(), ChooseActivity.class);
            intent.putExtra("nama", etName.getText().toString());
            startActivity(intent);
        }
    }
}
