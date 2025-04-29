package com.calamansi.demo.survey.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// @Transactional
public interface SurveyRepo extends JpaRepository<SurveyEntity, Long>{

	public Optional<SurveyEntity> findById(Long id);
	public Optional<SurveyEntity> findByName(String name);
//	public SurveyEntity save(SurveyEntity entity);
//	public List<SurveyEntity> saveAll(List<SurveyEntity> entities);
	
	
//	public List<AlertSubscription> findByAlertSubscriptionAgreementList_AgreementTypeCd_AndAlertSubscriptionAgreementList_AgreementNum (
//			String agreementTypeCd,
//			String agreementNum);

//	public AlertSubscription findById_AndAlertSubscriptionAgreementList_Id(
//			Long alertSubscriptionId, 
//			Long alertSubscriptionAgreementId);

//	@Query(value = "SELECT a from AlertSubscription a WHERE a.statusCd = 'TO_BE_PURGED' AND a.updatedTs <= ?1")
//    List<AlertSubscription> retrieveSubscriptionsToBeRemoved(Date dateLimit);

	
//	@Query("select a from AlertSubscriptionEntity a where a.alertSubscriptionAgreementList.agreementTypeCd = :agreementTypeCd"
//		+ "and a.alertSubscriptionAgreementList.agreementNum = :agreementNum", nativeQuery = true)
	
//	public List<AlertSubscriptionEntity> findAlertSubscriptionByProduct(
//		@Param("agreementTypeCd") String agreementTypeCd, 
//		@Param("agreementNum") String agreementNum);

	
}
