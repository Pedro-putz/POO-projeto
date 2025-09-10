/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todolist;

import java.util.Scanner;
import Operacoes.TarefaServico;
import pacote1.Tarefa;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaServico service = new TarefaServico(); 
        int opcao;
        
        do {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1 - Ver todas as tarefas");
            System.out.println("2 - Adicionar nova tarefa");
            System.out.println("3 - Editar tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Marcar tarefa como completa/incompleta");
            System.out.println("6 - Finalizar");
            System.out.print("Digite sua opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcao) {
                case 1:
                    verTarefas(service);
                    break;
                case 2:
                    adicionarTarefa(scanner, service);
                    break;
                case 3:
                    editarTarefa(scanner, service);
                    break;
                case 4:
                    excluirTarefa(scanner, service);
                    break;
                case 5:
                    toggleTarefa(scanner, service);
                    break;
                case 6:
                    System.out.println("Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
            
        } while (opcao != 6);
        
        scanner.close();
    }
    
    private static void verTarefas(TarefaServico service) {
        System.out.println("\n--- SUAS TAREFAS ---");
        if (service.listarTodas().isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada!");
            return;
        }
        
        for (Tarefa tarefa : service.listarTodas()) {
            String status = tarefa.isCompleta() ? "C" : "I";
            System.out.println(tarefa.getId() + " - " + status + " " + tarefa.getTitulo());
            System.out.println("   Descricao: " + tarefa.getDescricao());
            System.out.println("   Data: " + tarefa.getDataAgora());
            System.out.println("-----------------------------------");
        }
    }
    
    private static void adicionarTarefa(Scanner scanner, TarefaServico service) {
        System.out.println("\n--- NOVA TAREFA ---");
        System.out.print("Digite o titulo: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite a descricao: ");
        String descricao = scanner.nextLine();
        
        service.criarTarefa(titulo, descricao);
        System.out.println("Tarefa adicionada com sucesso!");
    }
    
    private static void editarTarefa(Scanner scanner, TarefaServico service) {
        System.out.println("\n--- EDITAR TAREFA ---");
        verTarefas(service); // Mostra as tarefas primeiro
        
        System.out.print("Digite o ID da tarefa que deseja editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Novo titulo: ");
        String novoTitulo = scanner.nextLine();
        
        System.out.print("Nova descricao: ");
        String novaDescricao = scanner.nextLine();
        
        if (service.atualizarTarefa(id, novoTitulo, novaDescricao)) {
            System.out.println("Tarefa atualizada com sucesso! ️");
        } else {
            System.out.println("Erro: Tarefa nao encontrada! ");
        }
    }
    
    private static void excluirTarefa(Scanner scanner, TarefaServico service) {
        System.out.println("\n--- EXCLUIR TAREFA ---");
        verTarefas(service); // Mostra as tarefas primeiro
        
        System.out.print("Digite o ID da tarefa que deseja excluir: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (service.removerTarefa(id)) {
            System.out.println("Tarefa excluida com sucesso!️");
        } else {
            System.out.println("Erro: Tarefa nao encontrada!");
        }
    }
    
    private static void toggleTarefa(Scanner scanner, TarefaServico service) {
        System.out.println("\n--- ALTERAR STATUS ---");
        verTarefas(service); // Mostra as tarefas primeiro
        
        System.out.print("Digite o ID da tarefa para alterar o status: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (service.toggleCompleta(id)) {
            System.out.println("Status alterado com sucesso!");
        } else {
            System.out.println("Erro: Tarefa nao encontrada!");
        }
    }
}