package com.example.client.clients;

import com.example.client.models.Request;
import com.example.client.models.Response;
import com.example.client.models.SampleClientInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "sampleService", url = "${feign.client.config.sampleService.url}")
public interface SampleClient extends SampleClientInterface {

    @RequestMapping(method = POST, value = "/search-business")
    Response searchCustomerBusiness(@RequestBody final Request request);

    @RequestMapping(method = POST, value = "/search-cost-center")
    Response searchCustomerCostCenter(@RequestBody final Request request);

    @RequestMapping(method = POST, value = "/insert-person")
    Response insertCustomerPerson(@RequestBody final Request request);

    @RequestMapping(method = POST, value = "/update-person-fiscal-name")
    Response updateFiscalName(@RequestBody final Request request);
}
