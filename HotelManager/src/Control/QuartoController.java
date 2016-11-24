package Control;

import DAO.QuartoDAO;
import Model.QuartoModel;

import java.util.List;

public class QuartoController {
    QuartoDAO quartoDAO = new QuartoDAO();
    public void create(QuartoModel estada){
        quartoDAO.create(estada);
    }
    public QuartoModel read(Long id){
        QuartoModel estada = quartoDAO.read(id);
        return estada;
    }
    public void update(QuartoModel toNew){
        QuartoModel current = read(toNew.getNumero());
        current = merge(current, toNew);
        quartoDAO.update(current);
    }
    public void delete(Long id){
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

    public List<QuartoModel> list() {
        return quartoDAO.list();
    }
}
