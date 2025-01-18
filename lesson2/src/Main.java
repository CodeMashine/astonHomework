import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<Integer> test = new CustomArrayList<>(new Integer[]{1, 2, 3, 6});
        CustomArrayList<Integer> testAnother = new CustomArrayList<>(new Integer[]{1, 2, 6, 23});

        test.add(0, 0);
        System.out.println(test);
        test.add(2, 300);
        System.out.println(test);
        test.add(4, 48);
        System.out.println(test);
        test.add(6, 666);
        System.out.println(test);
        test.set(7, 777);
        System.out.println(test);

    }


}