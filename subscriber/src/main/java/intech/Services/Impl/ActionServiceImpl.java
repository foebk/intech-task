package intech.Services.Impl;

import intech.DTO.MessageDTO;
import intech.Entities.PurchaseEntity;
import intech.Entities.SubcriptionEntity;
import intech.Repos.PurchaseRepo;
import intech.Repos.SubscriptionRepo;
import intech.Services.ActionService;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl implements ActionService {
    private final PurchaseRepo purchaseRepo;
    private final SubscriptionRepo subscriptionRepo;

    public ActionServiceImpl(PurchaseRepo purchaseRepo, SubscriptionRepo subscriptionRepo) {
        this.purchaseRepo = purchaseRepo;
        this.subscriptionRepo = subscriptionRepo;
    }

    public void saveAction(MessageDTO messageDTO) {
        if (messageDTO.getAction().equals("PURCHASE")) {
            savePurchaseAction(messageDTO);
        } else {
            saveSubscriptionAction(messageDTO);
        }
    }

    private void savePurchaseAction(MessageDTO messageDTO) {
        PurchaseEntity purchaseEntity = new PurchaseEntity();

        purchaseEntity.setMsisdn(messageDTO.getMsisdn());
        purchaseEntity.setTimestamp(messageDTO.getTimestamp());

        purchaseRepo.save(purchaseEntity);
    }

    private void saveSubscriptionAction(MessageDTO messageDTO) {
        SubcriptionEntity subcriptionEntity = new SubcriptionEntity();

        subcriptionEntity.setMsisdn(messageDTO.getMsisdn());
        subcriptionEntity.setTimestamp(messageDTO.getTimestamp());

        subscriptionRepo.save(subcriptionEntity);
    }
}
