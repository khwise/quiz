package com.quiz.core.entity;

import com.quiz.core.commons.Auditable;
import com.quiz.core.persistences.converts.BooleanConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@IdClass(CommonCodeItem.PK.class)
@Entity
@Table(name = "tb_common_code_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeItem extends Auditable<Long> {

    @Id
    @Column(name = "group_id")
    @Size(min = 4, max = 4)
    private String groupId;

    @Id
    @Column(name = "code")
    @Size(min = 4, max = 4)
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
