package Control;

import DAO.QuartoDAO;
import Model.QuartoModel;

import java.util.List;

public class QuartoController {
    QuartoDAO quartoDAO = new QuartoDAO();
    public void create(QuartoModel quarto){
        quartoDAO.create(quarto);
    }
    public QuartoModel read(int numQuarto){
        return quartoDAO.read(numQuarto);
    }
    public void update(QuartoModel toNew){
        QuartoModel current = read(toNew.getNumero());
        current = merge(current, toNew);
        quartoDAO.update(current);
    }
    public void delete(int id){
        QuartoModel quarto = read(id);
        quartoDAO.delete(quarto);
    }

    public QuartoModel merge(QuartoModel current, QuartoModel toNew){
        current.setNumero(toNew.getNumero());
        current.setAndar(toNew.getAndar());
        current.setSuiteEspecial(toNew.getSuiteEspecial());
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
