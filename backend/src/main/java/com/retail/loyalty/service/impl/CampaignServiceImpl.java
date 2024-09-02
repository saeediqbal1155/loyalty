package com.retail.loyalty.service.impl;

import com.retail.loyalty.entity.Campaign;
import com.retail.loyalty.repository.CampaignRepository;
import com.retail.loyalty.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final R2dbcEntityTemplate template;

    @Override
    public Flux<Campaign> getActiveCampaigns() {
        return campaignRepository.findByActiveTrue();
    }

    @Override
    public Mono<Campaign> addCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    @Override
    public Mono<Campaign> updateCampaign(Long campaignId, Campaign campaign) {
        return campaignRepository.findById(campaignId)
                .flatMap(existingCampaign -> {
                    existingCampaign.setName(campaign.getName());
                    existingCampaign.setStartDate(campaign.getStartDate());
                    existingCampaign.setEndDate(campaign.getEndDate());
                    return campaignRepository.save(existingCampaign);
                });
    }

    @Override
    public Mono<Void> deleteCampaign(Long campaignId) {
        return campaignRepository.deleteById(campaignId);
    }

    @Override
    public Mono<Campaign> activateCampaign(Long campaignId) {
        return campaignRepository.findById(campaignId)
                .flatMap(campaign -> {
                    campaign.setActive(true);
                    return campaignRepository.save(campaign);
                });
    }

    @Override
    public Mono<Campaign> deactivateCampaign(Long campaignId) {
        return campaignRepository.findById(campaignId)
                .flatMap(campaign -> {
                    campaign.setActive(false);
                    return campaignRepository.save(campaign);
                });
    }
}