package com.loosu.adapters;

import android.view.View;

public interface IViewHolder {
    public <T extends View> T findViewById(int viewId);
}
