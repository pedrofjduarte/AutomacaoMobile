package br.com.chronosAcademy.appium;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    DriverFactory driverFactory;

    @BeforeEach
    public void inicializarDriver() throws MalformedURLException{
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android", "ChronosMobile", "uiautomator2"
                , "com.android.calculator2", "com.android.calculator2.Calculator");
        driverFactory.setDriver();
    }

    @Test
    public void validarMultiplicacao() throws MalformedURLException {
        clickId("digit_7");
        clickId("op_mul");
        clickId("digit_9");
        clickId("eq");
        String resultado = resultadoRetornado();
        assertEquals("63", resultado);
    }

    @Test
    public void validarSoma() throws MalformedURLException{
        clickId("digit_7");
        clickId("op_add");
        clickId("digit_9");
        clickId("eq");
        String resultado = resultadoRetornado();
        assertEquals("16", resultado);
    }

    @Test
    public void validarDivisao() throws MalformedURLException{
        clickId("digit_7");
        clickId("op_div");
        clickId("digit_9");
        clickId("eq");
        String resultado = resultadoRetornado();
        assertEquals("0.7777777777777", resultado);
    }

    public void clickId(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();
    }

    public String resultadoRetornado(){
        return driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
    }

    @AfterEach
    public void finalizarDriver(){
        driverFactory.getDriver().quit();
    }
}
