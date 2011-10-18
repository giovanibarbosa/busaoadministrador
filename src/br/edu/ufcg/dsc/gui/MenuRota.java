/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuRota.java
 *
 * Created on 28/09/2011, 22:00:59
 */
package br.edu.ufcg.dsc.gui;

import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.bean.Horario;
import br.edu.ufcg.dsc.bean.Onibus;
import br.edu.ufcg.dsc.bean.Rota;
import br.edu.ufcg.dsc.facade.BusaoAdministradorFacade;
import br.edu.ufcg.dsc.service.RotaService;
import java.sql.Time;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Leite
 */
public class MenuRota extends javax.swing.JFrame {
	
	private BusaoAdministradorFacade facade;
    /** Creates new form MenuRota 
     * @throws SQLException */
    public MenuRota() throws SQLException {
    	facade = new BusaoAdministradorFacade();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     * @throws SQLException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws SQLException {

        voltarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        identificadorField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        corField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        linkGMapsField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        horaInicialComboBox = new javax.swing.JComboBox();
        minutoInicialComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        horaFinalComboBox = new javax.swing.JComboBox();
        minutoFinalComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        intervaloMinutoEntreParadaComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JList();
        addOnibusButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        removerRotaButton = new javax.swing.JButton();
        addRotaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317175785_back.png"))); // NOI18N
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Para adicionar uma nova Rota, preencher campos abaixo.");

        jLabel2.setText("Identificador:");

        jLabel3.setText("Cor:");

        jLabel4.setText("Link GMaps:");

        jLabel5.setText("Hora Inicial:");

        horaInicialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        minutoInicialComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel6.setText("Hora Final:");

        horaFinalComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        minutoFinalComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel7.setText("Intervalo entre onibus (minutos):");

        intervaloMinutoEntreParadaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jTextArea1.setModel(new javax.swing.AbstractListModel() {
            Object[] onibus = facade.getOnibus().toArray();
            public int getSize() {return onibus.length;}
            public Object getElementAt(int i){return onibus[i];}
        });

        jScrollPane1.setViewportView(jTextArea1);

        addOnibusButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317256235_add1-.png"))); // NOI18N
        addOnibusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addOnibusButtonActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jLabel8.setText("Para remover uma Rota, pressionar botao abaixo e escolher a Rota desejada.");

        removerRotaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317256312_Delete.png"))); // NOI18N
        removerRotaButton.setText("Remover Rota");
        removerRotaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					removerRotaButtonActionPerformed(evt);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        addRotaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317256235_add1-.png"))); // NOI18N
        addRotaButton.setText("Adicionar Rota");
        addRotaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					addRotaButtonActionPerformed(evt);
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(identificadorField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(59, 59, 59)
                        .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(linkGMapsField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(addOnibusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(removerRotaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(horaInicialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(minutoInicialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(horaFinalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(minutoFinalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(intervaloMinutoEntreParadaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(addRotaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(voltarButton)
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(identificadorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(corField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(linkGMapsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOnibusButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(horaInicialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minutoInicialComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaFinalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minutoFinalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(intervaloMinutoEntreParadaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addRotaButton)))
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(16, 16, 16)
                .addComponent(removerRotaButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        new MenuAdministrador().setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    @SuppressWarnings("deprecation")
	private void addRotaButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {//GEN-FIRST:event_addRotaButtonActionPerformed
        String id = identificadorField.getText();
        String cor = corField.getText();
        String link = linkGMapsField.getText();
        
        int horaInicial = Integer.parseInt(horaInicialComboBox.getSelectedItem().toString());
        int minutoInicial = Integer.parseInt(minutoInicialComboBox.getSelectedItem().toString());
        
        int horaFinal = Integer.parseInt(horaFinalComboBox.getSelectedItem().toString());
        int minutoFinal = Integer.parseInt(minutoFinalComboBox.getSelectedItem().toString());
        
        int intervalo = Integer.parseInt(intervaloMinutoEntreParadaComboBox.getSelectedItem().toString());
        
        Empresa empresa = (Empresa) JOptionPane.showInputDialog(null,"Escolha a empresa a ser removida:", "Busao Administrador",
    			JOptionPane.PLAIN_MESSAGE, null, facade.getEmpresas().toArray(), facade.getEmpresas().toArray()[0]);      
        
        int tempoInicial = ((horaInicial * 60) + minutoInicial) * 1000;
        int tempoFinal = ((horaFinal * 60) + minutoFinal) * 1000;
        int tempoTotal = (tempoFinal - tempoInicial)/1000;
        Object[] select = jTextArea1.getSelectedValues();
        List<Onibus> buss = new ArrayList<Onibus>();
        for(int i = 0;i < select.length; i ++){
        	buss.add((Onibus) select[i]);
        }
       
        Time tInicio = new Time(System.currentTimeMillis() + tempoInicial);
        Time tFim = new Time(System.currentTimeMillis() + tempoFinal);
        facade.cadastrarRota(new Rota(id, cor, buss, facade.extrairRotas(link), new Horario(intervalo,tempoTotal,tInicio, tFim), ""));
       
        JOptionPane.showMessageDialog(null, "Rota criada com sucesso");
        
    }//GEN-LAST:event_addRotaButtonActionPerformed

    private void addOnibusButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_addOnibusButtonActionPerformed
        // TODO add your handling code here:
    	MenuOnibus bus = new MenuOnibus();
    	bus.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	bus.setVisible(true);
       
        }//GEN-LAST:event_addOnibusButtonActionPerformed

    private void removerRotaButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_removerRotaButtonActionPerformed
        List<String> rotas = new ArrayList<String>();
       
        for (int i = 0; i < RotaService.getInstance().getRotas().size(); i++) {
            rotas.add(RotaService.getInstance().getRotas().get(i).getIdentificador());
        }
        
        dispose();
        
        String removeRota = (String) JOptionPane.showInputDialog(null,"Escolha a rota a ser removida:", "Busão Administrador",
			JOptionPane.PLAIN_MESSAGE, null, rotas.toArray(), rotas.toArray()[0]);
        
        //remover onibus. Tratar aqui
        JOptionPane.showMessageDialog(null, "Rota removido com sucesso");
        new MenuRota().setVisible(true);  
    }//GEN-LAST:event_removerRotaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
					new MenuRota().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOnibusButton;
    private javax.swing.JButton addRotaButton;
    private javax.swing.JTextField corField;
    private javax.swing.JComboBox horaFinalComboBox;
    private javax.swing.JComboBox horaInicialComboBox;
    private javax.swing.JTextField identificadorField;
    private javax.swing.JComboBox intervaloMinutoEntreParadaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList jTextArea1;
    private javax.swing.JTextField linkGMapsField;
    private javax.swing.JComboBox minutoFinalComboBox;
    private javax.swing.JComboBox minutoInicialComboBox;
    private javax.swing.JButton removerRotaButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
