package com.rohit.project.billing.hospitalbillingmodule.controller;

import com.rohit.project.billing.hospitalbillingmodule.domain.Bill;
import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import com.rohit.project.billing.hospitalbillingmodule.dto.BillResponse;
import com.rohit.project.billing.hospitalbillingmodule.exception.AmountNotPaidException;
import com.rohit.project.billing.hospitalbillingmodule.exception.BillNotFoundException;
import com.rohit.project.billing.hospitalbillingmodule.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/bill")
@RestController
public class BillController {
    @Autowired
    private BillService service;

    @PostMapping
    public ResponseEntity<BillResponse<BillDto>> creatingBill(@Valid @RequestBody BillDto dto) {
        var bill = service.creatingBill(dto);
        var response = new BillResponse<BillDto>();
        response.setSts("success");
        response.setMsg("bill created");
        response.setBody(bill);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<BillResponse<BillDto>> updateBill(@Valid @RequestBody BillDto dto) {
        try {
            var billUp = service.updateBill(dto);
            var response = new BillResponse<BillDto>();
            response.setSts("success");
            response.setMsg("bill updated");
            response.setBody(billUp);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (BillNotFoundException e) {
            var response = new BillResponse<BillDto>();
            response.setMsg(e.getMessage());
            response.setSts("fail");
            response.setBody(null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/all")
    public ResponseEntity<BillResponse<List<BillDto>>> findAllBills() {

        var response = new BillResponse<List<BillDto>>();
        response.setSts("success");
        response.setMsg("all bills ");
        response.setBody(service.allBills());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/paid")
    public ResponseEntity<BillResponse<Boolean>> markedAsPaid(@RequestBody BillDto dto) {
        try {
            var paid = service.billPaid(dto.getId(), dto.getStatus());
            var response = new BillResponse<Boolean>();
            response.setSts("success");
            response.setMsg("status updated");
            response.setBody(paid);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (AmountNotPaidException a) {
            var response = new BillResponse<Boolean>();
            response.setMsg(a.getMessage());
            response.setSts("fail");
            response.setBody(null);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/search")
    public ResponseEntity<BillResponse> searchAllBills(@RequestBody BillDto dto) {

        var response = new BillResponse();
        response.setSts("success");
        response.setMsg("selected");
        response.setBody(service.searchBills(dto.getId()));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<BillResponse<Bill>> search(@Valid @PathVariable int id) {
        Bill upDated = service.searchBills(id);
        var response = new BillResponse<Bill>();
        response.setSts("success");
        response.setMsg(" user " + upDated.getPatientName() + " has " + upDated.getAmount());
        response.setBody(upDated);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }
}
