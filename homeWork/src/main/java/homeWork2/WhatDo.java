package homeWork2;

public class WhatDo {
    HowFibanachi howfibanachi = new HowFibanachi();
    HowFactarial howFactarial = new HowFactarial();
    public void whatDo(int num, int method, int parametr) {
        if(num == 1) howfibanachi.howFibanachi(method, parametr);
        if(num == 2) howFactarial.howFactarial(method, parametr);
    };
}
