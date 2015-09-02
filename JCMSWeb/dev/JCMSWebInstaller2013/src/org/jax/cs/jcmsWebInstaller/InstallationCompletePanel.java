/****
Copyright (c) 2015 The Jackson Laboratory

This is free software: you can redistribute it and/or modify it 
under the terms of the GNU General Public License as published by  
the Free Software Foundation, either version 3 of the License, or  
(at your option) any later version.
 
This software is distributed in the hope that it will be useful,  
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this software.  If not, see <http://www.gnu.org/licenses/>.
****/

package org.jax.cs.jcmsWebInstaller;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

/**
 *
 * @author cnh
 */
public class InstallationCompletePanel extends JCMSPanel {
    private Connector connector = null;

    /**
     * Creates new form InstallationCompletePanel
     */
    public InstallationCompletePanel(JDesktopPane desktopPane, JFrame frame) {
        super.JCMSPanel(desktopPane, frame);
        initComponents();
    }

    public void initialize() {
        try {
            this.connector = ((JCMSWebInstallerApp)this.getFrame()).getConnector();
            String msg = "Start JCMS Web Application Server and open JCMS Web.  " +
                             "\n\nPlease follow these instructions to complete the installation and setup:  " +
                            "\n\n1. Click \"Start JCMS Web Application Server\" button below to start JCMS Web application server.  A link will appear below.  Click the link in 1 to 2 minutes to open JCMS Web." +
                            this.getStartCommand() +
                            "\n2. Using a browser, open http://"+ InetAddress.getLocalHost().getHostName() +":8080/jcms to launch JCMS Web." + 
                            "\n3. Log in as \"mtsadmin\" using password \"changeMe\"." +
                            "\n4. Navigate to the Administration module, create user accounts and select privileges." +
                            "\n\nFor a detailed set of startup instructions refer to JCMS Web Installation Guide link on the next page." +
                            "\n\nClick Next to get a complete list of JCMS Web resources and reference material." +
                            "\n";
            this.txtMessage.setText(msg);
            btnBrowseURL.setVisible(false);
            this.txtMessage.setCaretPosition(0);
        } catch (UnknownHostException e) {
        }
    }    
    
    private String getStartCommand() {
        String instruction = "";
        if (Utils.isWindows()) {
            instruction = "  For future referenence, you can also start it using Windows Explorer by double clicking this file:";
            instruction += "  "+ this.getInputDTO().getWebInstallationDirectory() + File.separator + "jcmsweb.cmd";
        } else {
            instruction = "For future reference, you can also start it by opening a terminal and running this script:"
                        + "  "+ this.getInputDTO().getWebInstallationDirectory() + File.separator + "jcmsweb.command";
        }
        return instruction;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        btnStartApplicationServer = new javax.swing.JButton();
        btnBrowseURL = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("JCMS Web Application Server");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtMessage.setEditable(false);
        txtMessage.setColumns(20);
        txtMessage.setLineWrap(true);
        txtMessage.setRows(5);
        txtMessage.setText("[See code behind for these instructions]");
        txtMessage.setWrapStyleWord(true);
        txtMessage.setCaretPosition(0);
        jScrollPane1.setViewportView(txtMessage);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonNextActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonNextActionPerformed(evt);
            }
        });

        btnStartApplicationServer.setText("Start JCMS Web Application Server");
        btnStartApplicationServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartApplicationServerActionPerformed(evt);
            }
        });

        btnBrowseURL.setForeground(new java.awt.Color(0, 0, 255));
        btnBrowseURL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBrowseURL.setText("Click here in 2 minutes, to open JCMS Web!");
        btnBrowseURL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBrowseURL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBrowseURLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStartApplicationServer)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBrowseURL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nextButton)))
                        .addGap(48, 48, 48))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStartApplicationServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBrowseURL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(backButton))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonNextActionPerformed
        this.previousPanel(this, this.getJcmsView());
    }//GEN-LAST:event_backButtonNextActionPerformed

    private void nextButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonNextActionPerformed
        this.nextPanel(this, this.getJcmsView().getResourcePanel(), this.getJcmsView());
    }//GEN-LAST:event_nextButtonNextActionPerformed

    private void btnStartApplicationServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartApplicationServerActionPerformed
        ProcessExec process = new ProcessExec();
        String installationDirectory = this.connector.getInputDTO().getWebInstallationDirectory();
        String runCommand = "";
        if (Utils.isWindows())
        runCommand = "jcmsweb.cmd";
        else
        runCommand = "jcmsWeb.command";
        runCommand = installationDirectory + File.separator + runCommand;
        System.out.println("\nJBOSS run command is: " + runCommand);
        int exitCode = process.runCommand(runCommand, installationDirectory + File.separator + "jcmsjboss.log");
        if (exitCode != 0) {
            this.btnBrowseURL.setText("JCMS Web Application Server may have a startup issue, please restart.");
        }
        this.btnBrowseURL.setVisible(true);
        this.getFrame().repaint();
        this.getFrame().validate();
    }//GEN-LAST:event_btnStartApplicationServerActionPerformed

    private void btnBrowseURLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBrowseURLMouseClicked
        Utils utils = new Utils();
        try {
            BrowserLaunch.openURL("http://"+ InetAddress.getLocalHost().getHostName() + ":8080/jcms");
        } catch (UnknownHostException e) {
            
        }
    }//GEN-LAST:event_btnBrowseURLMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel btnBrowseURL;
    private javax.swing.JButton btnStartApplicationServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextArea txtMessage;
    // End of variables declaration//GEN-END:variables

    public InputDTO getInputDTO() {
        return connector.getInputDTO();
    }

}
