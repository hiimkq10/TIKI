package com.hcmute.starter.mapping;


import com.hcmute.starter.common.OrderStatus;
import com.hcmute.starter.model.entity.OrderEntity;
import com.hcmute.starter.model.entity.PaymentEntity;
import com.hcmute.starter.model.entity.ShipEntity;
import com.hcmute.starter.model.entity.userAddress.AddressEntity;
import com.hcmute.starter.model.payload.request.Order.AddOrderRequest;
import com.hcmute.starter.model.payload.response.Order.OrderResponse;
import com.hcmute.starter.model.payload.response.Order.OrderStatusDTO;
import com.hcmute.starter.service.AddressService;
import com.hcmute.starter.service.PaymentService;
import com.hcmute.starter.service.ShipService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapping {

  @Autowired
  AddressService addressService;
  @Autowired
  PaymentService paymentService;
  @Autowired
  ShipService shipService;


  public OrderEntity ModelToEntity(AddOrderRequest addOrderRequest) {
    AddressEntity address = addressService.findById(addOrderRequest.getIdAddress());
    PaymentEntity payment = paymentService.getPaymentById(addOrderRequest.getIdPayment());
    ShipEntity ship = shipService.findShipById(addOrderRequest.getIdShip());

    OrderEntity order = new OrderEntity();
    order.setAddressOrder(address);
    order.setPaymentOrder(payment);
    order.setShipOrder(ship);
    order.setCreatedDate(LocalDateTime.now());
    order.setDelStatus(OrderStatus.AWAITINGPAYMENT);
    order.setExpectedDate(LocalDate.from(order.getCreatedDate().plusDays(2)));
    return order;
  }

  public OrderResponse OrderToOrderResponse(OrderEntity order) {
    if (order == null) {
      return null;
    }

    OrderResponse orderResponse = new OrderResponse();
    orderResponse.setOrderId(order.getOrderId());
    orderResponse.setOrderStatusDTO(
        new OrderStatusDTO(orderResponse.getDelStatus().getId(), orderResponse.getDelStatus().getName()));
    orderResponse.setUserOrder(order.getUserOrder());
    orderResponse.setCartOrder(order.getCartOrder());
    orderResponse.setName(order.getName());
    orderResponse.setAddressOrder(order.getAddressOrder());
    orderResponse.setCreatedDate(order.getCreatedDate());
    orderResponse.setPaymentOrder(order.getPaymentOrder());
    orderResponse.setShipOrder(order.getShipOrder());
    orderResponse.setTotal(order.getTotal());
    orderResponse.setDelStatus(order.getDelStatus());
    orderResponse.setExpectedDate(order.getExpectedDate());

    return orderResponse;
  }
}
