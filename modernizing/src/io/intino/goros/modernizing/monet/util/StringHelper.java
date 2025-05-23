package io.intino.goros.modernizing.monet.util;

public class StringHelper {
    public StringHelper() {
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
}
