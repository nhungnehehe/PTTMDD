package com.phamtuyetnhung.models;

import java.util.ArrayList;

public class ListPaymentMethod {
    ArrayList<PaymentMethod> paymentMethods;

    public ListPaymentMethod()
    {
        paymentMethods = new ArrayList<>();
    }
    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }
    public void addPaymentMethod(PaymentMethod pm)
    {
        paymentMethods.add(pm);
    }
    public void gen_payments_method()
    {
        paymentMethods.add(new PaymentMethod(1,"Banking Account","Chuyen khoan ngan hang"));
        paymentMethods.add(new PaymentMethod(2,"Momo","Thanh toan vi Momo"));
        paymentMethods.add(new PaymentMethod(3,"Cash","Thanh toan tien mat"));
        paymentMethods.add(new PaymentMethod(4,"COD","Nhan hang roi thanh toan"));
    }
}
