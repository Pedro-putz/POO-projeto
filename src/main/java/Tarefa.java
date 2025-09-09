/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private int dataAgora;

    // getting para id
    public int getId() {
        return this.id;
    }

    // getting para titulo
    public String getTitulo() {
        return this.titulo;
    }

    // getting para descricao
    public String getDescricao() {
        return this.descricao;
    }

    // getting para completa
    public boolean isCompleta() {
        return this.completa;
    }

    // getting para dataAgora
    public int getDataAgora() {
        return this.dataAgora;
    }

}
