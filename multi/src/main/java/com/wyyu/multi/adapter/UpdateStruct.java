package com.wyyu.multi.adapter;

/**
 * Created by wyyu on 2020-05-07.
 **/

public class UpdateStruct {

    // 更新类型
    public int updateType;
    // 本次更新附带的参数
    public Object[] params;

    public UpdateStruct(int updateType, Object... params) {
        this.updateType = updateType;
        this.params = params;
    }
}
