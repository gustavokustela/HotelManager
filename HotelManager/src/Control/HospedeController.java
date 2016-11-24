package Control;
import DAO.HospedeDAO;
import Model.HospedeModel;

public class HospedeController {
    HospedeDAO hospedeDAO = new HospedeDAO();
    public void create(HospedeModel estada){
        hospedeDAO.create(estada);
    }
    public HospedeModel read(String id){
        HospedeModel estada = hospedeDAO.read(id);
        return estada;
    }
    public void update(HospedeModel toNew){
        HospedeModel current = read(toNew.getCpf());
        current = merge(current, toNew);
        hospedeDAO.update(current);
    }
    public void delete(String id){
        HospedeModel estada = read(id);
        hospedeDAO.delete(estada);
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
}
