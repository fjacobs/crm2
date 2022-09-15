package nl.argo360.crm.repo;

import nl.argo360.crm.doa.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, String> { }
