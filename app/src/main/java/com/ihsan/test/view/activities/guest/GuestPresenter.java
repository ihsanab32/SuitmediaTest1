package com.ihsan.test.view.activities.guest;

import com.ihsan.test.BuildConfig;
import com.ihsan.test.model.response.GuestResponse;
import com.ihsan.test.utils.api.NetworkCallback;
import com.ihsan.test.view.base.ui.BasePresenter;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 09/05/2020.
 * ------------------------------
 * This class for
 */
public class GuestPresenter  extends BasePresenter<GuestView> {

    GuestPresenter(GuestView view) {
        super.attachView(view);
    }

    void getListGuest() {
        view.showLoading("Please Wait....");
        addSubscribe(apiStores.getGuest(BuildConfig.API_KEY), new NetworkCallback<GuestResponse>() {
            @Override
            public void onSuccess(GuestResponse model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFailed(message);
            }

            @Override
            public void onFinish() {
                view.dismissLoading();
            }
        });

    }
}
