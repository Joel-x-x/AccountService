package com.accountservice.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
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

    @Column(unique = true)
    private String username;
    private String fullname;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean email_confirmed;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String apiKey;
    private Boolean exists;

    // Create
    public UserEntity(DataSaveUser dataSaveUser, String password) {
        this.username = dataSaveUser.username();
        this.fullname = dataSaveUser.fullname();
        this.email = dataSaveUser.email();
        this.password = password;
        this.email_confirmed = false;
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
        this.exists = true;
    }

    // Update
    public void update(DataUpdateUser dataUpdateUser) {
        if(dataUpdateUser.fullname() != null) {
            this.fullname = dataUpdateUser.fullname();
        }

        if(dataUpdateUser.username() != null) {
            this.username = dataUpdateUser.username();
        }

        if(dataUpdateUser.email() != null) {
            this.email = dataUpdateUser.email();
        }
    }
}
