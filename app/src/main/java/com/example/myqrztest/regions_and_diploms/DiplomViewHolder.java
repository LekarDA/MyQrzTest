package com.example.myqrztest.regions_and_diploms;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myqrztest.R;
import com.example.myqrztest.model.DiplomModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public  class DiplomViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private RatingBar rbRating;
        private TextView tvVeiwsCount;
        private TextView tvDate;

        public DiplomViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.item_diplom_tvName);
            rbRating = (RatingBar) itemView.findViewById(R.id.item_diplom_rbRating);
            tvVeiwsCount = (TextView) itemView.findViewById(R.id.item_diplom_tvViewsCount);
            tvDate = (TextView) itemView.findViewById(R.id.item_diplom_tvDate);
        }

        public void initView(DiplomModel diplom) {
            tvName
                    .setText(
                            diplom
                                    .getDiplomName());
            rbRating.setRating(new Random().nextFloat() * 5);
            tvVeiwsCount.setText(String.valueOf(new Random().nextInt(8000)));
            SimpleDateFormat dateFormat = new SimpleDateFormat("DD.MM.yyyy");
            tvDate.setText(dateFormat.format(new Date(System.currentTimeMillis())));
        }
    }