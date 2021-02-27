package ensta;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Random rand = new Random();
        int i = 0;
        while (i <500) {
            System.out.println(rand.nextInt(9)+1);
            ++i;
        }
        

    }
}
