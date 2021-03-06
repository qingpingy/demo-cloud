package com.qpyue.cloud.controller;

import com.qpyue.cloud.entities.CommonResult;
import com.qpyue.cloud.entities.Payment;
import com.qpyue.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<Payment> create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入数据的ID: \t" + payment.getId());
        log.info("插入结果: " + result);
        if(result > 0){
            return CommonResult.success("插入数据成功", payment);
        }else{
            return CommonResult.fail("插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment == null){
            return CommonResult.fail("没有对应记录", payment);
        }else{
            return CommonResult.success("查询数据成功", payment);
        }
    }
}
