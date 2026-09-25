package padroescomportamentais.observer;

import java.util.Observable;

public class CentralDeAmeacas extends Observable {

    private String ipAlvo;
    private String tipoAmeaca;
    private Integer nivelRisco;

    public CentralDeAmeacas(String ipAlvo, String tipoAmeaca, Integer nivelRisco) {
        this.ipAlvo = ipAlvo;
        this.tipoAmeaca = tipoAmeaca;
        this.nivelRisco = nivelRisco;
    }

    public void detectarAmeaca() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "CentralDeAmeacas{" +
                "ipAlvo='" + ipAlvo + '\'' +
                ", tipoAmeaca='" + tipoAmeaca + '\'' +
                ", nivelRisco=" + nivelRisco +
                '}';
    }
}