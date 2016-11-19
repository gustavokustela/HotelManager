package Control;

import DAO.QuartoDAO;
import Model.QuartoModel;

public class QuartoController {
    public void create(QuartoModel estada){
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.create(estada);
    }
    public QuartoModel read(Long id){
        QuartoDAO quartoDAO = new QuartoDAO();
        QuartoModel estada = quartoDAO.read(id);
        return estada;
    }
    public void update(QuartoModel toNew){
        QuartoDAO quartoDAO = new QuartoDAO();
        QuartoModel current = read(toNew.getNumero());
        current = merge(current, toNew);
        quartoDAO.update(current);
    }
    public void delete(Long id){
        QuartoDAO quartoDAO = new QuartoDAO();
        QuartoModel estada = read(id);
        quartoDAO.delete(estada);
    }

    public QuartoModel merge(QuartoModel current, QuartoModel toNew){
        current.setNumero(toNew.getNumero());
        current.setAndar(toNew.getAndar());
        current.setSuiteEspecial(toNew.isSuiteEspecial());
        current.setQtdCamasSolteiro(toNew.getQtdCamasSolteiro());
        current.setQtdCamasCasal(toNew.getQtdCamasCasal());
        current.setAreaM2(toNew.getAreaM2());
        current.setValorDiaria(toNew.getValorDiaria());
        return current;
    }
}
