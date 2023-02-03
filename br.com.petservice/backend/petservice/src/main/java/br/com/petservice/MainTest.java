package br.com.petservice;

import br.com.petservice.domain.model.Address;
import br.com.petservice.domain.model.Owner;

public class MainTest {
    public static void main(String[] args) {
        Owner o = new Owner(null, "123", "123","123", new Address(null,"rua teste","bairro teste",123));
        System.out.println(o.getAddress().district());
    }


}
