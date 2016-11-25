package Control;
import DAO.EstadaDAO;
import Model.EstadaModel;

import java.util.List;

public class EstadaController {
    EstadaDAO estadaDAO = new EstadaDAO();
    public void create(EstadaModel estada){
        estadaDAO.create(estada);
    }
    public EstadaModel read(Long id){
        EstadaModel estada = estadaDAO.read(id);
        return estada;
    }
    public void update(EstadaModel toNew){
        EstadaModel current = read(toNew.getCodigoIdentificacao());
        current = merge(current, toNew);
        estadaDAO.update(current);
    }
    public void delete(Long id){
        EstadaModel estada = read(id);
        estadaDAO.delete(estada);
    }

    public EstadaModel merge(EstadaModel current, EstadaModel toNew){
        current.setQuarto(toNew.getQuarto());
        current.setReserva(toNew.isReserva());
        return current;
    }

    public List<EstadaModel> list(){
        return estadaDAO.list();
    }
}
