package com.musahalilecer.productservice.dto.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponse {

    private Integer id;
    private String countryName;
    private String flag;

    private List<Integer> adressIds;
}
