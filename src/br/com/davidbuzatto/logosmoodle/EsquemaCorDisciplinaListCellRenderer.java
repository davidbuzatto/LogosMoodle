package br.com.davidbuzatto.logosmoodle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 * Um renderizador para os itens do combo de esquemas de cores.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class EsquemaCorDisciplinaListCellRenderer extends DefaultListCellRenderer {
    
    @Override
    public Component getListCellRendererComponent( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        
        super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
        
        if ( value instanceof EsquemaCorDisciplina e ) {
            setText( e.sigla() );
            setIcon( new ImageIcon( createImage( e.corBase() ) ) );
        }
        
        return this;
        
    }
    
    private Image createImage( Color color ) {
        
        BufferedImage img = new BufferedImage( 10, 10, BufferedImage.TYPE_INT_ARGB );
        
        Graphics g = img.createGraphics();
        g.setColor( color );
        g.fillRect( 0, 0, img.getWidth(), img.getHeight() );
        g.setColor( Color.BLACK );
        g.drawRect( 0, 0, img.getWidth()-1, img.getHeight()-1 );
        g.dispose();
        
        return img;
        
    }
    
}
