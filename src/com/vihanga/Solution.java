package com.vihanga;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Solution {
    public static HashMap<String,Integer> romanValMap = new HashMap<>();

    public Solution(){

    }
    public int romanToInt(String s) {
        //System.out.println("Input:"+s);
        String [] arr =  s.split("");

       //for(String obj:arr) System.out.println("object value: "+obj);

       // System.out.println("Arr length: "+arr.length);
        int intValue = 0;
        if(arr.length !=0){
            intValue =  calculateVal(arr);
        }else {
            System.out.println("Input is empty: ");
        }

        return intValue;

    }

    private int calculateVal(String [] arr ){
        populate();
        int temp =0;
        int current=0;
        int finalValue =0;

        for(int i=0; i <arr.length ;i++){
            System.out.println("Arr index "+i+ " Value "+arr[i]);


            if(arr.length !=1){
                if(i ==0) {
                    temp = romanValMap.get(arr[i]); // only runs in the first iteration
                }else {
                    current = romanValMap.get(arr[i]);
                    if(temp>=current){
                        finalValue = finalValue+temp;
                        temp = current;
                        if(i== arr.length-1) finalValue = finalValue+current;
                    }else {
                        finalValue = finalValue -temp;
                        if(i== arr.length-1) finalValue = finalValue+current;
                        temp =current;
                    }
                }


            }else {
                Integer value = romanValMap.get(arr[i]);
                finalValue =value;
            }



        }



        return finalValue;
    }
    private void populate(){
        romanValMap.put("I",1);
        romanValMap.put("V",5);
        romanValMap.put("X",10);
        romanValMap.put("L",50);
        romanValMap.put("C",100);
        romanValMap.put("D",500);
        romanValMap.put("M",1000);

        // romanValArr.forEach((key,value)->System.out.println("Key: "+key+" ,Value: "+value));

    }
}
