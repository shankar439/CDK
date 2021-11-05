package com.Coherent.CDK.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@SQLDelete(sql = "Update projects SET deleted_flag = 1 Where id =?")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @NonNull
    @Column(name = "name")
    @Size(min = 3, max = 20)
    private String name;

    @Column(name = "is_active", columnDefinition = "TINYINT default 1")
    private byte isActive;

    @Column(name = "deleted_flag", columnDefinition = "TINYINT default 0")
    private byte deletedFlag;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

}
