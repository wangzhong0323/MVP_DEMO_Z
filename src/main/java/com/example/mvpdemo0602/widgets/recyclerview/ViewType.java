package com.example.mvpdemo0602.widgets.recyclerview;

/**
 * ViewType
 *
 * @author xl
 * @since 2017-08-05
 */
public interface ViewType {
    Class<? extends AbsViewHolder<?>> getViewType();
}
