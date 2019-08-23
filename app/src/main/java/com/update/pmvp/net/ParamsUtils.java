package com.update.pmvp.net;

import com.update.net.helper.ICommonHeadersHelper;
import com.update.net.helper.ICommonParamsHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : liupu
 * date    : 2019/8/23
 * desc    :
 */
public class ParamsUtils implements ICommonHeadersHelper, ICommonParamsHelper {
    @Override
    public Map<String, String> getCommonHeaders() {
        Map<String, String> map = new HashMap<>();
        map.put("token","heheewhhw");
        map.put("channel","google");
        return map;
    }

    @Override
    public Map<String, Object> getCommonParams() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","hello");
        return map;
    }
}
