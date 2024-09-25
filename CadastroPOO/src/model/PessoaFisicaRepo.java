package model;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas;
    
    public PessoaFisicaRepo(){
        pessoasFisicas = new ArrayList<>();
    }
    
    public void inserir(PessoaFisica pessoa){
        pessoasFisicas.add(pessoa);
    }
    
    public void alterar(int id, PessoaFisica novaPessoa) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == id) {
                pessoasFisicas.set(i, novaPessoa);
                return;
            }
        }
    }    
    
    public void excluir(int id) {
        pessoasFisicas.removeIf(p -> p.getId() == id);
    }
    
    public PessoaFisica obter(int id){
        for(PessoaFisica p : pessoasFisicas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public ArrayList<PessoaFisica> obterTodos(){
        return pessoasFisicas;
    }
}
