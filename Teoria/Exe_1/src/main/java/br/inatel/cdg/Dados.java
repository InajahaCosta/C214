package br.inatel.cdg;

import com.google.gson.JsonArray;

import java.lang.reflect.Array;

public class Dados {

    private String nomeDoProfessor;
    private double horarioDeAtendimento;
    private double periodo;
    private double sala;
    private JsonArray predio;


    public Dados(String nomeDoProfessor,
                 double horarioDeAtendimento,
                 double periodo,
                 double sala,
                 JsonArray predio){
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = predio;
    }



    public String getNomeDoProfessor(){
        return nomeDoProfessor;
    }
    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.nomeDoProfessor = nomeDoProfessor;
    }

    public double getHorarioDeAtendimento(){
        return horarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(double horarioDeAtendimento) {
        this.horarioDeAtendimento = horarioDeAtendimento;
    }

    public double getPeriodo(){
        return periodo;
    }

    public void setPeriodo(double periodo) {
        this.periodo = periodo;
    }

    public double getSala(){
        return sala;
    }

    public void setSala(double sala) {
        this.sala = sala;
    }

    public JsonArray getPredio(){
        return predio;
    }

    public void setPredio(JsonArray predio) {
        this.predio = predio;
    }

}
