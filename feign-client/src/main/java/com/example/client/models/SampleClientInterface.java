package com.example.client.models;

public interface SampleClientInterface {

    Response searchCustomerBusiness(final Request request);

    Response searchCustomerCostCenter(final Request request);

    Response insertCustomerPerson(final Request request);

    Response updateFiscalName(final Request request);
}
