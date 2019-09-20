/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 17171000107
 */
public class Cursoo {

    private String Nome;
    private String Codigo;
    private String Valor;
    private String CargaHoraria;
    private String NumeroVagas;
    private String ValorMensal;
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getValor() {
        return Valor;

    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    private int idCurso;

    public String getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(String CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public String getNumeroVagas() {
        return NumeroVagas;
    }

    public void setNumeroVagas(String NumeroVagas) {
        this.NumeroVagas = NumeroVagas;
    }

    public String getValorMensal() {
        return ValorMensal;
    }

    public void setValorMensal(String ValorMensal) {
        this.ValorMensal = ValorMensal;
    }
}
