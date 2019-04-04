package com.loosu.adapters.base_adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


import java.util.Objects;

import androidx.annotation.NonNull;

/**
 * 主要处理{@link BaseAdapter#getView(int, View, ViewGroup)} 减少findView的次数, 封装模板代码。
 * <p>
 * 模仿 {@link androidx.recyclerview.widget.RecyclerView.Adapter} 增加
 * {@link AbsBaseAdapter#onCreateViewHolder(ViewGroup, int)}、
 * {@link AbsBaseAdapter#onBindViewHolder(VH, int)} 方法。
 *
 * @param <VH> ViewHolder
 */
public abstract class AbsBaseAdapter<VH extends AbsBaseAdapter.ViewHolder> extends BaseAdapter {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        VH holder = null;
        if (convertView == null) {
            holder = onCreateViewHolder(parent, getItemViewType(position));
            convertView = holder.itemView;
        } else {
            holder = (VH) convertView.getTag();
        }
        onBindViewHolder(holder, position);
        return convertView;
    }

    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(@NonNull VH holder, int position);

    /**
     * ViewHolder
     */
    public static class ViewHolder {
        @NonNull
        public final View itemView;

        public ViewHolder(@NonNull View itemView) {
            Objects.requireNonNull(itemView, "itemView in null!");
            this.itemView = itemView;
            this.itemView.setTag(this);
        }
    }
}
