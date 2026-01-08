package br.com.davidbuzatto.logosmoodle;

import java.awt.Color;
import java.io.Serializable;

/**
 * Record para armazenamento dos dados do logo.
 * 
 * @author Prof. Dr. David Buzatto
 */
public record DadosLogo(
    String siglaDisciplina,
    String nomeDisciplina,
    String nomeCurso,
    String nomeProfessor,
    boolean mostrarDetalheCima,
    boolean mostrarDetalheBaixo,
    boolean mostrarBorda,
    Color corFundo,
    Color corBorda,
    Color corCima,
    Color corBaixo,
    Color corSigla,
    Color corSiglaCima,
    Color corNomeDisciplina,
    Color corNomeCurso,
    Color corNomeCursoBaixo,
    Color corNomeProfessor,
    Color corNomeProfessorBaixo ) implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
}
