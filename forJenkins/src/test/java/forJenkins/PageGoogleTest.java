package forJenkins;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by q on 26.03.2017.
 */
public class PageGoogleTest {
    PageGoogle pg;
    @Before
 public    void before(){
    pg=new PageGoogle();
    }
    @After
  public   void after(){
        pg.quit();
        pg=null;
    }
    @Test
    public void testTitle() throws Exception {

        pg.getHome();
        assertTrue(pg.getTitle().equals("Google"));

    }

}