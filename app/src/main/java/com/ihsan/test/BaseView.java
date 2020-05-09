package com.ihsan.test;

import androidx.annotation.StringRes;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 09/05/2020.
 * ------------------------------
 * This class for
 */
public interface BaseView {
    void showProgressDialog(String message);

    void showProgressDialog(@StringRes int message);

    void dismissProgressDialog();

    void showMessage(String message);

    void showMassage(@StringRes int message);
}
