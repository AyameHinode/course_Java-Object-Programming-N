package lessons;

import br.ce.wcaquino.entidades.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {

    @Test
    public void asserts() {

        Assert.assertTrue(true);
        Assert.assertFalse(false);

        Assert.assertEquals("Erro de comparacao", 2, 2);
        Assert.assertEquals(1,1);
        Assert.assertEquals(0.61345, 0.613, 0.001);
        Assert.assertEquals(Math.PI, 3.14, 0.01);

        int i = 1;
        Integer i2 = 1;
        Assert.assertEquals(Integer.valueOf(1), i2);
        Assert.assertEquals(i, i2.intValue());
        Assert.assertEquals("bola", "bola");
        Assert.assertNotEquals("bola", "casa");
        Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
        Assert.assertTrue("bola".startsWith("bo"));

        Usuario user1 = new Usuario("Usuario 1");
        Usuario user2 = new Usuario("Usuario 2");
        Usuario user3 = null;

        Assert.assertNotEquals(user1, user2);
        Assert.assertNotSame(user1, user2);
        Assert.assertNotSame(user1, user2);
        Assert.assertNull(user3);

    }

}
