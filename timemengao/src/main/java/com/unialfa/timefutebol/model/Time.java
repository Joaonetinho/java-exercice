package com.unialfa.timefutebol.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Time {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private Integer anoFundacao;
    private String estado;
    private Integer titulo;

}
