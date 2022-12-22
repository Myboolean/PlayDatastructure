package main.queue;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/19
 * Time: 10:41
 *
 * @author:pzj
 */
public interface Queue <E>{
    int getSize();
    boolean isEmpty();
    void push(E e);
    E front();
    E pop();
}
