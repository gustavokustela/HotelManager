package Control;
import DAO.FuncionarioDAO;
import Model.FuncionarioModel;

import java.util.List;

public class FuncionarioController {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    public void create(FuncionarioModel funcionario){
        funcionarioDAO.create(funcionario);
    }
    public FuncionarioModel read(int id){
        FuncionarioModel funcionario = funcionarioDAO.read(id);
        return funcionario;
    }
    public void update(FuncionarioModel toNew){
        FuncionarioModel current = read(toNew.getCodigo());
        current = merge(current, toNew);
        funcionarioDAO.update(current);
    }
    public void delete(int id){
        FuncionarioModel funcionario = read(id);
        funcionarioDAO.delete(funcionario);
    }

    public FuncionarioModel merge(FuncionarioModel current, FuncionarioModel toNew){
        current.setSalario(toNew.getSalario());
        current.setAdmin(toNew.isAdmin());
        current.setNome(toNew.getNome());
        current.setCpf(toNew.getCpf());
        current.setDataNasc(toNew.getDataNasc());
        current.setEndereco(toNew.getEndereco());
        current.setTelefone(toNew.getTelefone());
        current.setSexo(toNew.getSexo());
        return current;
    }

    public boolean Auth(String user, String pwd){
        return funcionarioDAO.Auth(user,pwd);
    }

    public List<FuncionarioModel> list() {
        return funcionarioDAO.list();
    }
}
