package io.tntra.javabootcamp.enumpkg;

public enum Acc_Type { SAVING("Saving"),
    CURRENTACCOUNT("Current"),
    FIXEDDEPOSIT("FixedDeposit");

    public final String values;

    Acc_Type(String values) {

        this.values = values;
    }


    public static Acc_Type EnumtoString (String values) {
        for(Acc_Type ac : values()){
            ac.values.equals(values);
            return ac;
        }
        return null;
    }
}
