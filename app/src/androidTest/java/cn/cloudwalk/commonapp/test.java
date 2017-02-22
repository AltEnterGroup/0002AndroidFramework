/**
 * Project Name:CommonApp
 * File Name:test
 * Package Name:cn.cloudwalk.commonapp
 * Date:2017/1/18 00189:58
 * Copyright @ 2010-2017 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.commonapp;

import java.math.BigDecimal;

/**
 * ClassName:test <br/>
 * Description: TODO Description. <br/>
 * Date:     2017年01月18日 09:58 <br/>
 * @author 284891377
 * @version
 * @since JDK 1.7	 
 */
public class test {

    public static void main(String args[]) {
        double score = new BigDecimal(0.654356).setScale(4, BigDecimal.ROUND_UNNECESSARY).doubleValue();
        System.out.println("Hello World!"+score);
    }

}
