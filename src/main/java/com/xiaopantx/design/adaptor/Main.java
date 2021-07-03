package com.xiaopantx.design.adaptor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author panxj
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        //InputStreamReader 转换器功能
        BufferedReader reader = new BufferedReader(
                new InputStreamReader( // 转换器模式
                        new FileInputStream("file.txt")
                )
        );


    }
}
