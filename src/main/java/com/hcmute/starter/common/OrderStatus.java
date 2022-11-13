package com.hcmute.starter.common;

public enum OrderStatus {
  AWAITINGPAYMENT(1, "Chờ thanh toán"),
  PROGRESSING(2, "Đang xử lý"),
  DELIVERING(3, "Đang vận chuyển"),
  DELIVERED(4, "Đã giao"),
  CANCELED(5, "Đã hủy");

  private final int id;
  private final String name;

  OrderStatus(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public static OrderStatus getOrderStatusById(int id) {
    for (OrderStatus o : values()) {
      if (o.id == id) {
        return o;
      }
    }
    return null;
  }
}
