package com.update.pmvp.net;

import com.update.net.helper.ICHeadersHelper;
import com.update.net.helper.ICParamsHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liupu
 * date    : 2019/8/23
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class ParamsUtils implements ICHeadersHelper, ICParamsHelper {
    @Override
    public Map<String, String> getCommonHeaders() {
        Map<String, String> map = new HashMap<>();
//        map.put("token", "heheewhhw");
//        map.put("channel", "google");
        return map;
    }

    @Override
    public Map<String, Object> getCommonParams() {
        Map<String, Object> map = new HashMap<>();
//        map.put("name", "hello");
        return map;
    }
}
