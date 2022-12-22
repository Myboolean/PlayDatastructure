package main.array;



/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/18
 * Time: 16:03
 *
 * @author:pzj
 */
public class Test {
    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);
        arr.remove(2);
        arr.removeAllElement(4);
        arr.removeAllElement(2);
        arr.removeAllElement(3);
        arr.removeAllElement(5);
        arr.removeAllElement(7);
        arr.removeFirst();
        System.out.println(arr);
    }
}
