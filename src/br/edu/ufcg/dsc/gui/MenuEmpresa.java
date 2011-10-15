/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuEmpresa.java
 *
 * Created on 28/09/2011, 21:22:37
 */
package br.edu.ufcg.dsc.gui;

import br.edu.ufcg.dsc.bean.Cidade;
import br.edu.ufcg.dsc.bean.Empresa;
import br.edu.ufcg.dsc.facade.BusaoAdministradorFacade;
import br.edu.ufcg.dsc.facade.BusaoFacade;
import br.edu.ufcg.dsc.service.EmpresaService;

import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Leite
 */
public class MenuEmpresa extends javax.swing.JFrame {
	private BusaoAdministradorFacade facade;
	private BusaoFacade fachadaApp;
	private Cidade cidade;
    /** Creates new form MenuEmpresa 
     * @throws SQLException */
    public MenuEmpresa() throws SQLException {
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
        identificadorEmpresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomeEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        anoFundacaoEmpresa = new javax.swing.JTextField();
        adicionarEmpresaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        removerEmpresaButton = new javax.swing.JButton();
       

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317175785_back.png"))); // NOI18N
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        


        jLabel1.setText("Para adicionar uma nova Empresa, por favor preencher campos abaixo.");

        jLabel2.setText("Identificador: ");

        jLabel3.setText("Nome: ");

        jLabel4.setText("Ano de Fundacao: ");

        adicionarEmpresaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317256235_add1-.png"))); // NOI18N
        adicionarEmpresaButton.setText("Adicionar Empresa");
        try {
			adicionarEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
			    public void actionPerformed(java.awt.event.ActionEvent evt) {
			        try {
						adicionarEmpresaButtonActionPerformed(evt);
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        jLabel5.setText("Para remover uma Empresa, pressione o botao abaixo e escolha a Empresa a ser removida.");

        removerEmpresaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ufcg/dsc/gui/images/1317256312_Delete.png"))); // NOI18N
        removerEmpresaButton.setText("Remover Empresa");
        removerEmpresaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					removerEmpresaButtonActionPerformed(evt);
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
                .addGap(20, 20, 20)
                .addComponent(voltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(identificadorEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(anoFundacaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(removerEmpresaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(76, 76, 76)
                        .addComponent(nomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adicionarEmpresaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
          //              .addGap(60,60,60).addComponent(lista,javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(voltarButton)
//                .addGap(10,10,10).addComponent(lista)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(identificadorEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(nomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(adicionarEmpresaButton))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoFundacaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(16, 16, 16)
                .addComponent(removerEmpresaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        new MenuAdministrador().setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void adicionarEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, SQLException {//GEN-FIRST:event_adicionarEmpresaButtonActionPerformed
        int identificador = Integer.parseInt(identificadorEmpresa.getText());
        String nome = nomeEmpresa.getText();
        int anoFundacao = Integer.parseInt(anoFundacaoEmpresa.getText());
        Cidade cidade;
		
			cidade = (Cidade) JOptionPane.showInputDialog(null,"Escolha a cidade que a empresa pertence:", "Busao Administrador",
					JOptionPane.PLAIN_MESSAGE, null, facade.getCidades(), facade.getCidades()[0]);
	
        try {
			facade.adicionarEmpresa(cidade, new Empresa(identificador, nome, anoFundacao,cidade.getIdentificacao()));
			JOptionPane.showMessageDialog(null, "Empresa Adicionada com Sucesso");
        } catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexao com o banco de dados");
			e.printStackTrace();
		}
        
        
        
    }//GEN-LAST:event_adicionarEmpresaButtonActionPerformed

    private void removerEmpresaButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_removerEmpresaButtonActionPerformed
        List<String> empresas = new ArrayList<String>();
        List<Empresa> emp = facade.getEmpresas();
        for (int i = 0; i < emp.size(); i++) {
            empresas.add(emp.get(i).getNome());
          }
        
        dispose();
        
        String removeEmpresa = (String) JOptionPane.showInputDialog(null,"Escolha a empresa a ser removida:", "Busao Administrador",
			JOptionPane.PLAIN_MESSAGE, null, empresas.toArray(), empresas.toArray()[0]);
        
        
       
           
        try {
        	Iterator<Empresa> it = emp.iterator();
        	Iterator<String> itString = empresas.iterator();
        	Empresa empresa =null;
        	while(it.hasNext()){
        		Empresa e = it.next();
        		while (itString.hasNext()){
        			String nome = itString.next();
        			if (e.getNome().equals(nome)){
        				empresa = e;
        			}
        		}
        	}

			facade.removerEmpresa(facade.getCidade(String.valueOf(empresa.getCidadeId())), empresa);
			JOptionPane.showMessageDialog(null, "Empresa removida com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexao com o banco de dados");
			e.printStackTrace();
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro !");
			e.printStackTrace();
		}
        
        new MenuEmpresa().setVisible(true);  
    }//GEN-LAST:event_removerEmpresaButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
					new MenuEmpresa().setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarEmpresaButton;
    private javax.swing.JTextField anoFundacaoEmpresa;
    private javax.swing.JTextField identificadorEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nomeEmpresa;
    private javax.swing.JButton removerEmpresaButton;
    private javax.swing.JButton voltarButton;
   // private javax.swing.JList lista;
    // End of variables declaration//GEN-END:variables
}
