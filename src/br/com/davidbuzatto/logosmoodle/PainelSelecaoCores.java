package br.com.davidbuzatto.logosmoodle;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class PainelSelecaoCores extends JPanel {
    
    private Color cor;
    
    public PainelSelecaoCores() {
        cor = Color.BLACK;
        setPreferredSize( new Dimension( 20, 20 ) );
        setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ) );
    }

    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        g.setColor( cor );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        g.setColor( Color.BLACK );
        g.drawRect( 0, 0, getWidth() - 1, getHeight() - 1 );
    }
    
    public Color getCor() {
        return cor;
    }

    public void setCor( Color cor ) {
        if ( cor == null ) {
            this.cor = Color.BLACK;
        } else {
            this.cor = cor;
        }
        repaint();
    }
    
}
