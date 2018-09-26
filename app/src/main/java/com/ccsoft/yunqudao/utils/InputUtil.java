package com.ccsoft.yunqudao.utils;

import android.text.TextUtils;
import com.ccsoft.yunqudao.data.AppConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入法工具类
 * @author: Pein
 * @data: 2018/5/22 0022
 */

public class InputUtil {

    /**
     * 判断是否是合法的账号（手机号或邮箱）
     *
     * @param account
     *
     * @return
     */
    public static boolean isAccountLegal(String account) {
        return !TextUtils.isEmpty(account) && account.matches(AppConstants.Validator.REGEX_ACCOUNT);
    }

    /**
     * 判断是否是合法的邮箱
     *
     * @param email
     *
     * @return
     */
    public static boolean isEmailLegal(String email) {
        return !TextUtils.isEmpty(email) && email.matches(AppConstants.Validator.REGEX_EMAIL);
    }

    /**
     * 判断是否是合法的手机号
     *
     * @param mobile
     *
     * @return
     */
    public static boolean isMobileLegal(String mobile) {
        return !TextUtils.isEmpty(mobile) && mobile.matches(AppConstants.Validator.REGEX_MOBILE);
    }

    /**
     * 判断是否是合法的昵称
     *
     * @param nickName
     *
     * @return
     */
    public static boolean isNickNameLegal(String nickName) {
        return !TextUtils.isEmpty(nickName) && nickName.matches(AppConstants.Validator.REGEX_NICKNAME);
    }

    /**
     * 判断是否是合法的汉字、字母、数字
     *
     * @param CharNumber
     *
     * @return
     */
    public static boolean isCharNumberLegal(String CharNumber) {
        return !TextUtils.isEmpty(CharNumber) && CharNumber.matches(AppConstants.Validator.REGEX_CHAR_NUMBER);
    }

    
    

    /**
     * 隐藏邮箱@前面的4位字符
     *
     * @param email
     *
     * @return
     */
    public static String hideEmailText(String email) {
        return email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
    }

    /**
     * 隐藏手机号中间的4位数字
     *
     * @param mobile
     *
     * @return
     */
    public static String hideMobileText(String mobile) {
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

   

    /**
     * 判断包含中文
     *
     * @param str
     *
     * @return
     */
    public static boolean isChineseChar(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        return temp;
    }

    /**
     * 是否包含字母
     *
     * @param str
     *
     * @return
     */
    public static boolean isLetter(String str) {
        boolean temp = false;
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            temp = true;
        }
        return temp;
    }

    /**
     * 判断是否含有特殊字符
     *
     * @param str
     *
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 判断是否是纯数字
     *
     * @param str
     *
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
    public static String convert(String str)
    {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++)
        {
            c = str.charAt(i);
            sb.append("\\u");
            j = (c >>>8); //取出高8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);
            j = (c & 0xFF); //取出低8位
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1)
                sb.append("0");
            sb.append(tmp);

        }
        return (new String(sb));
    }

    /**
     * 判断是否包含中文标点符号
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {

        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS

            || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS

            || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A

            || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION

            || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION

            || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {

            return true;

        }

        return false;

    }
    
}
