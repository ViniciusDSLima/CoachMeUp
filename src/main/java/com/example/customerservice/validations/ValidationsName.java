package com.example.customerservice.validations;

import com.example.customerservice.exceptions.errors.LengthException;
import com.example.customerservice.request.CustomerRegisterRequest;
import com.example.customerservice.request.CustomerUpdateRequest;

public interface ValidationsName {
    static void valideRegister(CustomerRegisterRequest customerRegisterRequest){

        if(customerRegisterRequest.getName().length() < 3) throw new LengthException("The minimum length for the name is 3 characters");

        if(customerRegisterRequest.getName().length() > 255) throw new LengthException("The maximum length for the name is 255 characters");
    }
    static void valideUpdate(CustomerUpdateRequest customerUpdateRequest){

        if(customerUpdateRequest.getName().length() < 3) throw new LengthException("The minimum length for the name is 3 characters");

        if(customerUpdateRequest.getName().length() > 255) throw new LengthException("The maximum length for the name is 255 characters");
    }
}
