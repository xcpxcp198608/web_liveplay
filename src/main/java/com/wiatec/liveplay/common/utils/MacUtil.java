package com.wiatec.liveplay.common.utils;

/**
 * @author patrick
 */
public class MacUtil {


    public static String[] createMacs(String startMac, String endMac, int index){
        String start = startMac.replaceAll(":", "");
        String end = endMac.replaceAll(":", "");
        String prefix = start.substring(0, index);
        start = start.substring(index);
        end = end.substring(index);

        int s1 = Integer.parseInt(start, 16);
        int e1 = Integer.parseInt(end, 16);
        int length = e1 - s1 + 1;
        String [] macs = new String[length];
        for(int i = 0; i < length; i ++){
            String m = Integer.toHexString(s1).toUpperCase();
            m = prefix + m;
            macs[i] = addColon(m).toUpperCase();
            s1 ++;
        }
        return macs;
    }

    private static String addColon(String s){
        String result = "";
        char[] chars = s.toCharArray();
        int length = chars.length - 1;
        for(int i = length ; i >= 0; i --){
            if(i % 2 == 0 && i != 0){
                result = ":" + chars[i] + result;
            }else{
                result = chars[i] + result;
            }
        }
        return result;
    }

    public static boolean compare(String startMac, String endMac, int index){
        String start = startMac.replaceAll(":", "");
        String end = endMac.replaceAll(":", "");
        String sPrefix = start.substring(0, index);
        String ePrefix = end.substring(0, index);
        if(!sPrefix.equals(ePrefix)){
            return false;
        }
        start = start.substring(index);
        end = end.substring(index);
        int s1 = Integer.parseInt(start, 16);
        int e1 = Integer.parseInt(end, 16);
        return e1 > s1;
    }

    public static boolean validateMac(String mac){
        String newMac = mac;
        if(newMac.length() != 17){
            return false;
        }
        newMac = newMac.replaceAll(":", "");
        if(newMac.length() != 12){
            return false;
        }
        return true;
    }

    public static void main (String [] args){
        String[] macs = MacUtil.createMacs("5C:41:E7:00:01:02", "5C:41:E7:00:01:1A", 5);
        for(String mac: macs){
            System.out.println(mac);
        }

        boolean compare = compare("5C:41:E7:00:01:32", "5C:41:E7:00:01:1A", 5);
        System.out.println(compare);
    }

}
