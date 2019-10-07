package com.java.samples.enums;

import java.text.MessageFormat;

public enum UF implements CalculoICMS {

    RO(11, "Rondônia", Regiao.NORTE, 25),
    AC(12, "Acre", Regiao.NORTE, 25),
    AM(13, "Amazonas", Regiao.NORTE, 25),
    RR(14, "Roraima", Regiao.NORTE, 25),
    PA(15, "Pará", Regiao.NORTE, 25),
    AP(16, "Amapá", Regiao.NORTE, 25),
    TO(17, "Tocantins", Regiao.NORTE, 25),
    MA(21, "Maranhão", Regiao.NORDESTE, 20),
    PI(22, "Piauí", Regiao.NORDESTE, 20),
    CE(23, "Ceará", Regiao.NORDESTE, 20),
    RN(24, "Rio Grande do Norte", Regiao.NORDESTE, 20),
    PB(25, "Paraíba", Regiao.NORDESTE, 20),
    PE(26, "Pernambuco", Regiao.NORDESTE, 20),
    AL(27, "Alagoas", Regiao.NORDESTE, 20),
    SE(28, "Sergipe", Regiao.NORDESTE, 20),
    BA(29, "Bahia", Regiao.NORDESTE, 20),
    MG(31, "Minas Gerais", Regiao.SUDESTE, 15),
    ES(32, "Espírito Santo", Regiao.SUDESTE, 15),
    RJ(33, "Rio de Janeiro", Regiao.SUDESTE, 15),
    SP(35, "São Paulo", Regiao.SUDESTE, 15),
    PR(41, "Paraná", Regiao.SUL, 10),
    SC(42, "Santa Catarina", Regiao.SUL, 10),
    RS(43, "Rio Grande do Sul", Regiao.SUL, 10),
    MS(50, "Mato Grosso do Sul", Regiao.CENTRO_OESTE, 5),
    MT(51, "Mato Grosso", Regiao.CENTRO_OESTE, 5),
    GO(52, "Goiás", Regiao.CENTRO_OESTE, 5),

    DF(53, "Distrito Federal", null, 99) {
        @Override
        public int apply(int base) {
            return super.apply(new CalculoICMSDF2().apply(base));
        }
    };

    private final int codigoIbge;

    private final String nome;

    private final Regiao regiao;

    private final int aliquota;

    private UF(int codigoIbge, String nome, Regiao regiao, int aliquota) {
        this.codigoIbge = codigoIbge;
        this.nome = nome;
        this.regiao = regiao;
        this.aliquota = aliquota;
    }

    public int getCodigoIbge() {
        return codigoIbge;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public boolean isRegiao(Regiao regiao) {
        return this.regiao == regiao;
    }

    public int getAliquota() {
        return aliquota;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} (IBGE: {3}, ALIQUOTA: {4}): {1} - {2}",
                name(), nome, regiao, codigoIbge, aliquota);
    }

    @Override
    public int apply(int base) {
        return base + aliquota;
    }
}
