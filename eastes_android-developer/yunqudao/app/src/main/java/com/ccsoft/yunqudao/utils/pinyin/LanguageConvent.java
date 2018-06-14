package com.ccsoft.yunqudao.utils.pinyin;

import java.util.ArrayList;

/**
 * @author: YangFan
 * @data: 2017/12/11
 */

public class LanguageConvent {


    /**
     * 获取名字对应的首字母字符串
     * 规则：
     * 当名称为中文开头时，返回名称第一个汉字的拼音的首字母的大写
     * 当名称为英文开头时，返回第一次英文字母的大写
     * 当名称为数字开头或者是其他特殊符号时，返回字符串“其他”
     */
    public static String getFirstChar(String name) {
        String str = "";
        if (name != null && name.length() > 0) {
            str = LanguageConvent.getPinYin(name) + "";
        }
        return str;
    }

    /**
     * 返回中文拼音及英文大写，
     *
     * @return
     */
    public static String getPinYin(String input) {
        ArrayList<HanziToPinyin.Token> tokens = HanziToPinyin.getInstance().get(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0) {
            for (HanziToPinyin.Token token : tokens) {
                if (HanziToPinyin.Token.PINYIN == token.type) {
                    sb.append(token.target.substring(0,1));
                }
                else {
                    sb.append(token.source);
                }
            }
        }
        else {
            //如果获取不到实例，则返回一个特殊字符
            sb.append("%");
        }
        return sb.toString().toUpperCase();
    }
}
