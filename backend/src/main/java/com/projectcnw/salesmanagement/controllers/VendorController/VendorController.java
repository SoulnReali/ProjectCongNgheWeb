package com.projectcnw.salesmanagement.controllers.VendorController;

import com.projectcnw.salesmanagement.dto.ResponseObject;
import com.projectcnw.salesmanagement.dto.vendorDtos.ImportOrderDTO;
import com.projectcnw.salesmanagement.dto.vendorDtos.VendorDTO;
import com.projectcnw.salesmanagement.services.VendorService.IVendorService;
import com.projectcnw.salesmanagement.services.VendorService.impl.ImportOrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admin/supplier")
public class VendorController {
    private final IVendorService vendorService;

    VendorController(IVendorService importOrderService) {
        this.vendorService = importOrderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getSupplierList() {
        List<VendorDTO> importVenderDTOList = vendorService.findAll();
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(importVenderDTOList)
                .build());
    }

}