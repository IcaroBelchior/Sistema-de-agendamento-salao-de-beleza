package DAO;

import DTO.AgendamentoDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class AgendamentoDAO {
    ArrayList<AgendamentoDTO> lista=new ArrayList<>();
    Connection conn;
     public ResultSet autenticacaoAgendamento(AgendamentoDTO objetoAgendamentoDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from agendamento where id_cliente=? and id_servico=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, objetoAgendamentoDTO.getId_cliente());
           pstm.setInt(2, objetoAgendamentoDTO.getId_servico());
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AgendamentoDAO:" + e);
            return null;
      }
     }
     public ResultSet autenticacaoAgenda(AgendamentoDTO objetoAgendamentoDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from agendamento where id_agendamento=? and id_cliente=? and id_servico=? and data_age=? and hora_age=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, objetoAgendamentoDTO.getId_agendamento());
           pstm.setInt(2, objetoAgendamentoDTO.getId_cliente());
           pstm.setInt(3, objetoAgendamentoDTO.getId_servico());
           pstm.setDate(4,objetoAgendamentoDTO.getData());
           pstm.setTime(5,objetoAgendamentoDTO.getHora());          
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AgendamentoDAO:" + e);
            return null;
      }
     }
     
     public void agendarNovo(AgendamentoDTO objetoAgendamentoDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="insert into agendamento (id_agendamento,id_cliente,id_servico,data_age,hora_age) values(?,?,?,?,?)";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, objetoAgendamentoDTO.getId_agendamento());
           pstm.setInt(2, objetoAgendamentoDTO.getId_cliente());
           pstm.setInt(3, objetoAgendamentoDTO.getId_servico());
           pstm.setDate(4, objetoAgendamentoDTO.getData());
           pstm.setTime(5, objetoAgendamentoDTO.getHora());
           pstm.execute();
           pstm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "AgendamentoDAO:" + e);

      }
     }
     
     
      public ArrayList<AgendamentoDTO> pesquisarAgendamento(){
        String sql="select * from agendamento";
         conn=new conexaoDAO().conectaBD();
         try{
         PreparedStatement pstm=conn.prepareStatement(sql);
         ResultSet rs=pstm.executeQuery();
         while(rs.next()){
         AgendamentoDTO objAgendamentoDTO=new AgendamentoDTO();

        objAgendamentoDTO.setId_agendamento(rs.getInt("id_agendamento"));

        objAgendamentoDTO.setId_cliente(rs.getInt("id_cliente"));

        objAgendamentoDTO.setId_servico(rs.getInt("id_servico"));
        
        objAgendamentoDTO.setData(rs.getDate("data_age"));
        
        objAgendamentoDTO.setHora(rs.getTime("hora_age"));
        
         lista.add(objAgendamentoDTO);
         }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Pesquisar:" + e);
         }
         return lista;
         }
}
