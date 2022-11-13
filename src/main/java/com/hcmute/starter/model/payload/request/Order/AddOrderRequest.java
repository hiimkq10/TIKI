package com.hcmute.starter.model.payload.request.Order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hcmute.starter.model.payload.request.CartRequest.AddItemCartRequest;
import java.util.Set;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddOrderRequest {
    @NotBlank(message = "Nhập id địa chỉ")
    private String idAddress;
    @NotBlank(message = "Nhập id phương thức thanh toán")
    private int idPayment;
    @NotBlank(message = "Nhập id loại vận chuyển")
    private int idShip;
    @JsonProperty("products")
    @NotEmpty(message = "Cart cant be empty")
    private Set<AddItemCartRequest> setOfCartItems;
    private UUID voucher;
    private Long DiscountId;
}
