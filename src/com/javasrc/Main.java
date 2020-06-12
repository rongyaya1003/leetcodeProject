package com.javasrc;

import com.sun.jmx.snmp.EnumRowStatus;
import org.apache.log4j.Logger;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.*;

public class Main {

    protected static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        System.out.println("hello world");

        getRow();
//        generate();
//        getFirstSaturdayTimestamp();
//        reverseString();
//        twoSum();
//        checkPermutation();
//        compressString();
//        isPalindrome();
//        reverse();
//        longestCommonPrefix();
//        removeDuplicates();
//        removeElement();
//        strStr();
//        searchInsert();
//        isFlipedString();

    }

    public static List<Integer> getRow() {
        int rowIndex = 3;

        //To 1
//        int numRows = rowIndex + 1;
//        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
//        if(numRows < 1){
//            return listAll.get(0);
//        }
//        int[][] yanghui = new int[numRows][numRows];
//
//        for (int i=0; i<numRows; i++){
//            List<Integer> list = new ArrayList<>();
//
//            for(int j=0;j<=i;j++) {
//                if (i == 0 || j == 0 || j == numRows) {
//                    yanghui[i][j] = 1;
//                }else {
//                    yanghui[i][j]= yanghui[i-1][j-1] + yanghui[i-1][j];
//                }
//                list.add(yanghui[i][j]);
//            }
//
//            listAll.add(list);
//        }
//
//        return listAll.get(rowIndex);


        //To 2

        List<Integer> pre = new ArrayList<>();

        for (int i=0; i<=rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j==0 || j==i) {
                    cur.add(1);
                }else {
                    int sumpre = pre.get(j -1) + pre.get(j);
                    cur.add(sumpre);
                }
            }
            pre = cur;
        }

        return pre;

        // to 3

//        int pre = 1;
//        List<Integer> cur = new ArrayList<>();
//        cur.add(1);
//        for (int i = 1; i <= rowIndex; i++) {
//            for (int j = 1; j < i; j++) {
//                int temp = cur.get(j);
//                cur.set(j, pre + cur.get(j));
//                pre = temp;
//            }
//            cur.add(1);
//        }
//        return cur;
    }

    /**
     * 杨辉三角
     *
     * @return
     */
    public static List<List<Integer>> generate() {
        int numRows = 5;
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        if(numRows < 1){
            return listAll;
        }
        int[][] yanghui = new int[numRows][numRows];

        for (int i=0; i<numRows; i++){
            List<Integer> list = new ArrayList<>();

            for(int j=0;j<=i;j++) {
                if (i == 0 || j == 0 || j == numRows) {
                    yanghui[i][j] = 1;
                }else {
                    yanghui[i][j]= yanghui[i-1][j-1] + yanghui[i-1][j];
                }
                list.add(yanghui[i][j]);
            }

            listAll.add(list);
        }
        return listAll;

    }

    /**
     * 每月第一个周六
     *
     * @return
     */
    public static Date getFirstSaturdayTimestamp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.WEEK_OF_MONTH, calendar.get(Calendar.WEEK_OF_MONTH));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return calendar.getTime();
    }

    /**
     * 递归反转字符串
     */
    static int index = 0;

    public static void reverseString(){
//        char[] c = {'h', 'e', 'l', 'l', 'o'};
        char[] c = {'H', 'a', 'n', 'n', 'a', 'h'};
        char[] chars = reverseStr(c, 0);
        System.out.println(chars);
    }

    public static char[] reverseStr(char[] chars, int k){
        if(k == chars.length) return chars;
        reverseStr(chars, k + 1);
        if(index <= k) {
            char temp = chars[k];
            chars[k] = chars[index];
            chars[index++] = temp;
        }
        return chars;
    }

    /**
     * 两数之和
     * @return
     */
    public static int[] twoSum() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] a = new int[2];
        if(nums.length >0 ) {
            for (int i=0; i<nums.length; i++) {
                for (int j=i; j<nums.length; j++) {
                    if(target == nums[i] + nums[j] && i!=j) {
                        a[0] = i;
                        a[1] = j;
                    }
                }
            }
        }
        return a;
    }

    /**
     * 排序
     * @return
     */
    public static boolean checkPermutation() {
        String s1 = "jzvthzihsvghjhbrpfhdwixmyaxjrdzfvnhpmyrbqjpdffykqgahgzpjwvouurr";
        String s2 = "hhqhxjyrghjjsmduaxppwrqkikqnfdrzjowapehtbyrgrfyprrfrebzduxvvhhu";

        if(s1.length() != s2.length()){
            return false;
        }


        return stringSort(s1).equals(stringSort(s2));
    }

    private static List<String> stringSort(String s){
        String[] string = s.split("");
        Arrays.sort(string);
        List<String> stringList = new ArrayList<>();
        for (String str : string) {
            stringList.add(str);
        }

        return stringList;
    }

    /**
     * 字符串压缩
     * 输入："aabcccccaaa"
     * 输出："a2b1c5a3"
     * @return
     */
    public static String compressString(){
        String S = "aabcccccaaa";

        int len = S.length();
        if(S == null && len == 0) return S;
        boolean flag = false;
        int cnt = 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0; i<len; i++) {
            logger.info(i+"=");
            for (int j=i+1; j<len; j++) {
                logger.info(j+"==");
                if(S.charAt(i) == S.charAt(j)) {
                    cnt++;
                    logger.info(cnt+"--");
                    stringBuffer.append(S.charAt(i)).append(cnt);
                } else {
                    logger.info(cnt);
                    flag = true;
                }

                if(flag){
                    cnt = 1;
                    i=j;
                    break;
                }
            }
        }
        logger.info(stringBuffer);
        stringBuffer.append(S.charAt(len-1)).append(cnt);

        if(S.length() <= stringBuffer.length()){
            return S;
        }
        return stringBuffer.toString();

        //方法一 执行后可能存在越界
//        int len = S.length();
//        if(S == null && len == 0){
//            return S;
//        }

//        StringBuffer stringBuffer = new StringBuffer();
//        int index = 1;
//        int cnt = 0;
//        for (int i=0; i < len; i++) {
//            logger.info(index);
//            if(S.charAt(i) == S.charAt(index)) {
//                cnt++;
//            } else {
//                stringBuffer.append(S.charAt(index)).append(cnt);
//                index = i;
//                cnt = 0;
//            }
//        }
//        stringBuffer.append(S.charAt(len - 1)).append(cnt);
//        if(S.length() <= stringBuffer.length()){
//            return S;
//        }
//
//        return stringBuffer.toString();

        //方法二 √
//        int N = S.length();
//        int i = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i < N) {
//            int j = i;
//            while (j < N && S.charAt(j) == S.charAt(i)) {
//                j++;
//            }
//            sb.append(S.charAt(i));
//            sb.append(j - i);
//            i = j;
//        }
//
//        String res = sb.toString();
//        if (res.length() < S.length()) {
//            return res;
//        } else {
//            return S;
//        }

    }

    /**
     * 反转
     * @return
     */
    public static int reverse() {
        int x = 123;

        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }

        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;
        return (int) y;

    }

    /**
     * 回文
     *
     * @return
     */
    public static boolean isPalindrome() {
        int x = 121;

        if(x <= 0) {
            return false;
        }

        StringBuffer stringBuffer = new StringBuffer(String.valueOf(x));
        stringBuffer.reverse();// 反转字符串

        if(stringBuffer.toString().equals(String.valueOf(x))  ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 最长公共前缀
     * @return
     */
    public static String longestCommonPrefix() {
        String[] strs = {"flower","flow","flight"};

        StringBuffer stringBuffer = new StringBuffer();

        if(strs.length == 0 && strs == null){
            return "";
        }

        for (String string : strs) {
            for (int j=0; j<string.length(); j++) {
                if(string.charAt(j) == string.charAt(j)) {
                    stringBuffer.append(string.charAt(j));
                }
            }
        }

        return stringBuffer.toString();
    }

    /**
     * 删除排序数组中的重复项(原地删除)
     * @return
     */
    public static int removeDuplicates() {
        int[] nums = {1,1,2};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        if(nums == null && nums.length == 0) {
            return nums.length;
        }

        int index = 1;
        for (int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }

        }

        return index;


//        boolean flag = false;
//        int cnt = 1;
//        for (int i=0; i<nums.length; i++) {
//            for (int j=i+1;j<nums.length; j++) {
//                if(nums[i] == nums[j]){
//                    cnt++;
//                } else {
//                    flag = true;
//                }
//
//                if(flag){
//                    i=j;
//                    break;
//                }
//            }
//        }
//        return cnt;

//        boolean flag = false;
//        List<Integer> stringList = new ArrayList<>();
//        for (int i=0; i<nums.length; i++) {
//            for (int j=i+1;j<nums.length; j++) {
//                if(nums[i] == nums[j]){
//                    stringList.add(nums[i]);
//                } else {
//                    flag = true;
//                }
//
//                if(flag){
//                    i=j;
//                    break;
//                }
//            }
//        }
//
//        stringList.add(nums[nums.length - 1]);
//        return stringList.size();
    }

    /**
     * 27. 移除元素
     * @return
     */
    public static int removeElement() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        int len = nums.length;
        if(len <= 0 && nums == null) return nums.length;

        int index = 0;
        for (int i=0; i<len; i++) {
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }
//        logger.info(Arrays.toString(nums));
        return index;
    }

    /**
     * 判断needle在haystack中出现的位置，没有就输出-1
     * @return
     */
    public static int strStr() {
        String haystack = "aaaaa";
        String needle = "bba";

        if(haystack == null && needle == null) return -1;

        return haystack.indexOf(needle);
    }

    /**
     * 35.搜索插入位置
     * @return
     */
    public static int searchInsert() {
        int[] nums= {1,2,3,4,5,10};
        int target = 2;

//        if(nums.length <= 0) {
//            return 0;
//        }
//
//        if(target < 0) {
//            return 0;
//        }
//
//
//        List<Integer> newList = new ArrayList<>();
//        for (int i=0; i<nums.length; i++) {
//            if(nums[i] == target) {
//                return i;
//            } else {
//                newList.add(nums[i]);
//                newList.add(target);
//            }
//        }
//
//        Collections.sort(newList);
//
//        if(newList.size() > 0 && newList != null){
//            for (int i=0; i<newList.size(); i++) {
//                if (newList.get(i) == target) {
//                    return i;
//                }
//            }
//        }
//
//        return 0;

//        int index = 0;
//        if(nums.length <= 0 && target < 0) return index;
//
//        List<Integer> arrayList = new ArrayList<>();
//        for (int i=0; i<nums.length; i++) {
//            arrayList.add(nums[i]);
//            if(nums[i] != target){
//                arrayList.add(target);
//            }
//        }
//
//        Collections.sort(arrayList);
//
//        if(arrayList.size() > 0){
//            index = arrayList.indexOf(target);
//        }
//
//        return index;

        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;

    }

    public static boolean isFlipedString() {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean flag = false;
        if(s1.equals(s2)){
            flag = true;
        }
        if(s1.length() == s2.length()) {
            String[] ss = s1.split("");
            for (int i=0; i<ss.length; i++) {
                flag = s2.contains(ss[i]);
            }
        }



        return flag;
    }




}
