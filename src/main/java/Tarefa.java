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
    
    //setting para id
    public void setId(int id){
        this.id= id;
    }
    
    // getting para titulo
    public String getTitulo() {
        return this.titulo;
    }

        //setting para titulo
    public void setTitulo(String titulo){
        this.titulo= titulo;
    }
    // getting para descricao
    public String getDescricao() {
        return this.descricao;
    }
    
    //setting para titulo
    public void setDescricao(String descricao){
        this.descricao= descricao;
    }

    // getting para completa
    public boolean isCompleta() {
        return this.completa;
    }
    
    //setting para titulo
    public void setCompleta(boolean completa){
        this.completa= completa;
    }

    // getting para dataAgora
    public int getDataAgora() {
        return this.dataAgora;
    }

     //setting para titulo
    public void setDataAgora(int dataAgora){
        this.dataAgora= dataAgora;
    }
   
}
