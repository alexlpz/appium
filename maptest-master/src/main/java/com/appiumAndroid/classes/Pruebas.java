/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appiumAndroid.classes;




import java.awt.BorderLayout;


public class Pruebas extends javax.swing.JFrame {
  public Principal principal;
   
    
    public Pruebas() {
         
        
        initComponents();
       
            
        principal=new Principal(panel_principla);
        
        
        principal.setSize(489, 580);
        principal.setLocation(5, 5);
        
        panel_principla.removeAll();
        panel_principla.add(principal, BorderLayout.CENTER);
        panel_principla.revalidate();
        panel_principla.repaint();
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principla = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));
        setPreferredSize(new java.awt.Dimension(489, 580));

        panel_principla.setBorder(new javax.swing.border.MatteBorder(null));
        panel_principla.setForeground(javax.swing.UIManager.getDefaults().getColor("ToolBar.dockingForeground"));
        panel_principla.setPreferredSize(new java.awt.Dimension(489, 580));

        javax.swing.GroupLayout panel_principlaLayout = new javax.swing.GroupLayout(panel_principla);
        panel_principla.setLayout(panel_principlaLayout);
        panel_principlaLayout.setHorizontalGroup(
            panel_principlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        panel_principlaLayout.setVerticalGroup(
            panel_principlaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_principla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_principla, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel_principla;
    // End of variables declaration//GEN-END:variables
}
