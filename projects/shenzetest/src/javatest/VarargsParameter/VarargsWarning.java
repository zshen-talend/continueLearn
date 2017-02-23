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
package javatest.VarargsParameter;

import java.util.ArrayList;

/**
 * DOC zshen class global comment. Detailled comment
 */

public class VarargsWarning {

    public static void main(String[] args) {

        System.out.println(new VarargsWarning().sum(1, 2, 3, 4));
        Pair result = VarargsWarning.sumF(new Pair(0, 0), new Pair(2, 4), new Pair(5, 6));
        System.out.println(result);

        VarargsWarning.useVarargs(new ArrayList<String>());
    }

    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }

    public int sum(int... args) {
        int result = 0;
        for (int value : args) {
            result += value;
        }
        return result;
    }

    public static <T extends Addable> T sumF(T initial, T... args) {
        T result = initial;
        for (T value : args) {
            result.add(value);
        }
        return result;
    }

    private static interface Addable<T> {

        void add(T operand);
    }

    private static class Pair implements Addable<Pair> {

        private int x;

        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void add(Pair operand) {
            this.x += operand.x;
            this.y += operand.y;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }
}