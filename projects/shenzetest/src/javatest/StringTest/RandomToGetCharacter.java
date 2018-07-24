// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.StringTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomToGetCharacter {

    private final PatternRange hiraganaSmall = new PatternRange(Arrays.asList(new String[] { "\\u3041", "\\u3043",
            "\\u3045", "\\u3047", "\\u3049", "\\u3063", "\\u3083", "\\u3085", "\\u3087", "\\u308E", "\\u3095",
            "\\u3096" }));

    private final PatternRange katakanaSmall = new PatternRange(3,
            Arrays.asList(new Integer[] { 0X31F0, 16, 0XFF67, 8 }), Arrays.asList(new String[] { "\\u30A1", "\\u30A3",
                    "\\u30A5", "\\u30A7", "\\u30A9", "\\u30C3", "\\u30E3", "\\u30E5", "\\u30E7", "\\u30EE", "\\u30F5",
                    "\\u30F6" }));

    private final PatternRange katakana = new PatternRange(2, Arrays.asList(new Integer[] { 0X31F0, 16, 0XFF67, 8 }),
            new ArrayList<String>());

    public static void main(String[] args) {
        RandomToGetCharacter randomToGetCharacter = new RandomToGetCharacter();
        System.out.println(randomToGetCharacter.katakana.getChar(1, 2));
        System.out.println(randomToGetCharacter.hiraganaSmall.getChar(2, 3));
        System.out.println(randomToGetCharacter.katakanaSmall.getChar(3, 4));
    }

    class PatternRange {

        int partSize = 1;

        List<String> economyCharacters = new ArrayList<>();

        List<Integer> partStartPoint = new ArrayList<>();

        public PatternRange(List<String> economyCharacters) {
            this.economyCharacters = economyCharacters;
        }

        public PatternRange(int partSize, List<Integer> partStartPoint, List<String> economyCharacters) {
            this.partSize = partSize;
            this.partStartPoint = partStartPoint;
            this.economyCharacters = economyCharacters;
        }

        public String getChar(int random1, int random2) {
            int collectionSize = partStartPoint.size() / 2;
            int partIndex = random1 % partSize;
            if (collectionSize > partIndex) {
                Integer startPoint = partStartPoint.get(partIndex * 2);
                Integer collectSize = partStartPoint.get(partIndex * 2 + 1);
                Integer result = startPoint + random2 % collectSize;
                return encodingTest.decode(encodingTest.convertUnicode(result));
            } else {
                int economysize = this.economyCharacters.size();
                return encodingTest.decode(economyCharacters.get(random2 % economysize));
            }
        }
    }

}
