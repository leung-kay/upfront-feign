package com.ruifucredit.cloud.upfront.repository.http;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.ruifucredit.cloud.commodity.support.controller.IGoodsController;
import com.ruifucredit.cloud.commodity.support.dto.Goods;
import com.ruifucredit.cloud.kit.dto.Outcoming;
import com.ruifucredit.cloud.upfront.repository.http.IGoodsClient.GoodsClientFallback;

@FeignClient(name = "commodity-feign", fallback = GoodsClientFallback.class)
public interface IGoodsClient extends IGoodsController {

	@Component
	class GoodsClientFallback implements IGoodsClient {
		
		private Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Override
		public Outcoming<Goods> queryGoods(Long id) {
			logger.info("GoodsClientFallback.queryGoods.id: {}", id);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<List<Goods>> queryGoods(String name) {
			logger.info("GoodsClientFallback.queryGoods.name: {}", name);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

		@Override
		public Outcoming<Goods> createGoods(Goods param) {
			logger.info("GoodsClientFallback.createGoods.param: {}", param);
			return new Outcoming<>(Outcoming.FAIL_CODE, null);
		}

	}

}
