/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.ConexaoMySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cursoo;
import java.util.List;

/**
 *
 * @author 17171000107
 */
public class CursoDAO {

    public boolean gravarCurso(Cursoo a) {

        Connection conn = ConexaoMySql.conexao();

        String sql = "INSERT INTO curso(nome, area, cargahoraria, valorcurso, valormensal, numvagas, "
                + "cod) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {

            PreparedStatement ps
                    = conn.prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setString(2, a.getArea());
            ps.setString(3, a.getCargaHoraria());
            ps.setString(4, a.getValor());
            ps.setString(5, a.getValorMensal());
            ps.setString(6, a.getNumeroVagas());
            ps.setString(7, a.getCodigo());

            ps.executeUpdate();

            ps.close();
            conn.close();
            //retorno de ok
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Cursoo> recuperaTodosCursos() {

        Connection conexao = ConexaoMySql.conexao();

        String sql = "SELECT * FROM curso;";

        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Cursoo> lista = new ArrayList<>();

            while (rs.next()) {

                Cursoo a = new Cursoo();
                a.setIdCurso(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setArea(rs.getString(3));
                a.setCargaHoraria(rs.getString(4));
                a.setValor(rs.getString(5));
                a.setValorMensal(rs.getString(6));
                a.setNumeroVagas(rs.getString(7));
                a.setCodigo(rs.getString(8));

                lista.add(a);
            }

            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public List<Cursoo> pesquisaCursos(String pesquisa) {
        Connection conexao = ConexaoMySql.conexao();
        //instrução SQL
        String sql = "SELECT * FROM curso" + " WHERE nome LIKE?;";

        try {

            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, "%" + pesquisa + "%");
            ResultSet rs = ps.executeQuery();

            List<Cursoo> lista = new ArrayList<>();

            while (rs.next()) {

                Cursoo a = new Cursoo();
                a.setIdCurso(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setArea(rs.getString(3));
                a.setCargaHoraria(rs.getString(4));
                a.setValor(rs.getString(5));
                a.setValorMensal(rs.getString(6));
                a.setNumeroVagas(rs.getString(7));
                a.setCodigo(rs.getString(8));

                lista.add(a);
            }

            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean excluirCurso(int idCurso) {

         Connection conexao = ConexaoMySql.conexao();
        
        String sql = "DELETE FROM curso WHERE idCurso=?;";
        try {
            
            PreparedStatement ps = conexao.prepareStatement(sql);
            
            ps.setInt(1, idCurso);
            //executar sql
            ps.executeUpdate();
            ps.close();
            conexao.close();
            //retornar ok
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //retorno falha
        return false;
    }
}
