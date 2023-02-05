
package DAO;


import DTO.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {
    ArrayList<ClienteDTO> lista=new ArrayList<>();
    Connection conn;
    public ResultSet autenticacaoUsuario(ClienteDTO objetoClienteDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from cliente where nome_usuario=? and senha_usuario=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, objetoClienteDTO.getNome_usuario());
           pstm.setString(2, objetoClienteDTO.getSenha_usuario());
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO:" + e);
            return null;
      }
        }
    
    public ResultSet autenticacaoAgenda(ClienteDTO objetoClienteDTO){
       conn=new conexaoDAO().conectaBD();
        try {
           String sql="select * from cliente where telefone_usuario=?";     
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, objetoClienteDTO.getTelefone_usuario());
           ResultSet rs=pstm.executeQuery();
           return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO:" + e);
            return null;
      }
        }

public void inserirCliente(ClienteDTO objetoClienteDTO){             
           String sql="insert into funcionario(nome_usuario,senha_usuario,telefone_usuario) values(?,?,?)"; 
           conn=new conexaoDAO().conectaBD();
           try {
           PreparedStatement pstm=conn.prepareStatement(sql);
           pstm.setString(1, objetoClienteDTO.getNome_usuario());
           pstm.setString(2, objetoClienteDTO.getSenha_usuario());
           pstm.setString(3, objetoClienteDTO.getTelefone_usuario());
           pstm.execute();
           pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO:" + e);
      }
        } 

    public ArrayList<ClienteDTO> pesquisarCliente(){
        String sql="select * from cliente";
         conn=new conexaoDAO().conectaBD();
         try{
         PreparedStatement pstm=conn.prepareStatement(sql);
         ResultSet rs=pstm.executeQuery();
         while(rs.next()){
         ClienteDTO objClienteDTO=new ClienteDTO();

        objClienteDTO.setId_usuario(rs.getInt("id_usuario"));

        objClienteDTO.setNome_usuario(rs.getString("nome_usuario"));

        objClienteDTO.setSenha_usuario(rs.getString("senha_usuario"));
        
        objClienteDTO.setTelefone_usuario(rs.getString("telefone_usuario"));
        
         lista.add(objClienteDTO);
         }
         }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Pesquisar:" + e);
         }
         return lista;
         }
}
