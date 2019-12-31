package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;


public class Main {

    static LinkedHashSet<String> nums;

    public static void main(String[] args) {
        long num = 1027;

        nums = new LinkedHashSet();
        String strNum = num + "";
        permutation("", strNum);

        int indexOfNum = 0;

        List<String> numsList = new ArrayList<>(nums);
        Collections.sort(numsList);

        for(int i = 0; i < nums.size(); i++){
            System.out.println(numsList.get(i));
            if(numsList.get(i).equals(strNum)){
                indexOfNum = i;
            }
        }

        if(indexOfNum == 0){
            System.out.println("it is " + indexOfNum);
        }else {
            System.out.println("The next lowest is " + Long.parseLong(numsList.get(indexOfNum - 1)));
        }

    }

    private static void permute(String prefix, String str) {
        int len = str.length();
        if (len == 0 && !prefix.substring(0, 1).equals("0")) nums.add(prefix);
        else {
            for (int i = 0; i < len; i++)
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, len));
        }
    }
}
