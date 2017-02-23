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
package apache;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.Soundex;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class SoundexTest {

    public static void main(String args[]) throws EncoderException {
        Soundex soundex = new Soundex();
        int diff = soundex.difference("jngr", "dnéee");
        System.out.println(diff);
    }
}
