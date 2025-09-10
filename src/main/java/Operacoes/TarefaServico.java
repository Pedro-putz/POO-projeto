package Operacoes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import pacote1.Tarefa;

public class TarefaServico {

    private ArrayList<Tarefa> tarefas;
    private int proximoId;

    public TarefaServico() {
        this.tarefas = new ArrayList<>();
        this.proximoId = 1;
    }
    
    // CREATE - Criar tarefa
    public void criarTarefa(String titulo, String descricao) {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setId(proximoId++); 
        novaTarefa.setTitulo(titulo);
        novaTarefa.setDescricao(descricao);
        novaTarefa.setCompleta(false); 
        novaTarefa.setDataAgora((int) (System.currentTimeMillis() / 1000));
        tarefas.add(novaTarefa); 
    }
    
    // READ - Listar todas as tarefas
    public ArrayList<Tarefa> listarTodas() {
        return tarefas; 
    }
    
    // READ - Buscar tarefa por ID
    public Tarefa buscarPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }
    
    // UPDATE - Atualizar tarefa
    public boolean atualizarTarefa(int id, String novoTitulo, String novaDescricao) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            return true;
        }
        return false;
    }
    
    // DELETE - Remover tarefa
    public boolean removerTarefa(int id) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefas.remove(tarefa);
            return true;
        }
        return false;
    }
    
    // UPDATE - Alternar status completo/incompleto
    public boolean toggleCompleta(int id) {
        Tarefa tarefa = buscarPorId(id);
        if (tarefa != null) {
            tarefa.setCompleta(!tarefa.isCompleta());
            return true;
        }
        return false;
    }
    
    // READ - Buscar tarefas por status
    public ArrayList<Tarefa> buscarPorStatus(boolean completa) {
        ArrayList<Tarefa> resultado = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isCompleta() == completa) {
                resultado.add(tarefa);
            }
        }
        return resultado;
    }
    
    // Estatísticas - Total de tarefas
    public int getTotalTarefas() {
        return tarefas.size();
    }
    
    // Estatísticas - Tarefas pendentes
    public int getTarefasPendentes() {
        int count = 0;
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isCompleta()) {
                count++;
            }
        }
        return count;
    }
    
    // Estatísticas - Tarefas concluídas
    public int getTarefasConcluidas() {
        int count = 0;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isCompleta()) {
                count++;
            }
        }
        return count;
    }
    
    // Limpar todas as tarefas (reset)
    public void limparTodas() {
        tarefas.clear();
        proximoId = 1;
    }
}
