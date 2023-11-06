package com.projectcnw.salesmanagement.dto.vendorDtos.createImportOrder;

import com.projectcnw.salesmanagement.models.Vendor;
import com.projectcnw.salesmanagement.models.enums.ShipmentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateImportOrder {

    @NotNull
    private Vendor vendor;

    @NotNull
    private int quantity;

    @NotNull
    private ShipmentStatus shipmentstatus;


}
