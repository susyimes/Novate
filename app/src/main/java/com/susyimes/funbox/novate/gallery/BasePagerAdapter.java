package com.susyimes.funbox.novate.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by susyimes on 2018/11/23.
 */
public abstract class BasePagerAdapter<T> extends PagerAdapter {
    /**
     * 已经销毁的Item，存起来复用
     */
    private final List<PagerHolder<T>> mRecyclerList = new LinkedList<>();
    /**
     * 正在使用的Item， 存起来以便可以定点刷新
     */
    private final List<PagerHolder<T>> mUsedList = new LinkedList<>();

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((PagerHolder) object).itemView;
    }

    @Override
    public int getItemPosition(Object object) {
        //1、如果列表为空，直接返回POSITION_NONE， 防止移除时不能刷新
        //2、如果下标越界，直接返回POSITION_NONE
        //3、根据子类isViewHolderChanged返回值 决定是否返回POSITION_NONE
        //如果返回POSITION_NONE 将会重新instantiateItem
        if (getCount() == 0 || ((PagerHolder) object).getItemPosition() >= getCount() || isViewHolderChanged(
                (PagerHolder<T>) object)) {
            return POSITION_NONE;
        }
        return POSITION_UNCHANGED;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        PagerHolder<T> holder;
        if (!mRecyclerList.isEmpty()) {//是否有可复用的item
            holder = mRecyclerList.remove(0);
        } else {//新建item
            holder = onCreateViewHolder(container.getContext(), position);
        }
        holder.position = position;
        //绑定item数据
        onBindViewHolder(container.getContext(), holder);
        container.addView(holder.itemView);
        mUsedList.add(holder);
        return holder;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        PagerHolder<T> holder = (PagerHolder<T>) object;
        container.removeView(holder.itemView);
        mUsedList.remove(holder);
        mRecyclerList.add(holder);
    }

    public List<PagerHolder<T>> getUsedHolders() {
        return mUsedList;
    }

    public abstract PagerHolder<T> onCreateViewHolder(Context context, int position);

    public abstract void onBindViewHolder(Context context, PagerHolder<T> holder);

    public abstract boolean isViewHolderChanged(PagerHolder<T> holder);

    /**
     * 参照RecyclerView的机制定义了一个缓存类
     */
    public static class PagerHolder<T> {
        public View itemView;
        private int position;
        private T mData;

        public PagerHolder(View view) {
            this.itemView = view;
        }

        public int getItemPosition() {
            return position;
        }

        public T getData() {return  mData;}

        public void setData(T data) {
            mData = data;
        }
    }

}
