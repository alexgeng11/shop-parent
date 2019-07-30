package com.kaysen.shop.utils;

import org.apache.commons.lang.ArrayUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描叙：字符串工具类，用于实现一些字符串的常用操作
 * 创建人：HeGuifang
 * 创建时间：2016年5月23日 下午4:25:39
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
    public static final String NUMBERS_AND_LETTERS         = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS                     = "0123456789";
    public static final String LETTERS                     = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS             = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS          = "abcdefghijklmnopqrstuvwxyz";

    public static final String defaultKeyAndValueSeparator = ":";
    public static final String defaultValueEntitySeparator = ",";
    public static final String defaultKeyOrValueQuote      = "\"";
    
    public static final String MAPPER_SAVE="Mapper.save";//bean对应的xml文件后缀部分
    
    public static final String MAPPER_UPDATE="Mapper.update";//bean对应的xml文件后缀部分
    
    public static final String MAPPER_SAVE_OR_UPDATE="Mapper.saveOrUpdate";//bean对应的xml文件后缀部分
    
    /**
     * 根据bean的名称得到对应mybatis的执行方法
     * @param beanName
     * @param mapperType   MAPPER_SAVE  MAPPER_UPDATE  MAPPER_SAVE_OR_UPDATE
     * @return
     */
    public static String getMapperSave(String beanName,String mapperType){
    	return 	beanName.substring(2)+mapperType;
    }
    
    
    /**
     * 判断字符串是否为空或长度为0
     * 
     * @param str
     * @return 若字符串为null或长度为0, 返回true; 否则返回false.
     * 
     * <pre>
     *      isEmpty(null)   =   true;
     *      isEmpty("")     =   true;
     *      isEmpty("  ")   =   false;
     * </pre>
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * 判断字符串是否为空或长度为0，或仅由空格组成
     * 
     * @param str
     * @return 若字符串为null或长度为0或仅由空格组成, 返回true; 否则返回false.
     * 
     * <pre>
     *      isBlank(null)   =   true;
     *      isBlank("")     =   true;
     *      isBlank("  ")   =   true;
     *      isBlank("a")    =   false;
     *      isBlank("a ")   =   false;
     *      isBlank(" a")   =   false;
     *      isBlank("a b")  =   false;
     * </pre>
     */
    public static boolean isBlank(String str) {
        return (isEmpty(str) || (str.trim().length() == 0));
    }

    /**
     * 将字符串首字母大写后返回
     * 
     * @param str 原字符串
     * @return 首字母大写后的字符串
     * 
     * <pre>
     *      capitalizeFirstLetter(null)     =   null;
     *      capitalizeFirstLetter("")       =   "";
     *      capitalizeFirstLetter("1ab")    =   "1ab"
     *      capitalizeFirstLetter("a")      =   "A"
     *      capitalizeFirstLetter("ab")     =   "Ab"
     *      capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     */
    public static String capitalizeFirstLetter(String str) {
        return (isEmpty(str) || !Character.isLetter(str.charAt(0))) ? str : Character.toUpperCase(str.charAt(0))
                                                                            + str.substring(1);
    }

    /**
     * 如果不是普通字符，则按照utf8进行编码
     * 
     * @param str 原字符
     * @return 编码后字符，编码错误返回null
     * 
     * <pre>
     *      utf8Encode(null)        =   null
     *      utf8Encode("")          =   "";
     *      utf8Encode("aa")        =   "aa";
     *      utf8Encode("啊啊啊啊")   = "编码后字符";
     * </pre>
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return str;
    }

    /**
     * 如果不是普通字符，则按照utf8进行编码，编码异常则返回defultReturn
     * 
     * @param str 源字符串
     * @param defultReturn 默认出错返回
     * @return
     */
    public static String utf8Encode(String str, String defultReturn) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return defultReturn;
            }
        }
        return str;
    }

    /**
     * null字符串转换为长度为0的字符串
     * 
     * @param str 待转换字符串
     * @return
     * @see
     * <pre>
     *  nullStrToEmpty(null)    =   "";
     *  nullStrToEmpty("")      =   "";
     *  nullStrToEmpty("aa")    =   "";
     * </pre>
     */
    public static String nullStrToEmpty(String str) {
        return (str == null ? "" : str);
    }

    /**
     * 以固定格式得到当前时间的字符串
     * 
     * @param format 时间格式，同时间的format，如"yyyy-MM-dd HH:mm:ss"
     * @return 时间字符串，若format为空或长度为空或只包含空格，则默认为"yyyy-MM-dd HH:mm:ss"
     * 
     * <pre>
     *      currentDate(null)                   = "yyyy-MM-dd HH:mm:ss"
     *      currentDate("")                     = "yyyy-MM-dd HH:mm:ss"
     *      currentDate("   ")                  = "yyyy-MM-dd HH:mm:ss"
     *      currentDate("yyyy-MM-dd")           = "yyyy-MM-dd"
     *      currentDate("yyyy/MM/dd HH:mm:ss")  = "yyyy/MM/dd HH:mm:ss"
     * </pre>
     */
    public static String currentDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(isBlank(format) ? "yyyy-MM-dd HH:mm:ss" : format);
        return dateFormat.format(new Date());
    }

    /**
     * 以"yyyy-MM-dd HH:mm:ss"格式得到当前时间
     * 
     * @return "yyyy-MM-dd HH:mm:ss"
     */
    public static String currentDate() {
        return currentDate("");
    }

    /**
     * 以固定格式得到当前时间的字符串，包含毫秒
     * 
     * @param format 时间格式，同时间的format，如"yyyy-MM-dd HH:mm:ss SS"
     * @return 时间字符串，若format为空或长度为空或只包含空格，则默认为"yyyy-MM-dd HH:mm:ss SS"
     * 
     * <pre>
     *      currentDate(null)                   = "yyyy-MM-dd HH:mm:ss SS"
     *      currentDate("")                     = "yyyy-MM-dd HH:mm:ss SS"
     *      currentDate("   ")                  = "yyyy-MM-dd HH:mm:ss SS"
     *      currentDate("yyyy-MM-dd")           = "yyyy-MM-dd"
     *      currentDate("yyyy/MM/dd HH:mm:ss SS")  = "yyyy/MM/dd HH:mm:ss SS"
     * </pre>
     */
    public static String currentDateInMills(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(isBlank(format) ? "yyyy-MM-dd HH-mm-ss SS" : format);
        return dateFormat.format(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * 以"yyyy-MM-dd HH:mm:ss SS"格式得到当前时间
     * 
     * @return "yyyy-MM-dd HH:mm:ss SS"
     */
    public static String currentDateInMills() {
        return currentDateInMills("");
    }

    /**
     * 处理时间，用来显示状态更新时间
     * 
     * @param time
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String processTime(Long time) {
        long oneDay = 24 * 60 * 60 * 1000;
        Date now = new Date();
        Date orginalTime = new Date(time);
        long nowDay = now.getTime() - (now.getHours() * 3600 + now.getMinutes() * 60 + now.getSeconds()) * 1000;
        long yesterday = nowDay - oneDay;
        String nowHourAndMinute = toDoubleDigit(orginalTime.getHours()) + ":" + toDoubleDigit(orginalTime.getMinutes());
        if (time >= now.getTime()) {
            return "刚刚";
        } else if ((now.getTime() - time) < (60 * 1000)) {
            return (now.getTime() - time) / 1000 + "秒前 " + nowHourAndMinute + " ";
        } else if ((now.getTime() - time) < (60 * 60 * 1000)) {
            return (now.getTime() - time) / 1000 / 60 + "分钟前 " + nowHourAndMinute + " ";
        } else if ((now.getTime() - time) < (24 * 60 * 60 * 1000)) {
            return (now.getTime() - time) / 1000 / 60 / 60 + "小时前 " + nowHourAndMinute + " ";
        } else if (time >= nowDay) {
            return "今天 " + nowHourAndMinute;
        } else if (time >= yesterday) {
            return "昨天 " + nowHourAndMinute;
        } else {
            return toDoubleDigit(orginalTime.getMonth()) + "-" + toDoubleDigit(orginalTime.getDate()) + " "
                   + nowHourAndMinute + ":" + toDoubleDigit(orginalTime.getSeconds());
        }
    }

    /**
     * 将一位整数十位加0变成两位整数
     * 
     * @param number
     * @return
     */
    public static String toDoubleDigit(int number) {
        if (number >= 0 && number < 10) {
            return "0" + ((Integer)number).toString();
        }
        return ((Integer)number).toString();
    }

    /**
     * 得到href链接的innerHtml
     * 
     * @param href href内容
     * @return href的innerHtml
     *         <ul>
     *         <li>空字符串返回""</li>
     *         <li>若字符串不为空，且不符合链接正则的返回原内容</li>
     *         <li>若字符串不为空，且符合链接正则的返回最后一个innerHtml</li>
     *         </ul>
     * @see
     * <pre>
     *      getHrefInnerHtml(null)                                  = ""
     *      getHrefInnerHtml("")                                    = ""
     *      getHrefInnerHtml("mp3")                                 = "mp3";
     *      getHrefInnerHtml("&lt;a innerHtml&lt;/a&gt;")                    = "&lt;a innerHtml&lt;/a&gt;";
     *      getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     *      getHrefInnerHtml("&lt;a&lt;a&gt;innerHtml&lt;/a&gt;")                    = "innerHtml";
     *      getHrefInnerHtml("&lt;a href="baidu.com"&gt;innerHtml&lt;/a&gt;")               = "innerHtml";
     *      getHrefInnerHtml("&lt;a href="baidu.com" title="baidu"&gt;innerHtml&lt;/a&gt;") = "innerHtml";
     *      getHrefInnerHtml("   &lt;a&gt;innerHtml&lt;/a&gt;  ")                           = "innerHtml";
     *      getHrefInnerHtml("&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                      = "innerHtml";
     *      getHrefInnerHtml("jack&lt;a&gt;innerHtml&lt;/a&gt;&lt;/a&gt;")                  = "innerHtml";
     *      getHrefInnerHtml("&lt;a&gt;innerHtml1&lt;/a&gt;&lt;a&gt;innerHtml2&lt;/a&gt;")        = "innerHtml2";
     * </pre>
     */
    public static String getHrefInnerHtml(String href) {
        if (isEmpty(href)) {
            return "";
        }
        // String hrefReg = "[^(<a)]*<[\\s]*a[\\s]*[^(a>)]*>(.+?)<[\\s]*/a[\\s]*>.*";
        String hrefReg = ".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*";
        Pattern hrefPattern = Pattern.compile(hrefReg, Pattern.CASE_INSENSITIVE);
        Matcher hrefMatcher = hrefPattern.matcher(href);
        if (hrefMatcher.matches()) {
            return hrefMatcher.group(1);
        }
        return href;
    }

    /**
     * 得到固定长度的随机字符串，字符串由数字和字母混合组成
     * 
     * @param length 长度
     * @return
     * @see 见{@link StringUtils#getRandom(String source, int length)}
     */
    public static String getRandomNumbersAndLetters(int length) {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由数字混合组成
     * 
     * @param length 长度
     * @return
     * @see 见{@link StringUtils#getRandom(String source, int length)}
     */
    public static String getRandomNumbers(int length) {
        return getRandom(NUMBERS, length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由字母混合组成
     * 
     * @param length 长度
     * @return
     * @see 见{@link StringUtils#getRandom(String source, int length)}
     */
    public static String getRandomLetters(int length) {
        return getRandom(LETTERS, length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由大写字母混合组成
     * 
     * @param length 长度
     * @return
     * @see 见{@link StringUtils#getRandom(String source, int length)}
     */
    public static String getRandomCapitalLetters(int length) {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由小写字母混合组成
     * 
     * @param length 长度
     * @return
     * @see 见{@link StringUtils#getRandom(String source, int length)}
     */
    public static String getRandomLowerCaseLetters(int length) {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由source中字符混合组成
     * 
     * @param source 源字符串
     * @param length 长度
     * @return
     *         <ul>
     *         <li>若source为null或为空字符串，返回null</li>
     *         <li>否则见{@link StringUtils#getRandom(char[] sourceChar, int length)}</li>
     *         </ul>
     */
    public static String getRandom(String source, int length) {
        return StringUtils.isEmpty(source) ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * 得到固定长度的随机字符串，字符串由sourceChar中字符混合组成
     * 
     * @param sourceChar 源字符数组
     * @param length 长度
     * @return
     *         <ul>
     *         <li>若sourceChar为null或长度为0，返回null</li>
     *         <li>若length小于0，返回null</li>
     *         </ul>
     */
    public static String getRandom(char[] sourceChar, int length) {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }
        StringBuilder str = new StringBuilder("");
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }

    /**
     * html的转移字符转换成正常的字符串
     * 
     * @param source
     * @return
     */
    public static String htmlEscapeCharsToString(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        } else {
            return source.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;",
                                                                                                              "\"");
        }
    }


    /**
     * 去掉字符串两边的符号，返回去掉后的结果
     * 
     * @param source 原字符串
     * @param symbol 符号
     * @return
     */
    public static String RemoveBothSideSymbol(String source, String symbol) {
        if (isEmpty(source) || isEmpty(symbol)) {
            return source;
        }

        int firstIndex = source.indexOf(symbol);
        int lastIndex = source.lastIndexOf(symbol);
        try {
            return source.substring(((firstIndex == 0) ? symbol.length() : 0),
                                    ((lastIndex == source.length() - 1) ? (source.length() - symbol.length()) : source.length()));
        } catch (IndexOutOfBoundsException e) {
            return "";
        }
    }

    /**
     * 字符串匹配(仅支持"*"匹配).
     * @param pattern 模板
     * @param str 要验证的字符串
     * @return
     */
    public static boolean simpleWildcardMatch(String pattern, String str) {
        return wildcardMatch(pattern, str, "*");
    }

    /**
     * 字符串匹配.
     * @param pattern   模板
     * @param str   要验证的字符串
     * @param wildcard 通配符
     * @return
     */
    public static boolean wildcardMatch(String pattern, String str, String wildcard) {
        if (StringUtils.isEmpty(pattern) || StringUtils.isEmpty(str)) {
            return false;
        }
        final boolean startWith = pattern.startsWith(wildcard);
        final boolean endWith = pattern.endsWith(wildcard);
        String[] array = StringUtils.split(pattern, wildcard);
        int currentIndex = -1;
        int lastIndex = -1 ;
        switch (array.length) {
            case 0:
                return true ;
            case 1:
                currentIndex = str.indexOf(array[0]);
                if (startWith && endWith) {
                    return currentIndex >= 0 ;
                }
                if (startWith) {
                    return currentIndex + array[0].length() == str.length();
                }
                if (endWith) {
                    return currentIndex == 0 ;
                }
                return str.equals(pattern) ;
            default:
                for (String part : array) {
                    currentIndex = str.indexOf(part);
                    if (currentIndex > lastIndex) {
                        lastIndex = currentIndex;
                        continue;
                    }
                    return false;
                }
                return true;
        }
    }
    
    /**
     * 根据后一个字符分割前一个字符
     * @param str String
     * @param separ String 分隔符
     * @return String[]
     */
	public static String[] separator(String str, String separ) {
		String Str[]=null;
    	if(str == null || "".equals(str)){
    		Str = new String[0];
    	}else{
    		int iStar = 0, iSum = 0;
    		for (int i = 0; i < str.length(); i++) {
    			if (str.substring(i, i + 1).equals(separ)) {
    				iSum++;
    			}
    		}
    		if (!str.substring(str.length() - 1, str.length()).equals(separ)) {
    			iSum++;
    		}
    		Str = new String[iSum];
    		iSum = 0;
    		for (int i = 0; i < str.length(); i++) {
    			if (str.substring(i, i + 1).equals(separ)) {
    				Str[iSum] = str.substring(iStar, i).trim();
    				iStar = i + 1;
    				iSum++;
    			}
    		}
    		if (!str.substring(str.length() - 1, str.length()).equals(separ)) {
    			Str[iSum] = str.substring(iStar, str.length()).trim();
    		}
    	}	
        return Str;
	}
	
	/**	
	 *	AezGenholmes 
	 *	2016年4月11日
	 *  描述：获得数据库的字段名称  如userId转换为 USER_ID 将驼峰以下划线分割
	 *  @param str
	 *  @return 
	 */
	public static String getTableName(String str){
		if(isBlank(str)){
			return null;
		}
		String[] strArray=str.split("");
		String newStr="";
		for(String s:strArray){
			if(s.matches("[A-Z]")){
				newStr+="_"+s;
			}else{
				newStr+=s.toUpperCase();
			}
		}
		if(newStr.length()>0 && newStr.substring(0,1).matches("_")){
			newStr=newStr.substring(1);
		}
		return newStr;
	}
	
	/**	
	 *	AezGenholmes 
	 *	2016年4月22日
	 *  描述：判断字符串数组 是否包含某个特定字符串
	 *  @param array
	 *  @param str
	 *  @return 
	 */
	public static boolean arrayHasStr(String[] array,String str){
		if(isBlank(str)){
			return false;
		}
		for(int i=0;i<array.length;i++){
			if(str.equals(array[i])){
				return true;
			}
		}
		return false;
	}
	
	/**	
	 *	AezGenholmes 
	 *	2016年4月22日
	 *  描述：判断字符串集合 是否包含某个特定字符串
	 *  @param array
	 *  @param str
	 *  @return 
	 */
	public static boolean listHasStr(List<String> list,String str){
		if(isBlank(str)){
			return false;
		}
		for(String s:list){
			if(str.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	
	/**	
	 *	AezGenholmes 
	 *	2016年5月18日
	 *  描述：
	 *  @param objectClass 转换对象的所属类类型或者基本类型
	 *  @param str	转换对象字符串
	 *  @return 
	 */
	public static Object convertStringToObject(String objectClass,String str){
		if(isBlank(objectClass) || isBlank(str)){
			return null;
		}
		str=str.trim();
		// 如果type是类类型，则前面包含"class "，后面跟类名
		//如果类型是String
		if (objectClass.equals("class java.lang.String")) { 
			return str;
		}
		// 如果类型是Integer
		else if (objectClass.equals("class java.lang.Integer")) {
			if(isNumeric(str)){
				return Integer.valueOf(str);
			}
		}
		// 如果类型是Double
		else if (objectClass.equals("class java.lang.Double")) {
			if(isNumeric(str)){
				return Double.valueOf(str);
			}
		}
		// 如果类型是Boolean 是封装类
		else if (objectClass.equals("class java.lang.Boolean")) {
			if(str.equals("1")||str.equals("true")){
				return true;
			}else if(str.equals("0")||str.equals("false")){
				return false;
			}
		}
		// 如果类型是Short
		else if (objectClass.equals("class java.lang.Short")) {
			if(isNumeric(str)){
				return Short.valueOf(str);
			}
		}
		// 如果类型是boolean 基本数据类型不一样 不需要class
		else if (objectClass.equals("boolean")) {
			if(str.equals("1")||str.equals("true")){
				return true;
			}else if(str.equals("0")||str.equals("false")){
				return false;
			}
		}
		//	如果类型是int
		else if (objectClass.equals("int")) {
			if(isNumeric(str)){
				return Integer.parseInt(str);
			}
		}
		//还可以后续扩展
		return null;
	}
	
	/**	
	 *	AezGenholmes 
	 *	2016年5月18日
	 *  描述：判断一个字符串是否为数字形式  可为负数、带小数点
	 *  @param str
	 *  @return 
	 */
	public static boolean isNumeric(String str){ 
	   Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+"); 
	   Matcher isNum = pattern.matcher(str);
	   if( !isNum.matches() ){
	       return false; 
	   } 
	   return true; 
	}
    public  static String  convertToString(String[] array){
        String string="";
        if(array!=null){
            string = ArrayUtils.toString(array);
            string = string.substring(1, string.length() - 1);
        }
        return string;
    }

    /**
     * 差集
     **/
    public  static String  differenceSet(String[] array,String[] array1){
        Set<String> set = new HashSet<String>(Arrays.asList(array.length > array1.length ? array : array1));
        for (String i : array.length > array1.length ? array1 : array){
            if (set.contains(i)) {
                set.remove(i);
            }
//            else {
//                set.add(i);
//            }
        }
        return convertToString(set.toArray(new String[0]));
    }

    /**
     * 差集
     **/
    public  static String  differenceSet(String string,String string1){
        String result="";
        if(string!=null&&string1!=null){
            String[] array = string.split(",");
            String[] array1 = string1.split(",");
            result=differenceSet(array,array1);
        }
        return result;
    }
    /**
     * 差集
     **/
    public  static String  removeElement(String array,String string){
        String[] arr={};
        String[] objects={};
        if(array!=null&&string!=null){
            arr = array.split(",");
            objects = (String[]) ArrayUtils.removeElement(arr, string);
        }
        return convertToString(objects);
    }
    /**
     * 是否存在
     **/
    public  static Boolean  isExist(String array,String string){
        Boolean falg=false;
        if (array!=null&&string!=null){
            if(array.contains(","+string+",")){
                falg=true;
            }
            if(array.startsWith(string+",")){
                falg=true;
            }
            if(array.endsWith(","+string)){
                falg=true;
            }
            if(array.equals(string)){
                falg=true;
            }
        }

        return falg;
    }

    /**
     * 格式化字符串，防止空指针异常
     * @param obj
     * @return
     */
    public static String formatStr(Object obj){
       return obj==null?"":obj.toString();

    }
}