package wtz.com.mm.audit.logger.mm_app_audit_wtz.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import wtz.com.mm.audit.logger.mm_app_audit_wtz.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
