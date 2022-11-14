package dao;

//tudo okay

public interface OperacoesDAO<T> {
	
	public boolean inserir (T e);
    
    public boolean excluir (int id);
    
    public boolean editar (T e);
    
    public T pesquisar (int id);
   
}
