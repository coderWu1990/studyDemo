package com.wd.java.basic.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wudi
 * @desc
 * @time 2023-02-20 19:12
 */
public class GetApiTest {
    public <T extends BaseAPI> T getApi(Class<T> a){
        return null;
    }

    public static void main(String[] args) {
        GetApiTest test=new GetApiTest();
        BtAPI api=test.getApi(BtAPI.class);
        List<? extends BaseAPI> list=new ArrayList<>();
//        list.add(new BaseAPI());//error
        BaseAPI baseAPI=list.get(0);
    }
}
