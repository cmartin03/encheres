/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fr.insastrasbourg.ui;

import fr.insastrasbourg.Principal;
import fr.insastrasbourg.data.Enchere;
import fr.insastrasbourg.data.Objet;
import javax.persistence.EntityManager;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author martin
 */
public class VoirObjet extends javax.swing.JFrame {

    Objet objet;
    Principal principal;
    ConsulterEnchere consulterEnchere;
    
    /**
     * Creates new form VoirObjet
     */
    public VoirObjet(Principal principal, Objet objet, ConsulterEnchere consulterEnchere) {
        initComponents();
        
        this.objet = objet;
        this.principal = principal;
        this.consulterEnchere = consulterEnchere;
        
        lblLibelle.setText(objet.getLibelle());
        txtDesc.setText(objet.getDescription());
        lblDteFinEnchere.setText(objet.getDateFinEnchereAsString());
        lblErreurEnchere.setText("");
        lblProprietaire.setText(objet.getUtilisateur().getNom()+ " " + objet.getUtilisateur().getPrenom () );
        
        // affichage liste de encheres
        
        // on ne peut encherir que si ont est connecté
        if (principal.getUtilisateurConnecte()==null) {
            panelNvlEnchere.setVisible(false);
        }
                
        int prix = objet.getDernierPrix() + 1;
        txtNvleEnchere.setText( String.valueOf(prix));
        
        // Add the document filter to text field for numeric and length check.
        ((AbstractDocument) txtNvleEnchere.getDocument()).setDocumentFilter(new NumericAndLengthFilter(5));

     
        doAffichageEncheres();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFermer = new javax.swing.JButton();
        lblLibelle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblDteFinEnchere = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEncheres = new javax.swing.JTextArea();
        panelNvlEnchere = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNvleEnchere = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEncherir = new javax.swing.JButton();
        lblErreurEnchere = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblProprietaire = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFermer.setText("Fermer");
        btnFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerActionPerformed(evt);
            }
        });

        lblLibelle.setText("jLabel1");

        txtDesc.setEditable(false);
        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        jLabel1.setText("Fin enchère");

        lblDteFinEnchere.setText("jLabel2");

        jLabel2.setText("Encheres");

        txtEncheres.setEditable(false);
        txtEncheres.setColumns(20);
        txtEncheres.setRows(5);
        jScrollPane2.setViewportView(txtEncheres);

        jLabel3.setText("Nouvelle enchère");

        txtNvleEnchere.setText("jTextField1");

        jLabel4.setText("€");

        btnEncherir.setText("Enchérir");
        btnEncherir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncherirActionPerformed(evt);
            }
        });

        lblErreurEnchere.setForeground(new java.awt.Color(255, 0, 0));
        lblErreurEnchere.setText("jLabel5");

        javax.swing.GroupLayout panelNvlEnchereLayout = new javax.swing.GroupLayout(panelNvlEnchere);
        panelNvlEnchere.setLayout(panelNvlEnchereLayout);
        panelNvlEnchereLayout.setHorizontalGroup(
            panelNvlEnchereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNvlEnchereLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelNvlEnchereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNvlEnchereLayout.createSequentialGroup()
                        .addComponent(lblErreurEnchere)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelNvlEnchereLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(txtNvleEnchere, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnEncherir)
                        .addGap(15, 15, 15))))
        );
        panelNvlEnchereLayout.setVerticalGroup(
            panelNvlEnchereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNvlEnchereLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelNvlEnchereLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNvleEnchere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(btnEncherir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblErreurEnchere)
                .addContainerGap())
        );

        jLabel5.setText("Appartiens à:");

        lblProprietaire.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDteFinEnchere, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblLibelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(191, 191, 191))
                            .addComponent(btnFermer, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))
                            .addComponent(panelNvlEnchere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblProprietaire)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblLibelle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblProprietaire))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDteFinEnchere))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelNvlEnchere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnFermer)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerActionPerformed

        // on met à jour la liste des objets avec le nouveau prix
        consulterEnchere.doAffichage();
        
        this.setVisible(false);
    }//GEN-LAST:event_btnFermerActionPerformed

    private void btnEncherirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncherirActionPerformed
        // TODO add your handling code here:
        // le montant doit être supérieur à la dernière enchere
        int prix = Integer.parseInt(txtNvleEnchere.getText());
        
        if (prix <= objet.getDernierPrix()) {
            lblErreurEnchere.setText("Le montant de l'enchère doit être supérieur à " + objet.getDernierPrix() + "€");
            lblErreurEnchere.setVisible(true);
            return;
        }
        else {
            lblErreurEnchere.setVisible(false);
        }
        
        EntityManager em = principal.getEntityManager();
        em.getTransaction( ).begin( );
        
        Enchere e = new Enchere();
        e.setObjet(objet);
        e.setPrix(prix);
        e.setUtilisateur(principal.getUtilisateurConnecte());
        
        em.persist(e);
        em.getTransaction().commit();
        
        objet.getEnchereList().add(e);
        doAffichageEncheres();
        
    }//GEN-LAST:event_btnEncherirActionPerformed

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
            java.util.logging.Logger.getLogger(VoirObjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoirObjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoirObjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoirObjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VoirObjet(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncherir;
    private javax.swing.JButton btnFermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDteFinEnchere;
    private javax.swing.JLabel lblErreurEnchere;
    private javax.swing.JLabel lblLibelle;
    private javax.swing.JLabel lblProprietaire;
    private javax.swing.JPanel panelNvlEnchere;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextArea txtEncheres;
    private javax.swing.JTextField txtNvleEnchere;
    // End of variables declaration//GEN-END:variables

    private void doAffichageEncheres() {
        String s = "";
        
        for (Enchere e : objet.getEnchereList()) {
            s += e.getUtilisateur().getPrenom() + " " + e.getUtilisateur().getNom() + " " + e.getPrix() + "€\n";
        }
        txtEncheres.setText(s);
    }
    
}
