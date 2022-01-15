import org.junit.Test;

import static org.junit.Assert.*;

public class PersonajeTest {

    @Test
    public void setBolsaOKVacia() {
        System.out.println("TEST Personaje - setBolsa - OK - Bolsa vacia");
        Bolsa b = new Bolsa("Bolsa1",90);
        Personaje p = new Personaje("Alfredo",100,90);
        p.setBolsa(b);
        assertEquals("Asigna bolsa",b,p.getBolsa());
    }

}
