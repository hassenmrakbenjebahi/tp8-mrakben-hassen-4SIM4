package tn.esprit.tp8mrakbenhassen4sim4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp8mrakbenhassen4sim4.entity.ProjetDetail;
@Repository
public interface ProjetDetailRepository extends JpaRepository<ProjetDetail,Long> {

}
