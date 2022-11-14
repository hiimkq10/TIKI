package com.hcmute.starter.model.payload.response.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcmute.starter.common.OrderStatus;
import com.hcmute.starter.model.entity.CartEntity;
import com.hcmute.starter.model.entity.PaymentEntity;
import com.hcmute.starter.model.entity.ShipEntity;
import com.hcmute.starter.model.entity.UserEntity;
import com.hcmute.starter.model.entity.userAddress.AddressEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OrderResponse {

  private int orderId;

  @JsonProperty("type")
  private OrderStatusDTO orderStatusDTO;

  private UserEntity userOrder;

  private CartEntity cartOrder;

  private String name;

  private AddressEntity addressOrder;

  private LocalDateTime createdDate;

  private PaymentEntity paymentOrder;

  private ShipEntity shipOrder;

  private double total;

  private OrderStatus delStatus;

  private LocalDate expectedDate;

}
