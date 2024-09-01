package com.retail.loyalty.service;

import com.retail.loyalty.entity.Campaign;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CampaignService {
    Flux<Campaign> getActiveCampaigns();

    Mono<Campaign> addCampaign(Campaign campaign);

    Mono<Campaign> updateCampaign(Long campaignId, Campaign campaign);

    Mono<Void> deleteCampaign(Long campaignId);

    Mono<Campaign> activateCampaign(Long campaignId);

    Mono<Campaign> deactivateCampaign(Long campaignId);
}
