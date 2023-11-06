package com.projectcnw.salesmanagement.controllers.VendorController;

import com.projectcnw.salesmanagement.dto.ResponseObject;
import com.projectcnw.salesmanagement.dto.vendorDtos.ImportOrderDTO;
import com.projectcnw.salesmanagement.services.VendorService.impl.ImportOrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/admin/import")
public class ImportOrderController {
    private final ImportOrderService importOrderService;

    ImportOrderController(ImportOrderService importOrderService) {
        this.importOrderService = importOrderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getImportOrderList() {
        List<ImportOrderDTO> importOrderDTOList = importOrderService.findAll();
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(importOrderDTOList)
                .build());
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name", "phone"})
    public ResponseEntity<ResponseObject> searchImport(@RequestParam(value = "name", defaultValue = "null") @Valid String name,
                                                       @RequestParam(value = "phone", defaultValue = "null") @Valid String phone) {
        List<ImportOrderDTO> importOrderDTOList = importOrderService.findAll();
        if (!Objects.equals(name, "null")) {
            importOrderDTOList = importOrderService.findByName(name);
        } else if (!Objects.equals(phone, "null")) {
            importOrderDTOList = importOrderService.findByPhone(phone);
        }
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(importOrderDTOList)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getImportDetail(@PathVariable("id") int orderId) {
        ImportOrderDTO importOrderDTOList = importOrderService.findById(orderId);

        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(importOrderDTOList)
                .build());
    }
}