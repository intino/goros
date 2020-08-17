package io.intino.goros.builder.util;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StringUtil {
    public StringUtil() {
    }

    public static String firstUpperCase(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    public static String stripAccents(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return s;
    }

    public static String firstLowerCase(String value) {
        return value.substring(0, 1).toLowerCase() + value.substring(1);
    }

    public static String camelCaseToSnakeCase(String string) {
        if (string.isEmpty()) {
            return string;
        } else {
            String result = String.valueOf(Character.toLowerCase(string.charAt(0)));

            for(int i = 1; i < string.length(); ++i) {
                result = result + (Character.isUpperCase(string.charAt(i)) ? "-" + Character.toLowerCase(string.charAt(i)) : string.charAt(i));
            }

            return result;
        }
    }

    public static String snakeCaseToCamelCase(String string) {
        if (string.isEmpty()) {
            return string;
        } else {
            String result = "";
            String[] var2 = string.replace("_", "-").split("-");
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String part = var2[var4];
                result = result + String.valueOf(Character.toUpperCase(part.charAt(0))) + part.substring(1);
            }

            return result;
        }
    }

    public static String replaceSpecialChars(String sData, String sReplacement) {
        sData = sData.replaceAll("\n", sReplacement);
        sData = sData.replaceAll("\r", sReplacement);
        sData = sData.replaceAll("\t", sReplacement);
        return sData;
    }

    public static String cleanSpecialChars(String sData) {
        return replaceSpecialChars(sData, "");
    }

    public static String capitalize(String sContent) {
        char[] aChars = sContent.toCharArray();
        aChars[0] = Character.toUpperCase(aChars[0]);
        return new String(aChars);
    }

    public static String cleanAccents(String sData) {
        sData = sData.replaceAll("á", "a");
        sData = sData.replaceAll("à", "a");
        sData = sData.replaceAll("â", "a");
        sData = sData.replaceAll("ã", "a");
        sData = sData.replaceAll("ª", "a");
        sData = sData.replaceAll("�?", "A");
        sData = sData.replaceAll("À", "A");
        sData = sData.replaceAll("Â", "A");
        sData = sData.replaceAll("Ã", "A");
        sData = sData.replaceAll("é", "e");
        sData = sData.replaceAll("è", "e");
        sData = sData.replaceAll("ê", "e");
        sData = sData.replaceAll("É", "E");
        sData = sData.replaceAll("È", "E");
        sData = sData.replaceAll("Ê", "E");
        sData = sData.replaceAll("ó", "o");
        sData = sData.replaceAll("ò", "o");
        sData = sData.replaceAll("ô", "o");
        sData = sData.replaceAll("õ", "o");
        sData = sData.replaceAll("º", "o");
        sData = sData.replaceAll("Ó", "O");
        sData = sData.replaceAll("Ò", "O");
        sData = sData.replaceAll("Ô", "O");
        sData = sData.replaceAll("Õ", "O");
        sData = sData.replaceAll("ú", "u");
        sData = sData.replaceAll("ù", "u");
        sData = sData.replaceAll("û", "u");
        sData = sData.replaceAll("Ú", "U");
        sData = sData.replaceAll("Ù", "U");
        sData = sData.replaceAll("Û", "U");
        sData = sData.replaceAll("í", "i");
        sData = sData.replaceAll("ì", "i");
        sData = sData.replaceAll("î", "i");
        sData = sData.replaceAll("�?", "I");
        sData = sData.replaceAll("Ì", "I");
        sData = sData.replaceAll("Î", "I");
        sData = sData.replaceAll("ç", "c");
        sData = sData.replaceAll("Ç", "C");
        sData = sData.replaceAll("ñ", "n");
        sData = sData.replaceAll("Ñ", "N");
        return sData;
    }

    public static String removeBrackets(String sData) {
        sData = sData.replaceAll("\\[", "");
        sData = sData.replaceAll("\\]", "");
        return sData;
    }

    public static String cleanString(String sContent, String sAlphabet) {
        String sAux = sContent;

        for(int iPos = 0; iPos < sContent.length(); ++iPos) {
            String sChar = sContent.substring(iPos, iPos + 1);
            if (sAlphabet.indexOf(sChar.toLowerCase()) == -1) {
                sAux = sAux.replace(sChar, "");
            }
        }

        return sAux;
    }

    public static String cleanString(String sContent) {
        return cleanString(sContent, "abcdefghijklmnopqrstuvwxyz1234567890");
    }

    public static String[] getKeywords(String sData, Integer iMinLength) {
        HashMap<String, String> hmKeywords = new HashMap();
        StringTokenizer tok = new StringTokenizer(sData);

        while(true) {
            String sToken;
            do {
                if (!tok.hasMoreTokens()) {
                    return (String[])hmKeywords.keySet().toArray(new String[0]);
                }

                sToken = tok.nextToken();
                sToken = cleanString(sToken, "abcdefghijklmnopqrstuvwxyz1234567890");
            } while(iMinLength != null && sToken.length() <= iMinLength);

            hmKeywords.put(sToken.toLowerCase(), sToken.toLowerCase());
        }
    }

    public static String[] getKeywordsWithEmpty(String data) {
        String[] keyWordsArray = getKeywords(data, (Integer)null);
        if (keyWordsArray.length <= 0) {
            keyWordsArray = new String[]{""};
        }

        return keyWordsArray;
    }

    public static int getLevenshteinDistance(String s, String t) {
        if (s != null && t != null) {
            int n = s.length();
            int m = t.length();
            if (n == 0) {
                return m;
            } else if (m == 0) {
                return n;
            } else {
                int[] p = new int[n + 1];
                int[] d = new int[n + 1];

                int i;
                for(i = 0; i <= n; p[i] = i++) {
                }

                for(int j = 1; j <= m; ++j) {
                    int t_j = t.charAt(j - 1);
                    d[0] = j;

                    for(i = 1; i <= n; ++i) {
                        int cost = s.charAt(i - 1) == t_j ? 0 : 1;
                        d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
                    }

                    int[] _d = p;
                    p = d;
                    d = _d;
                }

                return p[n];
            }
        } else {
            return -1;
        }
    }

    public static String replaceAll(String sContent, String sValue, String sReplacement) {
        for(Integer iPos = sContent.indexOf(sValue); iPos != -1; iPos = sContent.indexOf(sValue)) {
            String sLeftSide = sContent.substring(0, iPos);
            String sRightSide = sContent.substring(iPos + sValue.length());
            sContent = sLeftSide + sReplacement + sRightSide;
            sContent.substring(0, iPos);
        }

        return sContent;
    }

    public static String generatePassword() {
        String sPassword = "";
        String[] aSyllables = new String[]{"er", "in", "tia", "wol", "fe", "pre", "vet", "jo", "nes", "al", "len", "son", "cha", "ir", "ler", "bo", "ok", "tio", "nar", "sim", "ple", "bla", "ten", "toe", "cho", "co", "lat", "spe", "ak", "er", "po", "co", "lor", "pen", "cil", "li", "ght", "wh", "at", "the", "he", "ck", "is", "mam", "bo", "no", "fi", "ve", "any", "way", "pol", "iti", "cs", "ra", "dio", "sou", "rce", "sea", "rch", "pa", "per", "com", "bo", "sp", "eak", "st", "fi", "rst", "gr", "oup", "boy", "ea", "gle", "tr", "ail", "bi", "ble", "brb", "pri", "dee", "kay", "en", "be", "se"};

        for(Integer iCount = 1; iCount <= 4; iCount = iCount + 1) {
            if (Math.random() % 10.0D == 1.0D) {
                sPassword = sPassword + Integer.toString(Math.round((float)(Math.round(Math.random() % 50.0D) + 1L)));
            } else {
                sPassword = sPassword + aSyllables[Math.round((float)Math.round(Math.random() % 62.0D))];
            }
        }

        return sPassword;
    }

    public static String implodeAndWrap(String[] aObject, String sDelimiter, String sWrapper) {
        String sResult = "";

        for(int iPos = 0; iPos < aObject.length; ++iPos) {
            if (iPos != 0) {
                sResult = sResult + sDelimiter;
            }

            sResult = sResult + (sWrapper != null ? sWrapper : "");
            sResult = sResult + aObject[iPos];
            sResult = sResult + (sWrapper != null ? sWrapper : "");
        }

        return sResult;
    }

    public static String toJavaIdentifier(String aString) {
        String identifier = toAttributeJavaIdentifier(aString);
        return Character.toUpperCase(identifier.charAt(0)) + identifier.substring(1);
    }

    public static String toAttributeJavaIdentifier(String aString) {
        StringBuffer res = new StringBuffer();
        int idx = 0;
        boolean toUpper = false;

        while(idx < aString.length()) {
            char c = aString.charAt(idx++);
            if (Character.isJavaIdentifierPart(c)) {
                if (toUpper) {
                    c = Character.toUpperCase(c);
                    toUpper = false;
                }

                res.append(c);
            } else {
                toUpper = true;
            }
        }

        return res.toString();
    }

    public static class DummyValue {
        private String sValue;

        public DummyValue(String sValue) {
            this.sValue = sValue;
        }

        public String getValue() {
            return this.sValue;
        }
    }
}
