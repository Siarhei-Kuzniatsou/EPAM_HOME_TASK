package homeWork2;

public class WhatDo {
    private String[] args;

    WhatDo (String[] args) {
        this.args = args;
        whatDo(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
    }

    HowFibanachi howfibanachi = new HowFibanachi();
    HowFactarial howFactarial = new HowFactarial();
    private void whatDo(int num, int method, int parametr) {
        switch (num) {
            case 1 : howfibanachi.howFibanachi(method, parametr);
            break;
            case 2 : howFactarial.howFactarial(method, parametr);
            break;
        }
    }

}
