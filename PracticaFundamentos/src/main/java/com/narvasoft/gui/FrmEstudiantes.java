package com.narvasoft.gui;

import java.util.ArrayList;
import javax.swing.*;

public class FrmEstudiantes extends javax.swing.JFrame {

    private JButton btnSave;
    private static JLabel lblId3;
    private static JLabel lblJuegof;
    private static JLabel lblLevel;
    private static JLabel lblNombre;
    private static JLabel lblScore;
    private static JTextField txtId;
    private static JTextField txtJuego;
    private static JTextField txtLevel;
    private static JTextField txtNombre;
    private static JTextField txtScore;
    private static JTextArea txtArea;
    private static JScrollPane jScrollPane1;
    private static JButton btnBuscar;
    private static JButton btnEliminar;

    static ArrayList<Jugadores> jugadores = new ArrayList<>();

   public static void addJugador() {
    String idText = txtId.getText().trim();
    
    if (!idText.isEmpty()) {
        // El campo no está vacío, mostrar un mensaje de advertencia
        JOptionPane.showMessageDialog(null, "El sistema le asignará su correspondiente ID. Deje este campo vacío por favor.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método sin agregar el jugador
    }
       Jugadores jugador = new Jugadores(txtNombre.getText(), txtJuego.getText(), txtLevel.getText().charAt(0), Integer.parseInt(txtScore.getText()));
        jugadores.add(jugador);
        listarJugadores();
        txtId.setText("");
        txtJuego.setText("");
        txtLevel.setText("");
        txtNombre.setText("");
        txtScore.setText("");

    }
       

   static void listarJugadores(){
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("************Listado de Jugadores***************\n");
       //System.out.println("************Listado de Jugadores***************");
       for(Jugadores jugador: jugadores)
           //txtArea.setText("Id. "+jugador.getId()+"Nombre del Jugador:" +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore());
          //System.out.println("Id. "+jugador.getId()+"Nombre del Jugador:" +jugador.getNombre() + " Puntaje: "+jugador.getMaxScore()); 
         stringBuilder.append("Id. ").append(jugador.getId()).append(" Nombre del Jugador: ").append(jugador.getNombre()).append(" Juego Favorito: ").append(jugador.getJuegoFavortio()).append(" Puntaje: ").append(jugador.getMaxScore()). append (" Nivel(A:Avanzado, I: Intermedio, P: Principiante): ").append(jugador.getLevel()).append("\n");
       txtArea.setText(stringBuilder.toString());
    }
    private JButton btnCerrar;
    private JButton btnEdit;
   
   
    public FrmEstudiantes() {
        initComponents();
    }
    
    static void buscarJugador() {
        int id = Integer.parseInt(txtId.getText());
        boolean encontrado=false;
        
        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {
                txtNombre.setText(jugador.getNombre());
                txtJuego.setText(jugador.getJuegoFavortio());
                txtScore.setText(String.valueOf(jugador.getMaxScore()));
                txtLevel.setText(Character.toString(jugador.getLevel()));
                listarJugadores();
                encontrado=true;
                break;
        }
        }
        if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Error: El ID ingresado no existe. Intenta de nuevo.");
        listarJugadores();
    }
    }
        static void eliminarJugador() {
        int id = Integer.parseInt(txtId.getText());
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar un jugador?");

    if (opcion == JOptionPane.YES_OPTION) {
        // Busca al jugador por su ID
        for (Jugadores jugador : jugadores) {
            if (jugador.getId() == id) {
                jugadores.remove(jugador);
                JOptionPane.showMessageDialog(null, "Se ha eliminado el jugador con ID: " + id);
                listarJugadores();
                break;
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Operación cancelada.");
    }
        txtId.setText("");
        txtJuego.setText("");
        txtLevel.setText("");
        txtNombre.setText("");
        txtScore.setText("");
}
   static void editarJugador() {
       int id = Integer.parseInt(txtId.getText());
       for (Jugadores jugador : jugadores) {
        if (jugador.getId() == id) {
            jugador.setNombre(txtNombre.getText());
            jugador.setJuegoFavortio(txtJuego.getText());
            jugador.setMaxScore(Integer.parseInt(txtScore.getText()));
            jugador.setLevel(txtLevel.getText().charAt(0));
            }
        }
       listarJugadores();
       JOptionPane.showMessageDialog(null, "Se ha editado el jugador con ID: "+id);
        txtId.setText("");
        txtJuego.setText("");
        txtLevel.setText("");
        txtNombre.setText("");
        txtScore.setText("");   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblJuegof = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lblId3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtLevel = new javax.swing.JTextField();
        txtJuego = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblNombre.setText("Nombre del jugador:");

        lblLevel.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblLevel.setText("Nivel:");
        lblLevel.setToolTipText("'");

        lblJuegof.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblJuegof.setText("Juego Favorito:");

        lblScore.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblScore.setText("Score:");

        lblId3.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblId3.setText("ID:");

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtIdComponentAdded(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtLevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLevel.setToolTipText("P' principiante, 'I' Intermedio o 'A' Avanzado");

        txtJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtScore.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnSave.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\guardar.png"));
        btnSave.setText("Guardar");
        btnSave.setToolTipText("Guardar el Jugador Actual");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(java.awt.SystemColor.activeCaption);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtArea);

        btnBuscar.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 12)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+("\\src\\main\\java\\img\\buscar.png")));
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar jugador");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/narvasoft/gui/eliminar.png"))); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\eliminar.png"));
        btnEliminar.setText("Eliminar");
        btnEliminar.setToolTipText("Eliminar al jugador actual");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\img\\editar.png"));
        btnEdit.setText("Editar");
        btnEdit.setToolTipText("Editar al Jugador Actual");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(65, 65, 65)
                        .addComponent(btnEdit)
                        .addGap(65, 65, 65)
                        .addComponent(btnEliminar)
                        .addGap(118, 118, 118))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblScore)
                            .addGap(18, 18, 18)
                            .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblLevel)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblJuegof)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblId3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJuegof, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJuego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addJugador();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarJugador();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarJugador();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        editarJugador();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtIdComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtIdComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdComponentAdded

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
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEstudiantes().setVisible(true);
            }
        });
    }
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSave;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId3;
    private javax.swing.JLabel lblJuegof;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtJuego;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtScore;
    // End of variables declaration//GEN-END:variables
*/
}
