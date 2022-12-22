package main.segmenttree;

/**
 * Created by IntelliJ IDEA.
 * User: pzj
 * Date: 2022/12/22
 * Time: 22:04
 *
 * @author:pzj
 */
public class Main {
    public static void main(String[] args) {
        Integer [] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTreeArray<Integer> segmentTreeArray = new SegmentTreeArray<>(
                nums,
                Integer::sum
        );
        System.out.println(segmentTreeArray);

    }
}
