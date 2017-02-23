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
package javatest.enumTest;

/**
 * Enumeration of the email verify result.
 */
public enum EmailVerifyResult {

    VALID("VALID"), //$NON-NLS-1$
    INVALID("INVALID"), //$NON-NLS-1$
    CORRECTED("CORRECTED"), //$NON-NLS-1$
    VERIFIED("VERIFIED"), //$NON-NLS-1$
    REJECTED("REJECTED"); //$NON-NLS-1$

    private String resultValue;

    private String suggestedEmail;

    private EmailVerifyResult(String resultValue) {
        this.resultValue = resultValue;
    }

    /**
     * Getter for resultValue.
     * 
     * @return the resultValue
     */
    public String getResultValue() {
        return this.resultValue;
    }

    /**
     * Getter for suggestedEmail.
     * 
     * @return the suggestedEmail
     */
    public String getSuggestedEmail() {
        return this.suggestedEmail;
    }

    /**
     * Sets the suggestedEmail.
     * 
     * @param suggestedEmail the suggestedEmail to set
     */
    public void setSuggestedEmail(String suggestedEmail) {
        this.suggestedEmail = suggestedEmail;
    }

    // /**
    // * get type by component value".
    // *
    // * @param value
    // * @return the type corresponding to the component value
    // */
    // public static EmailVerifyResult getResult(String value) {
    // for (EmailVerifyResult type : values()) {
    // if (type.resultValue.equals(value)) {
    // return type;
    // }
    // }
    // return null;
    // }

}
