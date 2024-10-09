package com.api.maintenance.dto;

import com.api.maintenance.models.MantenimientoModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MantenimientoUpdateRequest {
    private MantenimientoModel.Status status;
    private Integer tecnicoId;


}
