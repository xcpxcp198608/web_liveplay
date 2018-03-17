package com.wiatec.liveplay.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author patrick
 */
public class UnitUtil {

    public static void main (String [] args){
        String f = round(1.5892F);
        System.out.println(f);
    }


    public static String round(float f){
        DecimalFormat df = new DecimalFormat ( "###,##0.00" ) ;
        return df.format (f) ;
    }
}
