package com.hcmute.starter.model.payload.response;

import com.hcmute.starter.model.entity.AttributeEntity;
import com.hcmute.starter.model.entity.AttributeOptionEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Setter
@Getter
public class ProductResponse {
    private UUID id;
    private String image;
    private String name;
    private String description;
    private int rate;
    private double price;
    private double discount;
    private int sold;
    private String brand;
    private String origins;
    private String category;
    private List<String> img;
    private Set<AttributeOptionEntity> attributeEntitySet;

    public ProductResponse(UUID id, String image, String name, String description, String category, int rate, double price, double discount, int sold, String brand, String origins, List<String> img, Set<AttributeOptionEntity> attributeEntitySet) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.rate = rate;
        this.price = price;
        this.discount = discount;
        this.sold = sold;
        this.brand = brand;
        this.origins = origins;
        this.img = img;
        this.attributeEntitySet = attributeEntitySet;
    }
}
