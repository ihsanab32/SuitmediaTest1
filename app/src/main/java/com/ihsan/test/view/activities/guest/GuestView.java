package com.ihsan.test.view.activities.guest;

import com.ihsan.test.model.response.GuestResponse;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 09/05/2020.
 * ------------------------------
 * This class for
 */
public interface GuestView {
    void showLoading(String message);

    void dismissLoading();

    void getDataSuccess(GuestResponse model);

    void getDataFailed(String message);
}
