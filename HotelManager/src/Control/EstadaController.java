package Control;
import DAO.EstadaDAO;
import Model.EstadaModel;

public class EstadaController {
    public void create(EstadaModel estada){
        EstadaDAO estadaDAO = new EstadaDAO();
        estadaDAO.create(estada);
    }
    public EstadaModel read(Long id){
        EstadaDAO estadaDAO = new EstadaDAO();
        EstadaModel estada = estadaDAO.read(id);
        return estada;
    }
    public void update(EstadaModel toNew){
        EstadaDAO estadaDAO = new EstadaDAO();
        EstadaModel current = read(toNew.getCodigoIdentificacao());
        current = merge(current, toNew);
        estadaDAO.update(current);
    }
    public void delete(Long id){
        EstadaDAO estadaDAO = new EstadaDAO();
        EstadaModel estada = read(id);
        estadaDAO.delete(estada);
    }

    public EstadaModel merge(EstadaModel current, EstadaModel toNew){
        current.setQuarto(toNew.getQuarto());
        current.setReserva(toNew.isReserva());
        return current;
    }
}
