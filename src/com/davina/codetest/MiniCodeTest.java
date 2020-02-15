package com.davina.codetest;

import java.util.*;

/**
 * @ClassName MiniCodeTest
 * @Description Given an integer array containing digits from [0, 9], the task is to print all possible letter
 * combinations that the numbers could represent. A mapping of digit to letters (just like
 * on the telephone buttons) is being followed. Note that 0 and 1 do not map to any
 * letters. All the mapping are shown in the image below
 * @Author Davina Chan
 * @Date 2020/2/15 14:28
 * @Version 1.0
 */
public class MiniCodeTest {

    public static void main(String[] args) {

        int [] intArray = {32,33};
        System.out.println(SpliceLetters(intArray));
    }

    public static List<String> SpliceLetters(int[] intArray){

        //获取0-9和字母之间的转换关系
//        Map<Integer, List<String>> integerListMap = covertNumToLetter();
        Map<Integer, List<String>> integerListMap = covertNum99ToLetter();
        System.out.println(integerListMap);

        // 用于存放每次拼接的结果
        List<String> strings = new ArrayList<>();
        for (int i = 0 ; i < intArray.length ; i++){
            // 把上一次拼接好的结果，和当前数字，以及0-9和字母之间的映射传入
            get(strings,intArray[i],integerListMap);
        }

        return strings;
    }

    private static void get(List<String> strings, int index, Map<Integer, List<String>> integerListMap) {
        List<String> letters = new ArrayList<>(); //用于存放每个字母中所有的字母
        List<String> stringList = new ArrayList<>(strings); // 原来拼好的字符串
        strings.clear();

        for(int i = 0 ; i < integerListMap.get(index).size(); i++){
            letters.add(integerListMap.get(index).get(i));
        }
        // 第一个数字
        if (stringList.size() == 0){
            for (int i = 0 ; i < letters.size();i++){
                strings.add(letters.get(i));
            }
        }else {
            // 第二个数字之后就要把上一次拼接的结果，和当前数字对应的字母列表进行组合
            for (int i = 0 ; i < letters.size();i++){
                for (int j = 0 ; j < stringList.size();j++){
                    strings.add(letters.get(i)+stringList.get(j));
                }
            }
        }
    }

    /**
     * 把0-9与26个字母关联起来
     * @return
     */
    public static Map<Integer,List<String>> covertNumToLetter(){
        // 用于存放数字和字母对应关系（key是数字，value是对应的字母列表）
        Map<Integer, List<String>> numCovertToChar = new HashMap<>();

        for (int i = 0 ; i < 10; i++){
            numCovertToChar.put(i,new ArrayList<String>());
        }

        List<String> characterList = new ArrayList<>();
        for (int i = 'a' ; i < 'd' ; i++) {
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(2,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'd'; i < 'g'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(3,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'g'; i < 'j'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(4,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'j'; i < 'm'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(5,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'm'; i < 'p'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(6,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'p'; i < 't'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(7,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 't'; i < 'w'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(8,characterList);
        }

        characterList = new ArrayList<>();
        for (int i = 'w'; i <= 'z'; i++){
            characterList.add(String.valueOf((char) i));
            numCovertToChar.put(9,characterList);
        }

        return  numCovertToChar;
    }


    /**
     * 把0-99与26个字母关联起来
     * @return
     */
    public static Map<Integer,List<String>> covertNum99ToLetter(){
        // 用于存放数字和字母对应关系（key是数字，value是对应的字母列表）
        Map<Integer, List<String>> numCovertToChar = new HashMap<>();

        for (int i = 0 ; i < 100; i++){
            numCovertToChar.put(i,new ArrayList<String>());
        }

        List<String> characterList = new ArrayList<>();
        for (int i = 'a' ; i < 'd' ; i++) {
            characterList.add(String.valueOf((char) i));
            for (int j = 0 ; j < 10 ; j++){
                numCovertToChar.put(2 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'd'; i < 'g'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0; j < 10 ; j++){
                numCovertToChar.put(3 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'g'; i < 'j'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0 ; j < 10;j++){
                numCovertToChar.put(4 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'j'; i < 'm'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0; j < 10 ;j++){
                numCovertToChar.put(5 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'm'; i < 'p'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0 ; j < 10; j++){
                numCovertToChar.put(6 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'p'; i < 't'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0 ; j < 10 ; j++){
                numCovertToChar.put(7 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 't'; i < 'w'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0 ; j < 10 ; j++){
                numCovertToChar.put(8 + 10 * j,characterList);
            }
        }

        characterList = new ArrayList<>();
        for (int i = 'w'; i <= 'z'; i++){
            characterList.add(String.valueOf((char) i));
            for (int j = 0; j < 10 ; j++){
                numCovertToChar.put(9 + 10 * j,characterList);
            }
        }

        return  numCovertToChar;
    }
}
