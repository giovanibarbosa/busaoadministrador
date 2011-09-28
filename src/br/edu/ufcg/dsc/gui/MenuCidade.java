/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuCidade.java
 *
 * Created on 27/09/2011, 23:23:08
 */
package br.edu.ufcg.dsc.gui;

import br.edu.ufcg.dsc.service.CidadeService;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Leite
 */
public class MenuCidade extends javax.swing.JFrame {

    /** Creates new form MenuCidade */
    public MenuCidade() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        adicionaCidadeButton = new javax.swing.JButton();
        removeCidadeButton = new javax.swing.JButton();
        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cidadeTextField = new javax.swing.JTextField();
        estadoComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciador de Cidades");

        adicionaCidadeButton.setText("Adicionar Nova Cidade");
        adicionaCidadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionaCidadeButtonActionPerformed(evt);
            }
        });

        removeCidadeButton.setText("Remover Cidade");
        removeCidadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCidadeButtonActionPerformed(evt);
            }
        });

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317175785_back.png"))); // NOI18N
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Cidade:");

        jLabel2.setText("Estado:");

        jLabel3.setText("Para remover uma Cidade, acessar botão abaixo e escolher cidade a ser removida.");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espiríto Santo", "Góias ", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        jLabel4.setText("Para adicionar uma nova Cidade, completar campos abaixo e pressione o botão.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(voltarButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(adicionaCidadeButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeCidadeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(voltarButton)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(adicionaCidadeButton)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(removeCidadeButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionaCidadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionaCidadeButtonActionPerformed
        String cidade = cidadeTextField.getText();
        String estado = estadoComboBox.getSelectedItem().toString();
        
        //Pegar ponto pela geocoder. e Adicionar
        JOptionPane.showMessageDialog(null, "Cidade adicionada com Sucesso");
        dispose();
    }//GEN-LAST:event_adicionaCidadeButtonActionPerformed

    private void removeCidadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCidadeButtonActionPerformed
        List<String> cidades = new ArrayList<String>();
        
        for (int i = 0; i < CidadeService.getInstance().getCidadesAplicativo().size(); i++) {
            cidades.add(CidadeService.getInstance().getCidadesAplicativo().get(i).getNome());
        }
        
        dispose();
        
        String removeCidade = (String) JOptionPane.showInputDialog(null,"Escolha a cidade que deseja remover:", "Busão Administrador",
			JOptionPane.PLAIN_MESSAGE, null, cidades.toArray(), cidades.toArray()[0]);
        
        //remove cidade
        JOptionPane.showMessageDialog(null, "Cidade removida com sucesso");
        new MenuCidade().setVisible(true);  
    }//GEN-LAST:event_removeCidadeButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        new MenuAdministrador().setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MenuCidade().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionaCidadeButton;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JComboBox estadoComboBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton removeCidadeButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}