package cz.manek.cryptii.ciphers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.jpa.repository.JpaRepository;

@ConditionalOnBean(name = "dataSource")
public interface CipherRepository extends JpaRepository<CipherDO, Long> {

}
