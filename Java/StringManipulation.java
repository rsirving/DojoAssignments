public class StringManipulation {
    public String trimAndConcat(String string1, String string2){
        return string1.trim() + string2.trim();
    }

    public Integer getIndexOrNull(String string, char letter) {
        int index = string.indexOf(letter);
        if (index == -1){
            return null;
        } else {
            return index;
        }
    }

    public Integer getIndexOrNull(String string1, String string2) {
        int index = string1.indexOf(string2);
        if (index == -1) {
            return null;
        } else {
            return index;
        }
    }

    public String concatSubstring(String string1, int start, int end, String string2) {
        String subString = string1.substring(start, end);
        return subString + string2;
    }
}