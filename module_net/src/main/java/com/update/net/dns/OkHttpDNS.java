package com.update.net.dns;

import android.text.TextUtils;

import com.alibaba.sdk.android.httpdns.HttpDns;
import com.alibaba.sdk.android.httpdns.HttpDnsService;
import com.update.base.GlobalContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import okhttp3.Dns;

/**
 * @author : liupu
 * date    : 2019/12/26
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class OkHttpDNS implements Dns {
    private HttpDnsService httpDnsService;

    private OkHttpDNS() {
        httpDnsService = HttpDns.getService(GlobalContext.getApp(), "");
    }

    public static OkHttpDNS getDns() {
        return Holder.INSTANCE;
    }

    @Override
    public List<InetAddress> lookup(String hostname) throws UnknownHostException {
        // HttpDns 获取解析到的ip
        String ip = httpDnsService.getIpByHostAsync(hostname);
        if (!TextUtils.isEmpty(ip)) {
            List<InetAddress> inetAddresses = Arrays.asList(InetAddress.getAllByName(ip));
            return inetAddresses;
        }
        // 如果通过 HttpDns 解析到的是空值, 则使用系统的 dns服务
        return Dns.SYSTEM.lookup(hostname);
    }

    private static final class Holder {
        private static final OkHttpDNS INSTANCE = new OkHttpDNS();
    }
}
