package Week6.Friday.Test;

import Week6.Friday.Objects.Rectangle;
import java.util.Arrays;

public class testRect {
    public static void main(String[] args){
        Rectangle[] rect = {
                new Rectangle(12,2),
                new Rectangle(4,9),
                new Rectangle(5,4),
                new Rectangle(8,8),
                new Rectangle(5,2),
                new Rectangle(2,7),
        };

        System.out.println(Arrays.toString(rect));
        Arrays.sort(rect);
        System.out.println(Arrays.toString(rect));
    }
}
