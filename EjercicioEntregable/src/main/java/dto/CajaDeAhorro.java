package dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{
    private int cantOperaciones;
    public CajaDeAhorro(double saldo, int cantOperaciones){
        super(saldo);
        this.cantOperaciones=0;
    }
    @Override
    public synchronized boolean agregarSaldo(double monto){
        if (monto>0){
            this.saldo=this.saldo+monto;
            cantOperaciones++;
            return true;
        }
        return false;
    }
    @Override
    public synchronized boolean quitarSaldo (double monto){
        if (monto>0 && monto<=this.saldo){
            this.saldo=this.saldo - monto;
            cantOperaciones++;
            return true;
        }
        return false;
    }
    @Override
    public double getSaldo(){
        return this.saldo;
    }
    @Override
    public int getOperaciones(){
        return cantOperaciones;
    }
}
