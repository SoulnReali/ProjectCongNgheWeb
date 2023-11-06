package com.projectcnw.salesmanagement.controllers.VendorController;

import com.projectcnw.salesmanagement.dto.ResponseObject;
import com.projectcnw.salesmanagement.dto.vendorDtos.VendorDTO;
import com.projectcnw.salesmanagement.services.VendorService.IVendorService;
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
    @RequestMapping(method = RequestMethod.GET, params = {"name", "phone"})
    public ResponseEntity<ResponseObject> searchISupplier(@RequestParam(value = "name", defaultValue = "null") @Valid String name,
                                                          @RequestParam(value = "phone", defaultValue = "null") @Valid String phone) {
        VendorDTO importVenderDTO = null;
        if (!Objects.equals(name, "null")) {
            importVenderDTO = vendorService.findByName(name);
        } else if (!Objects.equals(phone, "null")) {
            importVenderDTO = vendorService.findByPhone(phone);
        }
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(importVenderDTO)
                .build());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getSupplierDetail (@PathVariable("id") int orderId) {
        VendorDTO vendorDTO = vendorService.findById(orderId);

        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(vendorDTO)
                .build());
    }
    @PostMapping
    public ResponseEntity<ResponseObject> addSupplier(@RequestBody @Valid VendorDTO createOrderDto) {
        VendorDTO vendorDto1 = vendorService.createVendorProduct(createOrderDto);
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(vendorDto1)
                .build());
    }
}