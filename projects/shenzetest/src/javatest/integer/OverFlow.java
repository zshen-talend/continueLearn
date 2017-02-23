// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.integer;


/**
 * DOC zshen  class global comment. Detailled comment
 */
public class OverFlow {

    public static void main(String[] args) {
        // try {
        // Integer inputValue = -99999999;
        // Integer rate = 1;
        // boolean inputIsNegative = inputValue < 0;
        // boolean rateIsNegative = rate < 0;
        // int attenuationTimes = 0;
        // Integer result = 0;
        // if (isAbsAdd(inputIsNegative, rateIsNegative)) {
        // result = inputValue + Math.round(inputValue * rate / 100);
        // System.out.println("first time result is " + result);
        // System.out.println("change value is " + Math.round(inputValue * rate / 100));
        // if (Math.abs(result) > Math.abs(inputValue)) {
        // result = inputValue + Math.round(inputValue * (-rate) / 100);
        // System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
        // }
        // System.out.println("finnally result is " + result);
        // System.out.println("change rate is " + (0.0 + result - inputValue) / inputValue);
        // // result = Math.abs(inputValue) + Math.round(Math.abs(inputValue) * Math.abs(rate) / 100);
        // // System.out.println("first time result is " + result);
        // // System.out.println("change value is " + Math.round(Math.abs(inputValue) * Math.abs(rate) / 100));
        // // while (result < Math.abs(inputValue)) {
        // // attenuationTimes = attenuationTimes + 2;
        // // result = Math.abs(inputValue) + Math.round(Math.abs(inputValue) * (Math.abs(rate) / attenuationTimes) / 100);
        // // System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
        // // }
        // // System.out.println("finnally result is " + result);
        // // System.out.println("change rate is " + (0.0 + result - inputValue) / inputValue);
        // } else {
        // result = Math.abs(inputValue) - Math.round(Math.abs(inputValue) * Math.abs(rate) / 100);
        // System.out.println("first time result is " + result);
        // System.out.println("change value is " + -Math.round(Math.abs(inputValue) * Math.abs(rate) / 100));
        // while (result > Math.abs(inputValue)) {
        // attenuationTimes = attenuationTimes + 2;
        // result = Math.abs(inputValue) - Math.round(Math.abs(inputValue) * (Math.abs(rate) / attenuationTimes) / 100);
        // System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
        // }
        // System.out.println("finnally result is " + result);
        // System.out.println("change rate is " + (0.0 + Math.abs(inputValue) - result) / inputValue);
        // }
        // } catch (RuntimeException e) {
        // System.out.println(e.getMessage());
        // }
        System.out.println(120 * 99999999 / 100);
    }
    

//    public static void main(String[] args) {
//        try {
//            Integer inputValue = -99999999;
//            Integer rate = 1;
//            boolean inputIsNegative = inputValue < 0;
//            boolean rateIsNegative = rate < 0;
//            int attenuationTimes = 0;
//            Integer result = 0;
//            if (isAbsAdd(inputIsNegative, rateIsNegative)) {
//                result = inputValue + Math.round(inputValue * rate / 100);
//                System.out.println("first time result is " + result);
//                System.out.println("change value is " + Math.round(inputValue * rate / 100));
//                if (Math.abs(result) > Math.abs(inputValue)) {
//                    result = inputValue + Math.round(inputValue * (-rate) / 100);
//                    System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
//                }
//                System.out.println("finnally result is " + result);
//                System.out.println("change rate is " + (0.0 + result - inputValue) / inputValue);
//                // result = Math.abs(inputValue) + Math.round(Math.abs(inputValue) * Math.abs(rate) / 100);
//                // System.out.println("first time result is " + result);
//                // System.out.println("change value is " + Math.round(Math.abs(inputValue) * Math.abs(rate) / 100));
//                // while (result < Math.abs(inputValue)) {
//                // attenuationTimes = attenuationTimes + 2;
//                // result = Math.abs(inputValue) + Math.round(Math.abs(inputValue) * (Math.abs(rate) / attenuationTimes) / 100);
//                // System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
//                // }
//                // System.out.println("finnally result is " + result);
//                // System.out.println("change rate is " + (0.0 + result - inputValue) / inputValue);
//            } else {
//                result = Math.abs(inputValue) - Math.round(Math.abs(inputValue) * Math.abs(rate) / 100);
//                System.out.println("first time result is " + result);
//                System.out.println("change value is " + -Math.round(Math.abs(inputValue) * Math.abs(rate) / 100));
//                while (result > Math.abs(inputValue)) {
//                    attenuationTimes = attenuationTimes + 2;
//                    result = Math.abs(inputValue) - Math.round(Math.abs(inputValue) * (Math.abs(rate) / attenuationTimes) / 100);
//                    System.out.println("attenuation times is " + attenuationTimes + " current result is " + result);
//                }
//                System.out.println("finnally result is " + result);
//                System.out.println("change rate is " + (0.0 + Math.abs(inputValue) - result) / inputValue);
//            }
//        } catch (RuntimeException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public static boolean isAbsAdd(boolean inputIsNegative, boolean rateIsNegative) {
        return !(inputIsNegative ^ rateIsNegative);
    }
}
