import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by q on 04.07.2016.
 */
public class ReversTest {

    @Test
    public void rev() throws Exception {
        Revers revers=new Revers();

        assertTrue("вход 1234 выход 4321",revers.rev("12")=="21");

    }

}