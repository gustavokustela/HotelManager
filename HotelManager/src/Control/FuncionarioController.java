package Control;
import DAO.FuncionarioDAO;
import Model.FuncionarioModel;

public class FuncionarioController {
    public void create(FuncionarioModel funcionario){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.create(funcionario);
    }
    public FuncionarioModel read(Long id){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FuncionarioModel funcionario = funcionarioDAO.read(id);
        return funcionario;
    }
    public void update(FuncionarioModel toNew){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        FuncionarioModel current = read(toNew.getCodigo());
        current = merge(current, toNew);
        funcionarioDAO.update(current);
    }
    public void delete(Long id){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
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
}
