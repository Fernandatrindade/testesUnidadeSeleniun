package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LojinhaWebTest {
    private WebDriver navegador;

    @Before
    public void abriNavegador() {
            // Preparação
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sankhya\\Documents\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");
        // Login com úsuario admin e senha adm
        navegador.findElement(By.cssSelector("#usuario")).sendKeys("fernanda_rodrigues");
        navegador.findElement(By.id("senha")).sendKeys("teste123");
        navegador.findElement(By.cssSelector(".btn")).click();
    }


    @Test
    public void testValidarDadosDeumProduto() {

        // Acessar o produto PS4 na lista de produtos
        navegador.findElements(By.linkText("PS4")).get(0).click();

        // Validação do nome do Produto e do nome do primeiro Componente
        String produtoNome = navegador.findElement(By.cssSelector("#produtonome")).getAttribute("value");
        Assert.assertEquals("PS4", produtoNome);

        String componenteNome = navegador.findElements(By.cssSelector(".title")).get(1).getText();
        Assert.assertEquals("Lojinha Memory Card", componenteNome);


    }
    @Test
    public void cadastrarProdutos(){

        //Adicionar produtos
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();
        navegador.findElement(By.id("produtonome")).sendKeys("Nintendo");
        navegador.findElement(By.id("produtovalor")).sendKeys("1000,00");
        navegador.findElement(By.id("produtocores")).sendKeys("Azul");
        navegador.findElement(By.xpath("//button[text()='Salvar']")).click();

        //Validar a mensagem de produto adicionada
        String mensagem = navegador.findElement(By.cssSelector(".toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", mensagem);

    }
    @After
    public void fechaNavegador(){
        //Fechar navegador
        navegador.quit();
    }
}
