package br.com.alura.escola.shared.dominio.evento;

import java.time.LocalDateTime;
import java.util.Map;

public interface Evento {

    //momento que o evento foi disparado
    LocalDateTime momento();
    TipoEvento evento();
    Map<String, Object> informacoes();
}
