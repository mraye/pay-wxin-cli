package com.github.vspro.pay.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.dom4j.*;

import java.lang.reflect.Field;
import java.util.*;

public class WxXmlUtil {

    private static final String ROOT = "xml";

    private WxXmlUtil(){

    }

    /**
     * 将bean转成xml
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toXml(T t) {
        XStream xStream = XstreamFactory.createXStream();
        xStream.processAnnotations(t.getClass());
        xStream.alias(ROOT, t.getClass());
        //to resolve xstream security framework of xstream not initialized xstream is probably vulnerable
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypesByWildcard(new String[] {
                "com.github.vspro.pay.request.**",
                "com.github.vspro.pay.response.**"
        });
        return xStream.toXML(t);
    }


    /**
     * 将xml解析成bean
     * @param xml
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T toBean(String xml, Class<T> clz) {
        XStream xStream = XstreamFactory.createXStream();
        xStream.ignoreUnknownElements();  //忽略xml中有的元素，而bean中没有的属性
        xStream.processAnnotations(clz);
        xStream.alias(ROOT, clz);
        //to resolve xstream security framework of xstream not initialized xstream is probably vulnerable
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypesByWildcard(new String[] {
                "com.github.vspro.pay.request.**",
                "com.github.vspro.pay.response.**"
        });
        return (T) xStream.fromXML(xml);
    }


    public static Map<String, Object> toMap(String xml) throws DocumentException {

        Document document = DocumentHelper.parseText(xml);
        if (null == document){
            return Collections.EMPTY_MAP;
        }

        Element root = document.getRootElement();
        return (Map<String, Object>) parseMap(root);

    }

    /*
        <xml>                      {
            <a>a</a>               	a: a,
            <b>b</b>               	b:b,
            <c>                    	c:[{
                <d>d</d>           			d:d,
                <e>e</e>           			e:e
            </c>            ===>   		},
            <c>                    		{
                <g>g</g>           			g:g,
                <h>h</h>           			h:h
            </c>                   		}]
        </xml>                     	}

    */


    /**
     * xml 转成 map [解析结果通知]
     * @param elem
     * @return
     */
    private static Object parseMap(Element elem) {

        Map<String, Object> map = new HashMap<>();
        List<Element> elements = elem.elements();

        if (0 == elements.size()){

            // the whole xml just has one root node
            map.put(elem.getName(), elem.getTextTrim());

            // property like a:a
            if (!elem.isRootElement()){
                return elem.getTextTrim();
            }
        }else if (1 == elements.size()){
            //a object like a: {...}
            map.put(elem.getName(), parseMap(elements.get(0)));

        }else  {

            Map<String, Element> leafs = new HashMap<>();
            for (Element e: elements){
                leafs.put(e.getName(), e);
            }

            Set<String> keys = leafs.keySet();
            for (String key: keys){

                Namespace namespace = leafs.get(key).getNamespace();
                List<Element> sameLeafs = elem.elements(new QName(key, namespace));

                if (sameLeafs.size() > 1){
                    // array
                    List<Object> array = new ArrayList<>();
                    for (Element el: sameLeafs){
                        array.add(parseMap(el));
                    }
                    map.put(key, array);

                }else {
                    // object or property
                    map.put(key, parseMap(sameLeafs.get(0)));
                }
            }
        }

        return map;
    }


    /**
     * 将Bean中的属性【基本类型】转成以 map 形式
     * @param t
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    public static <T> Map<String, Object> getParams(T t) throws IllegalAccessException {

        Map<String, Object> map = new TreeMap<>();
        Class<?> clz = t.getClass();
        List<Field> fields = new ArrayList<>();

        //获取父类
        while (null != clz) {
            fields.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }

        for (Field field : fields) {

            //设置私有属性可以访问
            field.setAccessible(true);

            //查找field上的xstream alia
            if (field.isSynthetic() || field.isEnumConstant()) {
                continue;
            }

            String filedName = "";
            XStreamAlias alia = field.getAnnotation(XStreamAlias.class);
            if (null != alia) {
                filedName = alia.value();
            } else {
                filedName = field.getName();
            }

            Object value = field.get(t);
            if (null != value) {
                if (value instanceof String) {
                    String va = (String) value;
                    if (null != va && !"".equals(va)) {
                        map.put(filedName, va);
                    }
                } else {
                    map.put(filedName, value);
                }
            }
        }
        return map;
    }

}
