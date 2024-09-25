package model;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas;
    
    public PessoaJuridicaRepo(){
        pessoasJuridicas = new ArrayList<>();
    }
    
    public void inserir(PessoaJuridica pessoa){
        pessoasJuridicas.add(pessoa);
    }
    
    public void alterar(int id, PessoaJuridica novaPessoa) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == id) {
                pessoasJuridicas.set(i, novaPessoa);
                return;
            }
        }
    }    
    
    public void excluir(int id) {
        pessoasJuridicas.removeIf(p -> p.getId() == id);
    }
    
    public PessoaJuridica obter(int id){
        for(PessoaJuridica p : pessoasJuridicas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos(){
        return pessoasJuridicas;
    }
}