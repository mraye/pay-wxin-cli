package com.github.vspro.pay.util;

import com.github.vspro.pay.client.WxRequestHolder;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class WxSignatureUtil {


    private WxSignatureUtil() {

    }

    public static Map<String, Object> getSortedMap(WxRequestHolder holder) throws IllegalAccessException {
        Map<String, Object> map = new TreeMap<>();
        Map<String, Object> param = WxXmlUtil.getParams(holder.getRequest());
        map.putAll(param);
        if (!holder.getAdditional().isEmpty()) {
            map.putAll(holder.getAdditional());
        }
        return map;
    }

    public static String getSignContent(WxRequestHolder holder, String key) throws IllegalAccessException {
        return getSignContentWithKey(getSortedMap(holder), key);
    }

    public static StringBuffer getSignContent(Map<String, Object> map) {

        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = map.get(key);
            if (null != value) {
                if (value instanceof String) {
                    String v = (String) value;
                    if (StringUtils.isEmpty(v)) {
                        continue;
                    }
                }
                content.append((i == 0) ? "" : "&").append(key).append("=").append(value);
            }
        }
        return content;
    }

    public static String getSignContentWithKey(Map<String, Object> map, String key) {
        return getSignContent(map).append("&key=").append(key).toString();
    }



    public static String sign(String content, String type) {
        if (type.equals("MD5")) {
            return HashKit.md5(content).toUpperCase();
        } else {
            return HashKit.sha1(content).toUpperCase();
        }
    }

    public static String sign(TreeMap<String, Object> map, String key, String type) {
        StringBuffer content = getSignContent(map).append("&key=").append(key);
        return sign(content.toString(), type);
    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("appid", "wer");
        map.put("mch_id", "2342");
        map.put("device_info", "gfh");
        map.put("body", "56yt");
        System.out.println(WxSignatureUtil.getSignContent(map));
    }

}
