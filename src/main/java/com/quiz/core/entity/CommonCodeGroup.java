package com.quiz.core.entity;

import com.quiz.core.commons.Auditable;
import com.quiz.core.persistences.converts.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_common_code_group")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeGroup extends Auditable<Long> {

    @Id
    @Column(name = "group_id")
    @Min(4)
    @Max(4)
    private String groupId;

    @Column(name = "code_nm")
    @NotBlank
    private String codeName;

    @Column(name = "code_value")
    private String codeValue;

    @Column(name = "used")
    @Convert(converter = BooleanConverter.class)
    private Boolean used;

    @Column(name = "cache")
    @Convert(converter = BooleanConverter.class)
    private Boolean cache;
}
