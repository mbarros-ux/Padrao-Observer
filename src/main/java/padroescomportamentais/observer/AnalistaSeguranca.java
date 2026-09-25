package padroescomportamentais.observer;

import java.util.Observable;
import java.util.Observer;

public class AnalistaSeguranca implements Observer {

    private String nome;
    private String ultimoAlerta;

    public AnalistaSeguranca(String nome) {
        this.nome = nome;
    }

    public String getUltimoAlerta() {
        return this.ultimoAlerta;
    }

    public void subscrever(CentralDeAmeacas central) {
        central.addObserver(this);
    }

    @Override
    public void update(Observable central, Object arg) {
        this.ultimoAlerta = this.nome + ", ameaça detectada na " + central.toString();
    }
}