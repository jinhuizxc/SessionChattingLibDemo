package com.hero.zhaoq.emotionboardlib.entity;

import android.view.View;
import android.view.ViewGroup;

import com.hero.zhaoq.emotionboardlib.widget.EmotionItemPageView;

import java.util.List;

/**
 * author: zhaoqiang
 * date:2017/11/21 / 14:42
 * zhaoqiang:zhaoq_hero@163.com
 */
public class EmoticonPageBean<T> extends PageEntity<EmoticonPageBean> {

    public enum DelBtnStatus {
        // 0,1,2
        GONE, FOLLOW, LAST;

        public boolean isShow() {
            return ! GONE.toString().equals(this.toString());
        }
    }

    /**
     * 表情数据源
     */
    private List<T> mEmoticonList;
    /**
     * 每页行数
     */
    private int mLine;
    /**
     * 每页列数
     */
    private int mRow;
    /**
     * 删除按钮
     */
    private DelBtnStatus mDelBtnStatus;

    public List<T> getEmoticonList() {
        return mEmoticonList;
    }

    public void setEmoticonList(List<T> emoticonList) {
        this.mEmoticonList = emoticonList;
    }

    public int getLine() {
        return mLine;
    }

    public void setLine(int line) {
        this.mLine = line;
    }

    public int getRow() {
        return mRow;
    }

    public void setRow(int row) {
        this.mRow = row;
    }

    public DelBtnStatus getDelBtnStatus() {
        return mDelBtnStatus;
    }

    public void setDelBtnStatus(DelBtnStatus delBtnStatus) {
        this.mDelBtnStatus = delBtnStatus;
    }

    public EmoticonPageBean() { }

    @Override
    public View instantiateItem(final ViewGroup container, int position, EmoticonPageBean pageEntity) {
        if(mPageViewInstantiateListener != null){
            return mPageViewInstantiateListener.instantiateItem(container, position, this);
        }
        if (getRootView() == null) {
            EmotionItemPageView pageView = new EmotionItemPageView(container.getContext());
            pageView.setNumColumns(mRow);
            setRootView(pageView);
        }
        return getRootView();
    }
}

