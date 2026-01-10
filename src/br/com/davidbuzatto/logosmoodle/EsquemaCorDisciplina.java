package br.com.davidbuzatto.logosmoodle;

import java.awt.Color;

/**
 * Esquema de cor para uma disciplina.
 * 
 * @author Prof. Dr. David Buzatto
 */
public record EsquemaCorDisciplina(
    String sigla,
    Color corBase
    ) {
    
}
