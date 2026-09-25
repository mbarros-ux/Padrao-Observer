package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CentralDeAmeacasTest {

    @Test
    void deveNotificarAnalistaQuandoAmeacaForDetectada() {
        CentralDeAmeacas central = new CentralDeAmeacas("192.168.1.10", "DDoS", 9);
        AnalistaSeguranca analista = new AnalistaSeguranca("Maria");

        analista.subscrever(central);
        central.detectarAmeaca();

        assertTrue(analista.getUltimoAlerta().contains("Maria"));
        assertTrue(analista.getUltimoAlerta().contains("ameaça detectada"));
        assertTrue(analista.getUltimoAlerta().contains("DDoS"));
    }

    @Test
    void deveNotificarMultiplosAnalistas() {
        CentralDeAmeacas central = new CentralDeAmeacas("10.0.0.5", "Malware", 7);
        AnalistaSeguranca analista1 = new AnalistaSeguranca("Maria");
        AnalistaSeguranca analista2 = new AnalistaSeguranca("João");

        analista1.subscrever(central);
        analista2.subscrever(central);

        central.detectarAmeaca();

        assertTrue(analista1.getUltimoAlerta().contains("Maria"));
        assertTrue(analista2.getUltimoAlerta().contains("João"));
    }
}