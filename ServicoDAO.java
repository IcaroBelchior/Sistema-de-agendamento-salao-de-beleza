package DAO;


import DTO.ClienteDTO;
import DTO.ServiçoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ServicoDAO {
    ArrayList<ServiçoDTO> lista=new ArrayList<>();
    Connection conn;
    public ResultSet autenticacaoServico(ServiçoDTO objetoServicoDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from servicos where id_servico=? and valor_servicos=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setInt(1, objetoServicoDTO.getId_servico());
           pstm.setDouble(2, objetoServicoDTO.getValor_servico());
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ServiçoDAO:" + e);
            return null;
      }
     }
   public ResultSet autenticacaoAgenda(ServiçoDTO objetoServicoDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from servicos where valor_servicos=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);         
           pstm.setDouble(1, objetoServicoDTO.getValor_servico());
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ServiçoDAO:" + e);
            return null;
      }
     }
         public void inserirServico(ServiçoDTO objetoServicoDTO){             
           String sql="insert into funcionario(nome_servicos,valor_servicos) values(?,?)"; 
           conn=new conexaoDAO().conectaBD();
           try {
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, objetoServicoDTO.getNome_servico());
           pstm.setDouble(2, objetoServicoDTO.getValor_servico());
           pstm.execute();
           pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO:" + e);
      }
        } 

    public ArrayList<ServiçoDTO> pesquisarServico(){
        String sql="select * from servicos";
         conn=new conexaoDAO().conectaBD();
         try{
         PreparedStatement pstm=conn.prepareStatement(sql);
         ResultSet rs=pstm.executeQuery();
         while(rs.next()){
         ServiçoDTO objServiçoDTO=new ServiçoDTO();

        objServiçoDTO.setId_servico(rs.getInt("id_servico"));

        objServiçoDTO.setNome_servico(rs.getString("nome_servicos"));

        objServiçoDTO.setValor_servico(rs.getDouble("valor_servicos"));
        
        
         lista.add(objServiçoDTO);
         }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Pesquisar:" + e);
         }
         return lista;
         }
   
}
