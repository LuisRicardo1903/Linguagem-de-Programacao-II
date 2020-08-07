import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class FrameFuncionario extends javax.swing.JFrame {

   public Connection c;
   int ID;

   
    public FrameFuncionario() {
        initComponents();
        conectar();
    }

    public void limparCampos(){
        jTFNome.setText("");
        jTFEmail.setText("");
        jTFCargo.setText("");
    }
       
    public void conectar() {
      try {
        String url = "jdbc:mysql://localhost:3306/empresa?user=root&password=usrlab";   
        c = (Connection) DriverManager.getConnection(url);
        jLabelStatusServidor.setText("ON");
       } catch (Exception e){ }     
    }
    
    public void inserir(Funcionario funcionario) {
         try {
            String query = "INSERT INTO Funcionario (nome, email, cargo) "
                  + "values ('"+ funcionario.nome +"', '"+ funcionario.email +"', '"+ funcionario.cargo +"')";  
            
            Statement st = (Statement) c.createStatement();
            int resultado = st.executeUpdate(query);
            if (resultado==1) {
                //JOptionPane.showMessageDialog(this, "Dados inseridos com sucesso");
                JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.nome + " foi inserido com sucesso");
                limparCampos();
            }
            else {
               JOptionPane.showMessageDialog(this, "Não foi possível realizar a inserção");
            }
            
         } catch (Exception e) {}   
    }
    
    
     public void consultar(String query) {
         int registro=0;
         try {
           Funcionario funcionario = new Funcionario();  
           //confirmar/homologar a conexão com o banco de dados
           Statement st = (Statement) c.createStatement();
           //retorno da execução do comando SQL
           ResultSet rs = st.executeQuery(query);    
           if (rs != null) { // Verifica se a query retornou algo
              while (rs.next()) {
                  funcionario.ID = Integer.parseInt(rs.getString("ID"));
                  funcionario.nome = rs.getString("nome");
                  funcionario.email = rs.getString("email");
                  funcionario.cargo = rs.getString("cargo");
                  registro=1;
              }            
           }
           
           ID = funcionario.ID;
           jTFNome.setText(funcionario.nome);
           jTFEmail.setText(funcionario.email);
           jTFCargo.setText(funcionario.cargo);
           
           if (registro==0) {
               JOptionPane.showMessageDialog(this, "Registro não encontrado");
           }
           
           
        } catch (Exception e) {}
    }
     
    public void alterar(Funcionario funcionario) {
        try {
           String query = "UPDATE Funcionario SET nome='" + funcionario.nome + "', "
                   + "email='" + funcionario.email + "', cargo='" + funcionario.cargo + "'  "
                   + "WHERE id=" + funcionario.ID;
           Statement st = (Statement) c.createStatement();
           int resultado = st.executeUpdate(query);
           if (resultado==1) {
               JOptionPane.showMessageDialog(this, "O funcionário " + funcionario.nome + " foi alterado com sucesso");
               limparCampos();
           }
           else {
               JOptionPane.showMessageDialog(this, "Não foi possível realizar a alteração");
           }
        } catch (Exception e){}   
    }
    
    public void excluir() {
       try { 
         String query = "DELETE FROM Funcionario WHERE id="+ID;
         Statement st = (Statement) c.createStatement();
         int resultado = st.executeUpdate(query);
         if (resultado==1) {
               JOptionPane.showMessageDialog(this, "O funcionário foi excluído com sucesso");
               limparCampos();
           }
           else {
               JOptionPane.showMessageDialog(this, "Não foi possível realizar a exclusão");
           }
       } catch (Exception e) {}
    }
    
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelStatusServidor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFNome = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFCargo = new javax.swing.JTextField();
        jButtonInserir = new javax.swing.JButton();
        jButtonConsultar = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Servidor de Banco de Dados:");

        jLabelStatusServidor.setText("OFF");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Módulo de Funcionários");

        jLabel3.setText("Nome:");

        jLabel4.setText("Email:");

        jLabel5.setText("Cargo:");

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTFCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatusServidor)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInserir)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelStatusServidor))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        Funcionario funcionario = new Funcionario();
        funcionario.nome = jTFNome.getText();
        funcionario.email = jTFEmail.getText();
        funcionario.cargo = jTFCargo.getText();
        inserir(funcionario);
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        consultar("select * from Funcionario where nome like '" + jTFNome.getText() + "'");
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        Funcionario funcionario = new Funcionario();
        funcionario.ID = ID;
        funcionario.nome = jTFNome.getText();
        funcionario.email = jTFEmail.getText();
        funcionario.cargo = jTFCargo.getText();
        alterar(funcionario);
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrameFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameFuncionario().setVisible(true);
            }
        });
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelStatusServidor;
    private javax.swing.JTextField jTFCargo;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNome;
    // End of variables declaration//GEN-END:variables
}
