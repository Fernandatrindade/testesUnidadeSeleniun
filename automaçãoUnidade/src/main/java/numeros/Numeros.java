package numeros;

public class Numeros {

    public boolean eUmaUnidade(int meuNumero) {
        boolean eUnidade = true;

        if(meuNumero > 9){
            eUnidade = false;
            System.out.println("Numero maior que 9 " + eUnidade);
        }
        else {
            System.out.println("Numero menor que 9");
        }
        return eUnidade;
    }
}
