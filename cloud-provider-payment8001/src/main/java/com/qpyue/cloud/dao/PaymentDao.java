package com.qpyue.cloud.dao;

import com.qpyue.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface PaymentDao extends Mapper<Payment> {

    int create(Payment payment);
    Payment getPaymentById(@Param("id") Long id);
}
