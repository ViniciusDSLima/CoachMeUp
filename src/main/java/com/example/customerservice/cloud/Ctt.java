package com.example.customerservice.cloud;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "", name = "CTT")
public interface Ctt {


}
