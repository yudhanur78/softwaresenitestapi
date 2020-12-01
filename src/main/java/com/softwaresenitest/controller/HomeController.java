package com.softwaresenitest.controller;

import com.softwaresenitest.entity.Trax;
import com.softwaresenitest.service.TraxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/transactionservice")
public class HomeController {
    @Autowired
    TraxService traxService;

    @PutMapping(path = "/transaction/{transaction_id}", consumes = "application/json")
    public Map<String, Object> trx1(@RequestBody Map<String, ?> param, @PathVariable("transaction_id") Long transaction_id) {
        Map<String, Object> result = new HashMap<>();
        if ((param.get("amount") != null) && (param.get("type") != null) && (param.get("parent_id") != null)) {
            Double amount = (Double) param.get("amount");
            String type = (String) param.get("type");
            Long parent_id = (Long) param.get("parent_id");

            Trax trax = traxService.findOneById(transaction_id);
            trax.setAmount(amount);
            trax.setType(type);
            trax.setParentId(parent_id);
            traxService.save(trax);

            result.put("amount", amount);
            result.put("type", type);
            result.put("parent_id", parent_id);
            result.put("status", "ok");
            ResponseEntity.ok().body("success");
            return result;
        } else {
            result.put("status", "failed");
            ResponseEntity.ok().body("failed");
            return null;
        }
    }

    @GetMapping(path = "/transaction/{transaction_id}")
    public Map<String, Object> trx2(@PathVariable("transaction_id") Long transaction_id) {
        Trax trax = traxService.findOneById(transaction_id);

        Map<String, Object> result = new HashMap<>();
        result.put("amount", trax.getAmount());
        result.put("type", trax.getType());
        result.put("parent_id", trax.getParentId());
        return result;
    }

    @GetMapping(path = "/types/{type}")
    public Long[] trx3(@PathVariable("type") String type) {
        List<Trax> traxList = traxService.findByType(type);

        Long[] result = new Long[traxList.size()];
        for (int i = 0; i < traxList.size(); i++) {
            result[i] = traxList.get(i).getId();
        }

        return result;
    }

    @GetMapping(path = "/sum/{transaction_id}")
    public Map<String, Object> trx4(@PathVariable("transaction_id") Long transaction_id) {
        Trax trax = traxService.findOneById(transaction_id);
        List<Trax> traxList = traxService.findByType(trax.getType());

        Map<String, Object> result = new HashMap<>();
        result.put("sum", traxList.stream().mapToDouble(Trax::getAmount).sum());
        return result;
    }
}
