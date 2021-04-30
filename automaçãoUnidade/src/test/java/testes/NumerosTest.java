package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    private Numeros numeros;

    @Before
    public void setUp() {
        //Vou ultilizar o método eUmaUnidade passando o valor 9, que trata-se de uma unidade
        Numeros numeros = new Numeros();
    }


    @Test
    public void testeValidarSeUmNumeroEUmaUnidade() {


        boolean eUnidade = numeros.eUmaUnidade(9);

        //Vou validar que a resposta é verdadeira
        Assert.assertTrue(eUnidade);

    }

    @Test
    public void testeValidarSeUmNumeroEMaior() {
        boolean eUnidade = numeros.eUmaUnidade(10);

        //Valordar que a resposta e verdadeira
        Assert.assertFalse(eUnidade);
    }

}
