package com.loosu.adapters.base_adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;


import com.loosu.adapters.IViewHolder;

import androidx.annotation.NonNull;

/**
 * 万能适配器
 */
public class BaseAdapterViewHolder extends AbsBaseAdapter.ViewHolder implements IViewHolder {

    private SparseArray<View> views = new SparseArray<>();

    public BaseAdapterViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public <T extends View> T findViewById(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        //noinspection unchecked
        return (T) view;
    }

    public BaseAdapterViewHolder setText(int viewId, CharSequence text) {
        View view = findViewById(viewId);
        ((TextView) view).setText(text);
        return this;
    }
}
