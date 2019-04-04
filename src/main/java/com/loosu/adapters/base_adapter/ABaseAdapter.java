package com.loosu.adapters.base_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public abstract class ABaseAdapter<T> extends AbsBaseAdapter<BaseAdapterViewHolder> {
    private List<T> mDatas = null;

    public ABaseAdapter(List<T> datas) {
        if (datas == null) {
            mDatas = new ArrayList<>(0);
        } else {
            mDatas = datas;
        }
    }

    protected abstract int getItemLayoutId(int viewType);

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public BaseAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(getItemLayoutId(viewType), parent, false);
        return new BaseAdapterViewHolder(itemView);
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }
}
