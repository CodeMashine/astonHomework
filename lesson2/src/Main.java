import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;
import java.lang.reflect.Field;
import java.util.*;
//import java.util.HashMap$TreeNode;


public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        testCustomArrayList();
        testHashMap();
    }


    public static void testHashMap() throws NoSuchFieldException, IllegalAccessException {
//        перестроение связного списка в дерево при добавлении больше 8элементов с одинаковым хешем,
//                обратное перестроение с дерева в связный список при достижении 4 элементов в дереве

        HashMap<Key, Integer> hash = new HashMap<>();
        ArrayList<Key> keyList1 = new ArrayList<>();
        ArrayList<Key> keyList2 = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            keyList1.add(new Key("test" + i));
            hash.put(keyList1.get(i), 5);
        }

        for (int i = 0; i < 8; i++) {
            keyList2.add(new Key("rest" + i));
            hash.put(keyList2.get(i), 5);
        }

//        for (Map.Entry<Key, Integer> elem : hash.entrySet()) {
//            System.out.println(elem.getKey().name + "-" + elem.getClass());
//        }

        for (int i = 0; i < 21; i++) {
            hash.remove(keyList1.get(i));
        }

        for (Map.Entry<Key, Integer> elem : hash.entrySet()) {
            System.out.println("name " + elem.getKey().name + " hash " + "-" + elem.getKey() + " - " + elem.getClass());
        }

        for (int i = 0; i < 4; i++) {
            hash.put(keyList1.get(i), 8);
        }

        for (Map.Entry<Key, Integer> elem : hash.entrySet()) {
            System.out.println("name " + elem.getKey().name + " hash " + "-" + elem.getKey() + " - " + elem.getClass());
        }


    }


    public static void testCustomArrayList() {
        CustomArrayList<Integer> test = new CustomArrayList<>(new Integer[]{1, 2, 3, 6});
        CustomArrayList<Integer> testAnother = new CustomArrayList<>(new Integer[]{1, 2, 3, 6});


        System.out.println(test.contains(5));
//        test.add(0, 0);
//        System.out.println(test);
//        test.add(2, 300);
//        System.out.println(test);
//        test.add(4, 48);
//        System.out.println(test);
//        test.add(6, 666);
//        System.out.println(test);
//        test.set(7, 777);
//        System.out.println(test);
    }


}