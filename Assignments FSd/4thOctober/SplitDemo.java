import java.util.*;


 class SplitDemo {
    public static void main(String[] args) {
        String inputStr = "AkhilAjayAbhinavAkshayAAAAtyu";
        String strDelimiter = "A";
        
        System.out.println("Splits are:");
        for (String var : splitStrings(inputStr, strDelimiter)) {
            System.out.println(var);
        }
    }

    static String[] splitStrings(String inputStr, String strDelimiter){
        List<String> strings = new ArrayList<String>();
        String tempString;
        int itr = 0;
        boolean flag = true;
        
        if(inputStr.contains(strDelimiter)){
            tempString = inputStr;
            do{
                int loc = tempString.indexOf(strDelimiter);
                strings.add(tempString.substring(0, loc));
                tempString = tempString.substring(loc+strDelimiter.length(), tempString.length());
                if(!tempString.contains(strDelimiter)){
                    strings.add(tempString);
                    flag=false;
                }
            } while(flag);
        } else {
            strings.add(inputStr);
        }
        String[] tokens = new String[strings.size()];
        tokens = strings.toArray(tokens);
        return tokens;
    }
}
