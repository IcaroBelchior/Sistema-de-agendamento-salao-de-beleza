
package View;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author icaro
 */
public class Alterações_clientes extends javax.swing.JFrame {

    /**
     * Creates new form Alterações
     */
    public Alterações_clientes() {
        initComponents();
        listarValoresCliente();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jtitulo = new javax.swing.JLabel();
        jnome = new javax.swing.JLabel();
        jtelefone = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        txttelefone = new javax.swing.JTextField();
        bsalvar = new javax.swing.JButton();
        balterar = new javax.swing.JButton();
        bconsultar = new javax.swing.JButton();
        bexcluir = new javax.swing.JButton();
        jsenha = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jtitulo.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jtitulo.setText("CADASTRO CLIENTES");

        jnome.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jnome.setText("NOME:");

        jtelefone.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jtelefone.setText("TELEFONE:");

        bsalvar.setText("SALVAR");
        bsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsalvarActionPerformed(evt);
            }
        });

        balterar.setText("ALTERAR");
        balterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balterarActionPerformed(evt);
            }
        });

        bconsultar.setText("CONSULTAR");
        bconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bconsultarActionPerformed(evt);
            }
        });

        bexcluir.setText("EXCLUIR");

        jsenha.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jsenha.setText("SENHA:");

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "*****************", null},
                {null, null, "*****************", null},
                {null, null, "*****************", null},
                {null, null, "*****************", null}
            },
            new String [] {
                "Id Cliente", "Nome", "Senha", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balterar)
                        .addGap(30, 30, 30)
                        .addComponent(bconsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bexcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jtelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jnome)
                                    .addComponent(jsenha))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnome, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(txtsenha)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jtitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnome)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsenha)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtelefone)
                    .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsalvar)
                    .addComponent(balterar)
                    .addComponent(bconsultar)
                    .addComponent(bexcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void bsalvarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        String nome_cliente=txtnome.getText();
        String senha_cliente=txtsenha.getText();
        String telefone_cliente=txttelefone.getText();
        
        ClienteDTO objclientedto=new ClienteDTO();
        objclientedto.setNome_usuario(nome_cliente);
        objclientedto.setSenha_usuario(senha_cliente);
        objclientedto.setTelefone_usuario(telefone_cliente);

        
        ClienteDAO objclientedao=new ClienteDAO();
        objclientedao.inserirCliente(objclientedto);
    }                                       

    private void bconsultarActionPerformed(java.awt.event.ActionEvent evt) {                                           
       listarValoresCliente();
    }                                          

    private void balterarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alterações_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alterações_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alterações_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alterações_clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alterações_clientes().setVisible(true);
            }
        });
    }
           private void listarValoresCliente(){
              
                   ClienteDAO objetoClienteDAO=new ClienteDAO();
                   DefaultTableModel model=(DefaultTableModel)tabelaCliente.getModel();
                   model.setNumRows(0);
                   ArrayList<ClienteDTO> lista=objetoClienteDAO.pesquisarCliente();
                   
                   for(int num=0;num<lista.size();num++){
                       model.addRow(new Object[]{
                           lista.get(num).getId_usuario(),
                           lista.get(num).getNome_usuario(),
                           lista.get(num).getSenha_usuario(),
                           lista.get(num).getTelefone_usuario()
                       });
                   }
            
               }
           
    // Variables declaration - do not modify                     
    private javax.swing.JButton balterar;
    private javax.swing.JButton bconsultar;
    private javax.swing.JButton bexcluir;
    private javax.swing.JButton bsalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jnome;
    private javax.swing.JLabel jsenha;
    private javax.swing.JLabel jtelefone;
    private javax.swing.JLabel jtitulo;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtsenha;
    private javax.swing.JTextField txttelefone;
    // End of variables declaration                   
}
