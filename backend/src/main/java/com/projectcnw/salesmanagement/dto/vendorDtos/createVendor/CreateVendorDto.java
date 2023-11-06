package com.projectcnw.salesmanagement.dto.vendorDtos.createVendor;

import com.projectcnw.salesmanagement.models.enums.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateVendorDto {

    @NotNull
    private String name;


    private String address;

    @NotNull
    private String phone;


    private String email;
}
