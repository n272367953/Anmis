package com.anmis.anmis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.anmis.anmis.activity.ClickEnentManager;
import com.anmis.anmis.util.Utils;

/**
 * Created by niushuowen on 2016/4/28.
 */
public class MyRecyclerViewAdaptes extends RecyclerView.Adapter {

    private Context context;
    private String[]datas;


    public MyRecyclerViewAdaptes(Context context,String[]datas){
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button button = new Button(context);
        RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(Utils.getScreenWidth(context)/3,Utils.getScreenWidth(context)/3);
        button.setLayoutParams(params);
        RecyclerView.ViewHolder viewHolder = new ViewHoler(button);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((Button)holder.itemView).setText(datas[position]);
        ((Button)holder.itemView).setAllCaps(false);
        ClickEnentManager.registerButton((Button)holder.itemView,position);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class ViewHoler extends RecyclerView.ViewHolder {
        public ViewHoler(View itemView) {
            super(itemView);
        }
    }
}
