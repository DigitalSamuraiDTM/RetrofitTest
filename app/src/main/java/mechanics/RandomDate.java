package mechanics;

import java.util.Random;

public  class RandomDate {
    public static String getRandomDate(){
        String returnData = "";
        Random random = new Random();
        int day =1+ random.nextInt(31);
        if (day<10){
            returnData+="0"+String.valueOf(day);
        } else{
            returnData+=String.valueOf(day);
        }
        returnData+=".";
        int month = 1+random.nextInt(12);

        if(month<10){
            returnData +="0"+String.valueOf(month);
        } else{
            returnData+=String.valueOf(month);
        }
        returnData+=".";
        returnData+=String.valueOf(2000+random.nextInt(21));
        return returnData;
    }
}
