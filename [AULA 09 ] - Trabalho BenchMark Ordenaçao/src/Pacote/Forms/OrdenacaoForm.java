/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pacote.Forms;

/**
 *
 * @author Administrador
 */
public class OrdenacaoForm extends javax.swing.JFrame {
    
    private int[] numeros = new int[0];
    
    public OrdenacaoForm(int[] numerosCarregados) {
    initComponents();
    this.numeros = numerosCarregados;
}
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrdenacaoForm.class.getName());

   private java.util.List<String> MetodosSelecionados() {
    java.util.List<String> metodos = new java.util.ArrayList<>();
    if (chkBolha.isSelected()) metodos.add("Bolha");
    if (chkSelecao.isSelected()) metodos.add("Selecao");
    if (chkInsercao.isSelected()) metodos.add("Insercao");
    if (chkMerge.isSelected()) metodos.add("Merge");
    if (chkQuick.isSelected()) metodos.add("Quick");
    return metodos;
}
   
   
    public OrdenacaoForm() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        chkBolha = new javax.swing.JCheckBox();
        chkInsercao = new javax.swing.JCheckBox();
        chkSelecao = new javax.swing.JCheckBox();
        chkMerge = new javax.swing.JCheckBox();
        chkQuick = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnExecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SELECIONE O METODO PARA BENCHMARK");

        chkBolha.setText("Metodo Bolha");

        chkInsercao.setText("Metodo Inserção");

        chkSelecao.setText("Metodo Seleção");
        chkSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelecaoActionPerformed(evt);
            }
        });

        chkMerge.setText("Metodo Merge");

        chkQuick.setText("Metodo Quick");
        chkQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkQuickActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Resultado :");

        btnExecutar.setText("Executar");
        btnExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBolha)
                            .addComponent(chkSelecao)
                            .addComponent(chkInsercao)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chkQuick)
                                .addComponent(chkMerge)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(139, 139, 139))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(chkBolha)
                        .addGap(18, 18, 18)
                        .addComponent(chkSelecao)
                        .addGap(18, 18, 18)
                        .addComponent(chkInsercao)
                        .addGap(18, 18, 18)
                        .addComponent(chkMerge)
                        .addGap(18, 18, 18)
                        .addComponent(chkQuick)
                        .addGap(26, 26, 26)
                        .addComponent(btnExecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnVoltar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    MenuBenchMarkForm menu = new MenuBenchMarkForm();
    menu.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void chkSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelecaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSelecaoActionPerformed

    private void chkQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkQuickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkQuickActionPerformed

    private void btnExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecutarActionPerformed
     if (numeros == null || numeros.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Nenhum número carregado!");
        return;
    }
    java.util.List<String> metodos = MetodosSelecionados();
    if (metodos.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione ao menos um método.");
        return;
    }
    
    btnExecutar.setEnabled(false);
    txtResultado.setText("Executando métodos...\n\n");

    for (String metodo : metodos) {
        int[] copia = Pacote.Util.copiarArray(numeros); 
        Pacote.Ordenacao.Resultado res = null;

        switch (metodo) {
            case "Bolha": res = Pacote.Ordenacao.bolha(copia); break;
            case "Selecao": res = Pacote.Ordenacao.selecao(copia); break;
            case "Insercao": res = Pacote.Ordenacao.insercao(copia); break;
            case "Merge": res = Pacote.Ordenacao.mergeSort(copia); break;
            case "Quick": res = Pacote.Ordenacao.quickSort(copia); break;
        }

        txtResultado.append("Método Selecionado: " + metodo + "\n");
        txtResultado.append("Comparações: " + res.qtd_comparacoes + "\n");
        txtResultado.append("Trocas: " + res.qtd_trocas + "\n");
        txtResultado.append("Tempo (ms): " + res.tempoMillis + "\n");
        txtResultado.append("\n");
    }

    btnExecutar.setEnabled(true);
    }//GEN-LAST:event_btnExecutarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new OrdenacaoForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chkBolha;
    private javax.swing.JCheckBox chkInsercao;
    private javax.swing.JCheckBox chkMerge;
    private javax.swing.JCheckBox chkQuick;
    private javax.swing.JCheckBox chkSelecao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
