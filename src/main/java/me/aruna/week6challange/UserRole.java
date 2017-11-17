package me.aruna.week6challange;

import javax.persistence.*;
import java.util.Set;
@Entity
public class UserRole {
    

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private long id;

        @Column(unique=true)
        private String role;

        @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
        private Set<UserRole> users;

        public UserRole(String role) {
            this.role = role;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public Set<UserRole> getUsers() {
            return users;
        }

        public void setUsers(Set<UserRole> users) {
            this.users = users;
        }
    }


