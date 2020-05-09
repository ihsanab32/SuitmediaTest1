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
import com.ihsan.test.model.EventItem;
import com.ihsan.test.utils.Constants;
import com.ihsan.test.utils.ItemClickListener;
import com.ihsan.test.view.activities.choose.ChooseActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private List<EventItem> eventItems;
    private Activity activity;

    public EventAdapter(Activity activity, Context context, List<EventItem> eventItems) {
        this.activity = activity;
        this.context = context;
        this.eventItems = eventItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return eventItems.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final EventAdapter.ViewHolder holder, int position) {
        final EventItem event = eventItems.get(position);
        holder.bindTo(event);
        holder.setClickListener(view -> {
            Intent intent = new Intent(context, ChooseActivity.class);
            intent.putExtra(Constants.KEY_HASIL, event.getNama());
            intent.putExtra(Constants.KEY_JENIS, Constants.KEY_JENIS_EVENT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            activity.setResult(Activity.RESULT_OK, intent);
            activity.finish();
        });
    }

    public void refresh(List<EventItem> fill) {
        eventItems = new ArrayList<>();
        eventItems.addAll(fill);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ItemClickListener itemClickListener;
        @BindView(R.id.iv_coupon)
        ImageView ivEventItem;
        @BindView(R.id.txt_mall_name_coupon)
        TextView txtDateEvent;
        @BindView(R.id.txt_no_coupon)
        TextView txtNameEvent;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void setClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        void bindTo(EventItem event) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dateAwal = dateFormat.parse(event.getStartdate());
                Date dateAkhir = dateFormat.parse(event.getEnddate());
                SimpleDateFormat sdfnewformat = new SimpleDateFormat("dd-MMM-YYYY");
                txtDateEvent.setText(sdfnewformat.format(dateAwal) + " s.d " + sdfnewformat.format(dateAkhir));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            txtNameEvent.setText(event.getNama());
            Glide.with(context)
                    .load(BuildConfig.IMAGE_URL+event.getFoto())
                    .placeholder(R.drawable.ic_null)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(ivEventItem);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v);
        }
    }

}
