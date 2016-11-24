package Control;
import DAO.HospedeDAO;
import Model.HospedeModel;

import java.util.List;

public class HospedeController {
    HospedeDAO hospedeDAO = new HospedeDAO();
    public void create(HospedeModel hospede){
        hospedeDAO.create(hospede);
    }
    public HospedeModel read(String id){
        HospedeModel hospede = hospedeDAO.read(id);
        return hospede;
    }
    public void update(HospedeModel toNew){
        HospedeModel current = read(toNew.getCpf());
        current = merge(current, toNew);
        hospedeDAO.update(current);
    }
    public void delete(String id){
        HospedeModel hospede = read(id);
        hospedeDAO.delete(hospede);
    }

    public HospedeModel merge(HospedeModel current, HospedeModel toNew){
        current.setEstrangeiro(toNew.isEstrangeiro());
        current.setNome(toNew.getNome());
        current.setCpf(toNew.getCpf());
        current.setDataNasc(toNew.getDataNasc());
        current.setEndereco(toNew.getEndereco());
        current.setTelefone(toNew.getTelefone());
        current.setSexo(toNew.getSexo());
        return current;
    }

    public List<HospedeModel> list(){
        return hospedeDAO.list();
    }
}
