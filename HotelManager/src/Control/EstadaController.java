package Control;
import DAO.EstadaDAO;
import Model.EstadaModel;

import java.util.List;

public class EstadaController {
    EstadaDAO estadaDAO = new EstadaDAO();
    public void create(EstadaModel estada){
        estadaDAO.create(estada);
    }
    public EstadaModel read(int codHosp){
        return estadaDAO.read(codHosp);
    }
    public void update(EstadaModel toNew){
        EstadaModel current = read((int) toNew.getCodigoIdentificacao());
        current = merge(current, toNew);
        estadaDAO.update(current);
    }
    public void delete(int id){
        EstadaModel estada = read(id);
        estadaDAO.delete(estada);
    }

    public EstadaModel merge(EstadaModel current, EstadaModel toNew){
        current.setQuarto(toNew.getQuarto());
        current.setReserva(toNew.getReserva());
        return current;
    }

    public List<EstadaModel> listActive(){
        return estadaDAO.listActive();
    }

    public List<EstadaModel> listAll(){ return estadaDAO.listAll(); }

    public boolean isActive(int hospCod){ return estadaDAO.isActive(hospCod); }

    public void checkOut(int hospCod) { estadaDAO.checkout(hospCod); }

    public boolean findReserva(int hospCod) {
        return estadaDAO.findReserva(hospCod);
    }

    public void checkInReserva(int hospCod) {
        estadaDAO.checkInReserva(hospCod);
    }

    public boolean itsFree(String nroQuarto) {
        return estadaDAO.itsFree(nroQuarto);
    }
}
