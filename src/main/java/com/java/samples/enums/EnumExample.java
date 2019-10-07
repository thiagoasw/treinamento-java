package com.java.samples.enums;

public class EnumExample {

    public static void main(String[] args) {
        
        for (UF uf : UF.values()) {
            System.out.println(uf);
        }
        
        System.out.println("=====================================");
        System.out.println(UF.AC.getRegiao());
        System.out.println(UF.AC.isRegiao(Regiao.SUL));
        
        System.out.println(UF.SC.getRegiao());
        System.out.println(UF.SC.isRegiao(Regiao.SUL));
        
        
        UF baka = UF.valueOf("DF");
        System.out.println(baka);
        System.out.println(baka.equals(UF.DF));
        System.out.println(UF.DF == baka);
        
        System.out.println("=====================================");
        
        int base = 10;
        System.out.println(UF.SC.apply(base));
        System.out.println(UF.DF.apply(base));
        System.out.println(UF.BA.apply(base));
        
        Regiao regiao = Regiao.valueOf("NORTE");
        UF.AC.isRegiao(regiao);
    }
    
}
