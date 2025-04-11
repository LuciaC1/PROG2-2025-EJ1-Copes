package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{
    private int cantOperaciones;
    private double giroDescubierto;
    public CuentaCorriente(double saldo, int cantOperaciones, double giroDescubierto){
        super(saldo);
        this.giroDescubierto=giroDescubierto;
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
        if (monto>0){
            double saldoTemporal = this.saldo-monto;
            if (saldoTemporal >= -this.giroDescubierto){
                this.saldo= saldoTemporal;
                cantOperaciones++;
                return true;
            }
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
