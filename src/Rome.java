import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public enum Rome {
    I(1), II(2), III(3), IV(4), V(5), VI(6),
    VII(7), VIII(8), IX(9), X(10),
    XX(20), XXX(30), XL(40), L(50),LX(60), LXX(70),
    LXXX(80), XC(90), C(100);

    int conv;
    Rome(int conv){
        this.conv = conv;
    }

    public int getConv(){
        return conv;
    }

    public static String getValue(int ararb){
        for (Rome r: values()){
            if(r.getConv() == ararb){
                return r.name();
            }
        }
        return "";
    }


    public static boolean isRoman(String value){
        for (Rome r: values()){
            if(r.name().equals(value)){
                return true;
            }
        }
        return false;
    }

    public static String convToRome(int ararb){
        int a = ararb / 10;
        int b = ararb % 10;
        return  getValue(a * 10) + getValue(b);
    }

    public static int convToArab(String rome){
        for (Rome r: values()){
            if(r.name().equals(rome)){
                return r.getConv();
            }
        }
        return -1;
    }

}
