package com.retail.loyalty.controller.v1;

import com.retail.loyalty.entity.Campaign;
import com.retail.loyalty.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/campaigns")
@AllArgsConstructor
public class CampaignController extends BaseController {

    private final CampaignService campaignService;

    @GetMapping
    public Flux<Campaign> getActiveCampaigns() {
        return campaignService.getActiveCampaigns();
    }

    @PostMapping("/add")
    public Mono<Campaign> addCampaign(@RequestBody Campaign campaign) {
        return campaignService.addCampaign(campaign);
    }

    @PutMapping("/update/{campaignId}")
    public Mono<Campaign> updateCampaign(@PathVariable Long campaignId, @RequestBody Campaign campaign) {
        return campaignService.updateCampaign(campaignId, campaign);
    }

    @DeleteMapping("/delete/{campaignId}")
    public Mono<Void> deleteCampaign(@PathVariable Long campaignId) {
        return campaignService.deleteCampaign(campaignId);
    }

    @PostMapping("/activate/{campaignId}")
    public Mono<Campaign> activateCampaign(@PathVariable Long campaignId) {
        return campaignService.activateCampaign(campaignId);
    }

    @PostMapping("/deactivate/{campaignId}")
    public Mono<Campaign> deactivateCampaign(@PathVariable Long campaignId) {
        return campaignService.deactivateCampaign(campaignId);
    }
}
