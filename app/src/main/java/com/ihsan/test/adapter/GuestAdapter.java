package com.ihsan.test.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ihsan.test.BuildConfig;
import com.ihsan.test.R;
import com.ihsan.test.model.GuestItem;
import com.ihsan.test.utils.Constants;
import com.ihsan.test.utils.ItemClickListener;
import com.ihsan.test.view.activities.choose.ChooseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 085749729115
 * Date     : 09/05/2020.
 * ------------------------------
 * This class for
 */
@SuppressLint({"InflateParams", "SetTextI18n", "SimpleDateFormat"})
public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {

    private Context context;
    private List<GuestItem> guestItems;
    private Activity activity;

    public GuestAdapter(Activity activity, Context context, List<GuestItem> guestItems) {
        this.activity = activity;
        this.context = context;
        this.guestItems = guestItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guest, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return guestItems.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final GuestAdapter.ViewHolder holder, int position) {
        final GuestItem guest = guestItems.get(position);
        holder.bindTo(guest);
        holder.setClickListener(view -> {
            Intent intent = new Intent(context, ChooseActivity.class);
            intent.putExtra(Constants.KEY_HASIL, guest.getName());
            intent.putExtra(Constants.KEY_JENIS, Constants.KEY_JENIS_GUEST);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            activity.setResult(Activity.RESULT_OK, intent);
            activity.finish();
        });
    }

    public void refresh(List<GuestItem> fill) {
        guestItems = new ArrayList<>();
        guestItems.addAll(fill);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemClickListener itemClickListener;
        @BindView(R.id.iv_guest)
        ImageView ivGuestItem;
        @BindView(R.id.txt_nama)
        TextView txtGuestName;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void setClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        void bindTo(GuestItem guest) {
            txtGuestName.setText(guest.getName());
            Glide.with(context)
                    .load(BuildConfig.IMAGE_URL + guest.getFoto())
                    .placeholder(R.drawable.ic_null)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(ivGuestItem);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v);
        }
    }
}
