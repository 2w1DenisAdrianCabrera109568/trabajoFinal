/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labiv.tpfinal.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import labiv.tpfinal.DTO.ReporteEmpRecXLegDTO;
import labiv.tpfinal.DTO.SueldoNetoAreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author devil
 */
@Repository
public class RepositorioEmpleadosJpa {
    
    @Autowired
    private DataSource source;
    
    public List<ReporteEmpRecXLegDTO> obtenerPorLeg(int leg) {
        
        List<ReporteEmpRecXLegDTO> list = new ArrayList<>();
        
        try {
            Connection conn = source.getConnection();
            PreparedStatement st = conn.prepareStatement("call emp_leg(?)");
            st.setInt(1, leg);
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                int legajo = rs.getInt("Legajo");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int anio = rs.getInt("Periodo");
                int mes = rs.getInt("Mes");
                double sueldoNeto = rs.getDouble("Sueldo Neto");
                list.add(new ReporteEmpRecXLegDTO(legajo, nombre, apellido, anio, mes, sueldoNeto));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public List<SueldoNetoAreaDTO> resumenAreas(int anio, int mes) {
        
        List<SueldoNetoAreaDTO> areas = new ArrayList<>();
        
        try {
            Connection conn = source.getConnection();
            PreparedStatement st = conn.prepareStatement("call sueldo_anio_mes(?,?)");
           st.setInt(1, anio);
            st.setInt(2, mes);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
            String area = rs.getString(1);
            int periodo = rs.getInt(2);
            int mess = rs.getInt(3);
            double sueldoNeto = rs.getDouble(4);
            
            areas.add(new SueldoNetoAreaDTO(area, periodo, mess, sueldoNeto));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
}
