package main.setandmap;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/21
 * Time: 17:34
 *
 * @author:pzj
 */
public class Main {
    public static void main(String[] args) {
        LinkedListSet<Integer> listSet = new LinkedListSet<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            listSet.add(random.nextInt(5));
        }
        System.out.println(listSet);
        listSet.remove(1);
        System.out.println(listSet);
        TreeSet<Integer> set = new TreeSet<>();
    }
}
