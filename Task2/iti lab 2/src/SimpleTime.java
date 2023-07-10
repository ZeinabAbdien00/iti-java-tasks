import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Formatter;

public class SimpleTime {
    long hour;
    int minuets = 0;
    int second = 0;
    float nanoSecond = 0;

    public SimpleTime(int hour,
                      int minuets,
                      int second,
                      float nanoSecond) {
        this.hour = hour;
        this.minuets = minuets;
        this.second = second;
        this.nanoSecond = nanoSecond;

    }

    public SimpleTime(
            float nanoSecond) {
        this.nanoSecond = nanoSecond;
    }

    public SimpleTime(
            int second) {
        this.second = second;
    }

    public SimpleTime(
            int hour,
            int minuets
    ) {
        this.minuets = minuets;
        this.hour = hour;

    }
    public long toSecondOfDay(){
        return hour*60*60L;
    }
    public long toNanoOfDay(){
        if(hour!=0 && minuets!=0){
            return hour* 3600000000000L + minuets*60000000000L;
        }
        else if (second!=0) {
            return second*1000000000L;
        }else {
            return (long) nanoSecond;
        }
    }
}
