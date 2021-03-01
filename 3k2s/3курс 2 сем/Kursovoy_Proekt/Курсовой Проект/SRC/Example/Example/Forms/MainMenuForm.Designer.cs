namespace Example
{
    partial class MainMenuForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.WorkWithExh = new System.Windows.Forms.Button();
            this.ViewExh = new System.Windows.Forms.Button();
            this.ExitButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // WorkWithExh
            // 
            this.WorkWithExh.Location = new System.Drawing.Point(86, 44);
            this.WorkWithExh.Name = "WorkWithExh";
            this.WorkWithExh.Size = new System.Drawing.Size(200, 50);
            this.WorkWithExh.TabIndex = 0;
            this.WorkWithExh.Text = "Work With Exhibitions";
            this.WorkWithExh.UseVisualStyleBackColor = true;
            this.WorkWithExh.Click += new System.EventHandler(this.WorkWithExh_Click);
            // 
            // ViewExh
            // 
            this.ViewExh.Location = new System.Drawing.Point(86, 147);
            this.ViewExh.Name = "ViewExh";
            this.ViewExh.Size = new System.Drawing.Size(200, 50);
            this.ViewExh.TabIndex = 1;
            this.ViewExh.Text = "View Exhibitons";
            this.ViewExh.UseVisualStyleBackColor = true;
            this.ViewExh.Click += new System.EventHandler(this.ViewExh_Click);
            // 
            // ExitButton
            // 
            this.ExitButton.Location = new System.Drawing.Point(86, 241);
            this.ExitButton.Name = "ExitButton";
            this.ExitButton.Size = new System.Drawing.Size(200, 50);
            this.ExitButton.TabIndex = 2;
            this.ExitButton.Text = "Exit";
            this.ExitButton.UseVisualStyleBackColor = true;
            this.ExitButton.Click += new System.EventHandler(this.ExitButton_Click);
            // 
            // MainMenuForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(393, 336);
            this.Controls.Add(this.ExitButton);
            this.Controls.Add(this.ViewExh);
            this.Controls.Add(this.WorkWithExh);
            this.Name = "MainMenuForm";
            this.Text = "MainMenuWindow";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button WorkWithExh;
        private System.Windows.Forms.Button ViewExh;
        private System.Windows.Forms.Button ExitButton;
    }
}