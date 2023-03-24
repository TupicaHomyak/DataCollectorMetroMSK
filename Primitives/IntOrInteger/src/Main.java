public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.  (1025, 1040-1103, 1105)

        for (char c = 'А'; c <= 'я'; c++) {
            int i = (int) c;
            System.out.println(c + " - " + i);
        }
        char eo = 'ё';
            int eoCode = eo;
            System.out.println(eo + " - " + eoCode);

        char eO = 'Ё';
            int eOCode = eO;
            System.out.println(eO + " - " + eOCode);
    }
}
