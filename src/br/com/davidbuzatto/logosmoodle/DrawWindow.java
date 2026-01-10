package br.com.davidbuzatto.logosmoodle;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.geom.Path;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import java.awt.Color;
import java.io.File;

/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class DrawWindow extends EngineFrame {
    
    private int logoX;
    private int logoY;
    private int logoWidth;
    private int logoHeight;
    
    private String siglaDisciplina;
    private String nomeDisciplina;
    private String nomeCurso;
    private String nomeProfessor;
    
    private String[] partesNomeDisciplina;
    
    private Path pBaixo;
    private Path pCima;
    
    private int marginRight = 10;
    private int marginTop = 16;
    private int marginBottom = 20;
    
    private Color corFundo;
    private Color corBorda;
    private Color corCima;
    private Color corBaixo;
    
    private Color corSigla;
    private Color corCimaSigla;
    private Color corNomeDisciplina;
    private Color corCimaNomeDisciplina;
    
    private Color corNomeCurso;
    private Color corBaixoNomeCurso;
    private Color corNomeProfessor;
    private Color corBaixoNomeProfessor;
    
    private boolean mostrarCima;
    private boolean mostrarBaixo;
    private boolean mostrarBorda;
    
    public DrawWindow() {
        
        super( 500, 500, "Imagem do Curso", 60, true, false, false, true, false, false );
        setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );
        
        logoWidth = 490;
        logoHeight = 230;
        logoX = getScreenWidth() / 2 - logoWidth / 2;
        logoY = getScreenHeight() / 2 - logoHeight / 2;
        
        reset();
        
        pBaixo = new Path();
        pBaixo.moveTo( logoX, logoY + 84 );
        pBaixo.lineTo( logoX + 260, logoY + logoHeight );
        pBaixo.lineTo( logoX, logoY + logoHeight );
        pBaixo.close();
        
        pCima = new Path();
        pCima.moveTo( logoX, logoY );
        pCima.lineTo( logoX + 204, logoY );
        pCima.lineTo( logoX, logoY + 126 );
        pCima.close();
        
    }
    
    public void reset() {
        
        siglaDisciplina = "SIGLA";
        nomeDisciplina = "Nome\nda Disciplina";
        nomeCurso = "Nome do Curso";
        nomeProfessor = "Nome do Professor";
        
        partesNomeDisciplina = nomeDisciplina.split( "\n" );
        
        mostrarCima = true;
        mostrarBaixo = true;
        mostrarBorda = true;
        
    }
    
    @Override
    public void create() {
        
        setDefaultFontName( "Century Gothic" );
        setDefaultFontSize( 40 );
        
    }
    
    @Override
    public void update( double delta ) {
    }
    
    @Override
    public void draw() {
        
        clearBackground( corFundo );
        
        beginScissorMode( new Rectangle( logoX, logoY, logoWidth, logoHeight ) );
        
        drawTextData();
        
        if ( mostrarBorda ) {
            drawRectangle( logoX, logoY, logoWidth - 1, logoHeight - 1, corBorda );
        }
        
        endScissorMode();
        
        drawRectangle( 0, 0, getScreenWidth() - 1, getScreenHeight() - 1, corBorda );
    
    }
    
    private void drawTextData() {
        
        String sigla = siglaDisciplina + ": ";
        String nome = partesNomeDisciplina[0];
        
        setFontStyle( FONT_BOLD );
        int wSigla = measureText( sigla );
        
        setFontStyle( FONT_PLAIN );
        int wNome = measureText( nome );
        
        setFontStyle( FONT_BOLD );
        drawText( sigla, logoX + logoWidth - wSigla - wNome - marginRight, logoY + marginTop, corSigla );
        
        setFontStyle( FONT_PLAIN );
        drawText( nome, logoX + logoWidth - wNome - marginRight, logoY + marginTop, corNomeDisciplina );
        
        for ( int i = 1; i < partesNomeDisciplina.length; i++ ) {
            nome = partesNomeDisciplina[i];
            Rectangle rNome = measureTextBounds( nome );
            drawText( nome, logoX + logoWidth - rNome.width - marginRight, logoY + marginTop + rNome.height * i, corNomeDisciplina );
        }
        
        setFontStyle( FONT_BOLD );
        setFontSize( 20 );
        
        int wNomeProfessor = measureText( nomeProfessor );
        Rectangle rNomeCurso = measureTextBounds( nomeCurso );
        
        drawText( nomeProfessor, logoX + logoWidth - wNomeProfessor - marginRight, logoY + logoHeight - marginBottom, corNomeProfessor );
        drawText( nomeCurso, logoX + logoWidth - rNomeCurso.width - marginRight, logoY + logoHeight - rNomeCurso.height - marginBottom, corNomeCurso );
        
        if ( mostrarCima ) {
            
            fillPath( pCima, corCima );
            beginScissorMode( pCima );
            setFontStyle( FONT_BOLD );
            setFontSize( 40 );
            drawText( sigla, logoX + logoWidth - wSigla - wNome - marginRight, logoY + marginTop, corCimaSigla );
            
            setFontStyle( FONT_PLAIN );
            nome = partesNomeDisciplina[0];
            drawText( nome, logoX + logoWidth - wNome - marginRight, logoY + marginTop, corCimaNomeDisciplina );

            for ( int i = 1; i < partesNomeDisciplina.length; i++ ) {
                nome = partesNomeDisciplina[i];
                Rectangle rNome = measureTextBounds( nome );
                drawText( nome, logoX + logoWidth - rNome.width - marginRight, logoY + marginTop + rNome.height * i, corCimaNomeDisciplina );
            }
            
            endScissorMode();
            
        }
        
        if ( mostrarBaixo ) {
            
            fillPath( pBaixo, corBaixo );
            beginScissorMode( pBaixo );
            
            setFontStyle( FONT_BOLD );
            setFontSize( 40 );
            drawText( sigla, logoX + logoWidth - wSigla - wNome - marginRight, logoY + marginTop, corCimaSigla );
            
            setFontStyle( FONT_PLAIN );
            nome = partesNomeDisciplina[0];
            drawText( nome, logoX + logoWidth - wNome - marginRight, logoY + marginTop, corCimaNomeDisciplina );

            for ( int i = 1; i < partesNomeDisciplina.length; i++ ) {
                nome = partesNomeDisciplina[i];
                Rectangle rNome = measureTextBounds( nome );
                drawText( nome, logoX + logoWidth - rNome.width - marginRight, logoY + marginTop + rNome.height * i, corCimaNomeDisciplina );
            }
            
            setFontStyle( FONT_BOLD );
            setFontSize( 20 );
            drawText( nomeProfessor, logoX + logoWidth - wNomeProfessor - marginRight, logoY + logoHeight - marginBottom, corBaixoNomeProfessor );
            drawText( nomeCurso, logoX + logoWidth - rNomeCurso.width - marginRight, logoY + logoHeight - rNomeCurso.height - marginBottom, corBaixoNomeCurso );
            endScissorMode();
            
        }
        
    }

    public void salvarImagem( File arquivo ) {
        saveScreenshot( "png", arquivo, logoX, logoY, logoWidth, logoHeight );
    }
    
    public String getSiglaDisciplina() {
        return siglaDisciplina;
    }

    public void setSiglaDisciplina( String siglaDisciplina ) {
        this.siglaDisciplina = siglaDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina( String nomeDisciplina ) {
        this.nomeDisciplina = nomeDisciplina;
        partesNomeDisciplina = nomeDisciplina.split( "\n" );
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso( String nomeCurso ) {
        this.nomeCurso = nomeCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor( String nomeProfessor ) {
        this.nomeProfessor = nomeProfessor;
    }

    public Color getCorFundo() {
        return corFundo;
    }

    public void setCorFundo( Color corFundo ) {
        this.corFundo = corFundo;
    }

    public Color getCorBorda() {
        return corBorda;
    }

    public void setCorBorda( Color corBorda ) {
        this.corBorda = corBorda;
    }

    public Color getCorCima() {
        return corCima;
    }

    public void setCorCima( Color corCima ) {
        this.corCima = corCima;
    }

    public Color getCorBaixo() {
        return corBaixo;
    }

    public void setCorBaixo( Color corBaixo ) {
        this.corBaixo = corBaixo;
    }

    public Color getCorSigla() {
        return corSigla;
    }

    public void setCorSigla( Color corSigla ) {
        this.corSigla = corSigla;
    }

    public Color getCorCimaSigla() {
        return corCimaSigla;
    }

    public void setCorCimaSigla( Color corCimaSigla ) {
        this.corCimaSigla = corCimaSigla;
    }
    
    public Color getCorCimaNomeDisciplina() {
        return corCimaNomeDisciplina;
    }

    public void setCorCimaNomeDisciplina( Color corCimaNomeDisciplina ) {
        this.corCimaNomeDisciplina = corCimaNomeDisciplina;
    }

    public Color getCorNomeDisciplina() {
        return corNomeDisciplina;
    }

    public void setCorNomeDisciplina( Color corNomeDisciplina ) {
        this.corNomeDisciplina = corNomeDisciplina;
    }

    public Color getCorNomeCurso() {
        return corNomeCurso;
    }

    public void setCorNomeCurso( Color corNomeCurso ) {
        this.corNomeCurso = corNomeCurso;
    }

    public Color getCorBaixoNomeCurso() {
        return corBaixoNomeCurso;
    }

    public void setCorBaixoNomeCurso( Color corBaixoNomeCurso ) {
        this.corBaixoNomeCurso = corBaixoNomeCurso;
    }

    public Color getCorNomeProfessor() {
        return corNomeProfessor;
    }

    public void setCorNomeProfessor( Color corNomeProfessor ) {
        this.corNomeProfessor = corNomeProfessor;
    }

    public Color getCorBaixoNomeProfessor() {
        return corBaixoNomeProfessor;
    }

    public void setCorBaixoNomeProfessor( Color corBaixoNomeProfessor ) {
        this.corBaixoNomeProfessor = corBaixoNomeProfessor;
    }

    public boolean isMostrarCima() {
        return mostrarCima;
    }

    public void setMostrarCima( boolean mostrarCima ) {
        this.mostrarCima = mostrarCima;
    }

    public boolean isMostrarBaixo() {
        return mostrarBaixo;
    }

    public void setMostrarBaixo( boolean mostrarBaixo ) {
        this.mostrarBaixo = mostrarBaixo;
    }

    public boolean isMostrarBorda() {
        return mostrarBorda;
    }

    public void setMostrarBorda( boolean mostrarBorda ) {
        this.mostrarBorda = mostrarBorda;
    }
    
}
