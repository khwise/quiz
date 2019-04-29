package com.quiz.core.entity;

import com.quiz.core.commons.Auditable;
import com.quiz.core.persistences.converts.BooleanConverter;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@IdClass(CommonCodeItem.PK.class)
@Entity
@Table(name = "tb_common_code_item")
@Data
public class CommonCodeItem extends Auditable<Long> {

    @Id
    @Column(name = "group_id")
    @Min(4)
    @Max(4)
    private String groupId;

    @Id
    @Column(name = "code")
    @Min(4)
    @Max(4)
    private String code;

    @Column(name = "code_nm")
    @NotBlank
    private String codeName;

    @Column(name = "code_value")
    private String codeValue;

    @Column(name = "code_desc")
    private String codeDesc;

    @Column(name = "used")
    @Convert(converter = BooleanConverter.class)
    private Boolean used;

    @Data
    public static class PK implements Serializable {

        private String groupId;

        private String code;

        public int hashCode() {
            return this.toString().hashCode();
        }

        // todo : 구문분석
        public boolean equals(Object o) {
            if (o == this)
                return true;

            if (!(o instanceof PK))
                return false;

            if (o == null)
                return false;

            PK pk = (PK)o;
            return pk.toString().equals(new StringBuilder().append(groupId).append(code).toString());
        }

        public String toString() {
            return new StringBuilder().append(groupId).append(code).toString();
        }
    }
}
