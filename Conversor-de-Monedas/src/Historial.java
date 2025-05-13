import java.util.List;

public class Historial {

    private List<String> conversiones;

    public Historial(List<String> conversiones) {
        this.conversiones = conversiones;
    }

    public List<String> getConversiones() {
        return conversiones;
    }

    public void setConversiones(List<String> conversiones) {
        this.conversiones = conversiones;
    }
}
