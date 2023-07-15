import java.util.HashMap;

public class Main {

    static String fasterRunner;
    static String secondFasterRunner;
    static Integer valueFasterRunner;
    static Integer valueSecondFasterRunner;

    public static void main(String[] args) {


        HashMap<String, Integer> marathon = new HashMap<>();
        marathon.put("Ahmed", 341);
        marathon.put("Mohamed ", 273);
        marathon.put("Ismail", 278);
        marathon.put("Hend", 329);
        marathon.put("Aly", 445);
        marathon.put("Hossam", 402);
        marathon.put("Ola", 388);
        marathon.put("Alaa", 275);
        marathon.put("Basma", 243);
        marathon.put("Nada", 412);
        marathon.put("Mina", 334);
        marathon.put("Saad", 393);


        fasterRunner = marathon.keySet().toArray()[0].toString();
        secondFasterRunner = marathon.keySet().toArray()[0].toString();

        valueFasterRunner = marathon.get(fasterRunner);
        valueSecondFasterRunner = marathon.get(secondFasterRunner);

        marathon.forEach((key, value) -> {

            if (value > valueFasterRunner){
                fasterRunner = key;
                valueFasterRunner = value;
            }
        });
        System.out.println(fasterRunner);

        marathon.forEach((key, value) -> {
            if (value < marathon.get(fasterRunner) && value > valueSecondFasterRunner){
                secondFasterRunner = key;
                valueSecondFasterRunner = value;
            }

        });
        System.out.println(secondFasterRunner);
    }
}










