package br.ufg.inf.es.cs.Calcular;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class CalcularTest {
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    
    @Test
    public void construtorPrivado() throws Exception {
        Constructor construtor = Calcular.class.getDeclaredConstructor();
        Assert.assertTrue(Modifier.isProtected(construtor.getModifiers()));
        construtor.setAccessible(true);
        construtor.newInstance();
    }
    
    @Test
    public void testMainCerto() {
        String[] args = new String[1];
        args[0] = "1+1";
        exit.expectSystemExitWithStatus(0);
        Calcular.main(args);
    }
    
    @Test
    public void testMainErrado() {
        String[] args = new String[1];
        args[0] = "";
        exit.expectSystemExitWithStatus(1);
        Calcular.main(args);
    }
    
    @Test
    public void testMainErrado2() throws Exception {
        String[] args = new String[1];
        args[0] = "";
        int exitValue = Calcular.executaCalculo(args[0]);
        exit.expectSystemExitWithStatus(exitValue);
        Calcular.main(args);
    }

    @Test
    public void executarParserTest1() throws Exception {
        String expressao = "1+1";
        Assert.assertEquals(0, Calcular.executaCalculo(expressao), 0);
    }
    
    @Test
    public void executarParserTest2() throws Exception {
        Assert.assertEquals(1, Calcular.executaCalculo(""), 0);
    }
    
}
