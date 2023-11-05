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

@RestController
@RequestMapping("/admin/import")
public class ImportOrderController {
    private ImportOrderService importOrderService;

    ImportOrderController(ImportOrderService importOrderService){
        this.importOrderService = importOrderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> getImportOrderList(){
        List<ImportOrderDTO> importOrderDTOList = importOrderService.findAll();
        return null;
    }
    @RequestMapping(method = RequestMethod.GET, params = {"name","phone"})
    public ResponseEntity<ResponseObject> searchImport(@RequestParam(value = "name", defaultValue = "null") @Valid String name,
                                                       @RequestParam(value = "phone", defaultValue = "null") @Valid String phone) {
        return ResponseEntity.ok(ResponseObject.builder()
                .responseCode(200)
                .message("Success")
                .data(name)
                .build());


}
}
