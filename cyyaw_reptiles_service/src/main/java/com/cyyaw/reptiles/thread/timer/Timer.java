package com.cyyaw.reptiles.thread.timer;

import java.util.List;

/**
 * 计时器用于统计调用次数
 */
public interface Timer<T> {


    /**
     * 计数，调用一次则计数一次
     */
    void count();

    /**
     * 获得计时数据
     */
    List<T> getDate();

}
