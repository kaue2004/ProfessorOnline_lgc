package View.Consultar;

import Controller.Conexao;
import Controller.NotasDAO;
import Model.Aluno;
import Model.Notas;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarNotas extends javax.swing.JFrame {

    public ConsultarNotas() {
        initComponents();
        setTitle("Professor Online");
        setLocationRelativeTo(this);
        setResizable(false);
        
        setSize(938,465);
    }
    
    public void AtualizaTable(){
        
        Connection cont = Conexao.AbrirConexao();
        NotasDAO db = new NotasDAO(cont);
        
        List<Notas> lista = new ArrayList<>();
        lista = db.ListarNotas();
        
        String PB = "";
        String SB = "";
        String TB = "";
        String QB = "";
        
        DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
        
        while(tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        
       
        int t = 0;
        for(Notas tab : lista){
            String notas = tab.getNotas();
            String Quebra[] = notas.split(",");
            PB = Quebra[0];
            SB = Quebra[1];
            TB = Quebra[2];
            QB = Quebra[3];
            
            String nomeAluno = "";
            
            for(Aluno a :  db.ConsultaNomeAluno(tab.getIdAluno())){
                nomeAluno = a.getNomeAluno();
            }
            
            tbm.addRow(new String[t]);
            jTable1.setValueAt(nomeAluno, t, 0);
            jTable1.setValueAt(tab.getTurma(), t, 1);
            jTable1.setValueAt(PB, t, 2);
            jTable1.setValueAt(SB, t, 3);
            jTable1.setValueAt(TB, t, 4);
            jTable1.setValueAt(QB, t, 5);
            jTable1.setValueAt(tab.getMedia(), t, 6);
            jTable1.setValueAt(tab.getSituacao(), t, 7);
            t++;
        }
            Conexao.FecharConexao(cont);
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(47, 107, 98));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/butao.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisa por Turma:");

        jButton4.setText("Voltar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Todos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Pesquisa por Nome:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aluno", "Turma", "1º Bimestre", "2º Bimestre", "3º Bimestre", "4º Bimestre", "Media", "Situacao"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nome = jTextField1.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Campo não pode ficar em branco!!");
        }else{

            Connection con = Conexao.AbrirConexao();
            NotasDAO db = new NotasDAO(con);
            
            List<Aluno> lista = new ArrayList<>();
            lista = db.PesquisarNomeAluno(nome);
            
            DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
            
            while(tbm.getRowCount() > 0){
                tbm.removeRow(0);
            }
            
            
            String PB = "";
            String SB = "";
            String TB = "";
            String QB = "";
            float media = 0;
            String situacao = "";
            int i = 0;
            
            for(Aluno tab : lista){
                
                for(Notas n : db.PesquisarIdAluno(tab.getIdAluno())){
                    String notas = n.getNotas();
                    String Quebra[] = notas.split(",");
                    PB = Quebra[0];
                    SB = Quebra[1];
                    TB = Quebra[2];
                    QB = Quebra[3];
                    media = n.getMedia();
                    situacao = n.getSituacao();
                }
                tbm.addRow(new String[i]);
                jTable1.setValueAt(tab.getNomeAluno(), i, 0);
                jTable1.setValueAt(tab.getTurma(), i, 1);
                jTable1.setValueAt(PB, i, 2);
                jTable1.setValueAt(SB, i, 3);
                jTable1.setValueAt(TB, i, 4);
                jTable1.setValueAt(QB, i, 5);
                jTable1.setValueAt(media, i, 6);
                jTable1.setValueAt(situacao, i, 7);
                i++;
            }
            Conexao.FecharConexao(con);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AtualizaTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       Integer linha = jTable1.getSelectedRow();
       JOptionPane.showMessageDialog(null,linha);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
       String pesquisa = jTextField2.getText();
       if(pesquisa.equals("")){
           AtualizaTable();
        }else{

            Connection con = Conexao.AbrirConexao();
            NotasDAO db = new NotasDAO(con);
            
            List<Aluno> lista = new ArrayList<>();
            lista = db.PesquisarTurmaAluno(pesquisa);
            
            DefaultTableModel tbm = (DefaultTableModel) jTable1.getModel();
            
            while(tbm.getRowCount() > 0){
                tbm.removeRow(0);
            }
            
            
            String PB = "";
            String SB = "";
            String TB = "";
            String QB = "";
            float media = 0;
            String situacao = "";
            int i = 0;
            
            for(Aluno tab : lista){
                
                for(Notas n : db.PesquisarIdAluno(tab.getIdAluno())){
                    String notas = n.getNotas();
                    String Quebra[] = notas.split(",");
                    PB = Quebra[0];
                    SB = Quebra[1];
                    TB = Quebra[2];
                    QB = Quebra[3];
                    media = n.getMedia();
                    situacao = n.getSituacao();
                }
                tbm.addRow(new String[i]);
                jTable1.setValueAt(tab.getNomeAluno(), i, 0);
                jTable1.setValueAt(tab.getTurma(), i, 1);
                jTable1.setValueAt(PB, i, 2);
                jTable1.setValueAt(SB, i, 3);
                jTable1.setValueAt(TB, i, 4);
                jTable1.setValueAt(QB, i, 5);
                jTable1.setValueAt(media, i, 6);
                jTable1.setValueAt(situacao, i, 7);
                i++;
            }
            Conexao.FecharConexao(con);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarNotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
