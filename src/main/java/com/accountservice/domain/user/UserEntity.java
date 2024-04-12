package com.accountservice.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "user_id")
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID user_id;

    private String username;
    private String fullname;
    private String email;
    private String password;
    private Boolean email_confirmed;

    public UserEntity(DataSaveUser dataSaveUser, String password) {
        this.username = dataSaveUser.username();
        this.fullname = dataSaveUser.fullname();
        this.email = dataSaveUser.email();
        this.password = password;
        this.email_confirmed = false;
    }
}
